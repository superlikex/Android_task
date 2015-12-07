package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(MainActivity.this,"onCreate",Toast.LENGTH_LONG).show();
		Log.d("HelloworldActivity","onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Toast.makeText(MainActivity.this,"onCreateOptionsMenu",Toast.LENGTH_LONG).show();
		Log.i("HelloworldActivity","onCreateOptionsMenu");
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
		Toast.makeText(MainActivity.this,"onOptionsItemSelected",Toast.LENGTH_LONG).show();
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onStart(){
		super.onStart();
		Toast.makeText(MainActivity.this,"onStart",Toast.LENGTH_LONG).show();
		Log.d("HelloworldActivity","onStart");
		
	}
	public void onPause(){
		super.onPause();
		Toast.makeText(MainActivity.this,"onStop",Toast.LENGTH_LONG).show();
		Log.d("HelloworldActivity","onPause");
		
	}
	public void onStop(){
		super.onStop();
		Toast.makeText(MainActivity.this,"onStop",Toast.LENGTH_LONG).show();
		Log.d("HelloworldActivity","onStop");
		
	}
	public void onDestory(){
		super.onStop();
		Toast.makeText(MainActivity.this,"onDestory",Toast.LENGTH_LONG).show();
		Log.d("HelloworldActivity","onDeatory");
		
	}
}
