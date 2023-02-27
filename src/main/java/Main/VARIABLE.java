/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import App.Login;
import BackFrameQuanLy.GD_QuanLy;
import NHANVIEN.NHANVIEN;
import NHANVIEN.NHANVIENMANAGER;
import TAIKHOAN.TAIKHOAN;


import java.sql.*;
public class VARIABLE {

    private final String NHAN_VIEN = "NV";
    private final String QUAN_LY = "QL";
    private final String GIAM_DOC = "GD";
    
    private Statement statement;
    private Connection connection;
   
    private Database DB;
    private GD_QuanLy GDQL;
    private Login login;
    
    private TAIKHOAN tk;
    private NHANVIEN nv;
    private NHANVIENMANAGER nvm;
    public VARIABLE() throws SQLException {
        this.DB = new Database();
        this.tk = new TAIKHOAN();
        this.nv = new NHANVIEN();
        this.nvm = new NHANVIENMANAGER();
        this.GDQL = new GD_QuanLy();
        this.login = new Login();
    }
    
    public boolean connectToSQL() throws SQLException{
        this.connection = this.DB.connectToDB();
        if(this.connection != null){
            this.statement = connection.createStatement();
            return true;
        }
        return false;
    }
    
    public void loadingGDQLform() throws SQLException{
        ResultSet rs = statement.executeQuery("SELECT * FROM NHANVIEN ");
        
        while(rs.next()){
            NHANVIEN NV = new NHANVIEN(rs.getString(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getString(9));
            this.nvm.insertNV(NV);           
        }
    }
    
    public void loadingData() throws SQLException{
        this.loadingGDQLform();
    }
    
    public void openGDQL(TAIKHOAN tk) throws SQLException{
        GDQL.setVisible(true);
        login.setVisible(false);
        GDQL.runGDQL(this,tk);
    }
    
    public void openLogIn(){
        login.setVisible(true);
        GDQL.setVisible(false);
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

    public String getNHAN_VIEN() {
        return NHAN_VIEN;
    }

    public String getQUAN_LY() {
        return QUAN_LY;
    }

    public String getGIAM_DOC() {
        return GIAM_DOC;
    }
    
    
}
