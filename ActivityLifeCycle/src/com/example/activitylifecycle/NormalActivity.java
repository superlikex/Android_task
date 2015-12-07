package com.example.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

class NormalActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.normal_layout);
		
	}

}
