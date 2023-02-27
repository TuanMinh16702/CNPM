/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KHUYENMAI;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author TRANG TUAN MINH
 */
public class CT_KMMANAGER {
    List<CT_KM> listCTKM;
    
    public CT_KMMANAGER() {
        listCTKM = new ArrayList<>();
    }

    public CT_KMMANAGER(List<CT_KM> listCTKM) {
        this.listCTKM = listCTKM;
    }

    public List<CT_KM> getListCTKM() {
        return listCTKM;
    }

    public void setListCTKM(List<CT_KM> listCTKM) {
        this.listCTKM = listCTKM;
    }
    
    public void insertCTKM(CT_KM ctkm) {
        listCTKM.add(ctkm);
    }
    
    public boolean deleteCTKM(String maMon, String maKM , String maGD) {
        List<CT_KM> ctkm = this.listCTKM.stream().filter(s -> s.getMaKM().equals(maKM)).collect(Collectors.toList());
        List<CT_KM> Ctkm = ctkm.stream().filter(s->s.getMaMon().equals(maMon)).collect(Collectors.toList());
        CT_KM ct_km = Ctkm.stream().filter(s -> s.getMaGD().equals(maGD)).findFirst().orElse(null);
        return this.listCTKM.remove(ct_km);
        
    }
    
    public CT_KM searchByCTHD(String maKM, String maMon, String maGD) {
        List<CT_KM> ctkm = this.listCTKM.stream().filter(s -> s.getMaKM().equals(maKM)).collect(Collectors.toList());
        List<CT_KM> Ctkm = ctkm.stream().filter(s -> s.getMaMon().equals(maMon)).collect(Collectors.toList());
        return Ctkm.stream().filter(s -> s.getMaGD().equals(maGD)).findFirst().orElse(null);
    }
}
