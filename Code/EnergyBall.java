package com.Syndacor.tapattacker;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class EnergyBall {
	
	private int x;
	private int y;
	private GameView viewy;
	private Canvas canvy;
	private int radius=1;
	private boolean maxRad=false;
	private int xSpeed; 
	private int ySpeed;
	private boolean dead=false; 
	private ArrayList<EnergyBall>eball = new ArrayList<EnergyBall>();
	private int counter; 
	private Paint paint;
	private int color;
	private Bitmap ballImage;
	private int width;
	private int height;
	private int ballCounter = 5;
	private int currentFrame;
	private boolean hit = false;
	

	public EnergyBall(ArrayList<EnergyBall> ball,GameView view, int X, int Y, Bitmap bmp){
		Random randy = new Random();
		x=X+30;
		y=Y+40;
		viewy=view;	
	    if(randy.nextInt(100)>50){
		xSpeed=-6;
	    }else
	    xSpeed=randy.nextInt(6)+1;
	    
	    ySpeed=randy.nextInt(6)+1;
		eball=ball;
      
		ballImage = bmp;
		width = ballImage.getWidth()/8;
		height = ballImage.getHeight();
		counter = randy.nextInt(180);
		
	}
	
	public void renew(){
		if(ballCounter>=0){
			ballCounter -=1;	
		}else{
		
			if(x>viewy.getWidth()-width-xSpeed || x+xSpeed<=0){
				xSpeed = -xSpeed;
				}
				 x=x+xSpeed;
				 
				 if(y>viewy.getHeight()-height-ySpeed|| y+ySpeed<=0){
					 ySpeed = -ySpeed;
				 }
				 
				 y=y+ySpeed;
				 if(!dead&&!hit){
				 currentFrame = ++currentFrame%5;
				 }
				 if(dead||hit){
					 currentFrame++;
				 }
				 
				 if(counter>=0||hit){
						counter--;
						if(counter<=0){
							dead=true;
						}
					}
	          	} 
	
		
	
	}
		
	//TODO: not sure if this drawing theory will work
	public void onDraw(Canvas canvy){
	renew();
	
	if(dead&&currentFrame==7){
		eball.remove(this);
	}
	if(hit&&currentFrame==7){
		eball.remove(this);
	}
	
	
	int srcX = currentFrame*width;
	int srcY =currentFrame/8*height; 
	Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
	Rect dst = new Rect(x, y, x+width, y+height);
	canvy.drawBitmap(ballImage,src,dst,null);
	
	
	
	
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void hit(boolean idk){
		hit =idk;
	}
	
}
