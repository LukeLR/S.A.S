package framework;

import java.awt.event.KeyEvent;

import listener.KeyboardAdapter;
import logging.Logger;

public class GameKeyboardAdapter extends KeyboardAdapter {
	private SnakeGame sg;
	
	public GameKeyboardAdapter(SnakeGame sg, Constants con){
		super(con);
		this.sg = sg;
		con.set(Constants.HASINPUT, false);
	}
	
	public void keyPressed(KeyEvent ke){
		Logger.logMessage('I', this, "Key pressed!");
		if(!(con.getBool(Constants.HASINPUT))){
			Logger.logMessage('I', this, "First input!");
			con.set(Constants.HASINPUT, true);
			sg.getView().getCounter().startTimer();
		}
		keyCode = ke.getKeyCode();
	}
}
