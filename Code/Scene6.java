package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Scene6 {
private Bitmap sprite;
private int x;
private int y;
private int height;
private int width;
private int COLS = 3;
private int ROWS = 2;
private boolean isThere= false;
private boolean over = false;
private GameView viewy;
private int currentFrame; 
private int currentRow;
private Bitmap bossImage;
private boolean completed=false; 
private int counter = 48; 
private boolean ended = false;

public Scene6(GameView view, Bitmap bmp, Bitmap bmp2){
	sprite = bmp;
	viewy = view;
	y = viewy.getHeight()/2; 
	x = 2;	
	width = sprite.getWidth()/COLS;
	height = sprite.getHeight()/ROWS;
	bossImage = bmp2;
	
		
}


private void renew1(){
	currentFrame = ++currentFrame%COLS; 
	x++;
	if(x>=viewy.getWidth()/4){
	    isThere = true;
	    currentRow++;
	}
}


public void renew2(){
	currentFrame = ++currentFrame%COLS; 
	
}

public void SetdialogueComplete(boolean idk){
	completed = idk;
}

public void onDraw(Canvas canvy){
if(!completed){
	if(!isThere){
		renew1();	
	}else if(isThere){
		renew2();				
		
	}
	int srcX = currentFrame*width;
	int srcY = currentRow*height;
	Rect src = new Rect(srcX, srcY, srcX + width-5, srcY+ height);
	Rect dst = new Rect((int) x, (int) y, (int) x+width, (int)y+height);
	canvy.drawBitmap(sprite,src,dst,null);
	
	
}else if(completed){
	canvy.drawBitmap(bossImage,x,y,null);
	counter--;
	if(counter <=0){
		ended=true;
	}
  }

}

public boolean hasReached(){
	return isThere;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public boolean hasEnded(){
	return ended;
}
	
	
}
