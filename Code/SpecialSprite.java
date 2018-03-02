package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpecialSprite {
private Bitmap character;
private int x;
private int y;
private GameView viewy;
private int width;
private int height;
private int frame;
private int currentFrame;
private boolean middle;
private boolean cutscene=false; 
private boolean over=false; 	
	
	public SpecialSprite(GameView view, Bitmap bmp){
		this.viewy=view;
		this.character=bmp;
		this.width = bmp.getWidth()/3;
		this.height = bmp.getHeight()/ 2;
		
		xPosition(viewy.getWidth(),width);
		yPosition(viewy.getHeight());
		
		
	}
	
	
	private void yPosition(int scrnHeight) {
		y=scrnHeight/2;
		
	}


	private void xPosition(int scrnWidth, int bmpWidth) {
		x=(int)(scrnWidth-bmpWidth);
	}


	public void onDraw(Canvas canvas){
		if(middle==false){
		renew();
		int srcX = currentFrame*width;
		int srcY = 1*height; 
		Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
		Rect dst = new Rect(x, y, x+width, y+height);
		canvas.drawBitmap(character,src,dst,null);
	}
		
		if(middle&&viewy.isDialogueComplete()==false){
			renew2();
			int srcX = currentFrame*width;
			int srcY = 0*height; 
			Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
			Rect dst = new Rect(x, y, x+width, y+height);
			canvas.drawBitmap(character,src,dst,null);
			
		}else if(middle&&viewy.isDialogueComplete()){
			renew();
			int srcX = currentFrame*width;
			int srcY = 1*height; 
			Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
			Rect dst = new Rect(x, y, x+width, y+height);
			canvas.drawBitmap(character,src,dst,null); 	
		 //Determines the distance the sprite is before cutscene ends
			if(x<=viewy.getWidth()*.05){
				over=true;
			}
		
		
		}
		
		
		
	}


	private void renew2() {
		currentFrame =++currentFrame%3;
		
	}


	private void renew() {
        x-=1;
        currentFrame = ++currentFrame%3; 
		if(x<=viewy.getWidth()/2){
			middle=true;
		}
	}
	
	public boolean isInMiddle(){
		return middle;
	}
	
	public int getX(){
		return x;
	}
	

	
	public boolean isCutscene1(){
		return true;
	}
	
	public void setCutscene1(boolean truth){
		cutscene = truth;
	}


	public int getY() {
		return y;
	}

// im actually not sure what this does
    public boolean isOver(){
    	return over;
    }
	
	
	
	
	
	
}
