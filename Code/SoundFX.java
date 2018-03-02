package com.Syndacor.tapattacker;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public class SoundFX {
	private SoundPool soundPool;
	private int[] soundID;
	private boolean loaded = false;
	
	
	  public SoundFX(Context context) {
		  
		    // Set the hardware buttons to control the music
			  //mAudioManager;
			  //mAudioManager.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		    
			  //Amount of sounds to be played
			  //Has to be hardcoded at this point
			  soundID = new int[13];
			  
		    // Load the sound
		    soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		    
		    soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
		      public void onLoadComplete(SoundPool soundPool, int sampleId,
		          int status) {
		        loaded = true;
		      }
		    });
		    
		   //fire
		    soundID[0] = soundPool.load(context, R.raw.fire, 1);
		    //water 
		    soundID[1] = soundPool.load(context, R.raw.water, 1);
		    //air
		    soundID[2] = soundPool.load(context, R.raw.thunder, 1);
		    //earth
		    soundID[3] = soundPool.load(context, R.raw.earth, 1);
            // ill make this bubble
		    soundID[4] = soundPool.load(context, R.raw.bubbleshield, 1);
		    //ill make this stabbing noise
		    soundID[5] = soundPool.load(context, R.raw.ninjastab, 1);
		    
		    soundID[6] = soundPool.load(context, R.raw.dead1, 1);
		    soundID[7] = soundPool.load(context, R.raw.dead2, 1);
		    soundID[8] = soundPool.load(context, R.raw.dead3, 1);
		    soundID[9] = soundPool.load(context, R.raw.owie2, 1);
		    
		    soundID[10] = soundPool.load(context, R.raw.samstab, 1);
		    soundID[11] = soundPool.load(context, R.raw.explosion, 1);
		    soundID[12] = soundPool.load(context, R.raw.robotalk, 1);
	  }
	  
	  public void play(int n) {

		  // Is the sound loaded already?
		  if (loaded) {
			  
			  
             if(n ==0 || n==1 ||n==2 ||n==3){
				  soundPool.play(soundID[n],	//which sound to play
						  1f,				//left volume 	(0.0f to 1.0f)
						  1f,				//right volume 	(0.0f to 1.0f)
						  1,				//priority		(0 = lowest)
						  0,				//loop
						  1.5f);			//playback rate (0.5f to 2.0f, 1.0f = normal
             }else{            	 
            	 soundPool.play(soundID[n],	//which sound to play
						  .6f,				//left volume 	(0.0f to 1.0f)
						  .6f,				//right volume 	(0.0f to 1.0f)
						  1,				//priority		(0 = lowest)
						  0,				//loop
						  1.5f);			//playback rate (0.5f to 2.0f, 1.0f = normal
            	 
            	 
             }
             
		  }
	  }
	  
}
