package com.app.seguridad;
import com.entidades.MtAccesosGrupos;
import com.entidades.MtAccesosGruposId;
import com.entidades.MtCargos;
import com.entidades.MtFormularios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

//@author Fausto Sanabria.

public class AccesosGrupos extends javax.swing.JDialog {
    public AccesosGrupos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Configuración de permisos por Roles - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();        
    }
    
    public AccesosGrupos(String user) {
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Configuración de permisos por Roles - KARU v1.0");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbEjecutar = new javax.swing.JComboBox();
        cmbInsertar = new javax.swing.JComboBox();
        cmbEditar = new javax.swing.JComboBox();
        cmbBorrar = new javax.swing.JComboBox();
        cmbCargo = new javax.swing.JComboBox();
        cmbFormularios = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Grupo");

        jLabel3.setText("Formulario");

        jLabel4.setText("Ejecución");

        jLabel5.setText("Inserción");

        jLabel6.setText("Edición");

        jLabel7.setText("Borrado");

        cmbEjecutar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));
        cmbEjecutar.setSelectedIndex(1);

        cmbInsertar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));
        cmbInsertar.setSelectedIndex(1);

        cmbEditar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));
        cmbEditar.setSelectedIndex(1);

        cmbBorrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));
        cmbBorrar.setSelectedIndex(1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbFormularios, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEjecutar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cmbInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbBorrar, cmbEditar, cmbEjecutar, cmbInsertar, jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5)))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFormularios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Grupo", "Formulario", "Ejecución", "Inserción", "Edición", "Borrado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.Byte.class, java.lang.Byte.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
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

        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        btnInforme.setToolTipText("Informe");
        btnInforme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInforme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
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
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo)
            .addComponent(btnAceptar)
            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelar)
            .addComponent(btnInforme)
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        obtenerTabla();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Permisos per = new Permisos();
        Boolean inserto = per.PuedeInsertar(usuario, formulario);
        if (!inserto) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para insertar" +
                    " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            nuevo();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        switch (accion) {
            case "Nuevo":
            guardar();
            break;
            case "Editar":
            guardarEd();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Permisos per = new Permisos();
        Boolean edito = per.PuedeModificar(usuario, formulario);
        if (!edito) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para editar" +
                    " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            editar();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Permisos per = new Permisos();
        Boolean elimino = per.PuedeEliminar(usuario, formulario);
        if (!elimino) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para eliminar" +
                    " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            eliminar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        informe();
        //JOptionPane.showMessageDialog(null, "Aqui va el informe");
    }//GEN-LAST:event_btnInformeActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        st.close();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(AccesosGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesosGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesosGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesosGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccesosGrupos dialog = new AccesosGrupos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbBorrar;
    private javax.swing.JComboBox cmbCargo;
    private javax.swing.JComboBox cmbEditar;
    private javax.swing.JComboBox cmbEjecutar;
    private javax.swing.JComboBox cmbFormularios;
    private javax.swing.JComboBox cmbInsertar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";
        
        //Seteamos los campos editables por el usuario
        this.cmbCargo.setEnabled(false);
        this.cmbCargo.setSelectedItem(null);
        this.cmbFormularios.setEnabled(false);
        this.cmbFormularios.setSelectedItem(null);
        this.cmbEjecutar.setEnabled(false);
        this.cmbInsertar.setEnabled(false);
        this.cmbEditar.setEnabled(false);
        this.cmbBorrar.setEnabled(false);
        this.cmbEjecutar.setSelectedItem(null);
        this.cmbInsertar.setSelectedItem(null);
        this.cmbEditar.setSelectedItem(null);
        this.cmbBorrar.setSelectedItem(null);
        
        //Seteamos el estado de los botones
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(true);
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        
        //Seteamos y cargamos la tabla
        defaultTableModel();
        cargarTabla();
        this.jTable1.setEnabled(true);   
    }
    
    public void defaultTableModel(){
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(170);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(270);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(35);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    public void cargarTabla(){
        st.beginTransaction();
        List<MtAccesosGrupos> lista = (List<MtAccesosGrupos>)st
                .createQuery("From MtAccesosGrupos Order By id.codCargo, id.nomFormulario").list();
        for (MtAccesosGrupos accesos : lista) {
            model.addRow(new Object[]{
                retornoCargoPorCodigo( accesos.getId().getCodCargo() ).getNomCargo(),
                accesos.getId().getNomFormulario(),
                accesos.getPuedeEjecutar(), accesos.getPuedeInsertar(), 
                accesos.getPuedeModificar(), accesos.getPuedeEliminar()
            });
        }
    }
    
    public void nuevo(){
        //Seteamos la accion
        accion = "Nuevo";
        
        //Los componentes editables
        //Primero lo primero, cargamos los combobox para después si habilitar.
        cargarComboCargos();
        cargarComboFormularios();
        this.cmbCargo.setEnabled(true);
        this.cmbFormularios.setEnabled(true);
        this.cmbCargo.setSelectedIndex(-1);
        this.cmbFormularios.setSelectedIndex(-1);
        this.cmbEjecutar.setEnabled(true);
        this.cmbInsertar.setEnabled(true);
        this.cmbEditar.setEnabled(true);
        this.cmbBorrar.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        
        //Los componentes editables
        //El cargo y el formulario son clave primaria, no los vamos a editar
        this.cmbEjecutar.setEnabled(true);
        this.cmbInsertar.setEnabled(true);
        this.cmbEditar.setEnabled(true);
        this.cmbBorrar.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.jTable1.setEnabled(false);
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showConfirmDialog(null,"Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        if(seleccion == 1){//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        }
        else{//Opción eliminar seleccionada
            st.beginTransaction();
            MtAccesosGruposId aid = new MtAccesosGruposId();
            Object codigoCargo = retornoCargoPorDescripcion((String) this.cmbCargo.getSelectedItem()).getCodCargo();
            aid.setCodCargo((int) codigoCargo);
            aid.setNomFormulario((String) this.cmbFormularios.getSelectedItem());
            MtAccesosGrupos a = (MtAccesosGrupos) st.load(MtAccesosGrupos.class, aid);
            st.delete(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro Eliminado...");
            arranque();
        }
    }
    
    public void cargarComboCargos(){
        this.cmbCargo.removeAllItems();
        List<MtCargos> lista = (List<MtCargos>)st.createQuery("From MtCargos").list();
        for(MtCargos cargoList : lista){
            this.cmbCargo.addItem(cargoList.getNomCargo());            
        }
    }
    
        
    public void cargarComboFormularios(){
        this.cmbFormularios.removeAllItems();
        List<MtFormularios> lista = (List<MtFormularios>)st.createQuery("From MtFormularios").list();
        for(MtFormularios formularioList : lista){
            this.cmbFormularios.addItem(formularioList.getNomFormulario());            
        }
    }
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.cmbEjecutar.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.cmbEjecutar.grabFocus();
               }
               else {
                   arranque();
               }
               break;
       }
    }

    public void guardar(){
        if(this.cmbCargo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el cargo.");
        }
        else if(this.cmbFormularios.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el formulario.");
        }
        else{
            st.beginTransaction();
            MtAccesosGruposId aid = new MtAccesosGruposId();
            Object codigoCargo = retornoCargoPorDescripcion((String) this.cmbCargo.getSelectedItem()).getCodCargo();
            
            aid.setCodCargo((int) codigoCargo);
            aid.setNomFormulario((String) this.cmbFormularios.getSelectedItem());
            
            MtAccesosGrupos a = new MtAccesosGrupos();
            a.setId(aid);
            a.setPuedeEjecutar( this.cmbEjecutar.getSelectedItem().toString().charAt(0));
            a.setPuedeInsertar( this.cmbInsertar.getSelectedItem().toString().charAt(0));
            a.setPuedeModificar( this.cmbEditar.getSelectedItem().toString().charAt(0));
            a.setPuedeEliminar( this.cmbBorrar.getSelectedItem().toString().charAt(0));
            
            a.setAccionMod(accion);
            a.setUsuarioMod(usuario);
            Calendar cal = Calendar.getInstance();
            a.setFechaMod(cal.getTime() );
            
            st.save(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            arranque();
        }
    }
    
    private void guardarEd(){
        st.beginTransaction();
        
        MtAccesosGruposId aid = new MtAccesosGruposId();
        Object codigoCargo = retornoCargoPorDescripcion((String) this.cmbCargo.getSelectedItem()).getCodCargo();
            
        aid.setCodCargo((int) codigoCargo);
        aid.setNomFormulario((String) this.cmbFormularios.getSelectedItem());

        MtAccesosGrupos a = (MtAccesosGrupos) st.load(MtAccesosGrupos.class, aid);
        
        a.setPuedeEjecutar( this.cmbEjecutar.getSelectedItem().toString().charAt(0));
        a.setPuedeInsertar( this.cmbInsertar.getSelectedItem().toString().charAt(0));
        a.setPuedeModificar( this.cmbEditar.getSelectedItem().toString().charAt(0));
        a.setPuedeEliminar( this.cmbBorrar.getSelectedItem().toString().charAt(0));
        
        a.setAccionMod(accion);
        a.setUsuarioMod(usuario);
        Calendar cal = Calendar.getInstance();
        a.setFechaMod(cal.getTime() );
        
        st.update(a);
        st.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro actualizado.");
        arranque();
    }
    
    public MtCargos retornoCargoPorDescripcion(String nomCargo){
        MtCargos tipRet = null;
        try {
            Query query = st.createQuery("From MtCargos c Where c.nomCargo = ?");
            query.setParameter(0, nomCargo);
            try {
                tipRet = (MtCargos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + nomCargo);
            }

        } catch (Exception e) {

        }
        return tipRet;
    }
    
    public MtCargos retornoCargoPorCodigo(Integer codCargo){
        MtCargos tipRet = null;
        try {
            Query query = st.createQuery("From MtCargos c Where c.codCargo = ?");
            query.setParameter(0, codCargo);
            try {
                tipRet = (MtCargos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + codCargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. ");
        }
        return tipRet;
    }
            
    public void obtenerTabla(){
        cargarComboCargos();
        cargarComboFormularios();
        int filaSeleccionada = this.jTable1.getSelectedRow();
        
        Object cargo = model.getValueAt(filaSeleccionada, 0);
        Object descFormulario = model.getValueAt(filaSeleccionada, 1);
        Object pEje = model.getValueAt(filaSeleccionada, 2);
        Object pIns = model.getValueAt(filaSeleccionada, 3);
        Object pUpd = model.getValueAt(filaSeleccionada, 4);
        Object pBor = model.getValueAt(filaSeleccionada, 5);

        this.cmbCargo.setSelectedItem(cargo.toString());
        this.cmbFormularios.setSelectedItem(descFormulario);
        this.cmbEjecutar.setSelectedItem(pEje.toString());
        this.cmbInsertar.setSelectedItem(pIns.toString());
        this.cmbEditar.setSelectedItem(pUpd.toString());
        this.cmbBorrar.setSelectedItem(pBor.toString());

        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/AccesosPorGruposQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, null, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Listado de Permisos por Cargos.");
            visor.setVisible(true);
            conexion.close();
            System.out.println("Conexion Cerrada");
        }
        catch(Exception e) {
            String mensajeEx = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error cargando reporte. " + mensajeEx);
        }
    }

}