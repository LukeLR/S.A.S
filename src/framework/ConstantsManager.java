package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logging.Logger;

public class ConstantsManager {
	private String filename = "constants.dat";

	public ConstantsManager (){

	}

	public ConstantsManager (String filename){
		this.filename = filename;
	}

	public static Constants loadConstants(String filename){
		File constantsFile = new File (filename);
		if (constantsFile.exists()){
			Logger.logMessage('I', new ConstantsManager(), "Loading Constants from " + filename);
			try {
				FileInputStream saveFile = new FileInputStream(constantsFile);
				ObjectInputStream restore = new ObjectInputStream(saveFile);
				Object obj = restore.readObject();
				restore.close();
				return (Constants)obj;
//				return new Constants();
			} catch (IOException | ClassNotFoundException e) {
				Logger.logException(new ConstantsManager(), "Error loading Constants!", e);
				return new Constants();
			}
		} else {
			Logger.logMessage('I', new ConstantsManager(), "Creating new Constants");
			return new Constants();
		}
	}

	public Constants loadConstants(){
		if (filename.equals("")){
			filename = "constants.dat";
		}
		Logger.logMessage('I', new ConstantsManager(), "Loading Constants from default filename " + filename);
		return loadConstants(filename); //Invoking loadConstants() with saved filename
	}

	public static void saveConstants (Constants c, String filename){
		Logger.logMessage('I', new ConstantsManager(), "Saving Constants to " + filename);
		try {
			FileOutputStream saveFile = new FileOutputStream(new File(filename));
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(c);
			save.close();
		} catch (IOException e) {
			Logger.logException(new ConstantsManager(), "Error saving Constants!", e);
			e.printStackTrace();
		}
	}

	public void saveConstants (Constants c){
		Logger.logMessage('I', new ConstantsManager(), "Saving Constants to default filename " + filename);
		saveConstants (c, filename); //Invoking saveConstants with saved filename
	}

	public static void deleteConstants(String filename) {
		Logger.logMessage('I', new ConstantsManager(), "Deleting File saved at " + filename);
		File f = new File(filename);

		if (!f.exists()){
			Logger.logMessage('E', new ConstantsManager(), "Could not delete File at " + filename + ": File does not exist");
		} else {
			if (!f.canWrite()){
				Logger.logMessage('E', new ConstantsManager(), "Could not delete File at " + filename + ": No write access");
			} else {
				if (f.isDirectory()){
					String[] files = f.list();
					if (files.length > 0) {
						 Logger.logMessage('E', new ConstantsManager(), "Could not delete File at " + filename + ": Is a direcotry (And not empty)");
					} else {
						boolean success = f.delete();
						if (!success){
							Logger.logMessage('E', new ConstantsManager(), "Could not delete File at " + filename + ": An unknown error occured!");
						}
					}
				}
			}
		}
	}

	public void deleteConstants (){
		if (filename.equals("")){
			filename = "constants.dat";
		}
		Logger.logMessage('I', new ConstantsManager(), "Deleting Constants with default filename " + filename);
		deleteConstants(filename); //Invoking deleteConstants() with saved filename
	}
}
