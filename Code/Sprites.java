package com.Syndacor.tapattacker;

import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprites {
private static final int BMP_COLUMNS = 3;
private static final int BMP_ROWS = 4;
int[] DIRECTION_TO_ANIMATION_MAP= {3,1,0,2}; 
private int x;
private int y;
public float firstx;
public float firsty; 
public float scndx;
public float scndy;
public float thirdx;
public float thirdy;

private int xSpeed =5;
private int ySpeed =5;
private GameView viewy; 
private Bitmap bmp;
private int width;
private int height;
int currentFrame;
//Almighty health, usually 15
private int health = 15; 

private int deadx;
private int deady;
private boolean hit=false;
private boolean hasShield=false;
private int counter =20;
private int lvly;


public Sprites(GameView viewy, Bitmap bmp){
	this.viewy=viewy;
	this.bmp=bmp;
	this.width = bmp.getWidth() /4;
	this.height = bmp.getHeight() / BMP_ROWS; 
	Random randy = new Random();
	xSpeed = randy.nextInt(3)+1; 
	ySpeed = randy.nextInt(3)+1; 
	x = randy.nextInt(viewy.getWidth()-width);
	y = randy.nextInt(viewy.getHeight()-height);
	lvly=viewy.level();

}

@SuppressLint("ParserError")
public void renew(){


	
if(x>viewy.getWidth()-width-xSpeed || x+xSpeed<0){
xSpeed = -xSpeed;
}
 x=x+xSpeed;
 
 if(y>viewy.getHeight()-height-ySpeed|| y+ySpeed<0){
	 ySpeed = -ySpeed;
 }
 
 y=y+ySpeed;
 

 currentFrame = ++currentFrame%3; 
 
 
 
	}

private int getAnimationRow(){
     double dirDouble = (Math.atan2(xSpeed,ySpeed)/(Math.PI/2)+2);
     int direction = (int) Math.round(dirDouble)%BMP_ROWS;
     return DIRECTION_TO_ANIMATION_MAP[direction];
     
}

@SuppressLint({ "DrawAllocation", "DrawAllocation" })
public void onDraw(Canvas canvas){

if(hit&&counter!=0){
 	
	int srcX = 4*width-30;
	int srcY = getAnimationRow()*height; 
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvas.drawBitmap(bmp,src,dst,null);
	
counter--;	
	
}else{ 
	counter=20;
	hit=false;
	
	
renew();
int srcX = currentFrame*width;
int srcY = getAnimationRow()*height; 
Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
Rect dst = new Rect(x, y, x+width, y+height);
canvas.drawBitmap(bmp,src,dst,null);
}

}


public boolean collide(float x2, float y2) {
	return (x2)>x && (x2)<x +width && (y2)> y && (y2)<y+height;
  
}

public boolean generousCollide(float x2, float y2) {
	return (x2+20)>x && (x2-20)<x +width && (y2+20)> y && (y2-20)<y+height;
  
}

public boolean OPCollide(float x2, float y2) {
	return (x2+30)>x && (x2-30)<x +width && (y2+30)> y && (y2-30)<y+height;
  
}








public void loseHealth(){
	health--; 
	if(health==0);
	deadx=x;
	deady=y;
}

public void loseHealth(double n){
    health-=n;
	if(health==0);
	deadx=x;
	deady=y;
}



public int getHealth(){
	return health;
}



public void moveit(float x4, float y4){
	x=(int)x4;
	y=(int)y4;	
}





public int getdeadx(){
	return deadx;
}

public int getdeady(){
	return deady;
}







public int bmpWidth(){
	return bmp.getWidth();
}




public int bmpHeight(){
	return bmp.getHeight();
}



public int getX(){
	return x;
}


public int getY(){
	return y;
}


public void isHit(boolean hitty){
	hit=hitty;
}

public void setShield(boolean idk){
	hasShield = idk;
}

public boolean hasShield(){
	return hasShield;
}




}
