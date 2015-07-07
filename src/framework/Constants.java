package framework;

import java.io.Serializable;
import java.util.Calendar;

import util.AverageDouble;
import logging.Logger;

@SuppressWarnings("serial")
public class Constants implements Serializable{
	//Steuerziffern (Form: Constants.get(Constants.LOGFILENAME))
	public static int LOGFILENAME = 0;
	public static int XWINDOWSIZE = 1;
	public static int YWINDOWSIZE = 2;
	public static int XTILENUMBER = 3;
	public static int YTILENUMBER = 4;
	public static int INTERVAL = 5;
	public static int XTILESIZE = 6;
	public static int YTILESIZE = 7;
	public static int DIFFICULTY = 8;
	public static int GRID = 9;
	public static int BORDERKILL = 10;
	public static int INGAME = 11;
	public static int SPEEDMULTIPLIER = 12;
	public static int NUMBERS = 13;
	public static int XFIELDSIZE = 14;
	public static int YFIELDSIZE = 15;
	
	public static int KEY_UP = 16;
	public static int KEY_DOWN = 17;
	public static int KEY_LEFT = 18;
	public static int KEY_RIGHT = 19;
	
	public static int STARTTIME = 20;
	public static int ENDTIME = 21;
	public static int HASINPUT = 22;
	public static int ENERGYSAVER = 23;
	public static int INVERSEMODE = 24;
	public static int FIRSTRUN = 25;
	
	public static int STATS_PLAYTIME = 26;
	public static int STATS_GAMESPLAYED = 27;
	public static int STATS_TIMESLAUNCHED = 28;
	public static int STATS_OVERALLAPPLES = 29;
	public static int STATS_OVERALLSUPERAPPLES = 30;
	public static int STATS_SUPERAPPLESLOST = 31;
	public static int STATS_MAXAPPLES = 32;
	public static int STATS_MAXSUPERAPPLES = 33;
	public static int STATS_AVGAPPLES = 34;
	public static int STATS_AVGSUPERAPPLES = 35;
	public static int STATS_AVGSUPERAPPLESCORE = 36;
	public static int STATS_MAXSUPERAPPLESCORE = 37;
	public static int STATS_BLOCKSWALKED = 38;
	public static int STATS_WALLHIT = 39;
	public static int STATS_DIEBYWALL = 40;
	public static int STATS_DIEBYEATSELF = 41;
	public static int STATS_DIEBYBADAPPLE = 42;
	public static int STATS_MAXSNAKELENGTH = 43;
	public static int STATS_AVGSNAKELENGTH = 44;
	public static int STATS_AVGPICKUPTIME = 45;
	
	public static int KEY_CONSOLE = 46;
	public static int KEY_PAUSE = 47;
	
	public static int DURATION = 48;
	
	public static int STATS_OVERALLSCORE = 53;
	public static int STATS_GAMESREVERSEMODE = 54;
	public static int STATS_GAMESENEMYMODE = 55;
	public static int STATS_GAMESLABYMODE = 56;
	public static int STATS_GAMESBORDERON = 57;
	public static int STATS_GAMESGRIDON = 58;
	public static int STATS_GAMESDIFFICULTY0 = 59;
	public static int STATS_GAMESDIFFICULTY1 = 60;
	public static int STATS_GAMESDIFFICULTY2 = 61;
	public static int STATS_GAMESDIFFICULTY3 = 62;
	public static int STATS_GAMESDIFFICULTY4 = 63;
	public static int STATS_GAMESDIFFICULTY5 = 64;
	public static int STATS_GAMESDIFFICULTY6 = 65;
	public static int STATS_GAMESDIFFICULTY7 = 66;
	public static int STATS_GAMESDIFFICULTY8 = 67;
	public static int STATS_GAMESDIFFICULTY9 = 68;
	public static int STATS_GAMESDIFFICULTY10 = 69;
	public static int STATS_AVGPLAYTIME = 70;
	
