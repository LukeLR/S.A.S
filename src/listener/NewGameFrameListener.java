package listener;

import gui.NewGameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameFrameListener implements ActionListener {
	private NewGameFrame ngf;
	
	public NewGameFrameListener(NewGameFrame ngf){
		this.ngf = ngf;
	}
	
	public void actionPerformed(ActionEvent ae){
		if (ae.getActionCommand().equals("New Game")){
			ngf.newGame();
		} else if (ae.getActionCommand().equals("Quit")){
			ngf.quit();
		} else if (ae.getActionCommand().equals("Back to launcher")){
			ngf.editSettings();
		}
	}
}