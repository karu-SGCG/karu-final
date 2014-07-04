/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util.buscar;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * @author Fausto
 * @Sobreescrito Carlos Patiño 
 * @version  0.2
 */
public class BuscarComprobante extends javax.swing.JDialog {

    /**
     * Creates new form Busqueda
     */
    
    public BuscarComprobante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();  
        sql = "select f.tipo_comprobante, f.cod_tribut_fac, f.cod_suc_fac, f.nro_docum, "
                + " (f.total_gravada + f.total_gravada), f.cod_caja, f.fecha, f.nro_trans "
                + " from factura_venta f ";
        this.tipoComp = "FT";
        this.estado = 'C';
        modeloTabla();
        setLocationRelativeTo(null);  
    }
      
    public BuscarComprobante(java.awt.Dialog parent, boolean modal, String tipoComp, char estado) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        
        this.codigoRetorno = "0";
        this.tipoComp = tipoComp;
        this.estado = estado;
        consulta = 1;
        
        sql = "select f.tipo_comprobante, f.cod_tribut_fac, f.cod_suc_fac, f.nro_docum, "
                + " (f.total_gravada + f.total_gravada), f.cod_caja, f.fecha, f.nro_trans "
                + " from factura_venta f ";
        modeloTabla();
        setLocationRelativeTo(null);
    }
    
    public BuscarComprobante(java.awt.Dialog parent, boolean modal, String tipoComp, String codCliente) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        
        this.codigoRetorno = "0";
        this.tipoComp = tipoComp;
        this.txtCriterio.setText(codCliente);
        this.txtCriterio.setEnabled(false);
        this.bandera = 1;
        consulta = 2;
        
        sql = "select p.cod_docum, p.cod_tribut_fac, p.cod_suc_fac, p.nro_docum, "
                + " p.fec_doc, p.cod_moneda, p.importe_origen, p.saldo, p.nro_trans "
                + " from sa_pendientes p ";
        modeloTabla2();
        cargarTabla2();
    }
    
    // Busca los las cajas habilitadas para el aqueo
    public BuscarComprobante(java.awt.Dialog parent, boolean modal, char estado) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();

        this.codigoRetorno = "0";
        //this.tipoComp = tipoComp;
        
        if (estado == 'V' || estado == 'C') {
            this.txtCriterio.setText("");
            this.txtCriterio.setEnabled(true);
        } else {
            this.txtCriterio.setText(String.valueOf(estado));
            this.txtCriterio.setEnabled(false);
        }
        
        
        this.txtCriterio.setToolTipText("Escriba estado de caja ('A' Abierto o 'C' Cerrado)");
        this.bandera = 2;
        consulta = 4;

        sql = "select a.nro_operacion, a.cod_caja, a.fecha_desde, a.fecha_hasta, a.estado "
                + " from arqueo_cab a ";
        modeloTabla4();
        cargarTabla4();
    }
    
    public BuscarComprobante(java.awt.Dialog parent, boolean modal, int valor) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        
        this.setTitle("Buscar Ordenes de Pago Pendientes");
        this.codigoRetorno = "0";
        this.tipoComp = tipoComp;
        this.txtCriterio.setText("");
        this.txtCriterio.setEnabled(false);
        this.btnBuscar.setEnabled(false);
        this.bandera = 2;
        consulta = 3;
        
        sql = "select o.nro_opago, o.cod_proveedor, o.cod_caja, o.fecha, o.total "
                + " from orden_pago o ";
        modeloTabla3();
        cargarTabla3();
    }
    
    private String sql;
    private String sqlComp;
    private Session st;
    private String codigoRetorno;
    private String tipoComp;
    private char estado;
    private DefaultTableModel model;
    private int bandera = 0;
    private int consulta = 0;

    private void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    private void arranque() {

        //Seteamos los campos editables por el usuario
        this.txtCriterio.setEnabled(true);
        this.txtCriterio.grabFocus();

        //Seteamos el estado de los botones
        this.btnAceptar.setEnabled(true);
        this.rdoCod.setSelected(true);

        //Seteamos y cargamos la tabla
        this.tablaResultados.setEnabled(true);
    }

    public void modeloTabla() {
        model = (DefaultTableModel) this.tablaResultados.getModel();
        model.setNumRows(0);
    }
    
    public void modeloTabla2() {
        model = new DefaultTableModel();
        //this.tablaResultados.removeAll();
        this.tablaResultados.setModel(model);
        model.addColumn("Tipo");
        model.addColumn("cod_tribut_fac");
        model.addColumn("cod_suc_fac");
        model.addColumn("nro_docum");
        model.addColumn("fec_doc");
        model.addColumn("moneda");
        model.addColumn("Imp. Origen");
        model.addColumn("Saldo");
        model.addColumn("Transacción");
        model.setNumRows(0);
    }
    
    public void modeloTabla3() {
        model = new DefaultTableModel();
        this.tablaResultados.setModel(model);
        model.addColumn("Nro. OP");
        model.addColumn("Cod. Proveedor");
        model.addColumn("Caja");
        model.addColumn("Fecha");
        model.addColumn("Imp. Total");
        model.setNumRows(0);
    }
    
    public void modeloTabla4() {
        model = new DefaultTableModel();
        this.tablaResultados.setModel(model);
        model.addColumn("Nro. OP");
        model.addColumn("Caja");
        model.addColumn("Apertura");
        model.addColumn("Cierre");
        model.addColumn("Estado");
        model.setNumRows(0);
    }

    //carga de tabla por defecto
    public void cargarTabla() {
        String cod = this.txtCriterio.getText();

        if (!cod.isEmpty()) {
            sqlComp = sql + "where f.cod_cliente = '" + cod + "'";
        } else {
            sqlComp = sql + " where f.tipo_comprobante = '"
                    + this.tipoComp + "' and f.estado = '" + this.estado
                    + "' order by f.tipo_comprobante, f.fecha";
        }
        System.out.println("Consulta: " + sqlComp);
        List<Object[]> retorno;

        try {
            st.beginTransaction();
            SQLQuery consulta = st.createSQLQuery(sqlComp);
            retorno = consulta.list();

            //carga el resultado en la grilla
            for (Object[] fila : retorno) {
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                    + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    //carga de tabla sobrecargado para busqueda automatica por cliente
     public void cargarTabla2() {
        if (!this.txtCriterio.getText().isEmpty()) {

            String cod = this.txtCriterio.getText();

            sqlComp = sql + "where p.cod_tit = '" + cod + "' and p.cod_docum = '"
                    + this.tipoComp + "' and p.saldo > 0 " 
                    + " order by p.cod_docum, p.fec_doc";

            System.out.println("Consulta: " + sqlComp);
            List<Object[]> retorno;

            try {
                st.beginTransaction();
                SQLQuery consulta = st.createSQLQuery(sqlComp);
                retorno = consulta.list();

                //caraga el resultado en la grilla
                for (Object[] fila : retorno) {
                    model.addRow(fila);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                        + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
     
    //carga de tabla sobrecargado para busqueda automatica por OP pendientes
    public void cargarTabla3() {
        sqlComp = sql + " where o.estado = 'P' order by o.nro_opago, o.fecha";

        System.out.println("Consulta: " + sqlComp);
        List<Object[]> retorno;

        try {
            st.beginTransaction();
            SQLQuery consulta = st.createSQLQuery(sqlComp);
            retorno = consulta.list();

            //caraga el resultado en la grilla
            for (Object[] fila : retorno) {
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                    + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    //carga de tabla sobrecargado para busqueda automatica de apertura de cajas
    public void cargarTabla4() {

        if (this.txtCriterio.getText().isEmpty()) {
            sqlComp = sql + " order by a.nro_operacion";
        } else {
            sqlComp = sql + " where a.estado = '" + this.txtCriterio.getText() + "'"
                    + " order by a.nro_operacion";
        }

        System.out.println("Consulta: " + sqlComp);
        List<Object[]> retorno;

        try {
            st.beginTransaction();
            SQLQuery consulta = st.createSQLQuery(sqlComp);
            retorno = consulta.list();

            //caraga el resultado en la grilla
            for (Object[] fila : retorno) {
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                    + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModo = new javax.swing.ButtonGroup();
        panelResultados = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelCriterio = new javax.swing.JPanel();
        txtCriterio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelModo = new javax.swing.JPanel();
        rdoCod = new javax.swing.JRadioButton();
        rdoDesc = new javax.swing.JRadioButton();
        panelBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar");

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "cod_tribut", "cod_suc", "nro_factura", "Importe Total", "caja", "fecha_vta", "nro_trans"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResultados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaResultados.getTableHeader().setReorderingAllowed(false);
        tablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaResultadosMouseClicked(evt);
            }
        });
        panelResultados.setViewportView(tablaResultados);
        tablaResultados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaResultados.getColumnModel().getColumnCount() > 0) {
            tablaResultados.getColumnModel().getColumn(5).setMinWidth(20);
        }
        tablaResultados.getAccessibleContext().setAccessibleName("Busqueda de Comprobantes");

        panelCriterio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCriterioLayout = new javax.swing.GroupLayout(panelCriterio);
        panelCriterio.setLayout(panelCriterioLayout);
        panelCriterioLayout.setHorizontalGroup(
            panelCriterioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriterioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        panelCriterioLayout.setVerticalGroup(
            panelCriterioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriterioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCriterioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelModo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        grupoModo.add(rdoCod);
        rdoCod.setSelected(true);
        rdoCod.setText("Buscar por codigo");

        grupoModo.add(rdoDesc);
        rdoDesc.setText("Buscar por descripcion");
        rdoDesc.setEnabled(false);

        javax.swing.GroupLayout panelModoLayout = new javax.swing.GroupLayout(panelModo);
        panelModo.setLayout(panelModoLayout);
        panelModoLayout.setHorizontalGroup(
            panelModoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(panelModoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelModoLayout.setVerticalGroup(
            panelModoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoDesc))
        );

        panelBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelResultados)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelModo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        model.setRowCount(0);
       // cargarTabla();
        
        switch (consulta) {
            case 1:
                cargarTabla();
                break;
            case 2:
                cargarTabla2();
                break;
            case 3:
                cargarTabla3();
                break;
            case 4:
                cargarTabla4();
                break;
            default:
                cargarTabla();
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadosMouseClicked
        int filaSeleccionada = this.tablaResultados.getSelectedRow();
        
        switch (bandera) {
            case 1:
                this.codigoRetorno = model.getValueAt(filaSeleccionada, 8).toString();
                break;
            case 2:
                this.codigoRetorno = model.getValueAt(filaSeleccionada, 0).toString();
                break;
            default:
                this.codigoRetorno = model.getValueAt(filaSeleccionada, 7).toString();
                break;
        }
    }//GEN-LAST:event_tablaResultadosMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
        } catch (Exception ex) {

        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BuscarComprobante dialog = new BuscarComprobante(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup grupoModo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCriterio;
    private javax.swing.JPanel panelModo;
    private javax.swing.JScrollPane panelResultados;
    private javax.swing.JRadioButton rdoCod;
    private javax.swing.JRadioButton rdoDesc;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtCriterio;
    // End of variables declaration//GEN-END:variables

}
