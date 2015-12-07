package com.example.httpclient_test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	
	private Button btsend;
	private Button btclear;
	private TextView textView;
	public 	static final int SHOW_RESPONSE =0 ;
	
	private Handler handler = new Handler(){
		
		public void handleMessage(Message msg){
			switch(msg.what){
			case SHOW_RESPONSE:
				String response = (String)msg.obj;
				textView.setText(response);
				//textView.setText("response");
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btsend = (Button)findViewById(R.id.bt_send);
		btclear = (Button)findViewById(R.id.bt_clear);
		textView = (TextView)findViewById(R.id.textView1);
		
		btsend.setOnClickListener(this);
		btclear.setOnClickListener(this);
	}
		
		
		
		
			
		@Override 
		public void onClick(View v){
				if(v.getId() ==R.id.bt_send){
					sendRequestWithHttpClient();
					
				}else if(v.getId() ==R.id.bt_clear){
					textView.setText("");
				}
			
		}
	
	private void sendRequestWithHttpClient(){
		new Thread(new Runnable(){
			
			@Override
			
			public void run(){
				try{
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet("http://www.baidu.com");
					HttpResponse httpResponse=httpClient.execute(httpGet);
					
					if( httpResponse.getStatusLine().getStatusCode() == 200){
						
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity,"utf-8");//转换成字符串
						
						Message message = new Message();
						message.what = SHOW_RESPONSE;
						message.obj = response.toString();
						handler.sendMessage(message);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
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
