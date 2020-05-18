package com.blackcoder.nmap;

// Author: Billal Fauzan
// Version: 0.1

import android.app.*;
import android.os.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.widget.*;
import android.view.View.OnClickListener;
import android.view.View;
import java.io.IOException;

public class MainActivity extends Activity 
{
	private EditText url;
	private Button btn;
	private TextView result;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		url = findViewById(R.id.url);
		btn = findViewById(R.id.button);
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				try{
					HttpURLConnection client = (HttpURLConnection) new URL("https://api.hackertarget.com/nmap/?q="+url.getText().toString()).openConnection();
					client.setRequestMethod("GET");
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					String line;
					result = findViewById(R.id.result);
					result.setText("            ==== Nmap By Billal Fauzan ====\n");
					while ((line = in.readLine()) != null){
						result.append(line+"\n");
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
    }
}
