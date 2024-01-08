package form;

import dialog.Message;
import main.Main;
import Config.koneksi;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ModelHistori;
import swing.table.HistoriEventAction;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Form_Histori_Owner extends javax.swing.JPanel {
    
    private Connection conn = koneksi.koneksiSql();
//    private PageFormat pageFormat = new PageFormat(PageType.A4, 0, 0, PageOrientation.PORTRAIT);

    public Form_Histori_Owner() {
        initComponents();
        table1.fixTable(jScrollPane2);
        setOpaque(false);
        initData();
    }

    private void initData() {
        initTableData();
    }

    private void initTableData() {
        HistoriEventAction eventAction = new HistoriEventAction() {
            @Override
            public void delete(ModelHistori histori) {
                if (showMessage("Delete Pemhistori : " + histori.getIdHistori())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelHistori histori) {
                if (showMessage("Update Pemhistori : " + histori.getIdHistori())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }   
            }
        };
        try {
            String sql = "SELECT * FROM tb_histori INNER JOIN tb_pembelian ON tb_histori.id_pembelian = tb_pembelian.id_pembelian INNER JOIN tb_mobil ON tb_pembelian.id_mobil = tb_mobil.id_mobil";
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(sql);
            while(r.next()) {
                ModelHistori histori = new ModelHistori(
                r.getString("kode_riwayat"),
                r.getString("tgl_lunas"),
                r.getString("nama_mobil"),
                r.getString("nik"),
                r.getString("harga"),
                r.getString("jumlah_uang"),
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
//    private ParameterReportHistori getDataPrint() throws SQLException, FileNotFoundException, DocumentException {
//        
//        String sql = "SELECT * FROM tb_histori INNER JOIN tb_pembelian ON tb_histori.id_pembelian = tb_pembelian.id_pembelian INNER JOIN tb_mobil ON tb_pembelian.id_mobil = tb_mobil.id_mobil";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        List<FieldReportHistori> fiels = new ArrayList<>();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        ResultSet r = stmt.executeQuery();
//        
//        while(r.next()) {
//            String id_pembelian =r.getString("id_pembelian");
//            String tgl_lunas = r.getString("tgl_lunas");
//            String nama_mobil = r.getString("nama_mobil");
//            String nik = r.getString("nik");
//            int harga_mobil = r.getInt("harga");
//            int jumlah_uang = r.getInt("jumlah_uang");
//            fiels.add(new FieldReportHistori(id_pembelian, tgl_lunas, nama_mobil, harga_mobil, nik, jumlah_uang));
//        }
//        
//        return new ParameterReportHistori(fiels);
//     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new swing.table.Table();
        btnPdf = new swing.Button();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / histori lunas");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(464, 436));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Histori Lunas");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Riwayat", "Tanggal Lunas", "Mobil", "NIK", "Harga", "Jumlah Uang", "ID Transaksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        btnPdf.setBackground(new java.awt.Color(39, 136, 226));
        btnPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnPdf.setText("Buat PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

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
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGap(0, 758, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
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
            String fileName = rekapFolder +"/rekap lunas" + strDate + ".pdf";
            String sql = "SELECT * FROM tb_histori INNER JOIN tb_pembelian ON tb_histori.id_pembelian = tb_pembelian.id_pembelian INNER JOIN tb_mobil ON tb_pembelian.id_mobil = tb_mobil.id_mobil";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
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
            headers[0] = new PdfPCell(new Phrase("ID", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[1] = new PdfPCell(new Phrase("Date", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[2] = new PdfPCell(new Phrase("Mobil", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[3] = new PdfPCell(new Phrase("NIK", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            headers[4] = new PdfPCell(new Phrase("Harga", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            table.setHeaderRows(1);
            for (int i = 0; i < headers.length; i++) {
                table.addCell(headers[i]); // menambahkan baris header ke dalam tabel
            }
            
            while (r.next()) {
                String id = r.getString("id_pembelian");
                String date = r.getString("tgl_lunas");
                String name = r.getString("nama_mobil");
                String address = r.getString("nik");
                String amount = r.getString("harga");

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
    }//GEN-LAST:event_btnPdfActionPerformed
    private File showFileChooser() {
        JFileChooser ch = new JFileChooser();
        int opt = ch.showSaveDialog(this);
        if (opt == JFileChooser.APPROVE_OPTION) {
            return ch.getSelectedFile();
        } else {
            return null;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
