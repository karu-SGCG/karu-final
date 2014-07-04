/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mantenimiento;

import com.entidades.MtCiudades;
import com.entidades.MtProveedores;
import com.entidades.MtTipoDocumentos;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author banuelor
 */
public class Proveedores extends javax.swing.JFrame {

    private Session st;
    private List<MtProveedores> proveedores;
    private String usuario;
    private TableRowSorter<DefaultTableModel> sorter;
    SQLQuery query;

    /**
     * Creates new form MantenimientoProveedores
     */
    public Proveedores() {
        initComponents();
        deshabilitar();
        sessionHibernate();
        vaciarCampo();
        getData();
        cargarCboTipoDoc();
        cargarCboCiudad();
    }

    public Proveedores(String user) {
        initComponents();
        deshabilitar();
        sessionHibernate();
        vaciarCampo();
        getData();
        cargarCboTipoDoc();
        cargarCboCiudad();
        this.usuario = user;
    }

    private void deshabilitar() {
        botonGuardar.setEnabled(false);
        cmbTipoDoc.setEnabled(false);
        textTelefono.setEnabled(false);
        cmbCiudad.setEnabled(false);
        textCelular.setEnabled(false);
        textDireccion.setEnabled(false);
        checkSi.setEnabled(false);
        checkNo.setEnabled(false);
        textNombre.setEnabled(false);
        textEmail.setEnabled(false);
        textNroDoc.setEnabled(false);
    }

    private void habilitar() {
        botonGuardar.setEnabled(true);
        cmbTipoDoc.setEnabled(true);
        textCelular.setEnabled(true);
        textTelefono.setEnabled(true);
        cmbCiudad.setEnabled(true);
        textDireccion.setEnabled(true);
        checkSi.setEnabled(true);
        checkNo.setEnabled(true);
        textNombre.setEnabled(true);
        textEmail.setEnabled(true);
        textNroDoc.setEnabled(true);
    }

    private void vaciarCampo() {
        cmbTipoDoc.setSelectedIndex(-1);
        textCelular.setText("");
        textTelefono.setText("");
        cmbCiudad.setSelectedIndex(-1);
        textDireccion.setText("");

        textNombre.setText("");
        textEmail.setText("");
        textNroDoc.setText("");
    }

