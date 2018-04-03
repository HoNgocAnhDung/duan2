package com.example.bai10;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class Tab2 extends Activity {
	SQLiteDatabase database;

	ListView lvList;
	ArrayList<Data> arrData;
	CustomAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2);
		lvList = (ListView) findViewById(R.id.lvList);

		arrData = new ArrayList<Data>();
		adapter = new CustomAdapter(arrData);
		lvList.setAdapter(adapter);
		taoData();
		docData();

		lvList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), SuaXoa.class);
				intent.putExtra("idsp", arrData.get(arg2).getIdsp().toString());
				intent.putExtra("tensp", arrData.get(arg2).getTensp()
						.toString());
				intent.putExtra("loaisp", arrData.get(arg2).getLoaisp()
						.toString());
				startActivity(intent);
				return false;
			}
		});
		
		lvList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), ChiTiet.class);
				intent.putExtra("idsp", arrData.get(arg2).getIdsp().toString());
				intent.putExtra("tensp", arrData.get(arg2).getTensp()
						.toString());
				intent.putExtra("loaisp", arrData.get(arg2).getLoaisp()
						.toString());
				startActivity(intent);
			}
		});
	}

	public void taoData() {
		database = openOrCreateDatabase("QLSP", MODE_APPEND, null);
	}

	public void docData() {
		arrData.clear();

		Cursor c = database
				.query("sanpham", null, null, null, null, null, null);
		c.moveToFirst();

		while (c.isAfterLast() == false) {
			arrData.add(new Data(c.getInt(0), c.getString(1), c.getString(2)));
			c.moveToNext();
		}
		c.close();
		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab2, menu);
		return true;
	}

}
