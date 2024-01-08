package form;

import static Config.ServiceUser.autokode;
import dialog.Message;
import main.Main;
import swing.table.MobilEventAction;
import javax.swing.ImageIcon;
import Config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelComboItem;
import model.ModelLogin;
import model.ModelMobil;

public class Form_Mobil extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();
    private ModelLogin modelLogin;
    
    public Form_Mobil(ModelLogin modelLogin) {
        this.modelLogin = modelLogin;
        initComponents();
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        tfAdmin.setText(modelLogin.getUsername());
        String id = autokode("tb_mobil", "id_mobil", "MB");
        tfId.setText(id);
    }

    private void initData() {
        initTableData();
        boxMerek();
    }
    private void blank() {
        tfNama.setText("");
        tfHarga.setText("");
        tfMerek.getSelectedItem();
        tfTahun.setText("");
        tfWarna.setText("");
    }
    private void initTableData() {
        MobilEventAction eventAction = new MobilEventAction(){
            @Override
            public void delete(ModelMobil mobil) {
                System.out.println("Oke");
                if (showMessage("Delete Mobil : " + mobil.getid())) {
                    System.out.println("User click OK");
                    try {
                        String sql = "DELETE FROM tb_mobil WHERE id_mobil = ?";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, mobil.getid());
                        int rowsAffected = pst.executeUpdate();
                            if (rowsAffected > 0) {
                                showMessage("ID "+mobil.getNamaMobil()+" data mobil berhasil dihapus" );
                            } else {
                                showMessage("Data Mobil tidak ditemukan");
                            }
                    } catch(SQLException e) {
                        showMessage("Error :" + e);
                    }
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    initTableData();
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelMobil mobil) {
                 System.out.println("Oke");
                if (showMessage("Update Mobil : " + mobil.getid())) {
                    System.out.println("User click OK");
                    tfId.setText(mobil.getid());
                    tfNama.setText(mobil.getNamaMobil());
                    tfHarga.setText(mobil.getHargaMobil());
                    tfMerek.setSelectedItem(mobil.getMerekMobil());
                    tfTahun.setText(mobil.getTahun());
                    tfWarna.setText(mobil.getWarnaMobil());
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
        try {
            String sql = "SELECT * FROM tb_mobil INNER JOIN tb_merek ON tb_mobil.id_merek = tb_merek.id_merek";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()) {
                ModelMobil mobil = new ModelMobil(
                    new ImageIcon(getClass().getResource("../img/profile.jpg")),
                    r.getString("nama_mobil"),
                    r.getString("id_mobil"),
                    r.getString("harga_mobil"),
                    r.getString("tahun_dirilis"),
                    r.getString("warna"),                   
                    r.getString("nama_merek"),
                    r.getString("username")
                );
                table1.addRow(mobil.toRowTable(eventAction));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }
    private void boxMerek() {
        try{
            String sql = "SELECT * FROM tb_merek";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            DefaultComboBoxModel<ModelComboItem> model = new DefaultComboBoxModel<>();
            
            while (hasil.next()) {
                model.addElement(new ModelComboItem(
                    hasil.getString("nama_merek"),
                    hasil.getString("id_merek")
                ));
            }
            tfMerek.setModel(model);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan"+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSave = new swing.Button();
        btnReset = new swing.Button();
        tfId = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTahun = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfWarna = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfAdmin = new javax.swing.JTextField();
        tfMerek = new swing.ComboBoxSuggestion();
        jLabel13 = new javax.swing.JLabel();
        btnStok = new swing.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Mobil");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(423, 563));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Tambah & Edit ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Menambahkan dan mengedit data pegawai");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(105, 105, 105));
        jLabel6.setText("ID");
        jLabel6.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel6.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 105, 105));
        jLabel7.setText("Nama");
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel7.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 38));

        btnSave.setBackground(new java.awt.Color(40, 167, 69));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(108, 117, 125));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ban-solid.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(53, 26));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tfId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tfNama.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tfHarga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("Harga");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 38));

        tfTahun.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("Tahun");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel9.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 38));

        tfWarna.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(105, 105, 105));
        jLabel10.setText("Warna");
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel10.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(105, 105, 105));
        jLabel11.setText("Merek");
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel11.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 38));

        tfAdmin.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tfMerek.setPreferredSize(new java.awt.Dimension(151, 38));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 105, 105));
        jLabel13.setText("Admin");
        jLabel13.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel13.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 38));

        btnStok.setBackground(new java.awt.Color(255, 255, 0));
        btnStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil-solid 1.png"))); // NOI18N
        btnStok.setText("Update Stok");
        btnStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId)
                                    .addComponent(tfNama)
                                    .addComponent(tfHarga)
                                    .addComponent(tfTahun)
                                    .addComponent(tfWarna)
                                    .addComponent(tfMerek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAdmin)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStok, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfId)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfWarna, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(464, 436));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Mobil");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "ID", "Harga", "Tahun", "Warna", "Merek", "Admin", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = tfId.getText();
        String name = tfNama.getText();
        String harga = tfHarga.getText();
        String warna = tfWarna.getText();
        String tahun = tfTahun.getText();
        String admin = tfAdmin.getText();
        String idMerek = ((ModelComboItem) tfMerek.getSelectedItem()).getId();
        System.out.println(idMerek);
        
