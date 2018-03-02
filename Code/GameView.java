package com.Syndacor.tapattacker;

/*
 *  Lead Programmer: Brian Soto
 *  Artists: Nicolas Pilowski, Nicole Soto
 *  Audio: Various Artists
 *  Special Thanks to: Ean Newton, Arjun Teh
 *  S ~ Y ~ N ~ D ~ A ~ C ~ O ~ R ~ E  
 *       
 * ======================================
 * Roughly 100++ hours spent on my end alone
 * This is officially my first android game =D 
 * To anyone working with this code I apologize in advanced. It's really messy 
 * I'd like to thank everyone who helped with the creation of this game.  
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;




public class GameView extends SurfaceView {
  
  
  //custom classes
	private SurfaceHolder holder;
	private AllmightyThread gameLoop; 
	private Elements elly;
	private Paint paint = new Paint();
	private Paint paint2 =new Paint();
	private Paint paint3 = new Paint();
	private LevelManager lvly;
	private Circle circle;
	private Samurai samurai;
	private CinimaticScene playScene;
	private Context contexty; 
	private SoundFX sfx;
	private Scene6 playScene6;
	SharedPreferences myPrefs;
	private Credits playCredits;
	//music is here
	MediaPlayer mp;
	MediaPlayer mp2;
	MediaPlayer mp3;  
	MediaPlayer mp4;
	MediaPlayer mp5;
	MediaPlayer mp6;
	MediaPlayer permMusic1;
	MediaPlayer permMusic2;
	MediaPlayer permMusic3;
	MediaPlayer permMusic4;
	MediaPlayer permMusic5;
	MediaPlayer permMusic6;
	//Arrays and Bitmaps
	private ArrayList<Dialogue>      text= new ArrayList<Dialogue>();
	private ArrayList<Sprites>       spritely = new ArrayList<Sprites>();
	private ArrayList<Sprite2>       blood = new ArrayList<Sprite2>();
	private ArrayList<SpriteLight>   light = new ArrayList<SpriteLight>();
	private ArrayList<SpriteLight>   flash = new ArrayList<SpriteLight>();
	private ArrayList<Shield>        shield = new ArrayList<Shield>();
	private ArrayList<DeadButt>      dead = new ArrayList<DeadButt>();
	private ArrayList<DeadButt>      deadPrince = new ArrayList<DeadButt>(); 
	private ArrayList<Ninja1>        ninja = new ArrayList<Ninja1>();
	private ArrayList<Ninja1>        ninja2 = new ArrayList<Ninja1>();
	private ArrayList<Ninja1>        ninja3 = new ArrayList<Ninja1>();
	private ArrayList<Ninja1>        ninja4 = new ArrayList<Ninja1>();
	private ArrayList<Retry>         retry = new ArrayList<Retry>();
	private ArrayList<Retry>         starty = new ArrayList<Retry>();
	private ArrayList<Retry>         newy = new ArrayList<Retry>();
	private ArrayList<SpecialSprite> specially = new ArrayList<SpecialSprite>();
    private ArrayList<EnergyBall>    ball = new ArrayList<EnergyBall>();
	private ArrayList<Boss>          boss = new ArrayList<Boss>();
    private ArrayList<Bitmap>        Dialogue2 = new ArrayList<Bitmap>();  
	private ArrayList<Bitmap>        talk1 = new ArrayList<Bitmap>();
	private ArrayList<Bitmap>        talk2 = new ArrayList<Bitmap>();
	private ArrayList<Bitmap>        talk3 = new ArrayList<Bitmap>();
	private ArrayList<Bitmap>        talk4 = new ArrayList<Bitmap>();
	private ArrayList<Bitmap>        credits=new ArrayList<Bitmap>();
	private ArrayList<Talk>          convo = new ArrayList<Talk>();
    private ArrayList<Ninja1>        ninja5 = new ArrayList<Ninja1>();         
    private ArrayList<Ninja1>        ninja6 = new ArrayList<Ninja1>(); 
    private ArrayList<Subi>          stars = new ArrayList<Subi>();
    
    private Bitmap bossImage = BitmapFactory.decodeResource(getResources(), R.drawable.androidboss);
	private Bitmap back1= BitmapFactory.decodeResource(getResources(), R.drawable.cherryback);
    private Bitmap back2= BitmapFactory.decodeResource(getResources(), R.drawable.snow);
    private Bitmap back3= BitmapFactory.decodeResource(getResources(), R.drawable.desert);
    private Bitmap back4= BitmapFactory.decodeResource(getResources(), R.drawable.castle);
    private Bitmap back5= BitmapFactory.decodeResource(getResources(), R.drawable.stalight);
	private Bitmap ellyBar= BitmapFactory.decodeResource(getResources(), R.drawable.elementcircles2);
	private Bitmap button = BitmapFactory.decodeResource(getResources(), R.drawable.nicoretry);
	private Bitmap greencircle = BitmapFactory.decodeResource(getResources(), R.drawable.ring);
	private Bitmap text1 = BitmapFactory.decodeResource(getResources(), R.drawable.speech1);
	private Bitmap text2 = BitmapFactory.decodeResource(getResources(), R.drawable.speech2);
	private Bitmap text3 = BitmapFactory.decodeResource(getResources(), R.drawable.speech3);
	private Bitmap text4 = BitmapFactory.decodeResource(getResources(), R.drawable.speech4);
	private Bitmap text5 = BitmapFactory.decodeResource(getResources(), R.drawable.speech5);
	private Bitmap text6 = BitmapFactory.decodeResource(getResources(), R.drawable.speech6);
	private Bitmap text7 = BitmapFactory.decodeResource(getResources(), R.drawable.speech7);	
   	
	
	
	private Bitmap pinkTalk1 = BitmapFactory.decodeResource(getResources(), R.drawable.p1);	
   	private Bitmap pinkTalk2 = BitmapFactory.decodeResource(getResources(), R.drawable.p2);	
   	private Bitmap pinkTalk3 = BitmapFactory.decodeResource(getResources(), R.drawable.p3);	
   	private Bitmap pinkTalk4 = BitmapFactory.decodeResource(getResources(), R.drawable.p4);	
   	private Bitmap pinkTalk5 = BitmapFactory.decodeResource(getResources(), R.drawable.p5);	
   	private Bitmap pinkTalk6 = BitmapFactory.decodeResource(getResources(), R.drawable.p6);	
   	private Bitmap pinkTalk7 = BitmapFactory.decodeResource(getResources(), R.drawable.p7);	
   	private Bitmap pinkTalk8 = BitmapFactory.decodeResource(getResources(), R.drawable.p8);	
    private Bitmap iceTalk1 =BitmapFactory.decodeResource(getResources(), R.drawable.i1);	
    private Bitmap iceTalk2 =BitmapFactory.decodeResource(getResources(), R.drawable.i2);	
    private Bitmap iceTalk3 =BitmapFactory.decodeResource(getResources(), R.drawable.i3);	
    private Bitmap iceTalk4 =BitmapFactory.decodeResource(getResources(), R.drawable.i4);
    private Bitmap iceTalk5 =BitmapFactory.decodeResource(getResources(), R.drawable.i5);	
    private Bitmap iceTalk6 =BitmapFactory.decodeResource(getResources(), R.drawable.i6);	
    private Bitmap iceTalk7 =BitmapFactory.decodeResource(getResources(), R.drawable.i7);	
    private Bitmap desertTalk1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
    private Bitmap desertTalk2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
    private Bitmap desertTalk3 = BitmapFactory.decodeResource(getResources(), R.drawable.d3);
    private Bitmap desertTalk4 = BitmapFactory.decodeResource(getResources(), R.drawable.d4);
    private Bitmap desertTalk5 = BitmapFactory.decodeResource(getResources(), R.drawable.d5);
    private Bitmap desertTalk6 = BitmapFactory.decodeResource(getResources(), R.drawable.d6);
    private Bitmap desertTalk7 = BitmapFactory.decodeResource(getResources(), R.drawable.d7);
    private Bitmap desertTalk8 = BitmapFactory.decodeResource(getResources(), R.drawable.d8);
    private Bitmap castleTalk1 = BitmapFactory.decodeResource(getResources(), R.drawable.c1);
    private Bitmap castleTalk2 = BitmapFactory.decodeResource(getResources(), R.drawable.c2);
    private Bitmap castleTalk3 = BitmapFactory.decodeResource(getResources(), R.drawable.c3);
    private Bitmap castleTalk4 = BitmapFactory.decodeResource(getResources(), R.drawable.c4);
    private Bitmap castleTalk5 = BitmapFactory.decodeResource(getResources(), R.drawable.c5);
    private Bitmap castleTalk6 = BitmapFactory.decodeResource(getResources(), R.drawable.c6);
    private Bitmap castleTalk7 = BitmapFactory.decodeResource(getResources(), R.drawable.c7);
    
    private Bitmap pinktrees = BitmapFactory.decodeResource(getResources(), R.drawable.cherrytrees);	   	
   	private Bitmap fog = BitmapFactory.decodeResource(getResources(), R.drawable.fog);
   	private Bitmap sand = BitmapFactory.decodeResource(getResources(), R.drawable.sand);
	private Bitmap shieldImage;
	private Bitmap bloodPic; 
	private Bitmap element;
	private Bitmap deadness;
	private Bitmap princeDead;
	private Bitmap currentBackground;
	private Bitmap ballImage = BitmapFactory.decodeResource(getResources(), R.drawable.energyballs);
	private Bitmap flashImage;
	private Bitmap samImage = BitmapFactory.decodeResource(getResources(), R.drawable.samuraisheet2);
	private Bitmap bubbleImage = BitmapFactory.decodeResource(getResources(), R.drawable.speechbubble);
	private Bitmap cinPic1 = BitmapFactory.decodeResource(getResources(), R.drawable.scenedude);
    private Bitmap eyeball = BitmapFactory.decodeResource(getResources(), R.drawable.eyeball2);
	private Bitmap scene6Sprite = BitmapFactory.decodeResource(getResources(), R.drawable.cutscene2);
	private Bitmap bossPic= BitmapFactory.decodeResource(getResources(), R.drawable.androidbossy); ;
    private Bitmap textBubble1 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble1);
    private Bitmap textBubble2 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble2);
    private Bitmap textBubble3 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble3);
    private Bitmap textBubble4 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble4);
    private Bitmap textBubble5 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble5);
    private Bitmap textBubble6 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble6);
    private Bitmap textBubble7 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble7);
    private Bitmap textBubble8 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble8);
    private Bitmap textBubble9 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble9);
    private Bitmap textBubble10 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble10);
    private Bitmap textBubble11 = BitmapFactory.decodeResource(getResources(), R.drawable.bubble11);
    private Bitmap starFog = BitmapFactory.decodeResource(getResources(), R.drawable.staryfog);
    private Bitmap castleWindow = BitmapFactory.decodeResource(getResources(), R.drawable.castlemozaik);
    private Bitmap startButtonbmp = BitmapFactory.decodeResource(getResources(), R.drawable.newb);
    private Bitmap newButton = BitmapFactory.decodeResource(getResources(), R.drawable.continueb);
    private Bitmap coverArt = BitmapFactory.decodeResource(getResources(), R.drawable.coverart);
    private Bitmap credit1 = BitmapFactory.decodeResource(getResources(), R.drawable.credit1);
    private Bitmap credit2 = BitmapFactory.decodeResource(getResources(), R.drawable.credit2);
    private Bitmap credit3 = BitmapFactory.decodeResource(getResources(), R.drawable.credit3);
    private Bitmap credit4 = BitmapFactory.decodeResource(getResources(), R.drawable.credit4);
    private Bitmap credit5 = BitmapFactory.decodeResource(getResources(), R.drawable.credit5);
    private Bitmap credit6 = BitmapFactory.decodeResource(getResources(), R.drawable.credit6);
    private Bitmap credit7 = BitmapFactory.decodeResource(getResources(), R.drawable.credit7);
    private Bitmap credit8 = BitmapFactory.decodeResource(getResources(), R.drawable.credit8);
    private Bitmap subiImage = BitmapFactory.decodeResource(getResources(), R.drawable.subi);
    
    //Screen Determiners, think think they're all useless
	private int scrnHeight;
	private int scrnWidth;
	private long lastClick; 
	private int lvl1time = 1440;
	private double textPosy;
	//time holders
	private long click2;
	private long timer2;
    private long timer3; 
    private long timer4;
    //items determine game stage
    private int round =1;
    private boolean win = true;
    private boolean createdNinjas =false;
	private boolean createdSprites=false;	
    private boolean createdNinjas2 = false; 
    private boolean createdNinjas3 = false;
    private boolean createdNinjas4 = false;
    private boolean createdninja5 = false;
    private boolean createdSpecial1;
    private boolean isCutscene1;
    private boolean createdDialogue=false;
    private boolean dialoguedone=false;
    private boolean music1On=false;
    private boolean music2On=false;
    private boolean music3On=false;
    private boolean music4On=false;
    private boolean music5On=false;
    private boolean isPaused=false;
    private boolean loopCreated=false;
    private boolean killsCounted=false;
    private boolean createdBoss=false;
    private boolean createdSam=false;
    private boolean speechOn=true; 
    private boolean cutscene3=false;
    private boolean createdScene3 = false;
    private boolean cutScene6 = false;
    private boolean createdScene6 = false;
    private boolean menu=true;
    private boolean resizedPics = false;
    private boolean resizedCoverArt=false;
    private boolean creditsOn=false;
    private boolean createdCredits=false;
    private boolean talkingFor6 = false;
    private boolean resizedBubbleImage=false;
    //other;
    private boolean ellyChange=false;
    private String talkingString="";
    private int score=0;
    Matrix matrix ;
    private long timer;
    private int countery=-1;
    private int killed=0;
	private double textPosx;
	private LvlSkipper skip;
	private boolean gameEnded=false;
	private Random randy;
	private int HighestScore;
	private long aTimer;
	private int aCounter=0;
	String MY_LEVEL_KEY = ""+25; 
	private int starCounter;
	private long roboTalkTimer; 
	
   public GameView(Context context) {
		super(context);
		contexty = context;
		gameLoop = new AllmightyThread(this);
	    paint.setColor(Color.WHITE);
	    paint2.setColor(Color.BLUE);
	    paint3.setColor(Color.MAGENTA);
		holder = getHolder();
		holder.addCallback(new SurfaceHolder.Callback() {
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
	       
				
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {	
			gameLoop.setRunning(true);
          if(loopCreated==false){
			gameLoop.start();
			loopCreated=true;
          }     
			// remind me to relocate these lines of code	
			try{	
			scrnHeight = getHeight();
			scrnWidth = getWidth();
			paint.setTextSize((float) (scrnHeight*0.0445));
			paint2.setTextSize((float) (scrnHeight*0.03));
			paint3.setTextSize((float) (scrnHeight*0.06));
		}catch(Exception e){}			
				
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {	
			
				
			}
		});
		//loads dead sprites, blood, element pictures + a level manager
		princeDead = BitmapFactory.decodeResource(getResources(), R.drawable.pinkdead);
		deadness = BitmapFactory.decodeResource(getResources(), R.drawable.death2);
		bloodPic = BitmapFactory.decodeResource(getResources(), R.drawable.bloody);
	    element = BitmapFactory.decodeResource(getResources(), R.drawable.lightningstrike3);
	    flashImage = BitmapFactory.decodeResource(getResources(), R.drawable.flash);
	    shieldImage = BitmapFactory.decodeResource(getResources(), R.drawable.shield); 
	    elly = new Elements(this,ellyBar);
	    lvly = new LevelManager(this);
	    circle = new Circle(this,greencircle,elly);
        textPosy = scrnHeight*.3;
        textPosx = scrnWidth*.1;
    
        skip = new LvlSkipper(this, shieldImage);
        sfx = new SoundFX(contexty);
        randy = new Random();
       
               
        
       
	}
	
	
	 @SuppressLint("ParserError")

	private Sprites spriteThis(int resource) {
			Bitmap bmp =BitmapFactory.decodeResource(getResources(), resource);
			return new Sprites (this,bmp); 
		}
	private Ninja1 spriteThisNinja(int resource){
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
		return new Ninja1(this,bmp,lvly);
	}
	
//Play Sound!!
	private void playSFX(int n){
		sfx.play(n);
		
	}
	
	@Override
     protected void onDraw(Canvas canvas) { 
if(isPaused==false){        

if(menu){
	if(!resizedCoverArt){
		coverArt = resize(coverArt,getWidth(),getHeight());
		resizedCoverArt=true;
	}
	canvas.drawBitmap(coverArt, 0,0, null);
	canvas.drawText("HighScore:" + HighestScore,(float)(getWidth()*.2),(float)(getHeight()*.37),paint3);
	canvas.drawText("Double tap to start",(float)(getWidth()*.3),(float)(getHeight()*.42),paint2);
	if(starty.size()<=0){
	 createContinueButton();
	}
	if(newy.size()<=0){
		createNewButton();
	}
	
	starty.get(0).setY((int)(getHeight()*.4));
	starty.get(0).onDraw(canvas);
	newy.get(0).setY((int)(getHeight()*.6));
	newy.get(0).onDraw(canvas);
	
	if(starty.get(0).getClicked()){		
		stopBackMusic();
		music1On=false;
		gameLoop.setTimer(1440);
		menu = false;
	}
	

	if(newy.get(0).getClicked()){
		stopBackMusic();
		music1On=false;			
        int lvl = myPrefs.getInt(MY_LEVEL_KEY, 1);
        lvly.setLevel(lvl);
        if(lvl==1)
        	gameLoop.setTimer(1440);
        if(lvl==2)
        	gameLoop.setTimer(624);
        if(lvl==3)
        	gameLoop.setTimer(720);
        if(lvl==4)
        	gameLoop.setTimer(648);
        if(lvl==5)
        	gameLoop.setTimer(1440); 
        if(lvl==6){
         	talkingFor6 = true;
        	gameLoop.setTimer(0);
       
        } 
        menu=false;
		
	}
	
	 if(music1On==false){
			startBackMusic1();
			music1On=true;
		 }
	
}else if(creditsOn){ 
	 if(mp5.isPlaying()||mp.isPlaying()){
		 stopBackMusic();
		 if(mp5.isLooping()){
			 mp5.setLooping(false);
		 }
	 }
	 
	 if(!mp6.isPlaying()){
		 startHappyMusic();
	 }
	 

if(!createdCredits){
	 createCredits();
	 createdCredits = true;
 }
canvas.drawColor(Color.BLACK);
playCredits.onDraw(canvas);


}else if(cutScene6){
	 if(mp.isPlaying()||mp2.isPlaying()){
		 stopBackMusic();
		 if(mp2.isLooping()){
			 mp2.setLooping(false);
		 }
	 }	
	 
	 if(music3On==false){
			startEvilMusic();
			music3On=true;
		}
	 
	 try{
			canvas.drawBitmap(currentBackground, 0,0, null);		
	 }catch(Exception e){}
	 
	 
	 if(createdScene6 == false){
         createDialogue2(); 	 
		 playScene6 = new Scene6(this,scene6Sprite,bossPic);
		 createdScene6 = true;
	 }
	 	 
     for(int c = 0; c< spritely.size();c++){
    	 Sprites sprite = spritely.get(c);
    	 sprite.onDraw(canvas);  
     }
     
     samurai.onDraw(canvas);
     playScene6.onDraw(canvas);
     talking();
     if(speechOn)
     canvas.drawBitmap(bubbleImage,(float)(textPosx-35),(float)(textPosy-10),null);
     
     canvas.drawText(""+talkingString, (float)(textPosx), (float)(textPosy)+20, paint);
	 if(playScene6.hasReached()&&Dialogue2.size()>0){
		 if(System.currentTimeMillis()-aTimer>=3000){
			 aCounter++;
			 aTimer= System.currentTimeMillis();
			 
		 }
		 canvas.drawBitmap(Dialogue2.get(aCounter), playScene6.getX()+10, playScene6.getY()-30, null); 	 
	    }	 
    		try{
    			canvas.drawBitmap(starFog, 0,0, null);
    			}catch(Exception e){}
    	           	 
	 if(aCounter>=Dialogue2.size()-1){
		playScene6.SetdialogueComplete(true);
	 }
	 if(playScene6.hasEnded()){
		 cutScene6 = false;
	 }
		
}else if(cutscene3){
//music	
	 if(mp.isPlaying()||mp2.isPlaying()){
		 stopBackMusic();
		 if(mp2.isLooping()){
			 mp2.setLooping(false);
		 }
	 }
	
	 if(music3On==false){
			startEvilMusic();
			music3On=true;
		}
	 
	
	 
if(createdScene3 == false){
    resizeCinamatic();
	playScene = new CinimaticScene(this,cinPic1,eyeball);
  createdScene3=true;
}
canvas.drawColor(Color.BLACK);
playScene.onDraw(canvas);

if(playScene.isBlinking()){
try {
	Thread.sleep(100);
} catch (InterruptedException e) {
	e.printStackTrace();
 }
}
	
	if(playScene.hasEnded()){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cinPic1=null;
		cutscene3=false;
		stopBackMusic();
	}
	
	
	
	
}else if(isCutscene1){
	//music!
	 if(mp.isPlaying()||mp2.isPlaying()){
		 stopBackMusic();
		 if(mp2.isLooping()){
			 mp2.setLooping(false);
		 }
	 }
	 
	 if(specially.get(0).isInMiddle()&&music3On==false){
			startEvilMusic();
			music3On=true;
		}

	 try{
			canvas.drawBitmap(currentBackground, 0,0, null);
			}catch(Exception e){}
					 
	 canvas.drawText("Score:"+score, (float)(scrnWidth*.1),(float) (scrnHeight*.1), paint);
	
	//trees
		try{
			canvas.drawBitmap(pinktrees, 0,0, null);
			}catch(Exception e){}
	 
	  if(speechOn)
		canvas.drawBitmap(bubbleImage,(float)(textPosx-35),(float)(textPosy-10),null);  
	
	  talking();
     canvas.drawText(""+talkingString, (float)(textPosx-10), (float)(textPosy+20), paint);
	 
	 
	 
	specially.get(0).onDraw(canvas);
	
	//creates dialogue
	if(specially.get(0).isInMiddle()&&createdDialogue==false){
		createDialogue();
		createdDialogue=true;	
	}
	 
	//plays dialogue while in middle
	if(createdDialogue==true&&specially.get(0).isInMiddle()&&dialoguedone==false){	
		if(System.currentTimeMillis()-timer>=3000 &&countery<text.size()-1 ){	
	        countery++;
	        timer=System.currentTimeMillis();	
		}
		text.get(countery).onDraw(canvas);	
	
		if(countery>=text.size()-1){			
		    dialoguedone=true;
		}
	}
if(specially.get(0).isOver()){
	specially.remove(0);
	isCutscene1 = false;
	stopBackMusic();
}
 }//end cutscene
//if its not the cutscene				
else if(win){	

 
//MUSIC might need to change level determination in the future	 
	 if(mp4.isPlaying()){
		 stopBackMusic();
	 }
	
if(lvly.getcurrentLevel()==1){	 
 if(music1On==false){
	startBackMusic1();
	music1On=true;
 }}
 


 if(lvly.getcurrentLevel() !=6){
  if(mp.isPlaying()==false&& music2On==false){
	if(lvly.getcurrentLevel()!=1){
	startMainBackMusic();
	music2On=true;
	}else if(round ==1 && gameLoop.getTimer()<=25){
	startMainBackMusic();
	music2On=true;
	}
	
 }
 } else if(lvly.getcurrentLevel()==6){
	if(mp3.isPlaying())
		stopBackMusic();
	if(mp.isPlaying())
		stopBackMusic();
	if(mp2.isPlaying())
		stopBackMusic();
	 if(music5On==false){
		 startBossMusic();
		 music5On=true;
	 }
 }
	 if(createdSpecial1==false){
			 createSpecial1();
			 createdSpecial1=true;
		 }
		 	
 //background	
	if(lvly.getLvldup()){
		determineBack();
		// in future might want to determine soundtrack here?
		lvly.lvldup(false);
	}
	
	try{
	canvas.drawBitmap(currentBackground, 0,0, null);
	}catch(Exception e){}
			
/*	 
      if(skip.pressed()){
    	  for(int a = ninja.size()- 1; a>=0; a--){
 			 ninja.remove(a);
 		 }
    	  for(int a = ninja2.size()- 1; a>=0; a--){
  			 ninja2.remove(a);
  		 }
    	  for(int a = ninja3.size()- 1; a>=0; a--){
   			 ninja3.remove(a);
   		 }
    	  for(int a = ninja4.size()- 1; a>=0; a--){
    	     ninja4.remove(a);
    		 }
    	  for(int a = ninja5.size()- 1; a>=0; a--){
     	     ninja5.remove(a);
     		 }
     	  for(int a = ninja6.size()- 1; a>=0; a--){
      	     ninja6.remove(a);
      		 }
    	  skip.press(false);
    	  checkLvlComplete();
      }
    */
	
