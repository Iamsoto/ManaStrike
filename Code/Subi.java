package com.Syndacor.tapattacker;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class Subi {
	private GameView viewy;
	private Bitmap image;
	private int x;
	private int y;
	private int currentFrame; 
	private Random randy; 
	private int width;
	private int height;
	private boolean flying = true;
	private ArrayList<Subi>subis = new ArrayList<Subi>();
	private float totalWidth;
	private float totalHeight;
	private int xSpeed;
	 
	public Subi(float x2,float y2, Bitmap bmp, ArrayList<Subi>stars){
    totalWidth = x2;
    totalHeight = y2;
    image = bmp; 
    randy = new Random();
	y = randy.nextInt((int) (totalHeight - image.getHeight()));
	x = 0; 	
	width = image.getWidth()/5;
	height = image.getHeight();
	subis=stars;
	xSpeed = randy.nextInt(7)+1;
	}
	
	public void renew1(){
		x+=xSpeed;  
		currentFrame =++currentFrame%5;
		if(x>totalWidth)
			subis.remove(this);
				
	}
	
	public void renew2(){
		y+=25; 
		if(y>totalHeight)
			subis.remove(this);
	}
	
	public void knockOut(){
		flying = false;
	}
	
	public void onDraw(Canvas canvas){
		if(flying){
			renew1();
		}else{
			renew2();
		}
		int srcX = currentFrame*width;
		int srcY = currentFrame/5*height;
		Rect src = new Rect(srcX, srcY, srcX + width-5, srcY+ height);
		Rect dst = new Rect((int) x, (int) y, (int) x+width+50, (int)y+height);
		canvas.drawBitmap(image,src,dst,null);
		
		
		
		
	}
	
	public boolean isFlying(){
		return flying;
	}
	
	public int getX(){
	return x;
	}
	public int getY(){
	return y;
	}
	
	public int bmpWidth(){
		return width;
	}
	
	public int bmpHeight(){
		return height;
	}
	
	public boolean generousCollide(float x2, float y2) {
		return (x2+25)>x && (x2-15)<x +width && (y2+15)> y && (y2-15)<y+height;
	  
	}

	
}