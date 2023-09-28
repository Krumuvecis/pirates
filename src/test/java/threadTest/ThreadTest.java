package threadTest;

import org.jetbrains.annotations.NotNull;

//
public class ThreadTest {
    static Data data;

    //
    public static void main(String[] args) {
        data = new Data();
    }

    //
    static class Data {
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
    private static class MonitorThread extends Thread implements Runnable {
        //
    }

    //
    private static class UpdaterThread extends Thread implements Runnable {
        //
    }
}