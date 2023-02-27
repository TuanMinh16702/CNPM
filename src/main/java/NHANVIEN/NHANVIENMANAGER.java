/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHANVIEN;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRANG TUAN MINH
 */
public class NHANVIENMANAGER {
    private List<NHANVIEN> listNV;
	
	public NHANVIENMANAGER() {
		listNV = new ArrayList<>();
	}

	public NHANVIENMANAGER(List<NHANVIEN> ListNV) {
		this.listNV = ListNV;
	}
	
	public List<NHANVIEN> getListNV(){
		return listNV;
	}
	
	public void setListNV(List<NHANVIEN> ListNV){
		this.listNV = ListNV;
	}
	
	public void insertNV(NHANVIEN nv) {
		listNV.add(nv);
	}
	
	public boolean deleteNV(String manv) {
		NHANVIEN nv = this.listNV.stream().filter(n ->n.getManv().equals(manv)).findFirst().orElse(null);
		return this.listNV.remove(nv);
	}
	public NHANVIEN searchByMaNV(String maNV) {
		return (NHANVIEN) this.listNV.stream().filter(nv -> nv.getManv().equals(maNV)).findFirst().orElse(null);
	}
}
