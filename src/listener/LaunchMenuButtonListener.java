package listener;

import gui.LaunchFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchMenuButtonListener implements ActionListener {
	private LaunchFrame lm;
	
	public LaunchMenuButtonListener (LaunchFrame lm){
		this.lm = lm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Launch")){
			lm.launch();
		} else if (arg0.getActionCommand().equals ("Delete Log")){
			lm.deleteLog();
		} else if (arg0.getActionCommand().equals ("Delete Presets")){
			lm.resetConstants();
		} else if (arg0.getActionCommand().equals ("Edit Controls...")){
			lm.editControls();
		} else if (arg0.getActionCommand().equals ("Show Highscores")){
			lm.showHighscores();
		} else if (arg0.getActionCommand().equals ("Show Statistics")){
			lm.showStatistics();
		}
	}	
}