/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HOADON;

import java.util.Date;

/**
 *
 * @author TRANG TUAN MINH
 */
public class HOADON {
        private String maHD;
	private Date ngay;
	private float tongtien;
        private String manv;

    public HOADON(String maHD, Date ngay, int tongtien, String manv) {
        this.maHD = maHD;
        this.ngay = ngay;
        this.tongtien = tongtien;
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
	
	public HOADON() {
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

        public float getTongtien() {
            return tongtien;
        }
	
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
}
