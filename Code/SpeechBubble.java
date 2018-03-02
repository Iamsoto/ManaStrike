package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpeechBubble {
GameView viewy;
Bitmap bubbleimage;
int x;
int y;
	
	public SpeechBubble(GameView view, Bitmap bmp ){
		viewy = view;
		bubbleimage = bmp;
	}
	public void setX(int x2){
		x=x2;
	}
	
	public void sety(int y2){
		y=y2;
	}
	
	public void onDraw(Canvas canvy){
		canvy.drawBitmap(bubbleimage, x,y,null);
		
		
	}
	
	
}
