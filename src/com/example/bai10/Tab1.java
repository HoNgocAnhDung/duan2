package com.example.bai10;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Tab1 extends Activity {
	SQLiteDatabase database;

	EditText edtTen;
	Spinner spin;
	Button btnThem;

	ArrayList<String> arrSpin;
	ArrayAdapter<String> adapter;
	String luachon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab1);

		edtTen = (EditText) findViewById(R.id.edtTen);
		spin = (Spinner) findViewById(R.id.spin);
		btnThem = (Button) findViewById(R.id.btnThem);

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
		btnThem.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put("ten", edtTen.getText().toString());
				values.put("loaisp", luachon);

				if (edtTen.getText().toString().equals("")) {
					Toast.makeText(getBaseContext(),
							"Mời Bạn Nhập Tên Sản Phẩm", Toast.LENGTH_LONG)
							.show();
				} else {
					database.insert("sanpham", null, values);
					Toast.makeText(getBaseContext(),
							"Thêm Thành Công", Toast.LENGTH_LONG)
							.show();
				}

			}
		});
	}

	public void taoData() {
		database = openOrCreateDatabase("QLSP", MODE_APPEND, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab1, menu);
		return true;
	}

}
