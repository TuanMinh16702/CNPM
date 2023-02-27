/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAIKHOAN;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class TAIKHOANMANAGER {
    List<TAIKHOAN> listTK;
    
    public TAIKHOANMANAGER() {
        listTK = new ArrayList<>();
    }

    public TAIKHOANMANAGER(List<TAIKHOAN> ListTK) {
        this.listTK = ListTK;
    }

    public List<TAIKHOAN> getListTK() {
        return listTK;
    }

    public void setListTK(List<TAIKHOAN> listTK) {
        this.listTK = listTK;
    }
    
    public void insertTK(TAIKHOAN tk) {
        listTK.add(tk);
    }
    
    public boolean deleteTK(String maTK) {
        TAIKHOAN tk = this.listTK.stream().filter(h -> h.getTk().equals(maTK)).findFirst().orElse(null);
        return this.listTK.remove(tk);
    }
    
    public TAIKHOAN searchByMaTK(String maTK) {
        return this.listTK.stream().filter(p -> p.getTk().equals(maTK)).findFirst().orElse(null);
    }
}
