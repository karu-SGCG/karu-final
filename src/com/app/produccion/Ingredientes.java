package com.app.produccion;

import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtCargos;
import com.entidades.MtMarcas;
import com.entidades.MtMonedas;
import com.entidades.MtTiposArticulos;
import com.entidades.MtUnidMedidas;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

//@author Fausto Sanabria.
public class Ingredientes extends javax.swing.JDialog {

    public Ingredientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Ingredientes - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
    }

    public Ingredientes(String user) {
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Ingredientes - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private String usuario;
    private String formulario;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoArticulo = new javax.swing.JComboBox();
        txtId = new javax.swing.JTextField();
        txtArticulo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        cmbMonedaCompra = new javax.swing.JComboBox();
        txtPrecioCompra = new javax.swing.JFormattedTextField();
        cmbUnidadMedidaCompra = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbUnidadMedidaVenta = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabIngredientes = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingredientes - KARU SGCG ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setIconImages(null);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código");

        jLabel3.setText("Ingrediente");

        jLabel7.setText("Moneda");

        txtId.setBackground(new java.awt.Color(255, 255, 204));
        txtId.setText("Id");
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tipo");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Unid. de Compra");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio Compra");

        jLabel12.setText("Referencia");

        cmbMonedaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guaraníes" }));

        txtPrecioCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtPrecioCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Unid. de Consumo");

        jLabel4.setText("Marca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbMonedaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtArticulo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(cmbTipoArticulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUnidadMedidaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUnidadMedidaCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbMonedaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cmbTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbUnidadMedidaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbUnidadMedidaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        btnGuardar.setToolTipText("Aceptar");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo)
            .addComponent(btnGuardar)
            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelar)
        );

        tabIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Ingrediente", "Marca", "Referencia", "Moneda", "Precio Compra", "Medida Compra", "Medida Consumo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabIngredientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabIngredientes);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Permisos per = new Permisos();
        Boolean inserto = per.PuedeInsertar(usuario, formulario);
        if (!inserto) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para insertar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            deshabilitarBotones();
            nuevo();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        switch (accion) {
            case "Nuevo":
                guardar();
                break;
            case "Editar":
                guardarEd();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //cancelar();
        habilitarBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Permisos per = new Permisos();
        Boolean edito = per.PuedeModificar(usuario, formulario);
        if (!edito) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para editar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            habilitarBotones();
            editar();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Permisos per = new Permisos();
        Boolean elimino = per.PuedeEliminar(usuario, formulario);
        if (!elimino) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para eliminar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            eliminar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabIngredientesMouseClicked
        obtenerTabla();
    }//GEN-LAST:event_tabIngredientesMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if (!"".equals(accion)) {
            int seleccion = JOptionPane.showConfirmDialog(null, "Existen datos que aun no se han guardado. ¿Confirma que desea cerrar?." ,
                "Ingredientes", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (seleccion == JOptionPane.YES_OPTION) {
                st.close();
                this.setVisible(false);
                this.dispose();
            }
        } else {
            st.close();
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        //verificar existencia
    }//GEN-LAST:event_txtIdFocusLost

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
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ingredientes dialog = new Ingredientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbMarca;
    private javax.swing.JComboBox cmbMonedaCompra;
    private javax.swing.JComboBox cmbTipoArticulo;
    private javax.swing.JComboBox cmbUnidadMedidaCompra;
    private javax.swing.JComboBox cmbUnidadMedidaVenta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabIngredientes;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtPrecioCompra;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque() {
        //Reseteamos la variable de acción
        accion = "";

        //Seteamos los campos editables por el usuario
        this.txtId.setEditable(false);
        this.txtId.setText("");
        this.txtArticulo.setEditable(false);
        this.txtArticulo.setText("");
        this.cmbMarca.setEnabled(false);
        this.cmbMarca.setSelectedItem(null);
        this.txtReferencia.setEditable(false);
        this.txtReferencia.setText("");
        this.cmbTipoArticulo.setEnabled(false);
        this.cmbTipoArticulo.setSelectedItem(null);
        this.cmbMonedaCompra.setEnabled(false);
        this.cmbMonedaCompra.setSelectedItem(null);
        this.cmbUnidadMedidaCompra.setEnabled(false);
        this.cmbUnidadMedidaCompra.setSelectedItem(null);
        this.cmbUnidadMedidaVenta.setEnabled(false);
        this.cmbUnidadMedidaVenta.setSelectedItem(null);
        this.txtPrecioCompra.setEditable(false);
        this.txtPrecioCompra.setValue(0);

        //Seteamos y cargamos la tabla
        defaultTableModel();
        cargarTabla();
        this.tabIngredientes.setEnabled(true);
        cargarComboTipoArt();
        cargarCombosMoneda();
        cargarCombosMedidas();
        cargarComboMarcas();
    }
    
    public void habilitarBotones(){
         //Seteamos el estado de los botones
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
    }
    
        public void deshabilitarBotones(){
         //Seteamos el estado de los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
    }

    public void defaultTableModel() {
        this.tabIngredientes.getColumnModel().getColumn(0).setPreferredWidth(80);       // código
        this.tabIngredientes.getColumnModel().getColumn(1).setPreferredWidth(200);      // ingrediente
        this.tabIngredientes.getColumnModel().getColumn(2).setPreferredWidth(200);      // marca
        this.tabIngredientes.getColumnModel().getColumn(3).setPreferredWidth(200);      // referencia
        this.tabIngredientes.getColumnModel().getColumn(4).setPreferredWidth(100);      // moneda compra
        this.tabIngredientes.getColumnModel().getColumn(5).setPreferredWidth(100);      // precio compra 
        this.tabIngredientes.getColumnModel().getColumn(6).setPreferredWidth(100);      // unidad medida compra
        this.tabIngredientes.getColumnModel().getColumn(7).setPreferredWidth(100);      // unidad medida venta
        model = (DefaultTableModel) this.tabIngredientes.getModel();
        model.setNumRows(0);
    }

    public void cargarTabla() {
        st.beginTransaction();
        List<MtArticulos> lista = (List<MtArticulos>) st
                .createQuery("From MtArticulos where esMateriaPrima = 'M' Order By codArticulo").list();
        for (MtArticulos unaLista : lista) {
            model.addRow(new Object[]{
                unaLista.getCodArticulo(), unaLista.getNomArticulo(), unaLista.getMtMarcas().getNomMarca(),
                unaLista.getReferencia(),
                unaLista.getMtMonedasByCodMonedaCompra().getNomMoneda(),
                unaLista.getPrecioCompra(), unaLista.getMtUnidMedidasByUniMedidaCom().getDescUnidad(),
                unaLista.getMtUnidMedidasByUniMedidaVenta().getDescUnidad()
            });
        }
    }

    public void nuevo() {
        //Seteamos la accion
        accion = "Nuevo";

        //Los componentes editables
        //Primero lo primero, cargamos los combobox para después si habilitar.
        this.cmbTipoArticulo.setEnabled(true);
        this.cmbTipoArticulo.setSelectedIndex(-1);
        this.txtId.setEditable(true);
        this.txtId.setText("");
        this.txtArticulo.setEditable(true);
        this.txtArticulo.setText("");
        this.cmbMarca.setEnabled(true);
        this.txtReferencia.setEditable(true);
        this.txtReferencia.setText("");
        this.cmbMonedaCompra.setEnabled(true);
        this.cmbMonedaCompra.setSelectedItem(null);
        this.cmbUnidadMedidaCompra.setEnabled(true);
        this.cmbUnidadMedidaCompra.setSelectedItem(null);
        this.txtPrecioCompra.setEditable(true);
        this.txtPrecioCompra.setValue(0);
        this.cmbUnidadMedidaVenta.setEnabled(true);
        this.cmbUnidadMedidaVenta.setSelectedItem(null);

        //Inicializamos
        this.txtId.grabFocus();
    }

    public void editar() {
        //Seteamos la accion
        accion = "Editar";

        //Los componentes editables
        //El cargo y el formulario son clave primaria, no los vamos a editar
        this.txtArticulo.setEditable(true);
        this.txtReferencia.setEditable(true);
        this.cmbTipoArticulo.setEnabled(true);
        this.cmbMonedaCompra.setEnabled(true);
        this.cmbMarca.setEnabled(true);
        this.cmbUnidadMedidaCompra.setEnabled(true);
        this.cmbUnidadMedidaVenta.setEnabled(true);
        this.txtPrecioCompra.setEditable(true);

        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);

        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.tabIngredientes.setEnabled(false);

        this.txtArticulo.grabFocus();
    }

    public void eliminar() {
        try {
            int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
            if (seleccion != 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.

                st.beginTransaction();

                int filaSeleccionada = this.tabIngredientes.getSelectedRow();

                Object valorDeFila = model.getValueAt(filaSeleccionada, 0);
                String codArticulo = valorDeFila.toString();

                Query query = st.createQuery("From MtArticulos a Where a.codArticulo = ? and a.esMateriaPrima = ?");
                query.setParameter(0, codArticulo);
                query.setParameter(1, 'M');

                MtArticulos a = (MtArticulos) query.uniqueResult();

                st.delete(a);
                st.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Registro Eliminado...");
                arranque();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el ingrediente. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Ingredientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarComboTipoArt() {
        this.cmbTipoArticulo.removeAllItems();
        List<MtTiposArticulos> lista = (List<MtTiposArticulos>) st.createQuery("From MtTiposArticulos").list();
        for (MtTiposArticulos cargoList : lista) {
            this.cmbTipoArticulo.addItem(cargoList.getNomTipoArticulo());
        }
    }

    public void cargarCombosMoneda() {
        this.cmbMonedaCompra.removeAllItems();
        List<MtMonedas> lista = (List<MtMonedas>) st.createQuery("From MtMonedas").list();
        for (MtMonedas listaMoneda : lista) {
            this.cmbMonedaCompra.addItem(listaMoneda.getNomMoneda());
        }
    }

    public void cargarCombosMedidas() {
        this.cmbUnidadMedidaCompra.removeAllItems();
        this.cmbUnidadMedidaVenta.removeAllItems();
        List<MtUnidMedidas> lista = (List<MtUnidMedidas>) st.createQuery("From MtUnidMedidas").list();
        for (MtUnidMedidas listaMedida : lista) {
            this.cmbUnidadMedidaCompra.addItem(listaMedida.getDescUnidad());
            this.cmbUnidadMedidaVenta.addItem(listaMedida.getDescUnidad());
        }
    }

    public void cargarComboMarcas() {
        this.cmbMarca.removeAllItems();
        List<MtMarcas> lista = (List<MtMarcas>) st.createQuery("From MtMarcas").list();
        for (MtMarcas listaMarca : lista) {
            this.cmbMarca.addItem(listaMarca.getNomMarca());
        }
    }

    private void cancelar() {
        switch (accion) {
            case "Nuevo":
                int seleccion = JOptionPane.showConfirmDialog(null,
                        "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (seleccion == 1) {
                    this.txtId.grabFocus();
                } else {
                    arranque();
                }
                break;
            case "Editar":
                int selec = JOptionPane.showConfirmDialog(null,
                        "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (selec == 1) {
                    this.txtArticulo.grabFocus();
                } else {
                    arranque();
                }
                break;
        }
    }

    public void guardar() {
        try {
            if (this.cmbTipoArticulo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de articulo.");
            } else if (this.cmbMonedaCompra.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la moneda de compra");
            } else if (this.cmbUnidadMedidaCompra.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida compra.");
            } else if (this.cmbMarca.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una marca para ingrediente.");
            } else if (this.cmbUnidadMedidaVenta.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida venta.");
            } else if (this.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto.");
            } else if (this.txtArticulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del articulo");
            } else if (this.txtPrecioCompra.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el precio de compra");
            } else {
                st.beginTransaction();

                Object marca = this.cmbMarca.getSelectedItem();
                MtMarcas codigoMarca = retornoMarcaPorDescripcion(marca.toString());

                Object tipoArt = this.cmbTipoArticulo.getSelectedItem();
                MtTiposArticulos codigoTipoArticulo = retornoTipoPorDescripcion(tipoArt.toString());

                Object codMonedaC = this.cmbMonedaCompra.getSelectedItem();
                MtMonedas codMonedaCo = retornoMonedaPorDescripcion(codMonedaC.toString());

                MtMonedas codMonedaVe = retornoMonedaPorDescripcion("Guaraní");

                Object codUniC = this.cmbUnidadMedidaCompra.getSelectedItem();
                MtUnidMedidas codUniCo = retornoUnidMedidaPorDescripcion(codUniC.toString());

                Object codUniV = this.cmbUnidadMedidaVenta.getSelectedItem();
                MtUnidMedidas codUniVe = retornoUnidMedidaPorDescripcion(codUniV.toString());

                MtArticulos a = new MtArticulos();

                a.setCodArticulo(this.txtId.getText());
                a.setNomArticulo(this.txtArticulo.getText());
                a.setMtMarcas(codigoMarca);
                a.setReferencia(this.txtReferencia.getText());
                a.setMtTiposArticulos(codigoTipoArticulo);
                a.setMtMonedasByCodMonedaCompra(codMonedaCo);
                a.setMtMonedasByCodMonedaVenta(codMonedaVe);
                a.setMtUnidMedidasByUniMedidaCom(codUniCo);
                a.setMtUnidMedidasByUniMedidaVenta(codUniVe);
                a.setPrecioCompra(new BigDecimal(this.txtPrecioCompra.getValue().toString()));
                a.setPrecioVenta(new BigDecimal(0));
                a.setControlStock('S');
                a.setEsMateriaPrima('M'); 
                a.setCantDiasVenc(0);
                a.setAccionMod(accion);
                a.setUsuarioMod(usuario);
                a.setFechaMod(new Date());

                st.save(a);
                st.getTransaction().commit();

                habilitarBotones();
                arranque();
            }
        } catch (NonUniqueObjectException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ya existe un ingrediente con el código ingresado. "
                    + "\n" + "Por favor ingrese otro código para el ingrediente",
                    "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
            this.txtId.grabFocus();
        } catch (HeadlessException | HibernateException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar registro del ingrediente. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Ingredientes", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void guardarEd() {
        try {
            if (this.cmbTipoArticulo.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de articulo.");
            } else if (this.cmbMonedaCompra.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la moneda de compra");
            } else if (this.cmbUnidadMedidaCompra.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida compra.");
            } else if (this.cmbUnidadMedidaVenta.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida venta.");
            } else if (this.cmbMarca.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar la marca del ingrediente.");
            } else if (this.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto.");
            } else if (this.txtArticulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del articulo");
            } else if (this.txtReferencia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la referencia");
            } else if (this.txtPrecioCompra.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el precio de compra");
            } else {
                
                st.beginTransaction();
                
                int filaSeleccionada = this.tabIngredientes.getSelectedRow();
                
                Object valorDeFila = model.getValueAt(filaSeleccionada, 0);
                String codArticulo = valorDeFila.toString();
                MtArticulos a = (MtArticulos) st.load(MtArticulos.class, codArticulo);
                Object marca = this.cmbMarca.getSelectedItem();
                MtMarcas codigoMarca = retornoMarcaPorDescripcion(marca.toString());
                Object tipoArt = this.cmbTipoArticulo.getSelectedItem();
                MtTiposArticulos codigoTipoArticulo = retornoTipoPorDescripcion(tipoArt.toString());
                Object codMonedaC = this.cmbMonedaCompra.getSelectedItem();
                MtMonedas codMonedaCo = retornoMonedaPorDescripcion(codMonedaC.toString());
                MtMonedas codMonedaVe = retornoMonedaPorDescripcion("Guaraní");
                Object codUniC = this.cmbUnidadMedidaCompra.getSelectedItem();
                MtUnidMedidas codUniCo = retornoUnidMedidaPorDescripcion(codUniC.toString());
                Object codUniV = this.cmbUnidadMedidaVenta.getSelectedItem();
                MtUnidMedidas codUniVe = retornoUnidMedidaPorDescripcion(codUniV.toString());

                a.setNomArticulo(this.txtArticulo.getText());
                a.setMtMarcas(codigoMarca);
                a.setReferencia(this.txtReferencia.getText());
                a.setMtTiposArticulos(codigoTipoArticulo);
                a.setMtMonedasByCodMonedaCompra(codMonedaCo);
                a.setMtMonedasByCodMonedaVenta(codMonedaVe);
                a.setMtUnidMedidasByUniMedidaCom(codUniCo);
                a.setMtUnidMedidasByUniMedidaVenta(codUniVe);
                a.setPrecioCompra(new BigDecimal(this.txtPrecioCompra.getValue().toString()));
                a.setPrecioVenta(new BigDecimal(0));
                a.setControlStock('S');
                a.setEsMateriaPrima('M');
                a.setCantDiasVenc(0);
                a.setAccionMod(accion);
                a.setUsuarioMod(usuario);
                a.setFechaMod(new Date());

                st.update(a);
                st.getTransaction().commit();
                
                JOptionPane.showMessageDialog(null, "Registro del ingrediente actualizado.");

                habilitarBotones();
                arranque();
            }
        } catch (HeadlessException | HibernateException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar registro del ingrediente. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Ingredientes", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public MtTiposArticulos retornoTipoPorDescripcion(String descripcion) {
        MtTiposArticulos tipRet = null;
        try {
            Query query = st.createQuery("From MtTiposArticulos c Where c.nomTipoArticulo = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtTiposArticulos) query.uniqueResult();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Hay más tipos con nombre: " + descripcion);
            }

        } catch (HibernateException | HeadlessException e) {
        }
        return tipRet;
    }

    public MtMarcas retornoMarcaPorDescripcion(String descripcion) {
        MtMarcas tipRet = null;
        try {
            Query query = st.createQuery("From MtMarcas c Where c.nomMarca = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtMarcas) query.uniqueResult();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Hay más masrcas con nombre: " + descripcion);
            }
        } catch (HeadlessException | HibernateException e) {

        }
        return tipRet;
    }

    public MtMonedas retornoMonedaPorDescripcion(String descripcion) {
        MtMonedas tipRet = null;
        try {
            Query query = st.createQuery("From MtMonedas c Where c.nomMoneda = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtMonedas) query.uniqueResult();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Hay más monedas de tipo: " + descripcion);
            }
        } catch (Exception e) {

        }
        return tipRet;
    }

    public MtUnidMedidas retornoUnidMedidaPorDescripcion(String descripcion) {
        MtUnidMedidas tipRet = null;
        try {
            Query query = st.createQuery("From MtUnidMedidas c Where c.descUnidad = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtUnidMedidas) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + descripcion);
            }

        } catch (Exception e) {

        }
        return tipRet;
    }

    public MtCargos retornoCargoPorCodigo(Integer codCargo) {
        MtCargos tipRet = null;
        try {
            Query query = st.createQuery("From MtCargos c Where c.codCargo = ?");
            query.setParameter(0, codCargo);
            try {
                tipRet = (MtCargos) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + codCargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. ");
        }
        return tipRet;
    }

    public void obtenerTabla() {

        int filaSeleccionada = this.tabIngredientes.getSelectedRow();

        Object marca = model.getValueAt(filaSeleccionada, 2);
        Object monedaCom = model.getValueAt(filaSeleccionada, 4);
        Object precioCom = model.getValueAt(filaSeleccionada, 5);
        Object medidaCom = model.getValueAt(filaSeleccionada, 6);
        Object medidaVen = model.getValueAt(filaSeleccionada, 7);

        this.txtId.setText(model.getValueAt(filaSeleccionada, 0).toString());
        this.txtArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
        this.txtReferencia.setText(model.getValueAt(filaSeleccionada, 3).toString());
        this.cmbMarca.setSelectedItem(marca.toString());
        this.cmbMonedaCompra.setSelectedItem(monedaCom.toString());
        this.cmbUnidadMedidaCompra.setSelectedItem(medidaCom.toString());
        this.cmbUnidadMedidaVenta.setSelectedItem(medidaVen.toString());
        this.txtPrecioCompra.setValue(new BigDecimal(precioCom.toString()));

        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
    }
}
