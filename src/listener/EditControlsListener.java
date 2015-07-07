package listener;

import gui.ControlsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditControlsListener implements ActionListener {
	private ControlsFrame cf;
	
	public EditControlsListener (ControlsFrame cf){
		this.cf = cf;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(cf.getResetButton())){
			cf.resetControls();
		} else if (e.getSource().equals(cf.getEditUpButton())){
			cf.openSetWindow(0);
		} else if (e.getSource().equals(cf.getEditDownButton())){
			cf.openSetWindow(1);
		} else if (e.getSource().equals(cf.getEditLeftButton())){
			cf.openSetWindow(2);
		} else if (e.getSource().equals(cf.getEditRightButton())){
			cf.openSetWindow(3);
		} else {
			
		}
	}
}
