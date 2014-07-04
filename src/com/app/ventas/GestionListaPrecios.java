package com.app.ventas;

import com.app.mantenimiento.Articulos;
import com.entidades.CambioPreciosCab;
import com.entidades.CambioPreciosDet;
import com.entidades.CambioPreciosDetId;
import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtMarcas;
import com.entidades.MtProveedores;
import com.entidades.MtTiposArticulos;
import com.entidades.MtUsuarios;
import com.entidades.OrdCompraDet;
import com.entidades.OrdCompraDetId;
import com.entidades.OrdenCompra;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;
import util.Busqueda;
import util.Cargar;
import util.UtilidadesCalendario;

//@author Fausto Sanabria.

public class GestionListaPrecios extends javax.swing.JDialog {
    public GestionListaPrecios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Gestión de Lista de Precios - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();   
    }
    
    public GestionListaPrecios (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Gestión de Lista de Precios - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private final String usuario;
    private final String formulario;
    private int var, idArti, filaSeleccionada, posicion; //Variables de clase auxiliares necesarias.
    private boolean deboBuscarArticulo = true;
    private MtProveedores proveedor;
    private MtArticulos articulo;
    private List<Object> ArrayPrimaryKey;
    private ArrayList<OrdCompraDetId> articulosBorrados;
    private int cant_lineas;
    private MtUsuarios objUsuario;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroTrans = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        txtCodMarca = new javax.swing.JTextField();
        txtNomMarca = new javax.swing.JTextField();
        txtCodTipo = new javax.swing.JTextField();
        txtNomTipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        rdoPorcentaje = new javax.swing.JRadioButton();
        rdoFijo = new javax.swing.JRadioButton();
        txtPorcAjuste = new javax.swing.JFormattedTextField();
        txtIncrementoFijo = new javax.swing.JFormattedTextField();
        btnCalcular = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodArticulo = new javax.swing.JTextField();
        txtDescArticulo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioVentaA = new javax.swing.JFormattedTextField();
        txtPrecioVentaN = new javax.swing.JFormattedTextField();
        txtVariacion = new javax.swing.JFormattedTextField();
        txtPrecioCompra = new javax.swing.JFormattedTextField();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblInfoPie = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtNomUsuario = new javax.swing.JTextField();
        txtFechaMod = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setIconImages(null);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Número");

        jLabel3.setText("Fecha Cambio");

        txtNroTrans.setBackground(new java.awt.Color(255, 255, 204));
        txtNroTrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroTransKeyTyped(evt);
            }
        });

        jLabel12.setText("Marca");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtFecha.setToolTipText("Fecha en formato dd/mm/aaaa");

        txtCodMarca.setToolTipText("Marca. F9 para buscar o dejar vacío");
        txtCodMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodMarcaFocusLost(evt);
            }
        });
        txtCodMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodMarcaKeyReleased(evt);
            }
        });

        txtNomMarca.setEditable(false);
        txtNomMarca.setBackground(new java.awt.Color(204, 255, 204));
        txtNomMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomMarca.setFocusable(false);

        txtCodTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodTipoFocusLost(evt);
            }
        });
        txtCodTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodTipoKeyReleased(evt);
            }
        });

        txtNomTipo.setEditable(false);
        txtNomTipo.setBackground(new java.awt.Color(204, 255, 204));
        txtNomTipo.setFocusable(false);

        jLabel8.setText("Tipo");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        grupoModo.add(rdoPorcentaje);
        rdoPorcentaje.setSelected(true);
        rdoPorcentaje.setText("Porcentaje Variacion");
        rdoPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdoPorcentajeStateChanged(evt);
            }
        });

        grupoModo.add(rdoFijo);
        rdoFijo.setText("Incremento Fijo");

        txtPorcAjuste.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPorcAjuste.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcAjusteFocusLost(evt);
            }
        });

        txtIncrementoFijo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rdoFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdoPorcentaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPorcAjuste, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(txtIncrementoFijo))
                        .addGap(5, 5, 5)
                        .addComponent(btnCalcular)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNroTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoPorcentaje)
                    .addComponent(txtPorcAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIncrementoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoFijo)
                    .addComponent(btnCalcular))
                .addGap(0, 3, Short.MAX_VALUE))
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

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Search.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInforme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Precio Compra", "PrecioVentaA", "PrecioVentaN", "Variacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Artículo");

        jLabel5.setText("Precio Compra");

        jLabel6.setText("P. Venta Anterior");

        jLabel7.setText("P. Venta Nuevo");

        jLabel14.setText("Variacion");

        txtCodArticulo.setEditable(false);
        txtCodArticulo.setToolTipText("Código de artículo. F9 para buscar");
        txtCodArticulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodArticuloFocusLost(evt);
            }
        });
        txtCodArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodArticuloKeyReleased(evt);
            }
        });

        txtDescArticulo.setEditable(false);
        txtDescArticulo.setBackground(new java.awt.Color(255, 255, 255));
        txtDescArticulo.setFocusable(false);

        jLabel16.setText("Descripcion");

        txtPrecioVentaA.setEditable(false);
        txtPrecioVentaA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecioVentaA.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioVentaA.setFocusable(false);
        txtPrecioVentaA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioVentaAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaAFocusLost(evt);
            }
        });
        txtPrecioVentaA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaAKeyTyped(evt);
            }
        });

        txtPrecioVentaN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecioVentaN.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioVentaN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaNFocusLost(evt);
            }
        });

        txtVariacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtVariacion.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtVariacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVariacionFocusLost(evt);
            }
        });

        txtPrecioCompra.setEditable(false);
        txtPrecioCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioCompra.setFocusable(false);
        txtPrecioCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioCompraFocusLost(evt);
            }
        });
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/quitar.png"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioVentaA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecioVentaN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtVariacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioVentaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioVentaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVariacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/primero.png"))); // NOI18N
        btnPrimero.setMaximumSize(new java.awt.Dimension(24, 24));
        btnPrimero.setMinimumSize(new java.awt.Dimension(24, 24));
        btnPrimero.setPreferredSize(new java.awt.Dimension(24, 24));
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/ANTERIOR.png"))); // NOI18N
        btnAnterior.setMaximumSize(new java.awt.Dimension(24, 24));
        btnAnterior.setMinimumSize(new java.awt.Dimension(24, 24));
        btnAnterior.setPreferredSize(new java.awt.Dimension(24, 24));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/SIGUIENTE.png"))); // NOI18N
        btnSiguiente.setMaximumSize(new java.awt.Dimension(24, 24));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(24, 24));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(24, 24));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/ULTIMO.png"))); // NOI18N
        btnUltimo.setMaximumSize(new java.awt.Dimension(24, 24));
        btnUltimo.setMinimumSize(new java.awt.Dimension(24, 24));
        btnUltimo.setPreferredSize(new java.awt.Dimension(24, 24));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblInfoPie.setText("Karu");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(40, 40, 40))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar)
                    .addComponent(lblInfoPie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(204, 255, 204));

        txtNomUsuario.setEditable(false);
        txtNomUsuario.setBackground(new java.awt.Color(204, 255, 204));

        txtFechaMod.setEditable(false);
        txtFechaMod.setBackground(new java.awt.Color(204, 255, 204));
        txtFechaMod.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss"))));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        anexarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCodArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArticuloKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            deboBuscarArticulo = false;
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigoArt;
                Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de articulos", "mt_articulos",
                        "cod_articulo", "nom_articulo");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigoArt = formBusqueda.getCodigo();
                if (codigoArt != null) {
                    this.txtCodArticulo.setText(codigoArt);
                }
            }
            deboBuscarArticulo = true;
        }
    }//GEN-LAST:event_txtCodArticuloKeyReleased

    private void txtCodMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMarcaKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigo;
                Busqueda formBusqueda = new Busqueda(this, true, "Marcas", "mt_marcas", "cod_marca", "nom_marca");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigo = formBusqueda.getCodigo();
                if (codigo != null) {
                    this.txtCodMarca.setText(codigo);
                    this.txtCodMarca.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    this.txtCodMarca.transferFocus();
            }
        }
    }//GEN-LAST:event_txtCodMarcaKeyReleased

    private void txtCodMarcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMarcaFocusLost
        if (!this.txtCodMarca.getText().isEmpty()) {
            recuperarMarca(this.txtCodMarca.getText());
        } else {
            this.txtNomMarca.setText("");
        }
    }//GEN-LAST:event_txtCodMarcaFocusLost

    private void txtCodArticuloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArticuloFocusLost
        if (deboBuscarArticulo && !this.txtCodArticulo.getText().isEmpty()) {
            if (this.articulo == null) {
                if (recuperarArticulo(this.txtCodArticulo.getText())) {
                    this.txtDescArticulo.setText(articulo.getNomArticulo());
                    this.txtPrecioCompra.setValue(articulo.getPrecioCompra());
                    this.txtPrecioVentaA.setValue(articulo.getPrecioVenta());
                } else {
                    JOptionPane.showMessageDialog(this, "No existe el código del producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (!articulo.getCodArticulo().equalsIgnoreCase(this.txtCodArticulo.getText())) {
                if (recuperarArticulo(this.txtCodArticulo.getText())) {
                    this.txtDescArticulo.setText(articulo.getNomArticulo());
                    this.txtPrecioCompra.setValue(articulo.getPrecioCompra());
                    this.txtPrecioVentaA.setValue(articulo.getPrecioVenta());
                } else {
                    JOptionPane.showMessageDialog(this, "No existe el código del producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
        }
    }//GEN-LAST:event_txtCodArticuloFocusLost

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Desea eliminar la fila seleccionada?", "Corfirmacion",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirma == 0) {
            if ("Editar".equalsIgnoreCase(accion)) {
                System.out.println("fila: " + filaSeleccionada);
                System.out.println("nro_orden: " + Integer.parseInt(this.txtNroTrans.getText()));
                OrdCompraDetId idLineaEliminada = new OrdCompraDetId(Integer.parseInt(this.txtNroTrans.getText()), filaSeleccionada);
                System.out.println("objeto: " + idLineaEliminada.getNroOcompra() + "--" + idLineaEliminada.getLinea());
                articulosBorrados.add(idLineaEliminada);
            }
            model.removeRow(filaSeleccionada);
            limpiarArticulos();
            this.txtCodArticulo.setEditable(true);
            this.txtCodArticulo.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNroTransKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroTransKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroTransKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!accion.equalsIgnoreCase("Buscar")) {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png")));
            arranque();
            this.accion = "Buscar";
            this.txtCodMarca.setEditable(true);
            this.txtCodTipo.setEditable(true);
            this.txtNroTrans.setEditable(true);
            this.txtNroTrans.requestFocus();
            this.btnCancelar.setEnabled(true);
        } else {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Search.png")));
            this.accion = "";
            this.btnCancelar.setEnabled(false);
            buscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        primero();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void txtPrecioVentaAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaAFocusLost
        try {
            this.txtPrecioVentaA.commitEdit();
            calcularLinea();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El precio ingresado no es correcto", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtPrecioVentaA.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioVentaAFocusLost

    private void txtPrecioCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraFocusLost
        try {
            this.txtPrecioCompra.commitEdit();
            calcularLinea();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error en la cantidad ingresada. ", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtPrecioCompra.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioCompraFocusLost

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9')) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtPrecioCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraFocusGained
        this.txtPrecioCompra.selectAll();
    }//GEN-LAST:event_txtPrecioCompraFocusGained

    private void txtPrecioVentaAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaAFocusGained
            this.txtPrecioVentaA.selectAll();
    }//GEN-LAST:event_txtPrecioVentaAFocusGained

    private void txtPrecioVentaAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaAKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == ',') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaAKeyTyped

    private void rdoPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdoPorcentajeStateChanged
        if (this.rdoPorcentaje.isSelected()) {
            this.txtIncrementoFijo.setValue(null);
            this.txtIncrementoFijo.setEnabled(false);
            this.txtPorcAjuste.setEnabled(true);
            this.txtPorcAjuste.requestFocus();
            try{
                this.txtIncrementoFijo.commitEdit();
            } catch(ParseException e){
            }
        } else {
            this.txtPorcAjuste.setValue(null);
            this.txtPorcAjuste.setEnabled(false);
            this.txtIncrementoFijo.setEnabled(true);
            this.txtIncrementoFijo.requestFocus();
            try{
                this.txtPorcAjuste.commitEdit();
            } catch(ParseException e){
            }
        }
    }//GEN-LAST:event_rdoPorcentajeStateChanged

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        recuperarArticulosFiltro();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void txtCodTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTipoKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigo;
                Busqueda formBusqueda = new Busqueda(this, true, "Tipos de Articulos", "mt_tipos_articulos", "cod_tipo_articulo", "nom_tipo_articulo");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigo = formBusqueda.getCodigo();
                if (codigo != null) {
                    this.txtCodTipo.setText(codigo);
                    this.txtCodTipo.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    this.txtCodTipo.transferFocus();
            }
        }
    }//GEN-LAST:event_txtCodTipoKeyReleased

    private void txtCodTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodTipoFocusLost
        if (!this.txtCodTipo.getText().isEmpty()) {
            recuperarTipo(this.txtCodTipo.getText());
        } else {
            this.txtNomTipo.setText("");
        }
    }//GEN-LAST:event_txtCodTipoFocusLost

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        calcularPrecios();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtPorcAjusteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcAjusteFocusLost
        if(this.rdoPorcentaje.isSelected()){
            try{
                this.txtPorcAjuste.commitEdit();
            } catch(ParseException e){
            }
        }
    }//GEN-LAST:event_txtPorcAjusteFocusLost

    private void txtPrecioVentaNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaNFocusLost
        if (!this.txtPrecioVentaN.getText().isEmpty()) {
            try {
                this.txtPrecioVentaN.commitEdit();
                Double precioVentaA = Double.parseDouble(this.txtPrecioVentaA.getValue().toString());
                Double precioVentaN = Double.parseDouble(this.txtPrecioVentaN.getValue().toString());
                Double variacion = precioVentaN - precioVentaA;
                this.txtVariacion.setValue(variacion);
                this.txtVariacion.commitEdit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtPrecioVentaNFocusLost

    private void txtVariacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVariacionFocusLost
        if (!this.txtVariacion.getText().isEmpty()) {
            try {
                this.txtVariacion.commitEdit();
                Double precioVentaA = Double.parseDouble(this.txtPrecioVentaA.getValue().toString());
                Double variacion = Double.parseDouble(this.txtVariacion.getValue().toString());
                Double precioVentaN = precioVentaA + variacion;
                this.txtPrecioVentaN.setValue(precioVentaN);
                this.txtPrecioVentaN.commitEdit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtVariacionFocusLost


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
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionListaPrecios dialog = new GestionListaPrecios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.ButtonGroup grupoModo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblInfoPie;
    private javax.swing.JRadioButton rdoFijo;
    private javax.swing.JRadioButton rdoPorcentaje;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtCodMarca;
    private javax.swing.JTextField txtCodTipo;
    private javax.swing.JTextField txtDescArticulo;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaMod;
    private javax.swing.JFormattedTextField txtIncrementoFijo;
    private javax.swing.JTextField txtNomMarca;
    private javax.swing.JTextField txtNomTipo;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroTrans;
    private javax.swing.JFormattedTextField txtPorcAjuste;
    private javax.swing.JFormattedTextField txtPrecioCompra;
    private javax.swing.JFormattedTextField txtPrecioVentaA;
    private javax.swing.JFormattedTextField txtPrecioVentaN;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JFormattedTextField txtVariacion;
    // End of variables declaration//GEN-END:variables



    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    

    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";
        //Seteamos los campos editables por el usuario
        this.txtNroTrans.setText("");
        this.txtFecha.setEditable(false);
        this.txtFecha.setText("");        
        this.txtCodMarca.setEditable(false);
        this.txtCodMarca.setText("");        
        this.txtNomMarca.setText("");
        this.txtCodTipo.setEditable(false);
        this.txtCodTipo.setText("");
        this.txtNomTipo.setText("");
        this.txtIncrementoFijo.setEnabled(false);
        //Detalle
        this.txtCodArticulo.setText("");
        this.txtDescArticulo.setText("");        
        this.txtPrecioCompra.setValue(null);         
        this.txtPrecioVentaA.setValue(null);        
        this.txtPrecioVentaN.setEditable(false);
        this.txtPrecioVentaN.setValue(null);                 
        this.txtVariacion.setEditable(false);
        this.txtVariacion.setValue(null);

        //Seteamos el estado de los botones
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnBorrar.setEnabled(false);
        this.btnAgregar.setEnabled(false);
        this.btnBuscar.setEnabled(true);
        
        this.btnPrimero.setEnabled(false);
        this.btnAnterior.setEnabled(false);
        this.btnSiguiente.setEnabled(false);
        this.btnUltimo.setEnabled(false);
        //Seteamos y cargamos la tabla
        defaultTableModel();
        this.jTable1.setEnabled(true);   
    }
    
    private void defaultTableModel(){
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);

        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);       // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);      // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);      // cantidad
        //this.jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);      // precio unitario
        //this.jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);      // subtotal
        //this.jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);      // porc iva
        //this.jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);

        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        objUsuario = (MtUsuarios) st.load(MtUsuarios.class, cod_usuario);
        return objUsuario;
    }
    
    private void buscar() {
        String SqlQuery = "select nro_trans from cambio_precios_cab where nro_trans >= 0";
        if (!this.txtCodMarca.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and upper(cod_marca) = '" + this.txtCodMarca.getText().toUpperCase().trim() + "'";
        }
        if (!this.txtCodTipo.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_tipo = " + this.txtCodTipo.getText();
        }
        SqlQuery = SqlQuery + " order by nro_trans";
        
        Query consulta = st.createSQLQuery(SqlQuery);
        ArrayPrimaryKey = consulta.list();

        if (ArrayPrimaryKey.size() > 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnPrimero.setEnabled(true);
            this.btnAnterior.setEnabled(true);
            this.btnSiguiente.setEnabled(true);
            this.btnUltimo.setEnabled(true);
            this.btnEliminar.setEnabled(false);
            this.btnEditar.setEnabled(false);
            this.btnInforme.setEnabled(false);
            this.btnCalcular.setEnabled(false);
            this.btnFiltrar.setEnabled(false);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else if (ArrayPrimaryKey.size() == 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnEliminar.setEnabled(false);
            this.btnEditar.setEnabled(false);
            this.btnInforme.setEnabled(false);
            this.btnCalcular.setEnabled(false);
            this.btnFiltrar.setEnabled(false);            
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro", "Buscar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void recuperarRegistros(int indice) {
        int nroOrden = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        CambioPreciosCab cabecera = (CambioPreciosCab) st.load(CambioPreciosCab.class, nroOrden);
        this.txtUsuario.setText(cabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaMod.setValue(cabecera.getFechaMod());
        this.txtNroTrans.setText(String.valueOf(cabecera.getNroTrans()));
        this.txtFecha.setValue(cabecera.getFecha());
        if(cabecera.getCodMarca() != null && !cabecera.getCodMarca().isEmpty()){
            this.txtCodMarca.setText(cabecera.getCodMarca().toUpperCase());
        }
        if(cabecera.getCodTipo() != null){
            this.txtCodTipo.setText(String.valueOf(cabecera.getCodTipo()));
        }
        recuperarDetalle(nroOrden);
    }
    
    private void recuperarDetalle(int orden) {
        Query consulta = st.createQuery("From CambioPreciosDet a JOIN a.id b WHERE b.nroTrans = :nroOrden");
        consulta.setParameter("nroOrden", orden);
        List<CambioPreciosDet> detalles = (List<CambioPreciosDet>)consulta.list();
        model.setNumRows(0);
        for (CambioPreciosDet detalle : detalles) {
            recuperarArticulo(detalle.getId().getCodArticulo());
            model.addRow(new Object[]{
                detalle.getId().getCodArticulo(),
                articulo.getNomArticulo(),
                detalle.getPrecioCostoActual(),
                detalle.getPrecioVentaActual(),
                detalle.getPrecioVentaNuevo(),
                detalle.getVariacion()            
            });
        }
    }
    
    private void primero() {
        if (posicion > 0 && ArrayPrimaryKey.size() > 0) {
            posicion = 0;
            recuperarRegistros(posicion);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            
        }
    }    
    
    private void anterior() {
        if (posicion > 0 && ArrayPrimaryKey.size() > 0) {
            posicion--;
            recuperarRegistros(posicion);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            
        }
    }
    
    private void siguiente() {
        if (posicion < ArrayPrimaryKey.size() - 1 && ArrayPrimaryKey.size() > 0) {
            posicion++;
            recuperarRegistros(posicion);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            
        }
    }    
    
    private void ultimo() {
        if (posicion < ArrayPrimaryKey.size() - 1 && ArrayPrimaryKey.size() > 0) {
            posicion = ArrayPrimaryKey.size() - 1;
            recuperarRegistros(posicion);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            
        }
    }    
    
    public void cargarTabla(){
        List<MtArticulos> lista = (List<MtArticulos>)st
                .createQuery("From MtArticulos Order By codArticulo").list();
        for (MtArticulos unaLista : lista) {
            model.addRow(new Object[]{
                unaLista.getCodArticulo(), unaLista.getNomArticulo(), unaLista.getMtMarcas().getNomMarca(), unaLista.getReferencia(),
                unaLista.getMtTiposArticulos().getNomTipoArticulo(), unaLista.getMtMonedasByCodMonedaCompra().getNomMoneda(),
                unaLista.getMtUnidMedidasByUniMedidaCom().getDescUnidad(), unaLista.getPrecioCompra(), 
                unaLista.getMtMonedasByCodMonedaVenta().getNomMoneda(),
                unaLista.getMtUnidMedidasByUniMedidaVenta().getDescUnidad(), unaLista.getPrecioVenta(), unaLista.getControlStock()
            });
        }
    }
    
    public void nuevo(){
        arranque();
        //Seteamos la accion
        accion = "Nuevo";
        //Los componentes editables
        this.txtCodMarca.setEditable(true);
        this.txtCodMarca.setText("");
        this.txtCodTipo.setEditable(true);
        this.txtNomTipo.setText("");
        this.txtFecha.setEditable(true);
        this.txtFecha.setText(UtilidadesCalendario.FechaActualString());        
        //Detalle
        this.txtCodArticulo.setText("");   
        this.txtCodArticulo.setEditable(true);
        this.txtPrecioCompra.setValue(null);
        this.txtPrecioVentaA.setValue(null);   
        this.txtPrecioVentaN.setEditable(true);
        this.txtPrecioVentaN.setValue(null);
        this.txtVariacion.setEditable(true);
        this.txtVariacion.setValue(null);
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnBuscar.setEnabled(false);
        this.btnAgregar.setEnabled(true);
        //Inicializamos
        this.txtNroTrans.setText(obtenerID());      
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(recuperarUsuario(usuario).getNomUsuario());
        this.txtFechaMod.setValue(new Date());
        
        this.txtCodMarca.requestFocus();
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        articulosBorrados = new ArrayList<>();
        cant_lineas = model.getRowCount();
        
        //Los componentes editables
        this.txtCodMarca.setEditable(true);
        this.txtFecha.setEditable(true); 
        
        this.txtCodArticulo.setEditable(true);   
        this.txtPrecioCompra.setEditable(true);       
        this.txtPrecioVentaA.setEditable(false);
        this.txtPrecioVentaN.setEditable(false);      
        this.txtVariacion.setEditable(false); 
       
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnBuscar.setEnabled(false);
        this.btnAgregar.setEnabled(true);
        
        this.btnPrimero.setEnabled(false);
        this.btnAnterior.setEnabled(false);
        this.btnSiguiente.setEnabled(false);
        this.btnUltimo.setEnabled(false);
        
        this.jTable1.setEnabled(true);
        this.txtCodMarca.grabFocus();
    }
    
    public void eliminar() {
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        } else {//Opción eliminar seleccionada
            st.beginTransaction();
            Integer numeroOrden = Integer.parseInt(this.txtNroTrans.getText());
            OrdenCompra a = (OrdenCompra) st.load(OrdenCompra.class, numeroOrden);

            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                OrdCompraDetId detOCompraId = new OrdCompraDetId(numeroOrden, i);
                OrdCompraDet detOCompra = (OrdCompraDet) st.load(OrdCompraDet.class, detOCompraId);
                st.delete(detOCompra);
            }
            st.delete(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro eliminado.");
            arranque();
        }
    }
    
    private void recuperarMarca(String marca) {
        try {
            String consulta = "Select * from mt_marcas where cod_marca = '" + marca + "'";
            Cargar cargar = new Cargar();
            MtMarcas objMarca = (MtMarcas) cargar.resultadoUnico(consulta, MtMarcas.class);
            this.txtNomMarca.setText(objMarca.getNomMarca());
        } catch (Exception e) {
        }
    }
    
    private void recuperarTipo(String codigo) {
        try {
            String consulta = "Select * from mt_tipos_articulos where cod_tipo_articulo = " + codigo ;
            Cargar cargar = new Cargar();
            MtTiposArticulos objeto = (MtTiposArticulos) cargar.resultadoUnico(consulta, MtTiposArticulos.class);
            this.txtNomTipo.setText(objeto.getNomTipoArticulo());
        } catch (Exception e) {
        }
    }
    
    private boolean recuperarArticulo(String codArticulo) {
        this.articulo = (MtArticulos) st.get(MtArticulos.class, codArticulo.toUpperCase());
        return articulo != null;
    }
    
    private void calcularLinea() {
        BigDecimal pCantidad = BigDecimal.ZERO;
        BigDecimal pUnitario = BigDecimal.ZERO;
        BigDecimal pPorcDescuento = BigDecimal.ZERO;
        BigDecimal pPorcIva = BigDecimal.ZERO;
        
        BigDecimal montoSubtotal;
        BigDecimal montoDescuento;
        BigDecimal montoIva;
        BigDecimal ivaCompuesto;
        BigDecimal auxiliarIva1;
        BigDecimal montoTotal;

        if (this.txtPrecioCompra.getValue() != null) {
            pCantidad = new BigDecimal(this.txtPrecioCompra.getValue().toString());
        }

        if (this.txtPrecioVentaA.getValue() != null) {
            pUnitario = new BigDecimal(this.txtPrecioVentaA.getValue().toString());
        }

        montoSubtotal = pUnitario.multiply(pCantidad);
        montoDescuento = montoSubtotal.multiply(pPorcDescuento);
        montoTotal = montoSubtotal.subtract(montoDescuento);
        
        auxiliarIva1 = montoTotal.multiply(pPorcIva);
        ivaCompuesto = pPorcIva.add(new BigDecimal("100"));
        montoIva = auxiliarIva1.divide(ivaCompuesto, MathContext.DECIMAL32);

        this.txtPrecioVentaN.setValue(montoSubtotal);
        this.txtVariacion.setValue(montoTotal);
    }
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.txtFecha.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.txtFecha.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Buscar":
               btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Search.png")));
               this.accion = "";
                arranque();
       }
    }
    
    private String obtenerID(){
        Integer newId;
        String retorno;
        retorno = null;
        try {
            String sql = "SELECT MAX(nroTrans) FROM CambioPreciosCab";
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

    public void guardar() {
        int rowCount = this.jTable1.getRowCount();

        if (this.txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                CambioPreciosCab cabecera = new CambioPreciosCab();
                Integer numeroOrden = Integer.parseInt(this.txtNroTrans.getText());

                cabecera.setNroTrans(numeroOrden);
                cabecera.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                if (!this.txtCodMarca.getText().isEmpty()) {
                    cabecera.setCodMarca(this.txtCodMarca.getText());
                }
                if (!this.txtCodTipo.getText().isEmpty()) {
                    cabecera.setCodTipo(Integer.parseInt(this.txtCodTipo.getText()));
                }
                cabecera.setAccionMod(accion);
                cabecera.setUsuarioMod(usuario);
                cabecera.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                st.save(cabecera);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    CambioPreciosDetId detalleId = new CambioPreciosDetId(numeroOrden, model.getValueAt(i, 0).toString().toUpperCase());

                    CambioPreciosDet detalle = new CambioPreciosDet();
                    MtArticulos elarticulo = (MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase());
                    elarticulo.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 4).toString())));

                    detalle.setId(detalleId);
                    detalle.setPrecioCostoActual(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 2).toString())));
                    detalle.setPrecioVentaActual(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 3).toString())));
                    detalle.setPrecioVentaNuevo(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 4).toString())));
                    detalle.setVariacion(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 5).toString())));
                    detalle.setCambioPreciosCab(cabecera);

                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                    st.save(detalle);
                    st.update(elarticulo);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                //informe();
                arranque();
            } catch (org.hibernate.NonUniqueObjectException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n"
                        + "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (org.hibernate.PropertyValueException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Existe un valor nulo. No es posible guardar el registro " + "\n"
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado. No es posible guardar el registro " + "\n"
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarEd() {
        int rowCount = this.jTable1.getRowCount();
        if (this.txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                Integer numeroOrden = Integer.parseInt(this.txtNroTrans.getText());
                CambioPreciosCab cabecera = (CambioPreciosCab) st.load(CambioPreciosCab.class, numeroOrden);

                cabecera.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                cabecera.setCodMarca(this.txtCodMarca.getText());
                cabecera.setCodTipo(Integer.parseInt(this.txtCodTipo.getText()));

                cabecera.setAccionMod(accion);
                cabecera.setUsuarioMod(usuario);
                cabecera.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                st.update(cabecera);

                if (cant_lineas > 0) {
                    for (int i = 0; i < cant_lineas; i++) {
                        CambioPreciosDetId detalleId = new CambioPreciosDetId(numeroOrden, model.getValueAt(i, 0).toString().toUpperCase());
                        CambioPreciosDet detalle = (CambioPreciosDet) st.load(CambioPreciosDet.class, detalleId);

                        st.delete(detalle);
                    }
                }
                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    CambioPreciosDetId detalleId = new CambioPreciosDetId(numeroOrden, model.getValueAt(i, 0).toString().toUpperCase());

                    CambioPreciosDet detalle = new CambioPreciosDet();
                    detalle.setId(detalleId);
                    detalle.setPrecioCostoActual(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 2).toString())));
                    detalle.setPrecioVentaActual(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 3).toString())));
                    detalle.setPrecioVentaNuevo(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 4).toString())));
                    detalle.setVariacion(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 5).toString())));
                    detalle.setCambioPreciosCab(cabecera);

                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                    MtArticulos elarticulo = (MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase());
                    elarticulo.setPrecioVenta(BigDecimal.valueOf(Double.parseDouble(model.getValueAt(i, 4).toString())));

                    st.save(detalle);
                    st.update(elarticulo);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro actualizado.");
                arranque();
            } catch (org.hibernate.NonUniqueObjectException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n"
                        + "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (org.hibernate.PropertyValueException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Existe un valor nulo. No es posible guardar el registro " + "\n"
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado. No es posible guardar el registro " + "\n"
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void anexarTabla() {
        if (this.articulo == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado el artículo. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else if (this.txtVariacion.getValue() == null || this.txtPrecioVentaN.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else {
            verificar();
            if(var>=1){
                int showConfirmDialog = 0; 
                //JOptionPane.showConfirmDialog(null, "Artículo ya Agregado. Desea reemplazar los datos?.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
                if(showConfirmDialog==0){
                    model.setValueAt(this.txtPrecioVentaN.getValue(), idArti, 4);
                    model.setValueAt(this.txtVariacion.getValue(), idArti, 5);
                    limpiarArticulos();
                }
                else {
                    limpiarArticulos();
                    this.txtCodArticulo.requestFocus();
                }
            }
            else {
                model.addRow(new Object[] {
                    this.articulo.getCodArticulo(),
                    this.articulo.getNomArticulo(),
                    this.txtPrecioCompra.getValue(),
                    this.txtPrecioVentaA.getValue(),
                    this.txtPrecioVentaN.getValue(),
                    this.txtVariacion.getValue()
                });                    
                limpiarArticulos(); 
             }
        }
    }
    
    public void verificar(){
        //Método para verificar que no se duplique el mismo artículo en la tabla, para ello se comprueba el id del artículo.
        var = 0;
        String idAr = this.txtCodArticulo.getText();
        if(this.jTable1.getRowCount()>=1){
            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                Object valueAt = model.getValueAt(i, 0);
                String parseInt = valueAt.toString();
                if(idAr.equals(parseInt)){
                    var = 1;
                    idArti = i;
                }        
            }        
        }  
    }
    
    public void sumarRepetido(){
        //Si se repite el ingreso de un artículo específico,se puede obtar por sumar la cantidad de compra,
        //este método localizar el id del artículo específico y aumenta la cantidad de la compra sumandola.
        int artCant = Integer.parseInt(this.txtPrecioCompra.getValue().toString());
        int artTotal = Integer.parseInt(this.txtVariacion.getValue().toString());
        Object valueAt = model.getValueAt(idArti, 2);
        Object valueAt1 = model.getValueAt(idArti, 9);
        int cantArt = Integer.parseInt(valueAt.toString());
        int totalArt = Integer.parseInt(valueAt1.toString());
        int x = artCant + cantArt;
        int y = artTotal + totalArt;
            model.setValueAt(x, idArti, 2);
            model.setValueAt(y, idArti, 9);        
    }
    
    private void limpiarArticulos() {
        this.txtCodArticulo.setText("");
        this.txtDescArticulo.setText("");
        this.txtPrecioCompra.setValue(null);
        this.txtPrecioVentaA.setValue(null);   
        this.txtPrecioVentaN.setValue(null);
        this.txtVariacion.setValue(null);
        this.btnBorrar.setEnabled(false);
        this.txtCodArticulo.requestFocus();
        this.deboBuscarArticulo = true;
        this.articulo = null;
    }  
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            recuperarArticulo(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtCodArticulo.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtDescArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
            this.txtPrecioCompra.setValue(model.getValueAt(filaSeleccionada, 2));
            this.txtPrecioVentaA.setValue(model.getValueAt(filaSeleccionada, 3));
            this.txtPrecioVentaN.setValue(model.getValueAt(filaSeleccionada, 4));
            this.txtVariacion.setValue(model.getValueAt(filaSeleccionada, 5));
            
            this.txtPrecioVentaN.requestFocus();
            this.btnBorrar.setEnabled(true);
        }
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            Map parametros = new HashMap();
            //parametros que enviamos al report.
            parametros.put("pnro_ocompra", Integer.parseInt(this.txtNroTrans.getText()));
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/OrdenCompraQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, parametros, conexion);
            //JasperPrint imprimir = JasperFillManager.fillReport(elReporte, null, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Orden de Compra.");
            visor.setVisible(true);
            conexion.close();
            System.out.println("Conexion Cerrada");
        }
        catch(Exception e) {
            String mensajeEx = e.getMessage();
            JOptionPane.showMessageDialog(null, "Error cargando reporte. " + mensajeEx);
        }
    }

    private void recuperarArticulosFiltro() {
        model.setRowCount(0);
        String SqlQuery = "select * from mt_articulos where precio_compra >= 0";
        if (!this.txtCodMarca.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and upper(cod_marca) = '" + this.txtCodMarca.getText().toUpperCase().trim() + "'";
        }
        if (!this.txtCodTipo.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_tipo_articulo = " + this.txtCodTipo.getText();
        }
        SqlQuery = SqlQuery + " order by cod_articulo";
        
        SQLQuery consulta = st.createSQLQuery(SqlQuery);
        consulta.addEntity(MtArticulos.class);
        
        List<MtArticulos> lista = (List<MtArticulos>) consulta.list();
        for (MtArticulos unaLista : lista) {
            model.addRow(new Object[]{
                unaLista.getCodArticulo(), unaLista.getNomArticulo(), unaLista.getPrecioCompra(), 
                unaLista.getPrecioVenta(), unaLista.getPrecioVenta(), BigDecimal.ZERO
            });
        }
    }

    private void calcularPrecios() {
        double incremento;
        double valorActual;
        double nuevoValor;
        double diferencia;
        try {
            if (this.rdoFijo.isSelected()) {
                if (this.txtIncrementoFijo.getValue() != null) {
                    incremento = Double.parseDouble(this.txtIncrementoFijo.getValue().toString());
                    if (this.jTable1.getRowCount() >= 1) {
                        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                            Object valueAt = model.getValueAt(i, 3);
                            valorActual = Double.parseDouble(valueAt.toString());
                            nuevoValor = valorActual + incremento;
                            diferencia = nuevoValor - valorActual;
                            model.setValueAt(nuevoValor, i, 4);
                            model.setValueAt(diferencia, i, 5);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han recuperado articulos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe especificar el monto del reajuste.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (this.txtPorcAjuste.getValue() != null) {
                    incremento = Double.parseDouble(this.txtPorcAjuste.getValue().toString());
                    if (this.jTable1.getRowCount() >= 1) {
                        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                            Object valueAt = model.getValueAt(i, 3);
                            valorActual = Double.parseDouble(valueAt.toString());
                            nuevoValor = (valorActual * incremento / 100) + valorActual;
                            diferencia = nuevoValor - valorActual;
                            model.setValueAt(nuevoValor, i, 4);
                            model.setValueAt(diferencia, i, 5);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han recuperado articulos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe especificar el porcentaje del reajuste.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al recalcular los precios. " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}