//creating stuff                    
      if(createdSprites==false){
       	 createSprites();
        } 

         for(int a = blood.size()-1; a>=0; a--){
        	 blood.get(a).onDraw(canvas);
         }  
         for(int c = dead.size()-1; c>=0; c--){
        	 dead.get(c).onDraw(canvas); 
         } 
         for(int c = deadPrince.size()-1; c>=0;c--){
        	 deadPrince.get(c).onDraw(canvas);
         }
         
         for(int c=0; c<ninja.size();c++){
        	 Ninja1 ninjy = ninja.get(c);
        	 ninjy.onDraw(canvas);
         }  
         for(int c=0; c<ninja2.size();c++){
        	 Ninja1 ninjy2 = ninja2.get(c);
        	 ninjy2.onDraw(canvas);
         }  
         for(int c=0; c<ninja3.size();c++){
        	 Ninja1 ninjy3 = ninja3.get(c);
        	 ninjy3.onDraw(canvas);
         }
         for(int c=0; c<ninja4.size();c++){
        	 Ninja1 ninjy4 = ninja4.get(c);
        	 ninjy4.onDraw(canvas);
         }   
         for(int c=0; c<ninja5.size();c++){
        	 Ninja1 ninjy5 = ninja5.get(c);
        	 ninjy5.onDraw(canvas);
         } 
         for(int c=0; c<ninja6.size();c++){
        	 Ninja1 ninjy6 = ninja6.get(c);
        	 ninjy6.onDraw(canvas);
         } 

