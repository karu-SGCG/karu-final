package com.app.ventas;

import com.entidades.MtPromocionesCab;
import com.entidades.MtPromocionesDet;
import com.entidades.MtPromocionesDetId;
import com.app.seguridad.Permisos;
import com.entidades.MtFormaPago;
import com.entidades.MtTiposClientes;
import com.entidades.MtUsuarios;
import com.entidades.OrdCompraDet;
import com.entidades.OrdCompraDetId;
import com.entidades.OrdenCompra;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
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
import org.hibernate.Session;
import util.HibernateUtil;
import util.Busqueda;
import util.Cargar;
import util.UtilidadesCalendario;

//@author Fausto Sanabria.

public class GestionPromociones extends javax.swing.JDialog {
    public GestionPromociones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Gestión de Promociones - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
    }
    
    public GestionPromociones (String user){
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Gestión de Promociones - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private final String usuario;
    private final String formulario;
    private int var, idArti, filaSeleccionada, posicion; //Variables de clase auxiliares necesarias.
    private List<Object> ArrayPrimaryKey;
    private ArrayList<OrdCompraDetId> articulosBorrados;
    private MtUsuarios objUsuario;
    private MtFormaPago objFormaPago;
    MtTiposClientes objTipoCliente;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdPromo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCodFormaPago = new javax.swing.JTextField();
        txtDescFormaPago = new javax.swing.JTextField();
        txtDescPromo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        chkManejaFecha = new javax.swing.JCheckBox();
        txtFechaDesde = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JFormattedTextField();
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
        jLabel7 = new javax.swing.JLabel();
        txtCodTipoCli = new javax.swing.JTextField();
        txtDescTipoCli = new javax.swing.JTextField();
        txtPorcDto = new javax.swing.JFormattedTextField();
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

        txtIdPromo.setEditable(false);
        txtIdPromo.setBackground(new java.awt.Color(255, 255, 204));
        txtIdPromo.setFocusable(false);
        txtIdPromo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdPromoKeyTyped(evt);
            }
        });

        jLabel12.setText("Forma de Pago:");

        txtCodFormaPago.setToolTipText("Marca. F9 para buscar o dejar vacío");
        txtCodFormaPago.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodFormaPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodFormaPagoFocusLost(evt);
            }
        });
        txtCodFormaPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodFormaPagoKeyReleased(evt);
            }
        });

        txtDescFormaPago.setEditable(false);
        txtDescFormaPago.setBackground(new java.awt.Color(204, 255, 204));
        txtDescFormaPago.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescFormaPago.setFocusable(false);

        txtDescPromo.setEditable(false);
        txtDescPromo.setBackground(new java.awt.Color(204, 255, 204));
        txtDescPromo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescPromoFocusLost(evt);
            }
        });

        jLabel1.setText("Descripcion:");

        chkActivo.setSelected(true);
        chkActivo.setText("Esta activo");
        chkActivo.setEnabled(false);
        chkActivo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        chkManejaFecha.setText("Maneja fechas");
        chkManejaFecha.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        chkManejaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkManejaFechaActionPerformed(evt);
            }
        });

        txtFechaDesde.setEditable(false);
        txtFechaDesde.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        jLabel3.setText("Fecha de Inicio:");

        jLabel8.setText("Fecha de Finalizacion");

        txtFechaFin.setEditable(false);
        txtFechaFin.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(12, 12, 12)
                        .addComponent(txtCodFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(51, 51, 51)
                        .addComponent(txtIdPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(chkActivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkManejaFecha)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkManejaFecha)
                    .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo de Cliente", "Descripción", "Porcentaje "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel4.setText("Tipo Cliente");

        jLabel7.setText("Porcentaje Descuento");

        txtCodTipoCli.setToolTipText("Código de artículo. F9 para buscar");
        txtCodTipoCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodTipoCliFocusLost(evt);
            }
        });
        txtCodTipoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodTipoCliKeyReleased(evt);
            }
        });

        txtDescTipoCli.setEditable(false);
        txtDescTipoCli.setFocusable(false);

        txtPorcDto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##.##"))));
        txtPorcDto.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtPorcDto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcDtoFocusLost(evt);
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
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodTipoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescTipoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPorcDto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7)
                        .addComponent(txtCodTipoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescTipoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPorcDto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
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

    private void txtCodTipoCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodTipoCliKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigoArt;
                Busqueda formBusqueda = new Busqueda(this, true, "Busqueda de articulos", "mt_tipos_clientes",
                        "cod_tipo_cliente", "nom_tipo_cliente");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigoArt = formBusqueda.getCodigo();
                if (codigoArt != null) {
                    this.txtCodTipoCli.setText(codigoArt);
                }
            }
        }
    }//GEN-LAST:event_txtCodTipoCliKeyReleased

    private void txtCodFormaPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFormaPagoKeyReleased
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            if (evt.getKeyCode() == KeyEvent.VK_F9) {
                String codigo;
                Busqueda formBusqueda = new Busqueda(this, true, "Formas de pago", "mt_forma_pago", "cod_tipo", "descripcion");
                formBusqueda.setDefaultCloseOperation(HIDE_ON_CLOSE);
                formBusqueda.setVisible(true);
                codigo = formBusqueda.getCodigo();
                if (codigo != null) {
                    this.txtCodFormaPago.setText(codigo);
                    this.txtCodFormaPago.transferFocus();
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    this.txtCodFormaPago.transferFocus();
            }
        }
    }//GEN-LAST:event_txtCodFormaPagoKeyReleased

    private void txtCodFormaPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodFormaPagoFocusLost
        if (!this.txtCodFormaPago.getText().isEmpty()) {
            recuperarFormaPago(Integer.parseInt(this.txtCodFormaPago.getText()));
        } else {
            this.txtCodFormaPago.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtCodFormaPagoFocusLost

    private void txtCodTipoCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodTipoCliFocusLost
        if (!this.txtCodTipoCli.getText().isEmpty()) {
            recuperarTipo(Integer.parseInt(this.txtCodTipoCli.getText()));
        }
    }//GEN-LAST:event_txtCodTipoCliFocusLost

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Desea eliminar la fila seleccionada?", "Corfirmacion",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirma == 0) {
            if ("Editar".equalsIgnoreCase(accion)) {
                System.out.println("fila: " + filaSeleccionada);
                System.out.println("nro_orden: " + Integer.parseInt(this.txtIdPromo.getText()));
                OrdCompraDetId idLineaEliminada = new OrdCompraDetId(Integer.parseInt(this.txtIdPromo.getText()), filaSeleccionada);
                System.out.println("objeto: " + idLineaEliminada.getNroOcompra() + "--" + idLineaEliminada.getLinea());
                articulosBorrados.add(idLineaEliminada);
            }
            model.removeRow(filaSeleccionada);
            limpiarArticulos();
            this.txtCodTipoCli.setEditable(true);
            this.txtCodTipoCli.requestFocus();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtIdPromoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPromoKeyTyped
        char car = evt.getKeyChar();
        if ((car >= '0' && car <= '9') || car == '.') {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdPromoKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!accion.equalsIgnoreCase("Buscar")) {
            btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png")));
            arranque();
            this.accion = "Buscar";
            this.txtCodFormaPago.setEditable(true);
            this.txtIdPromo.setEditable(true);
            this.txtIdPromo.setFocusable(true);
            this.txtIdPromo.requestFocus();
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

    private void txtPorcDtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcDtoFocusLost
        if (!this.txtPorcDto.getText().isEmpty()) {
            try {
                this.txtPorcDto.commitEdit();
                BigDecimal porcentaje = new BigDecimal(this.txtPorcDto.getValue().toString());
                if (porcentaje.compareTo(new BigDecimal("99")) > 0){
                    JOptionPane.showMessageDialog(this, "El monto del descuento supera el valor maximo.", "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtPorcDto.requestFocusInWindow();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtPorcDtoFocusLost

    private void txtDescPromoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescPromoFocusLost
        if (this.txtDescPromo.getText().isEmpty()){
            this.txtDescPromo.requestFocusInWindow();
        } else {
            this.txtDescPromo.setText(this.txtDescPromo.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtDescPromoFocusLost

    private void chkManejaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkManejaFechaActionPerformed
        if(this.chkManejaFecha.isSelected()){
            this.txtFechaDesde.setEditable(true);
            this.txtFechaFin.setEditable(true);
            this.txtFechaDesde.setValue(new Date());
            this.txtFechaFin.setValue(new Date());
        } else {
            this.txtFechaDesde.setEditable(false);
            this.txtFechaFin.setEditable(false);
            this.txtFechaDesde.setValue(null);
            this.txtFechaFin.setValue(null);
        }
    }//GEN-LAST:event_chkManejaFechaActionPerformed


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
            java.util.logging.Logger.getLogger(GestionPromociones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionPromociones dialog = new GestionPromociones(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JCheckBox chkManejaFecha;
    private javax.swing.ButtonGroup grupoModo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextField txtCodFormaPago;
    private javax.swing.JTextField txtCodTipoCli;
    private javax.swing.JTextField txtDescFormaPago;
    private javax.swing.JTextField txtDescPromo;
    private javax.swing.JTextField txtDescTipoCli;
    private javax.swing.JFormattedTextField txtFechaDesde;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaMod;
    private javax.swing.JTextField txtIdPromo;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JFormattedTextField txtPorcDto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables



    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    private void arranque(){
        //Reseteamos la variable de acción
        accion = "";
        //Seteamos los campos editables por el usuario
        this.txtIdPromo.setText("");
        this.txtDescPromo.setText("");
        this.txtDescPromo.setEditable(false);
        this.chkActivo.setSelected(false);
        this.chkManejaFecha.setSelected(false);
        this.chkManejaFecha.setEnabled(false);
        this.txtFechaDesde.setValue(null);
        this.txtFechaDesde.setEditable(false);
        this.txtFechaFin.setValue(null);
        this.txtFechaFin.setEditable(false);
        this.txtCodFormaPago.setEditable(false);
        this.txtCodFormaPago.setText("");        
        this.txtDescFormaPago.setText("");        

        //Detalle
        this.txtCodTipoCli.setText("");
        this.txtDescTipoCli.setText("");               
        this.txtPorcDto.setEditable(false);
        this.txtPorcDto.setValue(null);                 

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

        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);       // código
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);      // descripción
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);      // cantidad

        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    private MtUsuarios recuperarUsuario(String cod_usuario) {
        objUsuario = (MtUsuarios) st.load(MtUsuarios.class, cod_usuario);
        return objUsuario;
    }
    
    private void buscar() {
        String SqlQuery = "select id_promo from mt_promociones_cab where id_promo >= 0";
        if (!this.txtCodFormaPago.getText().isEmpty()) {
            SqlQuery = SqlQuery + " and upper(cod_forma_pago) = " + this.txtCodFormaPago.getText();
        }
        SqlQuery = SqlQuery + " order by id_promo";
        
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
            this.btnEditar.setEnabled(true);
            this.btnInforme.setEnabled(false);
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else if (ArrayPrimaryKey.size() == 1) {
            posicion = 0;
            recuperarRegistros(posicion);
            this.btnEliminar.setEnabled(false);
            this.btnEditar.setEnabled(true);
            this.btnInforme.setEnabled(false);           
            String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
            this.lblInfoPie.setText(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro", "Buscar", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void recuperarRegistros(int indice) {
        int numero = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        MtPromocionesCab cabecera = (MtPromocionesCab) st.get(MtPromocionesCab.class, numero);
        this.objFormaPago = cabecera.getMtFormaPago();
        this.txtUsuario.setText(cabecera.getUsuarioMod());
        this.txtNomUsuario.setText(recuperarUsuario(txtUsuario.getText()).getNomUsuario());
        this.txtFechaMod.setValue(cabecera.getFechaMod());
        this.txtIdPromo.setText(String.valueOf(cabecera.getIdPromo()));
        this.txtDescPromo.setText(cabecera.getDescripcion());
        this.txtCodFormaPago.setText(String.valueOf(cabecera.getMtFormaPago().getCodTipo()));
        this.txtDescFormaPago.setText(cabecera.getMtFormaPago().getDescripcion());
        char es_activo = cabecera.getEstaActivo();
        char es_fecha = cabecera.getEsPorFecha();
        this.chkActivo.setSelected((es_activo == 'S' || es_activo == 's'));
        this.chkManejaFecha.setSelected((es_fecha == 'S' || es_fecha == 's'));
        this.txtFechaDesde.setValue(cabecera.getFechaInicio());
        this.txtFechaFin.setValue(cabecera.getFechaFin());
        
        recuperarDetalle(numero);
    }
    
    private void recuperarDetalle(int numero) {
        Query consulta = st.createQuery("From MtPromocionesDet a JOIN a.id b WHERE b.idPromo = :numero");
        consulta.setParameter("numero", numero);
        List<MtPromocionesDet> detalles = (List<MtPromocionesDet>)consulta.list();
        model.setNumRows(0);
        for (MtPromocionesDet detalle : detalles) {
            model.addRow(new Object[]{
                detalle.getId().getCodTipoCliente(),
                detalle.getMtTiposClientes().getNomTipoCliente(),
                detalle.getPorcentajeDto()
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
    
    public void nuevo(){
        arranque();
        //Seteamos la accion
        accion = "Nuevo";
        //Los componentes editables
        this.txtDescPromo.setEditable(true);
        this.chkActivo.setSelected(true);
        this.chkManejaFecha.setEnabled(true);
        this.txtCodFormaPago.setEditable(true);
      
        //Detalle
        this.txtCodTipoCli.setText("");   
        this.txtCodTipoCli.setEditable(true);
        this.txtPorcDto.setEditable(true);
        this.txtPorcDto.setValue(null);
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
        this.txtIdPromo.setText(obtenerID());      
        this.txtUsuario.setText(usuario);
        this.txtNomUsuario.setText(recuperarUsuario(usuario).getNomUsuario());
        this.txtFechaMod.setValue(new Date());
        
        this.txtDescPromo.requestFocusInWindow();
        
    }
    
    public void editar(){
        //Seteamos la accion
        accion = "Editar";
        articulosBorrados = new ArrayList<>();
        
        //Los componentes editables
        this.chkActivo.setEnabled(true);
        this.chkManejaFecha.setEnabled(true);
        this.txtFechaDesde.setEditable(this.chkManejaFecha.isSelected());
        this.txtFechaFin.setEditable(this.chkManejaFecha.isSelected());
        this.txtFechaDesde.setFocusable(this.chkManejaFecha.isSelected());
        this.txtFechaFin.setFocusable(this.chkManejaFecha.isSelected());
        this.txtCodTipoCli.setEditable(true);
        this.txtPorcDto.setEditable(true);
        this.txtCodTipoCli.requestFocusInWindow();

        
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
    }
    
    public void eliminar() {
        int seleccion = JOptionPane.showConfirmDialog(null, "Desea eliminar el Registro.", "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        if (seleccion == 1) {//Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();//Si no se elimina se llama al metodo arranque() para limpiar campos
        } else {//Opción eliminar seleccionada
            st.beginTransaction();
            Integer numeroOrden = Integer.parseInt(this.txtIdPromo.getText());
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
    
    private void recuperarFormaPago(Integer codigo) {
        try {
            String consulta = "Select * from mt_forma_pago where cod_tipo = " + codigo;
            Cargar cargar = new Cargar();
            objFormaPago = (MtFormaPago) cargar.resultadoUnico(consulta, MtFormaPago.class);
            this.txtDescFormaPago.setText(objFormaPago.getDescripcion());
        } catch (Exception e) {
        }
    }
    
    private void recuperarTipo(Integer codigo) {
        try {
            String consulta = "Select * from mt_tipos_clientes where cod_tipo_cliente = " + codigo ;
            Cargar cargar = new Cargar();
            objTipoCliente = (MtTiposClientes) cargar.resultadoUnico(consulta, MtTiposClientes.class);
            this.txtDescTipoCli.setText(objTipoCliente.getNomTipoCliente());
        } catch (Exception e) {
        }
    }
    
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.txtCodTipoCli.requestFocusInWindow();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.txtCodTipoCli.requestFocusInWindow();
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
            String sql = "SELECT MAX(idPromo) FROM MtPromocionesCab";
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

        if (this.txtDescPromo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la descripcion");
        } else if (this.txtCodFormaPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la forma de pago.");
        } else if (this.chkManejaFecha.isSelected() && (this.txtFechaDesde.getValue() == null || this.txtFechaFin.getValue() == null)) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha.");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                MtPromocionesCab cabecerag = new MtPromocionesCab();
                Integer numero = Integer.parseInt(this.txtIdPromo.getText());

                cabecerag.setIdPromo(numero);
                cabecerag.setDescripcion(this.txtDescPromo.getText());
                if (this.chkActivo.isSelected()) {
                    cabecerag.setEstaActivo('S');
                } else {
                    cabecerag.setEstaActivo('N');
                }
                if (this.chkManejaFecha.isSelected()){
                    cabecerag.setEsPorFecha('S');
                    cabecerag.setFechaInicio(UtilidadesCalendario.StringACalendario(this.txtFechaDesde.getText()).getTime());
                    cabecerag.setFechaFin(UtilidadesCalendario.StringACalendario(this.txtFechaFin.getText()).getTime());                    
                } else {
                    cabecerag.setEsPorFecha('N');
                }
                cabecerag.setMtFormaPago(this.objFormaPago);
                cabecerag.setAccionMod(accion);
                cabecerag.setUsuarioMod(usuario);
                cabecerag.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                System.out.println("Voy a editar: " + "==>" + cabecerag.getIdPromo());
                st.saveOrUpdate(cabecerag);

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    MtPromocionesDetId detalleId = new MtPromocionesDetId(numero, Integer.parseInt(model.getValueAt(i, 0).toString()));

                    MtPromocionesDet detalle = new MtPromocionesDet();
                    detalle.setId(detalleId);
                    detalle.setPorcentajeDto(new BigDecimal(model.getValueAt(i, 2).toString()));
                    detalle.setMtTiposClientes(objTipoCliente);
                    detalle.setMtPromocionesCab(cabecerag);

                    detalle.setAccionMod(accion);
                    detalle.setUsuarioMod(usuario);
                    detalle.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                    st.saveOrUpdate(detalle);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                //informe();
                arranque();
            } catch (org.hibernate.NonUniqueObjectException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n"
                        + e.getMessage(), "Clave primaria duplicada", JOptionPane.ERROR_MESSAGE);
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
    
    public void guardarEd() {
        int rowCount = this.jTable1.getRowCount();

        if (this.txtDescPromo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la descripcion");
        } else if (this.txtCodFormaPago.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la forma de pago.");
        } else if (this.chkManejaFecha.isSelected() && (this.txtFechaDesde.getValue() == null || this.txtFechaFin.getValue() == null)) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha.");
        } else if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "La grilla debe estar cargada");
        } else {
            try {
                st.beginTransaction();
                Integer numero = Integer.parseInt(this.txtIdPromo.getText());
                MtPromocionesCab cabecerag = (MtPromocionesCab) st.load(MtPromocionesCab.class, numero);

                cabecerag.setDescripcion(this.txtDescPromo.getText());
                if (this.chkActivo.isSelected()) {
                    cabecerag.setEstaActivo('S');
                } else {
                    cabecerag.setEstaActivo('N');
                }
                if (this.chkManejaFecha.isSelected()){
                    cabecerag.setEsPorFecha('S');
                    cabecerag.setFechaInicio(UtilidadesCalendario.StringACalendario(this.txtFechaDesde.getText()).getTime());
                    cabecerag.setFechaFin(UtilidadesCalendario.StringACalendario(this.txtFechaFin.getText()).getTime());                    
                } else {
                    cabecerag.setEsPorFecha('N');
                }
                cabecerag.setMtFormaPago(this.objFormaPago);
                cabecerag.setAccionMod(accion);
                cabecerag.setUsuarioMod(usuario);
                cabecerag.setFechaMod(UtilidadesCalendario.FechaHoraActual());
                System.out.println("Voy a editar: " + "==>" + cabecerag.getIdPromo());
                st.update(cabecerag);
                
                if ("Editar".equalsIgnoreCase(this.accion)) {
                    Query consulta = st.createQuery("From MtPromocionesDet a JOIN a.id b WHERE b.idPromo = :numero");
                    consulta.setParameter("numero", numero);
                    List<MtPromocionesDet> detalles = (List<MtPromocionesDet>) consulta.list();
                    for (MtPromocionesDet detalle : detalles) {
                        System.out.println("Voy a borrar: " + detalle.getId().getIdPromo() + "==>" + detalle.getId().getCodTipoCliente());
                        st.delete(detalle);
                        System.out.println("Ok. Borré");
                    }
                }

                for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                    MtPromocionesDetId detalleId = new MtPromocionesDetId(numero, Integer.parseInt(model.getValueAt(i, 0).toString()));

                    MtPromocionesDet detalleg = new MtPromocionesDet();
                    detalleg.setId(detalleId);
                    detalleg.setPorcentajeDto(new BigDecimal(model.getValueAt(i, 2).toString()));
                    detalleg.setMtTiposClientes(objTipoCliente);
                    detalleg.setMtPromocionesCab(cabecerag);

                    detalleg.setAccionMod(accion);
                    detalleg.setUsuarioMod(usuario);
                    detalleg.setFechaMod(UtilidadesCalendario.FechaHoraActual());

                    st.save(detalleg);
                }
                st.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                //informe();
                arranque();
            } catch (org.hibernate.NonUniqueObjectException e) {
                st.getTransaction().rollback();
                st.clear();
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n"
                        + e.getMessage(), "Clave primaria duplicada", JOptionPane.ERROR_MESSAGE);
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
        if (this.txtCodTipoCli.getText().isEmpty() || this.txtPorcDto.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar. Por favor verifique.", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        else {
            verificar();
            if(var>=1){
                int showConfirmDialog = 0; 
                //JOptionPane.showConfirmDialog(null, "Artículo ya Agregado. Desea reemplazar los datos?.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
                if(showConfirmDialog==0){
                    model.setValueAt(this.txtPorcDto.getValue(), idArti, 2);
                    limpiarArticulos();
                }
                else {
                    limpiarArticulos();
                    this.txtCodTipoCli.requestFocus();
                }
            }
            else {
                model.addRow(new Object[] {
                    this.txtCodTipoCli.getText(),
                    this.txtDescTipoCli.getText(),
                    this.txtPorcDto.getValue()
                });                    
                limpiarArticulos(); 
             }
        }
    }
    
    public void verificar(){
        //Método para verificar que no se duplique el mismo artículo en la tabla, para ello se comprueba el id del artículo.
        var = 0;
        String idAr = this.txtCodTipoCli.getText();
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
    
    private void limpiarArticulos() {
        this.txtCodTipoCli.setText("");
        this.txtDescTipoCli.setText("");  
        this.txtPorcDto.setValue(null);
        this.btnBorrar.setEnabled(false);
        this.txtCodTipoCli.requestFocus();
    }  
    
    public void obtenerTabla() {
        if ("Nuevo".equals(accion) || "Editar".equals(accion)) {
            filaSeleccionada = this.jTable1.getSelectedRow();
            this.txtCodTipoCli.setText(model.getValueAt(filaSeleccionada, 0).toString());
            this.txtDescTipoCli.setText(model.getValueAt(filaSeleccionada, 1).toString());
            this.txtPorcDto.setValue(model.getValueAt(filaSeleccionada, 2));
            
            this.txtPorcDto.requestFocus();
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
            parametros.put("pnro_ocompra", Integer.parseInt(this.txtIdPromo.getText()));
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