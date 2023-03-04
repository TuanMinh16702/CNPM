/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHAMCONG;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CHAMCONG {
    private String mabcc;
    private String ngaychamcong;
    private String ghichu;
    private String manv;
    private int sogiolamviec;

    public CHAMCONG(String mabcc, String ngaychamcong, String ghichu, String manv, int sogiolamviec) {
        this.mabcc = mabcc;
        this.ngaychamcong = ngaychamcong;
        this.ghichu = ghichu;
        this.manv = manv;
        this.sogiolamviec = sogiolamviec;
    }

    public CHAMCONG() {
    }

    public String getMabcc() {
        return mabcc;
    }

    public String getNgaychamcong() {
        return ngaychamcong;
    }

    public String getGhichu() {
        return ghichu;
    }

    public String getManv() {
        return manv;
    }

    public int getSogiolamviec() {
        return sogiolamviec;
    }

    public void setMabcc(String mabcc) {
        this.mabcc = mabcc;
    }

    public void setNgaychamcong(String ngaychamcong) {
        this.ngaychamcong = ngaychamcong;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setSogiolamviec(int sogiolamviec) {
        this.sogiolamviec = sogiolamviec;
    }
    
}
