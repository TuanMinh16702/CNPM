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
    private String donvi;

    public NGUYENLIEU() {
    }

    public NGUYENLIEU(String maNL, String tenNL, String donvi) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.donvi = donvi;
    }

    public String getMaNL() {
        return maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    
    
    
}
