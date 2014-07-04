/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mantenimiento;

import com.entidades.MtSucursales;
import com.entidades.MtUsuarios;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

import net.sf.jasperreports.engine.JasperCompileManager;

/**
 * @author vanessa
 */
public class Usuarios extends javax.swing.JDialog {

    private Session st;
    private List<MtUsuarios> usuarios;
    private String usuario;
    private TableRowSorter<DefaultTableModel> sorter;
    SQLQuery query;

    /**
     * Creates new form modificarUsuario
     */
    public Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        deshabilitar();
        sessionHibernate();
        vaciarCampo();
        getData();
    }

    public Usuarios(String user) {
        initComponents();
        deshabilitar();
        sessionHibernate();
        vaciarCampo();
        getData();
        this.usuario = user;
    }

    private void deshabilitar() {
        btnGuardar.setEnabled(false);
        jPassword.setEnabled(false);
        jPassword2.setEnabled(false);
        textCI.setEnabled(false);
        textLogin.setEnabled(false);
        textCodSucursal.setEnabled(false);
        checkSi.setEnabled(false);
        checkNo.setEnabled(false);
        textNombre.setEnabled(false);
    }

    private void vaciarCampo() {
        textCI.setText("");
        textCodSucursal.setText("");
        textLogin.setText("");
        textNombre.setText("");
        jPassword.setText("");
        jPassword2.setText("");
        checkNo.setSelected(false);
        checkSi.setSelected(false);
    }

    private void getData() {
        sessionHibernate();
        usuarios = new ArrayList<MtUsuarios>();
        st.beginTransaction();
        String q = "select * from mt_usuarios;";
        query = st.createSQLQuery(q);
        query.addEntity(MtUsuarios.class);
        usuarios = query.list();
        st.getTransaction().commit();
        String[][] data = new String[usuarios.size()][5];

        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getCodUsuario();
            data[i][1] = usuarios.get(i).getNomUsuario();
            data[i][2] = usuarios.get(i).getNomUsuario();
            data[i][3] = usuarios.get(i).getMtSucursales().getCodSucursal();
            data[i][4] = String.valueOf(usuarios.get(i).getEsActivo());
        }

        String[] columnNames = {"Cedula", "Login", "Nombre", "Sucursal", "Activo"};
        //DefaultTableModel model = new DefaultTableModel(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaListaUsuarios.setModel(model);
        tablaListaUsuarios.setAutoscrolls(true);
        sorter = new TableRowSorter<DefaultTableModel>(model);
        tablaListaUsuarios.setRowSorter(sorter);
    }

    private boolean verificarContrasenha() {
        String psw1 = String.valueOf(jPassword.getPassword());
        String psw2 = String.valueOf(jPassword2.getPassword());
        if (!psw1.equals(psw2)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return false;
        }
        return true;
    }

    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf;
        //If current expression doesn't parse, don't update.
        try {
            int[] columnas = {0, 1};
            rf = RowFilter.regexFilter(textBuscar.getText(), columnas);
        } catch (Exception e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void eliminarUsuario(int pos) {
        st.beginTransaction();
        st.delete(usuarios.get(pos));
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        informe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        checkNo = new javax.swing.JCheckBox();
        checkSi = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jPassword2 = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textCI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        textLogin = new javax.swing.JTextField();
        textCodSucursal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        textBuscar = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Usuarios");

        tablaListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Login", "Nombre(s)", "Sucursal", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaUsuarios);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        btnNuevo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(60, 60));
        btnNuevo.setMinimumSize(new java.awt.Dimension(60, 60));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Save.png"))); // NOI18N
        btnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMaximumSize(new java.awt.Dimension(60, 60));
        btnGuardar.setMinimumSize(new java.awt.Dimension(60, 60));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        cancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cancelar.setContentAreaFilled(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        eliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        informe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        informe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        informe.setMaximumSize(new java.awt.Dimension(60, 60));
        informe.setMinimumSize(new java.awt.Dimension(60, 60));
        informe.setPreferredSize(new java.awt.Dimension(60, 60));
        informe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        informe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkNo.setText("No");
        checkNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNoActionPerformed(evt);
            }
        });

        checkSi.setText("Sí");
        checkSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSiActionPerformed(evt);
            }
        });

        jLabel12.setText("Es Activo");

        jPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Confirmar Contraseña");

        jLabel6.setText("Código Sucursal");

        jLabel15.setText("Usuario");

        jLabel11.setText("Nombre");

        textCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCIActionPerformed(evt);
            }
        });

        jLabel10.setText("Nro. Doc.");

        jLabel13.setText("Contraseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(21, 21, 21)
                                .addComponent(checkSi)
                                .addGap(10, 10, 10)
                                .addComponent(checkNo)
                                .addGap(0, 23, Short.MAX_VALUE))
                            .addComponent(jPassword2))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textCI, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCodSucursal)
                            .addComponent(textLogin))
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(textCodSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkSi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(textBuscar);
        textBuscar.setBounds(10, 10, 130, 20);

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(160, 10, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Mantenimiento de Usuarios - KARU v1.0");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Evento ActionPerformed para botón nuevo.
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        //arranque();// Evento ActionPerformed para botón cancelar.
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // eliminar();// Evento ActionPerformed para botón eliminar.
    }//GEN-LAST:event_eliminarActionPerformed

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked

// Habilita los campos para agregar un nuevo registro
        jPassword.setEnabled(true);
        jPassword2.setEnabled(true);
        textCI.setEnabled(true);
        textLogin.setEnabled(true);
        textCodSucursal.setEnabled(true);
        checkSi.setEnabled(true);
        checkNo.setEnabled(true);
        btnGuardar.setEnabled(true);
        textNombre.setEnabled(true);

    }//GEN-LAST:event_btnNuevoMouseClicked

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

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if (!verificarContrasenha() || !verificarCheck()) {
            return;
        }
        guardar();
        vaciarCampo();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void informeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeActionPerformed
        informe();
    }//GEN-LAST:event_informeActionPerformed

    private void textCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCIActionPerformed

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        // TODO add your handling code here:
        if (tablaListaUsuarios.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea eiminar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                eliminarUsuario(tablaListaUsuarios.getSelectedRow());
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_eliminarMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if (tablaListaUsuarios.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                initValues(usuarios.get(tablaListaUsuarios.getSelectedRow()));
            } else {
                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        newFilter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword2ActionPerformed

    private void checkSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkSiActionPerformed

    private void checkNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkNoActionPerformed

    private void initValues(MtUsuarios u) {
        textCI.setText(u.getCodUsuario());
        textCI.setEnabled(false);
        jPassword.setEnabled(true);
        jPassword2.setEnabled(true);
        textLogin.setEnabled(true);
        textCodSucursal.setEnabled(true);
        checkSi.setEnabled(true);
        checkNo.setEnabled(true);
        btnGuardar.setEnabled(true);
        textNombre.setEnabled(true);
        textNombre.setText(u.getNomUsuario());
        textLogin.setText(u.getNomUsuario());
        jPassword.setText(u.getContasenia());
        textCodSucursal.setText(u.getMtSucursales().getCodSucursal());
        if (String.valueOf(u.getEsActivo()).equals("S")) {
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
        
        MtUsuarios u = new MtUsuarios();
        u.setCodUsuario(textCI.getText());
        u.setEsActivo(activo());
        u.setMtSucursales((MtSucursales) st.get(MtSucursales.class, textCodSucursal.getText()));
        byte[] thedigest = {};
        try {
            byte[] bytesOfMessage = String.valueOf(jPassword.getPassword()).getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            thedigest = md.digest(bytesOfMessage);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
        }

        System.out.println(String.valueOf(thedigest));
        u.setContasenia(String.valueOf(jPassword.getPassword()));
        u.setNomUsuario(textNombre.getText());
        u.setNomUsuario(textLogin.getText());
        u.setUsuarioMod(this.usuario);
        u.setFechaMod(fecha);
        st.saveOrUpdate(u);
        st.getTransaction().commit();
        st.close();
        getData();
        JOptionPane.showMessageDialog(null, "Registro guardado.");
    }

    private char activo() {
        if (checkSi.isSelected()) {
            return 'S';
        } else {
            return 'N';
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuarios dialog = new Usuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox checkNo;
    private javax.swing.JCheckBox checkSi;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton informe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaListaUsuarios;
    private java.awt.TextField textBuscar;
    private javax.swing.JTextField textCI;
    private javax.swing.JTextField textCodSucursal;
    private javax.swing.JTextField textLogin;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void informe() {
        try {
            JasperCompileManager.compileReportToFile("src/com/informe/informe_usuarios.jrxml", "src/com/informe/informe_usuarios.jasper");
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }

        JDialog viewer = new JDialog(this, "Informe Usuarios.", true);
        viewer.setSize(800, 600);
        viewer.setLocationRelativeTo(null);

        String sourceFileName = "src/com/informe/informe_usuarios.jasper";

        ArrayList<MtUsuarios> dataList = getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource
                = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();

        try {
            JasperPrint fillReport = JasperFillManager.fillReport(
                    sourceFileName,
                    parameters,
                    beanColDataSource);

            //El JasperViewer para visualizar, le pasamos como argumento nuestro "fillReport" de arriba.
            JasperViewer jviewer = new JasperViewer(fillReport, false);
            //Le damos un título al reporte.
            jviewer.setTitle("Lista de Tipos de Artículos.");

            viewer.getContentPane().add(jviewer.getContentPane());
            viewer.setVisible(true);

            //La hacemos visible.
            //jviewer.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MtUsuarios> getDataBeanList() {
        ArrayList<MtUsuarios> dataBeanList = new ArrayList<MtUsuarios>();
        st.beginTransaction();
        String q = "select * from mt_usuarios;";
        query = st.createSQLQuery(q);
        query.addEntity(MtUsuarios.class);
        dataBeanList = (ArrayList<MtUsuarios>) query.list();
        return dataBeanList;
    }

}
