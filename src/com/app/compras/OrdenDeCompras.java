package com.app.compras;

import com.app.mantenimiento.Articulos;
import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtProveedores;
import com.entidades.MtUsuarios;
import com.entidades.OrdCompraDet;
import com.entidades.OrdCompraDetId;
import com.entidades.OrdenCompra;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.hibernate.Session;
import util.HibernateUtil;
import util.Busqueda;
import util.UtilidadesCalendario;

//@author Fausto Sanabria.

public class OrdenDeCompras extends javax.swing.JDialog {
    public OrdenDeCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Orden de Compra - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();   
    }
    
    public OrdenDeCompras (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Orden de Compra - KARU v1.0");
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
    private DecimalFormat dfNumero2Dec = new DecimalFormat("###,###,###.00");
    private DecimalFormat dfNumero0Dec = new DecimalFormat("###,###,###");
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroOCompra = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCodProveedor = new javax.swing.JTextField();
        txtNomProveedor = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodArticulo = new javax.swing.JTextField();
        txtDescArticulo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioUnitarioF = new javax.swing.JFormattedTextField();
        txtSubtotalF = new javax.swing.JFormattedTextField();
        txtDescuentoF = new javax.swing.JFormattedTextField();
        txtTotalF = new javax.swing.JFormattedTextField();
        txtIvaF = new javax.swing.JFormattedTextField();
        txtCantidadF = new javax.swing.JFormattedTextField();
        txtPorcDescuentoF = new javax.swing.JFormattedTextField();
        txtPorcIvaF = new javax.swing.JFormattedTextField();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtTotalFacturaF = new javax.swing.JFormattedTextField();
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

        jLabel3.setText("Fecha Emisión");

        txtNroOCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtNroOCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroOCompraKeyTyped(evt);
            }
        });

        jLabel12.setText("Proveedor");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtFecha.setToolTipText("Fecha en formato dd/mm/aaaa");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P", "A", "F", " " }));

        jLabel8.setText("Activo");

        txtCodProveedor.setToolTipText("Código del proveedor. F9 para buscar");
        txtCodProveedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodProveedorFocusLost(evt);
            }
        });
        txtCodProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodProveedorKeyTyped(evt);
            }
        });

        txtNomProveedor.setEditable(false);
        txtNomProveedor.setBackground(new java.awt.Color(204, 255, 204));
        txtNomProveedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomProveedor.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroOCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProveedor)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(50, 50, 50)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNroOCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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
                .addContainerGap(144, Short.MAX_VALUE))
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
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Cantidad", "Precio Unitario", "Subtotal", "% IVA", "Importe IVA", "% Desto.", "Descuento", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Artículo");

        jLabel5.setText("Cantidad");

        jLabel6.setText("Precio Unit.");

        jLabel7.setText("Subtotal");

        jLabel9.setText("% IVA");

        jLabel10.setText("IVA");

        jLabel11.setText("% Dto.");

        jLabel13.setText("Descuento");

        jLabel14.setText("Total");

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

        txtPrecioUnitarioF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecioUnitarioF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioUnitarioF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioUnitarioFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioUnitarioFFocusLost(evt);
            }
        });
        txtPrecioUnitarioF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioFKeyTyped(evt);
            }
        });

        txtSubtotalF.setEditable(false);
        txtSubtotalF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSubtotalF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtSubtotalF.setFocusable(false);

        txtDescuentoF.setEditable(false);
        txtDescuentoF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtDescuentoF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtDescuentoF.setFocusable(false);

        txtTotalF.setEditable(false);
        txtTotalF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtTotalF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalF.setFocusable(false);

        txtIvaF.setEditable(false);
        txtIvaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtIvaF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtIvaF.setFocusable(false);

        txtCantidadF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtCantidadF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtCantidadF.setText("1");
        txtCantidadF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFFocusLost(evt);
            }
        });
        txtCantidadF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadFKeyTyped(evt);
            }
        });

        txtPorcDescuentoF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtPorcDescuentoF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPorcDescuentoF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcDescuentoFFocusLost(evt);
            }
        });
        txtPorcDescuentoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcDescuentoFKeyTyped(evt);
            }
        });

        txtPorcIvaF.setEditable(false);
        txtPorcIvaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtPorcIvaF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPorcIvaF.setFocusable(false);

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidadF)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPrecioUnitarioF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotalF, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtPorcDescuentoF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtDescuentoF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPorcIvaF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIvaF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel16)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidadF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioUnitarioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSubtotalF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescuentoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPorcDescuentoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPorcIvaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIvaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTotalFacturaF.setEditable(false);
        txtTotalFacturaF.setBackground(new java.awt.Color(204, 255, 204));
        txtTotalFacturaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtTotalFacturaF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalFacturaF.setText("0");
        txtTotalFacturaF.setFocusable(false);
        txtTotalFacturaF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotalFacturaF, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalFacturaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPrimero.setText("<<");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setText(">>");
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
                .addComponent(btnPrimero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUltimo)
                .addGap(18, 18, 18)
                .addComponent(lblInfoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(81, 81, 81))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnUltimo)
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
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCodProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveedorKeyReleased
        // TODO add your handling code here:
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigoProv;
                Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de proveedor", "mt_proveedores",
                        "nro_docum", "nom_tit");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigoProv = formBusqueda.getCodigo();
                if (codigoProv != null) {
                    this.txtCodProveedor.setText(codigoProv);
                    this.txtCodProveedor.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (this.txtCodProveedor.getText().length() > 0) {
                    this.txtCodProveedor.transferFocus();
                } else {

                }
            }
        }
    }//GEN-LAST:event_txtCodProveedorKeyReleased

    private void txtCodProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodProveedorFocusLost
        if (!this.txtCodProveedor.getText().isEmpty()) {
            recuperarProveedor();
        } else {
            
        }
    }//GEN-LAST:event_txtCodProveedorFocusLost

    private void txtCodArticuloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArticuloFocusLost
        if (deboBuscarArticulo && !this.txtCodArticulo.getText().isEmpty()) {
            if (this.articulo == null) {
                recuperarArticulo();
            }
            else if (!articulo.getCodArticulo().equalsIgnoreCase(this.txtCodArticulo.getText())) {
                recuperarArticulo();
            }
        } else {
        }
    }//GEN-LAST:event_txtCodArticuloFocusLost

    private void txtCodProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveedorKeyTyped
        char car = evt.getKeyChar();
        if (car >= '0' && car <= '9') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodProveedorKeyTyped

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Desea eliminar la fila seleccionada?", "Corfirmacion",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirma == 0) {
            if ("Editar".equalsIgnoreCase(accion)) {
                System.out.println("fila: " + filaSeleccionada);
                System.out.println("nro_orden: " + Integer.parseInt(this.txtNroOCompra.getText()));
                OrdCompraDetId idLineaEliminada = new OrdCompraDetId(Integer.parseInt(this.txtNroOCompra.getText()), filaSeleccionada);
                System.out.println("objeto: " + idLineaEliminada.getNroOcompra() + "--" + idLineaEliminada.getLinea());
                articulosBorrados.add(idLineaEliminada);
            }
            model.removeRow(filaSeleccionada);
            calcularTotalFactura();
            limpiarArticulos();
            this.txtCodArticulo.setEditable(true);
            this.txtCodArticulo.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNroOCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroOCompraKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroOCompraKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!accion.equalsIgnoreCase("Buscar")) {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png")));
            arranque();
            this.accion = "Buscar";
            this.txtCodProveedor.setEditable(true);
            this.txtNroOCompra.setEditable(true);
            this.txtNroOCompra.requestFocus();
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

    private void txtPrecioUnitarioFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFFocusLost
        try {
            this.txtPrecioUnitarioF.commitEdit();
            calcularLinea();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El precio ingresado no es correcto", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtPrecioUnitarioF.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioUnitarioFFocusLost

    private void txtCantidadFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFFocusLost
        try {
            this.txtCantidadF.commitEdit();
            calcularLinea();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error en la cantidad ingresada. ", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtCantidadF.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadFFocusLost

    private void txtCantidadFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadFKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9')) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadFKeyTyped

    private void txtCantidadFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFFocusGained
        this.txtCantidadF.selectAll();
    }//GEN-LAST:event_txtCantidadFFocusGained

    private void txtPrecioUnitarioFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFFocusGained
            this.txtPrecioUnitarioF.selectAll();
    }//GEN-LAST:event_txtPrecioUnitarioFFocusGained

    private void txtPorcDescuentoFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcDescuentoFFocusLost
        try {
            this.txtPorcDescuentoF.commitEdit();
            calcularLinea();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El valor de decuento ingresado no es correcto. ", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtPorcDescuentoF.requestFocus();
        }
    }//GEN-LAST:event_txtPorcDescuentoFFocusLost

    private void txtPrecioUnitarioFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == ',') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioUnitarioFKeyTyped

    private void txtPorcDescuentoFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcDescuentoFKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == ',') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPorcDescuentoFKeyTyped


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
                OrdenDeCompras dialog = new OrdenDeCompras(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblInfoPie;
    private javax.swing.JFormattedTextField txtCantidadF;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtCodProveedor;
    private javax.swing.JTextField txtDescArticulo;
    private javax.swing.JFormattedTextField txtDescuentoF;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaMod;
    private javax.swing.JFormattedTextField txtIvaF;
    private javax.swing.JTextField txtNomProveedor;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroOCompra;
    private javax.swing.JFormattedTextField txtPorcDescuentoF;
    private javax.swing.JFormattedTextField txtPorcIvaF;
    private javax.swing.JFormattedTextField txtPrecioUnitarioF;
    private javax.swing.JFormattedTextField txtSubtotalF;
    private javax.swing.JFormattedTextField txtTotalF;
    private javax.swing.JFormattedTextField txtTotalFacturaF;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables



    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    

    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";
        //Seteamos los campos editables por el usuario
        this.txtNroOCompra.setEditable(false);
        this.txtNroOCompra.setText("");
        this.txtFecha.setEditable(false);
        this.txtFecha.setText("");        
        this.cmbEstado.setEnabled(false);       
        this.txtCodProveedor.setEditable(false);
        this.txtCodProveedor.setText("");        
        this.txtNomProveedor.setText("");
        this.txtTotalFacturaF.setValue(0);
        //Detalle
        this.txtCodArticulo.setEditable(false);
        this.txtCodArticulo.setText("");
        this.txtCantidadF.setEditable(false);
        this.txtCantidadF.setValue(null);         
        this.txtPrecioUnitarioF.setEditable(false);
        this.txtPrecioUnitarioF.setValue(null);        
        this.txtSubtotalF.setEditable(false);
        this.txtSubtotalF.setValue(null);        
        this.txtIvaF.setEditable(false);
        this.txtIvaF.setValue(null);          
        this.txtPorcDescuentoF.setEditable(false);
        this.txtPorcDescuentoF.setValue(null);     
        this.txtPorcIvaF.setEditable(false);
        this.txtPorcIvaF.setValue(null); 
        this.txtDescuentoF.setEditable(false);
        this.txtDescuentoF.setValue(null);     
        this.txtTotalF.setEditable(false);
        this.txtTotalF.setValue(null);
        this.txtDescArticulo.setText("");
        this.txtPorcDescuentoF.setEditable(false);
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
        //cargarTabla();
        this.jTable1.setEnabled(true);   
    }
    
    private void defaultTableModel(){
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);

        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);       // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);      // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);      // cantidad
        //this.jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);      // precio unitario
        //this.jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);      // subtotal
        //this.jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);      // porc iva
        //this.jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);      // iva
        //this.jTable1.getColumnModel().getColumn(6).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);      // porc dto
        //this.jTable1.getColumnModel().getColumn(7).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);      // descuento
        //this.jTable1.getColumnModel().getColumn(8).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(85);      // total
        //this.jTable1.getColumnModel().getColumn(9).setCellRenderer(tcr);
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        objUsuario = (MtUsuarios) st.load(MtUsuarios.class, cod_usuario);
        return objUsuario;
    }
    
    private void buscar() {
        String SqlQuery = "select nro_ocompra from orden_compra where nro_ocompra > 0";
        if (!this.txtNroOCompra.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and nro_ocompra = " + this.txtNroOCompra.getText();
        }
        if (!this.txtCodProveedor.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_proveedor = " + this.txtCodProveedor.getText();
        }
        if (this.txtFecha.getText().trim().length() == 10) {
            SqlQuery = SqlQuery + " and fecha = " + this.txtFecha.getText();
        }
        SqlQuery = SqlQuery + " order by nro_ocompra";
        
        Query consulta = st.createSQLQuery(SqlQuery);
        System.out.println(consulta.getQueryString());
        ArrayPrimaryKey = consulta.list();

        if (ArrayPrimaryKey.size() > 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnPrimero.setEnabled(true);
            this.btnAnterior.setEnabled(true);
            this.btnSiguiente.setEnabled(true);
            this.btnUltimo.setEnabled(true);
            this.btnEliminar.setEnabled(true);
            this.btnEditar.setEnabled(true);
            this.btnInforme.setEnabled(true);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else if (ArrayPrimaryKey.size() == 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnEliminar.setEnabled(true);
            this.btnEditar.setEnabled(true);
            this.btnInforme.setEnabled(true);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro", "Buscar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void recuperarRegistros(int indice) {
        DecimalFormat nroOrdenf = new DecimalFormat("###,###,###");
        int nroOrden = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        OrdenCompra ordenCabecera = (OrdenCompra) st.load(OrdenCompra.class, nroOrden);
        this.txtUsuario.setText(ordenCabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaMod.setValue(ordenCabecera.getFechaMod());
        this.txtNroOCompra.setText(nroOrdenf.format(ordenCabecera.getNroOcompra()));
        //this.txtFecha.setText(fechaString(ordenCabecera.getFecha()));
        this.txtFecha.setValue(ordenCabecera.getFecha());
        this.txtCodProveedor.setText(ordenCabecera.getMtProveedores().getNroDocum());
        this.txtTotalFacturaF.setValue(ordenCabecera.getTotal());
        this.cmbEstado.setSelectedItem(String.valueOf(ordenCabecera.getEstado()));
        System.out.println("El estado es : " + ordenCabecera.getEstado());
        
        recuperarProveedor();
        recuperarDetalle(nroOrden);
    }
    
    private void recuperarDetalle(int orden) {
        Query consulta = st.createQuery("From OrdCompraDet a JOIN a.id b WHERE b.nroOcompra = :nroOrden order by b.linea");
        consulta.setParameter("nroOrden", orden);
        List<OrdCompraDet> ordenesDetalle = (List<OrdCompraDet>)consulta.list();
        model.setNumRows(0);
        for (OrdCompraDet ordDetalle : ordenesDetalle) {
            DecimalFormat dfCant = new DecimalFormat("###,###.000");
            model.addRow(new Object[]{
                ordDetalle.getMtArticulos().getCodArticulo(), ordDetalle.getMtArticulos().getNomArticulo(), 
                //dfCant.format(ordDetalle.getCantidad()), 
                ordDetalle.getCantidad(), 
                ordDetalle.getPrecioUnitario().intValue(), ordDetalle.getSubtotal().intValue(),
                ordDetalle.getPorcIva(), ordDetalle.getImporteIva().intValue(),
                ordDetalle.getPorcDto(), ordDetalle.getImpDescuento().intValue(),
                ordDetalle.getTotal().intValue()
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
        st.beginTransaction();
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
        this.txtCodProveedor.setEditable(true);
        this.txtCodProveedor.setText("");
        this.cmbEstado.setEnabled(true);
        this.cmbEstado.setSelectedIndex(0);
        this.txtNroOCompra.setEditable(false);
        this.txtNroOCompra.setText("");
        this.txtFecha.setEditable(true);
        this.txtFecha.setText(UtilidadesCalendario.FechaActualString());        
        //Detalle
        this.txtCodArticulo.setEditable(true);
        this.txtCodArticulo.setText("");       
        this.txtCantidadF.setEditable(true);
        this.txtCantidadF.setValue(null);
        this.txtPrecioUnitarioF.setEditable(true);
        this.txtPrecioUnitarioF.setValue(null);   
        this.txtSubtotalF.setEditable(false);
        this.txtSubtotalF.setValue(null);
        this.txtIvaF.setEditable(false);
        this.txtIvaF.setValue(null);
        this.txtPorcDescuentoF.setEditable(false);
        this.txtPorcDescuentoF.setValue(0); 
        this.txtDescuentoF.setEditable(false);
        this.txtDescuentoF.setValue(null);
        this.txtTotalF.setEditable(false);
        this.txtTotalF.setValue(null);
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
        String nuevo;
        nuevo = obtenerID();
        this.txtNroOCompra.setText(nuevo);      
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(recuperarUsuario(usuario).getNomUsuario());
        this.txtFechaMod.setValue(new Date());
        
        this.txtCodProveedor.requestFocus();
        this.cmbEstado.setEnabled(false);
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        articulosBorrados = new ArrayList<>();
        cant_lineas = model.getRowCount();
        
        //Los componentes editables
        this.txtCodProveedor.setEditable(true);
        this.cmbEstado.setEnabled(true);
        this.txtFecha.setEditable(true); 
        
        this.txtCodArticulo.setEditable(true);   
        this.txtCantidadF.setEditable(true);       
        this.txtPrecioUnitarioF.setEditable(false);
        this.txtSubtotalF.setEditable(false); 
        this.txtIvaF.setEditable(false);
        this.txtPorcDescuentoF.setEditable(false);
        this.txtDescuentoF.setEditable(false);     
        this.txtTotalF.setEditable(false); 
       
        
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
        this.txtCodProveedor.grabFocus();
    }
    
    public void eliminar() {
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        } else {//Opción eliminar seleccionada
            st.beginTransaction();
            Integer numeroOrden = Integer.parseInt(this.txtNroOCompra.getText());
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
    
    private void recuperarProveedor() {
        st.beginTransaction();
        this.proveedor = (MtProveedores) st.get(MtProveedores.class, this.txtCodProveedor.getText());
        if (proveedor != null) {
            this.txtNomProveedor.setText(proveedor.getNomTit());
            this.txtPorcDescuentoF.setValue(proveedor.getPorcDto());
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodProveedor.requestFocus();
        }
    }
    
    private void recuperarArticulo() {
        st.beginTransaction();
        this.articulo = (MtArticulos) st.get(MtArticulos.class, this.txtCodArticulo.getText().toUpperCase());
        if (articulo != null) {
            this.txtDescArticulo.setText(articulo.getNomArticulo());
            BigDecimal precioUnit = new BigDecimal(articulo.getPrecioCompra().toString());
            BigDecimal precioUnitarioIva = precioUnit.multiply(new BigDecimal("1.1"));
            this.txtPrecioUnitarioF.setValue(precioUnitarioIva);
            this.txtPorcIvaF.setValue(articulo.getImpuesto());
            
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del producto", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodArticulo.requestFocus();
        }
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

        if (this.txtCantidadF.getValue() != null) {
            pCantidad = new BigDecimal(this.txtCantidadF.getValue().toString());
        }

        if (this.txtPrecioUnitarioF.getValue() != null) {
            pUnitario = new BigDecimal(this.txtPrecioUnitarioF.getValue().toString());
        }
        if (this.txtPorcDescuentoF.getValue() != null) {
            pPorcDescuento = new BigDecimal(this.txtPorcDescuentoF.getValue().toString());
            pPorcDescuento = pPorcDescuento.divide(new BigDecimal("100"));
        }
        if (this.txtPorcIvaF.getValue() != null) {
            pPorcIva = new BigDecimal(this.txtPorcIvaF.getValue().toString());
        }

        montoSubtotal = pUnitario.multiply(pCantidad);
        montoDescuento = montoSubtotal.multiply(pPorcDescuento);
        montoTotal = montoSubtotal.subtract(montoDescuento);
        
        auxiliarIva1 = montoTotal.multiply(pPorcIva);
        ivaCompuesto = pPorcIva.add(new BigDecimal("100"));
        montoIva = auxiliarIva1.divide(ivaCompuesto, MathContext.DECIMAL32);

        this.txtSubtotalF.setValue(montoSubtotal);
        this.txtDescuentoF.setValue(montoDescuento);
        this.txtTotalF.setValue(montoTotal);
        this.txtIvaF.setValue(montoIva);
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
            String sql = "SELECT MAX(nroOcompra) FROM OrdenCompra";
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
        int rowCount = this.jTable1.getRowCount();
        if(this.txtCodProveedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor.");
        }
        else if(this.cmbEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado");
        }
        else if(this.txtFecha.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        }
        else if(rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        }
        else{
            try {
                st.beginTransaction();
                OrdenCompra a = new OrdenCompra();
                Integer numeroOrden = Integer.parseInt(this.txtNroOCompra.getText());

                a.setNroOcompra(numeroOrden);
                a.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                a.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                a.setMtProveedores(proveedor);
                System.out.println("aca pase");
                a.setTotal(BigDecimal.valueOf(Double.parseDouble(this.txtTotalFacturaF.getValue().toString())));
                a.setAccionMod(accion);
                a.setUsuarioMod(usuario);
                a.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                proveedor.getOrdenCompras().add(a);
                st.save(a);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    OrdCompraDetId detOCompraId = new OrdCompraDetId(numeroOrden, i);

                    OrdCompraDet detOCompra = new OrdCompraDet();
                    detOCompra.setId(detOCompraId);
                    detOCompra.setMtArticulos((MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase()));
                    detOCompra.setCantidad(Integer.parseInt(model.getValueAt(i, 2).toString()));
                    detOCompra.setPrecioUnitario(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
                    detOCompra.setSubtotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 4).toString())));
                    detOCompra.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
                    detOCompra.setImporteIva(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 6).toString())));
                    detOCompra.setPorcDto(Integer.parseInt(model.getValueAt(i, 7).toString()));
                    detOCompra.setImpDescuento(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));
                    detOCompra.setTotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 9).toString())));
                    detOCompra.setAccionMod(accion);
                    detOCompra.setUsuarioMod(usuario);
                    detOCompra.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detOCompra.setOrdenCompra(a);
                    st.save(detOCompra);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                informe();
                arranque();                
            }
            catch(org.hibernate.NonUniqueObjectException e){
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n" +
                            "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(org.hibernate.PropertyValueException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Existe un valor nulo. No es posible guardar el registro " + "\n" +
                            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e) {
                st.getTransaction().rollback();
                st.clear();
                
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado. No es posible guardar el registro " + "\n" +
                            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarEd(){
        int rowCount = this.jTable1.getRowCount();
        if(this.txtCodProveedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor.");
        }
        else if(this.cmbEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado");
        }
        else if(this.txtFecha.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        }
        else if(rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        }
        else{
            try {
                st.beginTransaction();
                Integer numeroOrden = Integer.parseInt(this.txtNroOCompra.getText());
                OrdenCompra a = (OrdenCompra) st.load(OrdenCompra.class, numeroOrden);

                a.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                a.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                a.setMtProveedores(proveedor);
                a.setTotal(BigDecimal.valueOf(Double.parseDouble(this.txtTotalFacturaF.getValue().toString())));
                a.setAccionMod(accion);
                a.setUsuarioMod(usuario);
                a.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                proveedor.getOrdenCompras().add(a);
                st.update(a);
                
                if (cant_lineas > 0){
                    for (int i = 0; i < cant_lineas; i++){
                        System.out.println("voy a borrar: " + i + "   ");
                        OrdCompraDetId detOCompraId = new OrdCompraDetId(numeroOrden, i);
                        OrdCompraDet detOCompra = (OrdCompraDet) st.load(OrdCompraDet.class, detOCompraId);
                        st.delete(detOCompra);
                    }
                }
                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    OrdCompraDetId detOCompraId = new OrdCompraDetId(numeroOrden, i);

                    OrdCompraDet detOCompra = new OrdCompraDet();
                    detOCompra.setId(detOCompraId);
                    detOCompra.setMtArticulos((MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase()));
                    //detOCompra.setCodArticulo(model.getValueAt(i, 0).toString());
                    detOCompra.setCantidad(Integer.parseInt(model.getValueAt(i, 2).toString()));
                    detOCompra.setPrecioUnitario(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
                    detOCompra.setSubtotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 4).toString())));
                    detOCompra.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
                    detOCompra.setImporteIva(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 6).toString())));
                    detOCompra.setPorcDto(Integer.parseInt(model.getValueAt(i, 7).toString()));
                    detOCompra.setImpDescuento(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));
                    detOCompra.setTotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 9).toString())));
                    detOCompra.setAccionMod(accion);
                    detOCompra.setUsuarioMod(usuario);
                    detOCompra.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detOCompra.setOrdenCompra(a);
                    st.save(detOCompra);
                }
