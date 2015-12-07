package com.example.databasetest;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private MyDatabaseHelper dbHelper;
	
	private Button add;
	private Button delete;
	private Button update;
	private Button query;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new MyDatabaseHelper(this,"StaffManager.db",null,1);
		//Button createDatabase = (Button)findViewById(R.id.create_database);
		//Button addData = (Button)findViewById(R.id.add_data);
		SQLiteDatabase db = dbHelper.getWritableDatabase();//创建数据库
		
		Button add = (Button)findViewById(R.id.bt_add);//绑定空间
		Button delete = (Button)findViewById(R.id.bt_delete);
		Button update = (Button)findViewById(R.id.bt_update);
		Button query = (Button)findViewById(R.id.bt_query);
		
		
		add.setOnClickListener(this);
		delete.setOnClickListener(this);
		update.setOnClickListener(this);
		query.setOnClickListener(this);
		

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
		Intent intent = new Intent(this,AddActivity.class);;
		switch(v.getId())
		{
		case R.id.bt_add:
			 intent = new Intent(this,AddActivity.class);
			 
			break;
		case R.id.bt_delete:
			 intent = new Intent(this,DeleteActivity.class);
			break;
		case R.id.bt_update:
			 intent = new Intent(this,UpdateActivity.class);
			break;
		case R.id.bt_query:
			 intent = new Intent(this,QueryActivity.class);
			break;
		}
		
		startActivity(intent);
		
		
	}
}