//Sprites onDraw!!         
         for(int c = 0; c< spritely.size();c++){
        	 Sprites sprite = spritely.get(c);
        	 sprite.onDraw(canvas);  
         }
         for(int b = stars.size() -1; b>=0; b--){
          	 stars.get(b).onDraw(canvas);
            }
         
       if(lvly.getcurrentLevel()!=6)  
         checkKilling(canvas);  
         
//Samurai onDraw! make sure to change the level to 4 in the future
         if(lvly.getcurrentLevel()>3){
        	if(createdSam == false&& lvly.getcurrentLevel()!=6){
        		createSam();
        		createdSam=true;
        	}
       try{ 	
        	if(!samurai.isAway()){
        	 samurai.onDraw(canvas);
        	 checkSamKill();
        	}
       }catch(Exception e){}
         }
         
    try{     
         for(int d = 0; d< convo.size()-1;d++){
        	 Talk talk = convo.get(d);
        	 talk.onDraw(canvas); 
         }
    }catch(Exception e){} 
         
         
       try{ 
         for(int h = shield.size()-1; h>=0;h--){
        	shield.get(h).onDraw(canvas);
         }
       }catch(Exception e){e.printStackTrace();}
         
//boss block	
  if(lvly.getcurrentLevel()==6){
       if(createdBoss==false){
       	createBoss();
       	createdBoss=true;
       }
 if(System.currentTimeMillis()-roboTalkTimer >6000){
	 playSFX(12);
	 roboTalkTimer = System.currentTimeMillis();
 }
       
       for(int a = boss.size()-1; a>=0; a--){
       	 Boss bossy = boss.get(a);
       	 bossy.onDraw(canvas);
       	 if(bossy.isAttacking()){
       		 ball.add(newBall(ball,bossy));
       		 if(ball.size()>11)
       			 bossy.setAttack(false);
       	 }
	      if(bossy.getHealth()<=0){
	    	 gameEnd(); 
	      }
       	 
       }   
       
       for(int a = ball.size()-1; a>=0; a--){
    	   ball.get(a).onDraw(canvas);
       }
       for(int b = flash.size() -1; b>=0; b--){
        	 flash.get(b).onDraw(canvas);
         }
       
       
       checkBossKill();
 }//end of boss stuff   
       
         for(int b = light.size() -1; b>=0; b--){
          	 light.get(b).onDraw(canvas);
              }
            
//background extensions
         if(lvly.getcurrentLevel()==1){
        		try{
        			canvas.drawBitmap(pinktrees, 0,0, null);
        			}catch(Exception e){}
        	 
               }
         
         if(lvly.getcurrentLevel()==2){
     		try{
     			canvas.drawBitmap(fog, 0,0, null);
     			}catch(Exception e){}
     	 
              }
         if(lvly.getcurrentLevel()==3){
      		try{
      			canvas.drawBitmap(sand, 0,0, null);
      			}catch(Exception e){}
      	 
               }
         if(lvly.getcurrentLevel()==4){
       		try{
       			canvas.drawBitmap(castleWindow, 0,0, null);
       			}catch(Exception e){}
       	 
                }
         if(lvly.getcurrentLevel()>4){
        		try{
        			canvas.drawBitmap(starFog, 0,0, null);
        			}catch(Exception e){}
        	 
                 }
         
         
//element bar+circle
 		elly.onDraw(canvas);
 		circle.onDraw(canvas);
         
       
//Ninja declarations, based on time and lvl   
         if(lvly.getcurrentLevel()==1){
         if(gameLoop.getTimer()<=25 && createdNinjas==false){
        		 createNinjas(2,3,0,0);
         }
         }
         if(lvly.getcurrentLevel()==2){
             if(gameLoop.getTimer()<=15 && createdNinjas==false){
            		 createNinjas(2,0,2,2);   	 
             }
             }
         if(lvly.getcurrentLevel()==3||lvly.getcurrentLevel()==4||lvly.getcurrentLevel()==5){
             if(gameLoop.getTimer()<=25 && createdNinjas==false){
            	if(lvly.getcurrentLevel()==3){	 
            	  createNinjas(1,1,1,1); 
            	  createRedNinja(1);
            	}
            	if(lvly.getcurrentLevel()==4){	 
              	  createNinjas(0,0,0,5);  
              	}
            	if(lvly.getcurrentLevel()==5){	 
                	  createNinjas(0,1,1,1);
                	  createBlackNinja(2);
                	}   
            	 
                 }
             }//end of wave one;
             
         if(gameLoop.getTimer()<=0 && createdNinjas2==false){
        	if(lvly.getcurrentLevel()==1){ 
        	 createNinjas(2,2,1,0);
        	 createdNinjas2=true;
        	}
        	if(lvly.getcurrentLevel()==2){ 
           	 createNinjas(0,2,1,2);
           	 createdNinjas2=true;
           	}
        	if(lvly.getcurrentLevel()==3){ 
              	 createNinjas(2,0,2,1);
              	 createdNinjas2=true;
              	}
        	if(lvly.getcurrentLevel()==4){ 
             	 createNinjas(4,0,0,0);
             	 createRedNinja(1);
             	 createdNinjas2=true;
             	}
        	if(lvly.getcurrentLevel()==5){ 
            	 createNinjas(1,2,1,2);
            	 createdNinjas2=true;
            	}
         }//end wave 2
         
         if(gameLoop.getTimer()<=0 &&createdNinjas3==false && round ==2){
        	 if(lvly.getcurrentLevel()==1){
        	 createNinjas(1,1,1,2);
        	 createdNinjas3=true;
        	 }
        	 if(lvly.getcurrentLevel()==2){
            	 createNinjas(1,2,1,1);
            	 createBlackNinja(1);
            	 createdNinjas3=true;
            	 }
        	 if(lvly.getcurrentLevel()==3){
            	 createNinjas(0,1,2,1);
            	 createRedNinja(1);
            	 createdNinjas3=true;
            	 }
        	 if(lvly.getcurrentLevel()==4){
            	 createNinjas(0,6,0,0);
            	 createBlackNinja(2);
            	 createdNinjas3=true;
            	 }
        	 if(lvly.getcurrentLevel()==5){
            	 createNinjas(1,2,0,1);
            	 createRedNinja(2);
            	 createdNinjas3=true;
            }//end wave 3
        	 
         }
         
         if(gameLoop.getTimer()<=0 &&createdNinjas4==false && round ==3){
        	 if(lvly.getcurrentLevel()==2){
        	 createNinjas(2,1,1,2);
        	 createdNinjas4=true;
        	 }
        	 if(lvly.getcurrentLevel()==3){
            	 createNinjas(1,1,1,2);
            	 createBlackNinja(1);
            	 createdNinjas4=true;
            	 }
        	 if(lvly.getcurrentLevel()==4){
            	 createNinjas(0,0,3,0);
            	 createBlackNinja(2);
            	 createdNinjas4=true;
            	 }
        	 if(lvly.getcurrentLevel()==5){
            	 createNinjas(0,2,0,0);
            	 createBlackNinja(2);
            	 createRedNinja(2);
            	 createdNinjas4=true;
            	 }
         }//end of wave 4
        
         if(gameLoop.getTimer()<=0 &&createdNinjas4==false && round ==4){
        	 if(lvly.getcurrentLevel()==4){
            	 createNinjas(1,1,1,2);
            	 createBlackNinja(1);
            	 createdNinjas4=true;
            	 }
        	 if(lvly.getcurrentLevel()==5){
            	 createNinjas(2,1,1,1);
            	 createBlackNinja(2);
            	 createdNinjas4=true;
            	 }
         }//end of wave 5
         

         if(lvly.getcurrentLevel()==2){
        	 starCounter++;
        	 if(starCounter%500 ==0){
        		if(stars.size()<=0){ 
        		 createSubis(randy.nextInt(3)+1);
        		 starCounter=0;
        		}
        	 }
         }
         
         if(lvly.getcurrentLevel()==3){
        	 starCounter++;
        	 if(starCounter%400 ==0){
        		if(stars.size()<=0){ 
        		 createSubis(randy.nextInt(4)+1);
        		 starCounter=0;
        		}
        	 }
         }
         if(lvly.getcurrentLevel()==4){
        	 starCounter++;
        	 if(starCounter%450 ==0){
        		if(stars.size()<=0){ 
        		 createSubis(randy.nextInt(3)+1);
        		 starCounter=0;
        		}
        	 }
         }
         if(lvly.getcurrentLevel()==5){
        	 starCounter++;
        	 if(starCounter%400 ==0){
        		if(stars.size()<=0){ 
        		 createSubis(randy.nextInt(4)+1);
        		 starCounter=0;
        		}
        	 }
         }

        
