package com.example.bai10;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		TabSpec tabSpec = tabHost.newTabSpec("Tab1");
		tabSpec.setIndicator("Thêm Sản Phẩm");
		Intent intent = new Intent(getBaseContext(), Tab1.class);
		tabSpec.setContent(intent);

		TabSpec tabSpec1 = tabHost.newTabSpec("Tab2");
		tabSpec1.setIndicator("Danh Sách Sản Phẩm");
		Intent intent1 = new Intent(getBaseContext(), Tab2.class);
		tabSpec1.setContent(intent1);

		tabHost.addTab(tabSpec);
		tabHost.addTab(tabSpec1);
		
		taoData();
		taoBang();
	}

	public void taoData() {
		database = openOrCreateDatabase("QLSP", MODE_APPEND, null);
	}

	public void taoBang() {
		String sqlSanpham = "create table if not exists sanpham(id integer primary key autoincrement, ten text, loaisp text)";
		database.execSQL(sqlSanpham);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
