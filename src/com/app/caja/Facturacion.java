package com.app.caja;

import com.app.caja.controladores.ActualizarNC;
import com.app.caja.controladores.ControlArqueo;
import com.entidades.ArqueoCab;
import com.entidades.Caja;
import com.entidades.ComandaCab;
import com.entidades.ComandaDet;
import com.entidades.FacturaVenta;
import com.entidades.FacturaVentaDetalle;
import com.entidades.FacturaVentaDetalleId;
import com.entidades.MtArticulos;
import com.entidades.MtBancos;
import com.entidades.MtCajeros;
import com.entidades.MtClientes;
import com.entidades.MtComprobantes;
import com.entidades.MtCondicionPago;
import com.entidades.MtFormaPago;
import com.entidades.MtMonedas;
import com.entidades.MtProcTarjetas;
import com.entidades.MtSucursales;
import com.entidades.MtTipoComprobantes;
import com.entidades.MtUsuarios;
import com.entidades.SaPendientes;
import com.entidades.ValoresDet;
import com.entidades.ValoresDetId;
import java.awt.Color;
import java.awt.HeadlessException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_F9;
import static java.awt.event.KeyEvent.VK_TAB;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SQLQuery;

import util.Busqueda;
import util.Cargar;
import util.Fecha;
import util.FormatearNumero;
import util.HibernateUtil;
import util.NumeroToLetras;
import util.UtilidadesCalendario;
import util.buscar.BuscarComprobante;
import util.buscar.BusquedaArticulos;

/**
 * @author CArlos Patiño
 */
public class Facturacion extends javax.swing.JDialog {

    /**
     * Creates new form Facturacion
     */
    private String usuario;
    private String origen = "";
    private String formulario;
    private BigInteger masterNrotrans;
    private boolean estadoArqueo;
    private BigDecimal saldoNc;
    private int posicion; //Variables de clase auxiliares necesarias.
    private List<Object> ArrayPrimaryKey;

    public Facturacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hibernateSession();

        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
        this.txtCodUsuario.setText(this.usuario);

