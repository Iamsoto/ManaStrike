package com.Syndacor.tapattacker;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Credits {
	private int currentPic=0;
	private int waitTime = 144 ;
	private int counter;
	private ArrayList<Bitmap>credits; 
	
	
	public Credits(ArrayList<Bitmap> bmps){
		credits=bmps;
		counter=waitTime;
			
	}
	
	public void renew(){
		counter--;
		if(counter<=0){
			currentPic++;
			counter=waitTime;
		}
	}
		
     public void onDraw(Canvas canvy){
    	if(currentPic<credits.size()-1) 
    	 renew();
    	
    	 canvy.drawBitmap(credits.get(currentPic),0,0, null);
    	 
     }
		
		
		
	
	
	
	

}
