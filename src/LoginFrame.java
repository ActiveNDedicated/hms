
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAF
 */
public class LoginFrame extends javax.swing.JFrame {

    String query;
    DatabaseConnection dbc=new DatabaseConnection();
    User user;
    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 100, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 525));
        setResizable(false);
        getContentPane().setLayout(null);

        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(100, 310, 300, 40);

        loginField.setFont(new java.awt.Font("Roboto Lt", 0, 15)); // NOI18N
        loginField.setText("User Name");
        loginField.setBorder(null);
        loginField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginFieldMouseClicked(evt);
            }
        });
        loginField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginFieldKeyPressed(evt);
            }
        });
        getContentPane().add(loginField);
        loginField.setBounds(100, 160, 300, 30);

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        passwordField.setText("password");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        getContentPane().add(passwordField);
        passwordField.setBounds(100, 210, 300, 30);

        loginBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogInBackground.png"))); // NOI18N
        getContentPane().add(loginBackground);
        loginBackground.setBounds(0, -10, 510, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents
           
    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        query = " SELECT * FROM users ";
	ResultSet rs=dbc.getData(query);
        String login=loginField.getText();
        String password=new String(passwordField.getPassword());//String(char[] value)
        
        boolean found=false;
        try
            {
                while (rs.next()) 
                {
                  if(login.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
                {
                   dispose();
                   found=true;
                   if (rs.getInt("isManager")==1)
                       user=new Manager(rs.getString("firstname"),rs.getString("lastname"),rs.getString("phonenumber"),rs.getString("email"),new Address(rs.getString("country"),rs.getString("city"),rs.getString("street"),rs.getString("zipcode")),rs.getString("username"),rs.getString("password"));
                   else
                       user=new Receptionist(rs.getString("firstname"),rs.getString("lastname"),rs.getString("phonenumber"),rs.getString("email"),new Address(rs.getString("country"),rs.getString("city"),rs.getString("street"),rs.getString("zipcode")),rs.getString("username"),rs.getString("password"));
                   
                    /* Set the Windows look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MainFrame(user).setVisible(true);
                        dbc.closeconnection();
                    }
                });
                }               
                }
            }
            catch(SQLException e)
            {
                    System.out.println(e);
            }
//        if (loginField.getText().equals("admin") && passwordField.getText().equals("admin")){
//           dispose();
//            /* Set the Windows look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//        }
        if(!found) {
            JOptionPane.showMessageDialog(null, "Incorrect user name or password!", "Wrong enter", JOptionPane.ERROR_MESSAGE);
            loginField.setText("User Name");
            passwordField.setText("password");
        }
            
    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginFieldMouseClicked
        loginField.setText("");
    }//GEN-LAST:event_loginFieldMouseClicked

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        passwordField.setText("");
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
          loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginFieldKeyPressed
                    
    }//GEN-LAST:event_loginFieldKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loginBackground;
    private javax.swing.JLabel loginButton;
    private javax.swing.JTextField loginField;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
