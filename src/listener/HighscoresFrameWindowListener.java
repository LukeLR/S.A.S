package listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.HighscoresFrame;

public class HighscoresFrameWindowListener extends WindowAdapter {
	private HighscoresFrame hf;
	
	public HighscoresFrameWindowListener (HighscoresFrame hf){
		this.hf = hf;
	}
	
	public void windowClosing (WindowEvent we){
		hf.close();
	}
}
