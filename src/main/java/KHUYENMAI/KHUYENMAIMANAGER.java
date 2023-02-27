/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KHUYENMAI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class KHUYENMAIMANAGER {
    private List<KHUYENMAI> listKM;

    public KHUYENMAIMANAGER() {
        listKM = new ArrayList<>();
    }

    public KHUYENMAIMANAGER(List<KHUYENMAI> ListKM) {
        this.listKM = ListKM;
    }

    public List<KHUYENMAI> getListKM() {
        return listKM;
    }

    public void setListKM(List<KHUYENMAI> ListKM) {
        this.listKM = ListKM;
    }
    
    public void insertKM(KHUYENMAI km) {
        this.listKM.add(km);
    }
    
    public boolean deleteKM(String maKM) {
        KHUYENMAI km = this.listKM.stream().filter(k -> k.getMaKM().equals(maKM)).findFirst().orElse(null);
        return this.listKM.remove(km);
    }
    
    public KHUYENMAI searchByMaKM(String maKM) {
        return this.listKM.stream().filter(k -> k.getMaKM().equals(maKM)).findFirst().orElse(null);
    }
    
}
