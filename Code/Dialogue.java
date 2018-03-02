package com.Syndacor.tapattacker;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Dialogue {
private Bitmap text1;
private Bitmap text2;
private Bitmap text3;
private Bitmap text4;
private Bitmap text5;
private Bitmap text6;
private Bitmap text7; 
private SpecialSprite specially; 
private List<Dialogue>texty;
private int counter = 2000;
private boolean removed=false;


public Dialogue(List<Dialogue>text,Bitmap bmp1, SpecialSprite whee){
texty=text;
text1=bmp1;
specially=whee;
	
}
	
	
	
public void	onDraw(Canvas canvy){
	renew();
	int x = specially.getX();
	int y = specially.getY();	
	canvy.drawBitmap(text1, x+10, y-40, null);
	
		
	}



private void renew() {
counter--;
	if(counter<=0){
		texty.remove(this);
	}
	
}
	
	
private void setCounter(int c){
	counter=c;
}
	
	
	
}