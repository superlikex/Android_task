package com.example.musicplayer_bind;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private  final int PLAY = 1;
	private  final int PAUSE= 2;
	private  final int STOP = 3;
	private  final int EXIT = 4;

//	MediaPlayer mediaPlayer;
	
	MediaPlayer mediaPlayer ;
	private final IBinder binder = new MyBinder();
	
	public class MyBinder extends Binder{
		
		MyService getService(){
			return MyService.this;
		}	
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return binder;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		
		Log.d("test","service oncreate");

		mediaPlayer = MediaPlayer.create(this,R.raw.song);
			
		//mediaPlayer.setDataSource(getResources().openRawResource(R.raw.song));
		mediaPlayer.setLooping(false);
			

		
	}
	public void play(){
		if(!mediaPlayer.isPlaying()){
			mediaPlayer.start();
		}
		
	}
	
	public void pause(){
		if(mediaPlayer.isPlaying()){
			mediaPlayer.pause();
			Log.d("test","cannt pause");
			
		}
		
	}

	public void stop(){
		if(mediaPlayer.isPlaying()){
			mediaPlayer.reset();
			
			mediaPlayer = MediaPlayer.create(this,R.raw.song);
		}

	}

	
	@Override
	public void onDestroy(){
		super.onDestroy();
		if(mediaPlayer != null){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		
	}

}