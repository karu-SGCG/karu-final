/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mantenimiento;

import com.entidades.MtTipoComprobantes;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import util.HibernateUtil;

import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import com.app.seguridad.Permisos;

/**
 *
 * @author Carlos Patino
 */
public class TipoComprobantes extends javax.swing.JDialog {

    private String usuario;
    private String origen;
    private String formulario;

    /**
     * Creates new form Formularios
     *
     * @param parent
     * @param modal
     */
    public TipoComprobantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        hibernateSession();
        arranque();
    }

    public TipoComprobantes(String user) {
        setLocationRelativeTo(null);
        initComponents();
        hibernateSession();
        this.setUsuario(user);
        this.cmdCancelar.setVisible(false);
        this.formulario = this.getClass().getSimpleName();
        arranque();
    }

    private Session st;
    private DefaultTableModel model;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmdNuevo = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdEditar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        cmdReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTipoComp = new javax.swing.JTable();
        cmdCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Areas - KARU v1.0");
        setMinimumSize(new java.awt.Dimension(473, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo de Comprobantes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 440, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        cmdNuevo.setToolTipText("Nuevo");
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });

        cmdGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        cmdGuardar.setToolTipText("Guardar");
        cmdGuardar.setMaximumSize(new java.awt.Dimension(91, 33));
        cmdGuardar.setMinimumSize(new java.awt.Dimension(91, 33));
        cmdGuardar.setPreferredSize(new java.awt.Dimension(91, 33));
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        cmdEditar.setToolTipText("Editar");
        cmdEditar.setMaximumSize(new java.awt.Dimension(91, 33));
        cmdEditar.setMinimumSize(new java.awt.Dimension(91, 33));
        cmdEditar.setPreferredSize(new java.awt.Dimension(91, 33));
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
            }
        });

        cmdBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        cmdBorrar.setToolTipText("Borrar");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        cmdCancelar.setToolTipText("Cancelar");
        cmdCancelar.setMaximumSize(new java.awt.Dimension(91, 33));
        cmdCancelar.setMinimumSize(new java.awt.Dimension(91, 33));
        cmdCancelar.setPreferredSize(new java.awt.Dimension(91, 33));
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        cmdReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        cmdReporte.setToolTipText("Informe");
        cmdReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 50, 440, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Código");

        jLabel3.setText("Descripción");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addComponent(txtDescripcion))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 100, 440, 70);

        tabTipoComp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabTipoComp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabTipoComp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabTipoComp.getTableHeader().setReorderingAllowed(false);
        tabTipoComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTipoCompMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabTipoComp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 440, 180);

        cmdCerrar.setText("Cerrar");
        cmdCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmdCerrar);
        cmdCerrar.setBounds(400, 380, 63, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 370, 440, 10);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCerrarActionPerformed
        this.st.close();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cmdCerrarActionPerformed

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed
        Permisos per = new Permisos();
        Boolean inserto = per.PuedeInsertar(usuario, formulario);
        if (!inserto) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para insertar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            arranque();
            this.setOrigen("Nuevo");
            this.cmdBorrar.setEnabled(false);
            this.cmdEditar.setEnabled(false);
            this.cmdGuardar.setEnabled(true);
            this.cmdCancelar.setVisible(true);
            this.txtDescripcion.setEditable(true);
            this.txtCodigo.setEditable(true);
            this.tabTipoComp.setEnabled(false);
        }
    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        arranque();
        this.cmdBorrar.setEnabled(true);
        this.cmdEditar.setEnabled(true);
        this.cmdCancelar.setVisible(false);
        this.txtDescripcion.setEditable(false);
        this.txtCodigo.setEditable(false);
        this.tabTipoComp.setEnabled(true);
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        Permisos per = new Permisos();
        Boolean elimino = per.PuedeEliminar(usuario, formulario);
        if (!elimino) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para eliminar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selectedRow = this.tabTipoComp.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro a eliminar.",
                        "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
            } else {
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Eliminación de Registro",
                        "Desea eliminar este registro.", JOptionPane.YES_NO_OPTION);
                if (showConfirmDialog == 1) {
                    JOptionPane.showMessageDialog(null, "Registro no eliminado.",
                            "Mantenimiento Tipo Comprobantes", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        st.beginTransaction();
                        Object valueAt = model.getValueAt(selectedRow, 0);
                        String codArea = valueAt.toString();
                        MtTipoComprobantes registro = (MtTipoComprobantes) st.load(MtTipoComprobantes.class, codArea);
                        st.delete(registro);
                        st.getTransaction().commit();
                        JOptionPane.showMessageDialog(null, "Registro eliminado.", "Mantenimiento Tipo Comprobantes",
                                JOptionPane.INFORMATION_MESSAGE);
                        arranque();
                    } catch (HibernateException | HeadlessException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar el registro. " + ex.getMessage(),
                                "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed
        Permisos per = new Permisos();
        Boolean edito = per.PuedeModificar(usuario, formulario);
        if (!edito) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para editar"
                    + " en el formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.setOrigen("Editar");
            this.cmdGuardar.setEnabled(true);
            this.cmdCancelar.setVisible(true);
            this.txtDescripcion.setEditable(true);
            this.txtCodigo.setEditable(true);
            this.tabTipoComp.setEnabled(false);
        }
    }//GEN-LAST:event_cmdEditarActionPerformed

    private void tabTipoCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTipoCompMouseClicked
        seleccionarItem();
    }//GEN-LAST:event_tabTipoCompMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cmdReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReporteActionPerformed
        informe();
    }//GEN-LAST:event_cmdReporteActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoComprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TipoComprobantes dialog = new TipoComprobantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdCerrar;
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JButton cmdReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabTipoComp;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

    private void setUsuario(String user) {
        this.usuario = user;
    }

    public String getUsuario() {
        return this.usuario;
    }

    private void setOrigen(String orig) {
        this.origen = orig;
    }

    public String getOrigen() {
        return this.origen;
    }

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque() {
        this.txtDescripcion.setText("");
        this.txtCodigo.setText("");
        this.cmdGuardar.setEnabled(false);
        this.cmdCancelar.setVisible(false);
        tableModel();
        cargarTabla();
    }

    public void tableModel() {
        //this.tabTipoComp.getColumnModel().getColumn(0).setPreferredWidth(10);
        //this.tabTipoComp.getColumnModel().getColumn(1).setPreferredWidth(50);
        model = (DefaultTableModel) this.tabTipoComp.getModel();
        model.setNumRows(0);
    }

    public void cargarTabla() {
        try {
            List<MtTipoComprobantes> lista = (List<MtTipoComprobantes>) st.createQuery("from MtTipoComprobantes").list();
            for (MtTipoComprobantes areaList : lista) {
                model.addRow(new Object[]{
                    areaList.getCodComp(), areaList.getDescripcion()});
            }
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar la grilla. " + ex.getMessage(),
                    "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardar() {
        Date fecha = new Date();
        if (this.txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al generar código para el Área",
                    "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
            this.txtCodigo.grabFocus();
        } else {
            if (this.txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una descripción para el Área.",
                        "Mantenimiento Tipo Comprobantes", JOptionPane.INFORMATION_MESSAGE);
                this.txtDescripcion.grabFocus();
            } else {
                // procede a la persistencia del registro.
                if (this.origen.equals("Nuevo")) {
                    if (validarId(this.txtCodigo.getText())) {
                        try {
                            st.beginTransaction();
                            MtTipoComprobantes comp = new MtTipoComprobantes();
                            comp.setCodComp(this.txtCodigo.getText());
                            comp.setDescripcion(this.txtDescripcion.getText());
                            comp.setAccionMod("Nuevo");
                            comp.setUsuarioMod(this.getUsuario());
                            comp.setFechaMod(fecha);

                            st.save(comp);
                            st.getTransaction().commit();
                            JOptionPane.showMessageDialog(null, "El regsitro fue agregado exitosamente.",
                                    "Mantenimiento Tipo Comprobantes", JOptionPane.INFORMATION_MESSAGE);
                            arranque();
                        } catch (HibernateException | HeadlessException ex) {
                            JOptionPane.showMessageDialog(null, "Error al guardar registro.\\n" + ex.getMessage(),
                                    "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El código del Área ya existe.",
                                "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
                        this.txtCodigo.grabFocus();
                    }
                } else {
                    // procede a la persistencia del registro.
                    try {
                        st.beginTransaction();
                        String desArea = this.txtDescripcion.getText();
                        String codArea = this.txtCodigo.getText();
                        
                        MtTipoComprobantes comp = (MtTipoComprobantes) st.load(MtTipoComprobantes.class, codArea);
                        
                        comp.setCodComp(codArea);
                        comp.setDescripcion(desArea);
                        comp.setAccionMod("Editar");
                        comp.setUsuarioMod(this.getUsuario());
                        comp.setFechaMod(fecha);
                        st.update(comp);
                        st.getTransaction().commit();
                        
                        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.",
                                "Mantenimiento Tipo Comprobantes", JOptionPane.INFORMATION_MESSAGE);
                        arranque();

                    } catch (HibernateException | HeadlessException ex) {
                        st.beginTransaction().rollback();
                        JOptionPane.showMessageDialog(null, "Error al guardar registro. " + ex.getMessage(),
                                "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        this.cmdEditar.setEnabled(true);
        this.cmdBorrar.setEnabled(true);
        this.txtDescripcion.setEditable(false);
        this.txtCodigo.setEditable(false);
        this.tabTipoComp.setEnabled(true);
    }

    private void seleccionarItem() {
        int selectedRow = this.tabTipoComp.getSelectedRow();
        Object codArea = model.getValueAt(selectedRow, 0);
        Object desArea = model.getValueAt(selectedRow, 1);
        this.txtDescripcion.setText(desArea.toString());
        this.txtCodigo.setText(codArea.toString());
    }

    public boolean validarId(String id) {
        boolean respuesta = false;
        try {
            MtTipoComprobantes consulta = (MtTipoComprobantes) st.get(MtTipoComprobantes.class, id);
            if (consulta == null) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio al validar el Codigo. " + ex.getMessage(),
                    "Mantenimiento Tipo Comprobantes", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }

    public void informe() {
        try {            
            st.beginTransaction();
            List<MtTipoComprobantes> lista = (List<MtTipoComprobantes>) st.createQuery("From MtTipoComprobantes").list();
            JasperReport report = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/Areas.jasper"));
            JasperPrint fillReport = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
            JasperViewer jviewer = new JasperViewer(fillReport, false);
            jviewer.setTitle("Lista de Áreas.");
            jviewer.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error cargando reporte." + e.getMessage());
        }
    }
}
