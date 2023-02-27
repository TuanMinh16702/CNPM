/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KHUYENMAI;

import java.util.Date;

/**
 *
 * @author TRANG TUAN MINH
 */
public class KHUYENMAI {
    private String maKM;
	private String tenKM;
	private String lydo;
	public KHUYENMAI(String maKM, String tenKM, String lydo) {

		this.maKM = maKM;
		this.tenKM= tenKM;
		this.lydo = lydo;
	}
        
	public KHUYENMAI() {
	}
        
	public String getMaKM() {
		return maKM;
	}
        
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

        public String getTenKM() {
            return tenKM;
        }

        public void setTenKM(String tenKM) {
            this.tenKM = tenKM;
        }

	public String getLydo() {
		return lydo;
	}
        
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	
}
