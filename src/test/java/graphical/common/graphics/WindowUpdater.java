package graphical.common.graphics;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayType;
import delayCalculator.delayOptions.DelayOptions;
import ThreadAbstraction.AbstractUpdater;

//
public final class WindowUpdater extends AbstractUpdater {
    private static final int DEFAULT_FRAME_RATE = 60;
    private final @NotNull AbstractWindow window;

    //with custom frame rate
    public WindowUpdater(@NotNull AbstractWindow window, int frameRate) {
        super(new DelayOptions(DelayType.FPS, frameRate));
        this.window = window;
        this.start();
    }

    //with default frame rate
    public WindowUpdater(@NotNull AbstractWindow window) {
        this(window, DEFAULT_FRAME_RATE);
    }

    //
    @Override
    public void update() {
        window.repaint();
    }
}