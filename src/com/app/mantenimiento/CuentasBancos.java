/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mantenimiento;

import com.entidades.TsBancosCtas;
import com.entidades.MtBancos;
import com.entidades.MtMonedas;
import com.entidades.TsBancosCtasId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author vanessa
 */
public class CuentasBancos extends javax.swing.JFrame {

    private Session st;
    private String usuario;
    private List<TsBancosCtas> cuentasBancos;
    SQLQuery query;

    /**
     * Creates new form MantenimientoCuentasBancos
     */
    public CuentasBancos() {
        initComponents();
        vaciarCampo();
        deshabilitar();
        sessionHibernate();
        getData();
    }

    public CuentasBancos(String user) {
        initComponents();
        vaciarCampo();
        deshabilitar();
        sessionHibernate();
        getData();
        this.usuario = user;
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCodigoBanco = new java.awt.TextField();
        textNumeroCuenta = new java.awt.TextField();
        textCodigoMoneda = new java.awt.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaListaCuentasBancos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonNuevo = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonInforme = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Cuentas Bancarias");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Codigo Banco:");

        jLabel3.setText("Numero de Cuenta:");

        jLabel4.setText("Codigo Moneda:");

        textCodigoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodigoBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodigoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(textCodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(textNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textCodigoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaListaCuentasBancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Banco", "Numero de Cuenta", "Cod Moneda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaListaCuentasBancos);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        botonNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonNuevo.setContentAreaFilled(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setMaximumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setMinimumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevoMouseClicked(evt);
            }
        });
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(botonNuevo);
        botonNuevo.setBounds(10, 10, 33, 33);

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        botonEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEditar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEditar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });
        jPanel2.add(botonEditar);
        botonEditar.setBounds(50, 10, 33, 33);

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        botonGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(botonGuardar);
        botonGuardar.setBounds(90, 10, 33, 33);

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        botonEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminar);
        botonEliminar.setBounds(130, 10, 33, 33);

        botonInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        botonInforme.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonInforme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInforme.setMaximumSize(new java.awt.Dimension(60, 60));
        botonInforme.setMinimumSize(new java.awt.Dimension(60, 60));
        botonInforme.setPreferredSize(new java.awt.Dimension(60, 60));
        botonInforme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformeActionPerformed(evt);
            }
        });
        jPanel2.add(botonInforme);
        botonInforme.setBounds(170, 10, 33, 33);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vaciarCampo() {
        textCodigoBanco.setText("");
        textNumeroCuenta.setText("");
        textCodigoMoneda.setText("");
    }

    private void textCodigoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodigoBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodigoBancoActionPerformed

    private void deshabilitar() {
        botonGuardar.setEnabled(false);
        textCodigoBanco.setEnabled(false);
        textCodigoMoneda.setEnabled(false);
        textNumeroCuenta.setEnabled(false);
    }

    private void getData() {
        sessionHibernate();
        cuentasBancos = new ArrayList<TsBancosCtas>();
        st.beginTransaction();
        String q = "select * from ts_bancos_ctas;";
        query = st.createSQLQuery(q);
        query.addEntity(TsBancosCtas.class);
        cuentasBancos = query.list();
        st.getTransaction().commit();
        String[][] data = new String[cuentasBancos.size()][3];

        for (int i = 0; i < cuentasBancos.size(); i++) {
            data[i][0] = (cuentasBancos.get(i).getMtBancos().getCodBanco());
            data[i][1] = (cuentasBancos.get(i).getId().getNroCuenta());
            data[i][2] = Integer.toString(cuentasBancos.get(i).getMtMonedas().getCodMoneda());
        }

        String[] columnNames = {"Cod Banco", "Numero de Cuenta", "Cod Moneda"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        TablaListaCuentasBancos.setModel(model);
        TablaListaCuentasBancos.setAutoscrolls(true);

    }

    private void botonNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevoMouseClicked

        // Habilita los campos para agregar un nuevo registro
        textCodigoBanco.setEnabled(true);
        textCodigoMoneda.setEnabled(true);
        textNumeroCuenta.setEnabled(true);
        botonGuardar.setEnabled(true);
        vaciarCampo();
    }//GEN-LAST:event_botonNuevoMouseClicked


    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // Evento ActionPerformed para botón nuevo.
    }//GEN-LAST:event_botonNuevoActionPerformed


    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        if (TablaListaCuentasBancos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                initValues(cuentasBancos.get(TablaListaCuentasBancos.getSelectedRow()));
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_botonEditarMouseClicked

    private void initValues(TsBancosCtas bc) {
        textNumeroCuenta.setText(bc.getId().getNroCuenta());
        textCodigoBanco.setEnabled(false);
        textCodigoMoneda.setEnabled(true);
        textCodigoMoneda.setText(Integer.toString(bc.getMtMonedas().getCodMoneda()));
        textCodigoBanco.setText((bc.getMtBancos().getCodBanco()));
        botonGuardar.setEnabled(true);
    }

    /*     */

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        guardar();
        vaciarCampo();
    }//GEN-LAST:event_botonGuardarMouseClicked

    public void guardar() {
        st.close();
        sessionHibernate();
        st.beginTransaction();
        
        Date fecha = new Date();
        
        TsBancosCtas c = new TsBancosCtas();
        String codBanco = textCodigoBanco.getText();
        String codCuenta = textNumeroCuenta.getText();
        TsBancosCtasId cid = new TsBancosCtasId(codBanco, codCuenta);
        c.setId(cid);
        c.setMtMonedas((MtMonedas) st.get(MtMonedas.class, textCodigoMoneda.getText()));
        c.setMtBancos((MtBancos) st.get(MtBancos.class, textCodigoBanco.getText()));
        c.setUsuarioMod(this.usuario);
        c.setFechaMod(fecha);
        
        st.saveOrUpdate(c);
        st.getTransaction().commit();
        st.close();
        getData();
        JOptionPane.showMessageDialog(null, "Registro guardado");
    }


    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        // TODO add your handling code here:
        if (TablaListaCuentasBancos.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea eiminar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                eliminarCuentasBancos(TablaListaCuentasBancos.getSelectedRow());
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_botonEliminarMouseClicked

    private void eliminarCuentasBancos(int pos) {
        st.beginTransaction();
        st.delete(cuentasBancos.get(pos));
        st.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro eliminado.");
        getData();
    }

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // eliminar();// Evento ActionPerformed para botón eliminar.
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInformeActionPerformed
        // informe();
    }//GEN-LAST:event_botonInformeActionPerformed

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
            java.util.logging.Logger.getLogger(CuentasBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuentasBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuentasBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuentasBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuentasBancos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaListaCuentasBancos;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonInforme;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.awt.TextField textCodigoBanco;
    private java.awt.TextField textCodigoMoneda;
    private java.awt.TextField textNumeroCuenta;
    // End of variables declaration//GEN-END:variables
}