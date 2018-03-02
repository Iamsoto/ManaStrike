package com.Syndacor.tapattacker;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class CinimaticScene {
	
	private GameView viewy;
	Bitmap pic;
	public boolean end = false;
	private double width;
	private double height;
    private int y;
    private int x;
    private boolean reached = false;
    private int counter=72;
    private boolean stared=false;
    private Bitmap eye;
    private int columns = 7;
    private int picHeight;
    private int picWidth;
    private int x2;
    private int y2;
    private int currentFrame;
    private boolean startEye;
	
	
	public CinimaticScene(GameView view, Bitmap bmp, Bitmap bmp2){
		pic=bmp;
		eye=bmp2;
		viewy = view; 
		width = viewy.getWidth();
		height = viewy.getHeight();
		x =(int) width/2-pic.getWidth()/2;
		y =(int)height-30;
		
		picWidth = eye.getWidth()/columns;
		picHeight = eye.getHeight();
		x2 = viewy.getWidth()/2-picWidth/2;
		y2 = viewy.getWidth()/2-picHeight/2;
		
	}



public void	onDraw(Canvas canvy){
if(!startEye){
	if(!reached&& !stared){
	renew();
 }else if(reached && !stared){
	 renew2();
 }else if(reached && stared){
	 renew3();
 }
   canvy.drawBitmap(pic, x, y,null);
}else{
	renew4();
	int srcX = currentFrame*picWidth;
	int srcY = currentFrame/7*picHeight;
	Rect src = new Rect(srcX+10, srcY, srcX + picWidth, srcY+ picHeight);
	Rect dst = new Rect((int) x2, (int) y2, (int) y2+picWidth, (int)y2+picHeight);
	canvy.drawBitmap(eye,src,dst,null);
	
}
   
}

private void renew4() {
	currentFrame++;
	x-=10;
	if(currentFrame >= columns){
		end=true;
	}
	
}



private void renew3() {
 y+=3;
 if(y>=height){
	 startEye=true;
 }
	
}



private void renew2() {
	counter--;
	if(counter<=0){
		stared=true;
	}
	
}

private void renew() {
 y --;
 if(y-pic.getHeight()*.1<=height/2){
	reached= true; 
 }
 
	
}


public boolean hasEnded(){
	return end;
}

public boolean isBlinking(){
	return startEye;
}
	
	
}
