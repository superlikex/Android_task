package com.example.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReceiveActivity extends Activity {
	private TextView rece_text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("tag1","3");
		
		setContentView(R.layout.second_layout);
		rece_text = (TextView) findViewById(R.id.textView2);
		
		Intent intent = getIntent();//获取启动时的intent
		rece_text.setText(intent.getStringExtra("content"));
	
		//rece_text.setText("haha");
	    //	rece_text.setText("ddd");
	}
	

}
