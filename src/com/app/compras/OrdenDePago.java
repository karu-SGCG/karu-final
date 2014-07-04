package com.app.compras;

import com.app.mantenimiento.Articulos;
import com.entidades.Caja;
import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtCajeros;
import com.entidades.MtMonedas;
import com.entidades.MtProveedores;
import com.entidades.MtUsuarios;
import com.entidades.OrdenPago;
import com.entidades.OrdenPagoDet;
import com.entidades.OrdenPagoDetId;
import com.entidades.SaPendientes;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;
import util.Busqueda;
import util.UtilidadesCalendario;
import util.Cargar;

//@author Fausto Sanabria.

public class OrdenDePago extends javax.swing.JDialog {
    public OrdenDePago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Orden de Pago - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();   
    }
    
    public OrdenDePago (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Orden de Pago - KARU v1.0");
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
    private ArrayList<OrdenPagoDetId> articulosBorrados;
    private int cant_lineas;
    private MtUsuarios objUsuario;
    private MtCajeros objCajero;
    private Caja objCaja;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroOPago = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCodProveedor = new javax.swing.JTextField();
        txtNomProveedor = new javax.swing.JTextField();
        txtCodCaja = new javax.swing.JTextField();
        txtDescCaja = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodSucFac = new javax.swing.JTextField();
        txtCodTributFac = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAPagar = new javax.swing.JFormattedTextField();
        txtOrigen = new javax.swing.JFormattedTextField();
        txtSaldo = new javax.swing.JFormattedTextField();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        txtNroFactura = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFechaFac = new javax.swing.JFormattedTextField();
        txtFecVenc = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
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

        txtNroOPago.setBackground(new java.awt.Color(255, 255, 204));
        txtNroOPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroOPagoKeyTyped(evt);
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

        txtCodCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCajaFocusLost(evt);
            }
        });

        txtDescCaja.setEditable(false);
        txtDescCaja.setBackground(new java.awt.Color(204, 255, 204));
        txtDescCaja.setFocusable(false);

        jLabel9.setText("Caja");

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
                        .addComponent(txtNroOPago, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProveedor)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtDescCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel12, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNroOPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addContainerGap(110, Short.MAX_VALUE))
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
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod. Suc.", "Cod. Tribut.", "Nro Documento", "Fecha", "Vencimiento", "Moneda", "Importe Origen", "Saldo Doc.", "Importe a Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Cod. Suc.");

        jLabel6.setText("Monto Origen");

        jLabel7.setText("Saldo");

        jLabel11.setText("Monto a abonar");

        jLabel13.setText("Fecha Fac.");

        txtCodSucFac.setToolTipText("");
        txtCodSucFac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodSucFacFocusLost(evt);
            }
        });
        txtCodSucFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodSucFacKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodSucFacKeyTyped(evt);
            }
        });

        txtCodTributFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodTributFacKeyTyped(evt);
            }
        });

        jLabel16.setText("Cod. Tribut");

        txtAPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtAPagar.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtAPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAPagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAPagarFocusLost(evt);
            }
        });
        txtAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPagarKeyTyped(evt);
            }
        });

        txtOrigen.setEditable(false);
        txtOrigen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtOrigen.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtOrigen.setFocusable(false);

        txtSaldo.setEditable(false);
        txtSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtSaldo.setFocusable(false);

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

        txtNroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroFacturaActionPerformed(evt);
            }
        });

        jLabel15.setText("Nro. Factura");

        txtFechaFac.setEditable(false);
        txtFechaFac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        txtFecVenc.setEditable(false);

        jLabel5.setText("Vencimiento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodSucFac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodTributFac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtFechaFac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtFecVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodSucFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodTributFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(81, 81, 81))
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
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void txtCodSucFacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSucFacKeyReleased
        if ("Nuevoa".equals(accion) || "Editara".equals(accion)) {
            deboBuscarArticulo = false;
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigoArt;
                Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de articulos", "mt_articulos",
                        "cod_articulo", "nom_articulo");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigoArt = formBusqueda.getCodigo();
                if (codigoArt != null) {
                    this.txtCodSucFac.setText(codigoArt);
                }
            }
            deboBuscarArticulo = true;
        }
    }//GEN-LAST:event_txtCodSucFacKeyReleased

    private void txtCodProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveedorKeyReleased
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
            buscarDocumento(this.txtCodProveedor.getText());
        } else {

        }
    }//GEN-LAST:event_txtCodProveedorFocusLost

    private void txtCodSucFacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodSucFacFocusLost
        if (deboBuscarArticulo && !this.txtCodSucFac.getText().isEmpty()) {
            if (this.articulo == null) {
                //recuperarArticulo();
            }
            else if (!articulo.getCodArticulo().equalsIgnoreCase(this.txtCodSucFac.getText())) {
                //recuperarArticulo();
            }
        } else {
        }
    }//GEN-LAST:event_txtCodSucFacFocusLost

    private void txtCodProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProveedorKeyTyped
        char car = evt.getKeyChar();
        if (car >= '0' && car <= '9') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodProveedorKeyTyped

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Desea eliminar la fila seleccionada?", "Corfirmacion",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirma == 0) {
            if ("Editar".equalsIgnoreCase(accion)) {
                OrdenPagoDetId idLineaEliminada = new OrdenPagoDetId(Integer.parseInt(this.txtNroOPago.getText()), filaSeleccionada);
                articulosBorrados.add(idLineaEliminada);
            }
            model.removeRow(filaSeleccionada);
            calcularTotalFactura();
            limpiarArticulos();
            this.txtCodSucFac.setEditable(true);
            this.txtCodSucFac.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNroOPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroOPagoKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroOPagoKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!accion.equalsIgnoreCase("Buscar")) {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png")));
            arranque();
            this.accion = "Buscar";
            this.txtCodProveedor.setEditable(true);
            this.txtNroOPago.setEditable(true);
            this.txtNroOPago.requestFocus();
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

    private void txtAPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAPagarFocusLost
        try {
            this.txtAPagar.commitEdit();
            if(Double.parseDouble(this.txtAPagar.getValue().toString()) > Double.parseDouble(this.txtSaldo.getValue().toString())){
            JOptionPane.showMessageDialog(null, "El monto a pagar no puede ser mayor al saldo.");
            this.txtAPagar.setValue(this.txtSaldo.getValue());
        }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "El importe ingresado no es correcto", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            this.txtAPagar.requestFocus();
        }
    }//GEN-LAST:event_txtAPagarFocusLost

    private void txtAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPagarKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9')) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtAPagarKeyTyped

    private void txtCodSucFacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSucFacKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') && txtCodSucFac.getText().length() < 3) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodSucFacKeyTyped

    private void txtCodTributFacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTributFacKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') && txtCodTributFac.getText().length() < 3) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodTributFacKeyTyped

    private void txtCodCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCajaFocusLost
        recuperarCaja(this.txtCodCaja.getText());
    }//GEN-LAST:event_txtCodCajaFocusLost

    private void txtNroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroFacturaActionPerformed

    private void txtAPagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAPagarFocusGained
        this.txtAPagar.selectAll();
    }//GEN-LAST:event_txtAPagarFocusGained


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
                OrdenDePago dialog = new OrdenDePago(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JFormattedTextField txtAPagar;
    private javax.swing.JTextField txtCodCaja;
    private javax.swing.JTextField txtCodProveedor;
    private javax.swing.JTextField txtCodSucFac;
    private javax.swing.JTextField txtCodTributFac;
    private javax.swing.JTextField txtDescCaja;
    private javax.swing.JFormattedTextField txtFecVenc;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaFac;
    private javax.swing.JFormattedTextField txtFechaMod;
    private javax.swing.JTextField txtNomProveedor;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroFactura;
    private javax.swing.JTextField txtNroOPago;
    private javax.swing.JFormattedTextField txtOrigen;
    private javax.swing.JFormattedTextField txtSaldo;
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
        this.txtNroOPago.setEditable(false);
        this.txtNroOPago.setText("");
        this.txtFecha.setEditable(false);
        this.txtFecha.setText("");        
        this.cmbEstado.setEnabled(false);       
        this.txtCodProveedor.setEditable(false);
        this.txtCodProveedor.setText("");        
        this.txtNomProveedor.setText("");
        this.txtTotalFacturaF.setValue(0);
        //this.txtCodMonedaPago.setText("");
        //this.txtCodMonedaPago.setEditable(false);
        //this.txtDescMonedaPago.setText("");
        //this.txtTipoCambio.setValue(null);
        //Detalle
        this.txtCodSucFac.setEditable(false);
        this.txtCodSucFac.setText("");    
        this.txtAPagar.setEditable(false);
        this.txtAPagar.setValue(null);        
        this.txtOrigen.setEditable(false);
        this.txtOrigen.setValue(null);            
        this.txtSaldo.setEditable(false);
        this.txtSaldo.setValue(null);
        this.txtCodTributFac.setText("");
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
        //this.txtCodMonedaPago.setVisible(false);
        //this.txtDescMonedaPago.setVisible(false);
        //this.txtTipoCambio.setVisible(false);
        defaultTableModel();
        //cargarTabla();
        this.jTable1.setEnabled(true);   
    }
    
    private void defaultTableModel(){
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);

        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);       // cod suc
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);      // cod tribut
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);      // numero
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);      // fecha
        this.jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);      // vencimiento
        this.jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);      // moneda
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);      // importe
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(120);      // saldo
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(120);      // a pagar
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);
    }
    
    private void buscarDocumento(String codProveedor) {
        String sqlComp = "select a.*"
                + " from sa_pendientes a inner join factura_compra b on a.nro_trans = b.nro_trans where a.cod_docum = 'FP'"
                + " and a.saldo <> 0 and b.estado = 'P' and a.cod_tit = :codProveedor";

        try {
            List<SaPendientes> retorno;

            //Ejecuto la consulta y el array resultante asigno a mi variable "retorno"
            SQLQuery consulta = st.createSQLQuery(sqlComp);
            consulta.addEntity(SaPendientes.class);
            
            consulta.setParameter("codProveedor", codProveedor);
            retorno = (List<SaPendientes>) consulta.list();
            
            if (retorno.size() > 0) {
                for (SaPendientes fila : retorno) {
                    model.addRow( new Object[] {
                        fila.getCodSucFac(), fila.getCodTributFac(), fila.getNroDocum(),
                        UtilidadesCalendario.DateAString(fila.getFecDoc()), 
                        UtilidadesCalendario.DateAString(fila.getVencimiento()),
                        fila.getCodMoneda(), fila.getImporteOrigen(), fila.getSaldo(), fila.getSaldo()
                    }
                    );
                }
                calcularTotalFactura();
            } else {
                JOptionPane.showMessageDialog(null, "El proveedor no posee documentos pendientes. ", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                    + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        objUsuario = (MtUsuarios) st.load(MtUsuarios.class, cod_usuario);
        return objUsuario;
    }
    
    private void buscar() {
        String SqlQuery = "select nro_opago from orden_pago where nro_opago > 0";
        if (!this.txtNroOPago.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and nro_opago = " + this.txtNroOPago.getText();
        }
        if (!this.txtCodProveedor.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_proveedor = " + this.txtCodProveedor.getText();
        }
        if (this.txtFecha.getText().trim().length() == 10) {
            SqlQuery = SqlQuery + " and fecha = " + this.txtFecha.getText();
        }
        SqlQuery = SqlQuery + " order by nro_opago";
        
        Query consulta = st.createSQLQuery(SqlQuery);
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
        OrdenPago ordenCabecera = (OrdenPago) st.load(OrdenPago.class, nroOrden);
        this.txtUsuario.setText(ordenCabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaMod.setValue(ordenCabecera.getFechaMod());
        this.txtNroOPago.setText(nroOrdenf.format(ordenCabecera.getNroOpago()));
        this.txtCodCaja.setText(ordenCabecera.getCaja().getCodCaja());
        this.txtFecha.setValue(ordenCabecera.getFecha());
        this.txtCodProveedor.setText(ordenCabecera.getMtProveedores().getNroDocum());
        this.txtTotalFacturaF.setValue(ordenCabecera.getTotal());
        this.cmbEstado.setSelectedItem(String.valueOf(ordenCabecera.getEstado()));
        
        recuperarProveedor();
        recuperarCaja(this.txtCodCaja.getText());
        recuperarDetalle(nroOrden);
    }
    
    private void recuperarDetalle(int orden) {
        Query consulta = st.createQuery("From OrdenPagoDet a JOIN a.id b WHERE b.nroOpago = :nroOrden order by b.linea");
        consulta.setParameter("nroOrden", orden);
        List<OrdenPagoDet> ordenesDetalle = (List<OrdenPagoDet>)consulta.list();
        model.setNumRows(0);
        for (OrdenPagoDet ordDetalle : ordenesDetalle) {
            model.addRow(new Object[]{
                ordDetalle.getCodSucFac(), 
                ordDetalle.getCodTributFac(), 
                ordDetalle.getNroFacturaProv(), 
                "",
                UtilidadesCalendario.DateAString(ordDetalle.getFecVto()), 
                1,
                ordDetalle.getSaldo(),
                ordDetalle.getSaldo(),
                ordDetalle.getImportePagado()
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
        this.txtCodProveedor.setEditable(true);
        this.txtCodProveedor.setText("");
        this.cmbEstado.setEnabled(true);
        this.cmbEstado.setSelectedIndex(0);
        this.txtNroOPago.setEditable(false);
        this.txtNroOPago.setText("");
        this.txtFecha.setEditable(true);
        this.txtFecha.setText(UtilidadesCalendario.FechaActualString());
        //this.txtCodMonedaPago.setEditable(true);
        //this.txtCodMonedaPago.setText("1");
        //recuperarMoneda(this.txtCodMonedaPago.getText());
        
        //Detalle
        this.txtCodSucFac.setEditable(true);
        this.txtCodSucFac.setText("");
        this.txtCodTributFac.setEditable(true);
        this.txtCodTributFac.setText("");          
        this.txtAPagar.setEditable(true);
        this.txtAPagar.setValue(null);   
        this.txtOrigen.setEditable(false);
        this.txtOrigen.setValue(null);
        this.txtSaldo.setEditable(false);
        this.txtSaldo.setValue(null);
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
        this.txtNroOPago.setText(obtenerID());      
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(recuperarUsuario(usuario).getNomUsuario());
        this.txtFechaMod.setValue(new Date());
        
        this.txtCodProveedor.requestFocus();
        this.cmbEstado.setEnabled(false);
        
        recuperarCajadeUsuario();
//        tipoDeCambio();
    }
    
    private void recuperarCajadeUsuario() {
        try {
            Cargar cargar = new Cargar();
            String consultaSql = "select * from mt_cajeros where cod_usuario = '" + usuario + "'";
            this.objCajero = (MtCajeros) cargar.resultadoUnico(consultaSql, MtCajeros.class);
            this.txtCodCaja.setText(this.objCajero.getCaja().getCodCaja());
            recuperarCaja(this.txtCodCaja.getText());
        } catch (Exception e) {
        }
    }
    
    private void recuperarCaja(String codCaja) {
        try {
            Cargar cargar = new Cargar();
            String consultaSql = "select * from caja where cod_caja = '" + codCaja + "'";
            this.objCaja = (Caja) cargar.resultadoUnico(consultaSql, Caja.class);
            this.txtDescCaja.setText(this.objCaja.getNomCaja());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar la descripcion de la caja. ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        private void recuperarMoneda(String codMoneda) {
        try {
            Cargar cargar = new Cargar();
            String consultaSql = "select * from mt_monedas where cod_moneda = " + codMoneda;
            MtMonedas objMoneda = (MtMonedas) cargar.resultadoUnico(consultaSql, MtMonedas.class);
            //this.txtDescMonedaPago.setText(objMoneda.getNomMoneda());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar la moneda. ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //private void tipoDeCambio(){
    //    try {
      //      Cargar cargar = new Cargar();
            //BigDecimal tc = cargar.buscarTipoCambio(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime(), 
               // Integer.parseInt(this.txtCodMonedaPago.getText()), 'V');
       // this.txtTipoCambio.setValue(tc);
        //} catch(Exception e) {
            
        //}
    //}
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        articulosBorrados = new ArrayList<>();
        cant_lineas = model.getRowCount();
        
        //Los componentes editables
        this.txtCodProveedor.setEditable(false);
        this.txtCodProveedor.setFocusable(false);
        this.cmbEstado.setEnabled(true);
        this.txtFecha.setEditable(true); 
        
        this.txtCodSucFac.setEditable(false);   
        this.txtAPagar.setEditable(true);
        this.txtOrigen.setEditable(false); 
        this.txtSaldo.setEditable(false); 
       
        
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
        try {
            int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.",
                    JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
            if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
                JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
                arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
            } else {//Opción eliminar seleccionada
                st.beginTransaction();
                Integer numeroOrden = Integer.parseInt(this.txtNroOPago.getText());
                OrdenPago a = (OrdenPago) st.load(OrdenPago.class, numeroOrden);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    OrdenPagoDetId detOCompraId = new OrdenPagoDetId(numeroOrden, i);
                    OrdenPagoDet detOCompra = (OrdenPagoDet) st.load(OrdenPagoDet.class, detOCompraId);

                    String sqlComp = "select * from sa_pendientes where cod_docum = 'FP' "
                            + " and cod_tit =  :cod_tit and cod_suc_fac = :cod_suc_fac"
                            + " and cod_tribut_fac = :cod_tribut_fac and nro_docum = :nro_docum";
                    SQLQuery consulta = st.createSQLQuery(sqlComp);
                    consulta.addEntity(SaPendientes.class);
                    consulta.setParameter("cod_tit", detOCompra.getCodProveedor());
                    consulta.setParameter("cod_suc_fac", detOCompra.getCodSucFac());
                    consulta.setParameter("cod_tribut_fac", detOCompra.getCodTributFac());
                    consulta.setParameter("nro_docum", detOCompra.getNroFacturaProv());
                    SaPendientes pendiente = (SaPendientes) consulta.uniqueResult();

                    BigDecimal saldo = pendiente.getSaldo();
                    BigDecimal pagado = detOCompra.getImportePagado();
                    BigDecimal saldo2 = saldo.add(pagado);

                    pendiente.setSaldo(saldo2);
                    st.update(pendiente);
                    st.delete(detOCompra);
                }
                st.delete(a);
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                arranque();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage(), accion, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void recuperarProveedor() {
        this.proveedor = (MtProveedores) st.get(MtProveedores.class, this.txtCodProveedor.getText());
        if (proveedor != null) {
            this.txtNomProveedor.setText(proveedor.getNomTit());
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodProveedor.requestFocus();
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
    
    private String obtenerID(){
        Integer newId;
        String retorno;
        retorno = null;
        try {
            String sql = "SELECT MAX(nroOpago) FROM OrdenPago";
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
        if (this.txtCodProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor.");
        } else if (this.cmbEstado.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado");
        } else if (this.txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        } else if (this.objCaja == null) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la caja.");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                OrdenPago cabecera = new OrdenPago();
                Integer numeroOrden = Integer.parseInt(this.txtNroOPago.getText());

                cabecera.setNroOpago(numeroOrden);
                cabecera.setCaja(objCaja);
                cabecera.setMtProveedores(proveedor);
                cabecera.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                cabecera.setNroCheque(0);
                cabecera.setTotal(BigDecimal.valueOf(Double.parseDouble(this.txtTotalFacturaF.getValue().toString())));
                cabecera.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                cabecera.setAccionMod(accion);
                cabecera.setUsuarioMod(usuario);
                cabecera.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                proveedor.getOrdenPagos().add(cabecera);
                st.save(cabecera);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    OrdenPagoDetId detOCompraId = new OrdenPagoDetId(numeroOrden, i);

                    OrdenPagoDet detalle = new OrdenPagoDet();
                    detalle.setId(detOCompraId);
                    detalle.setCodCaja(objCaja.getCodCaja());
                    detalle.setCodProveedor(this.txtCodProveedor.getText());

                    detalle.setCodSucFac(model.getValueAt(i, 0).toString());
                    detalle.setCodTributFac(model.getValueAt(i, 1).toString());
                    detalle.setNroFacturaProv(Integer.valueOf(model.getValueAt(i, 2).toString()));
                    detalle.setFecVto(UtilidadesCalendario.StringACalendario(model.getValueAt(i, 4).toString()).getTime());
                    detalle.setSaldo(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 7).toString())));
                    detalle.setImportePagado(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));

                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detalle.setOrdenPago(cabecera);
                    st.save(detalle);

                    String sqlComp = "select * from sa_pendientes where cod_docum = 'FP' "
                            + " and cod_tit =  :cod_tit and cod_suc_fac = :cod_suc_fac"
                            + " and cod_tribut_fac = :cod_tribut_fac and nro_docum = :nro_docum";
                    System.out.println(sqlComp);
                    SQLQuery consulta = st.createSQLQuery(sqlComp);
                    consulta.addEntity(SaPendientes.class);
                    consulta.setParameter("cod_tit", this.txtCodProveedor.getText());
                    consulta.setParameter("cod_suc_fac", model.getValueAt(i, 0));
                    consulta.setParameter("cod_tribut_fac", model.getValueAt(i, 1));
                    consulta.setParameter("nro_docum", model.getValueAt(i, 2));
                    SaPendientes pendiente = (SaPendientes) consulta.uniqueResult();
                    
                    BigDecimal saldo = new BigDecimal(model.getValueAt(i, 7).toString());
                    BigDecimal pagado = new BigDecimal(model.getValueAt(i, 8).toString());
                    BigDecimal saldo2 = saldo.subtract(pagado);
                    
                    pendiente.setSaldo(saldo2);
                    st.update(pendiente);
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
            } catch (HibernateException e) {
                st.getTransaction().rollback();
                st.clear();

                JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado[1]. No es posible guardar el registro " + "\n"
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
        if (this.txtCodProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor.");
        } else if (this.cmbEstado.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado");
        } else if (this.txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                Integer numeroOrden = Integer.parseInt(this.txtNroOPago.getText());
                OrdenPago cabecera = (OrdenPago) st.load(OrdenPago.class, numeroOrden);

                cabecera.setCaja(objCaja);
                cabecera.setMtProveedores(proveedor);
                cabecera.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                cabecera.setNroCheque(0);
                cabecera.setTotal(BigDecimal.valueOf(Double.parseDouble(this.txtTotalFacturaF.getValue().toString())));
                cabecera.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                cabecera.setAccionMod(accion);
                cabecera.setUsuarioMod(usuario);
                cabecera.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                proveedor.getOrdenPagos().add(cabecera);
                st.update(cabecera);

                if (cant_lineas > 0) {
                    for (int i = 0; i < cant_lineas; i++) {
                        OrdenPagoDetId detOCompraId = new OrdenPagoDetId(numeroOrden, i);
                        OrdenPagoDet detOCompra = (OrdenPagoDet) st.load(OrdenPagoDet.class, detOCompraId);

                        String sqlComp = "select * from sa_pendientes where cod_docum = 'FP' "
                                + " and cod_tit =  :cod_tit and cod_suc_fac = :cod_suc_fac"
                                + " and cod_tribut_fac = :cod_tribut_fac and nro_docum = :nro_docum";

                        SQLQuery consulta = st.createSQLQuery(sqlComp);
                        consulta.addEntity(SaPendientes.class);
                        consulta.setParameter("cod_tit", detOCompra.getCodProveedor());
                        consulta.setParameter("cod_suc_fac", detOCompra.getCodSucFac());
                        consulta.setParameter("cod_tribut_fac", detOCompra.getCodTributFac());
                        consulta.setParameter("nro_docum", detOCompra.getNroFacturaProv());
                        SaPendientes pendiente = (SaPendientes) consulta.uniqueResult();

                        BigDecimal saldo = pendiente.getSaldo();
                        BigDecimal pagado = detOCompra.getImportePagado();
                        BigDecimal saldo2 = saldo.add(pagado);

                        pendiente.setSaldo(saldo2);
                        st.update(pendiente);

                        st.delete(detOCompra);
                    }
                }
                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    OrdenPagoDetId detOCompraId = new OrdenPagoDetId(numeroOrden, i);

                    OrdenPagoDet detalle = new OrdenPagoDet();
                    detalle.setId(detOCompraId);
                    detalle.setCodCaja(objCaja.getCodCaja());
                    detalle.setCodProveedor(this.txtCodProveedor.getText());

                    detalle.setCodSucFac(model.getValueAt(i, 0).toString());
                    detalle.setCodTributFac(model.getValueAt(i, 1).toString());
                    detalle.setNroFacturaProv(Integer.valueOf(model.getValueAt(i, 2).toString()));
                    detalle.setFecVto(UtilidadesCalendario.StringACalendario(model.getValueAt(i, 4).toString()).getTime());
                    detalle.setSaldo(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 7).toString())));
                    detalle.setImportePagado(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 8).toString())));

                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detalle.setOrdenPago(cabecera);
                    st.save(detalle);

                    String sqlComp = "select * from sa_pendientes where cod_docum = 'FP' "
                            + " and cod_tit =  :cod_tit and cod_suc_fac = :cod_suc_fac"
                            + " and cod_tribut_fac = :cod_tribut_fac and nro_docum = :nro_docum";
                    System.out.println(sqlComp);
                    SQLQuery consulta = st.createSQLQuery(sqlComp);
                    consulta.addEntity(SaPendientes.class);
                    consulta.setParameter("cod_tit", detalle.getCodProveedor());
                    consulta.setParameter("cod_suc_fac", model.getValueAt(i, 0));
                    consulta.setParameter("cod_tribut_fac", model.getValueAt(i, 1));
                    consulta.setParameter("nro_docum", model.getValueAt(i, 2));
                    SaPendientes pendiente = (SaPendientes) consulta.uniqueResult();

                    BigDecimal saldo = pendiente.getSaldo();
                    BigDecimal pagado = detalle.getImportePagado();
                    BigDecimal saldo2 = saldo.subtract(pagado);

                    pendiente.setSaldo(saldo2);
                    st.update(pendiente);
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
        if (Double.valueOf(this.txtAPagar.getValue().toString()) > 0) {
            int lin = verificar();
            if (lin >= 0) {
                    model.setValueAt(this.txtAPagar.getValue(), lin, 8);
                    calcularTotalFactura();
                    limpiarArticulos();
            } else {
                model.addRow(new Object[]{
                    this.txtCodSucFac.getText(),
                    this.txtCodTributFac.getText(),
                    this.txtNroFactura.getText(),
                    this.txtFechaFac.getText(),
                    this.txtFecVenc.getValue(),
                    1,
                    this.txtOrigen.getValue(),
                    this.txtSaldo.getValue(),
                    this.txtAPagar.getValue()                    
                });
                calcularTotalFactura();
                limpiarArticulos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public int verificar(){
        int linea = -1;
        String codSuc = this.txtCodSucFac.getText();
        String codTribut = this.txtCodTributFac.getText();
        Integer nroDocum = Integer.parseInt(this.txtNroFactura.getText());
        if(this.jTable1.getRowCount()>=1){
            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                String tcodSuc = model.getValueAt(i, 0).toString();
                String tcodTribut = model.getValueAt(i, 1).toString();
                Integer tnroDocum = Integer.parseInt(model.getValueAt(i, 2).toString());
                if(codSuc.equals(tcodSuc) && codTribut.equals(tcodTribut) && nroDocum.equals(tnroDocum)){
                    linea = i;
                }
            }        
        }
        return linea;
    }
    
    public void calcularTotalFactura(){
        //Método para calcular el total de la compra, obteniendo datos del jtable.
        double totalG = 0;
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            totalG += Double.parseDouble(model.getValueAt(i, 8).toString());
        }
        this.txtTotalFacturaF.setValue(totalG);
    }
    
    private void limpiarArticulos() {
        this.txtCodSucFac.setText("");
        this.txtCodTributFac.setText("");
        this.txtNroFactura.setText("");
        this.txtFecVenc.setText("");
        this.txtFechaFac.setText("");
        this.txtAPagar.setValue(null);   
        this.txtOrigen.setValue(null);
        this.txtSaldo.setValue(null);
        this.btnBorrar.setEnabled(false);
        this.txtCodSucFac.requestFocus();
        this.deboBuscarArticulo = true;
        this.articulo = null;
    }
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            this.txtCodSucFac.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtCodTributFac.setText(model.getValueAt(filaSeleccionada, 1).toString());
            this.txtNroFactura.setText(model.getValueAt(filaSeleccionada, 2).toString());
            this.txtFechaFac.setText(model.getValueAt(filaSeleccionada, 3).toString());
            this.txtFecVenc.setText(model.getValueAt(filaSeleccionada, 4).toString());
            this.txtOrigen.setValue(model.getValueAt(filaSeleccionada, 6));
            this.txtSaldo.setValue(model.getValueAt(filaSeleccionada, 7));
            this.txtAPagar.setValue(model.getValueAt(filaSeleccionada, 8));

            this.txtCodSucFac.setEditable(false);
            this.txtCodTributFac.setEditable(false);
            this.txtAPagar.requestFocus();
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
            parametros.put("pnro_ocompra", Integer.parseInt(this.txtNroOPago.getText()));
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/OrdenCompraQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, parametros, conexion);
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