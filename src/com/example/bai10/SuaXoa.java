package com.example.bai10;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class SuaXoa extends Activity {
	SQLiteDatabase database;

	EditText edtTenn;
	Spinner spin;
	Button btnSua, btnXoa;

	ArrayList<String> arrSpin;
	ArrayAdapter<String> adapter;
	String luachon;
	String laydulieuid, laydulieuten, laydulieuloaisp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sua_xoa);

		edtTenn = (EditText) findViewById(R.id.edtTenn);
		spin = (Spinner) findViewById(R.id.spin);
		btnSua = (Button) findViewById(R.id.btnSua);

		arrSpin = new ArrayList<String>();
		arrSpin.add("SAM SUNG");
		arrSpin.add("SAM SUNG1");
		arrSpin.add("SAM SUNG2");

		adapter = new ArrayAdapter<String>(getBaseContext(),
				android.R.layout.simple_spinner_item, arrSpin);
		spin.setAdapter(adapter);

		taoData();
		spin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				luachon = arrSpin.get(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		taoData();
		layintent();

		btnSua.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sua(laydulieuid, edtTenn.getText().toString(), luachon);
			}
		});
	}

	public void taoData() {
		database = openOrCreateDatabase("QLSP", MODE_APPEND, null);
	}

	public void layintent() {
		Intent layintent = getIntent();
		laydulieuid = layintent.getStringExtra("idsp");
		laydulieuten = layintent.getStringExtra("tensp");
		laydulieuloaisp = layintent.getStringExtra("loaisp");
		hienthi(laydulieuten);
	}

	public void hienthi(String ten) {
		edtTenn.setText(ten);
	}

	public void sua(String id2, String ten2, String loaisp2) {
		ContentValues values = new ContentValues();
		values.put("id", id2);
		values.put("ten", ten2);
		values.put("loaisp", loaisp2);

		if (database.update("sanpham", values, "id=?", new String[] { id2 }) != -1) {
			Toast.makeText(getBaseContext(), "Sửa thành công",
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(getBaseContext(), MainActivity.class);
			startActivity(intent);
		} else {
			Toast.makeText(getBaseContext(), "Sửa không thành công",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void xoa(String id2) {
		ContentValues values = new ContentValues();
		values.put("id", id2);

		database.delete("sanpham", "id=?", new String[] { id2 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sua_xoa, menu);
		return true;
	}

}
