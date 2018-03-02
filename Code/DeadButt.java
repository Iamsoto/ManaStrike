package com.Syndacor.tapattacker;

import java.util.List;
import android.graphics.Bitmap;
import android.graphics.Canvas; 
public class DeadButt {
private float y;
private float x;
private Bitmap bit; 
private int time = 25; 
private List<DeadButt> dead; 

public DeadButt (List<DeadButt> dead, GameView viewy, float x, float y, Bitmap bit){

this.x = Math.min(Math.max(x-bit.getWidth()/2, 0),viewy.getWidth() - bit.getWidth());
this.y = Math.min(Math.max(y-bit.getHeight()/2, 0), viewy.getHeight()- bit.getHeight());

this.bit = bit; 
this.dead = dead; 
}
public void onDraw(Canvas canvas){
	renew();
	canvas.drawBitmap(bit, x,y,null);
}

public void renew(){
	if(--time<1){
		dead.remove(this);
	}
}
	
	
}