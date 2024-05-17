/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import database.Koneksi;
import static database.Koneksi.getConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import Form.FormJurusan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class FormSiswa extends javax.swing.JFrame {

    private Connection conn;
    
    public FormSiswa() {
        initComponents();
        conn = Koneksi.getConnection();
//        cbx_jurusan = new javax.swing.JComboBox<>();
        getDataJurusan();
        getData();
        disabledButton();
        enabledButton();
    }
    
//    private void printTable(){
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setJobName("Print Data Siswa");
//        
//        job.setPrintable((Graphics g, PageFormat pf, int pageIndex) ->{
//            if(pageIndex > 0){
//                return Printable.NO_SUCH_PAGE;
//            }
//            Graphics2D g2 = (Graphics2D) g;
//            g2.translate(pf.getImageableX(), pf.getImageableY());
//            
//            jTable_siswa.print(g2);
//            
//            return Printable.PAGE_EXISTS;
//        });
//        
//        if(job.printDialog()){
//            try{
//                job.print();
//            } catch (PrinterException ex){
//                Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    private void getDataJurusan() {
        ArrayList<String> jurusanList = FormJurusan.getDataJurusan(conn);

        // Bersihkan combo box sebelum mengisi ulang
        cbx_jurusan.removeAllItems();

        // Isi combo box dengan daftar jurusan yang diperoleh
        for(String jurusan : jurusanList) {
            cbx_jurusan.addItem(jurusan);
        }
    }

    private int getIdJurusan(String namaJurusan){
        int idJurusan = 0;
        try{
            String sql = "SELECT id_jurusan FROM jurusan WHERE jurusan = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, namaJurusan);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                idJurusan = rs.getInt("id_jurusan");
            }
        } catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE, null, e);
        }
        return idJurusan;
    }
    
    public int getJumlahSiswa(){
        int jumlahSiswa = 0;
        try{
            String sql = "SELECT COUNT(*) FROM siswa";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                jumlahSiswa = rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jumlahSiswa;
    }
    
    public int getSiswaLaki(){
        try{
            String sql = "SELECT COUNT(*) FROM siswa WHERE Jenis_Kelamin = 'laki-laki'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int getSiswaPerempuan(){
        try{
            String sql = "SELECT COUNT(*) FROM siswa WHERE Jenis_Kelamin = 'perempuan'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) jTable_siswa.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT siswa.ID, siswa.NIS, siswa.Nama, siswa.Tanggal_Lahir, siswa.Jenis_Kelamin, siswa.Alamat, jurusan.jurusan AS jurusan " +
                         "FROM siswa " + 
                         "INNER JOIN jurusan ON siswa.id_jurusan = jurusan.id_jurusan";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int ID          = rs.getInt("ID");
                int NIS         = rs.getInt("NIS");
                String Nama     = rs.getString("Nama");
                java.sql.Date Tgllahir  = rs.getDate("Tanggal_Lahir");
                String Jenkel   = rs.getString("Jenis_Kelamin");
                String Alamat   = rs.getString("Alamat");
                String Jurusan   = rs.getString("Jurusan");
                
                Object[] rowData = {ID, NIS, Nama, Tgllahir,Jenkel, Alamat, Jurusan};
                model.addRow(rowData);
            }
            
            rs.close();
            st.close();
            
        } catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_siswa = new javax.swing.JTable();
        jLabel_nis = new javax.swing.JLabel();
        jLabel_nama = new javax.swing.JLabel();
        jTF_nis = new javax.swing.JTextField();
        jTF_nama = new javax.swing.JTextField();
        jLabel_alamat = new javax.swing.JLabel();
        jTF_alamat = new javax.swing.JTextField();
        jTF_cari = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        cb_jenkel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dc_tanggal = new com.toedter.calendar.JDateChooser();
        btn_home = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbx_jurusan = new javax.swing.JComboBox<>();
        btn_print = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIMS");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_siswa.setBackground(new java.awt.Color(204, 204, 204));
        jTable_siswa.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jTable_siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NIS", "Nama", "Tgl Lahir", "JenKel", "Alamat", "Jurusan"
            }
        ));
        jTable_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_siswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_siswa);
        if (jTable_siswa.getColumnModel().getColumnCount() > 0) {
            jTable_siswa.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable_siswa.getColumnModel().getColumn(1).setMaxWidth(65);
            jTable_siswa.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jLabel_nis.setText("NIS ");

        jLabel_nama.setText("Nama");

        jTF_nis.setBackground(new java.awt.Color(153, 204, 255));
        jTF_nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_nisActionPerformed(evt);
            }
        });

        jTF_nama.setBackground(new java.awt.Color(153, 204, 255));
        jTF_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_namaActionPerformed(evt);
            }
        });

        jLabel_alamat.setText("Alamat");

        jTF_alamat.setBackground(new java.awt.Color(153, 204, 255));
        jTF_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_alamatActionPerformed(evt);
            }
        });

        jTF_cari.setBackground(new java.awt.Color(153, 204, 255));
        jTF_cari.setText("Cari");
        jTF_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_cariMouseClicked(evt);
            }
        });
        jTF_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_cariActionPerformed(evt);
            }
        });
        jTF_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cariKeyTyped(evt);
            }
        });

        btn_tambah.setBackground(new java.awt.Color(0, 102, 204));
        btn_tambah.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_perbarui.setBackground(new java.awt.Color(0, 102, 204));
        btn_perbarui.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_perbarui.setForeground(new java.awt.Color(255, 255, 255));
        btn_perbarui.setText("Perbarui");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        btn_batal.setBackground(new java.awt.Color(0, 102, 204));
        btn_batal.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(0, 102, 204));
        btn_hapus.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        cb_jenkel.setBackground(new java.awt.Color(153, 204, 255));
        cb_jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "laki-laki", "perempuan" }));
        cb_jenkel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_jenkelActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis kelamin");

        jLabel2.setText("Tanggal Lahir");

        dc_tanggal.setBackground(new java.awt.Color(153, 204, 255));

        btn_home.setBackground(new java.awt.Color(0, 102, 204));
        btn_home.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("Back");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        jLabel3.setText("Jurusan");

        cbx_jurusan.setBackground(new java.awt.Color(153, 204, 255));
        cbx_jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_jurusanActionPerformed(evt);
            }
        });

        btn_print.setBackground(new java.awt.Color(0, 102, 204));
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
                        .addComponent(btn_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_perbarui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_home))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTF_nis)
                                    .addComponent(jTF_nama)
                                    .addComponent(jTF_alamat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(cb_jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel_alamat))
                                        .addGap(215, 215, 215)))
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nama)
                                    .addComponent(jLabel_nis)
                                    .addComponent(dc_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                            .addComponent(jTF_cari))))
                .addGap(306, 306, 306))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTF_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_nama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_alamat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_nisActionPerformed

    private void jTF_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_namaActionPerformed

    private void jTF_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_alamatActionPerformed

    private void jTF_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_cariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nis              = jTF_nis.getText();
        String nama             = jTF_nama.getText();
        java.util.Date tgllahir = dc_tanggal.getDate();
        String jenkel           = (String) cb_jenkel.getSelectedItem();
        String alamat           = jTF_alamat.getText();
        
        String selectedJurusan = (String) cbx_jurusan.getSelectedItem();
        int idJurusan = getIdJurusan(selectedJurusan);
        
        java.sql.Date sqltanggal_lahir = new java.sql.Date(tgllahir.getTime());
        
        if(nis.isEmpty() || nama.isEmpty() || tgllahir == null || jenkel.isEmpty() || alamat.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        try {
            String sql = "INSERT INTO siswa (NIS, Nama, Tanggal_Lahir, Jenis_Kelamin, Alamat, id_jurusan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nis);
            st.setString(2, nama);
            st.setDate(3, sqltanggal_lahir);
            st.setString(4, jenkel);
            st.setString(5, alamat);
            st.setInt(6, idJurusan);
            
            int rowInserted = st.executeUpdate();
            if(rowInserted > 0 ){
                JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan!");
                resetForm();
                getData();
            }
            
            st.close();
        } catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        int selectedRow = jTable_siswa.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String id = jTable_siswa.getValueAt(selectedRow, 0).toString();
        String nis = jTF_nis.getText();
        String nama = jTF_nama.getText();
        java.util.Date tgllahir = dc_tanggal.getDate();
        String jenkel = (String) cb_jenkel.getSelectedItem();
        String alamat = jTF_alamat.getText();
        String jurusan = (String) cbx_jurusan.getSelectedItem();
        
        int idJurusan = getIdJurusan(jurusan);        
        java.sql.Date sqltanggal_lahir = new java.sql.Date(tgllahir.getTime());

        if(nis.isEmpty() || nama.isEmpty() || tgllahir == null || jenkel.isEmpty() || alamat.isEmpty() || jurusan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            String sql = "UPDATE siswa SET nis=?, nama=?, tanggal_lahir=?, jenis_kelamin=?, alamat=?, id_jurusan=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nis);
            st.setString(2, nama);
            st.setDate(3, sqltanggal_lahir);
            st.setString(4, jenkel);
            st.setString(5, alamat);
            st.setInt(6, idJurusan);
            st.setString(7, id);
            
            int rowUpdated = st.executeUpdate();
            if(rowUpdated > 0 ){
                JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui!");
                resetForm();
                getData();
            }
            
            st.close();
        }catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void jTable_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_siswaMouseClicked
        int selectedRow = jTable_siswa.getSelectedRow();
        if(selectedRow != -1) { 
            String nis = jTable_siswa.getValueAt(selectedRow, 1).toString();
            String nama = jTable_siswa.getValueAt(selectedRow, 2).toString();
            Object tanggallahirObj = jTable_siswa.getValueAt(selectedRow, 3);
            String tgllahirString = (tanggallahirObj != null) ? tanggallahirObj.toString() : "";
            String jenkel = jTable_siswa.getValueAt(selectedRow, 4).toString();
            String alamat = jTable_siswa.getValueAt(selectedRow, 5).toString();
            Object jurusanObject  = jTable_siswa.getValueAt(selectedRow, 6);
            String jurusan = (jurusanObject != null) ? jurusanObject.toString() : "";
            
            jTF_nis.setText(nis);
            jTF_nama.setText(nama);            
            cb_jenkel.setSelectedItem(jenkel);
            jTF_alamat.setText(alamat);
            cbx_jurusan.setSelectedItem(jurusan);
            
            if(!tgllahirString.isEmpty()){
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date tgllahir = sdf.parse(tgllahirString);
                    dc_tanggal.setDate(tgllahir);
                } catch (ParseException ex) {
                    Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                dc_tanggal.setDate(null);
            }
        }
        
        btn_tambah.setEnabled(false);
        btn_perbarui.setEnabled(true);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_jTable_siswaMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        enabledButton();
        disabledButton();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = jTable_siswa.getSelectedRow();
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui!", "Peringatan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String id = jTable_siswa.getValueAt(selectedRow, 0).toString();
            
            try{
                String sql = "DELETE FROM siswa WHERE id=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, id);
                
                int rowDelete = st.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus!");
                }
                st.close();
            }catch(Exception e){
                Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
            }
        }
        resetForm();
        getData();
        enabledButton();
        disabledButton();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jTF_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) jTable_siswa.getModel();
        model.setRowCount(0);
        
        String cari = jTF_cari.getText();
        
        try {
            String sql = "SELECT siswa.ID, siswa.NIS, siswa.Nama, siswa.Tanggal_Lahir, siswa.Jenis_Kelamin, siswa.Alamat, jurusan.Jurusan " +
                        "FROM siswa " +
                        "INNER JOIN jurusan ON siswa.id_jurusan = jurusan.id_jurusan " +
                        "WHERE siswa.ID LIKE ? OR siswa.NIS LIKE ? OR siswa.Nama LIKE ? OR siswa.Jenis_Kelamin LIKE ? OR siswa.Alamat LIKE ? OR jurusan.Jurusan LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + cari + "%");
            st.setString(2, "%" + cari + "%");
            st.setString(3, "%" + cari + "%");
            st.setString(4, "%" + cari + "%");
            st.setString(5, "%" + cari + "%");
            st.setString(6, "%" + cari + "%");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int ID                  = rs.getInt("ID");
                int NIS                 = rs.getInt("NIS");
                String Nama             = rs.getString("Nama");
                java.sql.Date Tgllahir  = rs.getDate("Tanggal_Lahir"); 
                String Jenkel           = rs.getString("Jenis_Kelamin"); 
                String Alamat           = rs.getString("Alamat");
                String Jurusan          = rs.getString("Jurusan");

                Object[] rowData = {ID, NIS, Nama, Tgllahir, Jenkel, Alamat, Jurusan};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
            
        } catch(Exception e){
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_jTF_cariKeyTyped

    private void jTF_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_cariMouseClicked
        jTF_cari.setText("");
    }//GEN-LAST:event_jTF_cariMouseClicked

    private void cb_jenkelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_jenkelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_jenkelActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void cbx_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_jurusanActionPerformed
        String namaJurusan = (String) cbx_jurusan.getSelectedItem();
        int idJurusan = getIdJurusan(namaJurusan);
        System.out.println("ID Jurusan: " + idJurusan);
    }//GEN-LAST:event_cbx_jurusanActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try{
            String reportPath = "src/Report/Report_DataSiswa.jasper";
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSiswa().setVisible(true);
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
    private javax.swing.JComboBox<String> cb_jenkel;
    private javax.swing.JComboBox<String> cbx_jurusan;
    private com.toedter.calendar.JDateChooser dc_tanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_alamat;
    private javax.swing.JLabel jLabel_nama;
    private javax.swing.JLabel jLabel_nis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_alamat;
    private javax.swing.JTextField jTF_cari;
    private javax.swing.JTextField jTF_nama;
    private javax.swing.JTextField jTF_nis;
    private javax.swing.JTable jTable_siswa;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        jTF_nis.setText("");
        jTF_nama.setText("");
        jTF_alamat.setText("");
        cb_jenkel.setSelectedItem("");
        cbx_jurusan.setSelectedItem("");
    }

    private void disabledButton() {
        btn_perbarui.setEnabled(false);
//        btn_batal.setEnabled(false);
        btn_hapus.setEnabled(false);
    }

    private void enabledButton() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }
}
