package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class LvlSkipper {
private GameView viewy;
private Bitmap image;
boolean pressed=false;
private int x;
private int y;

public LvlSkipper(GameView view, Bitmap bmp){
image = bmp;
viewy = view;


}
	
public boolean pressed(){
	return pressed;
}

public void press(boolean idk){
	pressed=idk;
}


public void onDraw(Canvas canvas){
	canvas.drawBitmap(image, x,y, null);	
}

public boolean generousCollide(float x2, float y2) {
	return (x2+20)>x && (x2-20)<x +image.getWidth() && (y2+20)> y && (y2-20)<y+image.getHeight();
  
}


}
