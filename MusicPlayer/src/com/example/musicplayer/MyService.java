package com.example.musicplayer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private  final int PLAY = 1;
	private  final int PAUSE= 2;
	private  final int STOP = 3;
	private  final int EXIT = 4;

//	MediaPlayer mediaPlayer;
	
	MediaPlayer mediaPlayer ;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//	mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
	@Override
	public void onCreate(){
		super.onCreate();
		
		Log.d("test","service oncreate");
		//if(mediaPlayer == null){
//	mediaPlayer = getMediaPlayer(this);
		//	mediaPlayer.setAudioStreamType(AudioManager.STREAM_VOICE_CALL); 
			
//			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			//mediaPlayer.reset();
			//mediaPlayer.release();
//			mediaPlayer.stop();
		mediaPlayer = MediaPlayer.create(this,R.raw.song);
			
		//mediaPlayer.setDataSource(getResources().openRawResource(R.raw.song));
		mediaPlayer.setLooping(false);
			
//			try{
//				mediaPlayer.prepareAsync();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
			
	//	}
		
	}
//	static MediaPlayer getMediaPlayer(Context context){
//
//	    MediaPlayer mediaplayer = new MediaPlayer();
//
//	    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.KITKAT) {
//	        return mediaplayer;
//	    }
//
//	    try {
//	        Class<?> cMediaTimeProvider = Class.forName( "android.media.MediaTimeProvider" );
//	        Class<?> cSubtitleController = Class.forName( "android.media.SubtitleController" );
//	        Class<?> iSubtitleControllerAnchor = Class.forName( "android.media.SubtitleController$Anchor" );
//	        Class<?> iSubtitleControllerListener = Class.forName( "android.media.SubtitleController$Listener" );
//
//	        Constructor constructor = cSubtitleController.getConstructor(new Class[]{Context.class, cMediaTimeProvider, iSubtitleControllerListener});
//
//	        Object subtitleInstance = constructor.newInstance(context, null, null);
//
//	        Field f = cSubtitleController.getDeclaredField("mHandler");
//
//	        f.setAccessible(true);
//	        try {
//	            f.set(subtitleInstance, new Handler());
//	        }
//	        catch (IllegalAccessException e) {return mediaplayer;}
//	        finally {
//	            f.setAccessible(false);
//	        }
//
//	        Method setsubtitleanchor = mediaplayer.getClass().getMethod("setSubtitleAnchor", cSubtitleController, iSubtitleControllerAnchor);
//
//	        setsubtitleanchor.invoke(mediaplayer, subtitleInstance, null);
//	        //Log.e("", "subtitle is setted :p");
//	    } catch (Exception e) {}
//
//	    return mediaplayer;
//	}
	static int op = -1,num_song = -1,num_song_old =-1,flag = 0;
	@Override
	public int onStartCommand (Intent intent,int flags,int startId){
		Log.d("test","onstartCommand");
		
		
		if(intent != null){
			String recv = intent.getStringExtra("data");
			Log.d("test","recv "+recv);
			op = Integer.parseInt(recv.split("#")[0]);//获取操作
			
			num_song = Integer.parseInt(recv.split("#")[1]);//获取曲目
			//num_song = num_song_next;
			if(flag == 0 )
			{
				num_song_old = num_song;
				flag = 1;
			}
			
			Log.d("test",String.valueOf(op));
			Log.d("test","num_song+++++++++"+num_song);
			Log.d("test","num_song next+++++++++"+num_song_old);
			if(num_song != num_song_old)
			{
				//flag = 0;
				num_song_old = num_song;
				mediaPlayer.reset();
				switch(num_song){
				case 1:
					mediaPlayer = MediaPlayer.create(this,R.raw.song);
					break;
				case 2:
					mediaPlayer = MediaPlayer.create(this,R.raw.song2);
					break;
				}
				
			}
			
			switch (op){
			
			case PLAY:
				if(!mediaPlayer.isPlaying()){
					
					mediaPlayer.start();
				}
				break;
			case PAUSE:
				if(mediaPlayer.isPlaying()){
					mediaPlayer.pause();
					Log.d("test","cannt pause");
					
				}
				break;
			case STOP:
				if(mediaPlayer.isPlaying()){
					mediaPlayer.reset();
					
					switch(num_song){
					case 1:
						mediaPlayer = MediaPlayer.create(this,R.raw.song);
					case 2:
						mediaPlayer = MediaPlayer.create(this,R.raw.song2);
						
					}
					
					mediaPlayer.setLooping(false);
					
					
				}
				break;
			case EXIT:
				break;
			
			
			}
				
			
			
			
			
		}
		
		
		
		
		return super.onStartCommand(intent, flags, startId);
		
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
