/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAIKHOAN;

/**
 *
 * @author TRANG TUAN MINH
 */
public class TAIKHOAN {
        private String tk;
	private String mk;
	private String quyen;

        public TAIKHOAN(String tk, String mk, String quyen) {
            this.tk = tk;
            this.mk = mk;
            this.quyen = quyen;
        }
	
	public TAIKHOAN() {
	}
	
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
}
