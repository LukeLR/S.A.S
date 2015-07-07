package listener;

import gui.HighscoresFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighscoresFrameListener implements ActionListener {
	private HighscoresFrame hf;
	private int index;
	
	public HighscoresFrameListener(HighscoresFrame hf, int index){
		this.hf = hf;
		this.index = index;
	}
	
	public void actionPerformed (ActionEvent ae){
		hf.showInfoWindow(index);
	}
}
