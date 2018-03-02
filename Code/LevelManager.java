package com.Syndacor.tapattacker;

import java.util.Random;



public class LevelManager {

private int currentLevel =1;
private boolean lvldup=true;
private int xPosition;
Random randy;
GameView viewy;




LevelManager(GameView view){
	viewy=view;
}




public int getcurrentLevel(){
	return currentLevel;
}


public void levelUp(){
	currentLevel++;
}

public void deLevel(int lvl){
	currentLevel =lvl;
}


public void lvldup(boolean idk){
	lvldup=idk;
}

public boolean getLvldup(){
	return lvldup;
	
}



public int getXpos(){
	return xPosition;
	
}

public void setLevel(int lvl){
	currentLevel = lvl;
}

	
	
	
	
}