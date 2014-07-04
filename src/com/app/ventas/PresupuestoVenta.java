package com.app.ventas;

import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtClientes;
import com.entidades.MtSucursales;
import com.entidades.MtUsuarios;
import com.entidades.MtComprobantes;
import com.entidades.MtMonedas;
import com.entidades.MtTipoComprobantes;
import com.entidades.PresupuestoCab;
import com.entidades.PresupuestoDet;
import com.entidades.PresupuestoDetId;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
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

public class PresupuestoVenta extends javax.swing.JDialog {
    public PresupuestoVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Presupuesto de Venta - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();   
    }
    
    public PresupuestoVenta (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Presupuesto de Venta - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private final String usuario;
    private final String formulario;
    
    private int var, idArti, filaSeleccionada, posicion, cant_decimales, nro_trans;
    private BigDecimal totalGeneral, totalExenta, totalGravada, totalIva, total10, total5, unitarioMn;
    
    private MtClientes objCliente;
    private MtArticulos objArticulo;
    private MtUsuarios objUsuario;
    private MtSucursales objSucursal;
    private MtComprobantes objComprobante;
    private MtMonedas objMoneda;
    private List<Object> ArrayPrimaryKey;


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroPresup = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtNomCliente = new javax.swing.JTextField();
        txtCodSucursal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescSucursal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCodMoneda = new javax.swing.JTextField();
        txtDescMoneda = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTipoCambio = new javax.swing.JFormattedTextField();
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
        btnBorrarLinea = new javax.swing.JButton();
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

        txtNroPresup.setBackground(new java.awt.Color(255, 255, 204));
        txtNroPresup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPresupKeyTyped(evt);
            }
        });

        jLabel12.setText("Cliente");

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtFecha.setToolTipText("Fecha en formato dd/mm/aaaa");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "A", "F", " " }));

        jLabel8.setText("Activo");

        txtCodCliente.setToolTipText("Código del proveedor. F9 para buscar");
        txtCodCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusLost(evt);
            }
        });
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyTyped(evt);
            }
        });

        txtNomCliente.setEditable(false);
        txtNomCliente.setBackground(new java.awt.Color(204, 255, 204));
        txtNomCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomCliente.setFocusable(false);

        txtCodSucursal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodSucursalFocusLost(evt);
            }
        });
        txtCodSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodSucursalKeyReleased(evt);
            }
        });

        jLabel1.setText("Sucursal");

        txtDescSucursal.setEditable(false);
        txtDescSucursal.setBackground(new java.awt.Color(204, 255, 204));
        txtDescSucursal.setFocusable(false);

        jLabel15.setText("Moneda");

        txtCodMoneda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodMonedaFocusLost(evt);
            }
        });
        txtCodMoneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodMonedaKeyReleased(evt);
            }
        });

        txtDescMoneda.setEditable(false);
        txtDescMoneda.setBackground(new java.awt.Color(204, 255, 204));
        txtDescMoneda.setFocusable(false);

        jLabel17.setText("T.C.");

        txtTipoCambio.setEditable(false);
        txtTipoCambio.setBackground(new java.awt.Color(204, 255, 204));
        txtTipoCambio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtTipoCambio.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTipoCambio.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroPresup, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtCodSucursal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNroPresup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtCodMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripción", "Cantidad", "Precio Unitario", "Subtotal", "% IVA", "Importe IVA", "% Desto.", "Descuento", "Total", "UnitarioMn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setMinWidth(0);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

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

        txtPrecioUnitarioF.setEditable(false);
        txtPrecioUnitarioF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPrecioUnitarioF.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPrecioUnitarioF.setFocusable(false);
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

        btnBorrarLinea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBorrarLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/quitar.png"))); // NOI18N
        btnBorrarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarLineaActionPerformed(evt);
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
                        .addComponent(btnBorrarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnBorrarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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
        guardar();
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
        }
    }//GEN-LAST:event_txtCodArticuloKeyReleased

    private void txtCodClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigoProv;
                Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de proveedor", "mt_proveedores",
                        "nro_docum", "nom_tit");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigoProv = formBusqueda.getCodigo();
                if (codigoProv != null) {
                    this.txtCodCliente.setText(codigoProv);
                    this.txtCodCliente.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (this.txtCodCliente.getText().length() > 0) {
                    this.txtCodCliente.transferFocus();
                } else {

                }
            }
        }
    }//GEN-LAST:event_txtCodClienteKeyReleased

    private void txtCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusLost
        if (!this.txtCodCliente.getText().isEmpty()) {
            recuperarCliente(this.txtCodCliente.getText());
        } else {
        }
    }//GEN-LAST:event_txtCodClienteFocusLost

    private void txtCodArticuloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArticuloFocusLost
        if (!this.txtCodArticulo.getText().isEmpty()) {
                recuperarArticulo(this.txtCodArticulo.getText());
                if (objArticulo != null) {
                    BigDecimal tipoDeCambio = (BigDecimal) this.txtTipoCambio.getValue();
                    this.txtDescArticulo.setText(objArticulo.getNomArticulo());
                    unitarioMn = objArticulo.getPrecioVenta();
                    BigDecimal precioUnit = unitarioMn.divide(tipoDeCambio, cant_decimales, RoundingMode.HALF_UP);
                    BigDecimal impuesto = new BigDecimal(objArticulo.getImpuesto());
                    impuesto = impuesto.add(new BigDecimal("100"));
                    impuesto = impuesto.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
                    unitarioMn = unitarioMn.multiply(impuesto);
                    BigDecimal precioUnitarioIva = precioUnit.multiply(impuesto);
                    this.txtPrecioUnitarioF.setValue(precioUnitarioIva);
                    this.txtPorcIvaF.setValue(objArticulo.getImpuesto());
                    this.txtPorcDescuentoF.setValue(0);
                }
        } else {
            
        }
    }//GEN-LAST:event_txtCodArticuloFocusLost

    private void txtCodClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyTyped
        char car = evt.getKeyChar();
        if (car >= '0' && car <= '9') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodClienteKeyTyped

    private void btnBorrarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarLineaActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Desea eliminar la fila seleccionada?", "Corfirmacion",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirma == 0) {
            model.removeRow(filaSeleccionada);
            calcularTotalFactura();
            limpiarArticulos();
            this.txtCodArticulo.setEditable(true);
            this.txtCodArticulo.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnBorrarLineaActionPerformed

    private void txtNroPresupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPresupKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroPresupKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!accion.equalsIgnoreCase("Buscar")) {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png")));
            arranque();
            this.accion = "Buscar";
            this.txtCodCliente.setEditable(true);
            this.txtNroPresup.setEditable(true);
            this.txtNroPresup.requestFocus();
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
            this.txtCantidadF.requestFocusInWindow();
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

    private void txtCodSucursalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSucursalKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigo;
                Busqueda formBusqueda = new Busqueda(this, true, "Sucursales", "mt_sucursales",
                        "cod_sucursal", "nom_sucursal");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigo = formBusqueda.getCodigo();
                if (codigo != null) {
                    this.txtCodSucursal.setText(codigo);
                    this.txtCodSucursal.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (this.txtCodSucursal.getText().length() > 0) {
                    this.txtCodSucursal.transferFocus();
                } else {
                }
            }
        }
    }//GEN-LAST:event_txtCodSucursalKeyReleased

    private void txtCodMonedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMonedaKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigo;
                Busqueda formBusqueda = new Busqueda(this, true, "Monedas", "mt_monedas",
                        "cod_moneda", "nom_moneda");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigo = formBusqueda.getCodigo();
                if (codigo != null) {
                    this.txtCodMoneda.setText(codigo);
                    this.txtCodMoneda.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (this.txtCodMoneda.getText().length() > 0) {
                    this.txtCodMoneda.transferFocus();
                } else {
                }
            }
        }
    }//GEN-LAST:event_txtCodMonedaKeyReleased

    private void txtCodSucursalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodSucursalFocusLost
        objSucursal = recuperarSucursal(this.txtCodSucursal.getText());
        this.txtDescSucursal.setText(objSucursal.getNomSucursal());
    }//GEN-LAST:event_txtCodSucursalFocusLost

    private void txtCodMonedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMonedaFocusLost
        if (!this.txtCodMoneda.getText().isEmpty()) {
            try {
                objMoneda = recuperarMoneda(Integer.parseInt(this.txtCodMoneda.getText()));
                this.txtDescMoneda.setText(objMoneda.getNomMoneda());
                try {
                    Cargar cargar = new Cargar();
                    BigDecimal tipoCambio = cargar.buscarTipoCambio(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime(),
                            objMoneda.getCodMoneda(), 'V');
                    this.txtTipoCambio.setValue(tipoCambio);
                    if (objMoneda.getCodMoneda() == 1) {
                        cant_decimales = 0;
                    } else {
                        cant_decimales = 2;
                    }
                    reCalcularLinea();
                    calcularTotalFactura();
                } catch (Exception e) {
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo recuperar la moneda, por favor verifique." + "\n"
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCodMoneda.requestFocusInWindow();
            }

        } else {
            this.txtCodMoneda.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCodMonedaFocusLost


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
            java.util.logging.Logger.getLogger(PresupuestoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PresupuestoVenta dialog = new PresupuestoVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBorrarLinea;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodMoneda;
    private javax.swing.JTextField txtCodSucursal;
    private javax.swing.JTextField txtDescArticulo;
    private javax.swing.JTextField txtDescMoneda;
    private javax.swing.JTextField txtDescSucursal;
    private javax.swing.JFormattedTextField txtDescuentoF;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaMod;
    private javax.swing.JFormattedTextField txtIvaF;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroPresup;
    private javax.swing.JFormattedTextField txtPorcDescuentoF;
    private javax.swing.JFormattedTextField txtPorcIvaF;
    private javax.swing.JFormattedTextField txtPrecioUnitarioF;
    private javax.swing.JFormattedTextField txtSubtotalF;
    private javax.swing.JFormattedTextField txtTipoCambio;
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
        this.txtNroPresup.setEditable(false);
        this.txtNroPresup.setText("");
        this.txtFecha.setEditable(false);
        this.txtFecha.setText("");        
        this.cmbEstado.setEnabled(false);       
        this.txtCodCliente.setEditable(false);
        this.txtCodCliente.setText("");        
        this.txtNomCliente.setText("");
        this.txtTotalFacturaF.setValue(0);
        this.txtCodSucursal.setEditable(false);
        this.txtCodSucursal.setText("");        
        this.txtDescSucursal.setText("");
        this.txtCodMoneda.setEditable(false);
        this.txtCodMoneda.setText("");
        this.txtDescMoneda.setText("");
        this.txtTipoCambio.setValue(null);
        
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
        //Seteamos el estado de los botones
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.btnBorrarLinea.setEnabled(false);
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
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);       // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);      // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);      // cantidad
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);      // precio unitario
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);      // subtotal
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);      // porc iva
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);      // iva
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);      // porc dto
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);      // descuento
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(85);      // total
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        MtUsuarios unObjUsuario = (MtUsuarios) st.get(MtUsuarios.class, cod_usuario);
        return unObjUsuario;
    }
    
    private MtSucursales recuperarSucursal(String cod_sucursal) {
        MtSucursales unObjSucursal = (MtSucursales) st.get(MtSucursales.class, cod_sucursal);
        return unObjSucursal;
    }   
    
    private MtMonedas recuperarMoneda(Integer codigo) {
        MtMonedas unObjeto = (MtMonedas) st.get(MtMonedas.class, codigo);
        return unObjeto;
    }    
    
    private MtComprobantes recuperarComprobante(String cod_sucursal) {
        MtComprobantes unObjComprobante = null;
        try {
            String query = "select * from mt_comprobantes where tipo_docum = 'PR' and cod_sucursal = :sucursal";
            SQLQuery consulta = st.createSQLQuery(query);
            consulta.addEntity(MtComprobantes.class);
            consulta.setParameter("sucursal", cod_sucursal);
            unObjComprobante = (MtComprobantes) consulta.uniqueResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar el numero de presupuesto." + "\n"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return unObjComprobante;
    }
    
    private void buscar() {
        String SqlQuery = "select nro_trans from presupuesto_cab where nro_trans > 0";
        if (!this.txtNroPresup.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and nro_presupuesto = " + this.txtNroPresup.getText();
        }
        if (!this.txtCodCliente.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_tit = " + this.txtCodCliente.getText();
        }
        if (this.txtFecha.getText().trim().length() == 10) {
            SqlQuery = SqlQuery + " and fecha = " + this.txtFecha.getText();
        }
        SqlQuery = SqlQuery + " order by nro_presupuesto";
        
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
        int nroTrans = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        PresupuestoCab cabecera = (PresupuestoCab) st.load(PresupuestoCab.class, nroTrans);
        this.nro_trans = cabecera.getNroTrans();
        this.txtUsuario.setText(cabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaMod.setValue(cabecera.getFechaMod());
        this.txtNroPresup.setText(nroOrdenf.format(cabecera.getNroPresupuesto()));
        this.txtFecha.setValue(cabecera.getFecha());
        this.txtCodCliente.setText(cabecera.getMtClientes().getCodTit());
        this.txtTotalFacturaF.setValue(cabecera.getTotal());
        this.cmbEstado.setSelectedItem(String.valueOf(cabecera.getEstado()));
        this.txtCodSucursal.setText(cabecera.getMtSucursales().getCodSucursal());
        this.txtCodMoneda.setText(String.valueOf(cabecera.getMtMonedas().getCodMoneda()));
        this.txtTipoCambio.setValue(cabecera.getTipoCambio());
        
        recuperarCliente(cabecera.getMtClientes().getCodTit());
        recuperarDetalle(cabecera.getNroTrans());
        this.objMoneda = cabecera.getMtMonedas();
        this.txtDescMoneda.setText(objMoneda.getNomMoneda());
        this.objSucursal = cabecera.getMtSucursales();
        this.txtDescSucursal.setText(objSucursal.getNomSucursal());
    }
    
    private void recuperarDetalle(int trans) {
        Query consulta = st.createQuery("From PresupuestoDet a JOIN a.id b WHERE b.nroTrans = :nroTransQ order by a.linea");
        consulta.setParameter("nroTransQ", trans);
        List<PresupuestoDet> detalles = (List<PresupuestoDet>)consulta.list();
        model.setNumRows(0);
        for (PresupuestoDet detalle : detalles) {
            recuperarArticulo(detalle.getId().getCodArticulo());
            model.addRow(new Object[]{
                detalle.getId().getCodArticulo(),
                this.objArticulo.getNomArticulo(),
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getSubtotal(),
                detalle.getPorcIva(),
                detalle.getImporteIva(),
                detalle.getPorcDto(),
                detalle.getImpDescuento(),
                detalle.getTotal(),
                detalle.getPrecioUnitarioMn()
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
    
    public void nuevo() {
        arranque();
        //Seteamos la accion
        accion = "Nuevo";
        nro_trans = Integer.parseInt(st.createSQLQuery("select nextval('nro_trans_seq');").uniqueResult().toString());

        //Los componentes editables
        this.txtCodCliente.setEditable(true);
        this.cmbEstado.setEnabled(true);
        this.cmbEstado.setSelectedIndex(0);
        this.txtNroPresup.setEditable(false);
        this.txtFecha.setEditable(true);
        this.txtFecha.setText(UtilidadesCalendario.FechaActualString());
        this.txtCodMoneda.setEditable(true);
        //Detalle
        this.txtCodArticulo.setEditable(true);
        this.txtCantidadF.setEditable(true);
        this.txtPrecioUnitarioF.setEditable(false);
        this.txtSubtotalF.setEditable(false);
        this.txtIvaF.setEditable(false);
        this.txtPorcDescuentoF.setEditable(true);
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

        //Inicializamos
        this.txtFechaMod.setValue(new Date());
        objUsuario = recuperarUsuario(usuario);
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(objUsuario.getNomUsuario());
        objSucursal = recuperarSucursal(objUsuario.getMtSucursales().getCodSucursal());
        this.txtCodSucursal.setText(objSucursal.getCodSucursal());
        this.txtDescSucursal.setText(objSucursal.getNomSucursal());
        objComprobante = recuperarComprobante(objSucursal.getCodSucursal());
        if (objComprobante == null) {
            JOptionPane.showMessageDialog(null, "No se pudo recuperar el numero de presupuesto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.txtNroPresup.setText(objComprobante.getNroFactura().toString());
        }

        this.txtCodCliente.requestFocus();
        this.cmbEstado.setEnabled(false);
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        
        //Los componentes editables
        this.txtCodCliente.setEditable(true);
        this.cmbEstado.setEnabled(true);
        this.txtFecha.setEditable(true); 
        
        this.txtCodArticulo.setEditable(true);   
        this.txtCantidadF.setEditable(true);       
        this.txtPrecioUnitarioF.setEditable(false);
        this.txtSubtotalF.setEditable(false); 
        this.txtIvaF.setEditable(false);
        this.txtPorcDescuentoF.setEditable(true);
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
        this.txtCodArticulo.requestFocusInWindow();
    }
    
    public void eliminar() {
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);
        if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            //arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        } else {//Opción eliminar seleccionada
            st.beginTransaction();
            Integer nroTrans = this.nro_trans;
            PresupuestoCab cabecera = (PresupuestoCab) st.load(PresupuestoCab.class, nroTrans);

            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                PresupuestoDetId detalleId = new PresupuestoDetId(nroTrans, model.getValueAt(i, 0).toString());
                PresupuestoDet detalle = (PresupuestoDet) st.load(PresupuestoDet.class, detalleId);
                st.delete(detalle);
            }
            st.delete(cabecera);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro eliminado.");
            arranque();
        }
    }
    
    private void recuperarCliente(String codigo) {
        String consulta = "From MtClientes Where nroDocum = :nro_docum";
        Query query = st.createQuery(consulta);
        query.setParameter("nro_docum", codigo);
        this.objCliente = (MtClientes) query.uniqueResult();
        if (objCliente != null) {
            this.txtNomCliente.setText(objCliente.getNomTit());
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodCliente.requestFocus();
        }
    }
    
    private void recuperarArticulo(String codArticulo) {
        this.objArticulo = (MtArticulos) st.get(MtArticulos.class, codArticulo.toUpperCase());
        if (objArticulo != null) {
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del producto", "Error", JOptionPane.ERROR_MESSAGE);
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
            pPorcDescuento = pPorcDescuento.divide(new BigDecimal("100"), MathContext.DECIMAL32).setScale(4, RoundingMode.HALF_UP);
        }
        if (this.txtPorcIvaF.getValue() != null) {
            pPorcIva = new BigDecimal(this.txtPorcIvaF.getValue().toString());
        }

        montoSubtotal = pUnitario.multiply(pCantidad);
        montoDescuento = montoSubtotal.multiply(pPorcDescuento);
        montoTotal = montoSubtotal.subtract(montoDescuento);
        auxiliarIva1 = montoTotal.multiply(pPorcIva);
        ivaCompuesto = pPorcIva.add(new BigDecimal("100"));
        montoIva = auxiliarIva1.divide(ivaCompuesto, MathContext.DECIMAL32).setScale(cant_decimales, RoundingMode.HALF_UP);

        this.txtSubtotalF.setValue(montoSubtotal);
        this.txtDescuentoF.setValue(montoDescuento);
        this.txtTotalF.setValue(montoTotal);
        this.txtIvaF.setValue(montoIva);
    }
    
    private void reCalcularLinea() {
        if (this.jTable1.getRowCount() > 0) {
            BigDecimal tipoCambio = (BigDecimal) this.txtTipoCambio.getValue();
            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                BigDecimal pCantidad = new BigDecimal(model.getValueAt(i, 2).toString());
                BigDecimal pUnitario = new BigDecimal(model.getValueAt(i, 10).toString());
                pUnitario = pUnitario.divide(tipoCambio, cant_decimales, RoundingMode.HALF_UP);
                BigDecimal pPorcDescuento = new BigDecimal(model.getValueAt(i, 7).toString());
                pPorcDescuento = pPorcDescuento.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
                BigDecimal pPorcIva = new BigDecimal(model.getValueAt(i, 5).toString());

                BigDecimal montoSubtotal = pUnitario.multiply(pCantidad);
                BigDecimal montoDescuento = montoSubtotal.multiply(pPorcDescuento);
                BigDecimal montoTotal = montoSubtotal.subtract(montoDescuento);
                BigDecimal auxiliarIva1 = montoTotal.multiply(pPorcIva);
                BigDecimal ivaCompuesto = pPorcIva.add(new BigDecimal("100"));
                BigDecimal montoIva = auxiliarIva1.divide(ivaCompuesto, cant_decimales, RoundingMode.HALF_UP);

                model.setValueAt(pUnitario, i, 3);
                model.setValueAt(montoSubtotal, i, 4);
                model.setValueAt(montoIva, i, 6);
                model.setValueAt(montoDescuento, i, 8);
                model.setValueAt(montoTotal, i, 9);
            }
        }
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

    public void guardar(){
        int rowCount = this.jTable1.getRowCount();
        if(this.txtCodCliente.getText().isEmpty()){
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
                PresupuestoCab cabecera = new PresupuestoCab();
                Integer nroPresup = Integer.parseInt(this.txtNroPresup.getText());

                cabecera.setNroTrans(this.nro_trans);
                cabecera.setNroPresupuesto(nroPresup);
                cabecera.setMtClientes(objCliente);
                cabecera.setMtSucursales(objSucursal);
                cabecera.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                cabecera.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                cabecera.setMtTipoComprobantes((MtTipoComprobantes) st.load(MtTipoComprobantes.class, "PR"));
                cabecera.setMtMonedas(objMoneda);
                cabecera.setTipoCambio((BigDecimal) this.txtTipoCambio.getValue());
                cabecera.setTotal(totalGeneral);
                cabecera.setGravada(totalGravada);
                cabecera.setExenta(totalExenta);
                cabecera.setTotalIva(totalIva);
                cabecera.setIva10(total10);
                cabecera.setIva5(total5);
                cabecera.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                cabecera.setAccionMod(accion);
                cabecera.setUsuarioMod(usuario);
                cabecera.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                st.saveOrUpdate(cabecera);
                
                if ("Editar".equalsIgnoreCase(this.accion)) {
                    Query consulta = st.createQuery("From PresupuestoDet a JOIN a.id b WHERE b.nroTrans = :nroTransQ order by a.linea");
                    consulta.setParameter("nroTransQ", this.nro_trans);
                    List<PresupuestoDet> detalles = (List<PresupuestoDet>) consulta.list();
                    for (PresupuestoDet detalle : detalles) {
                        st.delete(detalle);
                    }
                }

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    objArticulo = (MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase());
                    PresupuestoDetId detalleId = new PresupuestoDetId(this.nro_trans, objArticulo.getCodArticulo());
                    
                    PresupuestoDet detalle = new PresupuestoDet();
                    detalle.setId(detalleId);
                    detalle.setNroPresupuesto(nroPresup);
                    detalle.setLinea(i);
                    detalle.setPrecioUnitarioMn(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
                    detalle.setCodMoneda(objMoneda.getCodMoneda());
                    detalle.setTipoCambio((BigDecimal) this.txtTipoCambio.getValue());
                    detalle.setPrecioUnitario(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
                    detalle.setCantidad(Integer.parseInt(model.getValueAt(i, 2).toString()));                    
                    detalle.setSubtotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 4).toString())));
                    detalle.setPorcDto(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 7).toString())));
                    detalle.setImpDescuento(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));
                    detalle.setTotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 9).toString())));
                    detalle.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
                    detalle.setImporteIva(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 6).toString())));
                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detalle.setPresupuestoCab(cabecera);
                    st.saveOrUpdate(detalle);
                }
                if("Nuevo".equalsIgnoreCase(accion)){
                    Integer actualNro = objComprobante.getNroFactura();
                    actualNro = actualNro + 1;
                    objComprobante.setNroFactura(actualNro);
                    st.update(objComprobante);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                //informe();
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
        if (this.objArticulo == null) {
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
                    model.setValueAt(this.unitarioMn, idArti, 10);
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
                    this.objArticulo.getCodArticulo(),
                    this.objArticulo.getNomArticulo(),
                    this.txtCantidadF.getValue(),
                    this.txtPrecioUnitarioF.getValue(),
                    this.txtSubtotalF.getValue(),
                    this.txtPorcIvaF.getValue(),
                    this.txtIvaF.getValue(),
                    this.txtPorcDescuentoF.getValue(),
                    this.txtDescuentoF.getValue(),
                    this.txtTotalF.getValue(),
                    this.unitarioMn
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
        totalGeneral = BigDecimal.ZERO;
        totalExenta = BigDecimal.ZERO;
        totalGravada = BigDecimal.ZERO;
        totalIva = BigDecimal.ZERO;
        total10 = BigDecimal.ZERO;
        total5 = BigDecimal.ZERO;
        
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            Object vTotal = model.getValueAt(i, 9); 
            Object vPIva = model.getValueAt(i, 5); 
            Object vMIva = model.getValueAt(i, 6); 
            
            if (Integer.parseInt(vPIva.toString()) == 0) {
                totalExenta = totalExenta.add(BigDecimal.valueOf(Double.parseDouble(vTotal.toString())));
            } else if (Integer.parseInt(vPIva.toString()) == 5) {
                Double vGrav = Double.parseDouble(vTotal.toString()) - Double.parseDouble(vMIva.toString());
                total5 = total5.add(BigDecimal.valueOf(Double.parseDouble(vMIva.toString())));
                totalGravada = totalGravada.add(BigDecimal.valueOf(vGrav));
            } else if (Integer.parseInt(vPIva.toString()) == 10) {
                Double vGrav = Double.parseDouble(vTotal.toString()) - Double.parseDouble(vMIva.toString());
                total10 = total10.add(BigDecimal.valueOf(Double.parseDouble(vMIva.toString())));
                totalGravada = totalGravada.add(BigDecimal.valueOf(vGrav));
            }
        }
        totalIva = totalIva.add(total5);
        totalIva = totalIva.add(total10);
        totalGeneral = totalGeneral.add(totalExenta);
        totalGeneral = totalGeneral.add(totalGravada);
        totalGeneral = totalGeneral.add(totalIva);
        
        this.txtTotalFacturaF.setValue(totalGeneral);
    }
    
    public void sumarRepetido(){
        //Si se repite el ingreso de un artículo específico,se puede obtar por sumar la cantidad de compra,
        //este método localizar el id del artículo específico y aumenta la cantidad de la compra sumandola.
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
        this.btnBorrarLinea.setEnabled(false);
        this.txtCodArticulo.requestFocus();
        this.objArticulo = null;
    }
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            this.txtCodArticulo.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtDescArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
            this.txtCantidadF.setValue(model.getValueAt(filaSeleccionada, 2));
            this.txtPrecioUnitarioF.setValue(model.getValueAt(filaSeleccionada, 3));
            this.txtSubtotalF.setValue(model.getValueAt(filaSeleccionada, 4));
            this.txtPorcDescuentoF.setValue(model.getValueAt(filaSeleccionada, 7));
            this.txtDescuentoF.setValue(model.getValueAt(filaSeleccionada, 8));
            this.txtTotalF.setValue(model.getValueAt(filaSeleccionada, 9));
            this.txtPorcIvaF.setValue(model.getValueAt(filaSeleccionada, 5));
            this.txtIvaF.setValue(model.getValueAt(filaSeleccionada, 6));
            this.txtCodArticulo.setEditable(false);
            this.txtCantidadF.requestFocus();
            this.btnBorrarLinea.setEnabled(true);
        }
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            Map parametros = new HashMap();
            //parametros que enviamos al report.
            parametros.put("pnro_ocompra", Integer.parseInt(this.txtNroPresup.getText()));
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