package com.example.calculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	
	private Button button_1,button_2;
	private EditText editText_1,editText_2;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText_1 	= (EditText) findViewById(R.id.number_1);
		editText_2 	= (EditText) findViewById(R.id.number_2);
	
		button_1	= (Button) findViewById(R.id.button_add);
		button_2	= (Button) findViewById(R.id.button_sub);
		textView	= (TextView) findViewById(R.id.text_sum);
		
		button_1.setOnClickListener((OnClickListener)this);
		button_2.setOnClickListener((OnClickListener)this);
		
		
	}
	@Override
	public void onClick(View v){
		String inputText_1 = editText_1.getText().toString();
		String inputText_2 = editText_2.getText().toString();
		
		if(inputText_1.length() == 0 || inputText_2.length() == 0)
		{
			Toast.makeText(MainActivity.this,"输入不能为空",Toast.LENGTH_SHORT).show();
			return;
		}
		float	num_1	= Float.parseFloat(inputText_1);
		float	num_2	= Float.parseFloat(inputText_2);
		
		switch(v.getId()){
		case R.id.button_add:
			
			
			float sum 	= num_1 + num_2;
			textView.setText(String.valueOf(sum));
			Toast.makeText(MainActivity.this,String.valueOf(sum),Toast.LENGTH_SHORT).show();
			break;
		case R.id.button_sub:
			
			
			float value 	= num_1 - num_2;
			textView.setText(String.valueOf(value));
			Toast.makeText(MainActivity.this,String.valueOf(value),Toast.LENGTH_SHORT).show();
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
