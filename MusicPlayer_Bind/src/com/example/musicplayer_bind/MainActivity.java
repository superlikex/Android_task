package com.example.musicplayer_bind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button bt_1;
	private Button bt_2;
	private int current_music;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_1 = (Button)findViewById(R.id.button1);
	//	bt_2 = (Button)findViewById(R.id.button2);
		
		bt_1.setOnClickListener(this);
	//	bt_2.setOnClickListener(this);
		
		
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,PlayActivity.class);
//		switch (v.getId()){
//		case R.id.button1:
			current_music = 1;
//			break;
//		case R.id.button2:
//			current_music = 2;
//			break;
//		default:
//			break;

//		}
		intent.putExtra("data",String.valueOf(current_music));
		startActivity(intent);
		
	}
}
