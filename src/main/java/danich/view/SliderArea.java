package danich.view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderArea extends JPanel {

    JLabel label;
    JSlider slider;

    public SliderArea(ChangeListener listener, int start, String label) {
        this.label = new JLabel(label);
        this.label.setSize(250, 50);
        this.slider = new JSlider(1, 10, start);
        this.slider.setPaintTrack(true);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);
        this.slider.setMajorTickSpacing(1);
        this.slider.setPreferredSize(new Dimension(250, 50));
        this.slider.addChangeListener(listener);
        this.setLayout(new GridLayout(2, 1));
        this.add(this.label);
        this.add(slider);
    }
}
