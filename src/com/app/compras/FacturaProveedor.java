package com.app.compras;

import com.entidades.FacturaCompra;
import com.entidades.FacturaCompraDetalle;
import com.entidades.FacturaCompraDetalleId;
import com.app.seguridad.Permisos;
import com.entidades.MtArticulos;
import com.entidades.MtCondicionPago;
import com.entidades.MtMonedas;
import com.entidades.MtProveedores;
import com.entidades.MtSucursales;
import com.entidades.MtTipoComprobantes;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.hibernate.Session;
import util.HibernateUtil;
import util.Busqueda;
import util.UtilidadesCalendario;

//@author Fausto Sanabria.

public class FacturaProveedor extends javax.swing.JDialog {
    public FacturaProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Factura de compra - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();   
    }
    
    public FacturaProveedor (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Factura de compra - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private final String usuario;
    private final String formulario;
    private int var, idArti, filaSeleccionada, posicion, cant_lineas;
    private boolean deboBuscarArticulo = true;
    private MtProveedores proveedor;
    private MtArticulos articulo;
    private MtUsuarios objUsuario;
    private OrdenCompra ordenCompra;
    private MtCondicionPago condicionPago;
    private MtSucursales objSucursal;
    private List<Object> ArrayPrimaryKey;
    private ArrayList<OrdCompraDetId> articulosBorrados;
    private boolean esOrdenCompra;

    
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
        jLabel17 = new javax.swing.JLabel();
        txtCodSuc = new javax.swing.JTextField();
        txtCodFac = new javax.swing.JTextField();
        txtNroFactura = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCodCondPago = new javax.swing.JTextField();
        txtDescCondPago = new javax.swing.JTextField();
        txtDias = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFechaVenc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCodSucur = new javax.swing.JTextField();
        txtDescSucur = new javax.swing.JTextField();
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
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        txtPorcDescuento = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtCodArticulo = new javax.swing.JTextField();
        txtDescArticulo = new javax.swing.JTextField();
        txtPorcIva = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtTotalFactura = new javax.swing.JTextField();
        txtIva10 = new javax.swing.JTextField();
        txtIva5 = new javax.swing.JTextField();
        txtGravada = new javax.swing.JTextField();
        txtExenta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
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
        txtFechaHoraActual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setIconImages(null);
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nro. O. Compra");

        jLabel3.setText("Fecha Factura");

        txtNroOCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtNroOCompra.setText("0");
        txtNroOCompra.setToolTipText("Nro de la orden de compra [0]");
        txtNroOCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNroOCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroOCompraFocusLost(evt);
            }
        });
        txtNroOCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroOCompraKeyTyped(evt);
            }
        });

        jLabel12.setText("Proveedor");

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setToolTipText("Fecha en formato dd/mm/aaaa");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P", "A", "F", " " }));
        cmbEstado.setEnabled(false);
        cmbEstado.setFocusable(false);

        jLabel8.setText("Estado");

        txtCodProveedor.setEditable(false);
        txtCodProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtCodProveedor.setToolTipText("Código del proveedor. F9 para buscar");
        txtCodProveedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodProveedor.setFocusable(false);
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

        jLabel17.setText("Nro. Factura ");

        txtCodSuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodSucKeyTyped(evt);
            }
        });

        txtCodFac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodFacKeyTyped(evt);
            }
        });

        txtNroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroFacturaKeyTyped(evt);
            }
        });

        jLabel15.setText("Forma de Pago");

        txtCodCondPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCondPagoFocusLost(evt);
            }
        });

        txtDescCondPago.setEditable(false);
        txtDescCondPago.setBackground(new java.awt.Color(204, 255, 204));
        txtDescCondPago.setFocusable(false);

        txtDias.setEditable(false);
        txtDias.setBackground(new java.awt.Color(204, 255, 204));
        txtDias.setFocusable(false);

        jLabel18.setText("Fecha Venc.");

        txtFechaVenc.setEditable(false);
        txtFechaVenc.setFocusable(false);

        jLabel19.setText("Sucursal");

        txtCodSucur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodSucurFocusLost(evt);
            }
        });

        txtDescSucur.setEditable(false);
        txtDescSucur.setBackground(new java.awt.Color(204, 255, 204));
        txtDescSucur.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodSucur))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroOCompra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodFac, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomProveedor)
                    .addComponent(txtDescSucur))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNroOCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtCodSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtCodCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtCodProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtCodSucur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescSucur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioUnitario.setFocusable(false);
        txtPrecioUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioUnitarioFocusLost(evt);
            }
        });

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubtotal.setFocusable(false);

        txtIVA.setEditable(false);
        txtIVA.setBackground(new java.awt.Color(255, 255, 255));
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setFocusable(false);

        txtPorcDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPorcDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPorcDescuentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcDescuentoFocusLost(evt);
            }
        });

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setFocusable(false);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFocusable(false);

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

        txtPorcIva.setEditable(false);
        txtPorcIva.setBackground(new java.awt.Color(255, 255, 255));
        txtPorcIva.setFocusable(false);

        jLabel16.setText("Descripcion");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png"))); // NOI18N
        btnAgregar.setToolTipText("");
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
                    .addComponent(txtCantidad)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtPorcDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorcIva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTotalFactura.setEditable(false);
        txtTotalFactura.setBackground(new java.awt.Color(204, 255, 204));
        txtTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalFactura.setText("0");

        txtIva10.setEditable(false);
        txtIva10.setBackground(new java.awt.Color(255, 255, 255));
        txtIva10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtIva5.setEditable(false);
        txtIva5.setBackground(new java.awt.Color(255, 255, 255));
        txtIva5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtGravada.setEditable(false);
        txtGravada.setBackground(new java.awt.Color(255, 255, 255));
        txtGravada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));
        txtExenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel20.setText("Total Exenta: ");

        jLabel21.setText("Total Gravadas");

        jLabel22.setText("Total 10%");

        jLabel23.setText("Total 5%");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIva5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIva10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGravada, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(txtGravada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtIva10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(txtIva5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addContainerGap())
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
                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUltimo)
                .addGap(18, 18, 18)
                .addComponent(lblInfoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(50, 50, 50))
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

        txtFechaHoraActual.setEditable(false);
        txtFechaHoraActual.setBackground(new java.awt.Color(204, 255, 204));
        txtFechaHoraActual.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        confirmarCerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        if (this.txtCodArticulo.getText().isEmpty()){
            this.txtCodArticulo.requestFocus();
        }
        this.txtCantidad.selectAll();
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        if (!this.txtCantidad.getText().isEmpty()) {
            if (Double.parseDouble(this.txtCantidad.getText()) > 0) {
                calcularLinea();
            } else {
                this.txtCantidad.requestFocus();
            }
        } else {
            if (!this.txtCodArticulo.getText().isEmpty()){
                this.txtCantidad.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtPrecioUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFocusGained
        txtPrecioUnitario.selectAll();
    }//GEN-LAST:event_txtPrecioUnitarioFocusGained

    private void txtPrecioUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioFocusLost
        calcularLinea();
    }//GEN-LAST:event_txtPrecioUnitarioFocusLost

    private void txtPorcDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcDescuentoFocusLost
        calcularLinea();
    }//GEN-LAST:event_txtPorcDescuentoFocusLost

    private void txtPorcDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcDescuentoFocusGained
        txtPorcDescuento.selectAll();
    }//GEN-LAST:event_txtPorcDescuentoFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!this.txtNroOCompra.getText().isEmpty() && Integer.parseInt(this.txtNroOCompra.getText()) > 0 && this.esOrdenCompra){
            editarTabla();
        } else {
            anexarTabla();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

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
            recuperarProveedor(this.txtCodProveedor.getText());
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
            this.txtCodProveedor.setFocusable(true);
            this.txtNroOCompra.setEditable(true);
            this.txtNroOCompra.setFocusable(true);
            this.txtCodSuc.setEditable(true);
            this.txtCodFac.setEditable(true);
            this.txtNroFactura.setEditable(true);
            this.txtCodSucur.setEditable(true);
            this.txtCodCondPago.setEditable(true);
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

    private void txtNroOCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroOCompraFocusLost
        if ("Nuevo".equals(accion)){
            recuperarOrdenCompra();
        }
    }//GEN-LAST:event_txtNroOCompraFocusLost

    private void txtCodSucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodSucKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') && this.txtCodSuc.getText().length() < 3) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodSucKeyTyped

    private void txtCodFacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFacKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') && this.txtCodFac.getText().length() < 3) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodFacKeyTyped

    private void txtNroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroFacturaKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9')) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroFacturaKeyTyped

    private void txtCodCondPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCondPagoFocusLost
        if (!"Buscar".equalsIgnoreCase(accion)) {
            condicionPago = (MtCondicionPago) st.get(MtCondicionPago.class, Integer.parseInt(this.txtCodCondPago.getText()));
            if (condicionPago == null) {
                JOptionPane.showMessageDialog(null, "No existe la forma de pago seleccionada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                this.txtCodCondPago.requestFocus();
            } else {
                this.txtDescCondPago.setText(condicionPago.getDescripcion());
                this.txtDias.setText(condicionPago.getPlazo().toString());
                this.txtFechaVenc.setText(calcularVencimiento(this.txtFecha.getText(), Integer.parseInt(this.txtDias.getText())));
            }
        }
    }//GEN-LAST:event_txtCodCondPagoFocusLost

    private void txtCodSucurFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodSucurFocusLost
        if (!"Buscar".equalsIgnoreCase(accion)) {
            recuperarSucursal(this.txtCodSucur.getText());
        }
    }//GEN-LAST:event_txtCodSucurFocusLost

    private void txtNroOCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroOCompraFocusGained
        this.txtNroOCompra.selectAll();
    }//GEN-LAST:event_txtNroOCompraFocusGained


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
            java.util.logging.Logger.getLogger(FacturaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FacturaProveedor dialog = new FacturaProveedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodArticulo;
    private javax.swing.JTextField txtCodCondPago;
    private javax.swing.JTextField txtCodFac;
    private javax.swing.JTextField txtCodProveedor;
    private javax.swing.JTextField txtCodSuc;
    private javax.swing.JTextField txtCodSucur;
    private javax.swing.JTextField txtDescArticulo;
    private javax.swing.JTextField txtDescCondPago;
    private javax.swing.JTextField txtDescSucur;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtExenta;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtFechaHoraActual;
    private javax.swing.JTextField txtFechaVenc;
    private javax.swing.JTextField txtGravada;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIva10;
    private javax.swing.JTextField txtIva5;
    private javax.swing.JTextField txtNomProveedor;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroFactura;
    private javax.swing.JTextField txtNroOCompra;
    private javax.swing.JTextField txtPorcDescuento;
    private javax.swing.JTextField txtPorcIva;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalFactura;
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
        this.txtCodSuc.setEditable(false);
        this.txtCodSuc.setText("");
        this.txtCodFac.setEditable(false);
        this.txtCodFac.setText("");
        this.txtNroFactura.setEditable(false);
        this.txtNroFactura.setText("");
        this.txtCodCondPago.setEditable(false);
        this.txtCodCondPago.setText("");
        this.txtDescCondPago.setEditable(false);
        this.txtDescCondPago.setText("");
        this.txtDias.setEditable(false);
        this.txtDias.setText("");
        this.txtFechaVenc.setEditable(false);
        this.txtFechaVenc.setText("");
        this.txtCodSucur.setEditable(false);
        this.txtCodSucur.setText("");
        this.txtDescSucur.setEditable(false);
        this.txtDescSucur.setText("");
        
        this.txtFecha.setEditable(false);
        this.txtFecha.setText("");        
        this.cmbEstado.setEnabled(false);       
        this.txtCodProveedor.setEditable(false);
        this.txtCodProveedor.setText("");        
        this.txtNomProveedor.setText("");
        this.txtTotalFactura.setText("0");
        this.txtExenta.setText("0");
        this.txtGravada.setText("0");
        this.txtIva10.setText("0");
        this.txtIva5.setText("0");
        //Detalle
        this.txtCodArticulo.setEditable(false);
        this.txtCodArticulo.setText("");
        this.txtCantidad.setEditable(false);
        this.txtCantidad.setText("");         
        this.txtPrecioUnitario.setEditable(false);
        this.txtPrecioUnitario.setText("");        
        this.txtSubtotal.setEditable(false);
        this.txtSubtotal.setText("");        
        this.txtIVA.setEditable(false);
        this.txtIVA.setText("");          
        this.txtPorcDescuento.setEditable(false);
        this.txtPorcDescuento.setText("");     
        this.txtPorcIva.setEditable(false);
        this.txtPorcIva.setText(""); 
        this.txtDescuento.setEditable(false);
        this.txtDescuento.setText("");     
        this.txtTotal.setEditable(false);
        this.txtTotal.setText("");
        this.txtDescArticulo.setText("");
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
        
        this.lblInfoPie.setText("Karu");
        //Seteamos y cargamos la tabla
        defaultTableModel();
        //cargarTabla();
        this.jTable1.setEnabled(true);
    }
    
    private void defaultTableModel(){
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);     // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(240);     // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);      // cantidad
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(95);      // precio unitario
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);      // subtotal
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);      // porc iva
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);      // iva
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);      // porc dto
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);      // descuento
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(85);      // total
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    private void confirmarCerrar() {
        if (!"".equals(accion)) {
            int seleccion = JOptionPane.showConfirmDialog(null, "Existen datos que aun no se han guardado. ¿Confirma que desea cerrar?.",
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
    }
    
    private void recuperarOrdenCompra() {
        if ("0".equals(this.txtNroOCompra.getText())) {
            this.txtCodProveedor.setEditable(true);
            this.txtCodProveedor.setFocusable(true);
        } else {
            st.beginTransaction();
            this.ordenCompra = (OrdenCompra) st.get(OrdenCompra.class, Integer.parseInt(this.txtNroOCompra.getText()));
            if (ordenCompra != null) {
                if ("P".equalsIgnoreCase(String.valueOf(ordenCompra.getEstado()))) {
                    this.proveedor = ordenCompra.getMtProveedores();
                    this.txtCodProveedor.setText(ordenCompra.getMtProveedores().getNroDocum());
                    this.txtNomProveedor.setText(ordenCompra.getMtProveedores().getNomTit());
                    cargarGrilla(ordenCompra.getNroOcompra());
                    calcularTotalFactura();
                } else {
                    JOptionPane.showMessageDialog(this, "El numero de orden ingresado,  ya ha sido facturado", "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtNroOCompra.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe el numero de orden ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtNroOCompra.requestFocus();
            }
        }
    }
        
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        objUsuario = (MtUsuarios) st.load(MtUsuarios.class, cod_usuario);
        return objUsuario;
    }
    
    private void buscar() {
        String SqlQuery = "select nro_trans from factura_compra where nro_trans > 0";
        if (!this.txtNroOCompra.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and nro_ocompra = " + this.txtNroOCompra.getText();
        }
        if (!this.txtCodProveedor.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_proveedor = '" + this.txtCodProveedor.getText().trim() + "'";
        }
        if (this.txtFecha.getText().trim().length() == 10) {
            SqlQuery = SqlQuery + " and fecha = to_timestamp('" + this.txtFecha.getText().trim() + "', 'dd/MM/yyyy')";
        }      
        if (this.txtCodSuc.getText().trim().length() == 3) {
            SqlQuery = SqlQuery + " and cod_suc_fac = '" + this.txtCodSuc.getText().trim() + "'";
        }
        if (this.txtCodFac.getText().trim().length() == 3) {
            SqlQuery = SqlQuery + " and cod_tribut_fac = '" + this.txtCodFac.getText().trim() + "'";
        }     
        if (!this.txtNroFactura.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and nro_factura = " + this.txtNroFactura.getText();
        }  
        if (!this.txtCodSucur.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cod_suc = '" + this.txtCodSucur.getText().trim() + "'";
        }          
        if (!this.txtCodCondPago.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and cond_pago = " + this.txtCodCondPago.getText();
        }                 
        SqlQuery = SqlQuery + " order by nro_trans";
        
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
            //this.btnEditar.setEnabled(true);
            //this.btnInforme.setEnabled(true);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else if (ArrayPrimaryKey.size() == 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnEliminar.setEnabled(true);
            //this.btnEditar.setEnabled(true);
            //this.btnInforme.setEnabled(true);
            this.txtCodProveedor.setEditable(false);
            this.txtCodProveedor.setFocusable(false);
            this.txtNroOCompra.setEditable(false);
            this.txtNroOCompra.setFocusable(false);
            this.txtCodSuc.setEditable(false);
            this.txtCodFac.setEditable(false);
            this.txtNroFactura.setEditable(false);
            this.txtCodSucur.setEditable(false);
            this.txtCodCondPago.setEditable(false);
            this.btnCancelar.setEnabled(false);
            
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro", "Buscar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void recuperarRegistros(int indice) {
        DecimalFormat formato = new DecimalFormat("###,###,###.00");
        int nroTrans = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        FacturaCompra registroCabecera = (FacturaCompra) st.load(FacturaCompra.class, nroTrans);
        this.txtUsuario.setText(registroCabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaHoraActual.setText(UtilidadesCalendario.DateAString(registroCabecera.getFechaMod()));
        this.txtNroOCompra.setText(String.valueOf(registroCabecera.getNroOcompra()));
        this.txtFecha.setText(UtilidadesCalendario.DateAString(registroCabecera.getFecha()));
        this.txtCodProveedor.setText(registroCabecera.getMtProveedores().getNroDocum());
        this.txtCodSuc.setText(registroCabecera.getCodSucFac());
        this.txtCodFac.setText(registroCabecera.getCodTributFac());
        this.txtNroFactura.setText(String.valueOf(registroCabecera.getNroFactura()));
        this.txtCodCondPago.setText(String.valueOf(registroCabecera.getMtCondicionPago().getCodCond()));
        this.txtDescCondPago.setText(registroCabecera.getMtCondicionPago().getDescripcion());
        this.txtDias.setText(String.valueOf(registroCabecera.getMtCondicionPago().getPlazo()));
        this.txtFechaVenc.setText(UtilidadesCalendario.DateAString(registroCabecera.getVencimiento()));
        this.txtCodSucur.setText(registroCabecera.getMtSucursales().getCodSucursal());
        this.txtDescSucur.setText(registroCabecera.getMtSucursales().getNomSucursal());
        this.txtIva10.setText(String.valueOf(registroCabecera.getTotalIva10().intValue()));
        this.txtIva5.setText(String.valueOf(registroCabecera.getTotalIva5().intValue()));
        this.txtGravada.setText(String.valueOf(registroCabecera.getTotalGravada().intValue()));
        this.txtExenta.setText(String.valueOf(registroCabecera.getTotalExenta().intValue()));
        this.txtTotalFactura.setText(formato.format(calcularTotal().toString()));
        
        recuperarProveedor(this.txtCodProveedor.getText());
        recuperarDetalle(nroTrans);
    }
    private BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.add(new BigDecimal(this.txtGravada.getText()));
        total = total.add(new BigDecimal(this.txtExenta.getText()));
        total = total.add(new BigDecimal(this.txtIva10.getText()));
        total = total.add(new BigDecimal(this.txtIva5.getText()));
        return total;
    }
    
    private void cargarGrilla(int nroOCompra) {
        System.out.println("Cargo la grilla");
        Query consulta = st.createQuery("From OrdCompraDet a JOIN a.id b WHERE b.nroOcompra = :nroOCompras order by b.linea");
        consulta.setParameter("nroOCompras", nroOCompra);
        List<OrdCompraDet> detalles = (List<OrdCompraDet>)consulta.list();
        model.setNumRows(0);
        for (OrdCompraDet registroDetalle : detalles) {
            model.addRow(new Object[]{
                registroDetalle.getMtArticulos().getCodArticulo(), registroDetalle.getMtArticulos().getNomArticulo(),
                registroDetalle.getCantidad(), registroDetalle.getPrecioUnitario().intValue(), registroDetalle.getSubtotal().intValue(),
                registroDetalle.getPorcIva(), registroDetalle.getImporteIva().intValue(),
                registroDetalle.getPorcDto(), registroDetalle.getImpDescuento().intValue(),
                registroDetalle.getTotal().intValue()
            });
        }
    }    
    
    private void recuperarDetalle(int trans) {
        System.out.println("Cargo la grilla");
        Query consulta = st.createQuery("From FacturaCompraDetalle a JOIN a.id b WHERE b.nroTrans = :nroTrans order by b.linea");
        consulta.setParameter("nroTrans", trans);
        List<FacturaCompraDetalle> detalles = (List<FacturaCompraDetalle>)consulta.list();
        model.setNumRows(0);
        for (FacturaCompraDetalle registroDetalle : detalles) {
            model.addRow(new Object[]{
                registroDetalle.getMtArticulos().getCodArticulo(), registroDetalle.getMtArticulos().getNomArticulo(),
                registroDetalle.getCantidad(), registroDetalle.getPrecioUnitaio().intValue(), registroDetalle.getSubtotal().intValue(),
                registroDetalle.getPorcIva(), registroDetalle.getImporteIva().intValue(),
                registroDetalle.getPorcDto(), registroDetalle.getImpDescuento(),
                registroDetalle.getTotal().intValue()
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
        this.txtCodProveedor.setEditable(false);
        this.txtCodProveedor.setText("");
        this.cmbEstado.setEnabled(false);
        this.cmbEstado.setSelectedIndex(0);
        this.txtNroOCompra.setEditable(true);
        this.txtNroOCompra.setText("0");
        this.txtFecha.setEditable(true);
        this.txtFecha.setText(UtilidadesCalendario.FechaActualString());   
        this.txtCodSuc.setEditable(true);
        this.txtCodSuc.setText("");
        this.txtCodFac.setEditable(true);
        this.txtCodFac.setText("");
        this.txtNroFactura.setEditable(true);
        this.txtNroFactura.setText("");
        this.txtCodCondPago.setEditable(true);
        this.txtCodCondPago.setText("");
        this.txtDescCondPago.setEditable(false);
        this.txtDescCondPago.setText("");
        this.txtDias.setEditable(false);
        this.txtDias.setText("");
        this.txtFechaVenc.setEditable(false);
        this.txtFechaVenc.setText("");
        this.txtCodSucur.setEditable(true);
        this.txtCodSucur.setText("");
        this.txtDescSucur.setEditable(false);
        this.txtDescSucur.setText("");
        //Detalle
        this.txtCodArticulo.setEditable(true);
        this.txtCodArticulo.setText("");       
        this.txtCantidad.setEditable(true);
        this.txtCantidad.setText("1");          
        this.txtPrecioUnitario.setEditable(true);
        this.txtPrecioUnitario.setFocusable(true);
        this.txtPrecioUnitario.setText("");   
        this.txtSubtotal.setEditable(false);
        this.txtSubtotal.setText("");
        this.txtIVA.setEditable(false);
        this.txtIVA.setText(""); 
        this.txtPorcDescuento.setEditable(false);
        this.txtPorcDescuento.setText("0"); 
        this.txtDescuento.setEditable(false);
        this.txtDescuento.setText("0");
        this.txtTotal.setEditable(false);
        this.txtTotal.setText("0");
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
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(recuperarUsuario(usuario).getNomUsuario());
        this.txtFechaHoraActual.setText(UtilidadesCalendario.FechaActualString());
        
        this.objSucursal = objUsuario.getMtSucursales();
        this.txtCodSucur.setText(objUsuario.getMtSucursales().getCodSucursal());
        this.txtDescSucur.setText(objUsuario.getMtSucursales().getNomSucursal());
        
        this.txtNroOCompra.requestFocus();
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
        this.txtCantidad.setEditable(true);       
        this.txtPrecioUnitario.setEditable(true);
        this.txtPrecioUnitario.setFocusable(true);
        this.txtSubtotal.setEditable(false); 
        this.txtIVA.setEditable(false);
        this.txtPorcDescuento.setEditable(true);
        this.txtDescuento.setEditable(false);     
        this.txtTotal.setEditable(false); 
        
        //Los botones
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnBuscar.setEnabled(false);
        this.btnAgregar.setEnabled(true);
        
        this.jTable1.setEnabled(true);
        this.txtCodProveedor.grabFocus();
    }
    
    public void eliminar() {
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);
        //Obtnemos la selección del usuario
        if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        } else {//Opción eliminar seleccionada
            st.beginTransaction();
            int nroTrans = Integer.parseInt(ArrayPrimaryKey.get(posicion).toString());
            FacturaCompra a = (FacturaCompra) st.load(FacturaCompra.class, nroTrans);

            for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                FacturaCompraDetalleId detId = new FacturaCompraDetalleId(nroTrans, i);
                FacturaCompraDetalle detalle = (FacturaCompraDetalle) st.load(FacturaCompraDetalle.class, detId);
                st.delete(detalle);
            }
            st.delete(a);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro eliminado.");
            arranque();
        }
    }
    
    private void recuperarProveedor(String pCodProveedor) {
        st.beginTransaction();
        this.proveedor = (MtProveedores) st.get(MtProveedores.class, pCodProveedor);
        if (proveedor != null) {
            this.txtNomProveedor.setText(proveedor.getNomTit());
            this.txtPorcDescuento.setText(String.valueOf(proveedor.getPorcDto()));
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodProveedor.requestFocus();
        }
    }
    
        private void recuperarSucursal(String pCodSucursal) {
        st.beginTransaction();
        this.objSucursal = (MtSucursales) st.get(MtSucursales.class, pCodSucursal);
        if (objSucursal != null) {
            this.txtDescSucur.setText(objSucursal.getNomSucursal());
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código de sucursal", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodSucur.requestFocus();
        }
    }
    
    private void recuperarArticulo() {
        st.beginTransaction();
        this.articulo = (MtArticulos) st.get(MtArticulos.class, this.txtCodArticulo.getText().toUpperCase());
        if (articulo != null) {
            this.txtDescArticulo.setText(articulo.getNomArticulo());
            BigDecimal precioUnit = new BigDecimal(articulo.getPrecioCompra().toString());
            BigDecimal precioUnitarioIva = precioUnit.multiply(new BigDecimal("1.1"));
            this.txtPrecioUnitario.setText(String.valueOf(precioUnitarioIva.intValue()));
            this.txtPorcIva.setText(String.valueOf(articulo.getImpuesto()));
            
        } else {
            JOptionPane.showMessageDialog(this, "No existe el código del producto", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCodArticulo.requestFocus();
        }
    }
    
    private MtArticulos recuperarArticuloCod(String codigo) {
        st.beginTransaction();
        MtArticulos retorno = (MtArticulos) st.load(MtArticulos.class, codigo.toUpperCase());
        return retorno;
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

        if (!this.txtCantidad.getText().isEmpty()) {
            pCantidad = new BigDecimal(this.txtCantidad.getText());
        }
        if (!this.txtPrecioUnitario.getText().isEmpty()) {
            pUnitario = new BigDecimal(this.txtPrecioUnitario.getText());
        }
        if (!this.txtPorcDescuento.getText().isEmpty()) {
            pPorcDescuento = new BigDecimal(this.txtPorcDescuento.getText());
            pPorcDescuento = pPorcDescuento.divide(new BigDecimal("100"));
        }
        if (!this.txtPorcIva.getText().isEmpty()) {
            pPorcIva = new BigDecimal(this.txtPorcIva.getText());
        }

        montoSubtotal = pUnitario.multiply(pCantidad);
        montoDescuento = montoSubtotal.multiply(pPorcDescuento);
        montoTotal = montoSubtotal.subtract(montoDescuento);
        
        auxiliarIva1 = montoTotal.multiply(pPorcIva);
        ivaCompuesto = pPorcIva.add(new BigDecimal("100"));
        montoIva = auxiliarIva1.divide(ivaCompuesto, MathContext.DECIMAL32);
        
        this.txtSubtotal.setText(String.valueOf(montoSubtotal.intValue()));
        this.txtDescuento.setText(String.valueOf(montoDescuento.intValue()));
        this.txtTotal.setText(String.valueOf(montoTotal.intValue()));
        this.txtIVA.setText(String.valueOf(montoIva.intValue()));
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
    
    private boolean validaDatos() {
        boolean retorno = false;
        int rowCount = this.jTable1.getRowCount();
        if(this.txtCodProveedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el proveedor.");
        } else if(this.cmbEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado");
        } else if(this.txtFecha.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha");
        } else if(rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else if(this.txtCodSuc.getText().isEmpty() || this.txtCodFac.getText().isEmpty() || this.txtNroFactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el numero de factura");
        } else if(this.txtCodSucur.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar la sucursal");            
        } else if(this.txtCodCondPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la forma de pago");            
        } else if(this.txtCodSuc.getText().length() != 3 || this.txtCodFac.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Error en el formato del numero de factura. Verifique.");            
        } else {
            retorno = true;
        }
        return retorno;
    }

    public void guardar() {
        if (validaDatos()) {
            try {
                st.beginTransaction();
                FacturaCompra a = new FacturaCompra();
                int nroTrans = Integer.parseInt(st.createSQLQuery("select nextval('nro_trans_seq');").uniqueResult().toString());

                a.setNroTrans(nroTrans);
                a.setNroOcompra(Integer.parseInt(this.txtNroOCompra.getText()));
                a.setMtProveedores(proveedor);
                a.setCodSucFac(this.txtCodSuc.getText());
                a.setCodTributFac(this.txtCodFac.getText());
                a.setNroFactura(Integer.parseInt(this.txtNroFactura.getText()));
                a.setMtSucursales(objSucursal);
                a.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                a.setVencimiento(UtilidadesCalendario.StringACalendario(this.txtFechaVenc.getText()).getTime());
                a.setMtTipoComprobantes((MtTipoComprobantes) st.load(MtTipoComprobantes.class, "FP"));
                a.setNroDocum(Integer.parseInt(this.txtNroFactura.getText()));
                a.setMtCondicionPago(condicionPago);
                a.setMtMonedas((MtMonedas) st.load(MtMonedas.class, Integer.parseInt("1")));
                a.setTipoCambio(BigDecimal.ONE);
                a.setTotalGravada(BigDecimal.valueOf(Double.parseDouble(this.txtGravada.getText())));
                a.setTotalIva10(BigDecimal.valueOf(Double.parseDouble(this.txtIva10.getText())));
                a.setTotalIva5(BigDecimal.valueOf(Double.parseDouble(this.txtIva5.getText())));
                a.setTotalExenta(BigDecimal.valueOf(Double.parseDouble(this.txtExenta.getText())));
                a.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                a.setAccionMod(accion);
                a.setUsuarioMod(usuario);
                a.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                proveedor.getFacturaCompras().add(a);
                st.save(a);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    FacturaCompraDetalleId detalleId = new FacturaCompraDetalleId(nroTrans, i);

                    FacturaCompraDetalle detalle = new FacturaCompraDetalle();
                    detalle.setId(detalleId);
                    detalle.setMtArticulos((MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase()));
                    detalle.setCantidad(Integer.parseInt(model.getValueAt(i, 2).toString()));
                    detalle.setPrecioUnitaio(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 3).toString())));
                    detalle.setSubtotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 4).toString())));
                    detalle.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
                    detalle.setImporteIva(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 6).toString())));
                    detalle.setPorcDto(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 7).toString())));
                    detalle.setImpDescuento(Integer.parseInt(model.getValueAt(i, 8).toString()));
                    detalle.setTotal(BigDecimal.valueOf(Double.valueOf(model.getValueAt(i, 9).toString())));
                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                    detalle.setFacturaCompra(a);
                    st.save(detalle);
                    
                    MtArticulos articuloeditar = (MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase());
                    articuloeditar.setPrecioCompra(detalle.getPrecioUnitaio().subtract(detalle.getPrecioUnitaio().multiply(detalle.getPorcDto().divide(new BigDecimal("100")))));
                    st.save(articuloeditar);
                    
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
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
                FacturaCompra a = (FacturaCompra) st.load(FacturaCompra.class, numeroOrden);

                a.setFecha(UtilidadesCalendario.StringACalendario(this.txtFecha.getText()).getTime());
                a.setEstado(this.cmbEstado.getSelectedItem().toString().charAt(0));
                a.setMtProveedores(proveedor);
                a.setTotalGravada(BigDecimal.valueOf(Double.parseDouble(this.txtTotalFactura.getText())));
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
                    //detOCompra.setOrdenCompra(a);
                    st.save(detOCompra);
                    
                    MtArticulos articuloeditar = (MtArticulos) st.load(MtArticulos.class, model.getValueAt(i, 0).toString().toUpperCase());
                    articuloeditar.setPrecioCompra(detOCompra.getTotal());
                    st.save(articuloeditar);
                }
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
    
    private void editarTabla() {
        if (this.txtCodArticulo.getText().isEmpty() || this.txtCantidad.getText().isEmpty() || this.txtPrecioUnitario.getText().isEmpty()
                || this.txtPorcDescuento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            model.setValueAt(this.txtCantidad.getText(), idArti, 2);
            model.setValueAt(this.txtPrecioUnitario.getText(), idArti, 3);
            model.setValueAt(this.txtSubtotal.getText(), idArti, 4);
            model.setValueAt(this.txtPorcIva.getText(), idArti, 5);
            model.setValueAt(this.txtIVA.getText(), idArti, 6);
            model.setValueAt(this.txtPorcDescuento.getText(), idArti, 7);
            model.setValueAt(this.txtDescuento.getText(), idArti, 8);
            model.setValueAt(this.txtTotal.getText(), idArti, 9);
            calcularTotalFactura();
            limpiarArticulos();
        }
    }
    
    private void anexarTabla() {
        if (this.articulo == null) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado el artículo. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else if (this.txtCantidad.getText().isEmpty() || this.txtPrecioUnitario.getText().isEmpty() ||
                this.txtPorcDescuento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else {
            verificar();
            if(var>=1){
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Artículo ya Agregado. Desea reemplazar los datos?.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
                if(showConfirmDialog==0){
                    model.setValueAt(this.txtCantidad.getText(), idArti, 2);
                    model.setValueAt(this.txtPrecioUnitario.getText(), idArti, 3);
                    model.setValueAt(this.txtSubtotal.getText(), idArti, 4);
                    model.setValueAt(this.txtPorcIva.getText(), idArti, 5);
                    model.setValueAt(this.txtIVA.getText(), idArti, 6);
                    model.setValueAt(this.txtPorcDescuento.getText(), idArti, 7);
                    model.setValueAt(this.txtDescuento.getText(), idArti, 8);
                    model.setValueAt(this.txtTotal.getText(), idArti, 9);
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
                    this.txtCantidad.getText(),
                    this.txtPrecioUnitario.getText(),
                    this.txtSubtotal.getText(),
                    this.txtPorcIva.getText(),
                    this.txtIVA.getText(),
                    this.txtPorcDescuento.getText(),
                    this.txtDescuento.getText(),
                    this.txtTotal.getText() 
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
        int totalG = 0;
        int totalE = 0;
        int total10 = 0;
        int total5 = 0;
        int totalGr = 0;
        
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            Object vTotal = model.getValueAt(i, 9); 
            Object vPIva = model.getValueAt(i, 5); 
            Object vMIva = model.getValueAt(i, 6); 
            
            if (Integer.parseInt(vPIva.toString()) == 0) {
                totalE += Integer.parseInt(vTotal.toString());
            } else if (Integer.parseInt(vPIva.toString()) == 5) {
                total5 += Integer.parseInt(vMIva.toString());
                totalGr += Integer.parseInt(vTotal.toString()) - Integer.parseInt(vMIva.toString());
            } else if (Integer.parseInt(vPIva.toString()) == 10) {
                total10 += Integer.parseInt(vMIva.toString());
                totalGr += Integer.parseInt(vTotal.toString()) - Integer.parseInt(vMIva.toString());
            }
            
            totalG += Integer.parseInt(vTotal.toString());
        }
        DecimalFormat formato = new DecimalFormat("###,###,##0.00");
        this.txtTotalFactura.setText(String.valueOf(totalG));
        this.txtGravada.setText(String.valueOf(totalGr));
        this.txtIva10.setText(String.valueOf(total10));
        this.txtIva5.setText(String.valueOf(total5));
        this.txtExenta.setText(String.valueOf(totalE));
    }
    
    public void sumarRepetido(){
        //Si se repite el ingreso de un artículo específico,se puede obtar por sumar la cantidad de compra,
        //este método localizar el id del artículo específico y aumenta la cantidad de la
        //compra sumandola.
        int artCant = Integer.parseInt(this.txtCantidad.getText());
        int artTotal = Integer.parseInt(this.txtTotal.getText());
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
        this.txtCantidad.setText("");          
        this.txtPrecioUnitario.setText("");   
        this.txtSubtotal.setText("");        
        this.txtPorcIva.setText("");
        this.txtIVA.setText(""); 
        this.txtPorcDescuento.setText("0"); 
        this.txtDescuento.setText("0");         
        this.txtTotal.setText("0");
        this.btnBorrar.setEnabled(false);
        this.txtCodArticulo.requestFocus();
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
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            this.txtCodArticulo.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtDescArticulo.setText(model.getValueAt(filaSeleccionada, 1).toString());
            this.txtCantidad.setText(model.getValueAt(filaSeleccionada, 2).toString());
            this.txtPrecioUnitario.setText(model.getValueAt(filaSeleccionada, 3).toString());
            this.txtSubtotal.setText(model.getValueAt(filaSeleccionada, 4).toString());
            this.txtPorcDescuento.setText(model.getValueAt(filaSeleccionada, 7).toString());
            this.txtDescuento.setText(model.getValueAt(filaSeleccionada, 8).toString());
            this.txtTotal.setText(model.getValueAt(filaSeleccionada, 9).toString());
            this.txtPorcIva.setText(model.getValueAt(filaSeleccionada, 5).toString());
            this.txtIVA.setText(model.getValueAt(filaSeleccionada, 6).toString());
            this.txtCodArticulo.setEditable(false);
            this.txtCantidad.requestFocus();
            this.btnBorrar.setEnabled(true);
            this.esOrdenCompra = true;
        }
    }
    
    private String calcularVencimiento(String fechaInicial, int dias){
        Calendar fechaFinal = UtilidadesCalendario.StringACalendario(fechaInicial);
        fechaFinal.add(Calendar.DATE, dias);
        String retorno = UtilidadesCalendario.CalendarioAString(fechaFinal);
        return retorno;
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