//The supercool speewcha bubbru
        if(!resizedBubbleImage){
        	bubbleImage = resize2(bubbleImage,getWidth());
        	resizedBubbleImage=true;
        }
         
         if(speechOn){
    	  canvas.drawBitmap(bubbleImage,(float)(textPosx-35),(float)(textPosy-10),null);  		 
      }
       
        
          canvas.drawText("HighScore: "+HighestScore, getWidth()*.14f,getHeight()*.14f,paint2);  
         
//Rounds are changed based on time and according to lvl   
       if(lvly.getcurrentLevel()==1){  
         
         if(gameLoop.getTimer()>=0){
        	canvas.drawText(""+gameLoop.getTimer(), (float)(scrnWidth*.875), (float) (scrnHeight*.08), paint);	
        }else{
        if(round<2){	
        gameLoop.setTimer(720);
        round++;         
        }
        if(round == 2){
        	checkLvlComplete();        
        }}  
     }   
       
       if(lvly.getcurrentLevel()==2){  
           
           if(gameLoop.getTimer()>=0){
          	canvas.drawText(""+gameLoop.getTimer(), (float)(scrnWidth*.875), (float) (scrnHeight*.08), paint);	
          }else{
          if(round<3){	
          gameLoop.setTimer(600);
          round++;         
          }
          if(round == 3){
          	checkLvlComplete();        
          }}  
       } 
       
    if(lvly.getcurrentLevel()>=3&&lvly.getcurrentLevel()!=6){  
           
           if(gameLoop.getTimer()>=0){
          	canvas.drawText(""+gameLoop.getTimer(), (float)(scrnWidth*.875), (float) (scrnHeight*.08), paint);	
          }else{
          if(round<3){	
          gameLoop.setTimer(480);
          round++;         
          }
          if(round == 3){
          	checkLvlComplete();        
          }}  
       } 
    if(lvly.getcurrentLevel()==6&&!talkingFor6){
     gameLoop.setTimer(720);
     talkingFor6 = true;
    }
    
       
        //the talking string!
        talking();
        canvas.drawText(""+talkingString, (float)(textPosx-10), (float)(textPosy)+20, paint);
      
        canvas.drawText("Score:"+score, (float)(scrnWidth*.1),(float) (scrnHeight*.1), paint); 
        //elementDeterminer creates appropriate element Bitmap
        elementDeterminer();
        //changes win boolean;
        lossDeterminer();     
	
    
}else{ //If you lose	
		try{
			canvas.drawBitmap(currentBackground, 0,0, null);
			}catch(Exception e){}
		
	//music!!!
		if(mp2.isPlaying()||mp5.isPlaying()){
			stopBackMusic();
			if(mp2.isLooping()){
				mp2.setLooping(false);
			}
		}
		
		if(music4On==false){
			startDeadMusic();
			music4On=true;
		}
		
		canvas.drawText("PHAIL", (float)(scrnWidth*.08), (float)(scrnHeight*.3), paint);
	    canvas.drawText("Double-tap to restart",(float)(scrnWidth*.08) , (float)(scrnHeight*.5), paint);
		canvas.drawText("Score:"+score, (float)(scrnWidth*.1),(float) (scrnHeight*.1), paint);
	    
	    if(retry.size()<=0){	
	    createButton();
	    }
	    
	    retry.get(0).onDraw(canvas);
	    
	    canvas.drawText("press it and we pretend", (float)(scrnWidth*.07),(float)(scrnHeight*.8) , paint2);
	    canvas.drawText("nothing happened", (float)(scrnWidth*.075),(float)(scrnHeight*.87) , paint2);
	    
	    if(retry.get(0).getClicked()){ 	 
	    	restart();	
	    }
	
	}}}
