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

import java.io.Serializable;

import date.Date;
import logging.Logger;

public class Highscores implements Serializable {
	private static final long serialVersionUID = -6854131310304762092L;
	private int[] scores;
	private String[] names;
	private Date[] dates, duration;
	private Constants[] constants;
	private long ratio[];
	private Apfeltasche[] pockets;
	
	private boolean verbose = false;
	
	public Highscores(int length){
		scores = new int[length];
		names = new String[length];
		dates = new Date[length];
		constants = new Constants[length];
		duration = new Date[length];
		ratio = new long[length];
		pockets = new Apfeltasche[length];
		
		for (int i = 0; i < length; i++){
			scores[i] = 0;
			names[i] = "";
			dates[i] = new Date("000000000000000000");
			constants[i] = new Constants();
			duration[i] = new Date("000000000000000000");
			ratio[i] = 0;
			pockets[i] = new Apfeltasche();
		}
	}
	
	public Highscores(){
		this(30);
	}
	
	public void setHighscore(int index, int score, String name){
		setHighscore(index, score, name, new Date(), new Constants());
	}
	
	public void setHighscore(int index, int score, String name, Date date){
		setHighscore(index, score, name, date, new Constants());
	}
	
	public void setHighscore(int index, int score, String name, Constants con){
		setHighscore(index, score, name, new Date(), con);
	}
	
	public void setHighscore(int index, int score, String name, Date date, Constants con){
		scores[index] = score;
		names[index] = name;
		dates[index] = date;
		constants[index] = con;
	}
	
	public int getHighscore(int index){
		if (verbose){
			Logger.logMessage('i', this, "returned Score at index: " + String.valueOf(index) + ", which is " + String.valueOf(scores[index]));
		}
		return scores[index];
	}
	
	public String getHighscoreName(int index){
		return names[index];
	}
	
	public Date getHighscoreDate(int index){
		return dates[index];
	}
	
	public Constants getConstants(int index){
		return constants[index];
	}
	
	public Date getDuration(int index){
		return duration[index];
	}
	
	public long getRatio(int index){
		return ratio[index];
	}
	
	public void calcRatio (int index){
		calcRatio (index, scores[index], duration[index].getLong());
	}
	
	public void calcRatio(int index, int score){
		calcRatio(index, score, duration[index].getLong());
	}
	
	public void calcRatio(int index, int score, long duration){
		if (duration != 0){
			ratio[index] = score*10000/duration;
		} else {
			ratio[index] = 0;
		}
	}
	
	public void setRatio(int index, long rat){
		ratio[index] = rat;
	}
	
	public void setDuration(int index, Date dur){
		duration[index] = dur;
	}
	
	public void setApfeltasche(int index, Apfeltasche pocket){
		pockets[index] = pocket;
	}
	
	public Apfeltasche getApfeltasche (int index){
		return pockets[index];
	}
	
	public int addHighscore (int score, String name, Constants con){
		int index = goOneUp(29, score);
		Logger.logMessage('I', this, "Index found: " + String.valueOf(index));
		if (!(scores[index] > score)){
			for (int i = 29; i > index; i--){
				scores[i] = scores[i-1];
				names[i] = names[i-1];
				dates[i] = dates[i-1];
				constants[i] = constants[i-1];
				duration[i] = duration[i-1];
				ratio[i] = ratio[i-1];
				pockets[i] = pockets[i-1];
			}
			
			scores[index] = score;
			names[index] = name;
			dates[index] = new Date();
			constants[index] = con;
			return index;
		} else if (scores[index] > score){
			return -1;
		} else {
			Logger.logMessage('E', this, "Unhandled Case in Highscore Comparison");
			return -1;
		}
	}
	
	public int addHighscore (int score, String name){
		return addHighscore(score, name, new Constants());
	}
	
	public boolean isHighscore(int score){
		int index = goOneUp(29, score);
		if (!(scores[index] > score)){
			return true;
		} else if (scores[index] > score){
			return false;
		} else {
			Logger.logMessage('E', this, "Unhandled Case in Highscore Comparison");
			return false;
		}
	}
	
	public int goOneUp(int index, int score){
		if ((index > 0) && (scores[index - 1] < score)){
			if (verbose){
				Logger.logMessage('I', this, "Going one up. Index is now " + String.valueOf(index) + ", because " + String.valueOf(score) + " > " + String.valueOf(scores[index - 1]));
			}
			index = index - 1;
			return goOneUp(index, score);
		} else {
			return index;
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 30; i++){
			result.append(i);
			result.append(" ");
			result.append(names[i]);
			result.append(" (");
			result.append(dates[i].toReadableString(Date.GermanShort));
			result.append("): ");
			result.append(scores[i]);
			result.append(System.lineSeparator());
		}
		return result.toString();
	}
	
	public int getLength(){
		return scores.length;
	}
	
	public void setLength(int newLength){
		int scoresTemp[] = scores;
		String namesTemp[] = names;
		Date datesTemp[] = dates;
		Constants constantsTemp[] = constants;
		Date[] durationTemp = duration;
		long[] ratioTemp = ratio;
		Apfeltasche[] pocketsTemp = pockets;
		
		scores = new int[newLength];
		names = new String[newLength];
		dates = new Date[newLength];
		constants = new Constants[newLength];
		duration = new Date[newLength];
		ratio = new long[newLength];
		pockets = new Apfeltasche[newLength];
		
		for (int i = 0; i < newLength; i++){
			scores[i] = 0;
			names[i] = "";
			dates[i] = new Date("000000000000000000");
			constants[i] = new Constants();
			duration[i] = new Date("000000000000000000");
			ratio[i] = 0;
			pockets[i] = new Apfeltasche();
		}
		
		for (int i = 0; i < scoresTemp.length; i++){
			scores[i] = scoresTemp[i];
			names[i] = namesTemp[i];
			dates[i] = datesTemp[i];
			constants[i] = constantsTemp[i];
			duration[i] = durationTemp[i];
			ratio[i] = ratioTemp[i];
			pockets[i] = pocketsTemp[i];
		}
	}
	
	public void deleteHighscore (int index){
		Logger.logMessage('I', this, "Deleting Score at " + String.valueOf(index));
		for (int i = index; i < scores.length - 1; i++){
			scores[i] = scores[i + 1];
			names[i] = names[i + 1];
			dates[i] = dates[i + 1];
			constants[i] = constants[i + 1];
			duration[i] = duration[i + 1];
			ratio[i] = ratio[i + 1];
			pockets[i] = pockets[i+1];
		}
		
		scores[scores.length - 1] = 0;
		names[names.length - 1] = "";
		dates[dates.length - 1] = new Date("000000000000000000");
		constants[constants.length - 1] = new Constants();
		duration[duration.length - 1] = new Date("000000000000000000");
		ratio[ratio.length - 1] = 0;
	}
}