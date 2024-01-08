package form;

import dialog.Message;
import main.Main;
import Config.koneksi;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelBayarCicilan;
import model.ModelComboItem;
import model.ModelHistoriCicilan;
import swing.table.HistoriBayarCicilanEventAction;
import swing.table.HistoriCicilanEventAction;

public class Form_BayarCicilan extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();
    private String nik;
//    private HistoriBayarCicilanEventAction eventAction;

    public Form_BayarCicilan() {
        initComponents();
        table1.fixTable(jScrollPane2);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initTableData(nik);
        boxSearch();
    }

    private void initTableData(String nikk) {
        HistoriBayarCicilanEventAction eventAction = new HistoriBayarCicilanEventAction() {
            @Override
            public void delete(ModelBayarCicilan histori) {
                if (showMessage("Delete Pemhistori : " + histori.getId())) {
                    System.out.println("User click OK");
                } else {
                        }
            System.out.println("User click Cancel");
            }

            @Override
            public void update(ModelBayarCicilan histori) {
                if (showMessage("Bayar pada ID ini : " + histori.getId())) {
                    System.out.println("User click OK");
//                    String sql = "SELECT * FROM tb_detail_cicilan WHERE id_konfirmasi=? ";
//                    PreparedStatement pstmt = conn.prepareStatement(sql);
//                    pstmt.setInt(1, );
//                    ResultSet r = pstmt.executeQuery();
                    try {
                        int hargaPokok = Integer.parseInt(histori.getSisa());
                        String sqlUpdate = "UPDATE tb_detail_cicilan SET status=? WHERE kode_bayar = ?";
                        String sqlUpdate1 = "UPDATE tb_konfirmasi SET sisa_cicilan=? WHERE id_konfirmasi = ?";
                        PreparedStatement pst = conn.prepareStatement(sqlUpdate);
                        pst.setString(1, "Bayar");
                        pst.setInt(2, histori.getId());
                        PreparedStatement pst1 = conn.prepareStatement(sqlUpdate1); 
                        pst1.setInt(1, hargaPokok);
                        pst1.setInt(2, histori.getIdKonfirmasi());
                        pst1.executeUpdate();
                        int rowsAffected = pst.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Status cicilan di update");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, tidak ditemukan");
                            }
                    } catch(SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    initTableData(nikk);
                } else {
                    System.out.println("User click Cancel");
                }   
            }
        };
        try {
            String dataNik = nikk;
            String sqlSelect = "SELECT * FROM `tb_konfirmasi` INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian WHERE nik = ?";
            PreparedStatement sltc = conn.prepareStatement(sqlSelect);
            sltc.setString(1, dataNik);
            ResultSet s = sltc.executeQuery();
            System.out.println(dataNik);
            int myVariable = 0;
            if (s.next()) {
                int id = s.getInt("id_konfirmasi");
                myVariable = id;
                System.out.println("id_konfirmasi: " + id);
            }
            
            String sql = "SELECT * FROM tb_detail_cicilan WHERE id_konfirmasi=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, myVariable);
            ResultSet r = pstmt.executeQuery();
            while(r.next()) {
                ModelBayarCicilan bayar = new ModelBayarCicilan(
                r.getInt(1),
                r.getString(2),
                r.getString(3),
                r.getString(4),
                r.getString(5),
                r.getString(6),
                r.getString(7),
                r.getInt(8)
            );
             table1.addRow(bayar.toRowTable(eventAction));
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
    private void boxSearch() {
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
            comboBoxSuggestion.setModel(model);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan"+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();
        comboBoxSuggestion = new swing.ComboBoxSuggestion();
        btnSearch = new swing.Button();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Bayar Cicilan");

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
                "ID", "Bulan", "Angsuran Bunga", "Angsuran Pokok", "Total Angsuran", "Sisa Pinjaman", "Status", "ID Cicilan", "Action"
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
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(10);
            table1.getColumnModel().getColumn(1).setPreferredWidth(15);
        }

        comboBoxSuggestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuggestionActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(39, 136, 226));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnSearch.setText("Print");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Cari :");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxSuggestion, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxSuggestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 754, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try{
//            String nik = 
            String homeFolder = System.getProperty("user.home");
            String rekapFolder = homeFolder + "/rekap";
            File fileRekapFolder = new File(rekapFolder);
            if (!fileRekapFolder.exists()) {
                fileRekapFolder.mkdir();
            }
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
            String strDate = sdf.format(now);
            String fileName = rekapFolder +"/rekap bayar" + strDate + ".pdf";
            String dataNik = ((ModelComboItem) comboBoxSuggestion.getSelectedItem()).getId();
            String sqlSelect = "SELECT * FROM `tb_konfirmasi` INNER JOIN tb_pembelian ON tb_konfirmasi.id_pembelian = tb_pembelian.id_pembelian WHERE nik = ?";
            PreparedStatement sltc = conn.prepareStatement(sqlSelect);
            sltc.setString(1, dataNik);
            ResultSet s = sltc.executeQuery();
            System.out.println(dataNik);
            int myVariable = 0;
            if (s.next()) {
                int id = s.getInt("id_konfirmasi");
                myVariable = id;
                System.out.println("id_konfirmasi: " + id);
            }
            
            String sql = "SELECT * FROM tb_detail_cicilan WHERE id_konfirmasi=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, myVariable);
            ResultSet r = pstmt.executeQuery();
            Document d =new Document(PageSize.A4);
            try {
                PdfWriter.getInstance(d, new FileOutputStream(fileName));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Form_Histori_Owner.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.open();
            d.add(new Phrase("LAPORAN TRANSAKSI LUNAS"));

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
            headers[0] = new PdfPCell(new Phrase("Bulan", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[1] = new PdfPCell(new Phrase("Angsuran Bunga", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[2] = new PdfPCell(new Phrase("Angsuran Pokok", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[3] = new PdfPCell(new Phrase("Sisa", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[4] = new PdfPCell(new Phrase("Status", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            table.setHeaderRows(1);
            for (int i = 0; i < headers.length; i++) {
                table.addCell(headers[i]); // menambahkan baris header ke dalam tabel
            }
            
            while (r.next()) {
                String id = r.getString("bulan");
                String date = r.getString("angsuran_bunga");
                String name = r.getString("angsuran_pokok");
                String address = r.getString("sisa_cicilan");
                String amount = r.getString("status");

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
    }//GEN-LAST:event_btnSearchActionPerformed

    private void comboBoxSuggestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestionActionPerformed
        String nik = ((ModelComboItem) comboBoxSuggestion.getSelectedItem()).getId();
        if(nik != null && !nik.equals("")) {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            initTableData(nik);
        }
    }//GEN-LAST:event_comboBoxSuggestionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnSearch;
    private swing.ComboBoxSuggestion comboBoxSuggestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
