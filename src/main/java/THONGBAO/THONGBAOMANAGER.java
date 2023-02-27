/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THONGBAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class THONGBAOMANAGER {
    List<THONGBAO> listTB;
    
    public THONGBAOMANAGER() {
        listTB = new ArrayList<>();
    }

    public THONGBAOMANAGER(List<THONGBAO> ListTB) {
        this.listTB = ListTB;
    }

    public List<THONGBAO> getListTB() {
        return listTB;
    }

    public void setListTB(List<THONGBAO> listTB) {
        this.listTB = listTB;
    }
    
    public void insertTB(THONGBAO tb) {
        listTB.add(tb);
    }
    
    public boolean deleteTB(String maTB) {
        THONGBAO ct = this.listTB.stream().filter(h -> h.getMaTB().equals(maTB)).findFirst().orElse(null);
        return this.listTB.remove(ct);
    }
    
    public THONGBAO searchByMaTB(String maTB) {
        return this.listTB.stream().filter(p -> p.getMaTB().equals(maTB)).findFirst().orElse(null);
    }
}
