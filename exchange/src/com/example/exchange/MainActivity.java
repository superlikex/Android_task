package com.example.exchange;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener,OnClickListener{
	
	private double value0 = 6.403;//默认汇率值，可用过设置更改
	private double value1 = 6.983;//汇率值
	private double value2 = 9.673;//汇率值
	private double value_rate = value0;
	private double value_input = 0;
	
	
	private Button  mybutton;
	private Spinner myspinner;
	private ArrayAdapter<String> _Adapter;
	private String[]	items ={"美元","英镑","欧元"};
	private EditText 	edit_1,edit_2;
	
	private final int MY = 0;
	private final int YB = 1;
	private final int OY = 2;
	private int	 choice = MY;
	
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("test","returnedData");
		
		myspinner = (Spinner) findViewById(R.id.spinner1);
		mybutton = (Button)findViewById(R.id.button1);
		edit_1 = (EditText) findViewById(R.id.editText1);
		edit_2 = (EditText) findViewById(R.id.editText2);
		
		_Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
		_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		myspinner.setAdapter(_Adapter);
		myspinner.setOnItemSelectedListener(this);
		mybutton.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu ) {
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
			Intent intent = new Intent(MainActivity.this,SetActivity.class);
			startActivityForResult(intent,1);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/***获取设置setactivity的返回值**/
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		if(requestCode == 1){
			if(resultCode == RESULT_OK){
				String returnedData = data.getStringExtra("data");
				Log.d("test",returnedData);
				value0 = Float.parseFloat(returnedData.split("#")[0]);	//类型转换
				value1 = Float.parseFloat(returnedData.split("#")[1]);	
				value2 = Float.parseFloat(returnedData.split("#")[2]);	
				
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String input_1,input_2;
		double num_1,num_2;
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.000");//四舍五入
		
		input_1 = edit_1.getText().toString();
		
		if(input_1.length() == 0 )//|| inputText_2.length() == 0)
		{
			Toast.makeText(MainActivity.this,"输入不能为空",Toast.LENGTH_SHORT).show();
			//return;
			return;
		}
		value_input = Float.parseFloat(input_1);
		switch (choice){
		case MY:
			value_rate = value0;
			break;
		case YB:
			value_rate = value1;
			break;
		case OY:
			value_rate = value2;
			break;
		}
		//if(v.getId() == R.id.button1){
			edit_2.setText(String.valueOf( df.format(value_rate*value_input)) );
		//}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
//		Toast.makeText(MainActivity.this,_Adapter.getItem(position), Toast.LENGTH_SHORT).show();
		
//		String input_1,input_2;
//		float num_1,num_2;
//	
//		input_1 = edit_1.getText().toString();
//		
//		if(input_1.length() == 0 )//|| inputText_2.length() == 0)
//		{
//			Toast.makeText(MainActivity.this,"null",Toast.LENGTH_SHORT).show();
//			//return;
//			return;
//		}
//		value_input = Float.parseFloat(input_1);
		
		//Toast.makeText(MainActivity.this,String.valueOf(position), Toast.LENGTH_SHORT).show();
		switch(position){
		case  MY://Toast.makeText(MainActivity.this,edit_1.getText().toString(),Toast.LENGTH_SHORT).show();
			choice = MY;
			//value_rate = value0;
//			edit_2.setText(String.valueOf(num_1));
		//	Toast.makeText(MainActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
			break;
		case  YB://Toast.makeText(MainActivity.this,edit_1.getText().toString(),Toast.LENGTH_SHORT).show();
			//value_rate = value1;
			choice = YB;
//			edit_2.setText(String.valueOf(num_1));
			break;
		case  OY://Toast.makeText(MainActivity.this,edit_1.getText().toString(),Toast.LENGTH_SHORT).show();
//			edit_2.setText(String.valueOf(num_1));
			//value_rate = value2;
			choice = OY;
			break;
		default :
			break;
			
		}
		return;
		
	}
	 
		  
         
     

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
	