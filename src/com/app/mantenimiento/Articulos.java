package com.app.mantenimiento;

import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtCargos;
import com.entidades.MtMarcas;
import com.entidades.MtMonedas;
import com.entidades.MtTipoImpuestos;
import com.entidades.MtTiposArticulos;
import com.entidades.MtUnidMedidas;
import java.math.BigDecimal;
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
import util.AutoCompletarComboBox;
import util.RetornoCombos;

//@author Fausto Sanabria.

public class Articulos extends javax.swing.JDialog {
    public Articulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Artículos - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
    }
    
    public Articulos (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Artículos - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private String usuario;
    private String formulario;
    private final RetornoCombos combos = new RetornoCombos();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoArticulo = new javax.swing.JComboBox();
        cmbMarca = new javax.swing.JComboBox();
        txtId = new javax.swing.JTextField();
        txtArticulo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JFormattedTextField();
        cmbUnidadMedidaCompra = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbUnidadMedidaVenta = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbIVA = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbControlaStock = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cmbFraccionable = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setIconImages(null);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código");

        jLabel3.setText("Artículo");

        jLabel4.setText("Marca");

        cmbTipoArticulo.setEditable(true);

        cmbMarca.setEditable(true);

        txtId.setText("Id");

        jLabel9.setText("Tipo");

        jLabel10.setText("Unidad de medida compra");

        jLabel6.setText("Precio Compra");

        jLabel12.setText("Referencia");

        txtPrecioCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        cmbUnidadMedidaCompra.setEditable(true);
        cmbUnidadMedidaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Unidad de medida venta");

        cmbUnidadMedidaVenta.setEditable(true);
        cmbUnidadMedidaVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Precio Venta");

        txtPrecioVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel8.setText("IVA");

        jLabel5.setText("Controla Stock? ");

        cmbControlaStock.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));

        jLabel1.setText("Es fraccionable?");

        cmbFraccionable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N", " " }));
        cmbFraccionable.setSelectedIndex(1);
        cmbFraccionable.setToolTipText("El articulo podrá venderse por partes?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(10, 10, 10)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cmbUnidadMedidaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbUnidadMedidaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbControlaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbFraccionable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbUnidadMedidaCompra, cmbUnidadMedidaVenta});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(cmbTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbUnidadMedidaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbControlaStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cmbUnidadMedidaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(cmbFraccionable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Marca", "Referencia", "Tipo", "Moneda Compra", "Medida Compra", "Precio Compra", "Moneda Venta", "Medida Venta", "Precio Venta", "Controla?", "% IVA", "Fraccionable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        obtenerTabla();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if (!"".equals(accion)) {
            int seleccion = JOptionPane.showConfirmDialog(null, "Existen datos que aun no se han guardado. ¿Confirma que desea cerrar?." , 
                    "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Articulos dialog = new Articulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbControlaStock;
    private javax.swing.JComboBox cmbFraccionable;
    private javax.swing.JComboBox cmbIVA;
    private javax.swing.JComboBox cmbMarca;
    private javax.swing.JComboBox cmbTipoArticulo;
    private javax.swing.JComboBox cmbUnidadMedidaCompra;
    private javax.swing.JComboBox cmbUnidadMedidaVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtArticulo;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtPrecioCompra;
    private javax.swing.JFormattedTextField txtPrecioVenta;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables

    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";

        //Seteamos los campos editables por el usuario
        cargarComboTipoArt();
        cargarComboMarcas();
        cargarComboIva();
        cargarCombosMedidas();
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
        this.cmbUnidadMedidaCompra.setEnabled(false);
        this.cmbUnidadMedidaCompra.setSelectedItem(null);
        this.txtPrecioCompra.setEditable(false);
        this.txtPrecioCompra.setText("");          
        this.cmbUnidadMedidaVenta.setEnabled(false);
        this.cmbUnidadMedidaVenta.setSelectedItem(null);
        this.txtPrecioVenta.setEditable(false);
        this.txtPrecioVenta.setText("");
        this.cmbControlaStock.setEnabled(false);
        this.cmbControlaStock.setSelectedItem(null);
        this.cmbIVA.setEnabled(false);
        this.cmbIVA.setSelectedItem(null);        
        this.cmbFraccionable.setEnabled(false);
        this.cmbFraccionable.setSelectedItem(null);
        
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
        
        AutoCompletarComboBox comboMarca = new AutoCompletarComboBox(cmbMarca);
        AutoCompletarComboBox comboUniC = new AutoCompletarComboBox(cmbUnidadMedidaCompra);
        AutoCompletarComboBox comboUniV = new AutoCompletarComboBox(cmbUnidadMedidaVenta);
        AutoCompletarComboBox comboTipoA = new AutoCompletarComboBox(cmbTipoArticulo);
    }
    
    public void defaultTableModel(){
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);       // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);      // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);      // marca
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(190);      // referencia
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(170);      // tipo
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);      // moneda compra
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);      // unidad medida compra
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);      // precio compra
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);      // moneda venta
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(120);      // unidad medida venta
        this.jTable1.getColumnModel().getColumn(10).setPreferredWidth(120);     // precio venta
        this.jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);     // controla stock?
        this.jTable1.getColumnModel().getColumn(12).setPreferredWidth(70);     // % IVA
        this.jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);     // fraccionable
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    public void cargarTabla(){
        st.beginTransaction();
        List<MtArticulos> lista = (List<MtArticulos>)st
                .createQuery("From MtArticulos Order By codArticulo").list();
        for (MtArticulos unaLista : lista) {
            model.addRow(new Object[]{
                unaLista.getCodArticulo(), unaLista.getNomArticulo(), unaLista.getMtMarcas().getNomMarca(), unaLista.getReferencia(),
                unaLista.getMtTiposArticulos().getNomTipoArticulo(), unaLista.getMtMonedasByCodMonedaCompra().getNomMoneda(),
                unaLista.getMtUnidMedidasByUniMedidaCom().getDescUnidad(), unaLista.getPrecioCompra(), 
                unaLista.getMtMonedasByCodMonedaVenta().getNomMoneda(),
                unaLista.getMtUnidMedidasByUniMedidaVenta().getDescUnidad(), unaLista.getPrecioVenta(), unaLista.getControlStock(),
                unaLista.getImpuesto(), convertirBooleanAString(unaLista.getFraccionable())
            });
        }
    }
    
    public String convertirBooleanAString(Boolean estado){
        String retorno;
        if(estado){
            retorno = "S";
        } else {
            retorno = "N";
        }
        return retorno;
    }
    
    public void nuevo(){
        //Seteamos la accion
        accion = "Nuevo";
        
        //Los componentes editables
        //Primero lo primero, cargamos los combobox para después si habilitar.
        /*cargarComboTipoArt();
        cargarComboMarcas();
        cargarCombosMoneda();
        cargarCombosMedidas();*/
        this.cmbTipoArticulo.setEnabled(true);
        this.cmbMarca.setEnabled(true);
        this.cmbTipoArticulo.setSelectedIndex(-1);
        this.cmbMarca.setSelectedIndex(-1);
        this.txtId.setEditable(true);
        this.txtId.setText("");
        this.txtArticulo.setEditable(true);
        this.txtArticulo.setText("");        
        this.txtReferencia.setEditable(true);
        this.txtReferencia.setText("");          
        this.cmbUnidadMedidaCompra.setEnabled(true);
        this.cmbUnidadMedidaCompra.setSelectedItem(null);
        this.txtPrecioCompra.setEditable(true);
        this.txtPrecioCompra.setText("");          
        this.cmbUnidadMedidaVenta.setEnabled(true);
        this.cmbUnidadMedidaVenta.setSelectedItem(null);
        this.txtPrecioVenta.setEditable(true);
        this.txtPrecioVenta.setText("");
        this.cmbControlaStock.setEnabled(true);
        this.cmbControlaStock.setSelectedItem(null);
        this.cmbIVA.setEnabled(true);
        this.cmbIVA.setSelectedItem(null);            
        this.cmbFraccionable.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        
        //Inicializamos
        this.txtId.grabFocus();
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        
        //Los componentes editables
        //El cargo y el formulario son clave primaria, no los vamos a editar
        this.txtArticulo.setEditable(true);
        this.cmbMarca.setEnabled(true);
        this.txtReferencia.setEditable(true);
        this.cmbTipoArticulo.setEnabled(true);
        this.cmbUnidadMedidaCompra.setEnabled(true);
        this.txtPrecioCompra.setEditable(true);
        this.cmbUnidadMedidaVenta.setEnabled(true);
        this.txtPrecioVenta.setEditable(true);
        this.cmbControlaStock.setEnabled(true);
        this.cmbIVA.setEnabled(true);
        this.cmbFraccionable.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.jTable1.setEnabled(false);
        
        this.txtArticulo.grabFocus();
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
            String codArticulo = valorDeFila.toString();
            MtArticulos a = (MtArticulos) st.load(MtArticulos.class, codArticulo);
            st.delete(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro Eliminado...");
            arranque();
        }
    }
    
    public void cargarComboIva(){
        this.cmbIVA.removeAllItems();
        List<MtTipoImpuestos> lista = (List<MtTipoImpuestos>)st.createQuery("From MtTipoImpuestos").list();
        for(MtTipoImpuestos lista1 : lista){
            this.cmbIVA.addItem(String.valueOf(lista1.getPorcentaje().intValue()));
        }
    }
        
    public void cargarComboTipoArt(){
        this.cmbTipoArticulo.removeAllItems();
        List<MtTiposArticulos> lista = (List<MtTiposArticulos>)st.createQuery("From MtTiposArticulos").list();
        for(MtTiposArticulos cargoList : lista){
            this.cmbTipoArticulo.addItem(cargoList.getNomTipoArticulo());            
        }
    }
    
    public void cargarComboMarcas(){
        this.cmbMarca.removeAllItems();
        List<MtMarcas> lista = (List<MtMarcas>)st.createQuery("From MtMarcas").list();
        for(MtMarcas listaMarca : lista){
            this.cmbMarca.addItem(listaMarca.getNomMarca());            
        }
    }
    
    public void cargarCombosMedidas(){
        this.cmbUnidadMedidaCompra.removeAllItems();
        this.cmbUnidadMedidaVenta.removeAllItems();
        List<MtUnidMedidas> lista = (List<MtUnidMedidas>)st.createQuery("From MtUnidMedidas").list();
        for(MtUnidMedidas listaMedida : lista){
            this.cmbUnidadMedidaCompra.addItem(listaMedida.getDescUnidad());
            this.cmbUnidadMedidaVenta.addItem(listaMedida.getDescUnidad());
        }
    }   
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.txtId.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.txtArticulo.grabFocus();
               }
               else {
                   arranque();
               }
               break;
       }
    }

    public void guardar(){
        if(this.cmbTipoArticulo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de articulo.");
        }
        else if(this.cmbControlaStock.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar controla stock");
        }
        else if(this.cmbMarca.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el formulario.");
        }
        else if(this.cmbUnidadMedidaCompra .getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida compra.");
        }
        else if(this.cmbUnidadMedidaVenta .getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida venta.");
        }
        else if(this.cmbIVA .getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de IVA.");
        }        
        else if(this.txtId.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto.");
        }
        else if(this.txtArticulo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del articulo");
        }
        else if(this.txtReferencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar la referencia");
        }
        else if(this.txtPrecioCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de compra");
        }
        else if(this.txtPrecioVenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de venta");
        }
        else{
            st.beginTransaction();
            Object marca = this.cmbMarca.getSelectedItem();
            MtMarcas codigoMarca = retornoMarcaPorDescripcion(marca.toString());

            Object tipoArt = this.cmbTipoArticulo.getSelectedItem();
            MtTiposArticulos codigoTipoArticulo = retornoTipoPorDescripcion(tipoArt.toString());
            
            MtMonedas codMonedaCo = retornoMonedaPorDescripcion("Guaraní");
            
            Object codUniC = this.cmbUnidadMedidaCompra.getSelectedItem();
            MtUnidMedidas codUniCo = retornoUnidMedidaPorDescripcion(codUniC.toString());
            
            Object codUniV = this.cmbUnidadMedidaVenta.getSelectedItem();
            MtUnidMedidas codUniVe = retornoUnidMedidaPorDescripcion(codUniV.toString());    
            
            MtArticulos a = new MtArticulos();
            a.setCodArticulo(this.txtId.getText().toUpperCase());
            a.setNomArticulo(this.txtArticulo.getText());
            a.setMtMarcas(codigoMarca);
            a.setReferencia(this.txtReferencia.getText());
            a.setMtTiposArticulos(codigoTipoArticulo);
            a.setMtMonedasByCodMonedaCompra(codMonedaCo);
            a.setMtMonedasByCodMonedaVenta(codMonedaCo);
            a.setMtUnidMedidasByUniMedidaCom(codUniCo);
            a.setMtUnidMedidasByUniMedidaVenta(codUniVe);
            a.setPrecioCompra(BigDecimal.valueOf(Double.parseDouble(this.txtPrecioCompra.getText())));
            a.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(this.txtPrecioVenta.getText())));
            a.setControlStock(this.cmbControlaStock.getSelectedItem().toString().charAt(0));
            a.setImpuesto(Integer.parseInt(this.cmbIVA.getSelectedItem().toString()));
            a.setFraccionable("S".equalsIgnoreCase(this.cmbFraccionable.getSelectedItem().toString()));
            a.setEsMateriaPrima('P');
            a.setCantDiasVenc(0);
            
            a.setAccionMod(accion);
            a.setUsuarioMod(usuario);
            Calendar cal = Calendar.getInstance();
            a.setFechaMod(cal.getTime() );
            
            try {
                st.save(a);
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                arranque();                
            }
            catch(org.hibernate.NonUniqueObjectException e){
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n" +
                            "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarEd(){
        if(this.cmbTipoArticulo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de articulo.");
        }
        else if(this.cmbControlaStock.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar controla stock");
        }
        else if(this.cmbMarca.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el formulario.");
        }
        else if(this.cmbUnidadMedidaCompra .getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida compra.");
        }
        else if(this.cmbUnidadMedidaVenta .getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar la unidad de medida venta.");
        }
        else if(this.txtId.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del producto.");
        }
        else if(this.txtArticulo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del articulo");
        }
        else if(this.txtReferencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar la referencia");
        }
        else if(this.txtPrecioCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de compra");
        }
        else if(this.txtPrecioVenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de venta");
        }
        else{
            st.beginTransaction();
            int filaSeleccionada = this.jTable1.getSelectedRow();
            Object valorDeFila = model.getValueAt(filaSeleccionada, 0);
            String codArticulo = valorDeFila.toString();
            MtArticulos a = (MtArticulos) st.load(MtArticulos.class, codArticulo);
            
            Object marca = this.cmbMarca.getSelectedItem();
            MtMarcas codigoMarca = retornoMarcaPorDescripcion(marca.toString());
            Object tipoArt = this.cmbTipoArticulo.getSelectedItem();
            MtTiposArticulos codigoTipoArticulo = retornoTipoPorDescripcion(tipoArt.toString());
            MtMonedas codMonedaCo = retornoMonedaPorDescripcion("Guaraní");
            Object codUniC = this.cmbUnidadMedidaCompra.getSelectedItem();
            MtUnidMedidas codUniCo = retornoUnidMedidaPorDescripcion(codUniC.toString());
            Object codUniV = this.cmbUnidadMedidaVenta.getSelectedItem();
            MtUnidMedidas codUniVe = retornoUnidMedidaPorDescripcion(codUniV.toString());   
            
            a.setNomArticulo(this.txtArticulo.getText());
            a.setMtMarcas(codigoMarca);
            a.setReferencia(this.txtReferencia.getText());
            a.setMtTiposArticulos(codigoTipoArticulo);
            a.setMtMonedasByCodMonedaCompra(codMonedaCo);
            a.setMtMonedasByCodMonedaVenta(codMonedaCo);
            a.setMtUnidMedidasByUniMedidaCom(codUniCo);
            a.setMtUnidMedidasByUniMedidaVenta(codUniVe);
            a.setPrecioCompra(BigDecimal.valueOf(Double.parseDouble(this.txtPrecioCompra.getText())));
            a.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(this.txtPrecioVenta.getText())));
            a.setControlStock(this.cmbControlaStock.getSelectedItem().toString().charAt(0));
            a.setImpuesto(Integer.parseInt(this.cmbIVA.getSelectedItem().toString()));
            a.setFraccionable("S".equalsIgnoreCase(this.cmbFraccionable.getSelectedItem().toString()));
            a.setEsMateriaPrima('P');
            a.setCantDiasVenc(0);
            
            a.setAccionMod(accion);
            a.setUsuarioMod(usuario);
            Calendar cal = Calendar.getInstance();
            a.setFechaMod(cal.getTime() );
            
            st.update(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro actualizado.");
            arranque();
        }
    }
    
    public MtTiposArticulos retornoTipoPorDescripcion(String descripcion){
        MtTiposArticulos tipRet = null;
        try {
            Query query = st.createQuery("From MtTiposArticulos c Where c.nomTipoArticulo = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtTiposArticulos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + descripcion);
            }

        } catch (Exception e) {
        }
        return tipRet;
    }
    
    public MtMarcas retornoMarcaPorDescripcion(String descripcion){
        MtMarcas tipRet = null;
        try {
            Query query = st.createQuery("From MtMarcas c Where c.nomMarca = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtMarcas)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + descripcion);
            }
        } catch (Exception e) {

        }
        return tipRet;
    }
    
    public MtMonedas retornoMonedaPorDescripcion(String descripcion){
        MtMonedas tipRet = null;
        try {
            Query query = st.createQuery("From MtMonedas c Where c.nomMoneda = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtMonedas)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + descripcion);
            }

        } catch (Exception e) {

        }
        return tipRet;
    }
    
    public MtUnidMedidas retornoUnidMedidaPorDescripcion(String descripcion){
        MtUnidMedidas tipRet = null;
        try {
            Query query = st.createQuery("From MtUnidMedidas c Where c.descUnidad = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtUnidMedidas)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + descripcion);
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
        
        int filaSeleccionada = this.jTable1.getSelectedRow();
        
        Object marca = model.getValueAt(filaSeleccionada, 2);
        Object tipo = model.getValueAt(filaSeleccionada, 4);
        Object monedaCom = model.getValueAt(filaSeleccionada, 5);
        Object medidaCom = model.getValueAt(filaSeleccionada, 6);
        Object precioCom = model.getValueAt(filaSeleccionada, 7);
        Object medidaVen = model.getValueAt(filaSeleccionada, 9);
        Object precioVen = model.getValueAt(filaSeleccionada, 10);
        Object controla = model.getValueAt(filaSeleccionada, 11);   
        Object iva = model.getValueAt(filaSeleccionada, 12);
        Object franccionable = model.getValueAt(filaSeleccionada, 13);

        this.txtId.setText(model.getValueAt(filaSeleccionada, 0).toString());
        this.txtArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
        this.cmbMarca.setSelectedItem(marca.toString());
        this.txtReferencia.setText(model.getValueAt(filaSeleccionada, 3).toString());
        this.cmbTipoArticulo.setSelectedItem(tipo.toString());
        this.cmbUnidadMedidaCompra.setSelectedItem(medidaCom.toString());
        this.txtPrecioCompra.setText(precioCom.toString());
        this.cmbUnidadMedidaVenta.setSelectedItem(medidaVen.toString());
        this.txtPrecioVenta.setText(precioVen.toString());
        this.cmbControlaStock.setSelectedItem(controla.toString());
        this.cmbIVA.setSelectedItem(iva.toString());
        this.cmbFraccionable.setSelectedItem(franccionable.toString());
        
        this.btnEditar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/ArticulosQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, null, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Listado de países.");
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