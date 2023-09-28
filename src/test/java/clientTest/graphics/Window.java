package clientTest.graphics;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(
            DefaultLayout.getTotalWidth(),
            DefaultLayout.getTotalHeight());

    public Window() {
        this(DEFAULT_WINDOW_SIZE, DefaultLayout.DEFAULT_WINDOW_LOCATION);
    }

    public Window(Dimension size, Point location) {
        super();
        setSize(size);
        setLocation(location);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("my title");
        add(new OnlyPanel());
        setVisible(true);
    }
}