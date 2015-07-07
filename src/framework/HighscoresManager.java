/**
 * This file is part of Super Awesome Snake.
 *
 * Super Awesome Snake is free software: you can redistribute it and/or
 * modify it under the terms of the cc-by-nc-sa (Creative Commons
 * Attribution-NonCommercial-ShareAlike) as released by the Creative
 * Commons organisation, version 3.0.
 *
 * Super Awesome Snake is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY.
 *
 * You should have received a copy of the cc-by-nc-sa-license along
 * with this LukeUtils. If not, see
 * <https://creativecommons.org/licenses/by-nc-sa/3.0/legalcode>.
 *
 * Copyright Lukas Rose 2013 - 2015
 */

package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logging.Logger;

public class HighscoresManager {
	private String filename = "Highscores.dat";

	public HighscoresManager (){

	}

	public HighscoresManager (String filename){
		this.filename = filename;
	}

	public static Highscores loadHighscores(String filename){
		File HighscoresFile = new File (filename);
		if (HighscoresFile.exists()){
			Logger.logMessage('I', new HighscoresManager(), "Loading Highscores from " + filename);
			try {
				FileInputStream saveFile = new FileInputStream(HighscoresFile);
				ObjectInputStream restore = new ObjectInputStream(saveFile);
				Object obj = restore.readObject();
				restore.close();
				return (Highscores)obj;
//				return new Highscores();
			} catch (IOException | ClassNotFoundException e) {
				Logger.logException(new HighscoresManager(), "Error loading Highscores!", e);
				return new Highscores();
			}
		} else {
			Logger.logMessage('I', new HighscoresManager(), "Creating new Highscores");
			return new Highscores();
		}
	}

	public Highscores loadHighscores(){
		if (filename.equals("")){
			filename = "Highscores.dat";
		}
		Logger.logMessage('I', new HighscoresManager(), "Loading Highscores from default filename " + filename);
		return loadHighscores(filename); //Invoking loadHighscores() with saved filename
	}

	public static void saveHighscores (Highscores c, String filename){
		Logger.logMessage('I', new HighscoresManager(), "Saving Highscores to " + filename);
		try {
			FileOutputStream saveFile = new FileOutputStream(new File(filename));
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(c);
			save.close();
		} catch (IOException e) {
			Logger.logException(new HighscoresManager(), "Error saving Highscores!", e);
			e.printStackTrace();
		}
	}

	public void saveHighscores (Highscores c){
		Logger.logMessage('I', new HighscoresManager(), "Saving Highscores to default filename " + filename);
		saveHighscores (c, filename); //Invoking saveHighscores with saved filename
	}

	public static void deleteHighscores(String filename) {
		Logger.logMessage('I', new HighscoresManager(), "Deleting File saved at " + filename);
		File f = new File(filename);

		if (!f.exists()){
			Logger.logMessage('E', new HighscoresManager(), "Could not delete File at " + filename + ": File does not exist");
		} else {
			if (!f.canWrite()){
				Logger.logMessage('E', new HighscoresManager(), "Could not delete File at " + filename + ": No write access");
			} else {
				if (f.isDirectory()){
					String[] files = f.list();
					if (files.length > 0) {
						 Logger.logMessage('E', new HighscoresManager(), "Could not delete File at " + filename + ": Is a direcotry (And not empty)");
					} else {
						boolean success = f.delete();
						if (!success){
							Logger.logMessage('E', new HighscoresManager(), "Could not delete File at " + filename + ": An unknown error occured!");
						}
					}
				}
			}
		}
	}

	public void deleteHighscores (){
		if (filename.equals("")){
			filename = "Highscores.dat";
		}
		Logger.logMessage('I', new HighscoresManager(), "Deleting Highscores with default filename " + filename);
		deleteHighscores(filename); //Invoking deleteHighscores() with saved filename
	}
}