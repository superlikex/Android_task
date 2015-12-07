package com.example.helloworld_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {

	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	
	private CheckBox cb;
	private EditText  accountEdit;
	private EditText  passwordEdit;
	private Button	  login;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(MainActivity.this,"onCreate",Toast.LENGTH_LONG).show();
		
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		
		accountEdit = (EditText)findViewById(R.id.edit_username);
		passwordEdit = (EditText)findViewById(R.id.edit_password);
		login		= (Button)findViewById(R.id.button_1);
		cb 			= (CheckBox)findViewById(R.id.checkBox_1);
		
//		boolean isRemember  = pref.getBoolean("checkBox_1",false);
//		if(isRemember){
//				String account = pref.getString("account","");
//				String password = pref.getString("password","");
//				accountEdit.setText(account);
//				passwordEdit.setText(password);
//				cb.setChecked(true);
//		}
		String str=load();
		if(!TextUtils.isEmpty(str)){
			accountEdit.setText(str.split(" ")[0]);
			passwordEdit.setText(str.split(" ")[1]);
			cb.setChecked(true);
		}
		login.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v){
					String account = accountEdit.getText().toString();
					String password = passwordEdit.getText().toString();
					
					if(cb.isChecked()){
//						editor.putBoolean("checkBox_1",true);
//						editor.putString("account",account);
//						editor.putString("password",password);
						save(account+" "+password);
//						save(" ");
//						save(password);
						
					}else{
//						editor.clear();
					}
//					editor.commit();
					
				}
			
				
		});
		Log.d("HelloworldActivity","onCreate");
	}
	public void save(String inputText){
		FileOutputStream out = null;
		BufferedWriter writer =null;
		
		try{
			out = openFileOutput("data",Context.MODE_PRIVATE);
			writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write(inputText);
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
			if (writer != null){
					writer.close();
				}
			}catch (IOException e){
					e.printStackTrace();
			}
		}
		
	}
	public String load(){
		FileInputStream in = null;
		BufferedReader reader = null;
		StringBuilder content = new StringBuilder();
		try{
			in = openFileInput("data");
			reader =new BufferedReader(new InputStreamReader(in));
			String line= "";
			while((line = reader.readLine()) != null){
				content.append(line);
			}
		}catch(IOException e){
				e.printStackTrace();
//				Log.d("bug", "ewfwegfew");
		}finally{
			if(reader!= null){
				
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}
		}
		Toast.makeText(MainActivity.this,String.valueOf(content.toString().length()),Toast.LENGTH_SHORT).show();
		return content.toString();
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
}
