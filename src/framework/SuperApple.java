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
import java.util.Calendar;

public class SuperApple extends Apple implements Serializable {
	public SuperApple (Constants con, Schlangenkorper head){
		super (con, head);
	}
	
	public SuperApple (Constants con, Schlangenkorper head, int x, int y){
		super (con, head, x, y);
	}
	
	public void calcBaseScore(){
		baseScore = index * 3;
	}
	
	public void calcOverallBonus(){
		overallBonus = baseScore + timeBonus + lengthBonus;
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
}