package com.Syndacor.tapattacker;




import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
AllmightyThread loopy;
MediaPlayer mp;
MediaPlayer mp2;
MediaPlayer mp3;
MediaPlayer mp4;
MediaPlayer mp5;
MediaPlayer mp6;
GameView view;
String MY_SCORE_KEY = ""+18;
String MY_LEVEL_KEY = ""+25; 
int HighScore;
int currentScore;
LevelManager lvly;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        mp = MediaPlayer.create(this, R.raw.newbeginning2);
        mp2 = MediaPlayer.create(this, R.raw.main2);
        mp3 = MediaPlayer.create(this, R.raw.evilback);
        mp4 = MediaPlayer.create(this, R.raw.newdead);
        mp5 = MediaPlayer.create(this, R.raw.bossmusic);
        mp6 = MediaPlayer.create(this,R.raw.beginningmusic);
        view= new GameView(this);
        loopy = view.getLoop();
        view.setMusic(mp,mp2,mp3,mp4,mp5,mp6);
        setContentView(view);     
//attempting to read save
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        HighScore = myPrefs.getInt(MY_SCORE_KEY, 0);
        view.HighestScore(HighScore);
        lvly = view.getLvly();        
        view.setSaveStuff(myPrefs);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
       
    }
    
    

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @SuppressWarnings("deprecation")
	public void onBackPressed(){
    	super.onBackPressed();	
    	SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
    	SharedPreferences.Editor prefsEditor = myPrefs.edit();
   //saves score
    	currentScore = view.getScore();
    	if(currentScore>HighScore){	
    	prefsEditor.putInt(MY_SCORE_KEY, currentScore);
    	prefsEditor.commit();
    	HighScore = currentScore;
    	view.HighestScore(HighScore);
          }
   //saves Level
     	prefsEditor.putInt(MY_LEVEL_KEY, lvly.getcurrentLevel());
    	prefsEditor.commit();
    	   	
    	finish();  
    	System.exit(0);
    }
 
    protected void onPause(){
    	super.onPause();
//don't touch    	
    	view.pauseMusic();    	
    	view.isPaused(true);
    	view.pause();
    	Intent intent = new Intent(Intent.ACTION_MAIN);
    	intent.addCategory(Intent.CATEGORY_HOME);
    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	startActivity(intent);
    	//save stuff here		
    }
    
       protected void onStop(){
        super.onStop();
    	SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
    	SharedPreferences.Editor prefsEditor = myPrefs.edit();
    currentScore = view.getScore();
    	if(currentScore>HighScore){	
   //saves score again 	
    	prefsEditor.putInt(MY_SCORE_KEY, currentScore);
    	prefsEditor.commit();
       	HighScore = currentScore;
    	view.HighestScore(HighScore);
        }
  //saves level again  	
     	prefsEditor.putInt(MY_LEVEL_KEY, lvly.getcurrentLevel());
    	prefsEditor.commit();	
        
    }
  
     protected void onResume(){
    	 super.onResume();
    	 
    	 view.isPaused(false);
    	 view.resume();
     }
     
      protected void onDestroy(){
    	   super.onDestroy();
    	   
    		finish();
        	System.exit(0);
       }


}
