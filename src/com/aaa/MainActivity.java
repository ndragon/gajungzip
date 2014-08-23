package com.aaa;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner place;
	Spinner theme;
	EditText price;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		//레이아웃 연결

		place = (Spinner) findViewById(R.id.place);
		theme = (Spinner) findViewById(R.id.theme);
		price = (EditText) findViewById(R.id.editText1);
		
		//아이디 지정
		
		
		
		ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,
				R.array.place, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		place.setAdapter(adapter1);
		
		place.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> local, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), local.getItemAtPosition(position).toString() + " 선택하셨습니다.", 
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	//1번 지역 스피너 연결
		
		ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
				R.array.theme, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		theme.setAdapter(adapter2);
		
		theme.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> theme, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), theme.getItemAtPosition(position).toString() + " 선택하셨습니다.", 
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//2번 테마 스피너 연결
		
		
		
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(	) {

					@Override
					public void onClick(View v) {
						String local = place.getSelectedItem().toString();
						String theme1 = theme.getSelectedItem().toString();
						String price1 = price.getText().toString();
						//각 스피너 값 스트링에 저장
						
						Intent intent = new Intent(MainActivity.this, SecondActivity.class);
						intent.putExtra("local", price1);
						intent.putExtra("theme", theme1);
						intent.putExtra("price", price1);
						
						
						
						try
						{
						  HttpClient client = new DefaultHttpClient();  
						  String postURL = "주소변경";
						  HttpPost post = new HttpPost(postURL); 
						 
						  List<NameValuePair> params = new ArrayList<NameValuePair>();
						  params.add(new BasicNameValuePair("local", local));
						  params.add(new BasicNameValuePair("theme", theme1));
						  params.add(new BasicNameValuePair("price", price1));
						 
						  UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
						  post.setEntity(ent);
						  HttpResponse responsePOST = client.execute(post);  
						  HttpEntity resEntity = responsePOST.getEntity();
						 
						  if (resEntity != null)
						  {    
						    Log.i("RESPONSE", EntityUtils.toString(resEntity));
						  }
						}
						catch (Exception e)
						{
						  e.printStackTrace();
						}
						
						
						
						startActivity(intent);
					}
		});
		//버튼으로 인텐트 이동
		
		
	}



}
