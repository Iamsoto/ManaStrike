package com.Syndacor.tapattacker;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Elements {
	
	private int FIRE  =  1;
	private int WATER =  2;
	private int LIGHT =  3;
	private int EARTH =  4;
	private double lightloc;
	private double fireloc;
	private double earthloc;
	private double waterloc;
    private GameView viewy;
	private Bitmap ellyBar;	
    private float XPOS;  
    private double ellySpace;
    private int currentElement= 3;
    private double ellyXpos;
    private double YPOS;

public Elements(GameView view, Bitmap bmp){
	ellyBar=bmp;
	viewy = view;


}
	
	
	
	

	
	public void onDraw( Canvas canvy){
		XPOS = (float)(viewy.getWidth()/2 - ellyBar.getWidth()/2);
		YPOS = (float) (viewy.getHeight()*.875);
		canvy.drawBitmap(ellyBar,XPOS, (float)(YPOS), null);
			
		
	}
	// collide and elementDetermined are meant to be used together with same X& y
	
	public boolean collide(float x2, float y2) {
		return (x2)>XPOS && (x2)<XPOS +ellyBar.getWidth() && (y2)> YPOS && (y2)<YPOS+ellyBar.getHeight();
	  
	}
	
	public int determineElement(float x){
		placeBar();
		if(x>= XPOS && x<waterloc){
			currentElement = FIRE;
			ellyXpos = XPOS; 
			return FIRE;
		}
		else if(x>=waterloc && x<lightloc){
			currentElement = WATER;
			ellyXpos = waterloc; 
			return WATER;
			}
		else if(x>=lightloc && x<earthloc){
			currentElement = LIGHT;
			ellyXpos = lightloc; 
			return LIGHT;
			}
		else{
			currentElement = EARTH;
			ellyXpos = earthloc; 
			return EARTH;
		}
	}
	
	
	
	private void placeBar(){
		
		double lastX= XPOS+ellyBar.getWidth();
	   ellySpace = (lastX-XPOS)/4;
		fireloc = XPOS;
		waterloc = XPOS +ellySpace;
		lightloc = waterloc +ellySpace;
		earthloc = lightloc+ellySpace; 
		
	}
	
	public int getCurrentElement(){
		return currentElement;
	}
	
	
	public int getYpos(){
		return (int) YPOS;
		
	}
	
	public double getEllyX(){
		return ellyXpos;
		
	}
	
	
	
	
	
	
	
	
	
}
