/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import App.GD_ThongTinNhanVien;
import App.GD_ĐoiTKMK;
import App.Login;
import BackFrameQuanLy.GD_QuanLy;
import BackFrameQuanLy.GD_TaoThongBao;
import CHAMCONG.CHAMCONG;
import CHAMCONG.CHAMCONGMANAGER;
import KHUYENMAI.CT_KM;
import KHUYENMAI.CT_KMMANAGER;
import KHUYENMAI.KHUYENMAI;
import KHUYENMAI.KHUYENMAIMANAGER;
import MON.CT_MON;
import MON.CT_MONMANAGER;
import MON.MON;
import MON.MONMANAGER;
import NGUYENLIEU.NGUYENLIEU;
import NGUYENLIEU.NGUYENLIEUMANAGER;
import NHANVIEN.NHANVIEN;
import NHANVIEN.NHANVIENMANAGER;
import TAIKHOAN.TAIKHOAN;
import TAIKHOAN.TAIKHOANMANAGER;
import THONGBAO.THONGBAO;
import THONGBAO.THONGBAOMANAGER;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class VARIABLE {

    private final String NHAN_VIEN = "NV";
    private final String QUAN_LY = "QL";
    private final String GIAM_DOC = "GD";
    
    private Statement statement;
    private Connection connection;
    
    private GD_TaoThongBao gdtb;
    private Database DB;
    private GD_QuanLy GDQL;
    private Login login;
    private GD_ĐoiTKMK tkmk;
    private GD_ThongTinNhanVien ttnv;
    
    private TAIKHOAN tk;
    private NHANVIEN nv;
    private NHANVIENMANAGER nvm;
    private CHAMCONGMANAGER ccm;
    private TAIKHOANMANAGER tkm;
    private NGUYENLIEU nl;
    private NGUYENLIEUMANAGER nlm;
    private THONGBAOMANAGER tbm;
    private CT_KMMANAGER ctkmm;
    private CT_MONMANAGER ctmm;
    private MONMANAGER mm;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public VARIABLE() throws SQLException {
        this.DB = new Database();
        this.tk = new TAIKHOAN();
        this.login = new Login();
        this.nv = new NHANVIEN();
        this.nvm = new NHANVIENMANAGER();
        this.tkm = new TAIKHOANMANAGER();
        this.gdtb = new GD_TaoThongBao();
        this.nl = new NGUYENLIEU();
        this.tkmk = new GD_ĐoiTKMK();
        this.ttnv = new GD_ThongTinNhanVien();
    }
    
    public boolean connectToSQL() throws SQLException{
        this.connection = this.DB.connectToDB();
        if(this.connection != null){
            this.statement = connection.createStatement();
            return true;
        }
        return false;
    }
    
    public String getHOTENNHANVIEN(String manv) throws SQLException{
        ResultSet rs = statement.executeQuery("SELECT * FROM NHANVIEN ");
        String hoten = "";
        while(rs.next()){
            if(manv.equals(rs.getString(1))){
                NHANVIEN NV = new NHANVIEN(rs.getString(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                hoten = rs.getString(2) + " " + rs.getString(3);
            }
                      
        }
        return hoten;
    }
    
    public String getChucVu(String manv) throws SQLException{
        ResultSet rs = statement.executeQuery("USE QLCF\n" +
                                                "SELECT MANV , TK.TK, CV.TENCHUCVU\n" +
                                                "FROM (SELECT TK, MACHUCVU FROM TAIKHOAN) AS TK JOIN NHANVIEN\n" +
                                                "ON NHANVIEN.TK = TK.TK\n" +
                                                "JOIN (SELECT TENCHUCVU, MACHUCVU FROM CHUCVU) AS CV\n" +
                                                "ON CV.MACHUCVU = TK.MACHUCVU\n" +
                                                "WHERE MANV ='" + manv+ "'");
        while(rs.next()){
            if(manv.equals(rs.getString(1))){
                return rs.getNString(3);
            }
                      
        }
        return "1";
    }
    
    public String getMatKhau(String tk) throws SQLException{
        ResultSet rs= statement.executeQuery("USE QLCF\n" +
                                            "SELECT TK , MK FROM TAIKHOAN WHERE TK='" +tk+"'");
        while(rs.next()){
            if(tk.equals(rs.getString(1))){
                return rs.getString(2);
            }  
        }
        return "";
    }
    
    public NHANVIEN getNhanVien(String manv) throws SQLException{
        ResultSet rs = statement.executeQuery("SELECT * FROM NHANVIEN WHERE MANV='" + manv+"'");
        NHANVIEN nv = null;
        while(rs.next()){
            if(manv.equals(rs.getString(1))){
                nv = new NHANVIEN(rs.getString(1),rs.getNString(2),rs.getNString(3),rs.getString(4),rs.getNString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9));
            }
                      
        }
        return nv;
    }
    
    public String getLyDoKhuyenMai(String makm) throws SQLException{
        ResultSet rs= statement.executeQuery("USE QLCF\n" +
                                            "SELECT MAKM, LYDO FROM KHUYENMAI");
        while(rs.next()){
            if(makm.equals(rs.getString(1))){
                return rs.getString(2);
            }  
        }
        return "";
    }
    
    
    public String GetMaMonByKhuyenMai(String makm) throws SQLException{
        ResultSet rs= statement.executeQuery("SELECT MAKM, MAMON FROM CT_KM");
        while(rs.next()){
            if(makm.equals(rs.getString(1))){
                return rs.getString(2);
            }  
        }
        return "";
    }
    
    public String getmaNVByTAIKHOAN(String tk) throws SQLException{
        ResultSet rs= statement.executeQuery("SELECT * FROM NHANVIEN");
        while(rs.next()){
            if(tk.equals(rs.getString(9))){
                return rs.getString(1);
            }  
        }
        return "";
    }
    
    public String getNgayThongBao(String matb) throws SQLException{
        ResultSet rs= statement.executeQuery("SELECT * FROM CT_THONGBAO");
        while(rs.next()){
            if(matb.equals(rs.getString(1))){
                return rs.getString(3);
            }
        }
        return "";
    }
    
    public String getMon(String mamon) throws SQLException{
        ResultSet rs = statement.executeQuery("{CALL gettenmon('" + mamon+"')}");
        while(rs.next()){
            if(mamon.equals(rs.getString(1))){
               return rs.getNString(2);
            }
        }
        return "";
    }
    
    public String getTenNguyenLieu(String mamon) throws SQLException{
        String ten = "";
        ResultSet rs = statement.executeQuery("{CALL gettenmon('" + mamon+"')}");
        while(rs.next()){
            if(mamon.equals(rs.getString(1))){
               return rs.getNString(2);
            }
        }
        return "";
    }
    
    public List<NGUYENLIEU> loadingNguyenLieu() throws SQLException{
        this.nlm = new NGUYENLIEUMANAGER();
        ResultSet rs = statement.executeQuery("SELECT * FROM NGUYENLIEU");
        while(rs.next()){
            NGUYENLIEU nl = new NGUYENLIEU(rs.getString(1),rs.getNString(2),rs.getNString(3));
            this.nlm.insertNL(nl);
        }
        return this.nlm.getListNL();
    }
    
    public List<CHAMCONG> loadingNHANVIENform(String date){
        this.ccm= new CHAMCONGMANAGER();
        try {
            String query ="SELECT MABCC, NGAYCHAMCONG, GHICHU ,MANV, SUM(SOGIOLAMVIEC) AS TONGSOGIOLAMVIEC\n" +
                            "FROM BANGCHAMCONG\n" +
                            "WHERE MONTH(NGAYCHAMCONG) = '"+ date +"'\n" +
                            "GROUP BY MABCC, NGAYCHAMCONG,GHICHU, MANV";
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                CHAMCONG cc = new CHAMCONG(rs.getString(1),rs.getString(2),rs.getNString(3),rs.getString(4),rs.getInt(5));
                this.ccm.insertCC(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VARIABLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.ccm.getListCC();
    }
    
    public List<THONGBAO> loadingThongBao() throws SQLException{
        this.tbm = new THONGBAOMANAGER();
        String query = "SELECT THONGBAO.MATB , THONGBAO.NOIDUNGTB, CT_THONGBAO.NGAYTB \n" +
                        "FROM CT_THONGBAO JOIN THONGBAO\n" +
                        "ON CT_THONGBAO.MATB = THONGBAO.MATB";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            THONGBAO tb = new THONGBAO(rs.getString(1),rs.getString(2));
            this.tbm.insertTB(tb);
        }
        return this.tbm.getListTB();
        
    }
    
    public List<CT_KM> loadingKhuyenMai() throws SQLException{
        this.ctkmm = new CT_KMMANAGER();
        String query = "USE QLCF\n" +
                        "SELECT * FROM CT_KM";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            CT_KM ctkm = new CT_KM(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
            this.ctkmm.insertCTKM(ctkm);
        }
        return this.ctkmm.getListCTKM();
        
    }
    
    public List<CT_MON> loadingDSCT() throws SQLException{
        this.ctmm = new CT_MONMANAGER();
        String query = "SELECT DISTINCT(CT2.MAMON), SUBSTRING(\n" +
                        "(\n" +
                        "	SELECT TRIM(NL.TENNGUYENLIEU) + ', ' \n" +
                        "	FROM CT_MON AS CT1 JOIN NGUYENLIEU AS NL\n" +
                        "       ON CT1.MANGUYENLIEU = NL.MANGUYENLIEU\n" +
                        "	WHERE CT2.MAMON = CT1.MAMON\n" +
                        "	FOR XML PATH('')\n" +
                        "),1, 100), SUBSTRING(\n" +
                        "(\n" +
                        "	SELECT TRIM(CT3.CACHLAM) + ', '\n" +
                        "	FROM CT_MON AS CT3\n" +
                        "	WHERE CT3.MAMON = CT2.MAMON\n" +
                        "	FOR XML PATH('')\n" +
                        "),1, 100)\n" +
                        "FROM CT_MON AS CT2";
        ResultSet rs = statement.executeQuery(query);

        while(rs.next()){
            CT_MON mon = new CT_MON(rs.getString(1),rs.getString(2), rs.getString(3));
            this.ctmm.insertCTMON(mon);
        }
        return this.ctmm.getListCTMON();
        
    }
    
    public String createMaThongBao() throws SQLException{
        List<String> existingRentCode = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT MATB FROM THONGBAO");
        
        while(result.next()){
            existingRentCode.add(result.getString(1));
        }
        
        if (existingRentCode.isEmpty()){
            return "TB1";
        }
        
        String hex = existingRentCode.get(existingRentCode.size() - 1).replaceFirst("TB", "");
        System.out.println(hex);
        int myInt = Integer.parseInt(hex.trim());
        myInt++;
        
        hex = Integer.toString(myInt);
        return "TB" + hex.toUpperCase().trim();
    }
    
    public void openInfoNhanVien(NHANVIEN nv) throws SQLException{
        this.ttnv.setVisible(true);
        this.ttnv.runTTNV(this, nv);
    }
    
    public void openDoiTKMK(TAIKHOAN tk){
        this.tkmk.setVisible(true);
        this.tkmk.runGDTKMK(this,tk);
    }
    
    public void openGDTB(){
        this.gdtb = new GD_TaoThongBao();
        this.gdtb.runGDTaoTB(this,this.GDQL);
        this.gdtb.setVisible(true);
    }
    
    public void openGDQL(TAIKHOAN tk) throws SQLException{
        login.setVisible(false);
        GDQL = new GD_QuanLy();
        GDQL.setVisible(true);
        GDQL.runGDQL(this,tk);
    }
    
    public void openLogInAgain(){
        login.setVisible(false);
        GDQL.setVisible(true);
        login.runLogIn(this);
    }
    
    public void openLogIn() throws SQLException{
        login.setVisible(true);
        login.runLogIn(this);
    }    
    
    public GD_QuanLy getGDQL() {
        return GDQL;
    }

    public void setGDQL(GD_QuanLy GDQL) {
        this.GDQL = GDQL;
    }

    public Database getDB() {
        return DB;
    }

    public void setDB(Database DB) {
        this.DB = DB;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
      
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    public Statement getStatement() {
        return statement;
    }

    public TAIKHOAN getTk() {
        return tk;
    }
    
    public void setTk(TAIKHOAN tk) {
        this.tk = tk;
    }    

    public NHANVIEN getNv() {
        return nv;
    }

    public void setNv(NHANVIEN nv) {
        this.nv = nv;
    }

    
    
    
    
    
}
