package listener;

import gui.ControlsFrame;
import gui.EditControlFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ControlsFrameWindowListener extends WindowAdapter {
	private ControlsFrame cf;
	
	public ControlsFrameWindowListener(ControlsFrame cf){
		this.cf = cf;
	}
	
	public void windowClosing(WindowEvent we){
		cf.sendClosing();
		cf.dispose();
	}
}
