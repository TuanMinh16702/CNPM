/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THONGBAO;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_THONGBAO {
    private String maTB;
    private String maGD;
    private String ngayTB;

    public CT_THONGBAO(String maTB, String maGD, String ngayTB) {
        this.maTB = maTB;
        this.maGD = maGD;
        this.ngayTB = ngayTB;
    }

    public CT_THONGBAO() {
    }

    public String getMaTB() {
        return maTB;
    }

    public String getMaGD() {
        return maGD;
    }

    public String getNgayTB() {
        return ngayTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }

    public void setNgayTB(String ngayTB) {
        this.ngayTB = ngayTB;
    }
    
}