//end of drawing method

	
	
	private void createBlackNinja(int num) {
		for(int i=0; i<num; i++ ){
			ninja5.add(spriteThisNinja(R.drawable.blackninja));
		}
		
	}
	private void createRedNinja(int num) {
		for(int i=0; i<num; i++ ){
			ninja6.add(spriteThisNinja(R.drawable.theredninja));
		}
		
	}



	private void createDialogue2() {
        Dialogue2.add(textBubble1);
        Dialogue2.add(textBubble2);
        Dialogue2.add(textBubble3);
        Dialogue2.add(textBubble4);
        Dialogue2.add(textBubble5);
        Dialogue2.add(textBubble6);
        Dialogue2.add(textBubble7);
        Dialogue2.add(textBubble8);
        Dialogue2.add(textBubble9);
        Dialogue2.add(textBubble10);
        Dialogue2.add(textBubble11);
	}


	private void gameEnd() {

		 for(int c = spritely.size()-1; c>=0; c--){
        	 spritely.remove(c); 
        	 score+=500;
         }
		boss.remove(0);
		score +=5000;
		gameEnded=true;
		
		creditsOn = true;
		
	}
	
	private void createCredits(){
		credit1 = resize(credit1,getWidth(),getHeight());
		credit2 = resize(credit2,getWidth(),getHeight());
		credit3 = resize(credit3,getWidth(),getHeight());
		credit4 = resize(credit4,getWidth(),getHeight());
		credit5 = resize(credit5,getWidth(),getHeight());
		credit6 = resize(credit6,getWidth(),getHeight());
		credit7 = resize(credit7,getWidth(),getHeight());
		credit8 = resize(credit8,getWidth(),getHeight());

//story	
		credits.add(credit6);
		credits.add(credit7);
		credits.add(credit8);
// the end scene	
		credits.add(credit1);
		credits.add(credit2);
		credits.add(credit3);
		credits.add(credit5);
		credits.add(credit4);
		
		playCredits = new Credits(credits);
	}


	private void checkSamKill() {
		 for(int b = 0; b< ninja.size();b++){
        	 Ninja1 ninjit = ninja.get(b);
		 if(ninjit.collide( (float)(samurai.getX()) ,(float)(samurai.getY()) )){
			 samurai.setAttacking(true);
			 if(System.currentTimeMillis()-timer4>=700){
				 playSFX(10);
		    	 timer4 = System.currentTimeMillis();
		    	ninjit.loseHealth(3);
		    	ninjit.hit(true);
		    	}
		    	blood.add(new Sprite2(blood, this, ninjit.getX()+13, ninjit.getY()+10, bloodPic));
		 }	
		 if(ninjit.getHealth()<=0){
			 playSFX(8);
			    int mydeadx= ninjit.getdeadx();
			    int mydeady= ninjit.getdeady();
				ninja.remove(b);			
	          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));   
	          score +=25;	
			}	 	
		 }
		 
		 for(int b = 0; b< ninja2.size();b++){
        	 Ninja1 ninjit = ninja2.get(b);
		 if(ninjit.collide( (float)(samurai.getX()) ,(float)(samurai.getY()) )){
			 samurai.setAttacking(true);
			 if(System.currentTimeMillis()-timer4>=700){
				 playSFX(10);
		    	 timer4 = System.currentTimeMillis();
		    	ninjit.loseHealth(3);
		    	ninjit.hit(true);
		    	}
		    	blood.add(new Sprite2(blood, this, ninjit.getX(), ninjit.getY(), bloodPic));
		 }	
		 if(ninjit.getHealth()<=0){
			 playSFX(8);
			    int mydeadx= ninjit.getdeadx();
			    int mydeady= ninjit.getdeady();
				ninja2.remove(b);			
	          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));   
	          score +=25;	
			}	
		    	 
		    	}
		 for(int b = 0; b< ninja3.size();b++){
        	 Ninja1 ninjit = ninja3.get(b);
		 if(ninjit.collide( (float)(samurai.getX()) ,(float)(samurai.getY()) )){
			 samurai.setAttacking(true);
			 if(System.currentTimeMillis()-timer4>=700){
				 playSFX(10);
		    	 timer4 = System.currentTimeMillis();
		    	ninjit.loseHealth(3);
		    	ninjit.hit(true);
		    	}
		    	blood.add(new Sprite2(blood, this, ninjit.getX(), ninjit.getY(), bloodPic));
		 }	
		 if(ninjit.getHealth()<=0){
			 playSFX(8);
			    int mydeadx= ninjit.getdeadx();
			    int mydeady= ninjit.getdeady();
				ninja3.remove(b);			
	          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));   
	          score +=25;	
			}	
		    	}
		 
		 for(int b = 0; b< ninja4.size();b++){
        	 Ninja1 ninjit = ninja4.get(b);
		 if(ninjit.collide( (float)(samurai.getX()) ,(float)(samurai.getY()) )){
			 samurai.setAttacking(true);
			 if(System.currentTimeMillis()-timer4>=700){
				 playSFX(10);
		    	 timer4 = System.currentTimeMillis();
		    	ninjit.loseHealth(3);
		    	ninjit.hit(true);
		    	}
		    	blood.add(new Sprite2(blood, this, ninjit.getX(), ninjit.getY(), bloodPic));
		 }	
		 if(ninjit.getHealth()<=0){
			 playSFX(8);
			    int mydeady= ninjit.getdeady();
				int mydeadx=ninjit.getdeadx();
			    ninja4.remove(b);			
	          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));   
	          score +=25;	
			}	
		    	}
		 
		 }

	private void createSam() {
		samurai = new Samurai(this,samImage);
		
	}


	private void checkBossKill() {
		for(int a=0; a<boss.size();a++){
			Boss bossy = boss.get(a);
			 for(int b = 0; b< spritely.size();b++){
				 Sprites sprite = spritely.get(b);
			 if (sprite.generousCollide((float)(bossy.getX()+bossy.bmpWidth()/2),(float) (bossy.getY()+bossy.bmpHeight()*.9))){		
				    	sprite.isHit(true);	
				    	if(System.currentTimeMillis()-timer2>=500){
					    	 timer2 = System.currentTimeMillis();
					    	sprite.loseHealth(3);
					    	}				    	
				    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));
				    	}}}  	
		
		for(int a=0; a<ball.size();a++){
			EnergyBall bally= ball.get(a);
			 for(int b = 0; b< spritely.size();b++){
				 Sprites sprite = spritely.get(b);
			 if (sprite.generousCollide((float)(bally.getX()+bally.getWidth()/2),(float) (bally.getY()+bally.getHeight()/2))){
				  bally.hit(true);
				 if(sprite.hasShield()==false){
				    	sprite.isHit(true);	
				    	if(System.currentTimeMillis()-timer2>=500){
					    	 timer2 = System.currentTimeMillis();
					    	sprite.loseHealth(5);
					    	}				    	
				    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));
				    	}}}} 
					
		for(int b = 0; b< spritely.size();b++){	
			Sprites sprite = spritely.get(b);
			if(sprite.getHealth()<=0){
//play sound!
	    		if(randy.nextInt(100)>50){
	    		 playSFX(6);
	    	 }else
	    		 playSFX(7);
				try{
				convo.remove(b);
				}catch(Exception e){}
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=200;
		    	}
		}
		
	}


	private EnergyBall newBall(ArrayList<EnergyBall> b, Boss bossy) {
		return new EnergyBall(b,this,bossy.getX(),bossy.getY(), ballImage);
		
	}


	private void createBoss() {
	 boss.add(new Boss(this,bossImage));
		
	}


	//music stuff
	public void setMusic(MediaPlayer music1, MediaPlayer music2,MediaPlayer music3,MediaPlayer music4, MediaPlayer music5, MediaPlayer music6 ){
		permMusic1=music1;		
		permMusic2=music2;
		permMusic3=music3;
		permMusic4=music4;
		permMusic5 = music5;
		permMusic6 = music6;
		mp=permMusic1;
		mp2=permMusic2;
		mp3=permMusic3;
		mp4=permMusic4;
		mp5=permMusic5;
		mp6 = permMusic6;
	}	
	public void startBackMusic1(){
		mp=permMusic1;
		mp.start();
	}
	public void startMainBackMusic(){
		mp2=permMusic2;
		mp2.setVolume(.5f, .5f);
		mp2.start();
		mp2.setLooping(true);
	}
	public void startEvilMusic(){
		
		mp3=permMusic3;
		mp3.start();
	}
	public void startDeadMusic(){
		mp4=permMusic4;
		mp4.start();
		mp4.setLooping(true);
	}
	public void startBossMusic(){
		mp5=permMusic5;
		mp5.start();
		mp5.setLooping(true);
	}
	public void startHappyMusic(){
		mp6 = permMusic6;
		mp6.start();
		mp6.setLooping(true);		
	}
	
	public void stopBackMusic(){
	if(mp.isPlaying()){			
		mp.stop();	
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	if(mp2.isPlaying()){ 		
	    mp2.stop();
	    try {
			mp2.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	if(mp3.isPlaying()){
		mp3.stop();
		try {
			mp3.prepare();
		} catch (IllegalStateException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}	
	}
	
	if(mp4.isPlaying()){
	  mp4.stop();
	  try {
		mp4.prepare();
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	if(mp5.isPlaying()){
		mp5.stop();
		  try {
				mp5.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	if(mp6.isPlaying()){
		mp6.stop();
		  try {
				mp5.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	
	
}
    
	public void pauseMusic(){
	if(mp.isPlaying()){
		mp.pause();
	    music1On=false;
	}
	if(mp2.isPlaying()){
		mp2.pause();
		music2On=false;
	}
	if(mp3.isPlaying()){
		mp3.pause();
		music3On=false;
	}
	if(mp4.isPlaying()){
		mp4.pause();
		music4On=false;
	}
	if(mp5.isPlaying()){
		mp5.pause();
		music5On=false;
	}
	if(mp6.isPlaying()){
		mp5.pause();
		music5On=false;
	}
	
		
	}
	
    private void createDialogue() {
      text.add(new Dialogue(text,text1,specially.get(0)));
      text.add(new Dialogue(text,text2,specially.get(0)));	
      text.add(new Dialogue(text,text3,specially.get(0)));
      text.add(new Dialogue(text,text4,specially.get(0)));
      text.add(new Dialogue(text,text5,specially.get(0)));
      text.add(new Dialogue(text,text6,specially.get(0)));
      text.add(new Dialogue(text,text7,specially.get(0)));
      text.add(new Dialogue(text,text7,specially.get(0)));
	}

	private void createSpecial1() {
		specially.add(specialThis(R.drawable.cutscenesprite1)); 
		
	}

	private SpecialSprite specialThis(int resource) { 
			Bitmap bmp =BitmapFactory.decodeResource(getResources(), resource);
			return new SpecialSprite(this,bmp); 		
			
	}

//This aslo creates a new lvl	
    private void checkLvlComplete() {
		if(ninja.size()<=0&& ninja2.size()<=0&& ninja3.size()<=0 && ninja4.size()<=0&&ninja5.size()<=0&&ninja6.size()<=0 ){
			music1On=false;
			if(lvly.getcurrentLevel()!=6)
			music2On=false;
			
			music3On=false;
			music4On=false;
			lvly.levelUp();
			//very important variable
			lvly.lvldup(true);	
			round=1;
			createdNinjas=false;
			createdNinjas2=false;
			createdNinjas3=false;
			createdNinjas4=false;
			music3On=false;

			for(int c = shield.size()-1; c>=0; c--){
	        	 shield.remove(c); 
	         }
			for(int c = dead.size()-1; c>=0; c--){
	        	 dead.remove(c); 
	         }
			 for(int c = deadPrince.size()-1; c>=0; c--){
	        	 deadPrince.remove(c); 
	         }
			 
			 for(int c = blood.size()-1; c>=0; c--){
	        	 blood.remove(c); 
	         }
			 for(int a = stars.size()- 1; a>=0; a--){
				 stars.remove(a);
			 }
			 
			 if(lvly.getcurrentLevel()!=6)
			 createdSprites=false;
			 createdSpecial1 =false;
			 
		if(lvly.getcurrentLevel()!=6){	 
			 for(int c = spritely.size()-1; c>=0; c--){
	        	 spritely.remove(c); 
	        	 score+=100;
	         }
		}
			
	 if(lvly.getcurrentLevel()!=6){	
		for(int c = convo.size()-1; c>=0; c--){
	        	 convo.remove(c); 
	         }
	 }

			 
	    if(lvly.getcurrentLevel()==2){
	    	isCutscene1 =true;
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	gameLoop.setTimer(1440);
	    }
	    
	    if(lvly.getcurrentLevel()==3){

	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	gameLoop.setTimer(720);
	    }
	    
	    if(lvly.getcurrentLevel()==4){

	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	gameLoop.setTimer(960);
	    	
	    	cutscene3= true; 
	    }
	    
	    if(lvly.getcurrentLevel()==5){
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	gameLoop.setTimer(1440);
	    }
		
	   if(lvly.getcurrentLevel()==6){
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	      cutScene6 = true;
	   }
	   
	}}
	
	public boolean isDialogueComplete(){
		return dialoguedone;
	}
	
	private void resizeCinamatic(){
		cinPic1 = resize(cinPic1,getWidth()*.5,getHeight()*.5); 
		resizedPics = true;
		
	}
	

	private void determineBack() {
		if(lvly.getcurrentLevel()==1){
			currentBackground= resize(back1,getWidth(),getHeight());
			pinktrees = resize(pinktrees,getWidth(),getHeight());			
			textPosx=getWidth()*.1;
			textPosy=0;
			speechOn=true;
			coverArt=null;
		}
		
		if(lvly.getcurrentLevel()==2){
			currentBackground= resize(back2,getWidth(),getHeight());
		   fog = resize(fog,getWidth(),getHeight());
		   pinktrees=null; 
		   back1=null;
			textPosx=getWidth()*.1;
			textPosy=getHeight()/2;
			speechOn=true;
		   
		}
		
		if(lvly.getcurrentLevel()==3){
			currentBackground= resize(back3,getWidth(),getHeight());
		   sand = resize(sand,getWidth(),getHeight());
		   back2=null;
		   fog=null;
			textPosx=getWidth()*.1;
			textPosy=getHeight()/2;
			speechOn=true;
		}
		
		if(lvly.getcurrentLevel()==4){
			currentBackground= resize(back4,getWidth(),getHeight());
			castleWindow = resize(castleWindow,getWidth(),getHeight());
			back3=null;
			sand=null;
			textPosx=getWidth()*.1;
			textPosy=getHeight()/2;
			speechOn=true;
		}
		
		if(lvly.getcurrentLevel()==5||lvly.getcurrentLevel()==6){
			back4=null;
			castleWindow = null;
			currentBackground= resize(back5,getWidth(),getHeight());
			starFog= resize(starFog,getWidth(),getHeight());
			textPosx=getWidth()*.1;
			textPosy=getHeight()/2;
			if(lvly.getcurrentLevel()!=6)
			speechOn=true;
		}
	
	}

	private Bitmap resize2(Bitmap b, int width) {
           float x =1;
          matrix = new Matrix();
           while(x*b.getWidth()<width){
        	   x +=.015;
           }
           matrix.postScale(x,1); 
           return Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), matrix, true);
	}


	private Bitmap resize(Bitmap b, double width, double height) {
   float x=1;
   float y=1;
   matrix = new Matrix();    
       while(x*b.getWidth()<width){
    	   x +=.015;
       }
       while(y*b.getHeight()<height){
    	   y +=.015;
       }

	matrix.postScale(x,y); 
    return Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), matrix, true);

	}

	public void createButton(){
	retry.add(new Retry(this,button));
	}
	
	public void createContinueButton(){
		starty.add(new Retry(this,startButtonbmp));
	}
	public void createNewButton(){
		newy.add(new Retry(this,newButton));
	}
	
//Text also made with sprites	
	public void createSprites(){
	
		if(lvly.getcurrentLevel()==1){
	createTexts(); 	
		for(int i = 0; i<= 7; i++){
			spritely.add(spriteThis(R.drawable.princessb1));	
//the talk array deals with the different dialogues said
			convo.add(new Talk(talk1,spritely.get(i)));
		}	
	}
			
	
	if(lvly.getcurrentLevel()==2){	
		for(int i = 0; i<= 6; i++){
			spritely.add(spriteThis(R.drawable.princessb2));
			convo.add(new Talk(talk2,spritely.get(i)));
		}	
	}
	
	if(lvly.getcurrentLevel()==3){	
		for(int i = 0; i<= 5; i++){
			spritely.add(spriteThis(R.drawable.princessb3));
			convo.add(new Talk(talk3,spritely.get(i)));
		}	
	}
	
	if(lvly.getcurrentLevel()==4){	
		for(int i = 0; i<= 5; i++){
			spritely.add(spriteThis(R.drawable.princessb4));
			convo.add(new Talk(talk4,spritely.get(i)));
		}	
	}
	
	if(lvly.getcurrentLevel()==5||lvly.getcurrentLevel()==6){	
			spritely.add(spriteThis(R.drawable.princessb1));
		convo.add(new Talk(talk1,spritely.get(0)));
			spritely.add(spriteThis(R.drawable.princessb2));
		convo.add(new Talk(talk2,spritely.get(1)));	
			spritely.add(spriteThis(R.drawable.princessb3));
		convo.add(new Talk(talk3,spritely.get(2)));
			spritely.add(spriteThis(R.drawable.princessb4));
		convo.add(new Talk(talk4,spritely.get(3)));
	}
	
	
		
	createdSprites = true;
		
 }
		
	private void createTexts() {
		talk1.add(pinkTalk1);
		talk1.add(pinkTalk2);
		talk1.add(pinkTalk3);
		talk1.add(pinkTalk4);
		talk1.add(pinkTalk5);
		talk1.add(pinkTalk6);
		talk1.add(pinkTalk7);
		talk1.add(pinkTalk8);
		
		talk2.add(iceTalk1);
		talk2.add(iceTalk2);
		talk2.add(iceTalk3);
		talk2.add(iceTalk4);
		talk2.add(iceTalk5);
		talk2.add(iceTalk6);
		talk2.add(iceTalk7);
		
		talk3.add(desertTalk1);
		talk3.add(desertTalk2);
		talk3.add(desertTalk3);
		talk3.add(desertTalk4);
		talk3.add(desertTalk5);
		talk3.add(desertTalk6);
		talk3.add(desertTalk7);
		talk3.add(desertTalk8);
		
		talk4.add(castleTalk1);
		talk4.add(castleTalk2);
		talk4.add(castleTalk3);
		talk4.add(castleTalk4);
		talk4.add(castleTalk5);
		talk4.add(castleTalk6);
		talk4.add(castleTalk7);
		
	}


	private void lossDeterminer() {
		if(spritely.size()<=0 && lvly.getLvldup()==false){
			win=false;
		}
		
	}

	private void talking(){
	
	int time=gameLoop.getTimer();
	
	if(lvly.getcurrentLevel()==1){	
		
		if(round ==1){
			
		if(time<=58 && time > 56){
			speechOn = true;
			talkingString="See all The Princesses?";
		}
		if(time<=56 && time > 55){
			talkingString="They're running'";
		}
		if(time<=55 && time > 54){
	     	talkingString="Want to know why?";                 
		}
		if(time<=54 && time > 52){
			talkingString="CUZ YOUR FACE IS UGLY";                   
		}
		if(time<=52 && time > 51){
			talkingString="Well that and...";               
		}
		if(time<=51 && time > 49){
			talkingString="Ninjas are coming to kill em";                
		}
	     if(time<=49 && time > 48){
			talkingString="Dont worry we got you...";                
		}
		if(time<=48 && time >47 ){
			talkingString="'re ugly face to fight ninjas";                 
		}
		if(time<=47 && time> 43){
			textPosy= scrnHeight*.77;
			talkingString="Select an element ";
		}
		if(time<=43 && time> 42){
			talkingString="Blue ninjas...";
		}
		if(time<=42 && time> 40){
			talkingString="only die with fire";
		}
		if(time<=40 && time> 38){
			talkingString="And yellow with earth ";
		}
		if(time<=38 && time> 37){
			talkingString="but... ";
		}
		if(time<=37 && time> 35){
			talkingString="not sure about the rest";
		}
		if(time<=35&&time>32){
			textPosy= scrnHeight*.3;
			talkingString="You can shield princesses";
		}
		if(time<=32&&time>29){
			talkingString="Just press them";
		}
		if(time<=29&&time>28){
			talkingString="So are you ready to fight EVAIL";
		}
		if(time<=28&&time>27){
			talkingString="ARE YOU REALLY READY";
		}
		if(time<=27&&time>26){

			talkingString="READY TO CRAP YO PANTS?";
		}
		if(time<=26&&time>25){
			talkingString="OUT OF SHEER AWESOMENESS";
		}
		if(time<=25&&time>24){

			talkingString="good cuz that's just weird";
		}
		if(time<=24&&time>22){
			talkingString="Don't phail me";
		}

		if(time<=22&&time>9){
			talkingString="";
			speechOn=false;
		}
	if(time==10&&killsCounted==false){	
		 for(int i=spritely.size();i<8;i++){
			 killed++;
		 }
		 killsCounted=true;
	}
	if(killed>1){ 	 
		 if(time<=9&& time > 8){
			 speechOn=true;
			 talkingString = "Let the world know";
		 }
		 if(time<=8&& time > 7){
			 talkingString = killed +" Princesses Have Died";
		 }
		 if(time<=7&& time > 4){
			 talkingString = "Good Job";
		 }
		 if(time<=4){
			 talkingString = "";
			 speechOn=false;
		 }
	}
		
		
	}
		if(round==2){
			
		 if(time<= 30&& time> 28){
			 speechOn=true;
			 talkingString="Theres more!!";
		 }
		 if(time<= 28&& time> 27){
			 talkingString="Give up yet?";
		 }
		 if(time<=27 && time >25){
			 talkingString = "good";
		 }
		 if(time<=25&& time > 15){
			 talkingString = "";
			 speechOn=false;
		 }
		 if(time<=15&& time > 13){
			 talkingString = "if you need to take a break";
			 speechOn=true;
		 }
		 if(time<=13&& time > 11){
			 talkingString = "press Home to pause";
			 speechOn=true;
		 }
		 if(time<=11){
			 talkingString = "";
			 speechOn=false;
		 }
	
	   }
	}  
	  if(lvly.getcurrentLevel()==2){
		  
		 if(round==1){
			  if(time>59) 
				   speechOn=false;
			 if(time<=59 && time >58){
				 textPosy = getWidth()*.5;
				 speechOn=true; 
				  talkingString = "YOU DID IT";
				 } 
			  
			  if(time<=58 && time >56){
				   speechOn=true; 
					 talkingString = "you saved the clones!";
				 } 
			  
			  if(time<=56 && time >55){
					 talkingString = "yes";
				 }	
			  
			  if(time<=55 && time >53){
					 talkingString = "They're only clones";
				 }	
			  
			  if(time<=53 && time >51){
					 talkingString = "who's this dork?";
				 }
			  
			  if(time<=51 && time >49){
					 talkingString = "ZAP HIM";
				 }
			  
			  if(time<=49 && time >46){
					 talkingString = "Derp";
				 }
			  
			  if(time<=46 && time >40){
					 talkingString = "......";
				 }
			  if(time<=40 && time >30){
					 talkingString = "";
					 speechOn=false;
				 }
			  		  
			   if(time<30&& time>28 ){
				speechOn=true;	 
				   talkingString = "Lets save more clones";				 
			   }
			   if(time<28&& time>26 ){
				speechOn=false; 
				   talkingString = "";				 
			   }
			   if(time<=26 && time >25 ){
				   speechOn=true;	 
				   talkingString = "Oh great, the Ice realm";				 
			   }
			   if(time<=25 && time >24 ){
					 talkingString = "I'm sorry I'm too cold for this";				 
			   }
			   if(time<=23 && time >22 ){
					 talkingString = "I'm sorry I'm too cold for this";				 
			   }
			   if(time<=22 && time > 21){
					 talkingString = "I'll be back";
			   }	
			   if(time<=21 && time > 20){
					 talkingString = "GoodLuck";
			   }
			   if(time<=20 && time > 10){
					 talkingString = "";
					 speechOn=false;
			   }   
		 }//end of round 1	
		    
		    if(round==2){
		    	 if(time<=20 && time >18 ){
					 speechOn=true;
					 textPosy= scrnHeight*.38; 
		    		 talkingString = "THE PRINCESSES!";				 
			   }
		    	 if(time<=18 && time >17 ){
					 talkingString = "THEY'RE GONNA DIE!";				 
			   }
		    	 if(time<=17 && time >5 ){
					 talkingString = "";
					 speechOn = false;
			   } 
		    	 if(time<=5 && time>2 && score<=50 ){
					 speechOn= true;
		    		 talkingString = "Nice score -_-";				 
			   }     
		    	 if(time<=2 ){
					 talkingString = "";
					 speechOn = false;
			   }     
		    	 
		    }//end of round 2
		    
		    if(round == 3){
		   	 if(time<=15 && time >13 ){
				 speechOn=true;
				 textPosy= getHeight()*.38; 
	    		 talkingString = "ouch!";				 
		      }
		   	 if(time<=13 && time >11 ){
						 textPosy= getHeight()*.48; 
			    		 talkingString = "Spilled my hot chocolate!!";				 
				      }
		   	 if(time<=11 && time >9 ){
				 speechOn=true;
				 textPosy= getHeight()*.38; 
	    		 talkingString = "WHY U SO HOT! CHOCOLATE!";				 
		      }
		   	 
		   	 if(time<=9 ){
				 speechOn=false;
				 textPosy= getHeight()*.37; 
	    		 talkingString = "";				 
		      }		   	 
		}//end round 3 
		 
	 }//end of lvl 2
	  
	  if(lvly.getcurrentLevel()==3){    
		  if(round==1){	
			  if(time>29) 
				   speechOn=false;
		  if(time<=29 && time>27){
					talkingString = "You still got more savin' to do";	
					speechOn=true;
					 textPosy = getHeight()*.35;
			} 
		  if(time<=27 && time>15){
				talkingString = "";	
				speechOn=false;
				 textPosy = getHeight()*.25;
		} 
		  
		  if(time<=15 && time>13){
			speechOn=true;	
			  talkingString = "They've gotten stronger, huh?";				
		}   
		  if(time<=13 && time>12){
				talkingString = "Ha!";				 
		}
		  if(time<=12 && time>11){
				talkingString = "That's you're porblem";				 
		}
		  if(time<=11){
				talkingString = "";	
				speechOn=false;
		} 
		  
	    }//end round 1
	    if(round==2){	    	
		if(time<=18&&time>17){
			talkingString = "I come back";	
			speechOn=true;
			} 	
		if(time<=17&&time>16){
			talkingString = "From the beach";	
			 textPosy = getHeight()*.1;  
			} 
		if(time<=16&&time>15){
			talkingString = "And I walk into this:";	 
			} 
		if(time<=15&&time>14){
			talkingString = " A PRINCESS BLOOD BATH";	 
			} 
		if(time<=14&&time>12){
			talkingString = " FIX IT!";	 
			} 
		if(time<=12){
			talkingString = " ";
			speechOn=false; 
			} 		    	    	
	    }//end round2
	    
	    if(round==3){
			if(time<=10&&time>8){
				speechOn=true; 
				textPosy = getHeight()*.8;
				talkingString = "Ewwww... ";				
				} 		
			if(time<=8&&time>6){
				talkingString = "Sand in mah pants ";				
				} 		    	    	
		    if(time<=6){
			    talkingString = "" ;
			    speechOn=false;
			    } 	    	
       }//end of round  3
	}//end of lvl 3 
	  
	   if(lvly.getcurrentLevel()==4){
		   if(round==1){
			  if(time>25) 
			   speechOn=false;
			   
			   if(time<=25&&time>24){
				    talkingString = "OK FINE" ;
				    speechOn=true;
				    textPosy = getHeight()*.5;
				    } 
			    if(time<=24&&time>23){
				    talkingString = "I'll help you" ;
				    } 
			    if(time<=23&&time>21){
				    talkingString = "Cuz you're that pathetic" ;
				    } 
			    if(time<=21&&time>3){
				    talkingString = "" ;
				    speechOn=false;
				    } 
			    if(time<=3&&time>1){
				    speechOn=true;
			    	talkingString = "God I'm Sexy" ;
				    } 
			    if(time<=1){
				    speechOn=false;
			    	talkingString = "" ;
				    } 
		   }// end round 1
		     if(round==2){
		    	  if(time<=16&&time>14){
					    speechOn=true;
				    	talkingString = "UNGARD!" ;
					    }
		    	  if(time<=14&&time>12){
					    speechOn=true;
				    	talkingString = " Je parle le fromage" ;
					    } 
		    	  if(time<=12){
					    speechOn=false;
				    	talkingString = "" ;
					    } 
		     }// end round 2
		       
		     if(round ==3){
		    	  if(time<=10&&time>9){
					    speechOn=true;
				    	talkingString = "Stuupid Ninjas" ;
					    }
		    	  if(time<=9&&time>8){					
				    	talkingString = "I'm an Artist!" ;
					    }
		    	  if(time<=8&&time>6){					
				    	talkingString = "With your blood I paint!" ;
					    }
		    	  if(time<=6){					
				    speechOn=false;
		    		  talkingString = "";
		    	  }    
		     }
		   		   
	   }// end lvl 4
	   
	   if(lvly.getcurrentLevel()==5){
		   if(round==1){
			  if(time>59) 
			   speechOn=false;
			 if(time<=59&&timer>58){
				 speechOn=true;
				 textPosy = getHeight()*.3;
				 talkingString = "Oh boy" ;
			 }
			 if(time<=58&&time>57){
				 talkingString = "This is it" ;
			 }
			 if(time<=57&&time>56){
				 textPosy = getHeight()*.4;
				 talkingString = "This is the God realm" ;
			 }
			 if(time<=56&&time>54){
				 textPosy = getHeight()*.4;
				 talkingString = "Where real princesses go!" ;
			 }
			 if(time<=54&&time>52){
				 textPosy = getHeight()*.4;
				 talkingString = "Man it's all up to you now" ;
			 }
			 if(time<=52&&time>51){
				 speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "We're gonna die!" ;
			 }
			 if(time<=51&&time>49){
				speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "There's too many ninjas!!" ;
			 }
			 if(time<=49&&time>47){
				speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "Too many" ;
			 }
			 if(time<=47&&time>45){
				 speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "Ninja's shouldn't be here!" ;
			 }
			 if(time<=45&&time>43){
				 speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "But they are..." ;
			 }
			 if(time<=43&&time>41){
				speechOn=true;
				 textPosy = getHeight()*.6;
				 talkingString = "They're ninjas!" ;
			 }
			 if(time<=41&&time>39){
				 speechOn=true;
				 textPosy = getHeight()*.5;
				 talkingString = "What next?" ;
			 }
			 if(time<=39&&time>37){
				 textPosy = getHeight()*.5;
				 talkingString = "A giant robot alien?" ;
			 }
			 if(time<=37&&time>35){
				 textPosy = getHeight()*.5;
				 talkingString = "I hate my job sometimes" ;
			 }
			 if(time<=35&&time>30){
				 textPosy = getHeight()*.2;
				 speechOn=false;
				 talkingString = "" ;
			 }
			 if(time<=30&&time>29){
				 textPosy = getHeight()*.2;
				 speechOn=true;
				 talkingString = "Mommy..." ;
			 }
			 if(time<=29&&time>27){
				 textPosy = getHeight()*.2;
				 speechOn=true;
				 talkingString = "Save me" ;
			 }
			 if(time<=27){
				 textPosy = getHeight()*.2;
				 speechOn=false;
				 talkingString = "" ;
			 }
		   }//end of round 1 
     }//end of lvl 5
	   
	   if(lvly.getcurrentLevel()==6){
			 if(time<=29&&time>27){
				 textPosy = getHeight()*.2;
				 speechOn=true;
				 talkingString = "YOU DID IT" ;
			 } 
			 if(time<=27&&time>26){
				 textPosy = getHeight()*.2;
				 speechOn=true;
				 talkingString = "I DONT BELIEVE IT" ;
			 } 
			 if(time<=26&&time>25){
				 textPosy = getHeight()*.2;
				 speechOn=true;
				 talkingString = "Oh no it's that one dork" ;
			 } 
			 if(time<=25&&time>23){
				 textPosy = getHeight()*.3;
				 speechOn=true;
				 talkingString = "T'M LEAVING!" ;
			 } 
			 if(time<=23&&time>15){
				 textPosy = getHeight()*.2;
				 talkingString = "I'VE HAD ENOUGH" ;
			 } 
			 if(time<15){
				 textPosy = getHeight()*.5;
				 speechOn=false;
				 talkingString = "" ;
			 } 
		   
	   }
  }//end of talking()
	
	private void createNinjas(int num, int num2, int num3, int num4){
		for(int i=0; i<num; i++ ){
			ninja.add(spriteThisNinja(R.drawable.blueninja));
		}
		
		for(int i=0; i<num2; i++ ){
			ninja2.add(spriteThisNinja(R.drawable.redninja2));
		}
		
		for(int i=0; i<num3; i++ ){
			ninja3.add(spriteThisNinja(R.drawable.greenninja));
		}
		
		for(int i=0; i<num4; i++ ){
			ninja4.add(spriteThisNinja(R.drawable.yellowninja));
		}
						
		createdNinjas=true;
		
	}
	 	 
	private void elementDeterminer() {
	if(System.currentTimeMillis()-timer3>= 100&& ellyChange){
		timer3 = System.currentTimeMillis(); 
		if(elly.getCurrentElement()==1){
			element = BitmapFactory.decodeResource(getResources(), R.drawable.firestrike2);
		}
		
		if(elly.getCurrentElement()==2){
			element = BitmapFactory.decodeResource(getResources(), R.drawable.waterstrike2);
		}
		
		if(elly.getCurrentElement()==3){
			element = BitmapFactory.decodeResource(getResources(), R.drawable.lightningstrike3);
		}
		if(elly.getCurrentElement()==4){
			element = BitmapFactory.decodeResource(getResources(), R.drawable.earthstrike2);
		}
		ellyChange = false;
	}	
		
		
	}

	private void createSubis(int n){
		for(int a=0; a<n; a++){
			stars.add(new Subi(getWidth(),getHeight(),subiImage,stars)); 
		}		
	}
	
	private void checkKilling(Canvas canvy) {
		for(int a=0; a<ninja.size();a++){
			 Ninja1 ninjit = ninja.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);
		    
		     	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		    	ninjit.setKillFrame(true);
		       
		    if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=500){
		    	 timer2 = System.currentTimeMillis();
		    	 playSFX(5);
		    	 sprite.loseHealth(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));
		    	if(sprite.getHealth()<=0){
		    	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=50;   
		}}}}}
		
		for(int a=0; a<ninja2.size();a++){
			 Ninja1 ninjit = ninja2.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);
		   	        	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		    	 
		    	ninjit.setKillFrame(true);
		    	if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=500){
		    		timer2 = System.currentTimeMillis();
		    		 playSFX(5);
		    		sprite.loseHealth(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));
		    	if(sprite.getHealth()<=0){
		    	 	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=50;
		    
		}}}}}
		
		for(int a=0; a<ninja3.size();a++){
			 Ninja1 ninjit = ninja3.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);	        	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		    	 
		    	ninjit.setKillFrame(true);
		    	if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=500){
		    		timer2 = System.currentTimeMillis();
		    	sprite.loseHealth(5);
		    	 playSFX(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));
		    	if(sprite.getHealth()<=0){
		    	 	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=50;
		    
		}}}}}
		
		for(int a=0; a<ninja4.size();a++){
			 Ninja1 ninjit = ninja4.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);
		   
		        	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		    	ninjit.setKillFrame(true);
		    	if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=500){
		    	timer2 = System.currentTimeMillis();
		    	sprite.loseHealth(5);
		    	 playSFX(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));		    	
		    	if(sprite.getHealth()<=0){
		    	 	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}    
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=50;
		    
		}}}}}//end ninja4		
		
		for(int a=0; a<ninja5.size();a++){
			 Ninja1 ninjit = ninja5.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);		        	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		    
		    	ninjit.setKillFrame(true);
		    	if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=300){
		    	timer2 = System.currentTimeMillis();
		    	sprite.loseHealth(5);
		    	 playSFX(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));		    	
		    	if(sprite.getHealth()<=0){
		    	 	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}    
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=70;
		    
		}}}}}//end ninja5 
		
		
		for(int a=0; a<ninja6.size();a++){
			 Ninja1 ninjit = ninja6.get(a);
			  for(int b = 0; b< spritely.size();b++){
		        	 Sprites sprite = spritely.get(b);		   	        	 
		      if (sprite.collide(ninjit.getX()+ninjit.bmpWidth()/2, ninjit.getY()+ninjit.bmpHeight()/3)){
		   
		    	ninjit.setKillFrame(true);
		    	if(sprite.hasShield()==false){
		    	sprite.isHit(true);
		    	ninjit.onDraw(canvy);
		    	if(System.currentTimeMillis()-timer2>=500){
		    	timer2 = System.currentTimeMillis();
		    	sprite.loseHealth(5);
		    	 playSFX(5);
		    	}
		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));		    	
		    	if(sprite.getHealth()<=0){
		    	 	 //play sound!
		    		if(randy.nextInt(100)>50){
		    		 playSFX(6);
		    	 }else
		    		 playSFX(7);
		    		try{
						convo.remove(b);
						}catch(Exception e){}    
		       int  mydeadx = sprite.getdeadx();
		       int mydeady= sprite.getdeady();
		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
		    	spritely.remove(sprite);
		    	score -=70;		    
		}}}}}//end ninja 6
		
		for(int a=0; a<stars.size();a++){
			 Subi subi = stars.get(a);
			 
			 for(int b = 0; b< spritely.size();b++){
	        	 Sprites sprite = spritely.get(b);
	        	 
	        	 if (sprite.generousCollide(subi.getX()+subi.bmpWidth()/2, subi.getY()+subi.bmpHeight()/3)){
	        		if(subi.isFlying()){  
	     		    	sprite.isHit(true);	 
	     		   	   if(System.currentTimeMillis()-timer2>=500){
	    		    	timer2 = System.currentTimeMillis();
	    		    	sprite.loseHealth(5);
	    		    	  }
	    		    	blood.add(new Sprite2(blood, this, sprite.getX()+10, sprite.getY()+10, bloodPic));		    	
	    		   //if sprite is dead 	
	        		 if(sprite.getHealth()<=0){
	    		    	 	 //play sound!
	    		    		if(randy.nextInt(100)>50){
	    		    		 playSFX(6);
	    		    	 }else
	    		    		 playSFX(7);
	    		    		try{
	    						convo.remove(b);
	    						}catch(Exception e){}    
	    		       int  mydeadx = sprite.getdeadx();
	    		       int mydeady= sprite.getdeady();
	    		    	deadPrince.add(new DeadButt(deadPrince,this,mydeadx,mydeady,princeDead));
	    		    	spritely.remove(sprite);
	    		    	score -=70;
	         	 
	        		 }}}}}
	}	
	
	@Override
	public boolean onTouchEvent(MotionEvent e){
  		 
		 
		 if(e.getAction()==MotionEvent.ACTION_DOWN){
		 if (System.currentTimeMillis()- lastClick>200){	
			 lastClick = System.currentTimeMillis();
		
		 synchronized(getHolder()){
			float x = e.getX();
			float y = e.getY();	

		//if(skip.generousCollide(e.getX(), e.getY())){
		//	skip.press(true);
		//}
			for(int a = ninja.size()- 1; a>=0; a--){
		 
	      Ninja1 ninjit = ninja.get(a); 	        
	          if(ninjit.collide(e.getX(),e.getY())){
				playSFX(elly.getCurrentElement()-1);
			if (elly.getCurrentElement()==1){
				 ninja.get(a).loseHealth(5);
				 blood.add(new Sprite2(blood, this, x, y, bloodPic));
			}else{}
		
				 light.add(new SpriteLight(light,this,e.getX(),e.getY(), element));
	  		    			 
				if(ninja.get(a).getHealth()<=0){
					    playSFX(8);
					    int mydeadx= ninja.get(a).getdeadx();
					    int mydeady= ninja.get(a).getdeady();
						ninja.remove(a);			
			          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));   
			          score +=50;	
					}		 
										
			break;
		 }}	
			
		 for(int a = ninja2.size()- 1; a>=0; a--){
			 
		      Ninja1 ninjit = ninja2.get(a); 
			        
		          if(ninjit.collide(e.getX(),e.getY())){
		        	  playSFX(elly.getCurrentElement()-1);
				if (elly.getCurrentElement()==2){
					 ninja2.get(a).loseHealth(5);
					 blood.add(new Sprite2(blood, this, x, y, bloodPic));
				}else{}
			
					 light.add(new SpriteLight(light,this,x,y, element));
		  		    					 
					if(ninja2.get(a).getHealth()<=0){
						    playSFX(8);
						    int mydeadx= ninja2.get(a).getdeadx();
						    int mydeady= ninja2.get(a).getdeady();
							ninja2.remove(a);	
							
				          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));
				          
				          score +=50;
				          
							
						}		 
											
				break;
			 }}	 
		
		 for(int a = ninja3.size()- 1; a>=0; a--){		 
		      Ninja1 ninjit = ninja3.get(a); 	        
		          if(ninjit.collide(e.getX(),e.getY())){
		        	  playSFX(elly.getCurrentElement()-1);
				if (elly.getCurrentElement()==3){
					 ninja3.get(a).loseHealth(5);
					 blood.add(new Sprite2(blood, this, x, y, bloodPic));
				}else{}
			
					 light.add(new SpriteLight(light,this,x,y, element));
		  		    
					 
					if(ninja3.get(a).getHealth()<=0){
						    playSFX(8);
						    int mydeadx= ninja3.get(a).getdeadx();
						    int mydeady= ninja3.get(a).getdeady();
							ninja3.remove(a);	
							
				          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));
				          
				          score +=50;		          							
						}		 										
				break;
			 }}		 
		 for(int a = ninja4.size()- 1; a>=0; a--){
			 
		      Ninja1 ninjit = ninja4.get(a); 
			        
		          if(ninjit.collide(e.getX(),e.getY())){
		        	  playSFX(elly.getCurrentElement()-1);
				//4 is earth i believe
		        	 if (elly.getCurrentElement()==4){
					 ninja4.get(a).loseHealth(5);
					 blood.add(new Sprite2(blood, this, x, y, bloodPic));
				}else{}
				 
		        	 light.add(new SpriteLight(light,this,x,y, element));
		  		    
					 
					if(ninja4.get(a).getHealth()<=0){
						   playSFX(8);
						    int mydeadx= ninja4.get(a).getdeadx();
						    int mydeady= ninja4.get(a).getdeady();
							ninja4.remove(a);	
							
				          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));
				          
				          score +=50;		
						}		 					
				break;
			 }}
		 
		 for(int a = ninja5.size()- 1; a>=0; a--){
			 
		      Ninja1 ninjit = ninja5.get(a); 
			        
		          if(ninjit.collide(e.getX(),e.getY())){
		        	  playSFX(elly.getCurrentElement()-1);
				//4 is earth i believe
		        	 if (elly.getCurrentElement()==3){
					 ninjit.loseHealth(5);
					 blood.add(new Sprite2(blood, this, x, y, bloodPic));
				}else{}
				 
		        	 light.add(new SpriteLight(light,this,x,y, element));
		  		    					 
					if(ninjit.getHealth()<=0){
						   playSFX(9);
						    int mydeadx= ninjit.getdeadx();
						    int mydeady= ninjit.getdeady();
							ninja5.remove(a);	
							
				          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));
				          
				          score +=100;		
						}		 					
				break;
			 }}
		 
		 for(int a = ninja6.size()- 1; a>=0; a--){
			 
		      Ninja1 ninjit = ninja6.get(a); 
			        
		          if(ninjit.collide(e.getX(),e.getY())){
		        	  playSFX(elly.getCurrentElement()-1);
				//4 is earth i believe
		        	 if (elly.getCurrentElement()==1){
					 ninjit.loseHealth(5);
					 blood.add(new Sprite2(blood, this, x, y, bloodPic));
				}else{}
				 
		        	 light.add(new SpriteLight(light,this,x,y, element));
		  		    					 
					if(ninjit.getHealth()<=0){
						   playSFX(9);
						    int mydeadx= ninjit.getdeadx();
						    int mydeady= ninjit.getdeady();
							ninja6.remove(a);	
							
				          dead.add(new DeadButt(dead,this,mydeadx,mydeady,deadness));
				          
				          score +=100;		
						}		 					
				break;
			 }}
		 
		 for(int a = boss.size()- 1; a>=0; a--){			 
		      Boss bossy = boss.get(a); 
		      if(bossy.collide(e.getX(),e.getY())&&!cutScene6){
		    	  playSFX(11);
		    	  bossy.loseHealth(10);
		    	  flash.add(new SpriteLight(flash,this,bossy.getHitX(),bossy.getHitY(), flashImage));	    	  
		      }	    
		 
		 }
		  

		 //give Sprites their shields
		 for(int a = spritely.size()- 1; a>=0; a--){
		      Sprites sprite = spritely.get(a); 
		     if(lvly.getcurrentLevel()!=6){     
		      if(sprite.generousCollide(e.getX(),e.getY())){
			         playSFX(4);
		        	  shield.add(new Shield(shield,sprite,shieldImage));	
		        	  sprite.setShield(true);
			 }}
		     else if(lvly.getcurrentLevel()==6){
			      if(sprite.generousCollide(e.getX(),e.getY())){
					
			        	  shield.add(new Shield(shield,sprite,shieldImage));					
				 	 
		     }}
		 }
		 		 	 
		 for(int a = retry.size()- 1; a>=0; a--){
			Retry rere = retry.get(a);
			if(rere.generousCollide(e.getX(), e.getY())){
				rere.click();
			}			
		 }		 
		 for(int a = starty.size()- 1; a>=0; a--){
				Retry startbutton = starty.get(a);
				if(startbutton.generousCollide(e.getX(), e.getY())){
					startbutton.click();
				}		
			 }
		 for(int a = newy.size()- 1; a>=0; a--){
				Retry newclicker = newy.get(a);
				if(newclicker.generousCollide(e.getX(), e.getY())){
					newclicker.click();
				}		
			 }
		 
		 
		 if(elly.collide(e.getX(), e.getY())){
				elly.determineElement(e.getX());
				ellyChange=true;	
			}
		 
		 for(int a = stars.size()- 1; a>=0; a--){
			Subi subi = stars.get(a);
			if(subi.generousCollide(e.getX(), e.getY())){
				subi.knockOut();
			}			
		 }		
		 
		 
		 
		 }
	 }}//END ACTION DOWN
		
		 
		 if (System.currentTimeMillis()- click2>25){
				
			 click2 = System.currentTimeMillis();
		 if(e.getAction()==MotionEvent.ACTION_MOVE){
			//picks up spites if hit
			 for(int a = spritely.size()- 1; a>=0; a--){
		 
		          Sprites sprite = spritely.get(a); 		 
			 if(lvly.getcurrentLevel()!=6){
		          if(sprite.generousCollide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
					sprite.moveit(e.getX()-20, e.getY()-20);
				}
			}} else if(lvly.getcurrentLevel()==6){
		          if(sprite.OPCollide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
					sprite.moveit(e.getX()-20, e.getY()-20);
				}			 
			 }}
			}
			try{ 
			 if(samurai.generousCollide(e.getX(), e.getY())){
				 if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){
					 samurai.moveIt((int)e.getX()-20,(int)e.getY()-20);
				 }
			 }
			}catch(Exception whee){}
				    
			// This block of code scans for ninjas and moves them if hit
			 
			 for(int a = ninja.size()- 1; a>=0; a--){		 
		          Ninja1 ninjit = ninja.get(a); 		 
			 if(ninjit.collide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
											
					ninjit.moveit(e.getX()-20, e.getY()-20);			 
	
				}}}
			 
			 for(int a = ninja2.size()- 1; a>=0; a--){
				 
		          Ninja1 ninjit = ninja2.get(a); 	
			 
			 if(ninjit.collide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
						
					ninjit.moveit(e.getX()-20, e.getY()-20);			 
		 
			
				}}}	
			 
			 for(int a = ninja3.size()- 1; a>=0; a--){
				 
		          Ninja1 ninjit = ninja3.get(a); 	
			 
			 if(ninjit.collide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
								
					ninjit.moveit(e.getX()-20, e.getY()-20);			 
		 
			
				}}}	
			 
			 for(int a = ninja4.size()- 1; a>=0; a--){
				 
		          Ninja1 ninjit = ninja4.get(a); 	
			 
			 if(ninjit.collide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
							
					ninjit.moveit(e.getX()-20, e.getY()-20);			 	
				}}}		
			 
			 for(int a = ninja5.size()- 1; a>=0; a--){
				 
		          Ninja1 ninjit = ninja5.get(a); 	
			 
			 if(ninjit.collide(e.getX(), e.getY())){
				if((e.getY()<scrnHeight-20 &&e.getY()>20) && (e.getX()<scrnWidth-15 && e.getX()>25)){	
				
					ninjit.moveit(e.getX()-20, e.getY()-20);			 	
				}}}		
					
		 }}				
			
		 		 
		 		 		  
	return true; 
}

    
	public void killMusic(){
		mp.release();
		mp2.release();
		mp3.release();
		mp4.release();
		mp5.release();
	}
	
	public AllmightyThread getLoop(){
		return gameLoop;
	}

