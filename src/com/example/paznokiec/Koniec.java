package com.example.paznokiec;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Koniec extends Activity implements OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.koniec);
		
		View v=findViewById(R.id.button1);
		v.setOnClickListener(this);
		View vv=findViewById(R.id.button2);
		vv.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View arg0){
		
		if(arg0.getId()==R.id.button1){
			Intent intent=new Intent(this, SecondActivity.class);
			this.startActivity(intent);
		}
		
		if(arg0.getId()==R.id.button2){
			moveTaskToBack(true);
		}
		
	}
}
