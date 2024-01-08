package component;

import model.ModelLoginPegawai;
import model.ModelLoginAdmin;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.MyComboBox;

public class PanelLoginAdminAndPegawai extends javax.swing.JLayeredPane {

    public ModelLoginAdmin getDataAdmin() {
        return dataAdmin;
    }
    public ModelLoginPegawai getDataPegawai() {
        return dataPegawai;
    }
    private ModelLoginAdmin dataAdmin;
    private ModelLoginPegawai dataPegawai;

    public PanelLoginAdminAndPegawai(ActionListener eventPegawai, ActionListener eventAdmin) {
        initComponents();
        initLoginPegawai(eventPegawai);
        initLoginAdmin(eventAdmin);
        admin.setVisible(false);
        pegawai.setVisible(true);
    }

    private void initLoginPegawai(ActionListener eventPegawai) {
        pegawai.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Login Pegawai");
        label.setFont(new Font("poppins", 1, 30));
        label.setForeground(new Color(39, 136, 226));
        pegawai.add(label);
        MyTextField txtUsername = new MyTextField();
        txtUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/img/user.png")));
        txtUsername.setHint("Username");
        pegawai.add(txtUsername, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/img/pass.png")));
        txtPass.setHint("Password");
        pegawai.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(39, 136, 226));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventPegawai);
        cmd.setText("Login");
        pegawai.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = txtUsername.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataPegawai = new ModelLoginPegawai(username, password);
            }
        });
    }

    private void initLoginAdmin(ActionListener eventAdmin) {
        admin.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Login Admin");
        label.setFont(new Font("poppins", 1, 30));
        label.setForeground(new Color(39, 136, 226));
        admin.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/img/user.png")));
        txtEmail.setHint("Username");
        admin.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/img/pass.png")));
        txtPass.setHint("Password");
        admin.add(txtPass, "w 60%");
        MyComboBox txtJabatan = new MyComboBox();
        txtJabatan.addItem("Admin");
        txtJabatan.addItem("Owner");
        txtJabatan.setPrefixIcon(new ImageIcon(getClass().getResource("/img/user-gear.png")));
        admin.add(txtJabatan, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(39, 136, 226));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventAdmin);
        cmd.setText("Login");
        admin.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                String jabatan = (String) txtJabatan.getSelectedItem();
                dataAdmin = new ModelLoginAdmin(username, password, jabatan);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            pegawai.setVisible(true);
            admin.setVisible(false);
        } else {
            pegawai.setVisible(false);
            admin.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pegawai = new javax.swing.JPanel();
        admin = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pegawai.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pegawaiLayout = new javax.swing.GroupLayout(pegawai);
        pegawai.setLayout(pegawaiLayout);
        pegawaiLayout.setHorizontalGroup(
            pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        pegawaiLayout.setVerticalGroup(
            pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pegawai, "card2");

        admin.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout adminLayout = new javax.swing.GroupLayout(admin);
        admin.setLayout(adminLayout);
        adminLayout.setHorizontalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        adminLayout.setVerticalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(admin, "card3");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin;
    private javax.swing.JPanel pegawai;
    // End of variables declaration//GEN-END:variables
}
