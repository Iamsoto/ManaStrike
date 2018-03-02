package com.Syndacor.tapattacker;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Talk {

	private ArrayList<Bitmap> sayList;//the different dialogues
	private Sprites person;//the sprite bound to sayList;
	private int index;//holds a random index number for sayList
	private int count;//how long the duration between actions
	private int display;//counter of the frames in the display
	private int sayTime = 72;//the amount of frames the character "speaks"
	private boolean sayingSomething;//whether person is "saying" dialogue
	private Random randy;
	private int x;
	private int y;
	public Talk(ArrayList<Bitmap> bmp, Sprites spr){
		randy = new Random();
		sayList = bmp;
		person = spr;
		count = randy.nextInt(900)+200;
		display = 0;
		sayingSomething = false;
		
	}
	
	private void generate(int size){
		index = randy.nextInt(size);
	}
	
	//10 seconds for each saying
	public void onDraw(Canvas canvas){
		if(person!=null){
		renew();
		if(sayingSomething){
			canvas.drawBitmap(sayList.get(index), x+15, y-40, null);
		}
		display++;
		if(display > count){
			generate(sayList.size());
			display = 0;
			nextAction();
		}
		}
	}
	
	
	private void renew() {
		x=person.getX();
		y=person.getY();
		
	}

	//the decides what to do and for how long
	private void nextAction(){
		if(sayingSomething){
			count = randy.nextInt(900)+200;
		}
		else{
			count = sayTime;
		}
		
		sayingSomething = !sayingSomething;
		
	}
	
	
}


