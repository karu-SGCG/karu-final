package com.app.stock;


import com.entidades.MtArticulos;
import com.entidades.MtUsuarios;
import com.entidades.MtSucursales;
import com.entidades.StExistenciaSuc;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import util.HibernateUtil;

public class Stock extends javax.swing.JDialog {

    private Session st;
    private List<MtArticulos> articulos;
      
    /**
     * Creates new form Stock
     */
    private String usuario;
    private String origen;
    private String formulario;
    private TableRowSorter<DefaultTableModel> sorter;
    private List<StExistenciaSuc> listaStock;
    private List<MtSucursales> sucursales; 
    SQLQuery query;

    public Stock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hibernateSession();
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();
        getData();
        this.txtCodUsuario.setText(this.usuario);
        
    }
    /**
     * Metodo que trae los datos de la BD y carga la tabla
     */
    private void getData() {
        hibernateSession();
        try { 
        listaStock = new ArrayList<StExistenciaSuc>();
        st.beginTransaction();
        String q = "select * from st_existencia_suc;";
        query = st.createSQLQuery(q);
        query.addEntity(StExistenciaSuc.class);
        listaStock = query.list();
        st.getTransaction().commit();
        String[][] data = new String[listaStock.size()][5];
        StExistenciaSuc aux;
        for (int i = 0; i < listaStock.size(); i++) {
            aux = listaStock.get(i);
            data[i][0] = aux.getMtArticulos().getNomArticulo();
            data[i][1] = aux.getMtSucursales().getNomSucursal();
            data[i][2] = aux.getCantidad().toString();
            data[i][3] = aux.getStockMinimo().toString();
            data[i][4] = aux.getMtArticulos().getMtTiposArticulos().getNomTipoArticulo();
            
        }

        String[] columnNames = {"Nombre Articulo", "Nombre Sucursal", "Cantidad", "Stock Minimo", "Tipo Articulo"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tablaStock.setModel(model);
        tablaStock.setAutoscrolls(true);
        // se asigna un renderer para cada columna 
        tablaStock.getColumnModel().getColumn(0).setCellRenderer(new BoardTableCellRenderer());
        tablaStock.getColumnModel().getColumn(1).setCellRenderer(new BoardTableCellRenderer());
        tablaStock.getColumnModel().getColumn(2).setCellRenderer(new BoardTableCellRenderer());
        tablaStock.getColumnModel().getColumn(3).setCellRenderer(new BoardTableCellRenderer());
        tablaStock.getColumnModel().getColumn(4).setCellRenderer(new BoardTableCellRenderer());
        //
        sorter = new TableRowSorter<DefaultTableModel>(model);
        tablaStock.setRowSorter(sorter);
        
        }
        catch (Exception e) { 
            
        }
    }
   
    /**
     * Metodo que permite filtrar las filas de la tabla, mediante el campo de busqueda.
     */
    
    //Metodo de busqueda 
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf;
        //If current expression doesn't parse, don't update.
        try {
            int[] columnas = {0, 1,2,3,4};
            rf = RowFilter.regexFilter(txtCodArt.getText(), columnas);
        } catch (Exception e) {
            return;
        }
        sorter.setRowFilter(rf);
    }
    
    /**
     * Metodo que permite colorear la tabla lista de stock, utilizando una clase con un renderizador
     */
    
    class BoardTableCellRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {

            Component c = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, col);
            
            Double minimo =  Double.parseDouble(table.getValueAt(row, 3).toString());
            Double cantidad = Double.parseDouble(table.getValueAt(row, 2).toString()); 
            c.setBackground(Color.WHITE);
            
            if (cantidad <= minimo) {
                c.setBackground(Color.RED);
            }   
            else if (isSelected) {
                    c.setBackground(Color.BLUE);
            }
            return c;
        }
    }
    
    public Stock(String user) {
        setLocationRelativeTo(null);
        initComponents();
        hibernateSession();
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
        valoresDefecto();
        this.txtCodUsuario.setText(this.usuario);
    }

   
    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public void cargarComboTipoArticulo() {
        this.comboTipoArticulo.removeAllItems();
        articulos = (List<MtArticulos>) st.createQuery("From MtArticulos").list();
        for (MtArticulos articulo : articulos) {
            this.comboTipoArticulo.addItem(articulo.getNomArticulo());
        }
    }

    public void cargarComboSucursal() {
        this.comboSucursal.removeAllItems();
        sucursales = (List<MtSucursales>) st.createQuery("From MtSucursales").list();
        for (MtSucursales sucursal : sucursales) {
            this.comboSucursal.addItem(sucursal.getNomSucursal());
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
        panArticulo = new javax.swing.JPanel();
        txtCodArt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        botonListar = new javax.swing.JButton();
        comboSucursal = new javax.swing.JComboBox();
        comboTipoArticulo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFechaHora = new javax.swing.JTextField();
        txtCodUsuario = new javax.swing.JTextField();
        txtNomUsuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStock = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        botonEditar = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jRadioButton1.setText("jRadioButton1");

        jLabel21.setText("Empresa");

        txtNomEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmpresa1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Facturación de Ventas - KARU SGCG v1.0");
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

        jLabel15.setText("Buscar:");

        botonListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Select.png"))); // NOI18N
        botonListar.setToolTipText("Agregar a lista");
        botonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarActionPerformed(evt);
            }
        });

        jLabel2.setText("Sucursal:");

        jLabel4.setText("Tipo de Articulo:");

        javax.swing.GroupLayout panArticuloLayout = new javax.swing.GroupLayout(panArticulo);
        panArticulo.setLayout(panArticuloLayout);
        panArticuloLayout.setHorizontalGroup(
            panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboSucursal, 0, 183, Short.MAX_VALUE)
                    .addComponent(comboTipoArticulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panArticuloLayout.setVerticalGroup(
            panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panArticuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panArticuloLayout.createSequentialGroup()
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panArticuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        tablaStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Articulo", "Nombre Sucursal", "Cantidad", "Stock Minimo", "Tipo Articulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaStock);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/edit.png"))); // NOI18N
        botonEditar.setToolTipText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/imprimir 24.png"))); // NOI18N
        botonImprimir.setToolTipText("Imprimir");

        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/Tasks.png"))); // NOI18N
        btnInforme.setToolTipText("Informe");
        btnInforme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInforme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panArticulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodUsuarioActionPerformed

    private void txtCodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodArtActionPerformed

    private void txtNomEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmpresa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpresa1ActionPerformed

    private void botonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarActionPerformed
        newFilter();
    }//GEN-LAST:event_botonListarActionPerformed

    private void txtCodArtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodArtFocusLost
        
    }//GEN-LAST:event_txtCodArtFocusLost

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        if (tablaStock.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un campo");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Está seguro que "
                    + "desea modificar el registro?", "Seleccione una opcion",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                   
                this.setFocusable(false);
                this.setAlwaysOnTop(false);
                
                StockMinimo sForm = new StockMinimo(listaStock.get(tablaStock.getSelectedRow()), usuario);
                sForm.setVisible(true);
                getData();
            } 
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        informe();
    }//GEN-LAST:event_btnInformeActionPerformed

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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Stock dialog = new Stock(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonListar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JComboBox comboSucursal;
    private javax.swing.JComboBox comboTipoArticulo;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panArticulo;
    private javax.swing.JTable tablaStock;
    private javax.swing.JTextField txtCodArt;
    private javax.swing.JTextField txtCodEmpresa1;
    private javax.swing.JTextField txtCodUsuario;
    private javax.swing.JTextField txtFechaHora;
    private javax.swing.JTextField txtNomEmpresa1;
    private javax.swing.JTextField txtNomUsuario;
    // End of variables declaration//GEN-END:variables

    public void inicializarCampos() {
        this.txtFechaHora.setText("");
        
    }

  
    private void valoresDefecto() {
        this.txtCodUsuario.setText(this.usuario);
        obtenerUsuario(this.usuario);  
    }
    
    public void obtenerUsuario(String cod) {
        
        try {
            MtUsuarios user = (MtUsuarios) st.get(MtUsuarios.class, cod);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Código de usuario buscado no existe. Intente de nuevo.",
                        "Factura Venta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.txtNomUsuario.setText(user.getNomUsuario());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar consulta. " + e.getMessage(),
                    "Facturación", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void informe() {

        JDialog viewer = new JDialog(this, "Informe Ciudades", true);
        viewer.setSize(800, 600);
        viewer.setLocationRelativeTo(null);

        try {
            String fileName = "src/com/informes/informe_stock.jrxml";
            File theFile = new File(fileName);
            JasperDesign jasperDesign = JRXmlLoader.load(theFile);
            String theQuery = "select nom_sucursal sucursal, nom_articulo articulo, "
                    + "cantidad, stock_minimo stock, nom_tipo_articulo tipo "
                    + "from mt_sucursales s , mt_articulos a, st_existencia_suc e, "
                    + "mt_tipos_articulos t  where s.cod_sucursal = e.cod_sucursal "
                    + "and e.cod_articulo = a.cod_articulo "
                    + "and t.cod_tipo_articulo = a.cod_tipo_articulo;";
            
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
