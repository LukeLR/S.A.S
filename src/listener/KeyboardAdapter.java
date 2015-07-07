package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import framework.Constants;
import logging.Logger;

public class KeyboardAdapter extends KeyAdapter {
	public int keyCode;
	public Constants con;
	private boolean verbose = false;
	
	public KeyboardAdapter(Constants con){
		this.con = con;
	}
	
	public void keyPressed (KeyEvent ke){
		if (verbose){
			Logger.logMessage('I', this, "Key pressed!");
		}
		con.set(Constants.HASINPUT, true);
		keyCode = ke.getKeyCode();
	}
	public int getKeyCode (){
		if (verbose){
			Logger.logMessage('I', this, "Returned KeyCode");
		}
		return keyCode;
	}
	public void setKeyCode(int keyCode){
		this.keyCode = keyCode;
	}
	
	public boolean hasInput(){
		return con.getBool(Constants.HASINPUT);
	}
	
	public void setInput (boolean state){
		con.set(Constants.HASINPUT, state);
	}
}