//                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
//                    OrdCompraDetId detOCompraId = new OrdCompraDetId(numeroOrden, i);
//                    System.out.println("voy a editar: " + detOCompraId);
//                    
//                    OrdCompraDet detOCompra = (OrdCompraDet) st.load(OrdCompraDet.class, detOCompraId);
//                    detOCompra.setCodArticulo(model.getValueAt(i, 0).toString());
//                    detOCompra.setCantidad(Integer.parseInt(model.getValueAt(i, 2).toString()));
//                    detOCompra.setPrecioUnitario(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
//                    detOCompra.setSubtotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 4).toString())));
//                    detOCompra.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
//                    detOCompra.setImporteIva(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 6).toString())));
//                    detOCompra.setPorcDto(Integer.parseInt(model.getValueAt(i, 7).toString()));
//                    detOCompra.setImpDescuento(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));
//                    detOCompra.setTotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 9).toString())));
//                    detOCompra.setAccionMod(accion);
//                    detOCompra.setUsuarioMod(usuario);
//                    detOCompra.setFechaMod(UtilidadesCalendario.FechaHoraActual());
//                    detOCompra.setOrdenCompra(a);
//                    st.update(detOCompra);
//                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro actualizado.");
                arranque();                
            }
            catch(org.hibernate.NonUniqueObjectException e){
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n" +
                            "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(org.hibernate.PropertyValueException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "Existe un valor nulo. No es posible guardar el registro " + "\n" +
                            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e) {
                st.getTransaction().rollback();
                st.clear();
                
                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado. No es posible guardar el registro " + "\n" +
                            e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void anexarTabla() {
        if (this.articulo == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado el artículo. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else if (this.txtCantidadF.getValue() == null || this.txtPrecioUnitarioF.getValue() == null ||
                this.txtPorcDescuentoF.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else {
            verificar();
            if(var>=1){
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Artículo ya Agregado. Desea reemplazar los datos?.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
                if(showConfirmDialog==0){
                    model.setValueAt(this.txtCantidadF.getValue(), idArti, 2);
                    model.setValueAt(this.txtPrecioUnitarioF.getValue(), idArti, 3);
                    model.setValueAt(this.txtSubtotalF.getValue(), idArti, 4);
                    model.setValueAt(this.txtPorcIvaF.getValue(), idArti, 5);
                    model.setValueAt(this.txtIvaF.getValue(), idArti, 6);
                    model.setValueAt(this.txtPorcDescuentoF.getValue(), idArti, 7);
                    model.setValueAt(this.txtDescuentoF.getValue(), idArti, 8);
                    model.setValueAt(this.txtTotalF.getValue(), idArti, 9);
                    calcularTotalFactura();
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
                    this.txtCantidadF.getValue(),
                    //Integer.valueOf(this.txtCantidad.getText()),
                    this.txtPrecioUnitarioF.getValue(),
                    //Double.valueOf(this.txtPrecioUnitario.getText()).doubleValue(),
                    this.txtSubtotalF.getValue(),
                    //Double.valueOf(this.txtSubtotal.getText()),
                    this.txtPorcIvaF.getValue(),
                    //Integer.valueOf(this.txtPorcIva.getText()),
                    this.txtIvaF.getValue(),
                    //Double.valueOf(this.txtIVA.getText()),
                    this.txtPorcDescuentoF.getValue(),
                    //Integer.valueOf(this.txtPorcDescuento.getText()),
                    this.txtDescuentoF.getValue(),
                    //Double.valueOf(this.txtDescuento.getText()),
                    this.txtTotalF.getValue()
                    //Double.valueOf(this.txtTotal.getText())
                });                    
                calcularTotalFactura();
                limpiarArticulos(); 
             }
        }
    }
    
    public void verificar(){
        //Método para verificar que no se duplique el mismo artículo en la tabla,
        //para ello se comprueba el id del artículo.
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
    
    public void calcularTotalFactura(){
        //Método para calcular el total de la compra, obteniendo datos del jtable.
        double totalG = 0;
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            totalG += Double.parseDouble(model.getValueAt(i, 9).toString());
        }
        this.txtTotalFacturaF.setValue(totalG);
    }
    
    public void sumarRepetido(){
        //Si se repite el ingreso de un artículo específico,se puede obtar por sumar la cantidad de compra,
        //este método localizar el id del artículo específico y aumenta la cantidad de la
        //compra sumandola.
        int artCant = Integer.parseInt(this.txtCantidadF.getValue().toString());
        int artTotal = Integer.parseInt(this.txtTotalF.getValue().toString());
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
        this.txtCantidadF.setValue(null);
        this.txtPrecioUnitarioF.setValue(null);   
        this.txtSubtotalF.setValue(null);
        this.txtPorcIvaF.setValue(null);
        this.txtIvaF.setValue(null);
        this.txtPorcDescuentoF.setValue(null);
        this.txtDescuentoF.setValue(null);
        this.txtTotalF.setValue(null);
        this.btnBorrar.setEnabled(false);
        this.txtCodArticulo.requestFocus();
        this.deboBuscarArticulo = true;
        this.articulo = null;
    }
    
    private String fechaString(Date fecha){
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
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            this.txtCodArticulo.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtDescArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
            //this.txtCantidad.setText(model.getValueAt(filaSeleccionada, 2).toString());
            this.txtCantidadF.setValue(model.getValueAt(filaSeleccionada, 2));
            //this.txtPrecioUnitario.setText(model.getValueAt(filaSeleccionada, 3).toString());
            this.txtPrecioUnitarioF.setValue(model.getValueAt(filaSeleccionada, 3));
            //this.txtSubtotal.setText(model.getValueAt(filaSeleccionada, 4).toString());
            this.txtSubtotalF.setValue(model.getValueAt(filaSeleccionada, 4));
            //this.txtPorcDescuento.setText(model.getValueAt(filaSeleccionada, 7).toString());
            this.txtPorcDescuentoF.setValue(model.getValueAt(filaSeleccionada, 7));
            //this.txtDescuento.setText(model.getValueAt(filaSeleccionada, 8).toString());
            this.txtDescuentoF.setValue(model.getValueAt(filaSeleccionada, 8));
            //this.txtTotal.setText(model.getValueAt(filaSeleccionada, 9).toString());
            this.txtTotalF.setValue(model.getValueAt(filaSeleccionada, 9));
            //this.txtPorcIva.setText(model.getValueAt(filaSeleccionada, 5).toString());
            this.txtPorcIvaF.setValue(model.getValueAt(filaSeleccionada, 5));
            //this.txtIVA.setText(model.getValueAt(filaSeleccionada, 6).toString());
            this.txtIvaF.setValue(model.getValueAt(filaSeleccionada, 6));
            this.txtCodArticulo.setEditable(false);
            this.txtCantidadF.requestFocus();
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
            parametros.put("pnro_ocompra", Integer.parseInt(this.txtNroOCompra.getText()));
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
}