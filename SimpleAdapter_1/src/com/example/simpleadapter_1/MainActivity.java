package com.example.simpleadapter_1;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity {
	private ArrayList<HashMap<String,Object>> list = null;
	private ListView listView;
	
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("test","1");
		list = new ArrayList<HashMap<String,Object>>();
		
		for(int i=0;i<20;i++){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("ItemImage",R.drawable.ic_launcher);
			map.put("ItemTitle","第"+i+"行");
			map.put("ItemText","Hello");
			list.add(map);
		}
		
//		HashMap<String,Object> m1 = new HashMap<String,Object>();
//		HashMap<String,Object> m2 = new HashMap<String,Object>();
//		HashMap<String,Object> m3 = new HashMap<String,Object>();
//		Log.d("test","2");
//		m1.put("ItemImage",R.drawable.ic_launcher);
//		m1.put("ItemTitle","bbc");
//		m1.put("ItemText","aa");
//		
//		m2.put("ItemImage",R.drawable.ic_launcher);
//		m2.put("ItemTitle","bbc");
//		m2.put("ItemText","aa");
//		
//		m3.put("ItemImage",R.drawable.ic_launcher);
//		m3.put("ItemTitle","bbc");
//		m3.put("ItemText","aa");
//		Log.d("test","3");
//		list.add(m1);
//		list.add(m2);
//		list.add(m3);
		
		Log.d("test","4");
		listView = (ListView)findViewById(R.id.user);
		
		SimpleAdapter msimpleAdapter = new SimpleAdapter(this,
				list,//绑定的数据
				R.layout.item,
				new String[] {"ItemImage","ItemTitle","ItemText"},//数据源
				new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});
		listView.setAdapter(msimpleAdapter);
		Log.d("test","5");
		
		
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