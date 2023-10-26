package graphical.common.graphics;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayType;
import delayCalculator.delayOptions.DelayOptions;
import ThreadAbstraction.AbstractUpdater;

//
public final class WindowUpdater extends AbstractUpdater {
    private static final int FRAME_RATE = 60;
    private final @NotNull AbstractWindow window;

    //
    public WindowUpdater(@NotNull AbstractWindow window) {
        super(new DelayOptions(DelayType.FPS, FRAME_RATE));
        this.window = window;
        this.start();
    }

    //
    @Override
    public void update() {
        window.repaint();
    }
}