    private void getData() {
        sessionHibernate();
        proveedores = new ArrayList<MtProveedores>();
        st.beginTransaction();
        String q = "select * from mt_proveedores;";
        query = st.createSQLQuery(q);
        query.addEntity(MtProveedores.class);
        proveedores = query.list();
        st.getTransaction().commit();
        String[][] data = new String[proveedores.size()][10];

        for (int i = 0; i < proveedores.size(); i++) {
            data[i][0] = proveedores.get(i).getMtTipoDocumentos().getNombre();
            data[i][1] = proveedores.get(i).getNroDocum();
            data[i][2] = proveedores.get(i).getNomTit();
            data[i][3] = proveedores.get(i).getDirTitular();
            data[i][4] = proveedores.get(i).getTelTitular();
            data[i][5] = proveedores.get(i).getCelTitular();
            data[i][6] = proveedores.get(i).getCelTitular();
            data[i][7] = proveedores.get(i).getEmail();
            data[i][8] = String.valueOf(proveedores.get(i).getEsActivo());
            data[i][9] = String.valueOf(proveedores.get(i).getPorcDto());
        }

        String[] columnNames = {"Tipo", "Nro.Docum", "Nombre", "Direccion",
            "Telefono", "Celular", "Ciudad", "Email", "Activo", "Descuento"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaListaProveedores.setModel(model);
        tablaListaProveedores.setAutoscrolls(true);
        sorter = new TableRowSorter<DefaultTableModel>(model);
        tablaListaProveedores.setRowSorter(sorter);
    }

    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf;
        //If current expression doesn't parse, don't update.
        try {
            int[] columnas = {1, 2};
            rf = RowFilter.regexFilter(textBuscar.getText(), columnas);
        } catch (Exception e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void eliminarProveedor(int pos) {
        st.beginTransaction();
        st.delete(proveedores.get(pos));
        st.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro eliminado.");
        getData();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        grupoActivo = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaProveedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        informe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        textEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtextCelular = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textNroDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textCelular = new javax.swing.JTextField();
        cmbTipoDoc = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbCiudad = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        checkSi = new javax.swing.JCheckBox();
        checkNo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txtPorcDto = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tablaListaProveedores.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        tablaListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaProveedores);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Proveedores");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        btnNuevo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo1.setContentAreaFilled(false);
        btnNuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo1.setMaximumSize(new java.awt.Dimension(60, 60));
        btnNuevo1.setMinimumSize(new java.awt.Dimension(60, 60));
        btnNuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevo1MouseClicked(evt);
            }
        });
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        btnEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMaximumSize(new java.awt.Dimension(60, 60));
        btnEditar.setMinimumSize(new java.awt.Dimension(60, 60));
        btnEditar.setPreferredSize(new java.awt.Dimension(60, 60));
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        botonGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonGuardar.setContentAreaFilled(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelar.setContentAreaFilled(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminar.setContentAreaFilled(false);
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setMaximumSize(new java.awt.Dimension(60, 60));
        eliminar.setMinimumSize(new java.awt.Dimension(60, 60));
        eliminar.setPreferredSize(new java.awt.Dimension(60, 60));
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        informe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        informe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        informe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        informe.setMaximumSize(new java.awt.Dimension(60, 60));
        informe.setMinimumSize(new java.awt.Dimension(60, 60));
        informe.setPreferredSize(new java.awt.Dimension(60, 60));
        informe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        informe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Email");

        jLabel7.setText("Ciudad");

        jLabel14.setText("Dirección");

        jtextCelular.setText("Celular");

        jLabel15.setText("Teléfono");

        jLabel13.setText("Nombre");

        jLabel11.setText("Nro. Documento");

        jLabel2.setText("Tipo de Doc.");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Activo:");

        grupoActivo.add(checkSi);
        checkSi.setSelected(true);
        checkSi.setText("Sí");

        grupoActivo.add(checkNo);
        checkNo.setText("No");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkSi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkSi)
                    .addComponent(checkNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Dto. Otorgado");

        txtPorcDto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtPorcDto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorcDtoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtextCelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textEmail))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 84, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPorcDto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textNombre))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtPorcDto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtextCelular)
                    .addComponent(textCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textBuscar)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void informeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informeMouseClicked
        // TODO add your handling code here:
        informe();
    }//GEN-LAST:event_informeMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        // TODO add your handling code here:
        if (tablaListaProveedores.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea eiminar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                eliminarProveedor(tablaListaProveedores.getSelectedRow());
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_eliminarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if (tablaListaProveedores.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Mantenimiento de Proveedores",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                initValues(proveedores.get(tablaListaProveedores.getSelectedRow()));
                habilitar();
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnNuevo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevo1MouseClicked

        // Habilita los campos para agregar un nuevo registro
        habilitar();
        vaciarCampo();
    }//GEN-LAST:event_btnNuevo1MouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        guardar();
        vaciarCampo();
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        newFilter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
         guardar();
        vaciarCampo();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        habilitar();
        vaciarCampo();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPorcDtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorcDtoFocusLost
        try{
            this.txtPorcDto.commitEdit();
        } catch (Exception e) {
            this.txtPorcDto.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtPorcDtoFocusLost

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox checkNo;
    private javax.swing.JCheckBox checkSi;
    private javax.swing.JComboBox cmbCiudad;
    private javax.swing.JComboBox cmbTipoDoc;
    private javax.swing.JButton eliminar;
    private javax.swing.ButtonGroup grupoActivo;
    private javax.swing.JButton informe;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtextCelular;
    private javax.swing.JTable tablaListaProveedores;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textCelular;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNroDoc;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JFormattedTextField txtPorcDto;
    // End of variables declaration//GEN-END:variables

    private boolean verificarCheck() {
        if (!checkSi.isSelected() && !checkNo.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccione si esta activo o no");
            return false;
        }

        if (checkSi.isSelected() && checkNo.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccione solo una opcion");
            return false;
        }

        return true;
    }

    private void initValues(MtProveedores p) {
        cmbTipoDoc.setSelectedItem(p.getMtTipoDocumentos().getTipoDocValor());
        textTelefono.setText(p.getTelTitular());
        cmbCiudad.setSelectedItem(p.getMtCiudades().getNomCiudad());
        textCelular.setText(p.getCelTitular());
        textDireccion.setText(p.getDirTitular());
        textNombre.setText(p.getNomTit());
        textEmail.setText(p.getEmail());
        textNroDoc.setText(p.getNroDocum());
        txtPorcDto.setValue(p.getPorcDto());

        if (String.valueOf(p.getEsActivo()).equals("S")) {
            checkSi.setSelected(true);
        } else {
            checkNo.setSelected(true);
        }
    }

    public void guardar() {
        st.close();
        sessionHibernate();
        st.beginTransaction();
        
        Date fecha = new Date();
        
        Object tipoDoc = this.cmbTipoDoc.getSelectedItem();
        MtTipoDocumentos nomTipoDoc = retornoTipoDoc(tipoDoc.toString());
        
        Object ciudad = this.cmbCiudad.getSelectedItem();
        MtCiudades nomCiudad = retornoCiudad(ciudad.toString());
        
        MtProveedores p = new MtProveedores();
        p.setMtTipoDocumentos(nomTipoDoc);
        p.setCelTitular(textCelular.getText());
        p.setDirTitular(textDireccion.getText());
        p.setEmail(textEmail.getText());
        p.setEsActivo(activo());
        p.setMtCiudades(nomCiudad);
        p.setNomTit(textNombre.getText());
        p.setTelTitular(textTelefono.getText());
        p.setNroDocum(textNroDoc.getText());
        p.setUsuarioMod(this.usuario);
        p.setFechaMod(fecha);
        p.setPorcDto(BigDecimal.valueOf(Double.parseDouble(this.txtPorcDto.getValue().toString())));
        
        st.saveOrUpdate(p);
        st.getTransaction().commit();
        st.close();
        getData();
        JOptionPane.showMessageDialog(null, "Registro guardado.");
    }
    
    public MtTipoDocumentos retornoTipoDoc(String tipo) {
        MtTipoDocumentos docRet = null;
        Query query = st.createQuery("From MtTipoDocumentos t Where t.tipoDocValor = ?");
        query.setParameter(0, tipo);
        try {
            docRet = (MtTipoDocumentos) query.uniqueResult();
            //docRet = (MtTipoDocumentos) query.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay mas registros repetidos: " + tipo,
                    "Mantenimiento de Clientes", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al recuperar tipoDocumento. (" + tipo + ")  -   " + e.getMessage());
            e.printStackTrace();
        }
        return docRet;
    }

    public MtCiudades retornoCiudad(String ciudad) {
        MtCiudades docRet = null;
        Query query = st.createQuery("From MtCiudades t Where t.nomCiudad = ?");
        query.setParameter(0, ciudad);
        try {
            docRet = (MtCiudades) query.uniqueResult();
            //docRet = (MtTipoDocumentos) query.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay mas registros repetidos: " + ciudad,
                    "Mantenimiento de Clientes", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Error al recuperar tipoDocumento. (" + ciudad + ")  -   " + e.getMessage());
            e.printStackTrace();
        }
        return docRet;
    }
    
    private char activo() {
        if (checkSi.isSelected()) {
            return 'S';
        } else {
            return 'N';
        }
    }

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void cargarCboTipoDoc() {
        this.cmbTipoDoc.removeAllItems();
        List<MtTipoDocumentos> lista = (List<MtTipoDocumentos>) st.createQuery("From MtTipoDocumentos").list();
        for (MtTipoDocumentos tipoDocList : lista) {
            this.cmbTipoDoc.addItem(tipoDocList.getTipoDocValor());
        }
        cmbTipoDoc.setSelectedIndex(-1);
    }
    
    public void cargarCboCiudad() {
        this.cmbCiudad.removeAllItems();
        List<MtCiudades> lista = (List<MtCiudades>) st.createQuery("From MtCiudades").list();
        for (MtCiudades tipoDocList : lista) {
            this.cmbCiudad.addItem(tipoDocList.getNomCiudad());
        }
        cmbTipoDoc.setSelectedIndex(-1);
    }    

    private void informe() {

        JDialog viewer = new JDialog(this, "Informe Proveedores", true);
        viewer.setSize(800, 600);
        viewer.setLocationRelativeTo(null);

        try {
            String fileName = "src/com/informe/informe_proveedores.jrxml";
            File theFile = new File(fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(theFile);

            //Build a new query
            String theQuery = "select cod_tit, nro_docum, nom_tit, dir_titular, tel_titular "
                    + "from mt_proveedores;";

            // update the data query
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(theQuery);
            jasperDesign.setQuery(newQuery);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection conn = st.connection();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
            JasperViewer jv = new JasperViewer(jasperPrint);

            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
