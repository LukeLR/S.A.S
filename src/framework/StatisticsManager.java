package framework;

public class StatisticsManager {
	public static int NORMALMDOE = 0;
	public static int RESERVEMODE = 1;
	public static int ENEMYMODE = 2;
	public static int LABYMODE = 3;
	public static int BORDERON = 4;
	public static int GRIDON = 5;
	
	private Constants con;
	
	public StatisticsManager (Constants con){
		this.con = con;
	}
	
	public void eatApple(){
		con.set(Constants.STATS_OVERALLAPPLES, con.getInt(Constants.STATS_OVERALLAPPLES) + 1);
	}
	
	public void eatSuperApple(){
		con.set(Constants.STATS_OVERALLSUPERAPPLES, con.getInt(Constants.STATS_OVERALLSUPERAPPLES) + 1);
	}
	
	public void eatApple(int number){
		con.set(Constants.STATS_OVERALLAPPLES, con.getInt(Constants.STATS_OVERALLAPPLES) + number);
	}
	
	public void eatSuperApple(int number){
		con.set(Constants.STATS_OVERALLSUPERAPPLES, con.getInt(Constants.STATS_OVERALLSUPERAPPLES) + number);
	}
	
	public void increaseScore(int points){
		con.set(Constants.STATS_OVERALLSCORE, con.getInt(Constants.STATS_OVERALLSCORE) + points);
	}
	
	public void decreaseScore(int points){
		con.set(Constants.STATS_OVERALLSCORE, con.getInt(Constants.STATS_OVERALLSCORE) - points);
	}
	
	public void increasePlayTime(long time){
		con.set(Constants.STATS_PLAYTIME, con.getLong(Constants.STATS_PLAYTIME) + time);
	}
	
	public void decreasePlayTime(long time){
		con.set(Constants.STATS_PLAYTIME, con.getLong(Constants.STATS_PLAYTIME) - time);
	}
	
	public void playedOnce(){
		con.set(Constants.STATS_GAMESPLAYED, con.getInt(Constants.STATS_GAMESPLAYED) + 1);
	}
	
	public void playedMultiple(int number){
		con.set(Constants.STATS_GAMESPLAYED, con.getInt(Constants.STATS_GAMESPLAYED) + 1);
	}
	
	public void playedOnce(int gametype){
		switch (gametype){
		case 0: con.set(Constants.STATS_GAMESPLAYED, con.getInt(Constants.STATS_GAMESPLAYED) + 1); break;
		case 1: con.set(Constants.STATS_GAMESREVERSEMODE, con.getInt(Constants.STATS_GAMESREVERSEMODE) + 1); break;
		case 2: con.set(Constants.STATS_GAMESENEMYMODE, con.getInt(Constants.STATS_GAMESENEMYMODE) + 1); break;
		case 3: con.set(Constants.STATS_GAMESLABYMODE, con.getInt(Constants.STATS_GAMESLABYMODE) + 1); break;
		case 4: con.set(Constants.STATS_GAMESBORDERON, con.getInt(Constants.STATS_GAMESBORDERON) + 1); break;
		case 5: con.set(Constants.STATS_GAMESGRIDON, con.getInt(Constants.STATS_GAMESGRIDON) + 1); break;
		}
	}
	
	public void playedMultiple(int gametype, int number){
		switch (gametype){
		case 0: con.set(Constants.STATS_GAMESPLAYED, con.getInt(Constants.STATS_GAMESPLAYED) + number); break;
		case 1: con.set(Constants.STATS_GAMESREVERSEMODE, con.getInt(Constants.STATS_GAMESREVERSEMODE) + number); break;
		case 2: con.set(Constants.STATS_GAMESENEMYMODE, con.getInt(Constants.STATS_GAMESENEMYMODE) + number); break;
		case 3: con.set(Constants.STATS_GAMESLABYMODE, con.getInt(Constants.STATS_GAMESLABYMODE) + number); break;
		case 4: con.set(Constants.STATS_GAMESBORDERON, con.getInt(Constants.STATS_GAMESBORDERON) + number); break;
		case 5: con.set(Constants.STATS_GAMESGRIDON, con.getInt(Constants.STATS_GAMESGRIDON) + number); break;
		}
	}
	
	public void launchedOnce(){
		con.set(Constants.STATS_TIMESLAUNCHED, con.getInt(Constants.STATS_TIMESLAUNCHED) + 1);
	}
	
	public void setMaxApplesForce (int number){
		con.set(Constants.STATS_MAXAPPLES, number);
	}
	
	public void setMaxApples (int number){
		if (number > con.getInt(Constants.STATS_MAXAPPLES)){
			con.set(Constants.STATS_MAXAPPLES, number);
		}
	}
	
	public void setMaxSuperApplesForce (int number){
		con.set(Constants.STATS_MAXSUPERAPPLES, number);
	}
	
	public void setMaxSuperApples (int number){
		if (number > con.getInt(Constants.STATS_MAXSUPERAPPLES)){
			con.set(Constants.STATS_MAXSUPERAPPLES, number);
		}
	}
	
	public void addAvgApples(int apples){
		con.set(Constants.STATS_AVGAPPLES, apples);
	}
	
	public void addAvgSuperApples (int apples){
		con.set(Constants.STATS_AVGSUPERAPPLES, apples);
	}
	
	public void addAvgSuperAppleScore (int score){
		con.set(Constants.STATS_AVGSUPERAPPLESCORE, score);
	}
	
	public void addAvgSnakeLength (int length){
		con.set(Constants.STATS_AVGSNAKELENGTH, length);
	}
	
	public void addAvgPickupTime (long time){
		con.set(Constants.STATS_AVGPICKUPTIME, time);
	}
	
	public void addAvgPlayTime (long time){
		con.set(Constants.STATS_AVGPLAYTIME, time);
	}
	
	public void setBlocksWalked (int distance){
		con.set(Constants.STATS_BLOCKSWALKED, distance);
	}
	
	public void addBlocksWalked (int distance){
		con.set(Constants.STATS_BLOCKSWALKED, con.getInt(Constants.STATS_BLOCKSWALKED) + distance);
	}
	
	public void setWallHit (int number){
		con.set(Constants.STATS_WALLHIT, number);
	}
	
	public void addWallHit (int number){
		con.set(Constants.STATS_WALLHIT, con.getInt(Constants.STATS_WALLHIT) + number);
	}
	
	public void setDieByWall (int number){
		con.set(Constants.STATS_DIEBYWALL, number);
	}
	
	public void addDieByWall (int number){
		con.set(Constants.STATS_DIEBYWALL, con.getInt(Constants.STATS_DIEBYWALL) + number);
	}
	
	public void setDieByEatSelf (int number){
		con.set(Constants.STATS_DIEBYEATSELF, number);
	}
	
	public void addDieByEatSelf (int number){
		con.set(Constants.STATS_DIEBYEATSELF, con.getInt(Constants.STATS_DIEBYEATSELF) + number);
	}
	
	public void setDieByBadApple (int number){
		con.set(Constants.STATS_DIEBYBADAPPLE, number);
	}
	
	public void addDieByBadApple (int number){
		con.set(Constants.STATS_DIEBYBADAPPLE, con.getInt(Constants.STATS_DIEBYBADAPPLE) + number);
	}
	
	public void setMaxSnakeLengthForce (int length){
		con.set(Constants.STATS_MAXSNAKELENGTH, length);
	}
	
	public void setMaxSnakeLength (int length){
		if (length > con.getInt(Constants.STATS_MAXSNAKELENGTH)){
			con.set(Constants.STATS_MAXSNAKELENGTH, length);
		}
	}
}
