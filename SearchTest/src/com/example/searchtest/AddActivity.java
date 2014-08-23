package com.example.searchtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
/*
public class AddActivity extends Activity {
	private EditText phone;
	private EditText name;
	private Spinner theme;
	private EditText price;
	private EditText userid;
	private EditText password;
	private AsyncTask<Void, Integer, Void> mTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_activity);

		final Spinner theme = (Spinner) findViewById(R.id.theme);
		ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
				R.array.theme, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		theme.setAdapter(adapter2);

		final Toast tv_post = Toast.makeText(this, "Ready", Toast.LENGTH_SHORT);
		Button button = (Button) findViewById(R.id.send);
		button.setOnClickListener(new OnClickListener() {

			mTask = new AsyncTask<Void, Integer, Void>() {

				@Override
				protected Void doInBackground(Void... params) {
					try {
						String url = "http://172.30.20.55";
						HttpClient http = new DefaultHttpClient();
						HttpParams params1 = http.getParams();
						HttpConnectionParams.setConnectionTimeout(params1,
								5000);
						HttpConnectionParams.setSoTimeout(params1, 5000);

						HttpPost httpPost = new HttpPost(url);
						UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(
								dataset, "utf-8");
						httpPost.setEntity(entityRequest);

						HttpResponse responsePost = http.execute(httpPost);
						HttpEntity resEntity = responsePost.getEntity();

						String a = "";
						tv_post.setText(EntityUtils.toString(resEntity));
						tv_post.show();
					} catch (Exception e) {
						e.printStackTrace();
						tv_post.setText("Occur exception");
						tv_post.show();
					}
					return null;
				}

			};
			@Override
			public void onClick(View v) {

				String url = "http://172.30.20.55";
				HttpClient http = new DefaultHttpClient();

				phone = (EditText) findViewById(R.id.in_phone);
				name = (EditText) findViewById(R.id.in_name);
				String position = "" + theme.getSelectedItemPosition();
				price = (EditText) findViewById(R.id.in_price);
				userid = (EditText) findViewById(R.id.in_userid);

				String sphone = phone.getText().toString();
				String sname = name.getText().toString();
				String sprice = price.getText().toString();
				String suserid = userid.getText().toString();

				final ArrayList<BasicNameValuePair> dataset = new ArrayList<BasicNameValuePair>();
				dataset.add(new BasicNameValuePair("telephone", sphone));
				dataset.add(new BasicNameValuePair("subject", sname));
				dataset.add(new BasicNameValuePair("theme", position));
				dataset.add(new BasicNameValuePair("price", sprice));
				dataset.add(new BasicNameValuePair("writer", suserid));

				mTask.execute();
				/*
				 * try { // TODO Auto-generated method stub HttpParams params =
				 * http.getParams();
				 * HttpConnectionParams.setConnectionTimeout(params, 5000);
				 * HttpConnectionParams.setSoTimeout(params, 5000);
				 * 
				 * HttpPost httpPost = new HttpPost(url); UrlEncodedFormEntity
				 * entityRequest = new UrlEncodedFormEntity( dataset, "utf-8");
				 * httpPost.setEntity(entityRequest);
				 * 
				 * HttpResponse responsePost = http.execute(httpPost);
				 * HttpEntity resEntity = responsePost.getEntity();
				 * 
				 * String a = "";
				 * tv_post.setText(EntityUtils.toString(resEntity));
				 * tv_post.show();
				 * 
				 * } catch (Exception e) { e.printStackTrace();
				 * tv_post.setText("Occur exception"); tv_post.show(); }
				 

			}
		});
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
*/