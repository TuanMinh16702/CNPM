/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HOADON;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_HOADON {    
    private String soHD;
    private String maMon;
    private int tongsoluong;

    public CT_HOADON(String soHD, String maMon, int tongsoluong) {
        this.soHD = soHD;
        this.maMon = maMon;
        this.tongsoluong = tongsoluong;
    }

    public CT_HOADON() {
    }

    public String getSoHD() {
        return soHD;
    }

    public String getMaMon() {
        return maMon;
    }

    public int getTongsoluong() {
        return tongsoluong;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setTongsoluong(int tongsoluong) {
        this.tongsoluong = tongsoluong;
    }
    
    
    
}
