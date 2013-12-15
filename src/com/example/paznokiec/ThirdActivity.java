package com.example.paznokiec;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity implements OnClickListener {
	
	private ImageView image;
	private RadioGroup radioGroupID0;
	private RadioGroup radioGroupID1;
	private RadioGroup radioGroupID2;
	private RadioGroup radioGroupID3;
	private RadioGroup radioGroupID4;
	private RadioGroup radioGroupID5;
	private RadioButton value0, value1, value2, value3, value4, value5;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.third);
		image=(ImageView)findViewById(R.id.imageView1);
		View v=findViewById(R.id.button2);
		v.setOnClickListener(this);
		View vv=findViewById(R.id.button1);
		vv.setOnClickListener(this);
	}
	
	public void addButtonListener(){
		radioGroupID0=(RadioGroup)findViewById(R.id.radioGroup1);
		radioGroupID1=(RadioGroup)findViewById(R.id.radioGroup2);
		radioGroupID2=(RadioGroup)findViewById(R.id.radioGroup3);
		radioGroupID3=(RadioGroup)findViewById(R.id.radioGroup4);
		radioGroupID4=(RadioGroup)findViewById(R.id.radioGroup5);
		radioGroupID5=(RadioGroup)findViewById(R.id.radioGroup6);
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode==1 && resultCode==RESULT_OK && data!=null){
			Uri pickedImage=data.getData();
			String[] filePath={MediaStore.Images.Media.DATA};
			Cursor cursor=getContentResolver().query(pickedImage, filePath, null, null, null);
			cursor.moveToFirst();
			String imagePath=cursor.getString(cursor.getColumnIndex(filePath[0]));
			image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
			cursor.close();
			
		}
	}
	
	@Override
	public void onClick(View arg0){
		
		if(arg0.getId()==R.id.button2){
			radioGroupID0=(RadioGroup)findViewById(R.id.radioGroup1);
			radioGroupID1=(RadioGroup)findViewById(R.id.radioGroup2);
			radioGroupID2=(RadioGroup)findViewById(R.id.radioGroup3);
			radioGroupID3=(RadioGroup)findViewById(R.id.radioGroup4);
			radioGroupID4=(RadioGroup)findViewById(R.id.radioGroup5);
			radioGroupID5=(RadioGroup)findViewById(R.id.radioGroup6);
			int selectedOption1=radioGroupID0.getCheckedRadioButtonId();
			int selectedOption2=radioGroupID1.getCheckedRadioButtonId();
			int selectedOption3=radioGroupID2.getCheckedRadioButtonId();
			int selectedOption4=radioGroupID3.getCheckedRadioButtonId();
			int selectedOption5=radioGroupID4.getCheckedRadioButtonId();
			int selectedOption6=radioGroupID5.getCheckedRadioButtonId();
			value0=(RadioButton)findViewById(selectedOption1);
			value1=(RadioButton)findViewById(selectedOption2);
			value2=(RadioButton)findViewById(selectedOption3);
			value3=(RadioButton)findViewById(selectedOption4);
			value4=(RadioButton)findViewById(selectedOption5);
			value5=(RadioButton)findViewById(selectedOption6);
			
			String message=null;
			if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE") && value5.getText().equals("NIE")){
				message="Nie zosta�y wykryte �adne choroby, zmiany koloru nie s� szkodliwe, �adna z okre�lonych podejrze� chor�b nie potwierdzi�o si�. Je�li odcie� nie minie, zalecany jest kontakt z lekarzem w celu dodatkowych bada�. Sprawd� te� inne choroby umieszczone w aplikacji.";
			}
			else if(value0.getText().equals("TAK") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE") && value5.getText().equals("NIE")){
				message="Odcie� ��tego na paznokciach jest spowodowany przez palenie papieros�w. Zalecamy rzuci� palenie.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("TAK") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE") && value5.getText().equals("NIE")){
				message="Odcie� ��tego na paznokciach jest spowodowany efektem ubocznym za�ywanych lek�w, skonsultuj si� z lekarzem lub farmaceut� i popro� o zamienniki. ";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("TAK") && value3.getText().equals("NIE") && value4.getText().equals("NIE") && value5.getText().equals("NIE")){
				message="Odcie� ��tego na paznokciach jest spowodowany chorob� na �uszczyc�. ";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("TAK") && value4.getText().equals("NIE") && value5.getText().equals("NIE")){
				message="Odcie� ��tego na paznokciach jest spowodowany chorob� na grzybic�. ";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("TAK") && value5.getText().equals("NIE")){
				message="Odcie� ��tego na paznokciach jest spowodowany chorob� na ��taczk�.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE") && value5.getText().equals("TAK")){
				message="Odcie� ��tego na paznokciach jest spowodowany zbyt cz�stym malowaniem paznokci na czerwono i zosta�y one przebarwione. Zalecane jest stosowanie lakieru bazowego przed na�o�eniem lakieru czerwonego.";
			}
			else {
				message="";
			}
			
			/*AlertDialog alertDialog=new AlertDialog.Builder(ThirdActivity.this).create();
			alertDialog.setTitle("Alert");
			alertDialog.setMessage(value0.getText() + " " + value1.getText() + " " + value2.getText() + " " + value3.getText() + " " + value4.getText() + " " + value5.getText());
			alertDialog.show();*/ 
			
			Intent intent=new Intent(this, Diagnoza.class);
			intent.putExtra("diagnoza", message);
			this.startActivity(intent);
		}
		
		if(arg0.getId()==R.id.button1){
			//Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
			//fileIntent.setType("*/*"); 
			//startActivityForResult(fileIntent, 0);
			
			Intent i=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i, 1);
		}
		
		TextView txt7=(TextView)findViewById(R.id.textView7);
		txt7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context=getApplicationContext();
				CharSequence text="�uszczyca cechuje si� obecno�ci� poprzecznych rowk�w i zag��bie� w p�ytce paznokciowej";
				final Toast toast=Toast.makeText(context, text, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				
			}
		});
		
		TextView txt9=(TextView)findViewById(R.id.textView9);
		txt9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context=getApplicationContext();
				CharSequence text="Grzybica: zaka�ony paznokie� traci swe r�owe zabarwienie, ulega pobruzdowaniu i �atwo si� kruszy.";
				final Toast toast=Toast.makeText(context, text, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				
			}
		});
		
		TextView txt11=(TextView)findViewById(R.id.textView11);
		txt11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context=getApplicationContext();
				CharSequence text="��taczka: objaw polegaj�cy na za��ceniu sk�ry, b�on �luzowych i bia�k�wki oczu.";
				final Toast toast=Toast.makeText(context, text, Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});
	}
	
}
