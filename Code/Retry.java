package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Retry {
	
	private GameView viewy;
	private Bitmap button;
	private float x;
	private int y;
	private int width;
	private int height;
	private int frame;
	private boolean clicked=false;

	
	public Retry( GameView view, Bitmap bmp){
	 
		viewy=view;
		button = bmp;
		width = button.getWidth()/2;
		height=button.getHeight();
		x= (float)(viewy.getWidth()/2 - width/2);
		y= (int)(viewy.getHeight()*.5);
			
	}
	
	public boolean generousCollide(float x2, float y2) {
		return (x2+15)>x && (x2-15)<x +width && (y2+15)> y && (y2-15)<y+height;
	  
	}
	
	public void click(){
		frame++;
		if(frame>=2){
			clicked =true;	
			}

	}
	
	public void onDraw(Canvas canvas){
		int srcX = frame*width;
		int srcY = frame/2*height;
		
		Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
		Rect dst = new Rect((int) x, (int) y, (int) x+width, (int)y+height);
		canvas.drawBitmap(button,src,dst,null);
	
	}
	
	
	

	public boolean getClicked() {
	
		return clicked;
	}

    public void setX(int x2){
    	x=x2;
    }
    
    public void setY(int y2){
    	y=y2;
    }
	

}