	private String logFileName = "Log.txt";
	private int xWindowSize = 500;
	private int yWindowSize = 500;
	private int xFieldSize = 500;
	private int yFieldSize = 500;
	private int xTileNumber = 20;
	private int yTileNumber = 20;
	private int difficulty = 5;
	private double speedMultiplier = 1;
	private long interval = (long)((500*speedMultiplier)/(difficulty + 1));
	private double xTileSize = xWindowSize/xTileNumber;
	private double yTileSize = yWindowSize/yTileNumber;
	private boolean grid = false;
	private boolean borderkill = false;
	private boolean inGame = true;
	private boolean numbers = false;
	private int key_up = java.awt.event.KeyEvent.VK_UP;
	private int key_down = java.awt.event.KeyEvent.VK_DOWN;
	private int key_left = java.awt.event.KeyEvent.VK_LEFT;
	private int key_right = java.awt.event.KeyEvent.VK_RIGHT;
	private long startTime = 0;
	private long endTime = 0;
	private long duration = 0;
	private boolean hasInput = false;
	private boolean energySaver = false;
	private boolean inverseMode = false;
	private boolean firstRun = true;
	private long stats_playTime = 0;
	private int stats_gamesPlayed = 0;
	private int stats_timesLaunched = 0;
	private int stats_overallApples = 0;
	private int stats_overallSuperApples = 0;
	private int stats_superApplesLost = 0;
	private int stats_maxApples = 0;
	private int stats_maxSuperApples = 0;
	private AverageDouble stats_avgApples = new AverageDouble();
	private AverageDouble stats_avgSuperApples = new AverageDouble();
	private AverageDouble stats_avgSuperAppleScore = new AverageDouble();
	private int stats_maxSuperAppleScore = 0;
	private int stats_blocksWalked = 0;
	private int stats_wallhit = 0;
	private int stats_dieByWall = 0;
	private int stats_dieByEatSelf = 0;
	private int stats_dieByBadApple = 0;
	private int stats_maxSnakeLength = 0;
	private AverageDouble stats_avgSnakeLength = new AverageDouble();
	private AverageDouble stats_avgPickupTime = new AverageDouble();
	
	private int key_console = java.awt.event.KeyEvent.VK_ENTER;
	private int key_pause = java.awt.event.KeyEvent.VK_SPACE;
	
	private int stats_overallScore = 0;
	private int stats_gamesReverseMode = 0;
	private int stats_gamesEnemyMode = 0;
	private int stats_gamesLabyMode = 0;
	private int stats_gamesBorderOn = 0;
	private int stats_gamesGridOn = 0;
	private int stats_gamesDifficulty0 = 0;
	private int stats_gamesDifficulty1 = 0;
	private int stats_gamesDifficulty2 = 0;
	private int stats_gamesDifficulty3 = 0;
	private int stats_gamesDifficulty4 = 0;
	private int stats_gamesDifficulty5 = 0;
	private int stats_gamesDifficulty6 = 0;
	private int stats_gamesDifficulty7 = 0;
	private int stats_gamesDifficulty8 = 0;
	private int stats_gamesDifficulty9 = 0;
	private int stats_gamesDifficulty10 = 0;
	
	private AverageDouble stats_avgPlayTime = new AverageDouble();
	
//	private Timer t;
	
	public void set (int memslot, int value){ // INT
		switch (memslot){
		case 1: xWindowSize = value; break;
		case 2: yWindowSize = value; break;
		case 3: xTileNumber = value; break;
		case 4: yTileNumber = value; break;
		case 5: interval = (long)value; break;
		case 6: xTileSize = (double)value; break;
		case 7: yTileSize = (double)value; break;
		case 8: difficulty = value; break;
		case 12: speedMultiplier = (double)value; break;
		case 14: xFieldSize = value; break;
		case 15: yFieldSize = value; break;
		case 16: key_up = value; break;
		case 17: key_down = value; break;
		case 18: key_left = value; break;
		case 19: key_right = value; break;
		case 20: startTime = (long)value; break;
		case 21: endTime = (long)value; break;
		case 26: stats_playTime = (long)value; break;
		case 27: stats_gamesPlayed = value; break;
		case 28: stats_timesLaunched = value; break;
		case 29: stats_overallApples = value; break;
		case 30: stats_overallSuperApples = value; break;
		case 31: stats_superApplesLost = value; break;
		case 32: stats_maxApples = value; break;
		case 33: stats_maxSuperApples = value; break;
		case 34: stats_avgApples.addToAverage((double)value); break;
		case 35: stats_avgSuperApples.addToAverage((double)value); break;
		case 36: stats_avgSuperAppleScore.addToAverage((double)value); break;
		case 37: stats_maxSuperAppleScore = value; break;
		case 38: stats_blocksWalked = value; break;
		case 39: stats_wallhit = value; break;
		case 40: stats_dieByWall = value; break;
		case 41: stats_dieByEatSelf = value; break;
		case 42: stats_dieByBadApple = value; break;
		case 43: stats_maxSnakeLength = value; break;
		case 44: stats_avgSnakeLength.addToAverage((double)value); break;
		case 45: stats_avgPickupTime.addToAverage((double)value); break;
		case 46: key_console = value; break;
		case 47: key_pause = value; break;
		case 48: duration = (long)value; break;
		case 53: stats_overallScore = value; break;
		case 54: stats_gamesReverseMode = value; break;
		case 55: stats_gamesEnemyMode = value; break;
		case 56: stats_gamesLabyMode = value; break;
		case 57: stats_gamesBorderOn = value; break;
		case 58: stats_gamesGridOn = value; break;
		case 59: stats_gamesDifficulty0 = value; break;
		case 60: stats_gamesDifficulty1 = value; break;
		case 61: stats_gamesDifficulty2 = value; break;
		case 62: stats_gamesDifficulty3 = value; break;
		case 63: stats_gamesDifficulty4 = value; break;
		case 64: stats_gamesDifficulty5 = value; break;
		case 65: stats_gamesDifficulty6 = value; break;
		case 66: stats_gamesDifficulty7 = value; break;
		case 67: stats_gamesDifficulty8 = value; break;
		case 68: stats_gamesDifficulty9 = value; break;
		case 69: stats_gamesDifficulty10 = value; break;
		case 70: stats_avgPlayTime.addToAverage((double)value); break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting int " + String.valueOf(memslot) + " to: " + String.valueOf(value)); break;
		}
	}
	
