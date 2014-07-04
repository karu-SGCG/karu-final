/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mantenimiento;

/**
 *
 * @author vanessa
 */
import com.entidades.MtCheques;
import com.entidades.TsBancosCtas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

public class GestionCheques extends javax.swing.JFrame {

    private Session st;
    private List<MtCheques> cheques;
    private String usuario;
    SQLQuery query;

    public GestionCheques() {
        initComponents();
        vaciarCampo();
        deshabilitar();
        sessionHibernate();
        getData();
    }

    public GestionCheques(String user) {
        initComponents();
        vaciarCampo();
        deshabilitar();
        sessionHibernate();
        getData();
        this.usuario = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        botonEditar = new javax.swing.JButton();
        botonNuevo = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonInforme = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaCheques = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        textNroTransaccion = new java.awt.TextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textBanco = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textNroInicioTalonario = new java.awt.TextField();
        textNroFinTalonario = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textCtaCte = new java.awt.TextField();
        textMontoDisponible = new java.awt.TextField();
        textEstado = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        botonEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEditar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEditar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });

        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/New.png"))); // NOI18N
        botonNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonNuevo.setContentAreaFilled(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setMaximumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setMinimumSize(new java.awt.Dimension(60, 60));
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNuevoMouseClicked(evt);
            }
        });
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
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

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/cancel32.png"))); // NOI18N
        botonCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Trashcan_empty.png"))); // NOI18N
        botonEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setMaximumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setMinimumSize(new java.awt.Dimension(60, 60));
        botonEliminar.setPreferredSize(new java.awt.Dimension(60, 60));
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });

        botonInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        botonInforme.setToolTipText("");
        botonInforme.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonInforme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInforme.setMaximumSize(new java.awt.Dimension(60, 60));
        botonInforme.setMinimumSize(new java.awt.Dimension(60, 60));
        botonInforme.setPreferredSize(new java.awt.Dimension(60, 60));
        botonInforme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInformeMouseClicked(evt);
            }
        });
        botonInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Cheques");

        tablaListaCheques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Trans.", "Banco", "Cta. Cte.", "Nro Inicio Talonario", "Nro Fin Talonario", "Monto", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListaCheques.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tablaListaCheques);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Nro. Transaccion");

        jLabel2.setText("Banco");

        jLabel3.setText("Nro. de Inicio Talonario");

        jLabel4.setText("Nro. de Fin Talonario");

        jLabel5.setText("Cta. Cte.:");

        jLabel6.setText("Monto Disponible:");

        jLabel7.setText("Estado");

        textEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(16, 16, 16)
                                .addComponent(textNroTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMontoDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textCtaCte, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNroInicioTalonario, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(textNroFinTalonario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNroTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textNroInicioTalonario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(textBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(textNroFinTalonario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5)
                    .addComponent(textCtaCte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(textMontoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vaciarCampo() {
        textNroTransaccion.setText("");
        textBanco.setText("");
        textCtaCte.setText("");
        textEstado.setText("");
        textNroFinTalonario.setText("");
        textMontoDisponible.setText("");
        textNroInicioTalonario.setText("");
    }

    private void deshabilitar() {
        botonGuardar.setEnabled(false);
        textNroFinTalonario.setEnabled(false);
        textNroInicioTalonario.setEnabled(false);
        textNroTransaccion.setEnabled(false);
        textBanco.setEnabled(false);
        textCtaCte.setEnabled(false);
        textEstado.setEnabled(false);
        textMontoDisponible.setEnabled(false);
    }

    private void getData() {
        sessionHibernate();
        cheques = new ArrayList<MtCheques>();
        st.beginTransaction();
        String q = "select * from mt_cheques;";
        query = st.createSQLQuery(q);
        query.addEntity(MtCheques.class);
        cheques = query.list();
        st.getTransaction().commit();
        String[][] data = new String[cheques.size()][7];

        for (int i = 0; i < cheques.size(); i++) {
            data[i][0] = Integer.toString(cheques.get(i).getNrotrans());
            data[i][1] = cheques.get(i).getTsBancosCtas().getMtBancos().getNomBanco();
            data[i][2] = cheques.get(i).getTsBancosCtas().getId().getNroCuenta();
            data[i][3] = cheques.get(i).getNroiniciotalonario();
            data[i][4] = cheques.get(i).getNrofintalonario();
            data[i][5] = cheques.get(i).getMontodisponible();
            data[i][6] = cheques.get(i).getEstado();

        }

        String[] columnNames = {"Nro Transaccion", "Bancos", "Cta. Cte., Nro. Inicio Talonario, Nro. Fin Talonario, Monto Disponible, Estado"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tablaListaCheques.setModel(model);
        tablaListaCheques.setAutoscrolls(true);

    }

    private void eliminarCheques(int pos) {
        st.beginTransaction();
        st.delete(cheques.get(pos));
        st.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro eliminado.");
        getData();
    }

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        if (tablaListaCheques.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                initValues(cheques.get(tablaListaCheques.getSelectedRow()));
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNuevoMouseClicked

        // Habilita los campos para agregar un nuevo registro
        textNroTransaccion.setEnabled(true);
        textBanco.setEnabled(true);
        textCtaCte.setEnabled(true);
        textNroFinTalonario.setEnabled(true);
        textNroInicioTalonario.setEnabled(true);
        textMontoDisponible.setEnabled(true);
        textEstado.setEnabled(true);
        botonGuardar.setEnabled(true);
        vaciarCampo();
    }//GEN-LAST:event_botonNuevoMouseClicked

    private void initValues(MtCheques ch) {
        textNroTransaccion.setText(Integer.toString(ch.getNrotrans()));
        textNroTransaccion.setEnabled(false);
        textBanco.setText(ch.getTsBancosCtas().getMtBancos().getNomBanco());
        textBanco.setEnabled(true);
        textCtaCte.setText(ch.getTsBancosCtas().getId().getNroCuenta());
        textCtaCte.setEnabled(true);
        textNroInicioTalonario.setText(ch.getNroiniciotalonario());
        textNroInicioTalonario.setEnabled(true);
        textNroFinTalonario.setText(ch.getNrofintalonario());
        textNroFinTalonario.setEnabled(true);
        textMontoDisponible.setText(ch.getMontodisponible());
        textMontoDisponible.setEnabled(true);
        textEstado.setText(ch.getEstado());
        textEstado.setEnabled(true);
        botonGuardar.setEnabled(true);
    }

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        guardar();
        vaciarCampo();
    }//GEN-LAST:event_botonGuardarMouseClicked

    public void guardar() {
        st.close();
        sessionHibernate();
        st.beginTransaction();
        
        Date fecha = new Date();
        
        MtCheques ch = new MtCheques();
        ch.setNrotrans(Integer.parseInt(textNroTransaccion.getText()));
        ch.setTsBancosCtas((TsBancosCtas) st.get(TsBancosCtas.class, textBanco.getText()));
        ch.setTsBancosCtas((TsBancosCtas) st.get(TsBancosCtas.class, textCtaCte.getText()));
        ch.setNroiniciotalonario(textNroInicioTalonario.getText());
        ch.setNrofintalonario(textNroFinTalonario.getText());
        ch.setMontodisponible(textMontoDisponible.getText());
        ch.setEstado(textEstado.getText());
        ch.setUsuarioMod(this.usuario);
        ch.setFechaMod(fecha);
        
        st.saveOrUpdate(ch);
        st.getTransaction().commit();
        st.close();
        getData();
        JOptionPane.showMessageDialog(null, "Registro guardado");
    }


    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        // TODO add your handling code here:
        if (tablaListaCheques.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Usuario: Debe seleccionar un campo.");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que desea eiminar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                eliminarCheques(tablaListaCheques.getSelectedRow());
            } else {

                //System.out.println("Cancelled");
            }
        }
    }//GEN-LAST:event_botonEliminarMouseClicked

    private void botonInformeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInformeMouseClicked
        // TODO add your handling code here:
        // informe();
    }//GEN-LAST:event_botonInformeMouseClicked

    private void textEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEstadoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformeActionPerformed

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
            java.util.logging.Logger.getLogger(GestionCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCheques().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonInforme;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaListaCheques;
    private java.awt.TextField textBanco;
    private java.awt.TextField textCtaCte;
    private java.awt.TextField textEstado;
    private java.awt.TextField textMontoDisponible;
    private java.awt.TextField textNroFinTalonario;
    private java.awt.TextField textNroInicioTalonario;
    private java.awt.TextField textNroTransaccion;
    // End of variables declaration//GEN-END:variables

    public void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

}
