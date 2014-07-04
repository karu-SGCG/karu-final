package com.app.mantenimiento;
import com.app.seguridad.Permisos;
import com.entidades.MtCargos;
import com.entidades.MtEmpleados;
import com.entidades.MtPaises;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class Empleados extends javax.swing.JDialog {
    public Empleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Empleados - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
    }
    
    public Empleados(String user) {
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Empleados - KARU v1.0");
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
        cmbCargo = new javax.swing.JComboBox();
        cmbPaises = new javax.swing.JComboBox();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNroDocum = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JFormattedTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFecIngreso = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaCese = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código");

        jLabel3.setText("Nombre(s)");

        jLabel4.setText("Apellido(s)");

        jLabel5.setText("Pais de Nacimiento");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Fecha Nac.");

        txtId.setText("Id");

        jLabel8.setText("Nro. Documento");

        try {
            txtFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Cargo");

        try {
            txtFecIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("Fecha de Ingreso");

        try {
            txtFechaCese.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Fecha de Cese");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNroDocum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(97, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPaises, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtFecIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, txtId});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFecIngreso, txtFechaCese});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroDocum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Empleados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nro.Doc.", "Nombre", "Apellido", "Fecha Nac.", "Pais", "Teléfono", "Cargo", "Ingreso", "Cese"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addContainerGap(681, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(69, 69, 69))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(462, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados dialog = new Empleados(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbCargo;
    private javax.swing.JComboBox cmbPaises;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtFecIngreso;
    private javax.swing.JFormattedTextField txtFechaCese;
    private javax.swing.JFormattedTextField txtFechaNac;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroDocum;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
                        
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String user) {
        this.usuario = user;
    }
    public void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";
        
        //Seteamos los campos editables por el usuario
        this.txtId.setEnabled(false);
        this.txtNroDocum.setEditable(false);
        this.txtNombres.setEnabled(false);
        this.txtApellidos.setEnabled(false);
        this.txtFechaNac.setEnabled(false);
        this.cmbPaises.setEnabled(false);
        this.cmbPaises.setSelectedItem(null);
        this.txtTelefono.setEnabled(false);
        this.cmbCargo.setEnabled(false);
        this.cmbCargo.setSelectedItem(null);
        this.txtFecIngreso.setEnabled(false);
        this.txtFechaCese.setEnabled(false);
        
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
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(25);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(25);
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(25);
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    public void cargarTabla(){
        st.beginTransaction();
        List<MtEmpleados> lista = (List<MtEmpleados>)st
                .createQuery("From MtEmpleados Order By codEmpleado").list();
        for (MtEmpleados emple : lista) {
            model.addRow(new Object[]{
                emple.getCodEmpleado(), emple.getNroDocumento(), 
                emple.getNombres(), emple.getApellidos(),
                fechaStringDate(emple.getFechaNac()), emple.getMtPaises().getNomPais(),
                emple.getTelefono(), emple.getMtCargos().getNomCargo(),
                fechaStringDate(emple.getFechaIngreso()), fechaStringDate(emple.getFechaCese())
            });
        }
    }
    
    public void nuevo(){
        //Seteamos la accion
        accion = "Nuevo";
        
        //Los componentes editables
        //Primero lo primero, cargamos los combobox para después si habilitar.
        cargarComboCargos();
        cargarComboPaises();
        this.cmbCargo.setEnabled(true);
        this.cmbPaises.setEnabled(true);
        this.cmbCargo.setSelectedIndex(-1);
        this.cmbPaises.setSelectedIndex(-1);
        this.txtId.setEnabled(false);
        this.txtNroDocum.setEditable(true);
        this.txtNombres.setEnabled(true);
        this.txtApellidos.setEnabled(true);
        this.txtFechaNac.setEnabled(true);
        this.txtTelefono.setEnabled(true);
        this.txtFecIngreso.setEnabled(true);
        this.txtFechaCese.setEnabled(true);
        this.txtNroDocum.setText(null);
        this.txtNombres.setText(null);
        this.txtApellidos.setText(null);
        this.txtFechaNac.setText(null);
        this.txtTelefono.setText(null);
        this.txtFecIngreso.setText(null);
        this.txtFechaCese.setText(null);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        
        //Inicializamos
        String nuevo;
        nuevo = obtenerID();
        this.txtId.setText(nuevo);
        this.txtNroDocum.grabFocus();
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        
        //Los componentes editables
        //El cargo y el formulario son clave primaria, no los vamos a editar
        this.txtId.setEnabled(false);
        this.txtNroDocum.setEnabled(true);
        this.txtNombres.setEnabled(true);
        this.txtApellidos.setEnabled(true);
        this.txtFechaNac.setEnabled(true);
        this.cmbPaises.setEnabled(true);
        this.txtTelefono.setEnabled(true);
        this.cmbCargo.setEnabled(true);
        this.txtFecIngreso.setEnabled(true);
        this.txtFechaCese.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.jTable1.setEnabled(false);
        
        this.txtNroDocum.grabFocus();
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showConfirmDialog(null,"Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        if(seleccion == 1){//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        }
        else{//Opción eliminar seleccionada
            st.beginTransaction();
            int filaSeleccionada = this.jTable1.getSelectedRow();
            Object valorDeFila = model.getValueAt(filaSeleccionada, 0);
            int idEmpleado = Integer.parseInt( valorDeFila.toString() );
            MtEmpleados a = (MtEmpleados) st.load(MtEmpleados.class, idEmpleado);
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
    
    public void cargarComboPaises(){
        this.cmbPaises.removeAllItems();
        List<MtPaises> lista = (List<MtPaises>)st.createQuery("From MtPaises").list();
        for(MtPaises listaPaises : lista){
            this.cmbPaises.addItem(listaPaises.getNomPais());            
        }
    }
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.txtNroDocum.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.txtNroDocum.grabFocus();
               }
               else {
                   arranque();
               }
               break;
       }
    }
    
    private String obtenerID(){
        Integer newId;
        String retorno;
        retorno = null;
        try {
            String sql = "SELECT MAX(codEmpleado) FROM MtEmpleados";
            Query consulta = st.createQuery(sql);
            Object elMax = consulta.uniqueResult();
            if (elMax == null){
                newId = 1;
            }
            else {
                newId = Integer.parseInt(elMax.toString());
                newId = newId + 1;
            }
            retorno = String.valueOf(newId);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e.getMessage());
            e.getStackTrace();
        }
        return retorno;
    }

    public void guardar(){
        if(this.cmbCargo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el cargo.");
        }
        else if(this.cmbPaises.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el formulario.");
        }
        else if(this.txtId.getText().isEmpty() || this.txtNroDocum.getText().isEmpty() ||
                this.txtNombres.getText().isEmpty() || this.txtApellidos.getText().isEmpty() ||
                this.txtFechaNac.getText().isEmpty() || this.txtFecIngreso.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Existen campos obligatorios sin cargar.");
        }
        else{
            st.beginTransaction();
            Object pais = this.cmbPaises.getSelectedItem();
            MtPaises codigoPais = retornoPaisPorDescripcion(pais.toString());

            Object cargo = this.cmbCargo.getSelectedItem();
            MtCargos codigoCargo = retornoCargoPorDescripcion(cargo.toString());
            
            MtEmpleados a = new MtEmpleados();
            a.setCodEmpleado(Integer.parseInt(this.txtId.getText()));
            a.setNroDocumento(this.txtNroDocum.getText());
            a.setNombres(this.txtNombres.getText());
            a.setApellidos(this.txtApellidos.getText());
            if (!"  /  /    ".equals(this.txtFechaNac.getText())){
                a.setFechaNac( fechaCalendar(this.txtFechaNac.getText()).getTime() );
            } else {
                a.setFechaNac(null);
            }         
            a.setMtPaises(codigoPais);
            a.setTelefono(this.txtTelefono.getText());
            a.setMtCargos(codigoCargo);
            if (!"  /  /    ".equals(this.txtFecIngreso.getText())){
                a.setFechaIngreso( fechaCalendar(this.txtFecIngreso.getText()).getTime() );
            } else {
                a.setFechaIngreso(null);
            }
            if (!"  /  /    ".equals(this.txtFechaCese.getText())){
                a.setFechaCese( fechaCalendar(this.txtFechaCese.getText()).getTime() );
            } else {
                a.setFechaCese(null);
            }
            
            a.setAccionMod(accion);
            a.setUsuarioMod(this.getUsuario());
            Calendar cal = Calendar.getInstance();
            a.setFechaMod(cal.getTime() );
            
            st.save(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            arranque();
        }
    }
    
    private void guardarEd(){
                if(this.cmbCargo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el cargo.");
        }
        else if(this.cmbPaises.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el formulario.");
        }
        else{
            st.beginTransaction();
            int filaSeleccionada = this.jTable1.getSelectedRow();
            Object valorDeFila = model.getValueAt(filaSeleccionada, 0);
            int idEmpleado = Integer.parseInt( valorDeFila.toString() );
            MtEmpleados a = (MtEmpleados) st.load(MtEmpleados.class, idEmpleado);
            
            Object pais = this.cmbPaises.getSelectedItem();
            MtPaises codigoPais = retornoPaisPorDescripcion(pais.toString());

            Object cargo = this.cmbCargo.getSelectedItem();
            MtCargos codigoCargo = retornoCargoPorDescripcion(cargo.toString());
            
            a.setNroDocumento(this.txtNroDocum.getText());
            a.setNombres(this.txtNombres.getText());
            a.setApellidos(this.txtApellidos.getText());
            if (!"  /  /    ".equals(this.txtFechaNac.getText())){
                a.setFechaNac( fechaCalendar(this.txtFechaNac.getText()).getTime() );
            } else {
                a.setFechaNac(null);
            }         
            a.setMtPaises(codigoPais);
            a.setTelefono(this.txtTelefono.getText());
            a.setMtCargos(codigoCargo);
            if (!"  /  /    ".equals(this.txtFecIngreso.getText())){
                a.setFechaIngreso( fechaCalendar(this.txtFecIngreso.getText()).getTime() );
            } else {
                a.setFechaIngreso(null);
            }
            if (!"  /  /    ".equals(this.txtFechaCese.getText())){
                a.setFechaCese( fechaCalendar(this.txtFechaCese.getText()).getTime() );
            } else {
                a.setFechaCese(null);
            }
            
            a.setAccionMod(accion);
            a.setUsuarioMod(this.getUsuario());
            Calendar cal = Calendar.getInstance();
            a.setFechaMod(cal.getTime() );
            st.update(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro actualizado.");
            arranque();
        }
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
    
    public MtPaises retornoPaisPorDescripcion(String nomPais){
        MtPaises tipRet = null;
        try {
            Query query = st.createQuery("From MtPaises c Where c.nomPais = ?");
            query.setParameter(0, nomPais);
            try {
                tipRet = (MtPaises)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + nomPais);
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
    
    private Calendar fechaCalendar(String fecha){
        //A este método le pasamo como parámetro un String con formato fecha específico
        //y la convierte en objeto Calendar.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Obtenemos una instancia del objeto Calendar.
        Calendar cal = Calendar.getInstance();
        //Utilizamos un try para controlar entrada de datos erroneos.
        try {
            //Hacemos la conversión con este procedimiento.
            cal.setTime(sdf.parse(fecha));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return cal;
    }
    
    private String fechaString(Calendar fecha){
        //A este método le pasamos un objeto Calendar y la convierte en un String de fecha.
        String retorno = null;
        //Utilizamos SimpleDateFormat para establecer el formato de la fecha.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Si fecha está vacío retornará null.
        if(fecha != null){
            //Este proceso permite convertir el Objeto Calendar en un formato de fecha útil.
            retorno = sdf.format(fecha.getTime());
        }    
        return retorno;
    }
    
    private String fechaStringDate(Date fecha){
        //A este método le pasamos un objeto Calendar y la convierte en un String de fecha.
        String retorno = null;
        //Utilizamos SimpleDateFormat para establecer el formato de la fecha.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Si fecha está vacío retornará null.
        if(fecha != null){
            //Este proceso permite convertir el Objeto Calendar en un formato de fecha útil.
            retorno = sdf.format(fecha);
        }    
        return retorno;
    }    
    
    public void obtenerTabla(){
        cargarComboCargos();
        cargarComboPaises();
        int filaSeleccionada = this.jTable1.getSelectedRow();
        Object idEmpleado = model.getValueAt(filaSeleccionada, 0);
        Object nroDocum = model.getValueAt(filaSeleccionada, 1);
        Object nombre = model.getValueAt(filaSeleccionada, 2);
        Object apellido = model.getValueAt(filaSeleccionada, 3);
        Object fechaNac = model.getValueAt(filaSeleccionada, 4);
        Object pais = model.getValueAt(filaSeleccionada, 5);
        Object telefono = model.getValueAt(filaSeleccionada, 6);
        Object cargo = model.getValueAt(filaSeleccionada, 7);
        Object fecIngreso = model.getValueAt(filaSeleccionada, 8);
        Object fecCese = model.getValueAt(filaSeleccionada, 9);

        this.txtId.setText(idEmpleado.toString());
        this.txtNroDocum.setText(nroDocum.toString());
        this.txtNombres.setText(nombre.toString());
        this.txtApellidos.setText(apellido.toString());
        if (fechaNac != null){
            this.txtFechaNac.setText(fechaNac.toString());
        }
        this.cmbPaises.setSelectedItem(pais.toString());
        this.txtTelefono.setText(telefono.toString());
        this.cmbCargo.setSelectedItem(cargo.toString());
        if (fecIngreso != null){
            this.txtFecIngreso.setText(fecIngreso.toString());
        }
        if (fecCese != null ){
            this.txtFechaCese.setText(fecCese.toString());
        }

        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/EmpleadosQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, null, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Listado de Empleados.");
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