	public void set (int memslot, double value){
		switch (memslot){
		case 6: xTileSize = value; break;
		case 7: yTileSize = value; break;
		case 12: speedMultiplier = value; break;
		case 34: stats_avgApples.addToAverage(value); break;
		case 35: stats_avgSuperApples.addToAverage(value); break;
		case 36: stats_avgSuperAppleScore.addToAverage(value); break;
		case 44: stats_avgSnakeLength.addToAverage(value); break;
		case 45: stats_avgPickupTime.addToAverage(value); break;
		case 70: stats_avgPlayTime.addToAverage(value); break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting double " + String.valueOf(memslot) + " to: " + String.valueOf(value)); break;
		}
	}
	
	public void set (int memslot, String value){ // STRING
		switch (memslot){
		case 0: logFileName = value; break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting String " + String.valueOf(memslot) + " to: " + value); break;
		}
	}
	
	public void set (int memslot, char value){ //CHAR
		switch (memslot){
		case 16: key_up = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		case 17: key_down = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		case 18: key_left = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		case 19: key_right = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		case 46: key_console = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		case 47: key_pause = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(value); break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting char " + String.valueOf(memslot) + " to: " + String.valueOf(value)); break;
		}
	}
	
	public void set (int memslot, long value){ //LONG
		switch (memslot){
		case 20: startTime = value; break;
		case 21: endTime = value; break;
		case 26: stats_playTime = value; break;
		case 48: duration = value; break;
		case 70: stats_avgApples.addToAverage(value); break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting long " + String.valueOf(memslot) + " to: " + String.valueOf(value)); break;
		}
	}
	
	public void set (int memslot, boolean value){
		switch (memslot){
		case 9: grid = value; break;
		case 10: borderkill = value; break;
		case 11: inGame = value; break;
		case 13: numbers = value; break;
		case 22: hasInput = value; break;
		case 23: energySaver = value; break;
		case 24: inverseMode = value; break;
		case 25: firstRun = value; break;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when setting boolean " + String.valueOf(memslot) + " to: " + String.valueOf(value)); break;
		}
	}
	
