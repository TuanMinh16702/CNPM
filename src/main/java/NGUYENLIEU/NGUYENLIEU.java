/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGUYENLIEU;

/**
 *
 * @author TRANG TUAN MINH
 */
public class NGUYENLIEU {
    private String maNL;
    private String tenNL;
    private String ghichu;
    private String manv;
    public NGUYENLIEU() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    

    public String getMaNL() {
        return maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public NGUYENLIEU(String maNL, String tenNL, String ghichu, String manv) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.ghichu = ghichu;
        this.manv = manv;
    }
    
}
