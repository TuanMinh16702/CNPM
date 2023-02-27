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
public class CT_KM {
    private String maMon;
    private String maKM;
    private String maGD;
    private Date ngayBD;
    private Date ngayKT;
    private float phantram;

    public CT_KM() {
    }

    public CT_KM(String maMon, String maKM, String maGD, Date ngayBD, Date ngayKT, float phantram) {
        this.maMon = maMon;
        this.maKM = maKM;
        this.maGD = maGD;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.phantram = phantram;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getMaKM() {
        return maKM;
    }

    public String getMaGD() {
        return maGD;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public float getPhantram() {
        return phantram;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setPhantram(float phantram) {
        this.phantram = phantram;
    }
    
}