	public int getInt (int memslot){
		switch (memslot){
		case 1: return xWindowSize;
		case 2: return yWindowSize;
		case 3: return xTileNumber;
		case 4: return yTileNumber;
		case 5: return (int)interval;
		case 6: return (int)xTileSize;
		case 7: return (int)yTileSize;
		case 8: return difficulty;
		case 9: if (grid) return 1; else return 0;
		case 10: if (borderkill) return 1; else return 0;
		case 11: if (inGame) return 1; else return 0;
		case 12: return (int)speedMultiplier;
		case 13: if (numbers) return 1; else return 0;
		case 14: return xFieldSize;
		case 15: return yFieldSize;
		case 16: return key_up;
		case 17: return key_down;
		case 18: return key_left;
		case 19: return key_right;
		case 20: return (int)startTime;
		case 21: return (int)endTime;
		case 22: if (hasInput) return 1; else return 0;
		case 23: if (energySaver) return 1; else return 0;
		case 24: if (inverseMode) return 1; else return 0;
		case 25: if (firstRun) return 1; else return 0;
		case 26: return (int)stats_playTime;
		case 27: return stats_gamesPlayed;
		case 28: return stats_timesLaunched;
		case 29: return stats_overallApples;
		case 30: return stats_overallSuperApples;
		case 31: return stats_superApplesLost;
		case 32: return stats_maxApples;
		case 33: return stats_maxSuperApples;
		case 34: return (int)stats_avgApples.getValue();
		case 35: return (int)stats_avgSuperApples.getValue();
		case 36: return (int)stats_avgSuperAppleScore.getValue();
		case 37: return stats_maxSuperAppleScore;
		case 38: return stats_blocksWalked;
		case 39: return stats_wallhit;
		case 40: return stats_dieByWall;
		case 41: return stats_dieByEatSelf;
		case 42: return stats_dieByBadApple;
		case 43: return stats_maxSnakeLength;
		case 44: return (int)stats_avgSnakeLength.getValue();
		case 45: return (int)stats_avgPickupTime.getValue();
		case 46: return key_console;
		case 47: return key_pause;
		case 48: return (int)duration;
		case 53: return stats_overallScore;
		case 54: return stats_gamesReverseMode;
		case 55: return stats_gamesEnemyMode;
		case 56: return stats_gamesLabyMode;
		case 57: return stats_gamesBorderOn;
		case 58: return stats_gamesGridOn;
		case 59: return stats_gamesDifficulty0;
		case 60: return stats_gamesDifficulty1;
		case 61: return stats_gamesDifficulty2;
		case 62: return stats_gamesDifficulty3;
		case 63: return stats_gamesDifficulty4;
		case 64: return stats_gamesDifficulty5;
		case 65: return stats_gamesDifficulty6;
		case 66: return stats_gamesDifficulty7;
		case 67: return stats_gamesDifficulty8;
		case 68: return stats_gamesDifficulty9;
		case 69: return stats_gamesDifficulty10;
		case 70: return (int)stats_avgPlayTime.getValue();
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning int " + String.valueOf(memslot)); return -1;
		}
	}
	
