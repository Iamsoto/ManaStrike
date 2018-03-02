package com.Syndacor.tapattacker;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Shield {
	private int width;
	private int height;
	private Sprites spritey;
	private int x;
	private int y;
	private int currentFrame;
	private boolean hasSet = false;
	private int counter= 170; //6 seconds 
	private ArrayList<Shield>shield;
	private Bitmap shieldBmp;
	
	public Shield(ArrayList<Shield>noShield,Sprites sprite, Bitmap bmp){
         shield=noShield;
		//divided by 10 for amount of pictures
		width = bmp.getWidth()/10;	
		//might need to be changed
		height = bmp.getHeight();	
		spritey=sprite;
		shieldBmp=bmp;
	}
	
	public void renew(){
		x = spritey.getX();
		y = spritey.getY();
		counter--;
		currentFrame = ++currentFrame%10;
		
		if(hasSet==false){
			spritey.setShield(true);
			hasSet=true;
		}
		
	}
	
	public void onDraw(Canvas canvy){
		
		if(counter>=0){
			renew();
			int srcX = currentFrame*width;
			//might need to change that line of code not sure
			int srcY =currentFrame/10*height; 
			Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
			Rect dst = new Rect(x, y, x+width, y+height);
			canvy.drawBitmap(shieldBmp,src,dst,null);
			
		}else{
			spritey.setShield(false);
			shield.remove(this);
			
			
		}
		
		checkShield();
		
		
	}

	private void checkShield() {
		if(!spritey.hasShield()){
			shield.remove(this);
		}
		
	}
	
	
	

}
