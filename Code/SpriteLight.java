package com.Syndacor.tapattacker;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpriteLight {
private float myx;
private float myy;
private Bitmap mybitty;
private final int NUM_COLS =2;
private final int NUM_ROWS =1;
private int frame;
private int width;
private int height;
private int counter=0;
private ArrayList<SpriteLight> light;
	
	public SpriteLight(ArrayList<SpriteLight>lighty ,GameView viewy, float x, float y, Bitmap bitty){
	 
		mybitty = bitty;
		width = mybitty.getWidth()/NUM_COLS;
		height = mybitty.getHeight()/NUM_ROWS;
		light= lighty;
		
		myx = x-width/2-10;
		myy =y-height/2;
	}
	
	public void renew(){
		frame = ++frame%NUM_COLS;
		
	}
	
	
	
	@SuppressLint({ "DrawAllocation", "DrawAllocation" })
	public void  onDraw(Canvas canvas){
		renew();
		int srcX = frame*width;
		int srcY = frame/2*height;
		Rect src = new Rect(srcX, srcY, srcX + width-5, srcY+ height);
		Rect dst = new Rect((int) myx, (int) myy, (int) myx+width+50, (int)myy+height);
		canvas.drawBitmap(mybitty,src,dst,null);
		counter++;
		if(counter>=5){
			light.remove(this);
		}
	} 
	
	
}