/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.Positions;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import logic.Controller;

/**
 *
 * @author Asus
 */
public class UpdatePositions extends javax.swing.JFrame {
Businesspartner currentbp;
    /**
     * Creates new form UpdatePositions
     */
    public UpdatePositions() throws Exception {
        initComponents();
        srediFormu();
         this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_posName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_posDescription = new javax.swing.JTextArea();
        jButton_savePosition = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_busPartner = new javax.swing.JComboBox();
        jTextField_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Position Name");

        jLabel6.setText("Description");

        jTextArea_posDescription.setColumns(20);
        jTextArea_posDescription.setRows(5);
        jScrollPane1.setViewportView(jTextArea_posDescription);

        jButton_savePosition.setText("Update Position");
        jButton_savePosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_savePositionActionPerformed(evt);
            }
        });

        jLabel7.setText("Business Partner");

        jComboBox_busPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField_id.setEditable(false);
        jTextField_id.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_busPartner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_savePosition)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField_posName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_posName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_busPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jButton_savePosition)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_savePositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_savePositionActionPerformed

        try {
            String posName=jTextField_posName.getText().trim();
            String posDesc = jTextArea_posDescription.getText().trim();
            Integer posID = (Integer.parseInt(jTextField_id.getText().trim()));
            Businesspartner bsid = (Businesspartner) jComboBox_busPartner.getSelectedItem();
            if(posName.equals("")){
                JOptionPane.showMessageDialog(this, "Populate position name field please");

            }else{
                Positions p = new Positions();
                p.setPosName(posName);
                p.setPosDescription(posDesc);
                //p.setBusinessPartner();
                p.setPosID(posID);
                p.setBusinessPartner(bsid);

                Controller.getInstance().updatePosition(p);
                JOptionPane.showMessageDialog(this, "Position Updated!");

                this.dispose();
                    ViewAllPositions v = new ViewAllPositions();
                            v.setVisible(true);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Position Not Updated!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_savePositionActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdatePositions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePositions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePositions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePositions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UpdatePositions().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(UpdatePositions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_savePosition;
    public javax.swing.JComboBox jComboBox_busPartner;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea_posDescription;
    public javax.swing.JTextField jTextField_id;
    public javax.swing.JTextField jTextField_posName;
    // End of variables declaration//GEN-END:variables


 public void srediFormu() throws Exception{
    
     java.util.List<Businesspartner> lc = Controller.getInstance().getPartnerList();
            JComboBox partners = new JComboBox();
           jComboBox_busPartner.removeAllItems();
            for (Businesspartner c : lc) {
                jComboBox_busPartner.addItem(c);
                partners.addItem(c);
            }
    
    }




}