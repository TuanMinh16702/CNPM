/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HOADON;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class HOADONMANAGER {
    List<HOADON> listHD;
    
    public HOADONMANAGER() {
        listHD = new ArrayList<>();
    }

    public HOADONMANAGER(List<HOADON> listHD) {
        this.listHD = listHD;
    }

    public List<HOADON> getListHD() {
        return listHD;
    }

    public void setListHD(List<HOADON> listHD) {
        this.listHD = listHD;
    }
    
    public void insertHD(HOADON hd) {
        listHD.add(hd);
    }
    
    public boolean deleteHD(String maHD) {
        HOADON hd = this.listHD.stream().filter(h -> h.getMaHD().equals(maHD)).findFirst().orElse(null);
        return this.listHD.remove(hd);
    }
    
    public HOADON searchByMaHD(String maHD) {
        return this.listHD.stream().filter(p -> p.getMaHD().equals(maHD)).findFirst().orElse(null);
    }
}
