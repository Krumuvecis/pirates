package threadTest;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.SimplePrinting.printLine;
import ThreadAbstraction.AbstractUpdater;

//
public class ThreadTest {
    static Data data;

    //
    public static void main(String[] args) {
        data = new Data();
        (new MonitorThread(data, 500)).start();
        (new UpdaterThread(data, 23)).start();
    }

    //
    private static class Data {
        private final static int @NotNull [] X_RANGE = new int[] {0, 100};
        private final static int INCREMENT = 1;
        private int x;

        //
        Data() {
            x = X_RANGE[0];
        }

        //
        void increaseX() {
            x += INCREMENT;
            if (x >= X_RANGE[1]) {
                x = X_RANGE[0];
            }
        }

        //
        int getX() {
            return x;
        }
    }

    //
    private static final class MonitorThread extends AbstractUpdater {
        private final @NotNull Data data;

        //
        MonitorThread(@NotNull Data data, long delay){
            super(delay);
            this.data = data;
        }

        //
        @Override
        public void update() {
            printLine("x : " + data.getX());
        }
    }

    //
    private static final class UpdaterThread extends AbstractUpdater {
        private final @NotNull Data data;

        //
        UpdaterThread(@NotNull Data data, long delay){
            super(delay);
            this.data = data;
        }

        //
        @Override
        public void update() {
            data.increaseX();
        }
    }
}