package form;

import dialog.Message;
import main.Main;
import Config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ModelHistoriCicilan;
import swing.table.HistoriCicilanEventAction;

public class Form_HistoriCicilan extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();

    public Form_HistoriCicilan() {
        initComponents();
        table1.fixTable(jScrollPane2);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initTableData();
        boxBunga();
    }
    
    private void blank(){
        tfId.setText("");
        tfLama.getSelectedItem();
        tfBunga.getSelectedItem();
        tfHarga.setText("");
        tfAbunga.setText("");
        tfPokok.setText("");
        tfTotal.setText("");
        tfSisa.setText("");
    }

    private void initTableData() {
        HistoriCicilanEventAction eventAction = new HistoriCicilanEventAction() {
            @Override
            public void delete(ModelHistoriCicilan histori) {
                if (showMessage("Delete Pemhistori : " + histori.getIdKonfirmasi())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelHistoriCicilan histori) {
                if (showMessage("ID yang dipilih : " + histori.getIdKonfirmasi())) {
                    System.out.println("User click OK");
                    tfHarga.setText(histori.getHarga());
                    tfId.setText(histori.getIdKonfirmasi());
//                    tfTotal.setText(histori.getTotal());
                    tfSisa.setText(histori.getSisa());
                } else {
                    System.out.println("User click Cancel");
                }   
            }
        };
        try {
            String sql = "SELECT * FROM tb_konfirmasi INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian;";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()) {
                ModelHistoriCicilan histori = new ModelHistoriCicilan(
                r.getString("id_konfirmasi"),
                r.getString("dp_cicilan"),
                r.getString("sisa_cicilan"),
                r.getString("status_cicilan"),
                r.getString("total_cicilan"),
                r.getString("lama_cicilan"),
                r.getString("harga"),
                r.getString("id_pembelian")
            );
             table1.addRow(histori.toRowTable(eventAction));
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
    private void boxBunga() {
        try{
            String sql = "SELECT * FROM tb_cicilan";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tfBunga.addItem(Double.toString(hasil.getDouble("bunga")));
            }
//            table1.setModel(tabmode);
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
        jLabel8 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfAbunga = new javax.swing.JTextField();
        tfSisa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfPokok = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        tfBunga = new swing.ComboBoxSuggestion();
        tfLama = new swing.ComboBoxSuggestion();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Histori Cicilan");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(423, 563));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Konfirmasi Cicilan");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Pilihlah list cicilan pada tabel !");
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
        jLabel7.setText("Lama Minjam");
        jLabel7.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel7.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 38));

        btnSave.setBackground(new java.awt.Color(40, 167, 69));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnSave.setText("Update");
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

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("Bunga");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 38));

        tfHarga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHargaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("Harga");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel9.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(105, 105, 105));
        jLabel11.setText("Angsuran Bunga");
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel11.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 38));

        tfAbunga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfAbunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAbungaActionPerformed(evt);
            }
        });

        tfSisa.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfSisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSisaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(105, 105, 105));
        jLabel12.setText("Sisa Cicilan");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel12.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 38));

        tfPokok.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfPokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPokokActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 105, 105));
        jLabel13.setText("Angsuran Pokok");
        jLabel13.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel13.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 105, 105));
        jLabel14.setText("Total Angsuran");
        jLabel14.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel14.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel14.setPreferredSize(new java.awt.Dimension(100, 38));

        tfTotal.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        tfLama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12", "24", "36", "48" }));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(105, 105, 105));
        jLabel10.setText("* Klik enter pada field harga");
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel10.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 38));

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId)
                                    .addComponent(tfHarga)
                                    .addComponent(tfAbunga)
                                    .addComponent(tfSisa)
                                    .addComponent(tfPokok)
                                    .addComponent(tfTotal)
                                    .addComponent(tfBunga, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(tfLama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfLama, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBunga, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAbunga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(464, 436));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Cicilan");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DP", "Sisa", "Status", "Total", "Lama", "Harga", "Transaksi", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = tfId.getText();
        String lama = (String) tfLama.getSelectedItem();
        String bunga = (String) tfBunga.getSelectedItem();
        String harga = tfHarga.getText();
        String total = tfTotal.getText();
        String sisa = tfSisa.getText();
        String aBunga = tfAbunga.getText();
        String aPokok = tfPokok.getText();
        
        int hargaCtr = Integer.parseInt(harga);
        int totalCtr = Integer.parseInt(total);
        int sisaCtr = Integer.parseInt(sisa);
        int bungaCtr = Integer.parseInt(aBunga);
        int pokokCtr = Integer.parseInt(aPokok);
        int lamaCtr = Integer.parseInt(lama);
        
        try{
            String sqlUpdate = "UPDATE tb_konfirmasi SET total_cicilan = ?, lama_cicilan = ? WHERE id_konfirmasi = ?";
            
            PreparedStatement stat = conn.prepareStatement(sqlUpdate);
            stat.setInt(1, totalCtr);
            stat.setString(2, lama);
            stat.setString(3, id);
            
            int result = stat.executeUpdate();
            if (result > 0) {
                int totalSisaCicilan = sisaCtr;
                for(int i = 1;i<=lamaCtr;i++){
                    totalSisaCicilan -= pokokCtr;
                    String sqlInsert = "INSERT INTO tb_detail_cicilan (bulan,angsuran_bunga,angsuran_pokok,total_angsuran,sisa_cicilan, status, id_konfirmasi) VALUES (?, ?, ?, ?, ?, ?, ?)"; 
                    PreparedStatement stam = conn.prepareStatement(sqlInsert);
                    stam.setInt(1, i);
                    stam.setInt(2, bungaCtr);
                    stam.setInt(3, pokokCtr);
                    stam.setInt(4, totalCtr);
                    stam.setInt(5, totalSisaCicilan);
                    stam.setString(6, "Belum");
                    stam.setString(7, id);
                    stam.executeUpdate();
                }
                blank();
                showMessage("Data berhasil diperbarui");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal diupdate");
            }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diupdate "+e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        blank();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tfHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHargaActionPerformed

        try {
            String bunga = (String) tfBunga.getSelectedItem();
            Double bungaValue = Double.parseDouble(bunga);
            int harga = Integer.parseInt(tfHarga.getText());
            String sisa = tfSisa.getText();
            int sisaCtr = Integer.parseInt(sisa);
            String lama = (String) tfLama.getSelectedItem();
            int lamaValue = Integer.parseInt(lama);
            
            double cicilanperbulan = sisaCtr / lamaValue;
            double bungaperbulan = cicilanperbulan * (bungaValue / 100);
            double totalCicilanPerbulan = cicilanperbulan + bungaperbulan;
            System.out.println(Math.round(totalCicilanPerbulan));
            int totalCicilan = (int) Math.round(totalCicilanPerbulan);
            int BungaCicilan = (int) Math.round(bungaperbulan);
            int PokokCicilan = (int) Math.round(cicilanperbulan);
            tfTotal.setText(String.valueOf(totalCicilan));
            tfAbunga.setText(String.valueOf(BungaCicilan));
            tfPokok.setText(String.valueOf(PokokCicilan));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }   
        
    }//GEN-LAST:event_tfHargaActionPerformed

    private void tfAbungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAbungaActionPerformed
      
    }//GEN-LAST:event_tfAbungaActionPerformed

    private void tfSisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSisaActionPerformed

    private void tfPokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPokokActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnReset;
    private swing.Button btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane2;
    private swing.table.Table table1;
    private javax.swing.JTextField tfAbunga;
    private swing.ComboBoxSuggestion tfBunga;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfId;
    private swing.ComboBoxSuggestion tfLama;
    private javax.swing.JTextField tfPokok;
    private javax.swing.JTextField tfSisa;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
