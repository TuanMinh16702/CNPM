/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MON;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_MON {
    private String maMon;
    private String maNL;
    private String cachlam;

    public CT_MON() {
    }

    public CT_MON(String maMon, String maNL, String cachlam) {
        this.maMon = maMon;
        this.maNL = maNL;
        this.cachlam = cachlam;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getMaNL() {
        return maNL;
    }

    public String getCachlam() {
        return cachlam;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public void setCachlam(String cachlam) {
        this.cachlam = cachlam;
    }
    
    
}