//        int stokCtr = Integer.parseInt(stok);
        
        String sqlInsert = "INSERT INTO tb_mobil (id_mobil, warna, tahun_dirilis, harga_mobil, nama_mobil, id_merek, stok, hitung_beli, username) VALUES (?, ?, ?, ?,?,?,?,?,?)";
        String sqlUpdate = "UPDATE tb_mobil SET warna = ?, tahun_dirilis = ?, harga_mobil = ?, nama_mobil = ?, id_merek = ?WHERE id_mobil = ?";
        String matchUsername = "SELECT id_mobil from tb_mobil WHERE id_mobil = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(matchUsername);
            stmt.setString(1, id);
            ResultSet r = stmt.executeQuery();
            
                if(!r.isBeforeFirst()) {
                    PreparedStatement stat = conn.prepareStatement(sqlInsert);
                    do {
                        stat.setString(1, id);
                        stat.setString(2, warna);
                        stat.setString(3, tahun);
                        stat.setString(4, harga);
                        stat.setString(5, name);
                        stat.setString(6, idMerek);
                        stat.setString(7, "1");
                        stat.setString(8, "0");
                        stat.setString(9, admin);
                    }while(r.next()) ;  
                    if(stat.executeUpdate() > 0) {
                        blank();
                        showMessage("Data Mobil berhasil ditambahkan");
                    }
                } else {
                    PreparedStatement stat = conn.prepareStatement(sqlUpdate);
                        stat.setString(1, warna);
                        stat.setString(2, tahun);
                        stat.setString(3, harga);
                        stat.setString(4, name);
                        stat.setString(5, idMerek);
//                    stat.setString(4, admin);
                    r.next();
                    stat.setString(6, r.getString(1));
                    if(stat.executeUpdate() > 0) {
                        blank();
                        showMessage("Data Mobil berhasil diupdate");
                    }
                }
        } catch (SQLException e) {
            showMessage("Data Mobil gagal disimpan, error : "+e);
        }
        
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        initTableData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        blank();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStokActionPerformed
        String id = tfId.getText();
        try{
            String sqlUpdate = "UPDATE tb_mobil SET stok=? WHERE id_mobil = ?";
            PreparedStatement stat = conn.prepareStatement(sqlUpdate);
                stat.setString(1, "1");
                stat.setString(2, id);
            if(stat.executeUpdate() > 0) {
                showMessage("Stok Data Mobil berhasil diupdate");
            }
        }catch(SQLException e) {
            showMessage("Data Mobil gagal disimpan, error : "+e);
        }
    }//GEN-LAST:event_btnStokActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnReset;
    private swing.Button btnSave;
    private swing.Button btnStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.Table table1;
    private javax.swing.JTextField tfAdmin;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfId;
    private swing.ComboBoxSuggestion tfMerek;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfTahun;
    private javax.swing.JTextField tfWarna;
    // End of variables declaration//GEN-END:variables
}
