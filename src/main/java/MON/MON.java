/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MON;

/**
 *
 * @author TRANG TUAN MINH
 */
public class MON {
    private String maMon;
    private String tenMon;
    private float gia;
    private String manv;
    public MON() {
    }

    public MON(String maMon, String tenMon, float gia, String manv) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.gia = gia;
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public float getGia() {
        return gia;
    }
    
}
