/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MON;

import KHUYENMAI.CT_KM;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_MONMANAGER {
     List<CT_MON> listCTMON;
    
    public CT_MONMANAGER() {
        listCTMON = new ArrayList<>();
    }

    public CT_MONMANAGER(List<CT_MON> listCTMON) {
        this.listCTMON = listCTMON;
    }

    public List<CT_MON> getListCTMON() {
        return listCTMON;
    }

    public void setListCTMON(List<CT_MON> listCTMON) {
        this.listCTMON = listCTMON;
    }
    
    public void insertCTMON(CT_MON ctmon) {
        listCTMON.add(ctmon);
    }
    
    public boolean deleteCTMON(String maMon, String maNL ) {
        List<CT_MON> ctm = this.listCTMON.stream().filter(s -> s.getMaMon().equals(maMon)).collect(Collectors.toList());
        CT_MON ctmon = ctm.stream().filter(s -> s.getMaNL().equals(maNL)).findFirst().orElse(null);
        return this.listCTMON.remove(ctmon);
        
    }
    
    public CT_MON searchByCTMON(String maNL, String maMon) {
        List<CT_MON> ctm = this.listCTMON.stream().filter(s -> s.getMaMon().equals(maMon)).collect(Collectors.toList());
        
        return ctm.stream().filter(s -> s.getMaNL().equals(maNL)).findFirst().orElse(null);
    }
}
