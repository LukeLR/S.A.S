package framework;

import java.io.Serializable;
import java.util.Calendar;

import date.Date;
import logging.Logger;

public class Apple implements Serializable {
	public int index, baseScore, timeBonus, lengthBonus, overallBonus, x, y;
	public long placeTime, pickupTime, stayTime, remainingTime, placeTimeFromStart, pickupTimeFromStart, calcTime;
	public boolean visible = true;
	private boolean verbose = false;
	
	public Constants con;
	public Schlangenkorper head;
	
	
	public Apple (Constants con, Schlangenkorper head){
		this.con = con;
		this.head = head;
		visible = true;
		Logger.logMessage('I', this, "New Apple with random position, max: " + con.getString(Constants.XTILENUMBER) + con.getString(Constants.YTILENUMBER));
		x = (int)(Math.random()*con.getDouble(Constants.XTILENUMBER));
		y = (int)(Math.random()*con.getDouble(Constants.YTILENUMBER));
		while (head.snakeOnField(x, y)){
			x = (int)(Math.random()*con.getDouble(Constants.XTILENUMBER));
			y = (int)(Math.random()*con.getDouble(Constants.YTILENUMBER));
		}
	}
	
	public Apple (Constants con, Schlangenkorper head, int x, int y){
		this.con = con;
		this.head = head;
		this.x = x;
		this.y = y;
		visible = true;
		Logger.logMessage('I', this, "New Apple with position: " + String.valueOf(x) + ", " + String.valueOf(y));
	}
	
	public void remove(){
		Logger.logMessage('I', this, "Removing Apple at " + String.valueOf(x) + ", " + String.valueOf(y));
		head = null;
		visible = false;
	}
	
	public void setIndex(int index){
		Logger.logMessage('I', this, "Setting index to " + String.valueOf(index));
		this.index = index;
	}
	
	public int getIndex(){
		Logger.logMessage('I', this, "Returning Index " + String.valueOf(index));
		return index;
	}
	
	public void setBaseScore(int baseScore){
		Logger.logMessage('I', this, "Setting baseScore to " + String.valueOf(baseScore));
		this.baseScore = baseScore;
	}
	
	public int getBaseScore(){
		Logger.logMessage('I', this, "Returning BaseScore " + String.valueOf(baseScore));
		return baseScore;
	}
	
	public void setTimeBonus(int timeDefizit){
		Logger.logMessage('I', this, "Setting timeDefizit to " + String.valueOf(timeDefizit));
		this.timeBonus = timeDefizit;
	}
	
	public int getTimeBonus(){
		Logger.logMessage('I', this, "Returning timeBonus " + String.valueOf(timeBonus));
		return timeBonus;
	}
	
	public void setLengthBonus(int lengthBonus){
		Logger.logMessage('I', this, "Setting lengthBonus to " + String.valueOf(lengthBonus));
		this.lengthBonus = lengthBonus;
	}
	
	public int getLengthBonus(){
		Logger.logMessage('I', this, "Returning lengthBonus " + String.valueOf(lengthBonus));
		return lengthBonus;
	}
	
	public void setOverallBonus(int overallBonus){
		Logger.logMessage('I', this, "Setting overallBonus to " + String.valueOf(overallBonus));
		this.overallBonus = overallBonus;
	}
	
	public int getOverallBonus(){
		Logger.logMessage('I', this, "Returning overallBonus " + String.valueOf(overallBonus));
		return overallBonus;
	}
	
	public void setX(int x){
		Logger.logMessage('I', this, "Setting x to " + String.valueOf(x));
		this.x = x;
	}
	
	public void setY(int y){
		Logger.logMessage('I', this, "Setting y to " + String.valueOf(y));
		this.y = y;
	}
	
	public void setXY(int x, int y){
		Logger.logMessage('I', this, "Setting xy to " + String.valueOf(x) + ", " + String.valueOf(y));
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		if (verbose){
			Logger.logMessage('I', this, "Returning x " + String.valueOf(x));
		}
		return x;
	}
	
	public int getY(){
		if (verbose){
			Logger.logMessage('I', this, "Returning y " + String.valueOf(y));
		}
		return y;
	}
	
	public void setPlaceTime(long placeTime){
		Logger.logMessage('I', this, "Setting placeTime to " + String.valueOf(placeTime));
		this.placeTime = placeTime;
		calcPlaceTimeFromStart();
	}
	
	public void setPlaceTime(){
		this.placeTime = Calendar.getInstance().getTimeInMillis();
		Logger.logMessage('I', this, "Setting placeTime to current time (" + String.valueOf(placeTime) + ")");
		calcPlaceTimeFromStart();
	}
	
	public long getPlaceTime(){
		Logger.logMessage('I', this, "Returning placeTime " + String.valueOf(placeTime));
		return placeTime;
	}
	
