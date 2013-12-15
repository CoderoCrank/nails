package com.example.paznokiec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondActivity extends Activity implements OnClickListener {
	
	private RadioGroup radio1;
	private RadioButton value0;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.second);
		
		View v=findViewById(R.id.button1);
		v.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0){
		
		
		
		if(arg0.getId()==R.id.button1){
			
			radio1=(RadioGroup)findViewById(R.id.radioGroup1);
			int selectedoption=radio1.getCheckedRadioButtonId();
			value0=(RadioButton)findViewById(selectedoption);
			
			if(value0.getText().equals("草速y")){
			Intent intent=new Intent(this, ThirdActivity.class);
			this.startActivity(intent);
			}
			else if(value0.getText().equals("Bia造")){
				Intent intent=new Intent(this, BialyActivity.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Szaroniebieski")){
				Intent intent=new Intent(this, SzaroniebieskiActivity.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Br頊owy")){
				Intent intent=new Intent(this, BrazowyActivity.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Zielony")){
				Intent intent=new Intent(this, ZielonyActivity.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Czarny")){
				Intent intent=new Intent(this, CzarnyActivity.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Rozdwojenie")){
				Intent intent=new Intent(this, Rozdwajanie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Zanikanie p造tki")){
				Intent intent=new Intent(this, Zanikanie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("ζmliwe i kruche")){
				Intent intent=new Intent(this, Lamliwosc.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Pogrubienie p造tki")){
				Intent intent=new Intent(this, Pogrubienie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Wg喚bienia")){
				Intent intent=new Intent(this, Wglebienie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Matowienie")){
				Intent intent=new Intent(this, Matowienie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Bruzdy")){
				Intent intent=new Intent(this, Bruzdy.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("ㄊ瞠czkowaty kszta速")){
				Intent intent=new Intent(this, Lyzkowaty.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Uwypuklenie p造tki")){
				Intent intent=new Intent(this, Uwypuklenie.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Szponowaty kszta速")){
				Intent intent=new Intent(this, Szponowaty.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Zwini璚ie w rulonik")){
				Intent intent=new Intent(this, Rulonik.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Grzybica")){
				Intent intent=new Intent(this, Grzybica.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Dro盥篡ca")){
				Intent intent=new Intent(this, Drozdzyca.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Zanokcica")){
				Intent intent=new Intent(this, Zanokcica.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("ㄆszczyca")){
				Intent intent=new Intent(this, Luszczyca.class);
				this.startActivity(intent);
			}
			else if(value0.getText().equals("Onychioza")){
				Intent intent=new Intent(this, Onychioza.class);
				this.startActivity(intent);
			}

		}
	}
	
}
