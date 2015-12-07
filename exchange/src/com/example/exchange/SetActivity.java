package com.example.exchange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetActivity extends Activity implements OnClickListener{
	
	private EditText edit_1;
	private EditText edit_2;
	private EditText edit_3;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.avtivity_set);
		
		button = (Button) findViewById(R.id.button1);
		edit_1 = (EditText)findViewById(R.id.editText1);
		edit_2 = (EditText)findViewById(R.id.editText2);
		edit_3 = (EditText)findViewById(R.id.editText3);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Intent intent = new Intent(this,MainActivity.class);

		String inputText_1 = edit_1.getText().toString();
		String inputText_2 = edit_2.getText().toString();
		String inputText_3 = edit_3.getText().toString();
		if(inputText_1.length() == 0 || inputText_2.length() == 0|| inputText_3.length() == 0)
		{
			Toast.makeText(SetActivity.this,"输入不能为空",Toast.LENGTH_SHORT).show();
			return;
		}
		
		Intent intent = new Intent();
		intent.putExtra("data",inputText_1+"#"
				+inputText_2+"#"
				+inputText_3);
		
		
		setResult(RESULT_OK,intent);
		finish();
		
		
		
		
//		float	num_1	= Float.parseFloat(inputText_1);
//		float	num_2	= Float.parseFloat(inputText_2);
//		float	num_3	= Float.parseFloat(inputText_3);
		
		
//		switch(v.getId()){
//		case R.id.button_add:
//			
//			
//			int sum 	= num_1 + num_2;
//			textView.setText(String.valueOf(sum));
//			Toast.makeText(MainActivity.this,String.valueOf(sum),Toast.LENGTH_SHORT).show();
//			break;
//		case R.id.button_sub:
//			
//			
//			int value 	= num_1 - num_2;
//			textView.setText(String.valueOf(value));
//			Toast.makeText(MainActivity.this,String.valueOf(value),Toast.LENGTH_SHORT).show();
//			break;
//		default:
		
		
		
	}
	
}