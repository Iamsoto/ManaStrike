package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Circle {
private GameView viewy;
private Bitmap greenCirc;
Elements elly;
private double x;
private double y;

	public Circle(GameView view,Bitmap bmp,Elements ell ){	
	viewy = view; 
	greenCirc=bmp; 
	elly=ell;
	
				
	}
	
	public void renew(){
		if(elly.getEllyX()<x){
		x -=10;
		if(x<elly.getEllyX()){
			x=elly.getEllyX();
		}
		}
		
		if(elly.getEllyX()>x){
			x +=10;
			if(x>elly.getEllyX()){
				x=elly.getEllyX();
			}
			}
		y=elly.getYpos();
			
	}
	
	
	
	
	public void onDraw(Canvas canvy){
		renew();
		if(x!=0){
			canvy.drawBitmap(greenCirc,(int)x,(int)y, null);
		}
		
		
		
		
	}
	
	
	
	
	
	
		
	
	
}