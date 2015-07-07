package framework;

import java.awt.Color;
import java.awt.Graphics;

public class AppleManager {
	private Apple a;
	private Constants con;
	private int index = 0;
	private Apfeltasche pocket;
	private Schlangenkorper head;
	
	public AppleManager (Constants con, Apfeltasche pocket, Schlangenkorper head){
		this.con = con;
		this.pocket = pocket;
		this.head = head;
	}
	
	public void setApple(){
		a = new Apple(con, head);
		while (head.snakeOnField(a.getX(), a.getY())){
			a = new Apple(con, head);
		}
		index++;
		a.setIndex(index);
		a.setPlaceTime();
	}
	
	public void setApple (int x, int y){
		a = new Apple(con, head, x, y);
		index++;
		a.setIndex(index);
		a.setPlaceTime();
	}
	
	public void drawApple (Graphics g){
		if (a != null){
			Color before = g.getColor();
			g.setColor(Color.black);
			g.drawRect(((int)(a.getX()*con.getDouble(Constants.XTILESIZE))), ((int)(a.getY()*con.getDouble(Constants.YTILESIZE))), con.getInt(Constants.XTILESIZE), con.getInt(Constants.YTILESIZE));
			g.setColor(before);
		}
	}
	
	public void remove(){
		a.setPickupTime();
		a.remove();
		pocket.add(a);
		a = null;
	}
	
	public int getX(){
		if (a != null){
			return a.getX();
		} else {
			return 0;
		}
	}
	
	public int getY(){
		if (a != null){
			return a.getY();
		} else {
			return 0;
		}
	}
	
	public Apple getApple(){
		return a;
	}
	
	public boolean appleHit(int x, int y){
		if (a != null){
			return x == a.getX() && y == a.getY();
		} else {
			return false;
		}
	}
}
