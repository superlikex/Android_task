package com.example.notifiacation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;




@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt_send,bt_cancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_send = (Button)findViewById(R.id.button1);
		bt_cancel = (Button)findViewById(R.id.button2);
		
		bt_send.setOnClickListener(this);
		bt_cancel.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v){
		NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);//对通知管理
		switch(v.getId()){
		case R.id.button1:
			
			/***************坑**************/
		   //Notification notification = new Notification(R.drawable.icon,"新通知",System.currentTimeMillis());//存储通知所需信息
		   //Notification notification = new Notification(R.drawable.icon,"edfe",System.currentTimeMillis());
		   //Notification notification = new Notification.Builder(this);
			
	   	Intent intent = new Intent(this,NotificationActivity.class);
		PendingIntent p = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
			//notification.setLatestEventInfo(MainActivity.this,"你好","今天过得好吗",null);//布局
		    //notification.setLatestEventInfo(getApplicationContext(),"edf","wef",null);
		    //manager.notify(1,notification);//显示
			
			//http://www.piaoyi.org/mobile-app/Android-setLatestEventInfo-Handler-SimpleDateFormat.html
		//API23
			Notification notification = new Notification.Builder(this)    
	         .setAutoCancel(true)    
	         .setContentTitle("title")    
	         .setContentText("describe")    
	         .setContentIntent(p)    
	         .setSmallIcon(R.drawable.ic_launcher)    
	         .setWhen(System.currentTimeMillis())    
	         .build();   
			manager.notify(1,notification);//显示
			break;
		case R.id.button2:
			manager.cancel(1);
			break;
		default:
			break;
				
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
