/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import Main.Database;
import Main.VARIABLE;
import NHANVIEN.NHANVIEN;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GD_ThongTinNhanVien extends javax.swing.JFrame {
    private VARIABLE variables;
    private NHANVIEN nv;
    private Database data ;
    private Statement statement;
    public GD_ThongTinNhanVien() {
        initComponents();
    }

    public void runTTNV(VARIABLE variables, NHANVIEN nv) throws SQLException{
        this.variables = variables;
        this.data = data ;
        this.nv = nv;
        this.showInfo();
    }
    
    public void showInfo() throws SQLException{
        this.tf_manv.setText(nv.getManv().trim());
        this.tf_HọNV.setText(nv.getHo() +" "+ nv.getTen());
        this.tf_chucvu.setText(this.variables.getChucVu(nv.getManv()));
        this.tf_email.setText(nv.getEmail());
        this.txtDiachi.setText(nv.getDiachi());
        
        
        this.tf_manv.setEditable(false);
        this.tf_HọNV.setEditable(false);
        this.tf_chucvu.setEditable(false);
        this.tf_email.setEditable(false);
        this.txtDiachi.setEditable(false);
       
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
        tf_HọNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        btnXN = new javax.swing.JButton();
        tf_chucvu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        btnThayDoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();

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
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
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
        jLabel2.setText("Họ:");

        jLabel3.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(114, 149, 153));
        jLabel3.setText("Chức vụ:");

        tf_manv.setBackground(new java.awt.Color(255, 255, 255));
        tf_manv.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_manv.setForeground(new java.awt.Color(114, 149, 153));

        tf_HọNV.setBackground(new java.awt.Color(255, 255, 255));
        tf_HọNV.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_HọNV.setForeground(new java.awt.Color(114, 149, 153));

        jLabel5.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(114, 149, 153));
        jLabel5.setText("Email:");

        tf_email.setBackground(new java.awt.Color(255, 255, 255));
        tf_email.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_email.setForeground(new java.awt.Color(114, 149, 153));

        btnXN.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnXN.setForeground(new java.awt.Color(114, 149, 153));
        btnXN.setText("Xác nhận");
        btnXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXNActionPerformed(evt);
            }
        });

        tf_chucvu.setBackground(new java.awt.Color(255, 255, 255));
        tf_chucvu.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        tf_chucvu.setForeground(new java.awt.Color(114, 149, 153));
        tf_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_chucvuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(114, 149, 153));
        jLabel4.setText("Địa chỉ:");

        txtDiachi.setBackground(new java.awt.Color(255, 255, 255));
        txtDiachi.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtDiachi.setForeground(new java.awt.Color(114, 149, 153));

        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(114, 149, 153));
        jLabel6.setText("Tên:");

        txtTen.setBackground(new java.awt.Color(255, 255, 255));
        txtTen.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        txtTen.setForeground(new java.awt.Color(114, 149, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThayDoi)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_manv, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(tf_HọNV)
                                    .addComponent(tf_email)
                                    .addComponent(tf_chucvu)
                                    .addComponent(txtDiachi)
                                    .addComponent(txtTen))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(tf_HọNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThayDoi)
                .addGap(28, 28, 28)
                .addComponent(btnXN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
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

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
      
        this.tf_HọNV.setEditable(true);
        this.tf_email.setEditable(true);
        this.txtDiachi.setEditable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXNActionPerformed
        int dig = JOptionPane.showConfirmDialog(this, "Xác nhận sửa nhân viên","Sửa nhân viên",JOptionPane.YES_NO_OPTION);
        if (dig == JOptionPane.YES_OPTION) {
            NHANVIEN nvnew = new NHANVIEN() ;
            nvnew.setManv(tf_manv.getText());
            nvnew.setHo(tf_HọNV.getText());
            nvnew.setTen(txtTen.getText());
            nvnew.setMaCH("NV");
            nvnew.setEmail(tf_email.getText());
            nvnew.setDiachi(txtDiachi.getText());
            
            this.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnXN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_HọNV;
    private javax.swing.JTextField tf_chucvu;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_manv;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

}
