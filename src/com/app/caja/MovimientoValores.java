package com.app.caja;

import com.entidades.Caja;
import com.entidades.MovValDet;
import com.entidades.MovValDetId;
import com.entidades.MovValores;
import com.entidades.MtBancos;
import com.entidades.MtClientes;
import com.entidades.MtMonedas;
import com.entidades.TsBancosCtas;
import com.entidades.TsBancosCtasId;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_TAB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import util.Fecha;

/**
 * @author Carlos Patiño
 */
public class MovimientoValores extends javax.swing.JDialog {

    /**
     * Creates new form MovimientoValores
     */
    private final String usuario;
    private String origen;
    private final String formulario;
    private Integer masterOperacion;
    private int posicion;
    private List<Object> ArrayPrimaryKey;

    public MovimientoValores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hibernateSession();
        arranque();

        usuario = "karu";
        formulario = this.getClass().getSimpleName();
    }

    public MovimientoValores(String user) {
        setLocationRelativeTo(null);
        initComponents();
        hibernateSession();
        arranque();

        usuario = user;
        formulario = this.getClass().getSimpleName();
    }

    private Session st;
    private DefaultTableModel model;

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque() {
        this.cmdGuardar.setEnabled(false);
        this.cmdCancelar.setVisible(true);
        this.cmdCancelar.setEnabled(false);
        this.cmdProcesarBusqueda.setVisible(false);

        tableModel();
        cargarBanco();

        buscarRegistros(); 
    }

    public void tableModel() {
        model = (DefaultTableModel) this.tabValores.getModel();
        model.setNumRows(0);

        tabValores.getColumnModel().getColumn(9).setMaxWidth(0);
        tabValores.getColumnModel().getColumn(9).setMinWidth(0);
        tabValores.getColumnModel().getColumn(9).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cmdNuevo = new javax.swing.JButton();
        cmdGuardar = new javax.swing.JButton();
        cmdEditar = new javax.swing.JButton();
        cmdBorrar = new javax.swing.JButton();
        cmdCancelar = new javax.swing.JButton();
        cmdImprimir = new javax.swing.JButton();
        cmdBuscar = new javax.swing.JButton();
        cmdProcesarBusqueda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNroDeposito = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodCaja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodMoneda = new javax.swing.JTextField();
        txtNomMoneda = new javax.swing.JTextField();
        cboBanco = new javax.swing.JComboBox();
        cboCtaCte = new javax.swing.JComboBox();
        txtNomCaja = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRefDeposito = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabValores = new javax.swing.JTable();
        cmdAgregarValor = new javax.swing.JButton();
        cmdQuitarValor = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalEfectivo = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalCheque = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotalDeposito = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        btnUltimo = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnPrimero = new javax.swing.JButton();
        cmdCerrar = new javax.swing.JButton();
        lblInfoPie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Depósito de Valores");
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setResizable(false);

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

        cmdEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        cmdEditar.setToolTipText("Editar");
        cmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditarActionPerformed(evt);
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

        cmdProcesarBusqueda.setText("Buscar");
        cmdProcesarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProcesarBusquedaActionPerformed(evt);
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
                .addComponent(cmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdProcesarBusqueda)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdProcesarBusqueda))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmdBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(80, 80, 80))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Depósito"));

        jLabel1.setText("Nro. Depósito");

        txtNroDeposito.setEditable(false);
        txtNroDeposito.setBackground(new java.awt.Color(255, 255, 204));
        txtNroDeposito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroDeposito.setToolTipText("Nro. de Depósito");
        txtNroDeposito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroDepositoFocusLost(evt);
            }
        });
        txtNroDeposito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroDepositoKeyTyped(evt);
            }
        });

        jLabel2.setText("Fecha");

        jLabel3.setText("Caja");

        txtCodCaja.setBackground(new java.awt.Color(255, 255, 204));
        txtCodCaja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodCajaFocusLost(evt);
            }
        });

        jLabel4.setText("Banco");

        jLabel5.setText("Nro. Cuenta");

        jLabel6.setText("Moneda");

        txtCodMoneda.setBackground(new java.awt.Color(255, 255, 204));
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

        txtNomMoneda.setEditable(false);
        txtNomMoneda.setBackground(new java.awt.Color(255, 255, 255));

        cboBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboBancoFocusLost(evt);
            }
        });

        txtNomCaja.setEditable(false);
        txtNomCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtNomCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomCajaActionPerformed(evt);
            }
        });

        jLabel10.setText("Nro. Boleta Dep.");
        jLabel10.setToolTipText("");

        txtRefDeposito.setToolTipText("Referencia de Depósito Bancario");
        txtRefDeposito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRefDepositoKeyTyped(evt);
            }
        });

        txtFecha.setToolTipText("Fecha de la operación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNroDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtNomCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cboCtaCte, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtNomMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtRefDeposito)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNroDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCtaCte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRefDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores a Depositar"));

        tabValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Valor", "", "Número", "Bco./Ent.", "", "Cliente", "", "Vencimiento", "Importe", "Val"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false, true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabValores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabValores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabValoresFocusLost(evt);
            }
        });
        tabValores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabValoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabValores);
        if (tabValores.getColumnModel().getColumnCount() > 0) {
            tabValores.getColumnModel().getColumn(9).setResizable(false);
        }

        cmdAgregarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/plus.png"))); // NOI18N
        cmdAgregarValor.setToolTipText("Agregar línea para valores");
        cmdAgregarValor.setEnabled(false);
        cmdAgregarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarValorActionPerformed(evt);
            }
        });

        cmdQuitarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/DeleteUser.png"))); // NOI18N
        cmdQuitarValor.setToolTipText("Quitar línea de valores");
        cmdQuitarValor.setEnabled(false);
        cmdQuitarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdQuitarValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdQuitarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmdAgregarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cmdAgregarValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdQuitarValor))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Efectivo");

        txtTotalEfectivo.setEditable(false);
        txtTotalEfectivo.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotalEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Cheque");

        txtTotalCheque.setEditable(false);
        txtTotalCheque.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCheque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtTotalCheque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalCheque.setToolTipText("Total Otros Valores");

        jLabel9.setText("Total a Depositar");

        txtTotalDeposito.setEditable(false);
        txtTotalDeposito.setBackground(new java.awt.Color(204, 255, 255));
        txtTotalDeposito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtTotalDeposito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalDeposito.setToolTipText("Importe total a Depositar");
        txtTotalDeposito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtTotalDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed
        habilitarCampos();
        inicializarCampos();
        this.origen = "Nuevo";

        masterOperacion = obtenerNroOpe();

        this.txtNroDeposito.setText(String.valueOf(masterOperacion));
        this.txtFecha.setDate(new Date());
        this.txtCodCaja.grabFocus();
    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGuardarActionPerformed
        if (this.txtTotalDeposito.getText().equals("0")
                || this.txtTotalDeposito.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen valores que guardar. "
                    + "Proceda a cargar los importes del depósito.",
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        } else {
            guardar();
            deshabilitarCampos();
            buscarRegistros(); 
        }
    }//GEN-LAST:event_cmdGuardarActionPerformed

    private void cmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditarActionPerformed
        origen = "Editar";
        habilitarCampos();
    }//GEN-LAST:event_cmdEditarActionPerformed

    private void cmdBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBorrarActionPerformed
        int seleccion = JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar es Movimiento de Valores?",
                "Movimiento de Valores", JOptionPane.YES_NO_OPTION);
        if (seleccion == 0) {
            borrarValores();
            inicializarCampos();
            buscarRegistros();
        }
    }//GEN-LAST:event_cmdBorrarActionPerformed

    private void cmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelarActionPerformed
        deshabilitarCampos();
    }//GEN-LAST:event_cmdCancelarActionPerformed

    private void cmdImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdImprimirActionPerformed
         if (this.txtNroDeposito.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nro. de depósito para imprimir el informe",
                    "Movimiento de Valores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            imprimir();
        }
    }//GEN-LAST:event_cmdImprimirActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        origen = "Buscar";
        this.cmdCancelar.setEnabled(true);
        this.cmdProcesarBusqueda.setVisible(true);
        inicializarCampos();
        habilitarBusqueda();
        //consultarRegistros();
    }//GEN-LAST:event_cmdBuscarActionPerformed

    private void cmdAgregarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarValorActionPerformed
        agregarFilasValores();
    }//GEN-LAST:event_cmdAgregarValorActionPerformed

    private void cmdQuitarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdQuitarValorActionPerformed
        int selectedRow = tabValores.getSelectedRow();

        quitarElemento(model, selectedRow);
        actualizarTotales();
    }//GEN-LAST:event_cmdQuitarValorActionPerformed

    private void txtRefDepositoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefDepositoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRefDepositoKeyTyped

    private void txtCodMonedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMonedaKeyTyped
        char car = evt.getKeyChar();
        if (txtCodMoneda.getText().length() >= 2) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodMonedaKeyTyped

    private void txtNroDepositoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroDepositoKeyTyped
        char car = evt.getKeyChar();
        if (txtNroDeposito.getText().length() >= 2) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroDepositoKeyTyped

    private void txtCodMonedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMonedaFocusLost
        try {
            if (!origen.equals("Buscar") || !origen.isEmpty()) {
                MtMonedas mon = new MtMonedas();

                if (this.txtCodMoneda.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna moneda. ",
                            "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
                    this.txtCodMoneda.grabFocus();
                } else {
                    mon = obtenerMoneda(Integer.parseInt(this.txtCodMoneda.getText()));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener descripción de la moneda. ",
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCodMonedaFocusLost

    private void txtCodCajaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodCajaFocusLost
        try {
            if (!origen.equals("Buscar")) {
                try {
                    Caja caja = null;
                    txtCodCaja.setText(txtCodCaja.getText().toUpperCase());
                    caja = obtenerCaja(txtCodCaja.getText());
                    this.txtNomCaja.setText(caja.getNomCaja());

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al obtener descripción de la caja. ",
                            "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtCodCajaFocusLost

    private void cboBancoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboBancoFocusLost
        try {
            MtBancos bco = new MtBancos();
            if (!this.txtNomMoneda.getText().isEmpty()) {
                bco = obtenerBanco(this.cboBanco.getSelectedItem().toString(), 2);
                cargarCtaCte(bco);
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una moneda.",
                        "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_cboBancoFocusLost

    private void txtNroDepositoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroDepositoFocusLost
        if (origen.equals("Buscar")) {

        }
    }//GEN-LAST:event_txtNroDepositoFocusLost

    private void tabValoresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabValoresFocusLost

    }//GEN-LAST:event_tabValoresFocusLost

    private void tabValoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabValoresKeyPressed
        int selectedRow = tabValores.getSelectedRow();
        int selectedCol = tabValores.getSelectedColumn() - 1;

        if (selectedCol >= 0) {
            if (evt.getKeyCode() == VK_TAB || evt.getKeyCode() == VK_ENTER) {
                controlValores(selectedRow, selectedCol);
            }
        }
    }//GEN-LAST:event_tabValoresKeyPressed

    private void txtNomCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomCajaActionPerformed

    private void cmdProcesarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProcesarBusquedaActionPerformed
        buscarRegistros();
    }//GEN-LAST:event_cmdProcesarBusquedaActionPerformed

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
            java.util.logging.Logger.getLogger(MovimientoValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientoValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientoValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientoValores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MovimientoValores dialog = new MovimientoValores(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cboBanco;
    private javax.swing.JComboBox cboCtaCte;
    private javax.swing.JButton cmdAgregarValor;
    private javax.swing.JButton cmdBorrar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdCancelar;
    private javax.swing.JButton cmdCerrar;
    private javax.swing.JButton cmdEditar;
    private javax.swing.JButton cmdGuardar;
    private javax.swing.JButton cmdImprimir;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JButton cmdProcesarBusqueda;
    private javax.swing.JButton cmdQuitarValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfoPie;
    private javax.swing.JTable tabValores;
    private javax.swing.JTextField txtCodCaja;
    private javax.swing.JTextField txtCodMoneda;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNomCaja;
    private javax.swing.JTextField txtNomMoneda;
    private javax.swing.JTextField txtNroDeposito;
    private javax.swing.JTextField txtRefDeposito;
    private javax.swing.JFormattedTextField txtTotalCheque;
    private javax.swing.JFormattedTextField txtTotalDeposito;
    private javax.swing.JFormattedTextField txtTotalEfectivo;
    // End of variables declaration//GEN-END:variables

    public void inicializarCampos() {
        this.txtNroDeposito.setText("");
        this.txtFecha.setDate(null);
        this.cboBanco.setSelectedIndex(-1);
        this.cboCtaCte.setSelectedIndex(-1);
        this.txtRefDeposito.setText("");
        this.txtTotalCheque.setValue(0);
        this.txtTotalDeposito.setValue(0);
        this.txtTotalEfectivo.setValue(0);
        
        tableModel();
    }

    public void habilitarCampos() {
        // habilita botones
        this.cmdGuardar.setEnabled(true);
        this.cmdCancelar.setEnabled(true);
        this.cmdBorrar.setEnabled(false);
        this.cmdNuevo.setEnabled(false);
        this.cmdEditar.setEnabled(false);
        this.cmdAgregarValor.setEnabled(true);
        this.cmdQuitarValor.setEnabled(true);
        this.tabValores.setEnabled(true);
    }

    public void deshabilitarCampos() {
        // deshabilita botones
        this.cmdGuardar.setEnabled(false);
        this.cmdCancelar.setEnabled(false);
        this.cmdBorrar.setEnabled(true);
        this.cmdNuevo.setEnabled(true);
        this.cmdEditar.setEnabled(true);
        this.cmdAgregarValor.setEnabled(false);
        this.cmdQuitarValor.setEnabled(false);
        this.tabValores.setEnabled(false);
    }

    public void habilitarBusqueda(){
        this.txtNroDeposito.setEditable(true);
        this.txtNroDeposito.grabFocus();
        this.cmdProcesarBusqueda.setVisible(true);
    }
    
    public MtMonedas obtenerMoneda(int cod) {
        MtMonedas mon = null;
        try {
            mon = (MtMonedas) st.get(MtMonedas.class, cod);
            if (mon == null) {
                JOptionPane.showMessageDialog(null, "Código buscado no existe. Intente de nuevo.",
                        "Movimiento de Valores", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtNomMoneda.setText(mon.getNomMoneda());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta de monedas. "
                    + "\n" + e.getMessage(), "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return mon;
    }

    public Caja obtenerCaja(String cod) {
        Caja caja = null;
        try {
            caja = (Caja) st.get(Caja.class, cod);
            if (caja == null) {
                JOptionPane.showMessageDialog(null, "Código de caja buscado no existe. Intente de nuevo.",
                        "Movimiento de Valores", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtNomCaja.setText(caja.getNomCaja());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta de caja. "
                    + "\n" + e.getMessage(), "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return caja;
    }

    public void cargarBanco() {
        this.cboBanco.removeAllItems();
        List<MtBancos> lista = (List<MtBancos>) st.createQuery("From MtBancos").list();
        for (MtBancos tipoList : lista) {
            this.cboBanco.addItem(tipoList.getNomBanco());
        }
    }

    public MtBancos obtenerBanco(String cod, int bandera) {
        MtBancos bco = null;
        try {

            if (bandera == 2) {
                //busca por nombre del banco
                Query consulta = st.createQuery("From MtBancos b where b.nomBanco = ?");
                consulta.setParameter(0, cod);

                bco = (MtBancos) consulta.uniqueResult();
            } else {
                //busca por el codigo
                bco = (MtBancos) st.get(MtBancos.class, cod);
            }

            if (bco == null) {
                JOptionPane.showMessageDialog(null, "Código banco no existe. Intente de nuevo.",
                        "Movimiento de Valores", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HibernateException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. "
                    + "\n" + e.getMessage(), "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return bco;
    }

    public MtClientes buscarCliente(String codigo) {
        MtClientes cliente = null;
        try {
            Query query = st.createQuery("From MtClientes c Where c.nroDocum = ? and c.esActivo = 'S'");
            query.setParameter(0, codigo);
            cliente = (MtClientes) query.uniqueResult();
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente." + "\n" + ex.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }

    public TsBancosCtas obtenerCta(String codBco, String nroCta) {
        TsBancosCtasId id = new TsBancosCtasId();
        TsBancosCtas cta = null;
        try {

            id.setCodBanco(codBco);
            id.setNroCuenta(nroCta);

            cta = (TsBancosCtas) st.get(TsBancosCtas.class, id);

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Cuenta de Banco." + "\n" + ex.getCause(),
                   "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return cta;
    }

    public void cargarCtaCte(MtBancos bco) {
        String codBco = bco.getCodBanco();
        int codMoneda = Integer.parseInt(this.txtCodMoneda.getText());

        this.cboCtaCte.removeAllItems();

        Query consulta = st.createSQLQuery("Select c.nro_cuenta From ts_bancos_ctas c "
                + "where c.cod_banco = ? and cod_moneda = ?");
        consulta.setParameter(0, codBco);
        consulta.setParameter(1, codMoneda);

        try {
            List<String> lista
                    = (List<String>) consulta.list();

            for (String cta : lista) {
                this.cboCtaCte.addItem(cta);
            }

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda de cuentas corrientes. "
                    + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void agregarFilasValores() {
        Fecha fecha = new Fecha();
        try {
            model.addRow(new Object[]{"", "", "", "", "", "", "", fecha.fechaString(new Date()), 0});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void quitarElemento(DefaultTableModel modelo, int filaSel) {
        try {
            int selectedRow = filaSel;
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar.",
                        "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.removeRow(selectedRow);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al quitar artículo de la lista. "
                    + e.getMessage(), "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void controlValores(int fila, int columna) {
        try {
            int selectedRow = fila;
            int selectedCol = columna;

            int valor = Integer.parseInt(tabValores.getValueAt(selectedRow, 0).toString());

            switch (selectedCol) {
                case 0:

                    switch (valor) {
                        case 1:
                            tabValores.setValueAt("Efectivo", selectedRow, 1);
                            tabValores.setValueAt(0, selectedRow, 2);
                            break;
                        case 2:
                            tabValores.setValueAt("Cheque", selectedRow, 1);
                            break;
                        default:
                            tabValores.changeSelection(selectedRow, 0, false, false);
                            JOptionPane.showMessageDialog(null, "El código ingresado en la columna 'Valor' no es válido."
                                    + "\n" + "(1) Efectivo o (2) Cheque",
                                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    break;

                case 1: // no realiza nada
                    break;

                case 2:
                    break;

                case 3:
                    MtBancos bco = new MtBancos();
                    if (valor == 2) {
                        //cheque
                        String codBco = tabValores.getValueAt(selectedRow, 3).toString();
                        bco = obtenerBanco(codBco, 1);
                        tabValores.setValueAt(bco.getNomBanco(), selectedRow, 4);
                    } else {
                        //efectivo
                        bco = obtenerBanco("0", 1);
                        tabValores.setValueAt(bco.getNomBanco(), selectedRow, 4);
                    }
                    break;

                case 4:
                    tabValores.changeSelection(selectedRow, 5, false, false);
                    break;

                case 5:
                    MtClientes cliente = new MtClientes();
                    String codcli = tabValores.getValueAt(selectedRow, 5).toString();
                    cliente = buscarCliente(codcli);
                    tabValores.setValueAt(cliente.getNomTit(), selectedRow, 6);

                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    BigDecimal importe = new BigDecimal(
                            tabValores.getValueAt(selectedRow, 8).toString());
                    int res = importe.compareTo(BigDecimal.ZERO);

                    if (res < 1) {
                        JOptionPane.showMessageDialog(null, "El importe ingresado debe ser mayor a 0.",
                                "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
                        tabValores.changeSelection(selectedRow, 8, false, false);
                    }

                    actualizarTotales();
                    break;

                default:// no realiza nada
                    actualizarTotales();
                    break;
            }

        } catch (NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar valor."
                    + "\n" + ex.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarTotales() {
        int cantArt = model.getRowCount();
        try {
            int valor;
            BigDecimal sumEfectivo = BigDecimal.ZERO;
            BigDecimal sumCheque = BigDecimal.ZERO;
            BigDecimal importe = BigDecimal.ZERO;

            for (int i = 0; i < cantArt; i++) {
                valor = Integer.parseInt(tabValores.getValueAt(i, 0).toString());
                importe = new BigDecimal(tabValores.getValueAt(i, 8).toString());
                if (valor == 1) {
                    sumEfectivo = sumEfectivo.add(importe);
                } else {
                    sumCheque = sumCheque.add(importe);
                }
            }

            this.txtTotalEfectivo.setValue(sumEfectivo);
            this.txtTotalCheque.setValue(sumCheque);
            this.txtTotalDeposito.setValue(sumEfectivo.add(sumCheque));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar totales. "
                    + "\n" + ex.getCause(), "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public Integer obtenerNroOpe() {
        Integer nroTrans = 0;

        try {
            //Query query = st.createSQLQuery("SELECT NEXTVAL('deposito_valores_seq')");
            Query query = st.createSQLQuery("SELECT max(nro_operacion) FROM mov_valores");
            nroTrans = (Integer) query.uniqueResult();

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Error al generar nro. de operacion. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
        }
        return nroTrans + 1;
    }

    public void guardar() {
        MovValores val = new MovValores();
        Caja caja = new Caja();
        MtMonedas mon = new MtMonedas();
        MtBancos banco = new MtBancos();
        TsBancosCtas cta = new TsBancosCtas();

        try {
            st.beginTransaction();

            //variables auxiliares
            int nroOperacion = Integer.parseInt(this.txtNroDeposito.getText());
            caja = obtenerCaja(this.txtCodCaja.getText());
            mon = obtenerMoneda(Integer.parseInt(this.txtCodMoneda.getText()));
            banco = obtenerBanco(this.cboBanco.getSelectedItem().toString(), 2);
            cta = obtenerCta(banco.getCodBanco(), this.cboCtaCte.getSelectedItem().toString());
            BigDecimal totalDepositado = new BigDecimal(this.txtTotalDeposito.getValue().toString());
            int refDeposito = 0;

            if (!this.txtRefDeposito.getText().equals("")) {
                refDeposito = Integer.parseInt(this.txtRefDeposito.getText());
            }

            if (origen.equals("Nuevo")) {
                val.setNroOperacion(nroOperacion);
                val.setFechaOper(this.txtFecha.getDate());
                val.setCaja(caja);
                val.setMtMonedas(mon);
                val.setMtBancos(banco);
                //val.setTsBancosCtas(cta);
                val.setNroCtaCte(this.cboCtaCte.getSelectedItem().toString());
                val.setRefDeposito(refDeposito);
                val.setTotalDepositado(totalDepositado);
                val.setUsuarioMod(usuario);
                val.setAccionMod(origen);
                val.setFechaMod(new Date());

                st.save(val);
                
            } else {
                val = obtenerRegistro(nroOperacion);
                
                //resta el importe actual para sumarlo con el importe nuevo
                actualizarSaldoCta(cta, val.getTotalDepositado().multiply(new BigDecimal(-1)));
                
                //carga nuevos valores de la actualizacion
                val.setFechaOper(this.txtFecha.getDate());
                val.setCaja(caja);
                val.setMtMonedas(mon);
                val.setMtBancos(banco);
                val.setNroCtaCte(this.cboCtaCte.getSelectedItem().toString());
                val.setRefDeposito(refDeposito);
                val.setTotalDepositado(totalDepositado);
                val.setUsuarioMod(usuario);
                val.setAccionMod(origen);
                val.setFechaMod(new Date());
                
                st.update(val);
                
                borrarDetalle(val);
            }
            
            guardarValores(nroOperacion);
            actualizarSaldoCta(cta, totalDepositado);

            st.getTransaction().commit();

            deshabilitarCampos();

        } catch (HibernateException | NumberFormatException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar registros del depósito. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Movimiento de Valores", 
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void borrarDetalle(MovValores val) {
        try {
            List<MovValDet> borrar = obtenerDetalle(val);

            for (MovValDet var : borrar) {
                st.delete(var);
            }
        } catch (HibernateException e) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al borrar detalle del depósito. "
                    + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void guardarValores(int operacion) {
        int cantArt = model.getRowCount();

        try {
            for (int i = 0; i < cantArt; i++) {

                MovValDet det = new MovValDet();
                MovValDetId id = new MovValDetId();
                Fecha fec = new Fecha();

                int tipo = Integer.parseInt(model.getValueAt(i, 0).toString());
                int referencia = Integer.parseInt(model.getValueAt(i, 2).toString());
                String bcoRef = model.getValueAt(i, 3).toString();
                String cliente = model.getValueAt(i, 5).toString();
                String venc = null;
                Date vencDoc = null;
                if (model.getValueAt(i, 7).toString() != null) {
                    venc = model.getValueAt(i, 7).toString();
                    vencDoc = fec.fechaDate(venc);
                }
                BigDecimal importe = new BigDecimal(model.getValueAt(i, 8).toString());
               
                id.setNroOperacion(operacion);
                id.setNroLinea(i + 1);
                det.setId(id);
                det.setTipoVal(tipo);
                det.setNumRef(referencia);
                det.setBcoRef(bcoRef);
                det.setCodCliente(cliente);
                det.setVnecimiento(vencDoc);
                det.setImporte(importe);

                st.save(det);
            }
        } catch (NumberFormatException | HibernateException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar el detalle del depósito. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Movimiento de Valores",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarSaldoCta(TsBancosCtas cta, BigDecimal total) {
        try {
            BigDecimal saldo = cta.getSaldoCuenta();
            cta.setSaldoCuenta(saldo.add(total));

            st.update(cta);

        } catch (HibernateException ex) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar saldo de la cuenta. Se revertirá la transacción."
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(), "Movimiento de Valores",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
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

    private void buscarRegistros() {
        try {
            String SqlQuery = "select nro_operacion from mov_valores where nro_operacion > 0 ";

            if (!this.txtNroDeposito.getText().trim().isEmpty()) {
                SqlQuery = SqlQuery + " and nro_operacion = '" + this.txtNroDeposito.getText().trim() + "'";
            }
            if (this.txtFecha.getDate() != null) {
                SqlQuery = SqlQuery + " and fecha_oper >= '" + this.txtFecha.getDate() + "'";
            }
            if (!this.txtCodMoneda.getText().trim().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_moneda = '" + this.txtCodMoneda.getText() + "'";
            }
            if (!this.txtCodCaja.getText().trim().isEmpty()) {
                SqlQuery = SqlQuery + " and cod_caja = '" + this.txtCodCaja.getText().trim() + "'";
            }
            if (!this.txtRefDeposito.getText().trim().isEmpty()) {
                SqlQuery = SqlQuery + " and ref_deposito = " + this.txtRefDeposito.getText().trim() + " ";
            }

            SqlQuery = SqlQuery + " order by nro_operacion";

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

                String mensaje = "Registro " + String.valueOf(posicion + 1).trim() + " de " + String.valueOf(ArrayPrimaryKey.size()).trim();
                this.lblInfoPie.setText(mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "No existen registros para mostrar.", "Buscar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | HibernateException e) {
            e.printStackTrace();
        }
    }

    public void recuperarRegistros(int indice) {
        inicializarCampos();
        int nro_operacion = Integer.parseInt(ArrayPrimaryKey.get(indice).toString());
        //obtenerRegistro(nro_operacion);
        cargarCabecera(obtenerRegistro(nro_operacion));
    }

    public MovValores obtenerRegistro(int operacion) {
        MovValores val = null;
        try {
            val = (MovValores) st.get(MovValores.class, operacion);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return val;
    }

    public void cargarCabecera(MovValores val) {
        try {
            this.txtNroDeposito.setText(String.valueOf(val.getNroOperacion()));
            this.txtFecha.setDate(val.getFechaOper());
            this.txtCodCaja.setText(val.getCaja().getCodCaja());
            this.txtNomCaja.setText(val.getCaja().getNomCaja());
            this.txtCodMoneda.setText(String.valueOf(val.getMtMonedas().getCodMoneda()));
            this.txtNomMoneda.setText(val.getMtMonedas().getNomMoneda());
            this.cboBanco.setSelectedItem(val.getMtBancos().getNomBanco());
            cargarCtaCte(val.getMtBancos());
            this.cboCtaCte.setSelectedItem(val.getNroCtaCte());
            this.txtRefDeposito.setText(String.valueOf(val.getRefDeposito()));

            cargarGrilla(obtenerDetalle(val));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al recuperar registros. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Movimiento de valores", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<MovValDet> obtenerDetalle(MovValores val) {
        List<MovValDet> lista = new ArrayList<MovValDet>();
        try {
            lista = (List<MovValDet>) st.createQuery(
                    "FROM MovValDet d JOIN d.id i WHERE i.nroOperacion = ?")
                    .setParameter(0, val.getNroOperacion())
                    .list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void cargarGrilla(List<MovValDet> lista) {
        try {
            for (MovValDet det : lista) {

                MtBancos bco;
                MtClientes cli;
                Fecha fecha = new Fecha();
                String tipo = "Efectivo";

                bco = obtenerBanco(det.getBcoRef(), 1);
                cli = buscarCliente(det.getCodCliente());
                if (det.getTipoVal() == 2) {
                    tipo = "Cheque";
                }

                model.addRow(new Object[]{
                    det.getTipoVal(), tipo, det.getNumRef(), det.getBcoRef(),
                    bco.getNomBanco(), det.getCodCliente(), cli.getNomTit(),
                    fecha.fechaString(det.getVnecimiento()), det.getImporte()
                });
            }
            actualizarTotales();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void borrarValores() {
        try {
            st.clear();
            st.beginTransaction();

            int operacion = Integer.parseInt(this.txtNroDeposito.getText());
            MovValores val = obtenerRegistro(operacion);
            TsBancosCtas cta = obtenerCta(val.getMtBancos().getCodBanco(), val.getNroCtaCte());

            borrarDetalle(val);
            actualizarSaldoCta(cta, val.getTotalDepositado().multiply(new BigDecimal(-1)));

            st.delete(val);
            st.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Moviento de Valores borrado exitosamente.",
                    "Movimiento de Valores", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | HibernateException e) {
            st.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al borrar Movimiento de Valores. "
                    + "\n" + e.getMessage() + "\n" + e.getCause(),
                    "Movimiento de Valores", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void imprimir() {
        try {
            int codigo = Integer.parseInt(this.txtNroDeposito.getText());
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            Map parametros = new HashMap();
            //parametros que enviamos al report.
            parametros.put("nro_operacion", codigo);
            parametros.put("usuario", usuario);
            JasperReport elReporte = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/MovimientoValores.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, parametros, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Movimiento de Valores");
            visor.setVisible(true);
            conexion.close();
        } catch (NumberFormatException | SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ejecutar el reporte. "
                    + "\n" + ex.getMessage() + "\n" + ex.getCause(),
                    "Movimiento de valores", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
