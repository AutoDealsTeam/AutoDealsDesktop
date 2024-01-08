package swing.table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class Action extends javax.swing.JPanel {

    public Action(ModelAction data) {
        initComponents();
        if (data.getPetugas()!= null) {
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getPetugasEvent().update(data.getPetugas());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getPetugasEvent().delete(data.getPetugas());
            });
        }
        else if (data.getMobil() != null) {
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getMobilEvent().update(data.getMobil());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getMobilEvent().delete(data.getMobil());
            });
        }else if(data.getMekr() != null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getMerkEvent().update(data.getMekr());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getMerkEvent().delete(data.getMekr());
            });
        }else if(data.getBunga() != null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getBungaEvent().update(data.getBunga());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getBungaEvent().delete(data.getBunga());
            });
        }else if(data.getPembeli() != null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getPembeliEvent().update(data.getPembeli());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getPembeliEvent().delete(data.getPembeli());
            });
        }else if(data.getBeli() != null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getPembelianEvent().update(data.getBeli());
            });
//            cmdDelete.addActionListener((ActionEvent ae) -> {
//                data.getPembelianEvent().delete(data.getBeli());
//            });
            cmdDelete.setVisible(false);
        }else if(data.getHistori()!= null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getHistoriEvent().update(data.getHistori());
            });
            cmdDelete.addActionListener((ActionEvent ae) -> {
                data.getHistoriEvent().delete(data.getHistori());
            });
        }else if(data.getHistoriCicilan() != null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getHistoriCicilanEvent().update(data.getHistoriCicilan());
            });
//            cmdDelete.addActionListener((ActionEvent ae) -> {
//                data.getHistoriCicilanEvent().delete(data.getHistoriCicilan());
//            });
            cmdDelete.setVisible(false);
        }else if(data.getBayarCicilan()!= null){
            cmdEdit.addActionListener((ActionEvent ae) -> {
                data.getBayarCicilanEvent().update(data.getBayarCicilan());
            });
//            cmdDelete.addActionListener((ActionEvent ae) -> {
//                data.getBayarCicilanEvent().delete(data.getBayarCicilan());
//            });
            cmdDelete.setVisible(false);
        }
    }
    

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new swing.Button();
        cmdDelete = new swing.Button();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(74, 40));

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cmdEdit.getAccessibleContext().setAccessibleDescription("");
        cmdDelete.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdEdit1ActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdDelete;
    private swing.Button cmdEdit;
    // End of variables declaration//GEN-END:variables
}
