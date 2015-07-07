package listener;

import framework.Constants;
import framework.ConstantsManager;
import gui.SnakeFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import logging.LogManager;
import logging.Logger;

public class SnakeViewListener extends WindowAdapter {
	private SnakeFrame c;
	private Constants con;
	public SnakeViewListener(SnakeFrame c, Constants con){
		super();
		this.c = c;
		this.con = con;
	}
	
	public void windowClosing (WindowEvent we){
		Logger.logMessage('I', this, "Trying to close Window");
		if (JOptionPane.showOptionDialog(c, "Really Quit?", "Quit?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1) == 0){
			con.set(Constants.INGAME, false);
			Logger.logMessage('I', this, "Exited.");
			Logger.logMessage('I', this, "Desired LogFileName: " + con.getString(Constants.LOGFILENAME));
//			System.out.println("Desired LogFileName: " + con.getString(Constants.LOGFILENAME));
			con.set(Constants.LOGFILENAME, LogManager.saveLogFile(con.getString(Constants.LOGFILENAME)));
			
//			System.out.println("Saving Constants to constants.dat");
			ConstantsManager.saveConstants(con, "constants.dat");
			System.exit(1);
		} else {
			Logger.logMessage('I', this, "Closing cancelled.");
		}
	}
}