	public long getPlaceTimeFromStart(){
		Logger.logMessage('I', this, "Returning placeTime from Start " + String.valueOf(placeTimeFromStart));
		return placeTimeFromStart;
	}
	
	public void setPickupTime(long pickupTime){
		Logger.logMessage('I', this, "Setting pickupTime to " + String.valueOf(pickupTime));
		this.pickupTime = pickupTime;
		calcPickupTimeFromStart();
	}
	
	public void setPickupTime(){
		this.pickupTime = Calendar.getInstance().getTimeInMillis();
		Logger.logMessage('I', this, "Setting pickupTime to current time (" + String.valueOf(pickupTime) + ")");
		calcPickupTimeFromStart();
	}
	
	public long getPickupTime(){
		Logger.logMessage('I', this, "Returning pickupTime " + String.valueOf(pickupTime));
		return pickupTime;
	}
	
	public long getPickupTimeFromStart(){
		Logger.logMessage('I', this, "Returning pickupTime from Start " + String.valueOf(pickupTimeFromStart));
		return pickupTimeFromStart;
	}
	
	public void setStayTime(long stayTime){
		Logger.logMessage('I', this, "Setting stayTime to " + String.valueOf(stayTime));
		this.stayTime = stayTime;
	}
	
	public long getStayTime(){
		Logger.logMessage('I', this, "Returning stayTime " + String.valueOf(stayTime));
		return stayTime;
	}
	
	public void setRemainingTime(long remainingTime){
		Logger.logMessage('I', this, "Setting remainingTime to " + String.valueOf(remainingTime));
		this.remainingTime = remainingTime;
	}
	
	public long getRemainingTime(){
		Logger.logMessage('I', this, "Returning remainingTime " + String.valueOf(remainingTime));
		return remainingTime;
	}
	
	public void calcBaseScore(){
		baseScore = con.getInt(Constants.DIFFICULTY);
	}
	
	public void calcRemainingTime(){
		if (pickupTime == 0){
			Logger.logMessage('I', this, "pickupTime = 0, assuming calcTime");
			pickupTime = calcTime;
			calcPickupTimeFromStart();
		}
		if (stayTime == 0){
			remainingTime = 0;
		} else {
			remainingTime = (int)stayTime - (int)pickupTimeFromStart + (int)placeTimeFromStart;
		}
	}
	
	private void calcPlaceTimeFromStart(){
		placeTimeFromStart = placeTime - con.getLong(Constants.STARTTIME);
	}
	
	private void calcPickupTimeFromStart(){
		pickupTimeFromStart = pickupTime - con.getLong(Constants.STARTTIME);
	}
	
	public void calcTimeBonus(){
		if (remainingTime == 0){
			calcRemainingTime();
		}
		if (stayTime != 0){
			timeBonus = (int) (remainingTime/stayTime*50);
		} else {
			timeBonus = 0;
		}
	}
	
	public void calcLengthBonus(){
		if (head != null){
			lengthBonus = head.length(0)*2;
		} else {
			lengthBonus = 0;
		}
	}
	
	public void calcOverallBonus(){
		overallBonus = baseScore;
	}
	
	public int calc(){
		calcTime = Calendar.getInstance().getTimeInMillis();
		calcBaseScore();
		calcRemainingTime();
		calcTimeBonus();
		calcLengthBonus();
		calcOverallBonus();
		return overallBonus;
	}
	
	public String getPlayTimeString(){
		return new Date(con.getLong(Constants.STATS_PLAYTIME)).toReadableString(Date.WithoutDate);
	}
	
	public String getGamesPlayedString(){
		return con.getString(Constants.STATS_GAMESPLAYED);
	}
	
	public String getTimesLaunchedString(){
		return con.getString(Constants.STATS_TIMESLAUNCHED);
	}
	
	public String getOverallApplesString(){
		return con.getString(Constants.STATS_OVERALLAPPLES);
	}
	
	public String getOverallSuperApplesString(){
		return con.getString(Constants.STATS_OVERALLSUPERAPPLES);
	}
	
	public String getSuperApplesLostString(){
		return con.getString(Constants.STATS_SUPERAPPLESLOST);
	}
	
	public String getMaxApplesString(){
		return con.getString(Constants.STATS_MAXAPPLES);
	}
	
	public String getMaxSuperApplesString(){
		return con.getString(Constants.STATS_MAXSUPERAPPLES);
	}
	
	public String getAvgApplesString(){
		return con.getString(Constants.STATS_AVGAPPLES);
	}
	
	public String getAvgSuperApplesString(){
		return con.getString(Constants.STATS_AVGSUPERAPPLES);
	}
	
	public String getAvgSuperAppleScoreString(){
		return con.getString(Constants.STATS_AVGSUPERAPPLESCORE);
	}
}