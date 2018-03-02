package com.Syndacor.tapattacker;

import java.util.List;
import android.graphics.Bitmap;
import android.graphics.Canvas; 
public class Sprite2 {
private float y;
private float x;
private Bitmap bit; 
private int time = 20; 
private List<Sprite2> blood; 

public Sprite2 (List<Sprite2> blood, GameView viewy, float x, float y, Bitmap bit){

this.x = Math.min(Math.max(x-bit.getWidth()/2, 0),viewy.getWidth() - bit.getWidth());
this.y = Math.min(Math.max(y-bit.getHeight()/2, 0), viewy.getHeight()- bit.getHeight());

this.bit = bit; 
this.blood = blood; 
}
public void onDraw(Canvas canvas){
	renew();
	canvas.drawBitmap(bit, x,y,null);
}

public void renew(){
	if(--time<1){
		blood.remove(this);
	}
}
	
	
}