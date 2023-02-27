/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LUONG;

/**
 *
 * @author TRANG TUAN MINH
 */
public class LUONG {
    private String bacluong;
	private int luongcb;
	private int phucap;
	
	public LUONG(String bacluong, int luongcb, int phucap) {
		this.bacluong = bacluong;
		this.luongcb = luongcb;
		this.phucap = phucap;
	}
	
	public LUONG() {
	}

	public String getBacluong() {
		return bacluong;
	}
	public void setBacluong(String bacluong) {
		this.bacluong = bacluong;
	}
	public int getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(int luongcb) {
		this.luongcb = luongcb;
	}
	public int getPhucap() {
		return phucap;
	}
	public void setPhucap(int phucap) {
		this.phucap = phucap;
	}
}
