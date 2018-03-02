package com.Syndacor.tapattacker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/*TODO: the sprite will have 3 columns, four rows.
 * first column, running in
 * second standing
 * third attacking
 * fourth running away
 * 
 * 
 * 
 * 
 */


public class Samurai {
	GameView viewy;
	Bitmap samImage;
	int x;
	int y;
	private int width;
	private int height;
	private int currentFrame;
	boolean atCenter=false;
	int timer = 96; //time til he runs 
	int currentRow =0;
	boolean attacking = false;
	int lvl;
	boolean away;
	int swingCount=3;
	public Samurai(GameView view, Bitmap bmp){
		viewy=view;
		samImage = bmp;
		x = viewy.getWidth()-15;
		y = viewy.getHeight()/2;
		width = samImage.getWidth()/3;
		height = samImage. getHeight()/4;

		
	}
	//running in
    public void renew1(){
    	currentRow=0;
    	x-=2;
    	currentFrame = ++currentFrame%3;
    	if(x+width<=viewy.getWidth()/2){
    		atCenter=true;
    	}
    	 	
    }//the idle one
   public void renew2(){
	   currentRow=1;
	   lvl = viewy.level();
	   currentFrame = ++currentFrame%3;
   }
    //the attacking one
	public void renew3(){
	if(currentFrame!=2){	
		currentRow=2;
		currentFrame =++currentFrame%3;
	}else{
		swingCount--; 
		if(swingCount<=0){
			attacking=false;
			swingCount=3;
		}
	}
		
	}
	
	public void renew4(){
	    
	   if(timer<=0){
		 currentRow =3;
		 x++;
		 currentFrame = ++currentFrame%3;	   
	   }else{
		   currentRow =1;
			timer--;
	   }
	   if(x>= viewy.getWidth()){
		   away=true;
	   }
	   
	}  
	
	public boolean isAway(){
		return away;
	}
	
	public void moveIt(int x2, int y2){
	x=(int)x2;
	y=(int)y2;
		
	}
	
	public int getX(){
		return x+width*currentFrame;
	}
	public int getY(){
		return y+(height*currentRow)/2;
	}
	
	public void setAttacking(boolean idk){
		attacking=idk;
	}
	
	public boolean generousCollide(float x2, float y2) {
		return (x2+20)>x && (x2-20)<x +width && (y2+20)> y && (y2-20)<y+height;
	  
	}
	   
	
	public void onDraw(Canvas canvas){
		  if(!atCenter){
			  renew1();
		  }
		  if(atCenter&&lvl!=6){
			  renew2();  
		  }
		  if(attacking){
			  renew3();
		  }
		  if(lvl==6){
			  renew4();	  
		  } 
		  int srcX = currentFrame*width;
		  int srcY = currentRow*height; 
		  Rect src = new Rect(srcX, srcY, srcX + width, srcY+ height);
		  Rect dst = new Rect(x, y, x+width, y+height);
		  canvas.drawBitmap(samImage,src,dst,null);
		  
		  
		   
	   }
	   
	   
	   
		
	}
	
	
	
	
	
	