	public String getString (int memslot){
		switch (memslot){
		case 0: return logFileName;
		case 1: return String.valueOf(xWindowSize);
		case 2: return String.valueOf(yWindowSize);
		case 3: return String.valueOf(xTileNumber);
		case 4: return String.valueOf(yTileNumber);
		case 5: return String.valueOf(interval);
		case 6: return String.valueOf(xTileSize);
		case 7: return String.valueOf(yTileSize);
		case 8: return String.valueOf(difficulty);
		case 9: return String.valueOf(grid);
		case 10: return String.valueOf(borderkill);
		case 11: return String.valueOf(inGame);
		case 12: return String.valueOf(speedMultiplier);
		case 13: return String.valueOf(numbers);
		case 14: return String.valueOf(xFieldSize);
		case 15: return String.valueOf(yFieldSize);
		case 16: return java.awt.event.KeyEvent.getKeyText(key_up);
		case 17: return java.awt.event.KeyEvent.getKeyText(key_down);
		case 18: return java.awt.event.KeyEvent.getKeyText(key_left);
		case 19: return java.awt.event.KeyEvent.getKeyText(key_right);
		case 20: return String.valueOf(startTime);
		case 21: return String.valueOf(endTime);
		case 22: return String.valueOf(hasInput);
		case 23: return String.valueOf(energySaver);
		case 24: return String.valueOf(inverseMode);
		case 25: return String.valueOf(firstRun);
		case 26: return String.valueOf(stats_playTime);
		case 27: return String.valueOf(stats_gamesPlayed);
		case 28: return String.valueOf(stats_timesLaunched);
		case 29: return String.valueOf(stats_overallApples);
		case 30: return String.valueOf(stats_overallSuperApples);
		case 31: return String.valueOf(stats_superApplesLost);
		case 32: return String.valueOf(stats_maxApples);
		case 33: return String.valueOf(stats_maxSuperApples);
		case 34: return String.valueOf(stats_avgApples.getValue());
		case 35: return String.valueOf(stats_avgSuperApples.getValue());
		case 36: return String.valueOf(stats_avgSuperAppleScore.getValue());
		case 37: return String.valueOf(stats_maxSuperAppleScore);
		case 38: return String.valueOf(stats_blocksWalked);
		case 39: return String.valueOf(stats_wallhit);
		case 40: return String.valueOf(stats_dieByWall);
		case 41: return String.valueOf(stats_dieByEatSelf);
		case 42: return String.valueOf(stats_dieByBadApple);
		case 43: return String.valueOf(stats_maxSnakeLength);
		case 44: return String.valueOf(stats_avgSnakeLength.getValue());
		case 45: return String.valueOf(stats_avgPickupTime.getValue());
		case 46: return java.awt.event.KeyEvent.getKeyText(key_console);
		case 47: return java.awt.event.KeyEvent.getKeyText(key_pause);
		case 48: return String.valueOf(duration);
		case 53: return String.valueOf(stats_overallScore);
		case 54: return String.valueOf(stats_gamesReverseMode);
		case 55: return String.valueOf(stats_gamesEnemyMode);
		case 56: return String.valueOf(stats_gamesLabyMode);
		case 57: return String.valueOf(stats_gamesBorderOn);
		case 58: return String.valueOf(stats_gamesGridOn);
		case 59: return String.valueOf(stats_gamesDifficulty0);
		case 60: return String.valueOf(stats_gamesDifficulty1);
		case 61: return String.valueOf(stats_gamesDifficulty2);
		case 62: return String.valueOf(stats_gamesDifficulty3);
		case 63: return String.valueOf(stats_gamesDifficulty4);
		case 64: return String.valueOf(stats_gamesDifficulty5);
		case 65: return String.valueOf(stats_gamesDifficulty6);
		case 66: return String.valueOf(stats_gamesDifficulty7);
		case 67: return String.valueOf(stats_gamesDifficulty8);
		case 68: return String.valueOf(stats_gamesDifficulty9);
		case 69: return String.valueOf(stats_gamesDifficulty10);
		case 70: return String.valueOf(stats_avgPlayTime.getValue());
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning String " + String.valueOf(memslot)); return "ERROR!";
		}
	}
	
	public char getChar (int memslot){
		switch (memslot){
		case 9: if (grid) return '1'; else return '0';
		case 10: if (borderkill) return '1'; else return '0';
		case 11: if (inGame) return '1'; else return '0';
		case 13: if (numbers) return '1'; else return '0';
		case 22: if (hasInput) return '1'; else return '0';
		case 23: if (energySaver) return '1'; else return '0';
		case 24: if (inverseMode) return '1'; else return '0';
		case 25: if (firstRun) return '1'; else return '0';
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning char " + String.valueOf(memslot)); return '-';
		}
	}
	
