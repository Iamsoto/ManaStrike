package com.Syndacor.tapattacker;

import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Ninja1 {
private static final int BMP_COLUMNS = 4;
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
private int health; 
private boolean pickedup;
private int pickcounter =60;
private int hitCounter = 6;

private int deadx;
private int deady;
private Random randy = new Random();

private boolean killFrame=true; 
private int counting = 20; 
private boolean hit = false;


public Ninja1(GameView viewy, Bitmap bmp, LevelManager level){
	this.viewy=viewy;
	this.bmp=bmp;
	this.width = bmp.getWidth() / 4;
	this.height = bmp.getHeight() / BMP_ROWS; 

	xSpeed = randy.nextInt(viewy.level()+3)+1; 
	ySpeed = randy.nextInt(viewy.level()+3)+1;
	//x and y position methods based on level
	xPosition(viewy.getWidth(),width);
	yPosition(viewy.getHeight(),height);
	health= 3+viewy.level();

}


public void xPosition(int scrnWidth, int bmpWidth){
//spawn at sides if lvl 1 or 3
if(viewy.level()==1||viewy.level()==3){	
	if(randy.nextInt(100)>=50){
		x= 1;	
	}else
		x= (int)(scrnWidth-bmpWidth);	
}

//spawn onTop if lvls 2 or 4
if(viewy.level()==2||viewy.level()==4){	
   
	x = randy.nextInt(scrnWidth-bmpWidth);
}

//spawn to side if lvl 5
if(viewy.level()==5){	
	x = 1;
	}


}


public void yPosition(int scrnHeight, int bmpHeight){
	//if lvl 1 or 3 spawn at sides
if(viewy.level()==1||viewy.level()==3){
y = randy.nextInt(scrnHeight-bmpHeight);
	
}
//if lvl 2 or 4, spawn at top	
if(viewy.level()==2||viewy.level()==4){	
	if(randy.nextInt(100)>=50){
		y= 1;	
	}else
		y= (int)(scrnHeight-bmpHeight);
       }
//I know it's the same as lvls 1 and 3
if(viewy.level()==5){
	y = randy.nextInt(scrnHeight-bmpHeight);
}

}

public void hit(boolean idk){
	hit=idk;
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

if(killFrame&&counting!=0){
	int srcX = 4*width-30;
	int srcY = getAnimationRow()*height; 
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvas.drawBitmap(bmp,src,dst,null);
	counting--;
	
}else{
killFrame=false;
counting=20;

renew();
int srcX = currentFrame*width;
int srcY = getAnimationRow()*height; 
Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
Rect dst = new Rect(x, y, x+width, y+height);

canvas.drawBitmap(bmp,src,dst,null);
}
if(pickedup){
	pickcounter--;
	
	if(pickcounter<=60){
		pickedup=false;
		pickcounter=60;
	}


	
	
}





}



public void setKillFrame(boolean killy){
	killFrame = killy;
	
}

public boolean collide(float x2, float y2) {
	return (x2+7)>x && (x2-7)<x +width && (y2+7)> y && (y2-7)<y+height;
  
}

public boolean generousCollide(float x2, float y2) {
	return (x2+20)>x && (x2-20)<x +width && (y2+20)> y && (y2-20)<y+height;
  
}


public void loseHealth(){
	health--; 
	if(health<=0);
	deadx=x;
	deady=y;
}

public void loseHealth(int n){
	for(;n>0; n--){
		health--;
	}
	 
	if(health<=0);
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
	return width;
}




public int bmpHeight(){
	return height;
}



public int getX(){
	return x;
}


public int getY(){
	return y;
}

public boolean getPickedup(){
	return pickedup;
}

public void setPickedup(Boolean picky){
	
	pickedup=picky;
}

public void setPickcounter(){
	pickcounter= 60;
}




}