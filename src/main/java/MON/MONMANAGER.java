/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MON;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class MONMANAGER {
    private List<MON> listMON;

    public MONMANAGER() {
        listMON = new ArrayList<>();
    }

    public MONMANAGER(List<MON> ListMON) {
        this.listMON = ListMON;
    }

    public List<MON> getListMON() {
        return listMON;
    }

    public void setListMON(List<MON> ListMON) {
        this.listMON = ListMON;
    }
    
    public void insertMON(MON mon) {
        this.listMON.add(mon);
    }
    
    public boolean deleteMON(String maMON) {
        MON mon = this.listMON.stream().filter(k -> k.getMaMon().equals(maMON)).findFirst().orElse(null);
        return this.listMON.remove(mon);
    }
    
    public MON searchByMaMON(String maMON) {
        return this.listMON.stream().filter(k -> k.getMaMon().equals(maMON)).findFirst().orElse(null);
    }
    
}
