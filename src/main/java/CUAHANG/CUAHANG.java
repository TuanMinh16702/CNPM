/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CUAHANG;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CUAHANG {
        private String maCH;
	private String tenCH;
	public CUAHANG(String maCH, String tenCH) {
		this.maCH = maCH;
		this.tenCH = tenCH;
	}
	public CUAHANG() {
	}
	public String getMaCH() {
		return maCH;
	}
	public void setMaCH(String maCH) {
		this.maCH = maCH;
	}
	public String getTenCH() {
		return tenCH;
	}
	public void setTenCH(String tenCH) {
		this.tenCH = tenCH;
	}
}
