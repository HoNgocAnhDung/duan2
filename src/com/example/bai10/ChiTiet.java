package com.example.bai10;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ChiTiet extends Activity {
	TextView tvId, tvTen, tvLoaisp;
	String laydulieuid, laydulieuten, laydulieuloaisp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chi_tiet);
		tvId = (TextView) findViewById(R.id.tvId);
		tvTen = (TextView) findViewById(R.id.tvTen);
		tvLoaisp = (TextView) findViewById(R.id.tvLoaisp);

		layintent();
	}

	public void layintent() {
		Intent layintent = getIntent();
		laydulieuid = layintent.getStringExtra("idsp");
		laydulieuten = layintent.getStringExtra("tensp");
		laydulieuloaisp = layintent.getStringExtra("loaisp");

		hienthi(laydulieuid, laydulieuten, laydulieuloaisp);

	}

	public void hienthi(String id, String ten, String loaisp) {
		tvId.setText(id);
		tvTen.setText(ten);
		tvLoaisp.setText(loaisp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chi_tiet, menu);
		return true;
	}

}
