package form;

import static Config.ServiceUser.autokode;
import dialog.Message;
import main.Main;
import Config.koneksi;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelComboItem;
import model.ModelPembelian;
import model.ModelLogin;
import swing.table.PembelianEventAction;

public class Form_Transaksi extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();
    private ModelLogin modelLogin;
    
    public Form_Transaksi(ModelLogin modelLogin) {
        this.modelLogin = modelLogin;
        initComponents();
        table1.fixTable(jScrollPane2);
        setOpaque(false);
        initData();
        tfPetugas.setText(modelLogin.getUsername());
        String id = autokode("tb_pembelian", "id_pembelian", "TR");
        tfId.setText(id);
    }

    private void initData() {
        initTableData();
        boxBayar();
        boxPembeli();
    }
    
    private void blank(){
        tfDate.setCalendar(null);
        tfMobil.setText("");
        tfNik.getSelectedItem();
        tfBayar.getSelectedItem();
        tfPetugas.setText("");
        tfHarga.setText("");
        tfUang.setText("");
        tfSisa.setText("");
    }
    
    private void initTableData() {
        PembelianEventAction eventAction = new PembelianEventAction() {
            @Override
            public void delete(ModelPembelian beli) {
                if (showMessage("Delete transaksi : " + beli.getId())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelPembelian beli) {
                if (showMessage("Pilih ID mobil : " + beli.getId())) {
                    System.out.println("User click OK");
                    tfMobil.setText(beli.getId());
                    tfHarga.setText(beli.getHarga());
                } else {
                    System.out.println("User click Cancel");
                }   
            }
        };
        try {
            String sql = "SELECT * FROM tb_mobil INNER JOIN tb_merek ON tb_mobil.id_merek = tb_merek.id_merek WHERE stok=1";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()) {
                ModelPembelian beli = new ModelPembelian(
                r.getString("id_mobil"),
                r.getString("nama_mobil"),
                r.getString("harga_mobil"),
                r.getString("nama_merek"),
                r.getString("warna")
            );
             table1.addRow(beli.toRowTable(eventAction));
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
    
    private void boxBayar() {
        try{
            String sql = "SELECT * FROM tb_pembayaran";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            DefaultComboBoxModel<ModelComboItem> model = new DefaultComboBoxModel<>();
            
            while (hasil.next()) {
                model.addElement(new ModelComboItem(
                    hasil.getString("opsi_pembayaran"),
                    hasil.getString("id_pembayaran")
                ));
            }
            tfBayar.setModel(model);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan"+e);
        }
    }
    private void boxPembeli() {
        try{
            String sql = "SELECT * FROM tb_pembeli";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            DefaultComboBoxModel<ModelComboItem> model = new DefaultComboBoxModel<>();
            
            while (hasil.next()) {
                model.addElement(new ModelComboItem(
                    hasil.getString("nama_pembeli"),
                    hasil.getString("nik")
                ));
            }
            tfNik.setModel(model);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan"+e);
        }
    }
    private void checkKembalian(){
        try {
            int uang_masukan = Integer.parseInt(tfUang.getText());
            int harga = Integer.parseInt(tfHarga.getText());
            String bayar = ((ModelComboItem) tfBayar.getSelectedItem()).getId();
//            System.out.println(harga);
//            System.out.println(uang_masukan);
            if(bayar.equals("P01")){
                if (uang_masukan >= harga) {
                    int kembalian = uang_masukan - harga;
                    tfSisa.setText(Integer.toString(kembalian));
                } else {
                    showMessage("Uang kamu kurang !!!");
                    tfSisa.setText("");
                }
            }else if(bayar.equals("P02")){
                int kembalian = uang_masukan - harga;
                tfSisa.setText(Integer.toString(kembalian));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
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
        tfMobil = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfPetugas = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfUang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfSisa = new javax.swing.JTextField();
        tfDate = new com.toedter.calendar.JDateChooser();
        tfNik = new swing.ComboBoxSuggestion();
        tfBayar = new swing.ComboBoxSuggestion();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();
        jLabel16 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Transaksi");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(423, 563));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Tambah & Edit ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Pilihlah list mobil pada tabel dengan klik tombol action");
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
        jLabel7.setText("Tanggal");
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

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("Mobil");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 38));

        tfMobil.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 105, 105));
        jLabel9.setText("Nama");
        jLabel9.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel9.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(105, 105, 105));
        jLabel10.setText("Metode Bayar");
        jLabel10.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel10.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(105, 105, 105));
        jLabel11.setText("Petugas");
        jLabel11.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel11.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 38));

        tfPetugas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tfHarga.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(105, 105, 105));
        jLabel12.setText("Harga");
        jLabel12.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel12.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 38));

        tfUang.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfUang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUangActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 105, 105));
        jLabel13.setText("Jumlah uang");
        jLabel13.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel13.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 38));

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 105, 105));
        jLabel14.setText("Sisa");
        jLabel14.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel14.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel14.setPreferredSize(new java.awt.Dimension(100, 38));

        tfSisa.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tfDate.setDateFormatString("MMMM d, y");
        tfDate.setPreferredSize(new java.awt.Dimension(88, 25));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("* Tekan enter pada field jumlah uang");
        jLabel15.setMaximumSize(new java.awt.Dimension(100, 38));
        jLabel15.setMinimumSize(new java.awt.Dimension(100, 38));
        jLabel15.setPreferredSize(new java.awt.Dimension(100, 38));

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
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId)
                                    .addComponent(tfMobil)
                                    .addComponent(tfPetugas)
                                    .addComponent(tfHarga)
                                    .addComponent(tfUang)
                                    .addComponent(tfSisa)
                                    .addComponent(tfDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNik, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(tfBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfId)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNik, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                "ID", "Mobil", "Harga", "Merek", "Warna", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(105, 105, 105));
        jLabel16.setText("( Mobil yang sudah Ready)");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = tfId.getText();
        String tgl = new SimpleDateFormat("yyyy-MM-dd").format(tfDate.getDate());
        String harga = tfHarga.getText();
        String mobil = tfMobil.getText();
        String nik = ((ModelComboItem) tfNik.getSelectedItem()).getId();
        String petugas = tfPetugas.getText();
        String jumlahUang = tfUang.getText();
        String sisa = tfSisa.getText();
        String bayar = ((ModelComboItem) tfBayar.getSelectedItem()).getId();
        
        int nilaiAsli = Integer.parseInt(sisa);
        int nilaiAbsolut = Math.abs(nilaiAsli);
        int jumlahUangCtr = Integer.parseInt(jumlahUang);
        int hargaCtr = Integer.parseInt(harga);


        try {
            
                String matchUsername = "SELECT hitung_beli from tb_mobil WHERE id_mobil = ?";
    
           
                String sqlInsert = "INSERT INTO tb_pembelian (id_pembelian,tgl_pembelian,id_mobil,nik,id_pembayaran,username_petugas,harga,jumlah_uang) VALUES (?, ?, ?, ?,?,?,?,?)";
                String sqlUpdate = "UPDATE tb_mobil SET hitung_beli=?, stok=? WHERE id_mobil = ?";
                PreparedStatement stmt = conn.prepareStatement(matchUsername);
                stmt.setString(1, mobil);
                ResultSet r = stmt.executeQuery();
                int hitungBeli=0;
                if(r.next()){
                    int beli = r.getInt("hitung_beli");
                    hitungBeli = beli;
                    System.out.println(hitungBeli);
                }
                PreparedStatement stat = conn.prepareStatement(sqlInsert);
                stat.setString(1, id);
                stat.setString(2, tgl);
                stat.setString(3, mobil);
                stat.setString(4, nik);
                stat.setString(5, bayar);
                stat.setString(6, petugas);
                stat.setInt(7, hargaCtr);
                stat.setInt(8, jumlahUangCtr);
                if(stat.executeUpdate() > 0) { 
                    hitungBeli++;
                    PreparedStatement smt = conn.prepareStatement(sqlUpdate);
                    smt.setInt(1, hitungBeli);
                    smt.setInt(2, 0);
                    smt.setString(3, mobil);
                    smt.executeUpdate();
                    if(bayar.equals("P01")) {
                        String queryHistori = "INSERT INTO tb_histori (tgl_lunas, id_pembelian, sisa) VALUES (?, ?, ?)";
                        PreparedStatement histori = conn.prepareStatement(queryHistori);
                        histori.setString(1, tgl);
                        histori.setString(2, id);
                        histori.setInt(3, nilaiAbsolut);
                        if(histori.executeUpdate() > 0){
                            blank();
                            showMessage("Data berhasil ditambahkan ke riwayat");
                        }
                    }else if(bayar.equals("P02")){
                        String queryKonfirmasi = "INSERT INTO tb_konfirmasi (dp_cicilan, sisa_cicilan, status_cicilan, total_cicilan, lama_cicilan, id_pembelian) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement histori = conn.prepareStatement(queryKonfirmasi);
                        histori.setInt(1, jumlahUangCtr);
                        histori.setInt(2, nilaiAbsolut);
                        histori.setString(3, "Menyicil");
                        histori.setString(4, "0");
                        histori.setString(5, "0");
                        histori.setString(6, id);
                        if(histori.executeUpdate() > 0){
                            blank();
                            showMessage("Data berhasil ditambahkan ke list cicilan");
                        }
                    }
                }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        initTableData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        blank();
    }//GEN-LAST:event_btnResetActionPerformed
    private void tfUangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUangActionPerformed
//        try {
//            int uang_masukan = Integer.parseInt(tfUang.getText());
//            int harga = Integer.parseInt(tfHarga.getText());
//            String bayar = (String)tfBayar.getSelectedItem();
//            if(bayar.equals("P01")){
//                if (uang_masukan >= harga) {
//                    int kembalian = uang_masukan - harga;
//                    tfSisa.setText(Integer.toString(kembalian));
//                } else {
//                    tfSisa.setText("");
//                }
//            }else if(bayar.equals("P02")){
//                int kembalian = uang_masukan - harga;
//                tfSisa.setText(Integer.toString(kembalian));
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid input. Please enter a valid number.");
//        }   
        checkKembalian();
    }//GEN-LAST:event_tfUangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnReset;
    private swing.Button btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private swing.ComboBoxSuggestion tfBayar;
    private com.toedter.calendar.JDateChooser tfDate;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfMobil;
    private swing.ComboBoxSuggestion tfNik;
    private javax.swing.JTextField tfPetugas;
    private javax.swing.JTextField tfSisa;
    private javax.swing.JTextField tfUang;
    // End of variables declaration//GEN-END:variables
}
