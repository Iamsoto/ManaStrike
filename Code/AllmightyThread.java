package com.Syndacor.tapattacker;


import android.graphics.Canvas; 

public class AllmightyThread extends Thread{
	private GameView view; 
	private boolean running=false;
	private static final int maFPS = 24; 
	private static int timer=1440; 
	private boolean truth =true;
	private boolean paused;
	
	public AllmightyThread(GameView view){
		this.view = view;
	}
	
    private void checkPaused(){
    	paused = view.checkPause();
    }


	public void setRunning(boolean run){
		running = run;
		
	}
	public boolean isRunning(boolean letruth){
		truth = letruth;
		return truth;
	}
	public boolean getTruth(){
		return truth;
	}
	
	

	public void run(){
		long ticksPS = 1000/maFPS;
		long startTime;
		long napTime;
		
		while(running){	
			checkPaused();
			if(paused==false){
			
			Canvas c = null;
			startTime = System.currentTimeMillis();
			try{
				c= view.getHolder().lockCanvas();
				synchronized(view.getHolder()){
					view.onDraw(c);
				}
			} finally{
				if(c!=null){
					view.getHolder().unlockCanvasAndPost(c);
				}
			}
			napTime = ticksPS-(System.currentTimeMillis()-startTime);
			try{
				if(napTime>0)
					sleep(napTime);
				else
					sleep(1);
			}catch(Exception e){}
			timer --;
		}}
		
		
		}
	
	
	
	public int getTimer(){
		return timer/24;	
		}
	
	public void setTimer(int time){
		timer=time;
	}
	
	
		
	}