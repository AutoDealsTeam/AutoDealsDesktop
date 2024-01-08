package form;

import dialog.Message;
import main.Main;
import Config.koneksi;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ModelRekap;
import swing.datechooser.DateBetween;
import swing.datechooser.DateChooser;
import swing.datechooser.DateSelectable;
import swing.datechooser.listener.DateChooserAction;
import swing.datechooser.listener.DateChooserAdapter;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mysql.cj.conf.url.SingleConnectionUrl;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import swing.table.HistoriRekapEventAction;

public class Form_Keuangan extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();
    private DateChooser date = new DateChooser();
    private DefaultTableModel model;
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
    DecimalFormatSymbols formatRupiahSymbols = ((DecimalFormat) formatRupiah).getDecimalFormatSymbols();
    
    public Form_Keuangan() {
        initComponents();
        table2.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        formatRupiahSymbols.setCurrencySymbol("Rp ");
        ((DecimalFormat) formatRupiah).setDecimalFormatSymbols(formatRupiahSymbols);
        try{
            String sql = "SELECT SUM(angsuran_pokok) as total_angsuran_pokok FROM tb_detail_cicilan WHERE status = 'Bayar'";
            String sql1 = "SELECT SUM(harga) as total_lunas FROM tb_pembelian WHERE id_pembayaran = 'P01'";
            Statement stmt = conn.createStatement();
            Statement stms = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            ResultSet s = stms.executeQuery(sql1);
            int totalCicilan = 0;
            int totalLunas = 0;
            while(r.next()) {     
                totalCicilan = r.getInt("total_angsuran_pokok");
                String formattedTotalCicilan = formatRupiah.format(totalCicilan);
                lbTotalCicilan.setText(formattedTotalCicilan);
            }
            while(s.next()) {
                totalLunas = s.getInt("total_lunas");
                String formattedTotalLunas = formatRupiah.format(totalLunas);
                lbTotalLunas.setText(formattedTotalLunas);
                
                int totalPendapatan = totalCicilan + totalLunas;
                String formattedTotalPendapatan = formatRupiah.format(totalPendapatan);
                lbTotal.setText(formattedTotalPendapatan);
            }
            
        }catch (SQLException e) {
            System.out.println(e);
        }
        date.setTextField(tfDate);
        date.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        date.setLabelCurrentDayVisible(false);
        date.setDateFormat(new SimpleDateFormat("dd MMMM yyyy"));
        model = (DefaultTableModel) table2.getModel();
        date.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateChanged(Date date, DateChooserAction action) {
                System.out.println("date single selected...");
            }

            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String toDate = df.format(date.getToDate());
                loadData("SELECT * FROM tb_pembelian WHERE tgl_pembelian BETWEEN '"+dateFrom+"'AND'"+toDate+"'");
                
                try{
                    String sql = "SELECT SUM(angsuran_pokok) AS total FROM tb_konfirmasi INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian INNER JOIN tb_detail_cicilan ON tb_konfirmasi.id_konfirmasi = tb_detail_cicilan.id_konfirmasi WHERE tgl_pembelian BETWEEN '"+dateFrom+"'AND'"+toDate+"' AND status='Bayar'";
                    String sql1 = "SELECT SUM(harga) as total_lunas FROM tb_pembelian WHERE tgl_pembelian BETWEEN '"+dateFrom+"'AND'"+toDate+"' AND id_pembayaran = 'P01'";
                    Statement stms = conn.createStatement();
                    Statement stmt = conn.createStatement();
                    ResultSet s = stms.executeQuery(sql1);
                    ResultSet r = stmt.executeQuery(sql);
                    int totalCicilan = 0;
                    int  totalLunas = 0;
                    while(s.next()) {
                        totalLunas = s.getInt("total_lunas");
                        String formattedTotalLunas = formatRupiah.format(totalLunas);
                        lbLunasPerbulan.setText(formattedTotalLunas);
                    }
                    while(r.next()) {
                        totalCicilan = r.getInt("total");
                        String formattedTotalCicilan = formatRupiah.format(totalCicilan);
                        lbCicilanPerbulan.setText(formattedTotalCicilan);
                        
                        int totalPendapatan = totalCicilan + totalLunas;
                        String formattedTotalPendapatan = formatRupiah.format(totalPendapatan);
                        lbPerbulan.setText(formattedTotalPendapatan);
                    }
                }catch(SQLException e) {
                    System.out.println(e);
                }              
            }
        });
        date.setSelectedDateBetween(new DateBetween(getLast28Day(), new Date()));
    }
    private void loadData(String sql){
        try{
            model.setRowCount(0);
//            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while(r.next()) {
//                ModelRekap histori = new ModelRekap(
                String id = r.getString("id_pembelian");
                String tgl = r.getString("tgl_pembelian");
                String idMobil = r.getString("id_mobil");
                String nik = r.getString("nik");
                String idPembayaran = r.getString("id_pembayaran");
                int harga = r.getInt("harga");
                int jumlahUang = r.getInt("jumlah_uang");
                String user = r.getString("username_petugas");
//            );
            model.addRow(new Object[]{id, tgl, idMobil, nik, idPembayaran, harga, jumlahUang, user});
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }
    private Date getLast28Day(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -28);
        return cal.getTime();
    }
    private void initData() {
        initTableData();
        
    }

    private void initTableData() {
//        HistoriRekapEventAction eventAction = new HistoriRekapEventAction() {
//            @Override
//            public void delete(ModelRekap histori) {
//                if (showMessage("Delete Pemhistori : " + histori.getIdKonfirmasi())) {
//                    System.out.println("User click OK");
//                } else {
//                    System.out.println("User click Cancel");
//                }
//            }
//
//            @Override
//            public void update(ModelRekap histori) {
//                if (showMessage("Update Pemhistori : " + histori.getIdKonfirmasi())) {
//                    System.out.println("User click OK");
//                } else {
//                    System.out.println("User click Cancel");
//                }   
//            }
//        };
//        try {
//            String sql = "SELECT * FROM tb_konfirmasi INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian;";
//            Statement stmt = conn.createStatement();
//            ResultSet r = stmt.executeQuery(sql);
//            while(r.next()) {
//                ModelRekap histori = new ModelRekap(
//                r.getString("id_konfirmasi"),
//                r.getString("dp_cicilan"),
//                r.getString("sisa_cicilan"),
//                r.getString("status_cicilan"),
//                r.getString("total_cicilan"),
//                r.getString("lama_cicilan"),
//                r.getString("harga"),
//                r.getString("id_pembelian")
//            );
//             table2.addRow(histori.toRowTable(eventAction));
//        }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSearch2 = new swing.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTotalLunas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTotalCicilan = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbPerbulan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbLunasPerbulan = new javax.swing.JLabel();
        lbCicilanPerbulan = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tfDate = new swing.MyTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new swing.table.Table();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / laporan keuangan");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(464, 436));

        btnSearch2.setBackground(new java.awt.Color(39, 136, 226));
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnSearch2.setText("Buat PDF");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Pendapatan  ");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(105, 105, 105));
        jLabel4.setText("Pendapatan Lunas ");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbTotalLunas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbTotalLunas.setForeground(new java.awt.Color(105, 105, 105));
        lbTotalLunas.setText("Rp. 1 ");
        lbTotalLunas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 105, 105));
        jLabel7.setText("Pendapatan Cicilan ");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbTotalCicilan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbTotalCicilan.setForeground(new java.awt.Color(105, 105, 105));
        lbTotalCicilan.setText("Rp. 1");
        lbTotalCicilan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbTotal.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(105, 105, 105));
        lbTotal.setText("Rp. 1 ");
        lbTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbPerbulan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbPerbulan.setForeground(new java.awt.Color(105, 105, 105));
        lbPerbulan.setText("Rp. 1 ");
        lbPerbulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(105, 105, 105));
        jLabel5.setText("Pendapatan Per Tanggal ");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(105, 105, 105));
        jLabel13.setText("Pendapatan Lunas Per Tanggal");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbLunasPerbulan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbLunasPerbulan.setForeground(new java.awt.Color(105, 105, 105));
        lbLunasPerbulan.setText("Rp. 1 ");
        lbLunasPerbulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        lbCicilanPerbulan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lbCicilanPerbulan.setForeground(new java.awt.Color(105, 105, 105));
        lbCicilanPerbulan.setText("Rp. 1");
        lbCicilanPerbulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(105, 105, 105));
        jLabel16.setText("Pendapatan Cicilan Per Tanggal");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotal))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalLunas))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalCicilan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPerbulan)
                    .addComponent(lbCicilanPerbulan)
                    .addComponent(lbLunasPerbulan))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbPerbulan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbLunasPerbulan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lbCicilanPerbulan)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbTotalLunas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbTotalCicilan))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(76, 76, 76));
        jLabel9.setText("Laporan Keuangan");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(105, 105, 105));
        jLabel12.setText("Cari :");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Mobil", "NIK", "Jenis Bayar", "Harga", "Uang", "Pegawai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setPreferredWidth(15);
            table2.getColumnModel().getColumn(2).setPreferredWidth(15);
            table2.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        try{
            String homeFolder = System.getProperty("user.home");
            String rekapFolder = homeFolder + "/rekap";
            File fileRekapFolder = new File(rekapFolder);
            if (!fileRekapFolder.exists()) {
                fileRekapFolder.mkdir();
            }
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String strDate = sdf.format(now);
            String fileName = rekapFolder +"/rekap cicilan" + strDate + ".pdf";
            String sql = "SELECT * FROM tb_konfirmasi INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            Document d =new Document(PageSize.A4);
            try {
                PdfWriter.getInstance(d, new FileOutputStream(fileName));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Form_Histori_Owner.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.open();
            d.add(new Phrase("LAPORAN LIST CICILAN"));

            // Create a table and define the column widths
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(20);
            table.setSpacingAfter(20);

            // Define the table column widths
            float[] columnWidths = {2f, 2f, 2f, 2f, 2f};
            table.setWidths(columnWidths);

            // Add the table headers
            PdfPCell[] headers = new PdfPCell[5];
            headers[0] = new PdfPCell(new Phrase("ID", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[1] = new PdfPCell(new Phrase("Sisa", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[2] = new PdfPCell(new Phrase("Lama", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[3] = new PdfPCell(new Phrase("Total Angsuran", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[4] = new PdfPCell(new Phrase("Status", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            table.setHeaderRows(1);
            for (int i = 0; i < headers.length; i++) {
                table.addCell(headers[i]); // menambahkan baris header ke dalam tabel
            }
            
            while (r.next()) {
                String id = r.getString("id_konfirmasi");
                String date = r.getString("sisa_cicilan");
                String name = r.getString("lama_cicilan");
                String address = r.getString("total_cicilan");
                String amount = r.getString("status_cicilan");

                table.addCell(new Phrase(id, FontFactory.getFont(FontFactory.HELVETICA, 10)));
                table.addCell(new Phrase(date, FontFactory.getFont(FontFactory.HELVETICA, 10)));
                table.addCell(new Phrase(name, FontFactory.getFont(FontFactory.HELVETICA, 10)));
                table.addCell(new Phrase(address, FontFactory.getFont(FontFactory.HELVETICA, 10)));
                table.addCell(new Phrase(amount, FontFactory.getFont(FontFactory.HELVETICA, 10)));
            }
           
            d.add(table);
            d.close();
            
//            d.close();
        }catch(DocumentException ex){
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Form_Histori_Owner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Histori_Owner.class.getName()).log(Level.SEVERE, null, ex);
        }
        showMessage("PDF sudah dibuat");
    }//GEN-LAST:event_btnSearch2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSearch2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCicilanPerbulan;
    private javax.swing.JLabel lbLunasPerbulan;
    private javax.swing.JLabel lbPerbulan;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalCicilan;
    private javax.swing.JLabel lbTotalLunas;
    private swing.table.Table table2;
    private swing.MyTextField tfDate;
    // End of variables declaration//GEN-END:variables
}
