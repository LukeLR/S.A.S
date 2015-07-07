package framework;

import logging.Logger;

public class Schlangenkorper {
	private Schlangenkorper next;
	private int x = 0;
	private int y = 0;
	
	boolean isHead = false, popped = false, visible = true;
	
	public Schlangenkorper (){
		
	}
	
	public Schlangenkorper (int px, int py){
		this.x = px;
		this.y = py;
		Logger.logMessage('I', this, "Created new Schlangenkorper at " + px + ", " + py);
	}
	
	public void setNext (Schlangenkorper pNext){
		Logger.logMessage('I', this, "Appended new Schlangenkorper at " + pNext.getX() + ", " + pNext.getY() + " me: " + x + ", " + y);
		next = pNext;
	}
	
	public void append (Schlangenkorper pAppending){
		if (next == null){
			setNext (pAppending);
		} else {
			next.append(pAppending);
		}
	}
	
	public Schlangenkorper getNext(){
		return next;
	}
	
	public void setHead (boolean pHead){
		isHead = pHead;
	}
	
	public boolean isHead (){
		return isHead;
	}
	
	public void setPosition (int x, int y){
		if(next != null){
			next.setPosition(this.x, this.y);
		}
		this.x = x;
		this.y = y;
	}
	
	public int getX (){
		return x;
	}
	
	public int getY (){
		return y;
	}
	
	public boolean snakeOnField (int x, int y){
		if (x == this.x && y == this.y){
			return true;
		} else {
			if (next == null){
				return false;
			} else {
				return next.snakeOnField(x, y);
			}
		}
	}
	
	public int length (int pre){
		if (next == null){
			return pre;
		} else {
			return next.length(pre + 1);
		}
	}
	
	public void pop(){
		popped = true;
		if (next != null){
			next.pop();
		}
	}
	
	public boolean isPopped(){
		return popped;
	}
	
	public void setVisible(boolean value){
		visible = value;
		if (next != null){
			next.setVisible(value);
		}
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void hide(){
		visible = false;
		if (next != null){
			next.hide();
		}
	}
	
	public void show(){
		visible = true;
		if (next != null){
			next.show();
		}
	}
}