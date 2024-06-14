package danich.view.sliderwork;

import danich.factory.service.Observable;
import danich.view.actions.AccessoriesSupAction;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AccessoriesSlider extends Observable implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        notify(new AccessoriesSupAction(slider.getValue()));
    }
}
