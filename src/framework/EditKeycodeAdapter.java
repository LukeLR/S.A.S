package framework;

import java.awt.event.KeyEvent;

import listener.KeyboardAdapter;
import gui.EditControlFrame;

public class EditKeycodeAdapter extends KeyboardAdapter {
	private EditControlFrame ecf;
	
	public EditKeycodeAdapter (EditControlFrame ecf){
		super(new Constants());
		this.ecf = ecf;
	}
	
	public void keyPressed(KeyEvent ke){
		super.keyPressed(ke);
		ecf.keyInput(ke.getKeyCode());
	}
}
