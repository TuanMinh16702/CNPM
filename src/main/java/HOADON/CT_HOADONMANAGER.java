/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HOADON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_HOADONMANAGER {
    List<CT_HOADON> listCTHD;
    
    public CT_HOADONMANAGER() {
        listCTHD = new ArrayList<>();
    }

    public CT_HOADONMANAGER(List<CT_HOADON> listCTHD) {
        this.listCTHD = listCTHD;
    }

    public List<CT_HOADON> getListCTHD() {
        return listCTHD;
    }

    public void setListCTHD(List<CT_HOADON> listCTHD) {
        this.listCTHD = listCTHD;
    }
    
    public void insertCTHD(CT_HOADON cthd) {
        listCTHD.add(cthd);
    }
    
    public boolean deleteCTHD(String maHD, String maMon) {
        List<CT_HOADON> cthd = this.listCTHD.stream().filter(s -> s.getSoHD().equals(maHD)).collect(Collectors.toList());
        CT_HOADON ct_hd = cthd.stream().filter(s -> s.getMaMon().equals(maMon)).findFirst().orElse(null);
        return this.listCTHD.remove(ct_hd);
    }
    
    public CT_HOADON searchByCTHD(String maHD, String maMon) {
        List<CT_HOADON> cthd = this.listCTHD.stream().filter(s -> s.getSoHD().equals(maHD)).collect(Collectors.toList());
        return cthd.stream().filter(s -> s.getMaMon().equals(maMon)).findFirst().orElse(null);
    }
}
