/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Form;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ASUS
 */
public class LoginForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        
        // Membuat label tautan
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setForeground(Color.BLUE); // Atur warna teks menjadi biru
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Ubah kursor menjadi tangan saat diarahkan ke label
        
        // Menambahkan event listener untuk menangani klik pada label
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Buka form RegisterForm.java
                RegisterForm registerForm = new RegisterForm();
                registerForm.setVisible(true);
                getParent().add(registerForm);
                try {
                    registerForm.setSelected(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // Menambahkan label ke panel atau frame Anda
        jPanel1.add(registerLabel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pf_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setTitle("Login");

        jLabel4.setText("Nama :");

        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });

        jLabel5.setText("Password :");

        pf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passwordActionPerformed(evt);
            }
        });

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jLabel1.setText("Belum memiliki akun? silahkan register terlebih dahulu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Register");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_nama)
                            .addComponent(pf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaActionPerformed

    private void pf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passwordActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String inputUsername = tf_nama.getText();
        String inputPassword = new String(pf_password.getPassword());

        // Lakukan pengecekan ke database untuk mencocokkan username dan password
        try {
            // Lakukan koneksi ke database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projek_java", "root", "");

            // Buat query untuk mengambil data user berdasarkan username dan password
            String query = "SELECT * FROM users WHERE nama=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Jika data ditemukan, tampilkan pesan login berhasil
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                this.getDesktopPane().add(dashboard);
                this.dispose();
            } else {
                // Jika data tidak ditemukan, tampilkan pesan login gagal
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!");
            }

            // Tutup koneksi ke database
            conn.close();
        } catch (SQLException ex) {
            // Tangani kesalahan saat koneksi ke database
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kesalahan dalam koneksi database");
        }
    }//GEN-LAST:event_btn_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
