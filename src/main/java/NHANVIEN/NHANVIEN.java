/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHANVIEN;

import java.util.Date;

/**
 *
 * @author TRANG TUAN MINH
 */
public class NHANVIEN {
        private String manv;
	private String ho;
	private String ten;
	private int gioitinh;
	private String diachi;
	private Date ngaysinh;
	private String email;
	private String maCH;
        private String tk;

        public NHANVIEN(String manv, String ho, String ten, String diachi, String email, Date ngaysinh, int gioitinh, String maCH, String tk) {
            this.manv = manv;
            this.ho = ho;
            this.ten = ten;
            this.gioitinh = gioitinh;
            this.diachi = diachi;
            this.ngaysinh = ngaysinh;
            this.email = email;
            this.maCH = maCH;
            this.tk = tk;
        }
        public NHANVIEN() {

        }

        public void setTk(String tk) {
            this.tk = tk;
        }

        public String getTk() {
            return tk;
        }

        

        public String getMaCH() {
            return maCH;
        }

        public void setMaCH(String maCH) {
            this.maCH = maCH;
        }

	

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

	
	
}
