package com.example.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt_send;
	private EditText edit_text;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		bt_send = (Button)findViewById(R.id.button1);
		edit_text = (EditText)findViewById(R.id.editText1);
		
		bt_send.setOnClickListener(this);
		 
		
	}
	@Override
	public void onClick(View v){
		if(edit_text.getText().toString().length()<1)
		{
				Toast.makeText(MainActivity.this, "请输入发送内容", Toast.LENGTH_SHORT).show();
				
				
				return;
		}
		switch(v.getId()){
		case R.id.button1:
			Intent intent = new Intent();
			intent.setAction("com.example.broadcast.MYBROADCAST");//action 设置的值为自定义，要与清单中的一致
			intent.putExtra("content", edit_text.getText().toString().trim());//trim（）去掉前后的空字符
			sendBroadcast(intent);
			Toast.makeText(MainActivity.this, "已发送", Toast.LENGTH_SHORT).show();
			Log.d("tag1","1");
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
