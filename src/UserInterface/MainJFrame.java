/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import BusinessLogic.DB4OUtil.DB4OUtil;
import BusinessLogic.EcoSystem;
import BusinessLogic.Enterprise.Enterprise;
import BusinessLogic.Network.Network;
import BusinessLogic.Organization.Organization;
import BusinessLogic.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nehal
 */


public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
       private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public MainJFrame() {
        initComponents();
        
         system = dB4OUtil.retrieveSystem();
       
        setSize(1500, 900);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJSplitPane = new javax.swing.JSplitPane();
        loginJPanel = new javax.swing.JPanel();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        logoutJButton = new javax.swing.JButton();
        loginJButton = new javax.swing.JButton();
        userJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        errLoginJLabel = new javax.swing.JLabel();
        errPasswordJLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userProcessContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        MainJSplitPane.setDividerLocation(250);

        loginJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userNameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameJTextFieldFocusLost(evt);
            }
        });
        loginJPanel.add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 155, 48));

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        loginJPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 153, 48));

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        loginJPanel.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 607, 160, 40));

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        loginJPanel.add(loginJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 150, 41));

        userJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/login_user.png"))); // NOI18N
        loginJPanel.add(userJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 40));

        passwordJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/login_password.png"))); // NOI18N
        loginJPanel.add(passwordJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        errLoginJLabel.setForeground(new java.awt.Color(255, 51, 102));
        loginJPanel.add(errLoginJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 180, -1));

        errPasswordJLabel.setForeground(new java.awt.Color(255, 51, 102));
        loginJPanel.add(errPasswordJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Login");
        loginJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        MainJSplitPane.setLeftComponent(loginJPanel);

        userProcessContainer.setLayout(new java.awt.CardLayout());

        title.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        title.setText("Smart Farming");
        jPanel1.add(title);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/care-512.png"))); // NOI18N
        jPanel1.add(jLabel1);

        userProcessContainer.add(jPanel1, "card2");

        MainJSplitPane.setRightComponent(userProcessContainer);

        getContentPane().add(MainJSplitPane, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        loginJButton.setEnabled(true);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        userProcessContainer.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        userProcessContainer.removeAll();
        JPanel blankJP = new JPanel();
        userProcessContainer.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
        dB4OUtil.storeSystem(system);
        
       
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // TODO add your handling code here:
        
       // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        
       boolean flag = true; 
        
        
        if(userName.isEmpty()){
            
            errLoginJLabel.setText("Username can not be empty");
            flag = false;
        }
        if(password.isEmpty()){
            
            errPasswordJLabel.setText("Password can not be empty");
            flag = false;
        }
        
        if(flag){
            
        

        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network inNetwork = null;
        if (userAccount == null) {
            //Step2: Go inside each network to check each enterprise
            for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {
                        //Step3: Check against each organization inside that enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                inNetwork = network;
                                break;
                            }
                        }
                    } else {
                        inEnterprise = enterprise;
                        inNetwork = network;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
                inNetwork = network;
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(this, "Invalid Credentails!");
            userNameJTextField.setText("");
            passwordField.setText("");
            
            return;
        } else {
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("workArea", userAccount.getRole().createWorkArea(userProcessContainer, userAccount, inOrganization, inEnterprise,inNetwork, system));
            layout.next(userProcessContainer);
        }
        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
        }  
//        Date date = new Date();
//        loginTimeJLabel.setText(String.valueOf(date));
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void userNameJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameJTextFieldFocusLost
       
        String userName = userNameJTextField.getText().trim();
        
        if(!userName.isEmpty()){
            
            errLoginJLabel.setText("");
        }
    }//GEN-LAST:event_userNameJTextFieldFocusLost

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
     char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        if(!password.isEmpty()){
            
            errPasswordJLabel.setText("");
        }
        
    }//GEN-LAST:event_passwordFieldFocusLost

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane MainJSplitPane;
    private javax.swing.JLabel errLoginJLabel;
    private javax.swing.JLabel errPasswordJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPanel loginJPanel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userJLabel;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}