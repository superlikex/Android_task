package com.example.musicplayer_bind;

import com.example.musicplayer_bind.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayActivity extends Activity implements OnClickListener{
	
	private Button play;
	private Button pause;
	private Button stop;
	private Button close;
	private Button exit;
	
	private String rec_data;
	
	private MyService musicService;
	
	private ServiceConnection sc = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
		
			musicService = ((MyService.MyBinder)(service)).getService();	
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}	
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		Intent rec_intent = getIntent();
		rec_data   = rec_intent.getStringExtra("data");
		Log.d("test","rec_intent"+rec_data);
		
		play  = (Button)findViewById(R.id.bt_play);
		pause = (Button)findViewById(R.id.bt_pause);
		stop  = (Button)findViewById(R.id.bt_stop);
		close = (Button)findViewById(R.id.bt_close);
		exit  = (Button)findViewById(R.id.bt_exit);
		
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		stop.setOnClickListener(this);
		close.setOnClickListener(this);
		exit.setOnClickListener(this);
		
		connection();
		
		
		
	}

	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		int op = -1;
		Intent intent = new Intent(this,MyService.class);
//		intent.setAction("com.example.musicplayer.MyService");
		switch(v.getId()){
		case R.id.bt_play:
			musicService.play();
			Log.d("test","ONClick play");
			break;
		case R.id.bt_pause:
			musicService.pause();
			Log.d("test","ONClick pause");
			break;
		case R.id.bt_stop:
			musicService.stop();
			Log.d("test","ONClick stop");
			break;
		case R.id.bt_close:
			Log.d("test","ONClick close");
			this.finish();
			break;
		case R.id.bt_exit:
			Log.d("test","ONClick exit");
			op = 4;
			Intent stopIntent = new Intent(this,MyService.class);
			unbindService(sc);
			stopService(stopIntent);
			this.finish();
			return;
			
		}
	//	Bundle bundle = new Bundle();
		intent.putExtra("data",op +"#"+rec_data);
		Log.d("test","startservice"+op+"#"+rec_data);
		
		startService(intent);
		
		
	}
	
	private void  connection(){
		Intent intent = new Intent(this,MyService.class);
		bindService(intent,sc,BIND_AUTO_CREATE);
		
	}
	

}