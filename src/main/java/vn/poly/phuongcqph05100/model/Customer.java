package vn.poly.phuongcqph05100.model;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2529428441379448190L;

	private String makh;
	private String matkhau;
	private String hovaten;
	private String sodienthoai;
	private String email;

	public Customer() {
		super();
	}

	public Customer(String makh, String matkhau, String hovaten, String sodienthoai, String email) {
		super();
		this.makh = makh;
		this.matkhau = matkhau;
		this.hovaten = hovaten;
		this.sodienthoai = sodienthoai;
		this.email = email;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
