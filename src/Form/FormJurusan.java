/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import database.Koneksi;
import static database.Koneksi.getConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author ASUS
 */
public class FormJurusan extends javax.swing.JFrame {

    private Connection conn;
    
    public FormJurusan() {
        initComponents();
        conn = Koneksi.getConnection();
//        getDataJurusan();
        getData();
        disabledButton();
        enabledButton();
    }
    
    
    
    public static ArrayList<String> getDataJurusan(Connection conn) {
    ArrayList<String> jurusanList = new ArrayList<>();
        try {
            String sql = "SELECT jurusan FROM jurusan";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            // Mengambil data jurusan dari hasil kueri
            while(rs.next()){
                String namaJurusan = rs.getString("jurusan");
                jurusanList.add(namaJurusan);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return jurusanList;
    }

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) jTable_jurusan.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM jurusan";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int ID          = rs.getInt("id_jurusan");
                String Jurusan   = rs.getString("Jurusan");
                
                Object[] rowData = {ID, Jurusan};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
            
        } catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public int getJumlahJurusan(){
        int jumlahJurusan = 0;
        try{
            String sql = "SELECT COUNT(*) FROM jurusan";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                jumlahJurusan = rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumlahJurusan;
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_jurusan = new javax.swing.JTable();
        btn_home = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        tf_cari = new javax.swing.JTextField();
        jTF_jurusan = new javax.swing.JTextField();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIMS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nama Jurusan");

        jTable_jurusan.setBackground(new java.awt.Color(204, 204, 204));
        jTable_jurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nama Jurusan"
            }
        ));
        jTable_jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_jurusanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_jurusan);
        if (jTable_jurusan.getColumnModel().getColumnCount() > 0) {
            jTable_jurusan.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        btn_home.setBackground(new java.awt.Color(0, 51, 153));
        btn_home.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("Back");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(0, 51, 153));
        btn_tambah.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_batal.setBackground(new java.awt.Color(0, 51, 153));
        btn_batal.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(0, 51, 153));
        btn_hapus.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_perbarui.setBackground(new java.awt.Color(0, 51, 153));
        btn_perbarui.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_perbarui.setForeground(new java.awt.Color(255, 255, 255));
        btn_perbarui.setText("Perbarui");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        tf_cari.setBackground(new java.awt.Color(153, 204, 255));
        tf_cari.setText("Cari...");
        tf_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cariMouseClicked(evt);
            }
        });
        tf_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cariActionPerformed(evt);
            }
        });
        tf_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_cariKeyTyped(evt);
            }
        });

        jTF_jurusan.setBackground(new java.awt.Color(153, 204, 255));
        jTF_jurusan.setText("Ketik nama jurusan...");
        jTF_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_jurusanActionPerformed(evt);
            }
        });

        btn_print.setBackground(new java.awt.Color(0, 51, 153));
        btn_print.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTF_jurusan)
                                        .addGap(41, 41, 41))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                            .addComponent(tf_cari)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        int selectedRow = jTable_jurusan.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String id = jTable_jurusan.getValueAt(selectedRow, 0).toString();
        String jurusan = jTF_jurusan.getText();
        
        if(jurusan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            String sql = "UPDATE jurusan SET jurusan=? WHERE id_jurusan=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, jurusan);
            st.setString(2, id);
            
            int rowUpdated = st.executeUpdate();
            if(rowUpdated > 0 ){
                JOptionPane.showMessageDialog(this, "Jurusan Berhasil Diperbarui!");
                resetForm();
                getData();
            }
            
            st.close();
        }catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = jTable_jurusan.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus jurusan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String id = jTable_jurusan.getValueAt(selectedRow, 0).toString();
            
            try{
                String sql = "DELETE FROM jurusan WHERE id_jurusan=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, id);
                
                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus!");
                }
                st.close();
            }catch(Exception e){
                Logger.getLogger(FormJurusan.class.getName()).log(Level.SEVERE,null, e);
            }
        }
        resetForm();
        getData();
        enabledButton();
        disabledButton();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        enabledButton();
        disabledButton();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String jurusan = jTF_jurusan.getText();
        
        if(jurusan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama Jurusan Harus Diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            String sql = "INSERT INTO jurusan (jurusan) VALUES (?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, jurusan);
            
            int rowInserted = st.executeUpdate();
            if(rowInserted > 0 ){
                JOptionPane.showMessageDialog(this, "Jurusan Berhasil Ditambahkan!");
                resetForm();
                getData();
            }
            
            st.close();
        } catch(Exception e){
            Logger.getLogger(FormJurusan.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void jTable_jurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_jurusanMouseClicked
        int selectedRow = jTable_jurusan.getSelectedRow();
        if(selectedRow != -1) { 
            String jurusan = jTable_jurusan.getValueAt(selectedRow, 1).toString();  
            jTF_jurusan.setText(jurusan);
        }
        
        btn_tambah.setEnabled(false);
        btn_perbarui.setEnabled(true);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_jTable_jurusanMouseClicked

    private void tf_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cariActionPerformed

    private void tf_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cariMouseClicked
        tf_cari.setText("");
    }//GEN-LAST:event_tf_cariMouseClicked

    private void jTF_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_jurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_jurusanActionPerformed

    private void tf_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) jTable_jurusan.getModel();
        model.setRowCount(0);
        
        String cari = tf_cari.getText();
        
        try {
            String sql = "SELECT * FROM jurusan WHERE id_jurusan LIKE ? OR jurusan LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int ID         = rs.getInt("id_jurusan");
                String jurusan = rs.getString("jurusan"); 

                Object[] rowData = {ID, jurusan};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
            
        } catch(Exception e){
            Logger.getLogger(FormJurusan.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_tf_cariKeyTyped

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try{
            String reportPath = "src/Report/Report_DataJurusan.jasper";
            Connection conn = getConnection();
                
            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
        } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Error Displaying Report : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_printActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJurusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_jurusan;
    private javax.swing.JTable jTable_jurusan;
    private javax.swing.JTextField tf_cari;
    // End of variables declaration//GEN-END:variables
    private void resetForm() {
        jTF_jurusan.setText("");
    }

    private void disabledButton() {
        btn_perbarui.setEnabled(false);
        // btn_batal.setEnabled(false);
        btn_hapus.setEnabled(false);
    }

    private void enabledButton() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }
}
