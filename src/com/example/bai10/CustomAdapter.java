package com.example.bai10;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	ArrayList<Data> arrDT;

	public CustomAdapter(ArrayList<Data> arrDT) {
		// TODO Auto-generated constructor stub
		this.arrDT = arrDT;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrDT.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrDT.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.customlv, parent, false);

		TextView tvTen = (TextView) view.findViewById(R.id.tvTen);
		TextView tvLoaisp = (TextView) view.findViewById(R.id.tvLoaisp);

		Data d = arrDT.get(position);
		tvTen.setText(d.tensp);
		tvLoaisp.setText(d.loaisp);
		return view;
	}

}
