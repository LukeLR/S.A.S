package framework;

import java.io.Serializable;

import logging.Logger;

public class Apfeltasche implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7015952755419729968L;
	private Apple[] apples;
	private int length;
	
	public Apfeltasche(){
		this(1);
	}
	
	public Apfeltasche(int buffer){
		apples = new SuperApple[buffer];
	}
	
	public void add(Apple a){
		if (a.getClass().getName().equals("framework.Apple")){
			Logger.logMessage('I', this, "Added Apple with Index " + String.valueOf(a.getIndex()));
		} else if (a.getClass().getName().equals("framework.SuperApple")){
			Logger.logMessage('I', this, "Added SuperApple with Index " + String.valueOf(a.getIndex()));
		} else {
			Logger.logMessage('E', this, "Invalid AppleType in adding. Trying to continue procedure.");
		}
		length = length + 1;
		Apple[] temp = apples;
		apples = new Apple[length];
		for (int i = 0; i < temp.length; i++){
			apples[i] = temp[i];
		}
		apples[length - 1] = a;
	}
	
	public Apple[] getApples(){
		return apples;
	}
	
	public Apple getApple(int index){
		return apples[index];
	}
	
	public int getLength(){
		return apples.length;
	}
	
//	public String toString(){
//		StringBuilder result = new StringBuilder();
//		
//		for (int i = 0; i < apples.length; i++){
//			result.append(i);
//			result.append(" ");
//			if (apples[i].getClass().getName().equals("Apple"))){
//				result.append("Apple ");
//				result.append(apples[i].getIndex());
//				result.append(" Pickup: ");
//				result.append(apples[i].getPickupTime());
//				result.appen
//			}
//		}
//	}
}
