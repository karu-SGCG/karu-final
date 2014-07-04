package util.buscar;

import util.*;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * @author Fausto Sanabria
 * @author Carlos Patiño
 */
public class BusquedaArticulos extends javax.swing.JDialog {

    /**
     * Creates new form Busqueda
     * @param parent
     * @param modal
     */
    
    private String codTipo;
    
    public BusquedaArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        this.setTitle("Búsqueda genérica");
        this.colDescripcion = "nom_articulo";
        this.colCodigo = "cod_articulo";
        sql = "Select " + colCodigo + ", " + colDescripcion + " From mt_articulos";
        setLocationRelativeTo(null);
    }
      
    public BusquedaArticulos(java.awt.Dialog parent, boolean modal, String titulo, 
            String tabla, String colCodigo, String colDescripcion) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        this.setTitle(titulo);
        this.colDescripcion = colDescripcion;
        this.colCodigo = colCodigo;
        sql = "Select " + colCodigo + ", " + colDescripcion + " From " + tabla;
        setLocationRelativeTo(parent);
    }
    
      public BusquedaArticulos(java.awt.Dialog parent, boolean modal, String titulo, String tabla, 
             String colCodigo, String colDescripcion, String tipo) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        this.setTitle(titulo);
        this.colDescripcion = colDescripcion;
        this.colCodigo = colCodigo;
        codTipo = tipo;
        sql = "Select " + colCodigo + ", " + colDescripcion + " From " + tabla;
        setLocationRelativeTo(parent);
    }
    
    private final String sql;
    private String sqlComp;
    private final String colDescripcion;
    private final String colCodigo;
    private Session st;
    private DefaultTableModel model;
    private String codigoRetorno;
    private String descripcionRetorno;
    private int filaSeleccionada;
    
    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque(){
        //Habilito el campo de busqueda y solicito el foco.
        this.txtCriterio.setEnabled(true);
        this.txtCriterio.requestFocus();
        
        //Seteo el estado de los botones y marco el radio button Descripción como predeterminado.
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(true);
        this.rdoDesc.setSelected(true);

        //Seteo el jtable
        modeloTabla();
        this.tablaResultados.setEnabled(true);   
    }

    private void modeloTabla(){
        this.tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(120);       // código
        this.tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(450);      // descripción
        model = (DefaultTableModel) this.tablaResultados.getModel();
        model.setNumRows(0);   
    }    
    
    public String getCodigo() {
        return this.codigoRetorno;
    }
    
    public String getDescripcion() {
        return this.descripcionRetorno;
    }
    
    private void buscar() {
        model.setRowCount(0);
        cargarTabla();
    }

    private void cargarTabla() {
        // Si el campo contiene texto procedo a buscar
        if (!this.txtCriterio.getText().isEmpty()) {

            switch (codTipo) {
                case "venta":
                    // Armo el query teniendo en cuenta el criterio seleccionado.
                    // Uso Upper para que no sea CaseSensitive.
                    if (this.rdoDesc.isSelected()) {
                        sqlComp = sql + " Where Upper(" + colDescripcion + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " and es_materia_prima in('P','E')"
                                + " Order by " + colDescripcion;
                    } else {
                        sqlComp = sql + " Where Upper(" + colCodigo + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " and es_materia_prima in('P','E')"
                                + " Order by " + colCodigo;
                    }
                    break;
                    case "receta":
                    // Armo el query teniendo en cuenta el criterio seleccionado. 
                    //Uso Upper para que no sea CaseSensitive.
                    if (this.rdoDesc.isSelected()) {
                        sqlComp = sql + " Where Upper(" + colDescripcion + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " and es_materia_prima = 'M'"
                                + " Order by " + colDescripcion;
                    } else {
                        sqlComp = sql + " Where Upper(" + colCodigo + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " and es_materia_prima = 'M'"
                                + " Order by " + colCodigo;
                    }
                    break;
                default:
                    // Armo el query teniendo en cuenta el criterio seleccionado. 
                    // Uso Upper para que no sea CaseSensitive.
                    if (this.rdoDesc.isSelected()) {
                        sqlComp = sql + " Where Upper(" + colDescripcion + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " Order by " + colDescripcion;
                    } else {
                        sqlComp = sql + " Where Upper(" + colCodigo + ") Like '%"
                                + this.txtCriterio.getText().toUpperCase() + "%'"
                                + " Order by " + colCodigo;
                    }
                    break;
            }

            try {
                st.beginTransaction();
                List<Object[]> retorno;

                //Ejecuto la consulta y el array resultante asigno a mi variable "retorno"
                SQLQuery consulta = st.createSQLQuery(sqlComp);
                retorno = consulta.list();
                for (Object[] fila : retorno) {
                    model.addRow(fila);
                }

                // Pregunto la longitud de mi array "retorno", si es mayor a cero (obtuve resultado)
                // indico que debe seleccionar la primera fila, habilito el boton Aceptar
                if (retorno.size() > 0) {
                    this.tablaResultados.setRowSelectionInterval(0, 0);
                    this.btnAceptar.setEnabled(true);
                } else {
                    this.btnAceptar.setEnabled(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al ejecutar la busqueda. " + "\n"
                        + e.getMessage() + "\n" + e.getCause(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.btnAceptar.setEnabled(false);
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

        grupoModo = new javax.swing.ButtonGroup();
        panelResultados = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        panelCriterio = new javax.swing.JPanel();
        txtCriterio = new javax.swing.JTextField();
        panelModo = new javax.swing.JPanel();
        rdoCod = new javax.swing.JRadioButton();
        rdoDesc = new javax.swing.JRadioButton();
        panelBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResultados.getTableHeader().setReorderingAllowed(false);
        tablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaResultadosMouseClicked(evt);
            }
        });
        panelResultados.setViewportView(tablaResultados);
        tablaResultados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelCriterio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelCriterioLayout = new javax.swing.GroupLayout(panelCriterio);
        panelCriterio.setLayout(panelCriterioLayout);
        panelCriterioLayout.setHorizontalGroup(
            panelCriterioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriterioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCriterio)
                .addContainerGap())
        );
        panelCriterioLayout.setVerticalGroup(
            panelCriterioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCriterioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelModo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        grupoModo.add(rdoCod);
        rdoCod.setSelected(true);
        rdoCod.setText("Buscar por codigo");
        rdoCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCodActionPerformed(evt);
            }
        });

        grupoModo.add(rdoDesc);
        rdoDesc.setText("Buscar por descripcion");
        rdoDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModoLayout = new javax.swing.GroupLayout(panelModo);
        panelModo.setLayout(panelModoLayout);
        panelModoLayout.setHorizontalGroup(
            panelModoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoCod)
                .addGap(101, 101, 101))
            .addGroup(panelModoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoDesc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelModoLayout.setVerticalGroup(
            panelModoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoCod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoDesc)
                .addContainerGap())
        );

        panelBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadosMouseClicked
        // Cargo la fila seleccionada en la variable.
        this.filaSeleccionada = this.tablaResultados.getSelectedRow();
    }//GEN-LAST:event_tablaResultadosMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Si hago click en el boton Aceptar entonces cargo las variables con los valores de la fila seleccionada, 
        // si no seleccione ninguna, por defecto la fila seleccionada es la primera.
        this.codigoRetorno = model.getValueAt(filaSeleccionada, 0).toString();
        this.descripcionRetorno = model.getValueAt(filaSeleccionada, 1).toString();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Si hago click en Cancelar entonces cargo valores nulos en las variables que voy a retornar.
        this.codigoRetorno = null;
        this.descripcionRetorno = null;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        // Este metodo sirve para realizar la busqueda a medida que vamos escribiendo.
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.btnAceptar.isEnabled()) {
                this.btnAceptarActionPerformed(null);
            }
        } 
            else {
            buscar();
        }
    }//GEN-LAST:event_txtCriterioKeyReleased

    private void rdoCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCodActionPerformed
        // Cuando hago click en el radio button solicito el foco de nuevo en el campo de búsqueda txtCriterio
        // Luego, vuelvo a ejecutar la búsqueda.
        this.txtCriterio.requestFocus();
        buscar();
    }//GEN-LAST:event_rdoCodActionPerformed

    private void rdoDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDescActionPerformed
        // Cuando hago click en el radio button solicito el foco de nuevo en el campo de búsqueda txtCriterio
        // Luego, vuelvo a ejecutar la búsqueda.
        this.txtCriterio.requestFocus();
        buscar();
    }//GEN-LAST:event_rdoDescActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Busqueda dialog = new Busqueda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
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
