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

import java.awt.Color;
import java.awt.Graphics;

import logging.Logger;

public class SuperAppleManager extends Thread {
	private SuperApple a;
	private long placeInterval = (long)(Math.random()*20000)+10000;
	private long removeInterval = (long)(Math.random()*10000)+5000;
	private boolean active = false;
	private Constants con;
	private int index = 0;
	private Apfeltasche pocket;
	private Schlangenkorper head;
	
	public SuperAppleManager(Constants con, Apfeltasche pocket, Schlangenkorper head){
		this.con = con;
		this.pocket = pocket;
		this.head = head;
	}
	
	public void run(){
		active = true;
		while (active){
			try {
				Thread.sleep(placeInterval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (con.getBool(Constants.HASINPUT)){
				setApple();
				try {
					Thread.sleep(removeInterval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				remove(false);
			} else {
				Logger.logMessage('W',this,"Couldn't set superApple, Player hasn't started yet!");
			}
			recalcIntervals();
		}
	}
	
	public void recalcIntervals(){
		placeInterval = ((long)Math.random()*20000)+10000;
		removeInterval = ((long)Math.random()*10000)+5000;
	}
	
	public void enable(){
		active = true;
	}
	
	public void disable(){
		active = false;
		this.interrupt();
	}
	
	public void drawApple(Graphics g){
		if (a != null){
			Color before = g.getColor();
			g.setColor(Color.red);
			g.fillRect(((int)(a.getX()*con.getDouble(Constants.XTILESIZE))), ((int)(a.getY()*con.getDouble(Constants.YTILESIZE))), con.getInt(Constants.XTILESIZE), con.getInt(Constants.YTILESIZE));
			g.setColor(before);
		}
	}
	
	public int getX(){
		return a.getX();
	}
	
	public int getY(){
		return a.getY();
	}
	
	public boolean appleHit(int x, int y){
		if (a != null){
			return x == a.getX() && y == a.getY();
		} else {
			return false;
		}
	}
	
	public SuperApple getApple(){
		return a;
	}
	
	public Constants getConstants(){
		return con;
	}
	
	public long getRemoveInterval(){
		return removeInterval;
	}
	
	public long getPlaceInterval(){
		return placeInterval;
	}
	
	public void remove(boolean save){
		if (save){
			a.remove();
			pocket.add(a);
		}
		a = null;
	}
	
	public void setApple(){
		a = new SuperApple(con, head);
		while (head.snakeOnField(a.getX(), a.getY())){
			a = new SuperApple(con, head);
		}
		index++;
		a.setIndex(index);
		a.setPlaceTime();
		a.setStayTime(removeInterval);
	}
	
	public void setApple(int x, int y){
		a = new SuperApple(con, head, x, y);
		index++;
		a.setIndex(index);
		a.setPlaceTime();
		a.setStayTime(removeInterval);
	}
}