	public long getLong (int memslot){
		switch (memslot){
		case 1: return (long)xWindowSize;
		case 2: return (long)yWindowSize;
		case 3: return (long)xTileNumber;
		case 4: return (long)yTileNumber;
		case 5: return interval;
		case 6: return (long)xTileSize;
		case 7: return (long)yTileSize;
		case 8: return (long)difficulty;
		case 9: if (grid) return 1; else return 0;
		case 10: if (borderkill) return 1; else return 0;
		case 11: if (inGame) return 1; else return 0;
		case 12: return (long)speedMultiplier;
		case 13: if (numbers) return 1; else return 0;
		case 14: return (long)xFieldSize;
		case 15: return (long)yFieldSize;
		case 16: return (long)key_up;
		case 17: return (long)key_down;
		case 18: return (long)key_left;
		case 19: return (long)key_right;
		case 20: return startTime;
		case 21: return endTime;
		case 22: if (hasInput) return 1; else return 0;
		case 23: if (energySaver) return 1; else return 0;
		case 24: if (inverseMode) return 1; else return 0;
		case 25: if (firstRun) return 1; else return 0;
		case 26: return stats_playTime;
		case 27: return (long)stats_gamesPlayed;
		case 28: return (long)stats_timesLaunched;
		case 29: return (long)stats_overallApples;
		case 30: return (long)stats_overallSuperApples;
		case 31: return (long)stats_superApplesLost;
		case 32: return (long)stats_maxApples;
		case 33: return (long)stats_maxSuperApples;
		case 34: return (long)stats_avgApples.getValue();
		case 35: return (long)stats_avgSuperApples.getValue();
		case 36: return (long)stats_avgSuperAppleScore.getValue();
		case 37: return (long)stats_maxSuperAppleScore;
		case 38: return (long)stats_blocksWalked;
		case 39: return (long)stats_wallhit;
		case 40: return (long)stats_dieByWall;
		case 41: return (long)stats_dieByEatSelf;
		case 42: return (long)stats_dieByBadApple;
		case 43: return (long)stats_maxSnakeLength;
		case 44: return (long)stats_avgSnakeLength.getValue();
		case 45: return (long)stats_avgPickupTime.getValue();
		case 46: return (long)key_console;
		case 47: return (long)key_pause;
		case 48: return duration;
		case 53: return (long)stats_overallScore;
		case 54: return (long)stats_gamesReverseMode;
		case 55: return (long)stats_gamesEnemyMode;
		case 56: return (long)stats_gamesLabyMode;
		case 57: return (long)stats_gamesBorderOn;
		case 58: return (long)stats_gamesGridOn;
		case 59: return (long)stats_gamesDifficulty0;
		case 60: return (long)stats_gamesDifficulty1;
		case 61: return (long)stats_gamesDifficulty2;
		case 62: return (long)stats_gamesDifficulty3;
		case 63: return (long)stats_gamesDifficulty4;
		case 64: return (long)stats_gamesDifficulty5;
		case 65: return (long)stats_gamesDifficulty6;
		case 66: return (long)stats_gamesDifficulty7;
		case 67: return (long)stats_gamesDifficulty8;
		case 68: return (long)stats_gamesDifficulty9;
		case 69: return (long)stats_gamesDifficulty10;
		case 70: return (long)stats_avgPlayTime.getValue();
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning long " + String.valueOf(memslot)); return -1;
		}
	}
	
	public boolean getBoolean (int memslot){
		switch (memslot){
		case 9: return grid;
		case 10: return borderkill;
		case 11: return inGame;
		case 13: return numbers;
		case 22: return hasInput;
		case 23: return energySaver;
		case 24: return inverseMode;
		case 25: return firstRun;
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning boolean " + String.valueOf(memslot)); return false;
		}
	}
	
	public double getDouble (int memslot){
		switch (memslot){
		case 1: return (double)xWindowSize;
		case 2: return (double)yWindowSize;
		case 3: return (double)xTileNumber;
		case 4: return (double)yTileNumber;
		case 5: return (double)interval;
		case 6: return xTileSize;
		case 7: return yTileSize;
		case 8: return (double)difficulty;
		case 9: if (grid) return 1; else return 0;
		case 10: if (borderkill) return 1; else return 0;
		case 11: if (inGame) return 1; else return 0;
		case 12: return speedMultiplier;
		case 13: if (numbers) return 1; else return 0;
		case 14: return (double)xFieldSize;
		case 15: return (double)yFieldSize;
		case 16: return (double)key_up;
		case 17: return (double)key_down;
		case 18: return (double)key_left;
		case 19: return (double)key_right;
		case 20: return (double)startTime;
		case 21: return (double)endTime;
		case 22: if (hasInput) return 1; else return 0;
		case 23: if (energySaver) return 1; else return 0;
		case 24: if (inverseMode) return 1; else return 0;
		case 25: if (firstRun) return 1; else return 0;
		case 26: return (double)stats_playTime;
		case 27: return (double)stats_gamesPlayed;
		case 28: return (double)stats_timesLaunched;
		case 29: return (double)stats_overallApples;
		case 30: return (double)stats_overallSuperApples;
		case 31: return (double)stats_superApplesLost;
		case 32: return (double)stats_maxApples;
		case 33: return (double)stats_maxSuperApples;
		case 34: return stats_avgApples.getValue();
		case 35: return stats_avgSuperApples.getValue();
		case 36: return stats_avgSuperAppleScore.getValue();
		case 37: return (double)stats_maxSuperAppleScore;
		case 38: return (double)stats_blocksWalked;
		case 39: return (double)stats_wallhit;
		case 40: return (double)stats_dieByWall;
		case 41: return (double)stats_dieByEatSelf;
		case 42: return (double)stats_dieByBadApple;
		case 43: return (double)stats_maxSnakeLength;
		case 44: return stats_avgSnakeLength.getValue();
		case 45: return stats_avgPickupTime.getValue();
		case 46: return (double)key_console;
		case 47: return (double)key_pause;
		case 53: return (double)stats_overallScore;
		case 54: return (double)stats_gamesReverseMode;
		case 55: return (double)stats_gamesEnemyMode;
		case 56: return (double)stats_gamesLabyMode;
		case 57: return (double)stats_gamesBorderOn;
		case 58: return (double)stats_gamesGridOn;
		case 59: return (double)stats_gamesDifficulty0;
		case 60: return (double)stats_gamesDifficulty1;
		case 61: return (double)stats_gamesDifficulty2;
		case 62: return (double)stats_gamesDifficulty3;
		case 63: return (double)stats_gamesDifficulty4;
		case 64: return (double)stats_gamesDifficulty5;
		case 65: return (double)stats_gamesDifficulty6;
		case 66: return (double)stats_gamesDifficulty7;
		case 67: return (double)stats_gamesDifficulty8;
		case 68: return (double)stats_gamesDifficulty9;
		case 69: return (double)stats_gamesDifficulty10;
		case 70: return (double)stats_avgPlayTime.getValue();
		default: Logger.logMessage('E', this, "Wrong memslot-ID when returning double " + String.valueOf(memslot)); return -1;
		}
	}
	
