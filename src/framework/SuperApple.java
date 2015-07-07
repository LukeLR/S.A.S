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