/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.seguridad;

import com.entidades.MtUsuarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 * @author Carlos Patino
 */
public class Login extends javax.swing.JDialog {

    private String usuario;
    private String contrasena;
    private boolean estado;

    /**
     * Creates new form frm_login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hibernateSession();
        arranque();
    }

    public Login() {
        initComponents();
        hibernateSession();
        arranque();
    }

    private Session st;
    private DefaultTableModel model;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_login_usuario = new javax.swing.JTextField();
        txt_login_contrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmd_login_ingresar = new javax.swing.JButton();
        cmd_login_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acceso al Sistema - KARU SGCG v1.0");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Acceso al Sistema");
        jLabel3.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_login_usuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_login_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        cmd_login_ingresar.setText("Ingresar");
        cmd_login_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_login_ingresarActionPerformed(evt);
            }
        });

        cmd_login_cancelar.setText("Cancelar");
        cmd_login_cancelar.setToolTipText("");
        cmd_login_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_login_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmd_login_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(cmd_login_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_login_cancelar)
                    .addComponent(cmd_login_ingresar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_login_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_login_ingresarActionPerformed

        if (!this.txt_login_usuario.getText().isEmpty() && !this.txt_login_contrasena.getText().isEmpty()) {
            try {
                MtUsuarios user = (MtUsuarios) st.load(MtUsuarios.class, this.txt_login_usuario.getText());
                if (user.getCodUsuario().equals(this.txt_login_usuario.getText())) {
                    if ('S' == user.getEsActivo()) {
                        if (user.getContasenia().equals(this.txt_login_contrasena.getText())) {
                            this.setUsuario(this.txt_login_usuario.getText());
                            this.setContrasena(this.txt_login_contrasena.getText());
                            this.setEstado(true);
                            this.st.close();
                            this.setVisible(false);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña inválida. Reintente",
                                    "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
                            arranque();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario se encuentra inactivo. Consulte con el admnistrador del sistema.",
                                "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
                        arranque();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario " + user.getNomUsuario() + "es inválido.",
                            "Acceso al Sistema", JOptionPane.INFORMATION_MESSAGE);
                    arranque();
                }
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos.",
                        "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
                arranque();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos.",
                    "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
            arranque();
        }
    }//GEN-LAST:event_cmd_login_ingresarActionPerformed

    private void cmd_login_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_login_cancelarActionPerformed
        arranque();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cmd_login_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_login_cancelar;
    private javax.swing.JButton cmd_login_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_login_contrasena;
    private javax.swing.JTextField txt_login_usuario;
    // End of variables declaration//GEN-END:variables

    public void setUsuario(String user) {
        this.usuario = user;
    }

    public void setContrasena(String pass) {
        this.contrasena = pass;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void arranque() {
        this.setEstado(false);
        this.txt_login_usuario.setText("");
        this.txt_login_contrasena.setText("");
        this.txt_login_usuario.grabFocus();
    }
}
