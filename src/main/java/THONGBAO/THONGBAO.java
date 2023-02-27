/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THONGBAO;

/**
 *
 * @author TRANG TUAN MINH
 */
public class THONGBAO {
    private String maTB;
	private String noidung;
	public THONGBAO(String maTB, String noidung) {
		this.maTB = maTB;
		this.noidung = noidung;
	}
	public THONGBAO() {
	}
	public String getMaTB() {
		return maTB;
	}
	public void setMaTB(String maTB) {
		this.maTB = maTB;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
}
