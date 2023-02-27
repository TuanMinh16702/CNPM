/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHUCVU;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CHUCVU {
    private String maCV;
    private String tenCV;

    public CHUCVU() {
    }

    public CHUCVU(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
    
}
