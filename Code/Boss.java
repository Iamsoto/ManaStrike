package com.Syndacor.tapattacker;




import java.util.ArrayList;
import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Boss {
private Bitmap bossImage;
private GameView viewy;
private int height;
private int width;
private int currentFrame;
private int x;
private int y;
private int xSpeed;
private int ySpeed;
private int totalcols=6;
private int totalrows=6;
int[] DIRECTION_TO_ANIMATION_MAP= {3,1,0,2};
Random randy;
private boolean attack=false;
private boolean setTimer=false;
private int counter=200;
private ArrayList<EnergyBall>ball = new ArrayList<EnergyBall>();
//230 health is a good number
private int health=420;
private int ballXSpeed;
private int ballYSpeed;


private boolean isRolling=false;
private int rollingCounter=170;
private boolean exitTimerSet=false;
private float hitX;
private float hitY;
	
	public Boss(GameView view, Bitmap bmp){
    randy = new Random();
    viewy = view;
	bossImage = bmp;
	width = bmp.getWidth()/totalcols;
	height = bmp.getHeight()/totalrows;
	xSpeed = randy.nextInt(4)+1; 
	ySpeed = randy.nextInt(4)+3;
	ballXSpeed = xSpeed +5;
	ballYSpeed = ySpeed +5;
	x= 40;
	y= viewy.getHeight()/2;

	
}
	
	@SuppressLint("DrawAllocation")
	public void onDraw(Canvas canvy){

if(counter<=0&& currentFrame== 5){
	attack=true;
}
if(!isRolling){
if(attack==false){	
	renew();	
	int srcX = currentFrame*width;
	int srcY = getAnimationRow()*height; 
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvy.drawBitmap(bossImage,src,dst,null);
}else{	
	renew2();
	int srcX = currentFrame*width;
	int srcY = 4*height;
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvy.drawBitmap(bossImage,src,dst,null);
		
if(currentFrame==5){
        setTimer=false;

        attack=false;
        counter=100; //this time value doesnt matter. just >0
	}
   }
}else if(isRolling&&!attack){
	renew();	
	int srcX = currentFrame*width;	
	int srcY = 5*height;//This line only thing different on roll 
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvy.drawBitmap(bossImage,src,dst,null);	
	
  }
}

	private void renew2() {
		 currentFrame = ++currentFrame%6;
		
	}

	private int getAnimationRow(){
	     double dirDouble = (Math.atan2(xSpeed,ySpeed)/(Math.PI/2)+2);
	     int direction = (int) Math.round(dirDouble)%4;
	     return DIRECTION_TO_ANIMATION_MAP[direction];  
	}


	
private void renew() {

	
if(!isRolling){
if(x>viewy.getWidth()-width-xSpeed || x+xSpeed<0){
xSpeed = -xSpeed;
}
 x=x+xSpeed;
 
 if(y>viewy.getHeight()-height-ySpeed|| y+ySpeed<0){
	 ySpeed = -ySpeed;
 }
 
 y=y+ySpeed;
 
 currentFrame = ++currentFrame%6; 
 
 if(setTimer==false){
	 counter = randy.nextInt(350)+50;
	 setTimer=true;
 }
 counter--;
 rollingCounter--;
//not sure what this does
 if(rollingCounter<=0){
		rollingCounter+=randy.nextInt(400);
		isRolling=true;
	}
}else if(isRolling){
	if(!exitTimerSet){
		rollingCounter = randy.nextInt(200); 
		exitTimerSet= true;
	}
	rollingCounter--;
	
	if(rollingCounter<=0){
		exitTimerSet=false;
		rollingCounter = 300;
		isRolling=false;	
	}

	
	if(x>viewy.getWidth()-width-ballXSpeed || x+ballXSpeed<0){
		ballXSpeed = -ballXSpeed;
		}
		 x=x+ballXSpeed;
		 
		 if(y>viewy.getHeight()-height-ballYSpeed|| y+ballYSpeed<0){
			 ballYSpeed = -ballYSpeed;
		 }
		 y=y+ballYSpeed;
		 
		 currentFrame = ++currentFrame%6; 	
	
}




 
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	

	
	public ArrayList<EnergyBall> getBalls(){
		return ball;
	}
	

	public void loseHealth(int n){
		health -=n;
	}
	public int getHealth(int n){
		return health;
	}
	
	public boolean isAttacking(){
		return attack;
	}

	public int bmpWidth() {
	
		return width;
	}

	public int bmpHeight() {

		return height;
	}
	
	
public int getHealth(){
	return health;
}


public boolean collide(float x2, float y2) {
	if( (x2)>x+30 && (x2)<x +width-30 && (y2)> y && (y2)<y+height-65.7){
		if(!isRolling){
		hitX=x2;
		hitY =y2;
		return true;
		} return false;
	}
  return false;
}


public float getHitX(){
	return hitX;
}

public float getHitY(){
	return hitY;
}


public void setAttack(boolean idk){
	attack=idk;
}


}
	
	

