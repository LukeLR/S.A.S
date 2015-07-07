package listener;

import gui.HighscoresInfoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighscoresInfoFrameListener implements ActionListener {
	private HighscoresInfoFrame hif;
	
	public HighscoresInfoFrameListener (HighscoresInfoFrame hif){
		this.hif = hif;
	}
	
	public void actionPerformed (ActionEvent ae){
		if (ae.getActionCommand().equals("Delete Highscore")){
			hif.deleteHighscore();
		} else if (ae.getActionCommand().equals("Show Apfeltasche")){
			hif.showApfeltaschenInfo();
		}
	}
}
