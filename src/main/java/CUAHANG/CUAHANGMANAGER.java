/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CUAHANG;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CUAHANGMANAGER {
    List<CUAHANG> listCH;
    
    public CUAHANGMANAGER() {
        listCH = new ArrayList<>();
    }

    public CUAHANGMANAGER(List<CUAHANG> listHD) {
        this.listCH = listHD;
    }

    public List<CUAHANG> getListCH() {
        return listCH;
    }

    public void setListCH(List<CUAHANG> ListCH) {
        this.listCH = ListCH;
    }
    
    public void insertCH(CUAHANG ch) {
        listCH.add(ch);
    }
    
    public boolean deleteCH(String maCH) {
        CUAHANG ch = this.listCH.stream().filter(h -> h.getMaCH().equals(maCH)).findFirst().orElse(null);
        return this.listCH.remove(ch);
    }
    
    public CUAHANG searchByMaCH(String maCH) {
        return this.listCH.stream().filter(p -> p.getMaCH().equals(maCH)).findFirst().orElse(null);
    }
}
