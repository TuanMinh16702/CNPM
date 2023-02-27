/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NGUYENLIEU;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class NGUYENLIEUMANAGER {
    private List<NGUYENLIEU> listNL;

    public NGUYENLIEUMANAGER() {
        listNL = new ArrayList<>();
    }

    public NGUYENLIEUMANAGER(List<NGUYENLIEU> ListNL) {
        this.listNL = ListNL;
    }

    public List<NGUYENLIEU> getListNL() {
        return listNL;
    }

    public void setListNL(List<NGUYENLIEU> ListNL) {
        this.listNL = ListNL;
    }
    
    public void insertNL(NGUYENLIEU nl) {
        this.listNL.add(nl);
    }
    
    public boolean deleteNL(String maNL) {
        NGUYENLIEU nl = this.listNL.stream().filter(k -> k.getMaNL().equals(maNL)).findFirst().orElse(null);
        return this.listNL.remove(nl);
    }
    
    public NGUYENLIEU searchByMaNL(String maNL) {
        return this.listNL.stream().filter(k -> k.getMaNL().equals(maNL)).findFirst().orElse(null);
    }
    
}
