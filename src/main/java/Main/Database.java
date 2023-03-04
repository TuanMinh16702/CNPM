/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import HOADON.CT_HOADON;
import HOADON.HOADON;
import KHUYENMAI.CT_KM;
import KHUYENMAI.KHUYENMAI;
import MON.MON;
import NHANVIEN.NHANVIEN;
import TAIKHOAN.TAIKHOAN;
import THONGBAO.THONGBAO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
public class Database {
    private Connection connection;
    private Statement statement;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public Database() {
    }
    
    public Connection connectToDB() throws SQLException{
        Connection con = null;
        String url = "jdbc:sqlserver://localhost:1433;instance=LAPTOP-E0FD0UKT\\MSSQLSERVER06;databaeName=QLCF;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "qwerty";
        con = DriverManager.getConnection(url, user, password);
        if(con != null){
            System.out.println("Kết nối Thành công");
        }else{
            System.out.println("Kết nối thất bại");
        }
        return con;
    }
    
    public TAIKHOAN userAuthenciation(Statement statement, String userName, String userPassword) throws SQLException{
        TAIKHOAN currentUser = null;
        String query = "USE QLCF\n"+
                "SELECT * FROM TAIKHOAN";
        ResultSet result = statement.executeQuery(query);
        while(result.next()) {
            if (userName.equals(result.getString(1)) && userPassword.equals(result.getString(2))) {
                currentUser = new TAIKHOAN(result.getString(1), result.getString(2), result.getString(3));
            }
        }
        return currentUser;
    }
    
