package com.example.bai10;

public class Data {
	Integer idsp;
	String tensp;
	String loaisp;

	public Data(Integer idsp, String tensp, String loaisp) {
		super();
		this.idsp = idsp;
		this.tensp = tensp;
		this.loaisp = loaisp;
	}

	public Integer getIdsp() {
		return idsp;
	}

	public void setIdsp(Integer idsp) {
		this.idsp = idsp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public String getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(String loaisp) {
		this.loaisp = loaisp;
	}

}