        arranque();
        valoresDefecto();
    }

    public Facturacion(String user) {
        setLocationRelativeTo(null);
        initComponents();
        hibernateSession();
        arranque();

        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
        this.txtCodUsuario.setText(this.usuario);

        valoresDefecto();
        habilitacionCaja();
    }

    private Session st;
    private DefaultTableModel model;
    private DefaultTableModel modelVal;
    private MtCajeros masterCajero;
    private MtArticulos superArticulo;

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque() {
        this.cmdGuardar.setEnabled(false);
        this.cmdCancelar.setVisible(true);
        this.cmdCancelar.setEnabled(false);
        tableModel();
        tableModelVal();
        
        buscarRegistros();
        
        this.cmdProcesarConsulta.setVisible(false);
    }

    public void tableModel() {
        model = (DefaultTableModel) this.tabArticulos.getModel();
        model.setNumRows(0);

        tabArticulos.getColumnModel().getColumn(10).setMaxWidth(0);
        tabArticulos.getColumnModel().getColumn(10).setMinWidth(0);
        tabArticulos.getColumnModel().getColumn(10).setPreferredWidth(0);
    }

    public void tableModelVal() {
        modelVal = (DefaultTableModel) this.tabValores.getModel();
        modelVal.setNumRows(0);

        //oculta las ultimas tablas usadas para referencias
        tabValores.getColumnModel().getColumn(10).setMaxWidth(0);
        tabValores.getColumnModel().getColumn(10).setMinWidth(0);
        tabValores.getColumnModel().getColumn(10).setPreferredWidth(0);
    }

    private void habilitacionCaja() {
        ControlArqueo control = new ControlArqueo();
        ArqueoCab arq = null;
        Date date = new Date();
        arq = control.estadoCaja(this.txtCodCaja.getText(), date, 'A');
        if (arq != null) {
            this.estadoArqueo = true;
        } else {
            this.estadoArqueo = false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        txtCodEmpresa1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNomEmpresa1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        panArticulo = new javax.swing.JPanel();
        txtCodArt = new javax.swing.JTextField();
        txtDescArt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioUnit = new javax.swing.JFormattedTextField();
        txtStockActual = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTotalUnit = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCantPedida = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        cmdQuitar = new javax.swing.JButton();
        cmdAgregar = new javax.swing.JButton();
        txtDescto = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabArticulos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtFechaHora = new javax.swing.JTextField();
        txtCodUsuario = new javax.swing.JTextField();
        txtNomUsuario = new javax.swing.JTextField();
        tabPaneCabecera = new javax.swing.JTabbedPane();
        panFactura = new javax.swing.JPanel();
        txtCodTipoComp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescTipComp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodTribFac = new javax.swing.JTextField();
        txtCodSucFac = new javax.swing.JTextField();
        txtNroFact = new javax.swing.JTextField();
        txtCodCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNomCliente = new javax.swing.JTextField();
        txtNroPedido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCodSuc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNomSuc = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCodCaja = new javax.swing.JTextField();
        txtNomCaja = new javax.swing.JTextField();
        panCondPago = new javax.swing.JPanel();
        txtCodCondPago = new javax.swing.JTextField();
        txtDescConPago = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodMoneda = new javax.swing.JTextField();
        txtDescMoneda = new javax.swing.JTextField();
        txtVencimiento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTipoCambio = new javax.swing.JFormattedTextField();
        txtObservacion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabValores = new javax.swing.JTable();
        cmdAgregarValor = new javax.swing.JButton();
        cmdQuitarValor = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtPendiente = new javax.swing.JFormattedTextField();
        lblPendientes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cmdNuevo = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        cmdImprimir = new javax.swing.JButton();
        cmdBuscar = new javax.swing.JButton();
        cmdProcesarConsulta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtTotal10 = new javax.swing.JFormattedTextField();
        txtTotalExentas = new javax.swing.JFormattedTextField();
        txtTotalGral = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCantArt = new javax.swing.JFormattedTextField();
        txtTotal5 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnUltimo = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnPrimero = new javax.swing.JButton();
        cmdCerrar = new javax.swing.JButton();
        lblInfoPie = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jRadioButton1.setText("jRadioButton1");

        jLabel21.setText("Empresa");

        txtNomEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmpresa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación de Ventas - KARU SGCG v1.0");
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

        panArticulo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        txtCodArt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodArt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCodArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodArtActionPerformed(evt);
            }
        });
        txtCodArt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodArtFocusLost(evt);
            }
        });
        txtCodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodArtKeyPressed(evt);
            }
        });

        txtDescArt.setEditable(false);
        txtDescArt.setBackground(new java.awt.Color(255, 255, 255));
        txtDescArt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtDescArt.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel15.setText("Cód.");

        jLabel2.setText("Descripción");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Precio Unit.");

        txtPrecioUnit.setEditable(false);
        txtPrecioUnit.setBackground(new java.awt.Color(204, 255, 255));
        txtPrecioUnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        txtPrecioUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioUnit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtStockActual.setEditable(false);
        txtStockActual.setBackground(new java.awt.Color(204, 255, 255));
        txtStockActual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        txtStockActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockActual.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Stock");

        txtTotalUnit.setEditable(false);
        txtTotalUnit.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalUnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        txtTotalUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalUnit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtTotalUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalUnitActionPerformed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Cant.");

        txtCantPedida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCantPedida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantPedida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCantPedida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantPedidaFocusLost(evt);
            }
        });
        txtCantPedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantPedidaKeyTyped(evt);
            }
        });

        jLabel19.setText("Total");

        cmdQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/DeleteUser.png"))); // NOI18N
        cmdQuitar.setToolTipText("Quitar de la lista");
        cmdQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdQuitarActionPerformed(evt);
            }
        });

        cmdAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/plus.png"))); // NOI18N
        cmdAgregar.setToolTipText("Agregar a lista");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        txtDescto.setEditable(false);
        txtDescto.setBackground(new java.awt.Color(204, 255, 255));
        txtDescto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        txtDescto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescto.setToolTipText("Descuento otorgado");
        txtDescto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDesctoKeyTyped(evt);
            }
        });

        jLabel26.setText("Dto. %");

        javax.swing.GroupLayout panArticuloLayout = new javax.swing.GroupLayout(panArticulo);
        panArticulo.setLayout(panArticuloLayout);
        panArticuloLayout.setHorizontalGroup(
            panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(txtCodArt))
                .addGap(1, 1, 1)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescArt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockActual, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panArticuloLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panArticuloLayout.createSequentialGroup()
                        .addComponent(txtCantPedida, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotalUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panArticuloLayout.setVerticalGroup(
            panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panArticuloLayout.createSequentialGroup()
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel26))
                        .addGap(4, 4, 4)
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantPedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panArticuloLayout.createSequentialGroup()
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)))
                        .addGap(5, 5, 5)
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmdQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panArticuloLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel2});

        tabArticulos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tabArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio Unit.", "Cantidad", "Subtotal", "IVA (%)", "Importe IVA", "Descto. (%)", "Imp. Descto.", "Total", "tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        tabArticulos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabArticulos.setEnabled(false);
        jScrollPane1.setViewportView(tabArticulos);
        if (tabArticulos.getColumnModel().getColumnCount() > 0) {
            tabArticulos.getColumnModel().getColumn(10).setResizable(false);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFechaHora.setEditable(false);
        txtFechaHora.setBackground(new java.awt.Color(204, 255, 255));
        txtFechaHora.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtFechaHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodUsuario.setEditable(false);
        txtCodUsuario.setBackground(new java.awt.Color(204, 255, 255));
        txtCodUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodUsuarioActionPerformed(evt);
            }
        });

        txtNomUsuario.setEditable(false);
        txtNomUsuario.setBackground(new java.awt.Color(204, 255, 255));
        txtNomUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPaneCabecera.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPaneCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPaneCabeceraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabPaneCabeceraMousePressed(evt);
            }
        });

        panFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodTipoComp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodTipoComp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodTipoCompFocusLost(evt);
            }
        });

        jLabel5.setText("Tipo Comprobante");

        txtDescTipComp.setEditable(false);
        txtDescTipComp.setBackground(new java.awt.Color(204, 255, 255));
        txtDescTipComp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel6.setText("Nro. Comprobante");

        txtCodTribFac.setEditable(false);
        txtCodTribFac.setBackground(new java.awt.Color(255, 255, 204));
        txtCodTribFac.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtCodTribFac.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodSucFac.setEditable(false);
        txtCodSucFac.setBackground(new java.awt.Color(255, 255, 204));
        txtCodSucFac.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtCodSucFac.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNroFact.setEditable(false);
        txtNroFact.setBackground(new java.awt.Color(255, 255, 204));
        txtNroFact.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtNroFact.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodCliente.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusLost(evt);
            }
        });
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
        });

        jLabel13.setText("Cliente");

        txtNomCliente.setEditable(false);
        txtNomCliente.setBackground(new java.awt.Color(204, 255, 255));
        txtNomCliente.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtNroPedido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNroPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroPedidoFocusLost(evt);
            }
        });
        txtNroPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroPedidoKeyTyped(evt);
            }
        });

        jLabel14.setText("Nro. Pedido");

        txtCodSuc.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodSucActionPerformed(evt);
            }
        });
        txtCodSuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodSucFocusLost(evt);
            }
        });

        jLabel20.setText("Sucursal");

        txtNomSuc.setEditable(false);
        txtNomSuc.setBackground(new java.awt.Color(204, 255, 255));
        txtNomSuc.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel22.setText("Caja");

        txtCodCaja.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCajaFocusLost(evt);
            }
        });

        txtNomCaja.setEditable(false);
        txtNomCaja.setBackground(new java.awt.Color(204, 255, 255));
        txtNomCaja.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout panFacturaLayout = new javax.swing.GroupLayout(panFactura);
        panFactura.setLayout(panFacturaLayout);
        panFacturaLayout.setHorizontalGroup(
            panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panFacturaLayout.createSequentialGroup()
                        .addComponent(txtCodTipoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtDescTipComp, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panFacturaLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFacturaLayout.createSequentialGroup()
                            .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panFacturaLayout.createSequentialGroup()
                        .addComponent(txtCodTribFac, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtCodSucFac, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtNroFact, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panFacturaLayout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(203, 203, 203))
                        .addGroup(panFacturaLayout.createSequentialGroup()
                            .addComponent(txtCodSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtNomSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFacturaLayout.createSequentialGroup()
                        .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(txtNomCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panFacturaLayout.setVerticalGroup(
            panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodTribFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodSucFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodTipoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescTipComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        tabPaneCabecera.addTab("Datos Factura", panFactura);

        panCondPago.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodCondPago.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodCondPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCondPagoFocusLost(evt);
            }
        });

        txtDescConPago.setEditable(false);
        txtDescConPago.setBackground(new java.awt.Color(204, 255, 255));
        txtDescConPago.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtDescConPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescConPagoActionPerformed(evt);
            }
        });

        jLabel7.setText("Condición Pago");

        jLabel12.setText("Moneda");

        txtCodMoneda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCodMoneda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodMonedaFocusLost(evt);
            }
        });
        txtCodMoneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodMonedaKeyTyped(evt);
            }
        });

        txtDescMoneda.setEditable(false);
        txtDescMoneda.setBackground(new java.awt.Color(204, 255, 255));
        txtDescMoneda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtVencimiento.setEditable(false);
        txtVencimiento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtVencimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setText("Vencimiento");

        jLabel4.setText("Cambio");

        txtTipoCambio.setEditable(false);
        txtTipoCambio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        txtTipoCambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTipoCambio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtObservacion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel23.setText("Observaciones");

        javax.swing.GroupLayout panCondPagoLayout = new javax.swing.GroupLayout(panCondPago);
        panCondPago.setLayout(panCondPagoLayout);
        panCondPagoLayout.setHorizontalGroup(
            panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCondPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCondPagoLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panCondPagoLayout.createSequentialGroup()
                        .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCondPagoLayout.createSequentialGroup()
                                .addComponent(txtCodMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtDescMoneda))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCondPagoLayout.createSequentialGroup()
                                .addComponent(txtCodCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtDescConPago, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCondPagoLayout.createSequentialGroup()
                        .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtVencimiento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        panCondPagoLayout.setVerticalGroup(
            panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCondPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panCondPagoLayout.createSequentialGroup()
                        .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCondPagoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panCondPagoLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCondPagoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescConPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCondPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        tabPaneCabecera.addTab("Condiciones de Pago", panCondPago);

        tabValores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "F. Pago", "Descripción", "Bco./Proc.", "Descripción", "Moneda", "Descripción", "TC", "Ref. Operación", "Importe", "Coutas", "Trans"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabValores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabValores.setRowSelectionAllowed(false);
        tabValores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabValoresKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabValores);
        if (tabValores.getColumnModel().getColumnCount() > 0) {
            tabValores.getColumnModel().getColumn(10).setResizable(false);
        }

        cmdAgregarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/plus.png"))); // NOI18N
        cmdAgregarValor.setToolTipText("Agregar línea para valores");
        cmdAgregarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarValorActionPerformed(evt);
            }
        });

        cmdQuitarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/DeleteUser.png"))); // NOI18N
        cmdQuitarValor.setToolTipText("Quitar línea de valores");
        cmdQuitarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdQuitarValorActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Pendiente a cancelar:");

        txtPendiente.setBackground(new java.awt.Color(255, 255, 204));
        txtPendiente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblPendientes.setBackground(new java.awt.Color(255, 255, 102));
        lblPendientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPendientes.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdQuitarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmdAgregarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPendientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtPendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAgregarValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdQuitarValor)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        tabPaneCabecera.addTab("Valores", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        cmdNuevo.setToolTipText("Nuevo");
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });

        cmdGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        cmdGuardar.setToolTipText("Guardar");
        cmdGuardar.setEnabled(false);
        cmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGuardarActionPerformed(evt);
            }
        });

        cmdBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        cmdBorrar.setToolTipText("Anular");
        cmdBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBorrarActionPerformed(evt);
            }
        });

        cmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        cmdCancelar.setToolTipText("Cancelar");
        cmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelarActionPerformed(evt);
            }
        });

        cmdImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/imprimir 24.png"))); // NOI18N
        cmdImprimir.setToolTipText("Imprimir");
        cmdImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdImprimirActionPerformed(evt);
            }
        });

        cmdBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Search (2).png"))); // NOI18N
        cmdBuscar.setToolTipText("Buscar");
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        cmdProcesarConsulta.setText("Procesar");
        cmdProcesarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdProcesarConsulta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmdProcesarConsulta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmdGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTotal10.setEditable(false);
        txtTotal10.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotal10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal10.setText("0");

        txtTotalExentas.setEditable(false);
        txtTotalExentas.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalExentas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotalExentas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalExentas.setText("0");

        txtTotalGral.setEditable(false);
        txtTotalGral.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalGral.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotalGral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalGral.setText("0");
        txtTotalGral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalGral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalGralActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total IVA 10%");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Total Exentas");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Total");

        jLabel1.setText("Cant. Artículos");

        txtCantArt.setEditable(false);
        txtCantArt.setBackground(new java.awt.Color(255, 255, 255));
        txtCantArt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantArt.setText("0");

        txtTotal5.setEditable(false);
        txtTotal5.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotal5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal5.setText("0");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total IVA 5%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantArt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalExentas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalGral, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtTotal5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtTotalGral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)
                        .addComponent(txtTotal10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalExentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel1)
                        .addComponent(txtCantArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setToolTipText("Panel de Navegación");

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/ULTIMO.png"))); // NOI18N
        btnUltimo.setToolTipText("Último Registro");
        btnUltimo.setMaximumSize(new java.awt.Dimension(24, 24));
        btnUltimo.setMinimumSize(new java.awt.Dimension(24, 24));
        btnUltimo.setPreferredSize(new java.awt.Dimension(24, 24));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/SIGUIENTE.png"))); // NOI18N
        btnSiguiente.setToolTipText("Registro Siguiente");
        btnSiguiente.setMaximumSize(new java.awt.Dimension(24, 24));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(24, 24));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(24, 24));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/ANTERIOR.png"))); // NOI18N
        btnAnterior.setToolTipText("Registro Anterior");
        btnAnterior.setMaximumSize(new java.awt.Dimension(24, 24));
        btnAnterior.setMinimumSize(new java.awt.Dimension(24, 24));
        btnAnterior.setPreferredSize(new java.awt.Dimension(24, 24));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/primero.png"))); // NOI18N
        btnPrimero.setToolTipText("Primer Registro");
        btnPrimero.setMaximumSize(new java.awt.Dimension(24, 24));
        btnPrimero.setMinimumSize(new java.awt.Dimension(24, 24));
        btnPrimero.setPreferredSize(new java.awt.Dimension(24, 24));
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        cmdCerrar.setText("Cerrar");
        cmdCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCerrarActionPerformed(evt);
            }
        });

        lblInfoPie.setText("Karu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoPie, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdCerrar)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCerrar)
                    .addComponent(lblInfoPie))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panArticulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabPaneCabecera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPaneCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodUsuarioActionPerformed
    }//GEN-LAST:event_txtCodUsuarioActionPerformed

    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed
    }//GEN-LAST:event_txtCodArtActionPerformed

    private void txtNomEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmpresa1ActionPerformed
    }//GEN-LAST:event_txtNomEmpresa1ActionPerformed

    private void txtTotalUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalUnitActionPerformed
    }//GEN-LAST:event_txtTotalUnitActionPerformed

    private void txtCodSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodSucActionPerformed
    }//GEN-LAST:event_txtCodSucActionPerformed

    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        if (evt.getKeyCode() == VK_F9) {
            buscar();
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed
        habilitacionCaja();
        Fecha fecha = new Fecha();

        if (estadoArqueo == true) {
            habilitarCampos();
            inicializarCampos();
            this.txtFechaHora.setText(fecha.fechaHoraString(fecha.obtenerFechaSistema()));
            masterNrotrans = obtenerNroTrans();
            obtenerNroDocumento();
            this.origen = "Nuevo";
            this.txtCodCliente.grabFocus();
        } else {
            JOptionPane.showMessageDialog(null, "La caja no esta abierta. Proceda a habilitar la caja antes de comenzar a facturar.",
                    "Factura Venta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        if (verificarMontos()) {

            guardar();
            deshabilitarCampos();
            inicializarCampos();
            limpiarCamposArticulo();

            this.txtCantArt.setValue(0);
            this.txtTotalExentas.setValue(0);
            this.txtTotal10.setValue(0);
            this.txtTotal5.setValue(0);
            this.txtTotalGral.setValue(0);

        } else {
            JOptionPane.showMessageDialog(null, "El  importe a pagar no cierra con el importe de la compra.",
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        deshabilitarCampos();

        if (origen.equals("Buscar")) {
            deshabilitarCamposBusqueda();
            valoresDefecto();
        }
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        try {
            this.txtCantPedida.commitEdit();
            this.txtTotalUnit.commitEdit();
            //this.txtDescto.commitEdit();
            BigDecimal cantidad = new BigDecimal(this.txtCantPedida.getValue().toString());
            int res = cantidad.compareTo(BigDecimal.ZERO);

            if (!this.txtDescArt.getText().equals("")) {
                if (res > 0) {
                    try {

                        BigDecimal subtotal = new BigDecimal(this.txtTotalUnit.getValue().toString());
                        BigDecimal impDesc = calcularDescuento(this.txtDescto.getValue(), this.txtTotalUnit.getValue());
                        BigDecimal cantPedida = new BigDecimal(this.txtCantPedida.getValue().toString());
                        String descto = this.txtDescto.getValue().toString();

                        cargarArticulo(this.superArticulo, subtotal, impDesc, cantPedida, descto, 0);
                        limpiarCamposArticulo();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar el artículo a la grilla. "
                                + "\n" + ex.getMessage(), "Factura Venta", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cantida ingresada es inválida. Cantidad debe ser mayor a 0 (cero)",
                            "Factura Venta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar el código de un artículo en existencia.",
                        "Factura Venta", JOptionPane.ERROR_MESSAGE);
                this.txtCantPedida.setValue(0);
                this.txtCodArt.grabFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void cmdQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdQuitarActionPerformed
        int selectedRow = this.tabArticulos.getSelectedRow();
        quitarElemento(this.model, selectedRow);
        actualizarTotales();
        limpiarCamposArticulo();
    }//GEN-LAST:event_cmdQuitarActionPerformed

    private void txtCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusLost
        if (!origen.equals("buscar")) {
            MtClientes cli = new MtClientes();
            if (this.txtCodCliente.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Código de Cliente no ingresado. ",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtCodCliente.setText(this.txtCodCliente.getText().toUpperCase());
                cli = buscarCliente(this.txtCodCliente.getText());
                if (cli == null) {
                    JOptionPane.showMessageDialog(null, "El cliente no existe o no se encuentra activo. ",
                            "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
                    this.txtCodCliente.setText("");
                    this.txtNomCliente.setText("");
                    this.txtCodCliente.grabFocus();
                } else {
                    this.txtNomCliente.setText(cli.getNomTit());
                }
            }
        }
    }//GEN-LAST:event_txtCodClienteFocusLost

    private void txtDescConPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescConPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescConPagoActionPerformed

    private void txtCodTipoCompFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodTipoCompFocusLost
        if (!origen.equals("buscar")) {
            MtTipoComprobantes comp = new MtTipoComprobantes();
            this.txtCodTipoComp.setText(this.txtCodTipoComp.getText().toUpperCase());
            if (this.txtCodTipoComp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún tipo de comprobante. ",
                        "Factura Venta", JOptionPane.ERROR_MESSAGE);
                this.txtCodTipoComp.grabFocus();
            } else {
                comp = obtenerTipoComprobante(this.txtCodTipoComp.getText());
                obtenerNroDocumento();
            }
        }
    }//GEN-LAST:event_txtCodTipoCompFocusLost

    private void txtCodCondPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCondPagoFocusLost
        if (!origen.equals("buscar")) {
            MtCondicionPago cond = new MtCondicionPago();
            Date fecha = new Date();
            if (this.txtCodCondPago.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna condición de pago. ",
                        "Factura Venta", JOptionPane.ERROR_MESSAGE);
                this.txtCodCondPago.grabFocus();
            } else {
                cond = obtenerCondPago(Integer.parseInt(this.txtCodCondPago.getText()));
                //sólo si es a crédito se habilita campo vencimiento
                if (cond != null) {
                    if (cond.getPlazo() > 0) {
                        //calcula la fecha para el vencimiento
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(fecha);
                        Fecha fec = new Fecha();
                        this.txtVencimiento.setText(calcularVencimiento(fec.fechaString(fecha), cond.getPlazo()));
                    } else {
                        this.txtVencimiento.setText("");
                        this.txtVencimiento.setEditable(false);
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCodCondPagoFocusLost

    private void txtCodMonedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMonedaFocusLost
        if (!origen.equals("buscar")) {
            MtMonedas mon = new MtMonedas();

            if (this.txtCodMoneda.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna moneda. ",
                        "Pago a Proveedores", JOptionPane.ERROR_MESSAGE);
                this.txtCodMoneda.grabFocus();
            } else {
                mon = obtenerMoneda(Integer.parseInt(this.txtCodMoneda.getText()));
                this.txtDescMoneda.setText(mon.getNomMoneda());
                if (this.txtCodMoneda.getText().equals("1")) {
                    this.txtTipoCambio.setValue(1);
                    this.txtTipoCambio.setEnabled(false);
                } else {
                    this.txtTipoCambio.setValue(buscarTipoCambio(mon.getCodMoneda()));
                    this.txtTipoCambio.setEnabled(true);
                    this.txtTipoCambio.setEditable(true);
                }
            }
        }
    }//GEN-LAST:event_txtCodMonedaFocusLost

    private void txtTotalGralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalGralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalGralActionPerformed

    private void txtNroPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroPedidoFocusLost
        if (!origen.equals("buscar")) {
            if (!this.txtNroPedido.getText().equals("")) {
                cargarPedido();
            }
        }
    }//GEN-LAST:event_txtNroPedidoFocusLost

    private void txtCodMonedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMonedaKeyTyped
        char car = evt.getKeyChar();
        if (txtCodMoneda.getText().length() >= 2) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodMonedaKeyTyped

    private void txtCantPedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantPedidaKeyTyped
        char car = evt.getKeyChar();
        if (txtCantPedida.getText().length() >= 10) {
            evt.consume();
        }

        if (superArticulo.getFraccionable()) {

            if (car == ',' || car == '0' || car == '1' || car == '2' || car == '3'
                    || car == '4' || car == '5' || car == '6' || car == '7' || car == '8' || car == '9') {
                //no hace nada, deja pasar
            } else {
                evt.consume();
            }
        } else {
            if (car == '0' || car == '1' || car == '2' || car == '3'
                    || car == '4' || car == '5' || car == '6' || car == '7' || car == '8' || car == '9') {
                //no hace nada, deja pasar
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCantPedidaKeyTyped

    private void txtNroPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroPedidoKeyTyped
        char car = evt.getKeyChar();
        if (txtNroPedido.getText().length() >= 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroPedidoKeyTyped

    private void txtCodCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCajaFocusLost
        if (!origen.equals("buscar")) {
            try {
                Caja caja = null;
                txtCodCaja.setText(txtCodCaja.getText().toUpperCase());
                caja = obtenerCaja(txtCodCaja.getText());
                this.txtNomCaja.setText(caja.getNomCaja());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al obtener descripción de la caja. ",
                        "Factura Venta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtCodCajaFocusLost

    private void txtCodSucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodSucFocusLost
        if (!origen.equals("buscar")) {
            obtenerSucursal(txtCodSuc.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtCodSucFocusLost

    private void txtCodArtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArtFocusLost
        this.txtCodArt.setText(this.txtCodArt.getText().toUpperCase());
        MtArticulos art = null;

        if (!this.txtCodArt.getText().equals("")) {
            art = obtenerArticulo(this.txtCodArt.getText().toUpperCase());

            if (null != art) {
                superArticulo = art;
                BigDecimal precio = art.getPrecioVenta();
                String cod_suc = this.txtCodSuc.getText().toUpperCase();

                this.txtDescArt.setText(art.getNomArticulo());
                this.txtPrecioUnit.setValue(precio);
                this.txtStockActual.setValue(obtenerStock(art, cod_suc));
                
                //en caso que no haya stock en existencia
                if (!this.txtStockActual.getText().isEmpty()) {
                    this.txtCantPedida.grabFocus();
                    this.txtCantPedida.selectAll();
                } else {
                    this.txtDescArt.setText("");
                    this.txtCodArt.setText("");
                    this.txtCodArt.grabFocus();
                }   
            } else {
                this.txtCodArt.grabFocus();
                this.txtCodArt.selectAll();
            }
        }
    }//GEN-LAST:event_txtCodArtFocusLost

    private void txtCantPedidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantPedidaFocusLost
        BigDecimal cantidad;
        BigDecimal stock;

        try {
            this.txtCantPedida.commitEdit();
            this.txtStockActual.commitEdit();
            this.txtPrecioUnit.commitEdit();
            if (!this.txtCantPedida.getText().equals("")) {
                cantidad = new BigDecimal(this.txtCantPedida.getValue().toString());
                stock = new BigDecimal(this.txtStockActual.getValue().toString());
                int res = stock.compareTo(cantidad);

                if (res >= 0) {

                    BigDecimal precio = new BigDecimal(this.txtPrecioUnit.getValue().toString());
                    BigDecimal total = precio.multiply(cantidad);
                    this.txtTotalUnit.setValue(total);

                } else {
                    JOptionPane.showMessageDialog(null, "El stock actual es inferior a la cantidad pedida. ",
                            "Factura Venta", JOptionPane.ERROR_MESSAGE);
                    this.txtCantPedida.grabFocus();
                }
            }
        } catch (Exception e) {
            this.txtCantPedida.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCantPedidaFocusLost

    private void txtDesctoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesctoKeyTyped
        char car = evt.getKeyChar();
        if (txtDescto.getText().length() >= 10) {
            evt.consume();
        }

        if (car == ',' || car == '0' || car == '1' || car == '2' || car == '3'
                || car == '4' || car == '5' || car == '6' || car == '7' || car == '8' || car == '9') {
            //no hace nada, deja pasar
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtDesctoKeyTyped

    private void cmdImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_cmdImprimirActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        origen = "buscar";
       this.cmdProcesarConsulta.setVisible(true);
        this.cmdCancelar.setEnabled(true);
        consultarRegistros();
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void txtCodArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodArtKeyPressed
        if (evt.getKeyCode() == VK_F9) {
            buscarArt();
        }
    }//GEN-LAST:event_txtCodArtKeyPressed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmdAgregarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarValorActionPerformed
        agregarFilasValores();
    }//GEN-LAST:event_cmdAgregarValorActionPerformed

    private void cmdQuitarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdQuitarValorActionPerformed
        int selectedRow = tabValores.getSelectedRow();

        quitarElemento(modelVal, selectedRow);
        actualizarSaldoPendiente();
    }//GEN-LAST:event_cmdQuitarValorActionPerformed

    private void tabValoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabValoresKeyPressed
        int selectedRow = tabValores.getSelectedRow();
        int selectedCol = tabValores.getSelectedColumn() - 1;

        if (selectedCol >= 0) { 
            if (evt.getKeyCode() == VK_TAB || evt.getKeyCode() == VK_ENTER) {
                controlValores(selectedRow, selectedCol);
            }
        }
    }//GEN-LAST:event_tabValoresKeyPressed

    private void tabPaneCabeceraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPaneCabeceraMouseClicked
        if (this.tabPaneCabecera.getSelectedIndex() == 2) {
            if (consultarDocPendientes(this.txtCodCliente.getText()).size() > 0) {
                this.lblPendientes.setOpaque(true);
                this.lblPendientes.setText("Este cliente posee Nota de Crédito(s) a su favor.");
            } else {
                this.lblPendientes.setOpaque(false);
                this.lblPendientes.setText("");
            }
        }
    }//GEN-LAST:event_tabPaneCabeceraMouseClicked

    private void tabPaneCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPaneCabeceraMousePressed

    }//GEN-LAST:event_tabPaneCabeceraMousePressed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        primero();
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void cmdCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCerrarActionPerformed
        this.st.close();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cmdCerrarActionPerformed

    private void cmdProcesarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarConsultaActionPerformed
        buscarRegistros();
    }//GEN-LAST:event_cmdProcesarConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Facturacion dialog = new Facturacion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdAgregarValor;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdCerrar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdImprimir;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JButton cmdProcesarConsulta;
    private javax.swing.JButton cmdQuitar;
    private javax.swing.JButton cmdQuitarValor;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfoPie;
    private javax.swing.JLabel lblPendientes;
    private javax.swing.JPanel panArticulo;
    private javax.swing.JPanel panCondPago;
    private javax.swing.JPanel panFactura;
    private javax.swing.JTable tabArticulos;
    private javax.swing.JTabbedPane tabPaneCabecera;
    private javax.swing.JTable tabValores;
    private javax.swing.JFormattedTextField txtCantArt;
    private javax.swing.JFormattedTextField txtCantPedida;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtCodCaja;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodCondPago;
    private javax.swing.JTextField txtCodEmpresa1;
    private javax.swing.JTextField txtCodMoneda;
    private javax.swing.JTextField txtCodSuc;
    private javax.swing.JTextField txtCodSucFac;
    private javax.swing.JTextField txtCodTipoComp;
    private javax.swing.JTextField txtCodTribFac;
    private javax.swing.JTextField txtCodUsuario;
    private javax.swing.JTextField txtDescArt;
    private javax.swing.JTextField txtDescConPago;
    private javax.swing.JTextField txtDescMoneda;
    private javax.swing.JTextField txtDescTipComp;
    private javax.swing.JFormattedTextField txtDescto;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtNomCaja;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtNomEmpresa1;
    private javax.swing.JTextField txtNomSuc;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNroFact;
    private javax.swing.JTextField txtNroPedido;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JFormattedTextField txtPendiente;
    private javax.swing.JFormattedTextField txtPrecioUnit;
    private javax.swing.JFormattedTextField txtStockActual;
    private javax.swing.JFormattedTextField txtTipoCambio;
    private javax.swing.JFormattedTextField txtTotal10;
    private javax.swing.JFormattedTextField txtTotal5;
    private javax.swing.JFormattedTextField txtTotalExentas;
    private javax.swing.JFormattedTextField txtTotalGral;
    private javax.swing.JFormattedTextField txtTotalUnit;
    private javax.swing.JTextField txtVencimiento;
    // End of variables declaration//GEN-END:variables

    public void inicializarCampos() {
        this.txtFechaHora.setText("");
        this.txtCodCliente.setText("");
        this.txtNomCliente.setText("");
        this.txtNroPedido.setText("");
        this.txtCodTribFac.setText("");
        this.txtCodSucFac.setText("");
        this.txtNroFact.setText("");
        this.txtVencimiento.setText("");
        this.txtObservacion.setText("");
        this.txtCantArt.setValue(0);
        this.txtDescto.setValue(0);
        this.txtTipoCambio.setValue(1);

        tableModel();
        tableModelVal();
    }

    private void habilitarCampos() {
        // habilita botones
        this.cmdGuardar.setEnabled(true);
        this.cmdCancelar.setEnabled(true);
        this.cmdBorrar.setEnabled(false);
        this.cmdNuevo.setEnabled(false);
        this.cmdAgregar.setEnabled(true);
        this.cmdQuitar.setEnabled(true);
        this.tabArticulos.setEnabled(true);

        //habilita campos de texto
        this.txtCodCliente.setEnabled(true);
        this.txtCodTipoComp.setEnabled(true);
        this.txtCodSuc.setEnabled(true);
        this.txtCodCaja.setEnabled(true);
        this.txtNroPedido.setEnabled(true);
        this.txtCodArt.setEnabled(true);
        this.txtCodCondPago.setEnabled(true);
        this.txtCodMoneda.setEnabled(true);
        this.txtObservacion.setEnabled(true);
    }

    private void deshabilitarCampos() {
        this.cmdGuardar.setEnabled(false);
        this.cmdCancelar.setEnabled(false);
        this.cmdBorrar.setEnabled(true);
        this.cmdNuevo.setEnabled(true);
        this.cmdAgregar.setEnabled(false);
        this.cmdQuitar.setEnabled(false);
        this.tabArticulos.setEnabled(false);

        //habilita campos de texto
        this.txtCodCliente.setEnabled(false);
        this.txtCodTipoComp.setEnabled(false);
        this.txtCodSuc.setEnabled(false);
        this.txtCodCaja.setEnabled(false);
        this.txtNroPedido.setEnabled(false);
        this.txtCodArt.setEnabled(false);
        this.txtCodCondPago.setEnabled(false);
        this.txtCodMoneda.setEnabled(false);
        this.txtObservacion.setEnabled(false);

        this.lblPendientes.setOpaque(false);
    }

    //limpia los campos del area de carga de Articulos
    private void limpiarCamposArticulo() {
        this.txtCodArt.setText("");
        this.txtDescArt.setText("");
        this.txtPrecioUnit.setValue(0);
        this.txtStockActual.setValue(0);
        this.txtCantPedida.setText("");
        this.txtTotalUnit.setValue(0);
        this.txtDescto.setValue(0);
    }

    private void consultarRegistros() {
        habilitarCamposBusqueda();
    }

    private void habilitarCamposBusqueda() {
        this.txtCodTipoComp.setText("");
        this.txtDescTipComp.setText("");
        this.txtCodCondPago.setText("");
        this.txtDescConPago.setText("");
        this.txtCodMoneda.setText("");
        this.txtDescMoneda.setText("");
        this.txtCodCaja.setText("");
        this.txtNomCaja.setText("");
        this.txtCodSuc.setText("");
        this.txtNomCaja.setText("");

        this.txtFechaHora.setEditable(true);
        this.txtFechaHora.setBackground(new Color(255, 255, 204));
        this.txtCodTipoComp.setEditable(true);
        this.txtCodTipoComp.setBackground(new Color(255, 255, 204));
        this.txtCodSucFac.setEditable(true);
        this.txtCodSucFac.setBackground(new Color(255, 255, 204));
        this.txtCodTribFac.setEditable(true);
        this.txtCodTribFac.setBackground(new Color(255, 255, 204));
        this.txtNroFact.setEditable(true);
        this.txtNroFact.setBackground(new Color(255, 255, 204));
        this.txtCodCliente.setEditable(true);
        this.txtCodCliente.setBackground(new Color(255, 255, 204));
        this.txtCodSuc.setEditable(true);
        this.txtCodSuc.setBackground(new Color(255, 255, 204));
        this.txtCodCaja.setEditable(true);
        this.txtCodCaja.setBackground(new Color(255, 255, 204));
        this.txtNroPedido.setEditable(true);
        this.txtNroPedido.setBackground(new Color(255, 255, 204));
        this.txtCodCondPago.setEditable(true);
        this.txtCodCondPago.setBackground(new Color(255, 255, 204));
        this.txtCodMoneda.setEditable(true);
        this.txtCodMoneda.setBackground(new Color(255, 255, 204));
    }

    private void deshabilitarCamposBusqueda() {
        this.txtFechaHora.setEditable(false);
        this.txtFechaHora.setBackground(new Color(204, 255, 255));
        this.txtCodTipoComp.setEditable(false);
        this.txtCodTipoComp.setBackground(new Color(255, 255, 255));
        this.txtCodSucFac.setEditable(false);
        this.txtCodSucFac.setBackground(new Color(255, 255, 255));
        this.txtCodTribFac.setEditable(false);
        this.txtCodTribFac.setBackground(new Color(255, 255, 255));
        this.txtNroFact.setEditable(false);
        this.txtNroFact.setBackground(new Color(255, 255, 255));
        this.txtCodCliente.setEditable(false);
        this.txtCodCliente.setBackground(new Color(255, 255, 255));
        this.txtCodSuc.setEditable(false);
        this.txtCodSuc.setBackground(new Color(255, 255, 255));
        this.txtCodCaja.setEditable(false);
        this.txtCodCaja.setBackground(new Color(255, 255, 255));
        this.txtNroPedido.setEditable(false);
        this.txtNroPedido.setBackground(new Color(255, 255, 255));
        this.txtCodCondPago.setEditable(false);
        this.txtCodCondPago.setBackground(new Color(255, 255, 255));
        this.txtCodMoneda.setEditable(false);
        this.txtCodMoneda.setBackground(new Color(255, 255, 255));

        origen = "";
        this.cmdProcesarConsulta.setEnabled(false);
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

    private void buscarRegistros() {
        try {
            String SqlQuery = "select nro_trans from factura_venta where nro_trans > 0 ";

            if (!this.txtFechaHora.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and fecha >= to_timestamp('" + this.txtFechaHora.getText().trim() + "', 'dd/MM/yyyy')";
            }
            if (!this.txtCodTipoComp.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and tipo_comprobante = '" + this.txtCodTipoComp.getText() + "'";
            }
            if (this.txtCodSucFac.getText().trim().length() == 3) {
                SqlQuery = SqlQuery + " and cod_suc_fac = '" + this.txtCodSucFac.getText().trim() + "'";
            }
            if (this.txtCodTribFac.getText().trim().length() == 3) {
                SqlQuery = SqlQuery + " and cod_tribut_fac = '" + this.txtCodTribFac.getText().trim() + "'";
            }
            if (!this.txtNroFact.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and nro_docum = " + this.txtNroFact.getText();
            }
            if (!this.txtCodCliente.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_cliente = '" + this.txtCodCliente.getText().trim() + "'";
            }
            if (!this.txtCodSuc.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_suc = '" + this.txtCodSuc.getText().trim() + "'";
            }
            if (!this.txtCodCaja.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_caja = '" + this.txtCodCaja.getText().trim() + "'";
            }
            if (!this.txtNroPedido.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and nro_comanda = " + this.txtNroPedido.getText().trim();
            }
            if (!this.txtCodCondPago.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and cond_pago = " + this.txtCodCondPago.getText();
            }
            if (!this.txtCodMoneda.getText().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_moneda = '" + this.txtCodMoneda.getText().trim() + "'";
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
                this.cmdBorrar.setEnabled(true);
                String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
                this.lblInfoPie.setText(mensaje);

            } else if (ArrayPrimaryKey.size() == 1) {
                posicion = 0;
                recuperarRegistros(posicion);
                this.cmdBorrar.setEnabled(true);

                //deshabilitarACmpoBusqueda();
                String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
                this.lblInfoPie.setText(mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "No existen registros para mostrar.", "Buscar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | HibernateException e) {

        }
    }

    private void recuperarRegistros(int indice) {
        int nroTrans = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        masterNrotrans = BigInteger.valueOf(nroTrans);
        FacturaVenta factCab = recuperarCabecera(nroTrans);
        List<FacturaVentaDetalle> factDet = recuperarDetalle(nroTrans);
        List<ValoresDet> valDet = recuperarValores(nroTrans, "FT");
        cargarDetalle(factCab, factDet, valDet);
    }

    public MtClientes buscarCliente(String codigo) {
        MtClientes cliente = null;
        try {
            Query query = st.createQuery("From MtClientes c Where c.nroDocum = ? and c.esActivo = 'S'");
            query.setParameter(0, codigo);
            cliente = (MtClientes) query.uniqueResult();
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Existen varios clientes con el mismo codigo. Busque con el asistente.",
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }

    private void valoresDefecto() {
        try {
            Caja caja = null;
            obtenerCajero(this.usuario);

            this.txtCodUsuario.setText(this.usuario);
            obtenerUsuario(this.usuario);
            
            try {
                this.txtCodCaja.setText(masterCajero.getCaja().getCodCaja());
                this.txtNomCaja.setText(masterCajero.getCaja().getNomCaja());
                //caja = obtenerCaja(masterCajero.getCodCaja());
                caja = masterCajero.getCaja();

                //MtSucursales suc = obtenerSucursal(masterCajero.getCodSucursal());
                this.txtCodSuc.setText(masterCajero.getMtSucursales().getCodSucursal());
                this.txtNomSuc.setText(masterCajero.getMtSucursales().getNomSucursal());
                
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Usuario no registrado como cajero.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            }
            
            this.txtCodTipoComp.setText("FT");
            obtenerTipoComprobante("FT");

            this.txtCodCondPago.setText("1");
            obtenerCondPago(1);

            this.txtCodMoneda.setText("1");
            obtenerMoneda(1);

        } catch (Exception e) {
        }
    }

    //obtiene descripción de tipo de comprobante.
    public MtTipoComprobantes obtenerTipoComprobante(String cod) {
        MtTipoComprobantes comp = null;
        try {
            comp = (MtTipoComprobantes) st.get(MtTipoComprobantes.class, cod);
            if (comp == null) {
                JOptionPane.showMessageDialog(null, "Código buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtDescTipComp.setText(comp.getDescripcion());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return comp;
    }

    private MtBancos obtenerBanco(String cod) {
        MtBancos bco = null;
        try {
            bco = (MtBancos) st.get(MtBancos.class, cod);

            if (bco == null) {
                JOptionPane.showMessageDialog(null, "Banco buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta de bancos. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return bco;
    }

    private MtProcTarjetas obtenerProcesadora(int cod) {
        MtProcTarjetas proc = null;
        try {
            proc = (MtProcTarjetas) st.get(MtProcTarjetas.class, cod);

            if (proc == null) {
                JOptionPane.showMessageDialog(null, "La Procesadoa buscada no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta de procesadora de tarjetas. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return proc;
    }

    //obtiene descripción de condición de pago.
    public MtCondicionPago obtenerCondPago(int cod) {
        MtCondicionPago cond = null;
        try {
            cond = (MtCondicionPago) st.get(MtCondicionPago.class, cod);
            if (cond == null) {
                JOptionPane.showMessageDialog(null, "Código buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtDescConPago.setText(cond.getDescripcion());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return cond;
    }

    //obtiene descripción de moneda.
    public MtMonedas obtenerMoneda(int cod) {
        MtMonedas mon = null;
        try {
            mon = (MtMonedas) st.get(MtMonedas.class, cod);
            if (mon == null) {
                JOptionPane.showMessageDialog(null, "Código buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtDescMoneda.setText(mon.getNomMoneda());
            }
        } catch (HeadlessException | HibernateException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return mon;
    }

    //obtiene descripcion de la forma de pago.
    public MtFormaPago obtenerFormaPago(int cod) {
        MtFormaPago comp = null;
        try {
            comp = (MtFormaPago) st.get(MtFormaPago.class, cod);
            if (comp == null) {
                JOptionPane.showMessageDialog(null, "Código buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //this.txtDescFormaPago.setText(comp.getDescripcion());
            }
        } catch (HeadlessException | HibernateException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return comp;
    }

    //retorna la caja asignada.
    public Caja obtenerCaja(String cod) {
        Caja caja = null;
        try {
            caja = (Caja) st.get(Caja.class, cod);
            if (caja == null) {
                JOptionPane.showMessageDialog(null, "Código de caja buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtNomCaja.setText(caja.getNomCaja());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return caja;
    }

    //retorna la sucursal
    public MtSucursales obtenerSucursal(String cod) {
        MtSucursales suc = null;
        try {
            suc = (MtSucursales) st.get(MtSucursales.class, cod);
            if (suc == null) {
                JOptionPane.showMessageDialog(null, "Código de sucursal buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | HibernateException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return suc;
    }

    public MtUsuarios obtenerUsuario(String cod) {
        MtUsuarios user = null;
        try {
            user = (MtUsuarios) st.get(MtUsuarios.class, cod);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Código de usuario buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtNomUsuario.setText(user.getNomUsuario());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    //obtiene el datos del cajero
    public void obtenerCajero(String cajero) {
        MtCajeros caj = null;

        try {
            //Query query = st.createQuery("From MtCajeros c Where c.getMtUsuarios = ? and c.activo = 'S'");
            SQLQuery query = st.createSQLQuery("select * From mt_Cajeros c where c.cod_usuario = ? and c.activo = 'S'");
            query.setParameter(0, usuario);
            query.addEntity(MtCajeros.class);
            try {
                caj = (MtCajeros) query.uniqueResult();
                if (caj != null) {
                    this.masterCajero = caj;
                } else {
                    JOptionPane.showMessageDialog(null, "El cajero " + " no existe o no se encuentra activo",
                            "Facturación", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cajero activo para varias cajas." + e.getMessage(),
                        "Facturación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al recuperar registros del Cajero."
                    + "\n" + ex.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private int buscarTipoCambio(int cod) {
        Cargar cargar = new Cargar();
        BigDecimal tipoCambio = cargar.buscarTipoCambio(new Date(), cod, 'V');
        int retorno = 0;

        retorno = tipoCambio.intValue();

        return retorno;
    }
    
    private String calcularVencimiento(String fechaInicial, int dias) {
        Calendar fechaFinal = UtilidadesCalendario.StringACalendario(fechaInicial);
        fechaFinal.add(Calendar.DATE, dias);
        String retorno = UtilidadesCalendario.CalendarioAString(fechaFinal);
        return retorno;
    }

    //obtiene el nro de comprobante asignado a la caja y que se encuentre activo.
    public void obtenerNroDocumento() {
        MtComprobantes comp = null;
        try {
            //Query query = st.createQuery("From MtComprobantes c Where c.codSucursal = ? "
                   // + " and c.codCaja = ? and c.tipoDocum = ? and c.esActivo = true");
            
            SQLQuery query = st.createSQLQuery("Select * from mt_comprobantes c Where c.cod_sucursal = ? "
                    + " and c.cod_caja = ? and c.tipo_docum = ? and c.es_activo = true");
            query.setParameter(0, this.txtCodSuc.getText());
            query.setParameter(1, this.txtCodCaja.getText());
            query.setParameter(2, this.txtCodTipoComp.getText());
            query.addEntity(MtComprobantes.class);
            
            try {
                comp = (MtComprobantes) query.uniqueResult();
                //en caso que no esté asignado un comprobante con la caja.
                if (comp == null) {
                    JOptionPane.showMessageDialog(null, "No se encuentra comprobante asignado a esta caja.",
                            "Facturación", JOptionPane.INFORMATION_MESSAGE);
                    this.txtCodTribFac.setText("");
                    this.txtCodSucFac.setText("");
                    this.txtNroFact.setText("");
                    this.cmdGuardar.setEnabled(false);
                } else {
                    //valida vencimiento del comprobante. Solo FT y NC tienen Timbrado y Vencimiento
                    if (comp.getTipoDocum().equals("FT") || comp.getTipoDocum().equals("NC")) {
                        Fecha f = new Fecha();
                        if (f.obtenerFechaSistema().before(comp.getVencimiento())) {
                            this.txtCodTribFac.setText(comp.getCodTribut());
                            this.txtCodSucFac.setText(comp.getCodSucFac());
                            this.txtNroFact.setText((comp.getNroFactura()).toString());
                            this.cmdGuardar.setEnabled(true);
                        } else {
                            //en caso que haya vencido desplegar mensaje.
                            JOptionPane.showMessageDialog(null, "El Timbrado asignado al tipo comprobante está vencido."
                                    + "\n" + "Asigne nuevo lote a la caja.",
                                    "Facturación", JOptionPane.ERROR_MESSAGE);
                            this.txtCodTribFac.setText("");
                            this.txtCodSucFac.setText("");
                            this.txtNroFact.setText("");
                            this.cmdGuardar.setEnabled(false);
                        }
                    } else {
                        this.cmdGuardar.setEnabled(true);
                        this.txtCodTribFac.setText(comp.getCodTribut());
                        this.txtCodSucFac.setText(comp.getCodSucFac());
                        this.txtNroFact.setText((comp.getNroFactura()).toString());
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cajero activo para varias cajas. "
                        + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al recupera registros del Cajero. "
                    + "\n" + ex.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    //obtiene los datos del articulo a partir del código.
    public MtArticulos obtenerArticulo(String cod) {
        MtArticulos art = null;
        try {
            //art = (MtArticulos) st.get(MtArticulos.class, cod);
            Query query = st.createQuery("From MtArticulos a Where a.codArticulo = ? and a.esMateriaPrima <> 'M'");
            query.setParameter(0, cod);

            art = (MtArticulos) query.uniqueResult();

            if (art == null) {
                JOptionPane.showMessageDialog(null, "Código del artículo buscado no existe.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return art;
    }

    //obtiena la cantidad disponible en Stock de dicho articulo
    public BigDecimal obtenerStock(MtArticulos art, String suc) {
        BigDecimal stock = BigDecimal.ZERO;

        try {
            Query query = st.createSQLQuery("SELECT SUM(e.cantidad) FROM st_existencia_suc e "
                    + " WHERE e.cod_articulo = ? and e.cod_sucursal = ? and e.cod_estado = 'STOCK'");
            query.setParameter(0, art.getCodArticulo().toUpperCase());
            query.setParameter(1, suc.toUpperCase());

            stock = new BigDecimal((query.uniqueResult()).toString());

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(null, "Artículo no existe para la sucursal.",
                    "Error - Consulta de Stock", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido obtener el stock del artículo."
                    + "\n" + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }

        return stock;
    }

    private BigInteger obtenerNroTrans() {
        BigInteger nroTrans = BigInteger.ZERO;

        try {
            Query query = st.createSQLQuery("SELECT NEXTVAL('factura_venta_nro_factura_seq')");
            nroTrans = (BigInteger) query.uniqueResult();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al generar nro. de transacción. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return nroTrans;
    }

    public ComandaCab obtenerComandaCab(int nroComanda) {
        ComandaCab retorno = null;
        try {
            Query query = st.createQuery("FROM ComandaCab c "
                    + " WHERE c.nroComanda = ? and upper(c.estado) = 'P'");
            query.setParameter(0, nroComanda);

            retorno = (ComandaCab) (query.uniqueResult());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al recuperar registro del pedido nro: "
                    + nroComanda + "." + "\n" + e.getMessage(), "Facturación Venta",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return retorno;
    }

    //agrega los datos del artículo en la grilla de artículos
    private void cargarArticulo(MtArticulos articulo, BigDecimal subtotal, BigDecimal impDesc,
        BigDecimal cantPedida, String descto, int tipo) {
        BigDecimal impuesto = calcularImpuesto(subtotal, articulo.getImpuesto());
        BigDecimal total = subtotal.subtract(impDesc);

        try {
            model.addRow(new Object[]{
                articulo.getCodArticulo(),
                articulo.getNomArticulo(),
                articulo.getPrecioVenta(),
                cantPedida,
                subtotal,
                articulo.getImpuesto(),
                impuesto,
                descto,
                impDesc,
                total,
                tipo});

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar artículo."
                    + "\n" + ex.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        actualizarTotales();
        this.txtCantArt.setValue(model.getRowCount());
    }

    //método que permite la carga de articulos desde una comanda de pedido.
    private void cargarPedido() {
        ComandaCab cab = new ComandaCab();
        int nroComanda = Integer.parseInt(this.txtNroPedido.getText());

        try {
            //procede a la busqueda de la cabecera de la comanda.

            // cab = (ComandaCab) st.get(ComandaCab.class, nroComanda);
            cab = obtenerComandaCab(nroComanda);

            if (cab == null) {
                JOptionPane.showMessageDialog(null, "El Nro. de Pedido buscado no existe"
                        + " o ya ha sido utilizado.", "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //si existe el pedido procede a recuperar el detalle del pedido
                //### Solo importan los datos del detalle.

                List<ComandaDet> lista = (List<ComandaDet>) st.createQuery(
                        "FROM ComandaDet cd JOIN cd.id i WHERE i.nroComanda = ? "
                        + "and upper(cd.estado) = 'P'")
                        .setParameter(0, nroComanda)
                        .list();

                for (ComandaDet comDet : lista) {

                    MtArticulos art = new MtArticulos();
                    BigDecimal subtotal = BigDecimal.ZERO;
                    BigDecimal impDesc = BigDecimal.ZERO;
                    BigDecimal cantPedida = BigDecimal.ZERO;

                    art = obtenerArticulo(comDet.getCodArticulo().toUpperCase());
                    subtotal = comDet.getSubtotal();
                    cantPedida = comDet.getCantidad();

                    cargarArticulo(art, subtotal, impDesc, cantPedida, "0", 1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al recuperar registros de la Base de Datos. "
                    + "\n" + e.getMessage(), "Facturación por Comanda de Pedido",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    //calcular el importe del impuesto según el porcentaje de este
    private BigDecimal calcularImpuesto(BigDecimal valor, int impuesto) {
        //FormatearNumero vConvertidor = new FormatearNumero();
        BigDecimal monto = BigDecimal.ZERO;
        BigDecimal factor5 = new BigDecimal(21);
        BigDecimal factor10 = new BigDecimal(11);
        //BigDecimal factor = new BigDecimal(impuesto);
        //factor = factor.divide(new BigDecimal("100"));

        try {
            if(impuesto == 5){
                 monto = valor.divide(factor5, 2, RoundingMode.HALF_EVEN);
            } else {
                monto = valor.divide(factor10, 2, RoundingMode.HALF_EVEN);
            }

            if (this.txtCodMoneda.getText().equals("1")) {
                monto = monto.setScale(0, BigDecimal.ROUND_HALF_UP);
            } else {
                monto = monto.setScale(2, BigDecimal.ROUND_HALF_UP);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al calcular valor de impuesto."
                    + "\n" + ex.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return monto;
    }

    //calcular el monto de descuento otorgado según el porcentaje de este
    private BigDecimal calcularDescuento(Object porc, Object importe) {
        // FormatearNumero vConvertidor = new FormatearNumero();
        BigDecimal monto = BigDecimal.ZERO;
        BigDecimal valor = BigDecimal.ZERO;//importe
        BigDecimal descto = BigDecimal.ZERO;//porcentaje del descuento
        BigDecimal cien = new BigDecimal("100");// convertir int(100) a BigDecimal(100)

        valor = new BigDecimal(importe.toString());
        descto = new BigDecimal(porc.toString());
        BigDecimal factor = descto.divide(cien);

        try {
            monto = valor.multiply(factor);

            if (this.txtCodMoneda.getText().equals("1")) {
                monto = monto.setScale(0, BigDecimal.ROUND_HALF_UP);
            } else {
                monto = monto.setScale(2, BigDecimal.ROUND_HALF_UP);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al calcular valor del descuento."
                    + "\n" + ex.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
        return monto;
    }

    private void actualizarTotales() {
        //FormatearNumero vConvertidor = new FormatearNumero();
        BigDecimal totalGral = BigDecimal.ZERO;
        BigDecimal total10 = BigDecimal.ZERO;
        BigDecimal total5 = BigDecimal.ZERO;
        BigDecimal totalExenta = BigDecimal.ZERO;
        BigDecimal importe = BigDecimal.ZERO;
        int impuesto = 0;
        int cantArt = model.getRowCount();

        try {
            if (cantArt > 0) {
                for (int i = 0; i < cantArt; i++) {
                    impuesto = Integer.parseInt(model.getValueAt(i, 5).toString());
                    importe = new BigDecimal(model.getValueAt(i, 9).toString());
                    BigDecimal impImp = new BigDecimal(model.getValueAt(i, 6).toString());

                    /*if (impuesto > 0) {
                     totalGravadas = totalGravadas.add(importe);
                     } else {
                     totalExenta = totalExenta.add(importe);
                     }*/
                    if (impuesto > 0) {
                        if (impuesto == 5) {
                            total5 = total5.add(impImp);
                        } else {
                            total10 = total10.add(impImp);
                        }
                    } else {
                        totalExenta = totalExenta.add(importe);
                    }
                    totalGral = totalGral.add(importe);
                }
            } 

            this.txtTotalExentas.setValue(totalExenta);
            this.txtTotal5.setValue(total5);
            this.txtTotal10.setValue(total10);
            this.txtTotalGral.setValue(totalGral);
            this.txtPendiente.setValue(totalGral);
            this.txtCantArt.setValue(model.getRowCount());

        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar totales."
                    + "\n" + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void quitarElemento(DefaultTableModel modelo, int filaSel) {
        try {
            //int selectedRow = this.tabArticulos.getSelectedRow();
            int selectedRow = filaSel;
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar.",
                        "Facturación", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.removeRow(selectedRow);
            }
            //actualizarTotales();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al quitar artículo de la lista. "
                    + e.getMessage(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardar() {
        int cant = model.getRowCount();

        if (cant == 0) {
            JOptionPane.showMessageDialog(null, "No hay artículos en la lista. No se puede guardar.",
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                guardarCabecera();
                
                int seleccion = JOptionPane.showConfirmDialog(null, "Imprimir comprobante de venta?",
                        "Facturación", JOptionPane.YES_NO_OPTION);
                if (seleccion == 0) {
                    imprimir();
                }
                
                arranque();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar registro. " + "\n" + ex.getMessage(),
                        "Facturación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //persiste en la BD los datos de la factura_cabecera
    private void guardarCabecera() {
        Caja caja = new Caja();
        MtTipoComprobantes tcomp = new MtTipoComprobantes();
        MtCondicionPago condp = new MtCondicionPago();
        MtMonedas mon = new MtMonedas();
        MtClientes cliente = new MtClientes();

        Date fecha = new Date();
        Fecha fec = new Fecha();
        int nroPedido = 0;

        try {
            st.beginTransaction();

            if (!this.txtNroPedido.getText().equals("")) {
                nroPedido = Integer.parseInt(this.txtNroPedido.getText());
            }

            //caja = obtenerCaja(masterCajero.getCodCaja());
            caja = masterCajero.getCaja();
            tcomp = obtenerTipoComprobante(this.txtCodTipoComp.getText());
            condp = obtenerCondPago(Integer.parseInt(this.txtCodCondPago.getText()));
            mon = obtenerMoneda(Integer.parseInt(this.txtCodMoneda.getText()));
            cliente = buscarCliente(this.txtCodCliente.getText());

            FacturaVenta facVen = new FacturaVenta();

            facVen.setNroTrans(masterNrotrans.intValue());
            facVen.setFecha(fec.fechaHoraDate(this.txtFechaHora.getText()));
            facVen.setTotalGravada(new BigDecimal(this.txtTotal10.getValue().toString()));
            facVen.setTotalExenta(new BigDecimal(this.txtTotalExentas.getValue().toString()));
            facVen.setTotalIva10(new BigDecimal(this.txtTotal10.getValue().toString()));
            facVen.setTotalIva5(new BigDecimal(this.txtTotal5.getValue().toString()));
            facVen.setNroComanda(nroPedido);
            facVen.setCodSucFac(this.txtCodSucFac.getText());
            facVen.setCodTributFac(this.txtCodTribFac.getText());
            facVen.setNroDocum(Integer.parseInt(this.txtNroFact.getText()));
            facVen.setMtClientes(cliente);
            facVen.setCaja(caja);
            facVen.setMtSucursales(masterCajero.getMtSucursales());
            facVen.setMtTipoComprobantes(tcomp);
            facVen.setMtCondicionPago(condp);
            //fija estado de comprobante
            if (condp.getCodCond() == 1) {
                facVen.setEstado('C');
            } else {
                facVen.setEstado('P');
            }
            //formatear fecha vencimiento en caso de comprobantes a credito
            if (this.txtVencimiento.getText().equals("")) {
                facVen.setVencimiento(null);
            } else {
                facVen.setVencimiento(fec.fechaDate(this.txtVencimiento.getText()));
            }

            facVen.setMtMonedas(mon);
            facVen.setTipoCambio(new BigDecimal(this.txtTipoCambio.getValue().toString()));
            facVen.setObservacion(this.txtObservacion.getText());
            facVen.setAccionMod("Nuevo");
            facVen.setUsuarioMod(this.usuario);
            facVen.setFechaMod(fecha);

            st.save(facVen);

            actualizarNroComprobante();

            if (!this.txtNroPedido.getText().isEmpty()
                    || !this.txtNroPedido.getText().equals("0")) {
                actualizarEstadoComanda(nroPedido);
            }

            guardarDetalle();
            guardarValores(tcomp.getCodComp());

            //guarda el saldo, en caso que sea crédito o NC
            if (condp.getCodCond() != 1) {
                guardarPendiente(facVen);
            }

            st.getTransaction().commit();

            model.setNumRows(0);
            deshabilitarCampos();
            
        } catch (Exception ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar registro de la FacturaCab. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Facturación", JOptionPane.ERROR_MESSAGE);
            this.txtCodCliente.grabFocus();
            ex.printStackTrace();
        }
    }

    //guarda datos del detalle de la factura
    private void guardarDetalle() {
        FormatearNumero conv = new FormatearNumero();
        Date fecha = new Date();
        int cantArt = model.getRowCount();

        try {
            for (int i = 0; i < cantArt; i++) {

                MtArticulos art = new MtArticulos();
                FacturaVentaDetalle facDet = new FacturaVentaDetalle();
                FacturaVentaDetalleId facDetId = new FacturaVentaDetalleId();
                BigDecimal precioUnit = new BigDecimal(model.getValueAt(i, 2).toString());
                BigDecimal cantidad = new BigDecimal(model.getValueAt(i, 3).toString());

                art = obtenerArticulo(model.getValueAt(i, 0).toString());

                facDetId.setNroTrans(masterNrotrans.intValue());
                facDetId.setLinea(i + 1);
                facDet.setId(facDetId);
                facDet.setMtArticulos(art);
                facDet.setCantidad(cantidad);
                facDet.setPrecioUnitaio(precioUnit);
                facDet.setSubtotal(new BigDecimal(model.getValueAt(i, 4).toString()));
                facDet.setPorcIva(Integer.parseInt(model.getValueAt(i, 5).toString()));
                facDet.setImporteIva(new BigDecimal(model.getValueAt(i, 6).toString()));
                facDet.setPorcDto(new BigDecimal(model.getValueAt(i, 7).toString()));
                facDet.setImpDescuento(new BigDecimal(model.getValueAt(i, 8).toString()));
                facDet.setTotal(conv.toDecimal(model.getValueAt(i, 9).toString()));
                facDet.setAccionMod("Nuevo");
                facDet.setUsuarioMod(this.usuario);
                facDet.setFechaMod(fecha);

                st.save(facDet);

                int tipo = Integer.parseInt(model.getValueAt(i, 7).toString());
                if (tipo == 0) {
                    //actualiza stock solo si es compra directa. No por comanda
                    actualizarStock(art, cantidad);
                }
            }
        } catch (Exception e) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar detalle de la factura. "
                    + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    //guarda el saldo crédito en la tabala pendientes para su posterior cobro
    public void guardarPendiente(FacturaVenta facVen) {
        SaPendientes pend = new SaPendientes();
        Date fecha = new Date();

        try {

            pend.setNroTrans(facVen.getNroTrans());
            pend.setCodDocum(facVen.getMtTipoComprobantes().getCodComp());
            pend.setCodTit(facVen.getMtClientes().getCodTit());
            pend.setCodSucFac(facVen.getCodSucFac());
            pend.setCodTributFac(facVen.getCodTributFac());
            pend.setNroDocum(facVen.getNroDocum());
            pend.setFecDoc(facVen.getFecha());
            pend.setVencimiento(facVen.getVencimiento());
            pend.setCodMoneda(facVen.getMtMonedas().getCodMoneda());
            pend.setImporteOrigen(facVen.getTotalGravada().add(facVen.getTotalExenta()));
            pend.setSaldo(facVen.getTotalGravada().add(facVen.getTotalExenta()));
            pend.setAccionMod("Nuevo");
            pend.setUsuarioMod(this.usuario);
            pend.setFechaMod(fecha);

            st.save(pend);

        } catch (Exception ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar registro en sa_pendientes. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarValores(String tipoComp) {
        int cantArt = modelVal.getRowCount();

        try {
            for (int i = 0; i < cantArt; i++) {

                ValoresDet val = new ValoresDet();
                ValoresDetId id = new ValoresDetId();

                int forma_pago = Integer.parseInt(modelVal.getValueAt(i, 0).toString());
                int emisor = Integer.parseInt(modelVal.getValueAt(i, 2).toString());
                int moneda = Integer.parseInt(modelVal.getValueAt(i, 4).toString());
                int tc = Integer.parseInt(modelVal.getValueAt(i, 6).toString());
                int cuotas = Integer.parseInt(modelVal.getValueAt(i, 9).toString());
                int ref_docum = Integer.parseInt(modelVal.getValueAt(i, 10).toString());
                BigDecimal importe = new BigDecimal(modelVal.getValueAt(i, 8).toString());

                id.setNroTrans(masterNrotrans.intValue());
                id.setLinea(i + 1);
                id.setCodDocum(tipoComp);
                val.setId(id);
                val.setCodFormaPago(forma_pago);
                val.setCodEmisor(emisor);
                val.setCodMoneda(moneda);
                val.setTipoCambio(tc);
                val.setRefOperacion(modelVal.getValueAt(i, 7).toString());
                val.setImporte(importe);
                val.setCuotas(cuotas);
                val.setRefDocum(ref_docum);

                //actualiza saldos de la NC
                if (forma_pago == 4) {
                    ActualizarNC actualizar = new ActualizarNC();
                    actualizar.actualizarNC(ref_docum, importe);
                }

                st.save(val);
            }
        } catch (Exception ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar el detalle de los valores. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEstadoComanda(int comanda) {
        try {

            Query query = st.createSQLQuery("update comanda_cab set estado = 'C' "
                    + " WHERE nro_comanda = ?");
            query.setParameter(0, comanda);
            query.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar estado de nro de pedido: "
                    + comanda + ". " + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    //actualiza el stock del articulo
    public void actualizarStock(MtArticulos art, BigDecimal cantidad) {
        String suc = this.txtCodSuc.getText().toUpperCase();

        try {
            Query query = st.createSQLQuery("update st_existencia_suc set cantidad = (cantidad - ?) "
                    + " WHERE cod_articulo = ? and cod_sucursal = ? and cod_estado = 'STOCK'");
            query.setParameter(0, cantidad);
            query.setParameter(1, art.getCodArticulo().toUpperCase());
            query.setParameter(2, suc.toUpperCase());
            query.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el stock del articulo"
                    + "(" + art.getCodArticulo() + ")." + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    //actualiza el nro de comprobantes.
    public void actualizarNroComprobante() {
        MtComprobantes comp = new MtComprobantes();
        String tipoDocum = this.txtCodTipoComp.getText();
        String caja = this.txtCodCaja.getText();
        String codSucFac = this.txtCodSucFac.getText();
        String codTributFac = this.txtCodTribFac.getText();
        String codSuc = this.txtCodSuc.getText();
        int actual = 0;

        try {
            SQLQuery query = st.createSQLQuery(" select * From mt_comprobantes c Where c.tipo_docum = ? "
                    + " and c.cod_tribut = ? and c.cod_suc_fac = ? and c.cod_caja = ? "
                    + " and c.cod_sucursal = ? and c.es_activo = true");
            query.setParameter(0, tipoDocum);
            query.setParameter(1, codTributFac);
            query.setParameter(2, codSucFac);
            query.setParameter(3, caja);
            query.setParameter(4, codSuc);
            query.addEntity(MtComprobantes.class);

            comp = (MtComprobantes) query.uniqueResult();

            if (comp == null) {

            } else {
                actual = comp.getNroFactura();
                comp.setNroFactura(actual + 1);

                try {
                    st.update(comp);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el nro. de comprobante. "
                            + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Facturación", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el nro. de comprobante. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarSaldoPendiente() {
        int cantArt = modelVal.getRowCount();

        try {
            this.txtTotalGral.commitEdit();
            BigDecimal pendiente = new BigDecimal(this.txtTotalGral.getValue().toString());
            BigDecimal sumImporte = BigDecimal.ZERO;
            BigDecimal importe = BigDecimal.ZERO;

            for (int i = 0; i < cantArt; i++) {
                importe = new BigDecimal(tabValores.getValueAt(i, 8).toString());
                sumImporte = sumImporte.add(importe);
            }

            BigDecimal saldo = pendiente.subtract(sumImporte);
            this.txtPendiente.setValue(saldo);

            if (saldo.compareTo(BigDecimal.ZERO) < 0) {
                JOptionPane.showMessageDialog(null, "El importe a abonar es superior al importe de la compra. "
                        + "\n" + "Por favor verificar montos.", "Facturación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean verificarMontos() {
        boolean retorno = false;
        try {
            this.txtPendiente.commitEdit();
            BigDecimal pendiente = new BigDecimal(this.txtPendiente.getValue().toString());
            retorno = pendiente.compareTo(BigDecimal.ZERO) == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    private void buscar() {
        try {
            Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de clientes", "mt_clientes", "nro_docum", "nom_tit");
            formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
            formBusqueda.setVisible(true);
            String codigo = formBusqueda.getCodigo();
            String nombre = formBusqueda.getDescripcion();
            if (nombre != null) {
                this.txtCodCliente.setText(codigo);
                this.txtNomCliente.setText(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formulario padre. " + "\n"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarArt() {
        try {
            BusquedaArticulos formBusqueda = new BusquedaArticulos(this, true, 
                    "Buscar Artículo", "mt_articulos", "cod_articulo", "nom_articulo", "venta");
            formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
            formBusqueda.setVisible(true);
            String codigo = formBusqueda.getCodigo();
            String nombre = formBusqueda.getDescripcion();
            if (nombre != null) {
                this.txtCodArt.setText(codigo);
                this.txtDescArt.setText(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formulario búsqueda de Artículos. " + "\n"
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarNC(int selectedRow) {
        SaPendientes pend = new SaPendientes();
        if (this.txtNomCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar código de cliente.",
                    "Factura Venta", JOptionPane.ERROR_MESSAGE);
            this.txtCodCliente.grabFocus();
        } else {

            String cliente = this.txtCodCliente.getText();
            try {
                BuscarComprobante formBusqueda
                        = new BuscarComprobante(this, true, "NC", cliente);
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);

                int codigo = Integer.parseInt(formBusqueda.getCodigoRetorno());

                if (codigo > 0) {
                    pend = buscarFacturaPend(codigo);

                    tabValores.setValueAt(pend.getCodTributFac() + "-" + pend.getCodSucFac()
                            + "-" + pend.getNroDocum(), selectedRow, 7);

                    tabValores.setValueAt(pend.getSaldo(), selectedRow, 8);
                    saldoNc = pend.getSaldo();
                    tabValores.setValueAt(pend.getNroTrans(), selectedRow, 10);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al realizar búsqueda de comprobante. " + "\n"
                        + e.getMessage(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private SaPendientes buscarFacturaPend(int nroTrans) {
        SaPendientes pend = new SaPendientes();
        try {
            pend = (SaPendientes) st.load(SaPendientes.class, nroTrans);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al recuperar comprobante. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Buscar Nota de Crédito", JOptionPane.ERROR_MESSAGE);
        }
        return pend;
    }

    private void agregarFilasValores() {
        try {
            modelVal.addRow(new Object[]{"", "", "", "", 1, "Gs.", 1, "0", "", 1, 0});
        } catch (Exception ex) {
        }
    }

    public ArrayList<SaPendientes> consultarDocPendientes(String codTit) {
        ArrayList<SaPendientes> lista = new ArrayList<SaPendientes>();

        try {
            Query query = st.createQuery("From SaPendientes p Where p.codTit = ? and p.saldo > 0");
            query.setParameter(0, codTit);

            lista = (ArrayList<SaPendientes>) query.list();

        } catch (Exception e) {
        }
        return lista;
    }

    public void controlValores(int fila, int columna) {
        try {
            int selectedRow = fila;
            int selectedCol = columna;

            if (tabValores.getValueAt(selectedRow, selectedCol).toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo seleccionado no puede estar vacío.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int codForma = Integer.parseInt(tabValores.getValueAt(selectedRow, 0).toString());

                switch (selectedCol) {
                    case 0:
                        MtFormaPago forma = new MtFormaPago();
                        forma = obtenerFormaPago(codForma);
                        tabValores.setValueAt(forma.getDescripcion(), selectedRow, 1);

                        if (codForma == 1 || codForma == 6 || codForma == 7) {
                            tabValores.setValueAt(0, selectedRow, 2);
                            tabValores.setValueAt("CAJA", selectedRow, 3);
                        }

                        if (codForma == 4) {
                            tabValores.setValueAt(0, selectedRow, 2);
                            tabValores.setValueAt("CAJA", selectedRow, 3);
                            tabValores.setValueAt(1, selectedRow, 4);
                            tabValores.setValueAt(1, selectedRow, 6);

                            buscarNC(selectedRow);
                            tabValores.changeSelection(selectedRow, 8, false, false);
                        }

                        tabValores.changeSelection(selectedRow, 2, false, false);
                        break;

                    case 1: // no realiza nada
                        break;

                    case 2:
                        if (codForma == 2 || codForma == 3) {
                            MtProcTarjetas proc = new MtProcTarjetas();
                            int cod = Integer.parseInt(
                                    tabValores.getValueAt(selectedRow, 2).toString());
                            proc = obtenerProcesadora(cod);
                            tabValores.setValueAt(proc.getNombreProc(), selectedRow, 3);
                        }
                        if (codForma == 5) {
                            MtBancos bco = new MtBancos();
                            String codBco = tabValores.getValueAt(selectedRow, 2).toString();
                            bco = obtenerBanco(codBco);
                            tabValores.setValueAt(bco.getNomBanco(), selectedRow, 3);
                        }
                        tabValores.changeSelection(selectedRow, 4, false, false);
                        break;

                    case 3:  // no realiza nada
                        break;

                    case 4:
                        MtMonedas mon = new MtMonedas();
                        int cod = Integer.parseInt(
                                tabValores.getValueAt(selectedRow, 4).toString());
                        mon = obtenerMoneda(cod);
                        tabValores.setValueAt(mon.getSimbolo(), selectedRow, 5);

                        tabValores.setValueAt(buscarTipoCambio(cod), selectedRow, 6);
                        //tabValores.changeSelection(selectedRow, 6, false, false);
                        break;

                    case 5: // no realiza nada
                        break;

                    case 6:
                        if (tabValores.getValueAt(selectedRow, 6).toString().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Valor no válido en el campo TC.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            tabValores.changeSelection(selectedRow, 6, false, false);
                        } else {
                            int tc = Integer.parseInt(tabValores.getValueAt(selectedRow, 6).toString());
                            if (tc <= 0) {
                                JOptionPane.showMessageDialog(null, "Tipo de Cambio debe ser mayor a 0 (cero).",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;

                    case 7:
                        if ((codForma == 2 || codForma == 3)
                                && tabValores.getValueAt(selectedRow, 9).toString().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar el nro. de boleta de la transacción.",
                                    "Facturación", JOptionPane.ERROR_MESSAGE);
                            tabValores.changeSelection(selectedRow, 9, false, false);
                        }
                        break;

                    case 8:
                        BigDecimal importe = new BigDecimal(
                                tabValores.getValueAt(selectedRow, 8).toString());
                        int res = importe.compareTo(BigDecimal.ZERO);

                        if (res < 1) {
                            JOptionPane.showMessageDialog(null, "El importe ingresado debe ser mayor a 0.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            tabValores.changeSelection(selectedRow, 8, false, false);

                            res = 0;
                            res = importe.compareTo(saldoNc);
                            if (res > 0) {
                                JOptionPane.showMessageDialog(null, "El importe ingresado es mayor al saldo disponible para el documento.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                actualizarSaldoPendiente();
                            }
                        }
                        break;

                    case 9:

                        if (tabValores.getValueAt(selectedRow, 8).toString().isEmpty()
                                || tabValores.getValueAt(selectedRow, 8).toString().equals("0")) {
                            JOptionPane.showMessageDialog(null, "El importe ingresado no es válido.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            tabValores.changeSelection(selectedRow, 8, false, false);
                        }

                        if (codForma == 2 || codForma == 3) {
                            //no realiza nada
                        } else {
                            tabValores.setValueAt(1, selectedRow, 9);
                        }
                        tabValores.changeSelection(selectedRow, 9, false, false);
                        actualizarSaldoPendiente();
                        break;

                    default:// no realiza nada
                        actualizarSaldoPendiente();
                        break;
                }
            }
        } catch (Exception ex) {
        }
    }

    public FacturaVenta recuperarCabecera(int trans) {
        FacturaVenta retorno = new FacturaVenta();
        try {
            retorno = (FacturaVenta) st.load(FacturaVenta.class, trans);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public List<FacturaVentaDetalle> recuperarDetalle(int trans) {
        List<FacturaVentaDetalle> retorno = null;
        try {
            Query query = st.createQuery("From FacturaVentaDetalle a join a.id i Where i.nroTrans = ?");
            query.setParameter(0, trans);

            retorno = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
    public List<ValoresDet> recuperarValores(int trans, String docum){
        List<ValoresDet> retorno = null;
        try {
            Query query = st.createQuery("From ValoresDet a join a.id i "
                    + " Where i.nroTrans = ? and i.codDocum = ?");
            query.setParameter(0, trans);
            query.setParameter(1, docum);

            retorno = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
    public void cargarDetalle(FacturaVenta facCab, List<FacturaVentaDetalle> facDet, List<ValoresDet> val) {
        //carga la cabecera de la factura
        try {
            this.txtCodTipoComp.setText(facCab.getMtTipoComprobantes().getCodComp());
            this.txtDescTipComp.setText(facCab.getMtTipoComprobantes().getDescripcion());
            this.txtCodCliente.setText(facCab.getMtClientes().getCodTit());
            this.txtNomCliente.setText(facCab.getMtClientes().getNomTit());
            this.txtCodTribFac.setText(facCab.getCodTributFac());
            this.txtCodSucFac.setText(facCab.getCodSucFac());
            this.txtNroFact.setText(String.valueOf(facCab.getNroDocum()));
            this.txtNroPedido.setText(String.valueOf(facCab.getNroComanda()));
            this.txtCodSuc.setText(facCab.getMtSucursales().getCodSucursal());
            this.txtNomSuc.setText(facCab.getMtSucursales().getNomSucursal());
            this.txtCodCaja.setText(facCab.getCaja().getCodCaja());
            this.txtNomCaja.setText(facCab.getCaja().getNomCaja());
            this.txtCodCondPago.setText(String.valueOf(facCab.getMtCondicionPago().getCodCond()));
            this.txtDescConPago.setText(facCab.getMtCondicionPago().getDescripcion());
            this.txtCodMoneda.setText(String.valueOf(facCab.getMtMonedas().getCodMoneda()));
            this.txtDescMoneda.setText(String.valueOf(facCab.getMtMonedas().getNomMoneda()));
            this.txtTipoCambio.setValue(facCab.getTipoCambio());
            if (facCab.getVencimiento() == null) {
                this.txtVencimiento.setText("");
            } else {
                Fecha fec = new Fecha();
                this.txtVencimiento.setText(fec.fechaString(facCab.getVencimiento()));
            }
            this.txtObservacion.setText(facCab.getObservacion());
        } catch (Exception e) {
            System.out.println("Ocurrio un error al cargar detalle cabecera");
            e.printStackTrace();
        }

        // Carga el detalle de articulos
        try {
            model.setNumRows(0);
            for (FacturaVentaDetalle var : facDet) {
                model.addRow(new Object[]{
                    var.getMtArticulos().getCodArticulo(),
                    var.getMtArticulos().getNomArticulo(),
                    var.getMtArticulos().getPrecioVenta(),
                    var.getCantidad(), var.getSubtotal(),
                    var.getPorcIva(), var.getImporteIva(),
                    var.getPorcDto(), var.getImpDescuento(),
                    var.getTotal()
                });
            }
            actualizarTotales();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al cargar detalle de articulos");
            e.printStackTrace();
        }

        // Carga detalle de Valores de pago
        try {
            modelVal.setNumRows(0);
            for (ValoresDet var : val) {
                modelVal.addRow(new Object[]{
                    var.getCodFormaPago(), "", var.getCodEmisor(), "",
                    var.getCodMoneda(), "", var.getTipoCambio(),
                    var.getRefOperacion(), var.getImporte(),
                    var.getCuotas(), var.getRefDocum()
                });
            }
            actualizarSaldoPendiente();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al cargar detalle de valores");
            e.printStackTrace();
        }
    }

    private void imprimir() {
         try {
            NumeroToLetras imp = new NumeroToLetras();
            int codigo = masterNrotrans.intValue();
            int codMoneda = Integer.parseInt(this.txtCodMoneda.getText());
            String letras = imp.Convertir(this.txtTotalGral.getValue().toString(), false, codMoneda);
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            Map parametros = new HashMap();
            //parametros que enviamos al report.
            parametros.put("nroTrans", codigo);
            parametros.put("letras", this.txtDescMoneda.getText() + " " + letras + ".-");
            JasperReport elReporte = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/FacturaVenta.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, parametros, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Facturación");
            visor.setVisible(true);
            conexion.close();
        } catch (NumberFormatException | SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al imprimir factura de venta "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