    public NHANVIEN checkInFo(Statement statement, String tk) throws SQLException{
        NHANVIEN nv = null;
        String query ="USE QLCF\n" +
                "SELECT * FROM NHANVIEN";
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            if(tk.equals(rs.getString(9))){
                nv = new NHANVIEN(rs.getString(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9));
            }
        }
        return nv;
    }
    
    
    public void postNhanVientoDB(Statement statement, NHANVIEN nv) throws SQLException{
        String query = "USE QLCF \n" +
                "INSERT INTO NHANVIEN (MANV,HO,TEN,DIACHI,EMAIL,NGAYSINH,GIOITINH,MACH,TK) VALUES(" +
                "N'"  + nv.getManv() + "', " +
                "N'" + nv.getHo() + "', " +
                "N'" + nv.getTen()+ "', " +
                "N'" + nv.getDiachi() + "', " +
                "N'" + nv.getEmail() + "', " +
                "N'" + sdf.format(nv.getNgaysinh()) + "', " +
                "N'" + nv.getGioitinh() + "', " +
                "N'" + nv.getMaCH() + "', " +   
                "N'" + nv.getTk() + "'); "; 
        statement.executeUpdate(query);
            
    }
    
    public void postHoaDontoDB(Statement statement, HOADON hd, CT_HOADON cthd) throws SQLException{
        String query ="USE QLCF \n" +
                "INSERT INTO HOADON (SOHD,NGAYLAP,TONGTIEN,MANV) VALUES(" +
                "N'"  + hd.getMaHD() + "', " +
                "N'"  + sdf.format(hd.getNgay()) + "', " +
                "N'"  + hd.getTongtien() + "', " +
                "N'"  + hd.getManv() + "'); " ;
        statement.executeUpdate(query);
    }
    
    public void postMontoDB(Statement statement, MON mon) throws SQLException{
        String query="USE QLCF \n" +
            "INSERT INTO MON(MAMON,TENMON,GIA,MANV) VALUES(" +
            "N'"  + mon.getMaMon() + "', " +
            "N'"  + mon.getTenMon() + "', " +
            "N'"  + mon.getGia() + "', " +
            "NULLIF('"  + mon.getManv() + "', 'null' );" ;
        statement.executeUpdate(query);
    }
    
    public void postKhuyenMaitoDB(Statement statement, KHUYENMAI km) throws SQLException{
        String query ="USE QLCF\n" +
                "INSERT INTO KHUYENMAI(MAKM,TENKM,LYDO) VALUES(" +
                "N'"  + km.getMaKM() + "', " +
                "N'"  + km.getTenKM() + "', " +
                "N'"  + km.getLydo() + "'); ";
        statement.executeUpdate(query);
    }
    
    public void postTaiKhoanttoDB(Statement statement, TAIKHOAN tk) throws SQLException{
        String query = "USE QLCF\n" +
                "INSERT INTO TAIKHOAN(TK,MK,MACHUCVU) VALUES("+
                "N'" + tk.getTk() +"' " +
                "N'" + tk.getMk() +"' " +
                "N'" + tk.getQuyen() + "');";
        statement.executeQuery(query);
    }
    
    public void postCTHDtoDB(Statement statement, CT_HOADON cthd) throws SQLException{
        statement.executeUpdate("USE QLCF\n"+
                "INSERT INTO CTHĐ (SOHD,MAMON,TONGSOLUONG) VALUES(" +
                "N'" + cthd.getSoHD() + "', " +
                "N'" + cthd.getMaMon() +"', " +
                "N'" + cthd.getTongsoluong() + "');");
    }
    
    public void postCTKMtoDB(Statement statement, CT_KM ctkm) throws SQLException{
        statement.executeUpdate("USE QLCF\n"+
                "INSERT INTO CT_KM (MAMON,MAKM,MAGD,NGAYBD,NGAYKT,PHANTRAM) VALUES(" +
                "N'" + ctkm.getMaMon() + "', " +
                "N'" + ctkm.getMaKM() +"', " +
                "N'" + ctkm.getMaGD() +"', " +
                "N'" + sdf.format(ctkm.getNgayBD()) +"', " +
                "N'" + sdf.format(ctkm.getNgayKT()) +"', " +
                "N'" + ctkm.getPhantram() + "');");
    }
    
    public void postThongBaotoDB(Statement statement, THONGBAO tb, String ngaytb) throws SQLException{
        statement.executeUpdate("USE QLCF\n" +
                "INSERT INTO THONGBAO (MATB,NOIDUNGTB) VALUES(" +
                "N'" + tb.getMaTB() + "', " +
                "N'" + tb.getNoidung() + "');");
        
        statement.executeUpdate("USE QLCF\n" +
                "INSERT INTO CT_THONGBAO (MATB,MAGĐ,NGAYTB) VALUES(" +
                "N'" + tb.getMaTB() + "', " +
                "'"+ "GD" + "', " +      
                ngaytb + ");");
    }
    
    public void updateNhanVientoDB(Statement statement, String manv, String ho, String ten) throws SQLException{
        statement.executeUpdate("UPDATE NHANVIEN " +
                "SET " + 
                "HO = '" + ho + "', " +
                "TEN ='" + ten + "', "+     
                " WHERE MANV = '" + manv+ "'" );
    }
    
    public void updateMatKhautoDB(Statement statement, String tk, String newMK ) throws SQLException{
        statement.executeUpdate("UPDATE TAIKHOAN SET MK='" + newMK + "' WHERE TK='" + tk+ "'");
    }
    public void deleteNhanVien(Statement statement, String manv) throws SQLException{
        statement.execute("DELETE FROM NHANVIEN WHERE MANV ='" + manv + "'");
    }
    
    public void deleteHoaDon(Statement statement, String soHD) throws SQLException{
        statement.execute("DELETE FROM HOADON WHERE SOHD ='" + soHD + "'");
    }
    
    public void deleteCTHD(Statement statement, String soHD, String maMon) throws SQLException{
        statement.execute("DELETE FROM CT_HOADON WHERE SOHD ='" + soHD + "' AND MAMON ='" + maMon + "'");
    }
    
    public void deleteMon(Statement statement, String maMon) throws SQLException{
        statement.execute("DELETE FROM MON WHERE MAMON ='" + maMon + "'");
    }
    
    public void deleteThongBao(Statement statement, String matb) throws SQLException{        
        statement.execute("DELETE FROM CT_THONGBAO WHERE MATB='" + matb +"'");
        statement.execute("DELETE FROM THONGBAO WHERE MATB='" + matb +"'");

    }
    
    public void deleteNguyenLieu(Statement statement, String manl) throws SQLException{
        statement.execute("DELETE FROM CT_MON WHERE MANGUYENLIEU='" +manl+"'");
        statement.execute("DELETE FROM NGUYENLIEU WHERE MANGUYENLIEU='" +manl+"'");
    }
}

