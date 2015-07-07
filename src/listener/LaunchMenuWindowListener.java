package listener;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import logging.LogManager;
import logging.Logger;
import framework.Constants;
import framework.ConstantsManager;

public class LaunchMenuWindowListener extends WindowAdapter {
	private Component c;
	private Constants con;
	public LaunchMenuWindowListener(Component c, Constants con){
		super();
		this.c = c;
		this.con = con;
	}
	
	public void windowClosing (WindowEvent we){
		Logger.logMessage('I', this, "Trying to close Window");
		if (JOptionPane.showOptionDialog(c, "Really Quit?", "Quit?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1) == 0){
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