public void resume(){
	gameLoop.isRunning(true);
}
	
public boolean checkPause(){
	return isPaused;
}

public void pause(){
	if(isPaused){
		gameLoop.isRunning(false);
	}
}
    
public void isPaused(boolean paused){
    	isPaused=paused;
    }

public int level(){
	return lvly.getcurrentLevel();
}



   private void restart() {
	    stopBackMusic();
		music1On=false;
		music2On=false;
		music3On=false;
		music4On=false;
		music5On=false;
		mp = permMusic1;
		mp2 = permMusic2;
		mp3=permMusic3;
		mp4=permMusic4;
		mp5=permMusic4;
		talkingFor6=false;
		

		if(lvly.getcurrentLevel()==1){
		gameLoop.setTimer(lvl1time);
		}
		if(lvly.getcurrentLevel()==2){
			gameLoop.setTimer(528);
			}
		if(lvly.getcurrentLevel()==3){
			gameLoop.setTimer(720);
			}
		if(lvly.getcurrentLevel()==4){
			gameLoop.setTimer(648);
			}
		if(lvly.getcurrentLevel()==5){
			gameLoop.setTimer(1080);
			}
		win = true;
		createdSprites=false;
		createdSpecial1=false;
		 for(int a = ninja.size()- 1; a>=0; a--){
			 ninja.remove(a);
		 }
		 for(int a = ninja2.size()- 1; a>=0; a--){
			 ninja2.remove(a);
		 }
		 for(int a = ninja3.size()- 1; a>=0; a--){
			 ninja3.remove(a);
		 }
		 for(int a = ninja4.size()- 1; a>=0; a--){
			 ninja4.remove(a);
		 }
		 for(int a = ninja5.size()- 1; a>=0; a--){
			 ninja5.remove(a);
		 }
		 for(int a = ninja6.size()- 1; a>=0; a--){
			 ninja6.remove(a);
		 }
		 
		 for(int a = shield.size()- 1; a>=0; a--){
			 shield.remove(a);
		 }
		 for(int a = ball.size()- 1; a>=0; a--){
			 ball.remove(a);
		 }
		 for(int a = boss.size()- 1; a>=0; a--){
			 boss.remove(a);
		 }
		 for(int a = stars.size()- 1; a>=0; a--){
			 stars.remove(a);
		 }
		 
		createdNinjas=false;
		createdNinjas2=false;
		createdNinjas3=false;
		createdNinjas4=false;
		
		if(lvly.getcurrentLevel()==4)
		createdSam=false;
		createdBoss=false;
		 for(int c = dead.size()-1; c>=0; c--){
        	 dead.remove(c); 
         }
		 for(int c = deadPrince.size()-1; c>=0; c--){
        	 deadPrince.remove(c); 
         }
		 
		 for(int c = blood.size()-1; c>=0; c--){
        	 blood.remove(c); 
         }
		 for(int c = convo.size()-1; c>=0; c--){
        	 convo.remove(c); 
         }
		  
		 score -=200 ;
		 round=1;
		 talkingString = "";
		for(int b = retry.size() -1; b>=0; b--){
       	 retry.remove(b);
        }
	   if(lvly.getcurrentLevel()==6)
		createdSprites=false;
	}


	 public int getScore(){
		 return score;
	 }
     
	 public void HighestScore(int n){
		 HighestScore = n;
	 }
 
	 public LevelManager getLvly(){
		 return lvly;
	 }
	 
	 public void setSaveStuff(SharedPreferences savestuff){
		 myPrefs = savestuff;
	 }
	 
	 
}