	public boolean getBool (int memslot){
		return getBoolean (memslot);
	}
	
	public void calcTilesize(){
		xTileSize = xFieldSize/xTileNumber;
		yTileSize = yFieldSize/yTileNumber;
	}
	
	public void calcInterval(){
		interval = (long)((500*speedMultiplier)/(difficulty + 1));
	}
	
	public long getDuration(){
		return endTime - startTime;
	}
	
	public long getDuration(long startTime, long endTime){
		return startTime - endTime;
	}
	
	public void setStarttime(){
		startTime = Calendar.getInstance().getTimeInMillis();
	}
	
	public void setEndtime(){
		endTime = Calendar.getInstance().getTimeInMillis();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("LOGFILENAME: ");
		sb.append(getString(Constants.LOGFILENAME));
		sb.append(" WINDOWSIZE: ");
		sb.append(getString(Constants.XWINDOWSIZE));
		sb.append(", ");
		sb.append(getString(Constants.YWINDOWSIZE));
		sb.append(" TILENUMBER: ");
		sb.append(getString(Constants.XTILENUMBER));
		sb.append(", ");
		sb.append(getString(Constants.YTILENUMBER));
		sb.append(" TILESIZE: ");
		sb.append(getString(Constants.XTILESIZE));
		sb.append(", ");
		sb.append(getString(Constants.YTILESIZE));
		sb.append(" FIELDSIZE: ");
		sb.append(getString(Constants.XFIELDSIZE));
		sb.append(", ");
		sb.append(getString(Constants.YFIELDSIZE));
		sb.append(" INTERVAL: ");
		sb.append(getString(Constants.INTERVAL));
		sb.append(" DIFFICULTY: ");
		sb.append(getString(Constants.DIFFICULTY));
		sb.append(" GRID: ");
		sb.append(getString(Constants.GRID));
		sb.append(" NUMBERS: ");
		sb.append(getString(Constants.NUMBERS));
		sb.append(" BORDERKILL: ");
		sb.append(getString(Constants.BORDERKILL));
		sb.append(" INGAME: ");
		sb.append(getString(Constants.INGAME));
		sb.append(" SPEEDMULTIPLIER: ");
		sb.append(getString(Constants.SPEEDMULTIPLIER));
		sb.append(" CONTROLKEYS: ");
		sb.append(getString(Constants.KEY_UP));
		sb.append(" ");
		sb.append(getString(Constants.KEY_DOWN));
		sb.append(" ");
		sb.append(getString(Constants.KEY_LEFT));
		sb.append(" ");
		sb.append(getString(Constants.KEY_RIGHT));
		sb.append(" START/ENDTIME: ");
		sb.append(getString(Constants.STARTTIME));
		sb.append(" ");
		sb.append(getString(Constants.ENDTIME));
		sb.append(" HASINPUT: ");
		sb.append(getString(Constants.HASINPUT));
		return sb.toString();
	}
	
//	public void startTimer(){
//		Logger.logMessage('I', this, "Starting timer...");
//		t = new Timer(0, 0, 0, 0, 0, 0, 0, 10);
//		t.start();
//	}
//	
//	public Timer getTimer(){
//		return t;
//	}
//	
//	public void stopTimer(){
//		t.stop();
//	}
}