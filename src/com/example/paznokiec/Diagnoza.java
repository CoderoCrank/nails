package com.example.paznokiec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Diagnoza extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.wynik);
		
		View v=findViewById(R.id.button1);
		v.setOnClickListener(this);
		
		Bundle extras=getIntent().getExtras();
		String diagnoza=extras.getString("diagnoza");
		TextView txt=(TextView)findViewById(R.id.diagnoza);
		txt.setText(diagnoza);
	}
	
	@Override
	public void onClick(View arg0){
		if(arg0.getId()==R.id.button1){
			Intent intent=new Intent(this, Koniec.class);
			this.startActivity(intent);
		}
	}
	
}
