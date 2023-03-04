/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHAMCONG;

import KHUYENMAI.KHUYENMAI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CHAMCONGMANAGER {
    private List<CHAMCONG> listCC;

    public CHAMCONGMANAGER() {
        listCC = new ArrayList<>();
    }

    public CHAMCONGMANAGER(List<CHAMCONG> ListCC) {
        this.listCC = ListCC;
    }

    public List<CHAMCONG> getListCC() {
        return listCC;
    }

    public void setListCC(List<CHAMCONG> ListCC) {
        this.listCC = ListCC;
    }
    
    public void insertCC(CHAMCONG cc) {
        this.listCC.add(cc);
    }
    
    public boolean deleteCC(String maBCC) {
        CHAMCONG cc = this.listCC.stream().filter(k -> k.getMabcc().equals(maBCC)).findFirst().orElse(null);
        return this.listCC.remove(cc);
    }
    
//    public KHUYENMAI searchByMaKM(String maKM) {
//        return this.listKM.stream().filter(k -> k.getMaKM().equals(maKM)).findFirst().orElse(null);
//    }
}
