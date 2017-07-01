/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.Positions;
import com.documentsystem.model.Role;
import com.documentsystem.model.Users;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import logic.Controller;

/**
 *
 * @author Asus
 */
public class UpdateUser extends javax.swing.JFrame {

    /**
     * Creates new form UpdateUser
     */
    public UpdateUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        srediFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_userInfo = new javax.swing.JPanel();
        jTextField_userID = new javax.swing.JTextField();
        jTextField_name = new javax.swing.JTextField();
        jTextField_lastName = new javax.swing.JTextField();
        jTextField_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_role = new javax.swing.JComboBox();
        jComboBox_pos = new javax.swing.JComboBox();
        jButton_update = new javax.swing.JButton();
        jComboBox_bp = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField_userID.setEditable(false);
        jTextField_userID.setEnabled(false);

        jTextField_username.setEditable(false);
        jTextField_username.setEnabled(false);

        jLabel2.setText("User ID");

        jLabel3.setText("Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Username");

        jLabel6.setText("Role");

        jLabel7.setText("Position");

        jComboBox_role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_roleActionPerformed(evt);
            }
        });

        jComboBox_pos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton_update.setText("Update User Info");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jComboBox_bp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Business Partner");

        javax.swing.GroupLayout jPanel_userInfoLayout = new javax.swing.GroupLayout(jPanel_userInfo);
        jPanel_userInfo.setLayout(jPanel_userInfoLayout);
        jPanel_userInfoLayout.setHorizontalGroup(
            jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_userInfoLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_username)
                    .addComponent(jTextField_lastName)
                    .addComponent(jTextField_name)
                    .addComponent(jTextField_userID)
                    .addComponent(jComboBox_role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_pos, 0, 121, Short.MAX_VALUE)
                    .addComponent(jButton_update)
                    .addComponent(jComboBox_bp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel_userInfoLayout.setVerticalGroup(
            jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_userInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel_userInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_bp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_update)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jComboBox_role.getAccessibleContext().setAccessibleParent(this);
        jComboBox_pos.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_userInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel_userInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        
        try {
            String name = jTextField_name.getText().trim();
            String lastname=jTextField_lastName.getText().trim();
            String username = jTextField_username.getText().trim();
             Role role = (Role)jComboBox_role.getSelectedItem();
            Positions pos= (Positions)jComboBox_pos.getSelectedItem();
            Integer userID = (Integer.parseInt(jTextField_userID.getText()));
            Businesspartner bp = (Businesspartner) jComboBox_bp.getSelectedItem();
            
            Users u = new Users();
            u.setUserID(userID);
            u.setName(name);
            u.setLastName(lastname);
            u.setUsername(username);
            
            u.setRoleFk(role);
            u.setPos(pos);
            u.setBp(bp);

            Controller.getInstance().updateUser(u);
            JOptionPane.showMessageDialog(this, "User Updated!");
            this.dispose();
            ViewAllUsersForm v= new ViewAllUsersForm();
            v.setVisible(true);
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this, "User NOOOOOT Updated!");
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jComboBox_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_roleActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_update;
    public javax.swing.JComboBox jComboBox_bp;
    public javax.swing.JComboBox jComboBox_pos;
    public javax.swing.JComboBox jComboBox_role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel_userInfo;
    public javax.swing.JTextField jTextField_lastName;
    public javax.swing.JTextField jTextField_name;
    public javax.swing.JTextField jTextField_userID;
    public javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables

private void srediFormu()
  {
    try
    {
      java.util.List<Role> rc = Controller.getInstance().getRoleList();
      JComboBox roles = new JComboBox();
      jComboBox_role.removeAllItems();
      for (Role c : rc) {
        jComboBox_role.addItem(c);
        roles.addItem(c);
      }
  
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
      ex.printStackTrace();
    }
    
   try
    {
      java.util.List<Positions> lp = Controller.getInstance().getPositionList();
      JComboBox posi = new JComboBox();
      jComboBox_pos.removeAllItems();
      for (Positions p : lp) {
        jComboBox_pos.addItem(p);
        posi.addItem(p);
      }
  
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
      ex.printStackTrace();
    }

 try
    {
      java.util.List<Businesspartner> bp = Controller.getInstance().getPartnerList();
      JComboBox posi = new JComboBox();
      jComboBox_bp.removeAllItems();
      for (Businesspartner p : bp) {
        jComboBox_bp.addItem(p);
        posi.addItem(p);
      }
  
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
      ex.printStackTrace();
    }
    
  }


}
