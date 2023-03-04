/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package THONGBAO;

import NGUYENLIEU.NGUYENLIEU;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_THONGBAOMANAGER {
    private List<THONGBAO> listTB;

    public CT_THONGBAOMANAGER() {
        listTB = new ArrayList<>();
    }

    public CT_THONGBAOMANAGER(List<THONGBAO> ListTB) {
        this.listTB = ListTB;
    }

    public List<THONGBAO> getListNL() {
        return listTB;
    }

    public void setListTB(List<THONGBAO> ListTB) {
        this.listTB = ListTB;
    }
    
    public void insertTB(THONGBAO tb) {
        this.listTB.add(tb);
    }
    
//    public boolean deleteTB(String maNL) {
//        NGUYENLIEU nl = this.listNL.stream().filter(k -> k.getMaNL().equals(maNL)).findFirst().orElse(null);
//        return this.listNL.remove(nl);
//    }
    
//    public NGUYENLIEU searchByMaNL(String maNL) {
//        return this.listNL.stream().filter(k -> k.getMaNL().equals(maNL)).findFirst().orElse(null);
//    }
    
}
