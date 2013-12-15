package com.example.paznokiec;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BialyActivity extends Activity implements OnClickListener {
	
	private ImageView image;
	private RadioGroup radioGroupID0;
	private RadioGroup radioGroupID1;
	private RadioGroup radioGroupID2;
	private RadioGroup radioGroupID3;
	private RadioGroup radioGroupID4;
	private RadioButton value0, value1, value2, value3, value4;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.bialy);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getId()==R.id.button2){
			radioGroupID0=(RadioGroup)findViewById(R.id.radioGroup1);
			radioGroupID1=(RadioGroup)findViewById(R.id.radioGroup2);
			radioGroupID2=(RadioGroup)findViewById(R.id.radioGroup3);
			radioGroupID3=(RadioGroup)findViewById(R.id.radioGroup4);
			radioGroupID4=(RadioGroup)findViewById(R.id.radioGroup5);
			int selectedOption1=radioGroupID0.getCheckedRadioButtonId();
			int selectedOption2=radioGroupID1.getCheckedRadioButtonId();
			int selectedOption3=radioGroupID2.getCheckedRadioButtonId();
			int selectedOption4=radioGroupID3.getCheckedRadioButtonId();
			int selectedOption5=radioGroupID4.getCheckedRadioButtonId();
			value0=(RadioButton)findViewById(selectedOption1);
			value1=(RadioButton)findViewById(selectedOption2);
			value2=(RadioButton)findViewById(selectedOption3);
			value3=(RadioButton)findViewById(selectedOption4);
			value4=(RadioButton)findViewById(selectedOption5);
			
			String message=null;
			if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE")){
				message="Nie zosta�y wykryte �adne choroby, zmiany koloru nie s� szkodliwe, �adna z okre�lonych podejrze� chor�b nie potwierdzi�o si�. Je�li odcie� nie minie, zalecany jest kontakt z lekarzem w celu dodatkowych bada�. Sprawd� te� inne choroby umieszczone w aplikacji.";
			}
			else if(value0.getText().equals("TAK") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE")){
				message="Prosz� zwi�kszy� spo�ywanie wapnia w posi�kach. Najprawdopodobniej paznokcie s� odwapnione.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("TAK") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("NIE")){
				message="Prosz� zwi�kszy� spo�ywanie wapnia w posi�kach. Najprawdopodobniej paznokcie s� odwapnione.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("TAK") && value3.getText().equals("NIE") && value4.getText().equals("NIE")){
				message="Bia�e przebarwienie paznokci wynika z niewydolno�ci serca lub nerek. Zaleca si� kontakt z lekarzem lub farmaceut� w celu ustalenia dodatkowego leku usuwaj�cego przebarwienie.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("TAK") && value4.getText().equals("NIE")){
				message="Prosimy wzbogaci� swoj� diet� o produkty bogate w w�glowodany.";
			}
			else if(value0.getText().equals("NIE") && value1.getText().equals("NIE") && value2.getText().equals("NIE") && value3.getText().equals("NIE") && value4.getText().equals("TAK")){
				message="Naturalnie bia�e paznokcie s� spowodowane brakiem produkt�w bogatych w wap�, cynk lub bia�ko. Prosimy wzbogaci� swoj� diet� o produkty bogate w wymienione w�glowodany.";
			}
			else {
				message="";
			}
			
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
		
	}
	
	
}
