package main;

import Config.ServiceUser;
import component.Header;
import component.Menu;
import component.PanelCover;
import component.PanelLoginAdminAndPegawai;
import event.EventMenuSelected;
import event.EventShowPopupMenu;
import form.Form1;
import form.Form_BayarCicilan;
import form.Form_BungaCicilan;
import form.Form_Histori;
import form.Form_HistoriCicilan;
import form.Form_Histori_Owner;
import form.Form_Home;
import form.Form_Keuangan;
import form.Form_Merk;
import form.Form_Mobil;
import form.Form_Pembeli;
import form.Form_Rekap;
import form.Form_Transaksi;
import form.MainForm;
import swing.MenuItem;
import swing.PopupMenu;
import swing.icon.GoogleMaterialDesignIcons;
import swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import model.ModelLogin;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Dashboard extends javax.swing.JFrame {

    

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private PanelCover cover;
    private PanelLoginAdminAndPegawai loginAndRegister;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private ModelLogin modelLogin;

    public Dashboard(ModelLogin modelLogin) {
        this.modelLogin = modelLogin;
        initComponents();
        init();
    }
    private void init() {
        //dasboard
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        String username = modelLogin.getUsername();
        String role = modelLogin.getJabatan();
        header.setUsername(username);
        header.setRole(role);
//        header.setRole(username);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                switch (role){
                    case "Admin":
                        if (menuIndex == 0) {
                            if (subMenuIndex == 0) {
                                main.showForm(new Form_Home(modelLogin));
                            } else if (subMenuIndex == 1) {
                                main.showForm(new Form_Mobil(modelLogin));
                            }else if (subMenuIndex == 2) {
                                main.showForm(new Form_Merk());
                            }else if (subMenuIndex == 3) {
                                main.showForm(new Form_BungaCicilan());
                            }
                        }
                        break;
                    case "Pegawai":    
                        if(menuIndex == 0){
                            if(subMenuIndex == 0){
                                main.showForm(new Form_Pembeli());
                            }else if(subMenuIndex == 1){
                                main.showForm(new Form_Transaksi(modelLogin));
                            }else if(subMenuIndex == 2){
                                main.showForm(new Form_Histori());
                            }else if(subMenuIndex == 3){
                                main.showForm(new Form_HistoriCicilan());
                            }else if(subMenuIndex == 4){
                                main.showForm(new Form_BayarCicilan());
                            }
                        }
                        break;
                    case "Owner":
                        if(menuIndex == 0){
                            main.showForm(new Form_Histori_Owner());
                        }
                        if(menuIndex == 1){
                            main.showForm(new Form_Rekap());
                        }
                        if(menuIndex == 2){
                            main.showForm(new Form_Keuangan());
                        }
                        break;
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Dashboard.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Dashboard.this.getX() + 52;
                int y = Dashboard.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem(role);
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
//          Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        if(role.equals("Admin")){
            main.showForm(new Form_Home(modelLogin));
        }else if(role.equals("Pegawai")){
            main.showForm(new Form_Pembeli());
        }else if(role.equals("Owner")){
            main.showForm(new Form_Histori_Owner());
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1366, 783));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(ModelLogin modelLogin) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard(modelLogin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
