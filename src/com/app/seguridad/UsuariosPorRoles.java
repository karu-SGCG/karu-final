package com.app.seguridad;
import com.entidades.MtCargos;
import com.entidades.MtRolesUsuarios;
import com.entidades.MtRolesUsuariosId;
import com.entidades.MtUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

//@author Fausto Sanabria

public class UsuariosPorRoles extends javax.swing.JDialog {
    public UsuariosPorRoles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Usuarios por Roles - KARU v1.0");
        this.usuario = "karu";
        this.formulario = this.getClass().getSimpleName();        
    }
    
    public UsuariosPorRoles(String user) {
        initComponents();
        sessionHibernate();
        arranque();
        setLocationRelativeTo(null);
        this.setTitle("Mantenimiento de Usuarios por Roles - KARU v1.0");
        this.usuario = user;
        this.formulario = this.getClass().getSimpleName();
    }
    
    private Session st;
    private String accion;
    private DefaultTableModel model;
    private String usuario;
    private String formulario;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbActivo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox();
        cmbUsuario = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Roles");

        jLabel3.setText("Usuarios");

        cmbActivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "N" }));

        jLabel5.setText("Activo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rol", "Usuario", "Activo"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo)
            .addComponent(btnAceptar)
            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancelar)
            .addComponent(btnInforme)
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        obtenerTabla();
    }//GEN-LAST:event_jTable1MouseClicked

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
        //JOptionPane.showMessageDialog(null, "Aqui va el informe");
    }//GEN-LAST:event_btnInformeActionPerformed

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
            java.util.logging.Logger.getLogger(UsuariosPorRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosPorRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosPorRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosPorRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuariosPorRoles dialog = new UsuariosPorRoles(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbActivo;
    private javax.swing.JComboBox cmbCargo;
    private javax.swing.JComboBox cmbUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }

    private void arranque(){
        //Setea a vacío la accióna relizar
        accion = "";
        
        //Setea el estado de los componentes editables (textbox, combobox, etc)
        this.cmbCargo.setSelectedIndex(-1);
        this.cmbCargo.setEnabled(false);
        this.cmbUsuario.setSelectedIndex(-1);
        this.cmbUsuario.setEnabled(false);
        this.cmbActivo.setSelectedIndex(-1);
        this.cmbActivo.setEnabled(false);
        
        //Setea el estado de los botones y de la tabla
        this.btnNuevo.setEnabled(true);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(true);
        this.btnAceptar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
        this.jTable1.setEnabled(true);

        //Carga los estados iniciales y los datos guardados
        defaultTableModel();
        cargarTabla();
        cargarComboCargos();
        cargarComboUsuarios();
        this.cmbCargo.setSelectedIndex(-1);
        this.cmbUsuario.setSelectedIndex(-1);
    }
    
    public void defaultTableModel(){
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(45);
        model = (DefaultTableModel) this.jTable1.getModel();
        model.setNumRows(0);    
    }
    
    public void cargarTabla(){
        st.beginTransaction();
        List<MtRolesUsuarios> lista;
        lista = (List<MtRolesUsuarios>)st.createQuery("From MtRolesUsuarios").list();
        for (MtRolesUsuarios laLista : lista) {
            model.addRow(new Object[]{
                retornoCargoPorCodigo(laLista.getId().getCodCargo()).getNomCargo(),
                retornoUsuarioPorCodigo(laLista.getId().getCodUsuario()).getNomUsuario(),
                laLista.getEsActivo()
            });
        }
    }
    
    public void cargarComboCargos(){
        this.cmbCargo.removeAllItems();
        List<MtCargos> lista = (List<MtCargos>)st.createQuery("From MtCargos").list();
        for(MtCargos cargoList : lista){
            this.cmbCargo.addItem(cargoList.getNomCargo());            
        }
    }
    
    public void cargarComboUsuarios(){
        this.cmbUsuario.removeAllItems();
        List<MtUsuarios> lista = (List<MtUsuarios>)st.createQuery("From MtUsuarios").list();
        for(MtUsuarios usuarioList : lista){
            this.cmbUsuario.addItem( usuarioList.getNomUsuario() );            
        }
    }
    
    public void nuevo(){
        //Setea que acción vamos a realizar
        accion = "Nuevo";
        
        //Setea el estado de los componentes editables (textbox, combobox, etc)
        this.cmbCargo.setSelectedIndex(-1);
        this.cmbCargo.setEnabled(true);
        this.cmbUsuario.setSelectedIndex(-1);
        this.cmbUsuario.setEnabled(true);
        this.cmbActivo.setSelectedIndex(-1);
        this.cmbActivo.setEnabled(true);
        
        //Setea el estado de los botones y de la tabla
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        
        //Carga los estados y pone el foco
        this.cmbCargo.grabFocus();
    }
    
    public void editar(){
        //Setea que acción vamos a realizar
        accion = "Editar";
        
        //Setea el estado de los componentes editables (textbox, combobox, etc)
        this.cmbActivo.setEnabled(true);
        
        //Setea el estado de los botones y de la tabla
        this.btnNuevo.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnEliminar.setEnabled(false);
        this.btnInforme.setEnabled(false);
        this.btnAceptar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.jTable1.setEnabled(false);
        
        //Carga los estados y pone el foco
        this.cmbActivo.grabFocus();
    }
    
    public void eliminar(){
        int seleccion = JOptionPane.showConfirmDialog(null,"Desea eliminar el Registro.", 
        "Eliminación de Registro.", JOptionPane.YES_NO_OPTION);//Obtnemos la selección del usuario
        
        if(seleccion == 1){
            //Comparamos la selección del usuario igual a 1 no eliminamos, si es diferente se elimina.
            JOptionPane.showMessageDialog(null, "Registro no Eliminado...");
            arranque();
        }
        else{ 
            st.beginTransaction();
            Object codigoCargo = retornoCargoPorDescripcion((String) this.cmbCargo.getSelectedItem()).getCodCargo();
            Object codigoUsuario = retornoUsuarioPorDescripcion((String) this.cmbUsuario.getSelectedItem()).getCodUsuario();
           
            MtRolesUsuariosId id = new MtRolesUsuariosId();
            
            id.setCodCargo(Integer.parseInt(codigoCargo.toString()));
            id.setCodUsuario(codigoUsuario.toString());
            
            MtRolesUsuarios p = (MtRolesUsuarios) st.load(MtRolesUsuarios.class, id);
            st.delete(p);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro Eliminado...");
            arranque();
        }
    }
    
    private void cancelar(){
        switch(accion){
           case "Nuevo":
               int seleccion = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la operación?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (seleccion == 1){
                   this.cmbCargo.grabFocus();
               }
               else {
                   arranque();
               }
               break;
            case "Editar":
               int selec = JOptionPane.showConfirmDialog(null,
                       "¿Desea cancelar la edición?.", "Confirmacion", JOptionPane.YES_NO_OPTION);
               if (selec == 1){
                   this.cmbActivo.grabFocus();
               }
               else {
                   arranque();
               }
               break;
       }
    }

    public void guardar(){
        if( this.cmbCargo.getSelectedIndex() == -1 | this.cmbUsuario.getSelectedIndex() == -1
                | this.cmbActivo.getSelectedIndex() == -1 ){
            JOptionPane.showMessageDialog(null, "Imposible guardar campo vacio.");
        }
        else{
            st.beginTransaction();
            MtRolesUsuariosId id = new MtRolesUsuariosId();
            
            Object codigoCargo = retornoCargoPorDescripcion((String) this.cmbCargo.getSelectedItem()).getCodCargo();
            Object codigoUsuario = retornoUsuarioPorDescripcion((String) this.cmbUsuario.getSelectedItem()).getCodUsuario();
            
            id.setCodCargo((int) codigoCargo);
            id.setCodUsuario(codigoUsuario.toString());
            
            MtRolesUsuarios p = new MtRolesUsuarios();
            p.setId(id);
            p.setEsActivo(this.cmbActivo.getSelectedItem().toString().charAt(0));
            
            p.setAccionMod(accion);
            p.setUsuarioMod(usuario);
            Calendar cal = Calendar.getInstance();
            p.setFechaMod(cal.getTime() );
            
            try {
            st.save(p);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            arranque();
            }
            catch(org.hibernate.NonUniqueObjectException e){
                JOptionPane.showMessageDialog(null, "El registro ya existe en la base de datos. " + "\n" +
                            "Clave primaria duplicada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void guardarEd(){
        if(this.cmbActivo.getSelectedIndex() == -1 ){
            JOptionPane.showMessageDialog(null, "Imposible guardar campo vacio.");
        }
        else{
            st.beginTransaction();
            int selectedRow = this.jTable1.getSelectedRow();
            Object elCargo = model.getValueAt(selectedRow, 0);
            Object elUsuario = model.getValueAt(selectedRow, 1);
            Object esActivo = model.getValueAt(selectedRow, 2);
            MtRolesUsuariosId id = new MtRolesUsuariosId();
            
            id.setCodCargo(Integer.parseInt(elCargo.toString()));
            id.setCodUsuario(elUsuario.toString());
            
            MtRolesUsuarios p = (MtRolesUsuarios) st.load(MtRolesUsuarios.class, id);
            p.setEsActivo(esActivo.toString().charAt(0));
            
            p.setAccionMod(accion);
            p.setUsuarioMod(usuario);
            Calendar cal = Calendar.getInstance();
            p.setFechaMod(cal.getTime() );
            st.update(p);
            st.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Registro actualizado.");
            arranque();
        }
    }
    
    public MtCargos retornoCargoPorDescripcion(String nomCargo){
        MtCargos tipRet = null;
        try {
            Query query = st.createQuery("From MtCargos c Where c.nomCargo = ?");
            query.setParameter(0, nomCargo);
            try {
                tipRet = (MtCargos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + nomCargo);
            }

        } catch (Exception e) {

        }
        return tipRet;
    }
    
        public MtUsuarios retornoUsuarioPorDescripcion(String nomCargo){
        MtUsuarios tipRet = null;
        try {
            Query query = st.createQuery("From MtUsuarios c Where c.nomUsuario = ?");
            query.setParameter(0, nomCargo);
            try {
                tipRet = (MtUsuarios)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más usuarios de tipo: " + nomCargo);
            }

        } catch (Exception e) {

        }
        return tipRet;
    }
        
    public MtCargos retornoCargoPorCodigo(Integer codCargo){
        MtCargos tipRet = null;
        try {
            Query query = st.createQuery("From MtCargos c Where c.codCargo = ?");
            query.setParameter(0, codCargo);
            try {
                tipRet = (MtCargos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + codCargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. ");
        }
        return tipRet;
    }
    
        public MtUsuarios retornoUsuarioPorCodigo(String codUsuario){
        MtUsuarios tipRet = null;
        try {
            Query query = st.createQuery("From MtUsuarios c Where c.codUsuario = ?");
            query.setParameter(0, codUsuario);
            try {
                tipRet = (MtUsuarios)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más cargos de tipo: " + codUsuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error. ");
        }
        return tipRet;
    }
    
    public void obtenerTabla(){
        int selectedRow = this.jTable1.getSelectedRow();//Obtenemos la fila seleccionada...
        Object elCargo = model.getValueAt(selectedRow, 0);
        Object elUsuario = model.getValueAt(selectedRow, 1);
        Object esActivo = model.getValueAt(selectedRow, 2);
        this.cmbCargo.setSelectedItem(elCargo.toString());
        this.cmbUsuario.setSelectedItem(elUsuario.toString());
        this.cmbActivo.setSelectedItem(esActivo.toString());
        
        this.btnEditar.setEnabled(true);//Activamos el botón editar...
        this.btnEliminar.setEnabled(true);//Activamos el botón eliminar...
    }
    
    private void informe() {
        try {
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karu", "karu", "karu");
            System.out.println("Conexion Establecida");
            
            JasperReport elReporte = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/UsuariosPorRolesQ.jasper"));
            JasperPrint imprimir = JasperFillManager.fillReport(elReporte, null, conexion);
            JasperViewer visor = new JasperViewer(imprimir, false);
            visor.setTitle("Listado de Usuarios por Rol.");
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