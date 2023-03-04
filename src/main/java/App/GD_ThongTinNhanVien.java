/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Main.VARIABLE;
import NHANVIEN.NHANVIEN;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class GD_ThongTinNhanVien extends javax.swing.JFrame {
    private VARIABLE variables;
    private NHANVIEN nv;
    public GD_ThongTinNhanVien() {
        initComponents();
    }

    public void runTTNV(VARIABLE variables, NHANVIEN nv) throws SQLException{
        this.variables = variables;
        this.nv = nv;
        this.showInfo();
    }
    
    public void showInfo() throws SQLException{
        this.tf_manv.setText(nv.getManv().trim());
        this.tf_tenNV.setText(nv.getHo() +" "+ nv.getTen());
        this.tf_chucvu.setText(this.variables.getChucVu(nv.getManv()));
        this.tf_taikhoan.setText(nv.getTk());
        this.tf_matkhau.setText(this.variables.getMatKhau(nv.getTk()));
        
        this.tf_manv.setEditable(false);
        this.tf_tenNV.setEditable(false);
        this.tf_chucvu.setEditable(false);
        this.tf_taikhoan.setEditable(false);
        this.tf_matkhau.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_manv = new javax.swing.JTextField();
        tf_tenNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_taikhoan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_matkhau = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf_chucvu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(114, 149, 153));

        jLabel7.setFont(new java.awt.Font("UTM Avo", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin cá nhân");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(114, 149, 153));
        jLabel1.setText("Mã nhân viên:");

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(114, 149, 153));
        jLabel2.setText("Tên nhân viên:");

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(114, 149, 153));
        jLabel3.setText("Chức vụ:");

        tf_manv.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_manv.setForeground(new java.awt.Color(114, 149, 153));

        tf_tenNV.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_tenNV.setForeground(new java.awt.Color(114, 149, 153));

        jLabel5.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(114, 149, 153));
        jLabel5.setText("Tài khoản:");

        tf_taikhoan.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_taikhoan.setForeground(new java.awt.Color(114, 149, 153));

        jLabel6.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(114, 149, 153));
        jLabel6.setText("Mật khẩu:");

        tf_matkhau.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_matkhau.setForeground(new java.awt.Color(114, 149, 153));

        jButton1.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(114, 149, 153));
        jButton1.setText("Thay đổi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(114, 149, 153));
        jButton2.setText("Xác nhận");

        tf_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_chucvuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_manv)
                            .addComponent(tf_tenNV)
                            .addComponent(tf_taikhoan)
                            .addComponent(tf_matkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tf_chucvu))))
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_chucvuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_chucvuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.tf_tenNV.setEditable(true);
        this.tf_chucvu.setEditable(true);
        this.tf_taikhoan.setEditable(true);
        //this.variables.getDB().updateNhanVientoDB(variables.getStatement(), this.tf_manv.getText(), this.nv.getTen(), ten);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_chucvu;
    private javax.swing.JTextField tf_manv;
    private javax.swing.JTextField tf_matkhau;
    private javax.swing.JTextField tf_taikhoan;
    private javax.swing.JTextField tf_tenNV;
    // End of variables declaration//GEN-END:variables

}
