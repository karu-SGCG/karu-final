/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.mantenimiento.CuentasBancos;
import com.app.caja.AnularComprobante;
import com.app.caja.ArqueoCaja;
import com.app.caja.CobrarComprobante;
import com.app.caja.EmisionNotaCredito;
import com.app.caja.Facturacion;
import com.app.caja.HabilitarCaja;
import com.app.caja.PagoProveedores;
import com.app.caja.informes.ReportePagosProv;
import com.app.seguridad.Login;
import com.app.mantenimiento.Clientes;
import com.app.mantenimiento.Cargos;
import com.app.mantenimiento.Comprobantes;
import com.app.mantenimiento.Departamentos;
import com.app.mantenimiento.Formularios;
import com.app.seguridad.CambioContrasena;
import com.app.mantenimiento.Areas;
import com.app.mantenimiento.Articulos;
import com.app.mantenimiento.Bancos;
import com.app.mantenimiento.Cajas;
import com.app.mantenimiento.Ciudades;
import com.app.mantenimiento.CondicionPago;
import com.app.mantenimiento.Empleados;
import com.app.mantenimiento.FormaPago;
import com.app.mantenimiento.GestionCheques;
import com.app.mantenimiento.Monedas;
import com.app.mantenimiento.Paises;
import com.app.mantenimiento.Proveedores;
import com.app.mantenimiento.Sucursales;
import com.app.mantenimiento.TipoComprobantes;
import com.app.mantenimiento.TiposArticulos;
import com.app.mantenimiento.TiposClientes;
import com.app.mantenimiento.TiposImpuestos;
import com.app.mantenimiento.Usuarios;
import com.app.produccion.Ingredientes;
import com.app.produccion.Recetas;
import com.app.seguridad.AccesosGrupos;
import com.app.seguridad.UsuariosPorRoles;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;
import com.app.seguridad.Permisos;
import java.awt.Toolkit;

//JOptionPane.showMessageDialog(ventanaPadre, "mensaje de error", "título de la ventana", JOptionPane.ERROR_MESSAGE);
/**
 * @author Carlos Patiño
 */
public class Principal extends javax.swing.JFrame {

    private String usuario;
    private String contrasena;
    private String formulario;

    public Principal() {
        this.setVisible(true);
        initComponents();
        arranque();
        bloquearMenus();
        hibernateSession();
        this.mnu_AccesoDesconectar.setEnabled(false);
        formulario = this.getClass().getSimpleName();
        login();
    }

    private Session st;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jMenuBar2 = new javax.swing.JMenuBar();
        mnu_sistema = new javax.swing.JMenu();
        mnu_sistema_conectar = new javax.swing.JMenuItem();
        mnu_AccesoDesconectar = new javax.swing.JMenuItem();
        mnu_acceso_salir = new javax.swing.JMenuItem();
        mnu_mantenimiento = new javax.swing.JMenu();
        mnu_mt_caja = new javax.swing.JMenu();
        mnuMant_cajas_caja = new javax.swing.JMenuItem();
        mant_caja_comprobantes = new javax.swing.JMenuItem();
        mnu_mt_caja_tipoComprobantes = new javax.swing.JMenuItem();
        mnu_mt_compras = new javax.swing.JMenu();
        compras_articulos = new javax.swing.JMenuItem();
        mant_compras_proveedores = new javax.swing.JMenuItem();
        mant_compras_tipoArt = new javax.swing.JMenuItem();
        mant_financiero = new javax.swing.JMenu();
        mant_financiero_bancos = new javax.swing.JMenuItem();
        mant_financiero_cheques = new javax.swing.JMenuItem();
        mant_financiero_ctasBanco = new javax.swing.JMenuItem();
        mant_financiero_monedas = new javax.swing.JMenuItem();
        mnu_mt_Parametros = new javax.swing.JMenu();
        mnu_mtAreas = new javax.swing.JMenuItem();
        mnu_mtCargos = new javax.swing.JMenuItem();
        mant_param_ciudades = new javax.swing.JMenuItem();
        mnu_mantDeptos = new javax.swing.JMenuItem();
        mnu_mantFormularios = new javax.swing.JMenuItem();
        mant_param_paises = new javax.swing.JMenuItem();
        mant_param_sucursal = new javax.swing.JMenuItem();
        mnu_mt_seguridad = new javax.swing.JMenu();
        mnu_mant_seg_defSeg = new javax.swing.JMenu();
        mnu_mant_seg_defSeg_permGrupos = new javax.swing.JMenuItem();
        mnu_mant_seg_defSeg_usuRoles = new javax.swing.JMenuItem();
        mant_seg_usuarios = new javax.swing.JMenuItem();
        mnu_seguridad_cambioContrasena = new javax.swing.JMenuItem();
        mant_seg_empleados = new javax.swing.JMenuItem();
        mnu_mt_stock = new javax.swing.JMenu();
        mant_ventas = new javax.swing.JMenu();
        mnu_ventas_clientes = new javax.swing.JMenuItem();
        mant_venta_tipoDoc = new javax.swing.JMenuItem();
        mant_ventas_tiposCli = new javax.swing.JMenuItem();
        mnu_mt_ventas_FormasPago = new javax.swing.JMenuItem();
        mnu_mt_ventas_condPago = new javax.swing.JMenuItem();
        mant_ventas_impuestos = new javax.swing.JMenuItem();
        mnu_transacciones = new javax.swing.JMenu();
        mnu_tran_caja = new javax.swing.JMenu();
        mnu_tran_caja_facturacion = new javax.swing.JMenuItem();
        mnu_trans_caja_notaCredito = new javax.swing.JMenuItem();
        mnu_trans_caja_cobrarComp = new javax.swing.JMenuItem();
        mnu_caja_anularComprobante = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnu_trans_caja_habilitarCaja = new javax.swing.JMenuItem();
        mnu_trans_caja_pagoProveedores = new javax.swing.JMenuItem();
        mnu_tran_compras = new javax.swing.JMenu();
        mnu_trans_financiero = new javax.swing.JMenu();
        mnu_trans_caja_arqueo = new javax.swing.JMenuItem();
        mnu_trans_caja_movimValores = new javax.swing.JMenuItem();
        mnu_tran_produccion = new javax.swing.JMenu();
        mnu_trans_prod_ingredientes = new javax.swing.JMenuItem();
        mnu_trans_prod_recetas = new javax.swing.JMenuItem();
        mnu_tran_stock = new javax.swing.JMenu();
        mnu_tran_ventas = new javax.swing.JMenu();
        mnu_informes = new javax.swing.JMenu();
        mnu_informes_caja_pagosprov = new javax.swing.JMenu();
        mnu_informes_caja_pagosProv = new javax.swing.JMenuItem();
        mnu_ayuda = new javax.swing.JMenu();
        mnu_ayuda_contenido = new javax.swing.JMenuItem();
        mnu_ayuda_acercaDe = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar4.add(jMenu9);

        jMenuItem9.setText("jMenuItem9");

        jMenuItem4.setText("jMenuItem4");

        jMenu15.setText("File");
        jMenuBar5.add(jMenu15);

        jMenu16.setText("Edit");
        jMenuBar5.add(jMenu16);

        jMenu24.setText("jMenu24");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KARU - Sistema de Gestión Comercial Gastronómico  v1.0");
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("frm_principal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        mnu_sistema.setLabel("Sistema");

        mnu_sistema_conectar.setText("Conectar");
        mnu_sistema_conectar.setName("mnu_sistema_conectar"); // NOI18N
        mnu_sistema_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_sistema_conectarActionPerformed(evt);
            }
        });
        mnu_sistema.add(mnu_sistema_conectar);

        mnu_AccesoDesconectar.setText("Desconectar");
        mnu_AccesoDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_AccesoDesconectarActionPerformed(evt);
            }
        });
        mnu_sistema.add(mnu_AccesoDesconectar);

        mnu_acceso_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnu_acceso_salir.setText("Salir");
        mnu_acceso_salir.setToolTipText("Salir del sistema");
        mnu_acceso_salir.setName(""); // NOI18N
        mnu_acceso_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_acceso_salirActionPerformed(evt);
            }
        });
        mnu_sistema.add(mnu_acceso_salir);
        mnu_acceso_salir.getAccessibleContext().setAccessibleDescription("");

        jMenuBar2.add(mnu_sistema);

        mnu_mantenimiento.setText("Mantenimiento");

        mnu_mt_caja.setLabel("Caja");

        mnuMant_cajas_caja.setText("Cajas");
        mnuMant_cajas_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMant_cajas_cajaActionPerformed(evt);
            }
        });
        mnu_mt_caja.add(mnuMant_cajas_caja);

        mant_caja_comprobantes.setText("Comprobantes");
        mant_caja_comprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_caja_comprobantesActionPerformed(evt);
            }
        });
        mnu_mt_caja.add(mant_caja_comprobantes);

        mnu_mt_caja_tipoComprobantes.setText("Tipo de Comprobantes");
        mnu_mt_caja_tipoComprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mt_caja_tipoComprobantesActionPerformed(evt);
            }
        });
        mnu_mt_caja.add(mnu_mt_caja_tipoComprobantes);

        mnu_mantenimiento.add(mnu_mt_caja);

        mnu_mt_compras.setText("Compras");

        compras_articulos.setText("Articulos");
        compras_articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compras_articulosActionPerformed(evt);
            }
        });
        mnu_mt_compras.add(compras_articulos);

        mant_compras_proveedores.setText("Proveedores");
        mant_compras_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_compras_proveedoresActionPerformed(evt);
            }
        });
        mnu_mt_compras.add(mant_compras_proveedores);

        mant_compras_tipoArt.setText("Tipos Artículos");
        mant_compras_tipoArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_compras_tipoArtActionPerformed(evt);
            }
        });
        mnu_mt_compras.add(mant_compras_tipoArt);

        mnu_mantenimiento.add(mnu_mt_compras);

        mant_financiero.setText("Financiero");

        mant_financiero_bancos.setText("Bancos");
        mant_financiero_bancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_financiero_bancosActionPerformed(evt);
            }
        });
        mant_financiero.add(mant_financiero_bancos);

        mant_financiero_cheques.setText("Gestión Cheques");
        mant_financiero_cheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_financiero_chequesActionPerformed(evt);
            }
        });
        mant_financiero.add(mant_financiero_cheques);

        mant_financiero_ctasBanco.setText("Cuentas Bancarias");
        mant_financiero_ctasBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_financiero_ctasBancoActionPerformed(evt);
            }
        });
        mant_financiero.add(mant_financiero_ctasBanco);

        mant_financiero_monedas.setText("Monedas");
        mant_financiero_monedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_financiero_monedasActionPerformed(evt);
            }
        });
        mant_financiero.add(mant_financiero_monedas);

        mnu_mantenimiento.add(mant_financiero);

        mnu_mt_Parametros.setLabel("Parámetros");

        mnu_mtAreas.setText("Areas");
        mnu_mtAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mtAreasActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mnu_mtAreas);

        mnu_mtCargos.setText("Cargos");
        mnu_mtCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mtCargosActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mnu_mtCargos);

        mant_param_ciudades.setText("Ciudades");
        mant_param_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_param_ciudadesActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mant_param_ciudades);

        mnu_mantDeptos.setText("Departamentos");
        mnu_mantDeptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mantDeptosActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mnu_mantDeptos);

        mnu_mantFormularios.setText("Formularios");
        mnu_mantFormularios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mantFormulariosActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mnu_mantFormularios);

        mant_param_paises.setText("Países");
        mant_param_paises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_param_paisesActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mant_param_paises);

        mant_param_sucursal.setText("Sucursales");
        mant_param_sucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_param_sucursalActionPerformed(evt);
            }
        });
        mnu_mt_Parametros.add(mant_param_sucursal);

        mnu_mantenimiento.add(mnu_mt_Parametros);

        mnu_mt_seguridad.setText("Seguridad");

        mnu_mant_seg_defSeg.setText("Definiciones de Seguridad");

        mnu_mant_seg_defSeg_permGrupos.setText("Permisos por Grupos");
        mnu_mant_seg_defSeg_permGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mant_seg_defSeg_permGruposActionPerformed(evt);
            }
        });
        mnu_mant_seg_defSeg.add(mnu_mant_seg_defSeg_permGrupos);

        mnu_mant_seg_defSeg_usuRoles.setText("Usuarios por Roles");
        mnu_mant_seg_defSeg_usuRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mant_seg_defSeg_usuRolesActionPerformed(evt);
            }
        });
        mnu_mant_seg_defSeg.add(mnu_mant_seg_defSeg_usuRoles);

        mant_seg_usuarios.setText("Usuarios del Sistema");
        mant_seg_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_seg_usuariosActionPerformed(evt);
            }
        });
        mnu_mant_seg_defSeg.add(mant_seg_usuarios);

        mnu_mt_seguridad.add(mnu_mant_seg_defSeg);

        mnu_seguridad_cambioContrasena.setText("Cambiar contraseña");
        mnu_seguridad_cambioContrasena.setName("mnu_ seguridad_cambioContrasena"); // NOI18N
        mnu_seguridad_cambioContrasena.setOpaque(true);
        mnu_seguridad_cambioContrasena.setVerifyInputWhenFocusTarget(false);
        mnu_seguridad_cambioContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnu_seguridad_cambioContrasenaMouseClicked(evt);
            }
        });
        mnu_seguridad_cambioContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_seguridad_cambioContrasenaActionPerformed(evt);
            }
        });
        mnu_mt_seguridad.add(mnu_seguridad_cambioContrasena);

        mant_seg_empleados.setText("Empleados");
        mant_seg_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_seg_empleadosActionPerformed(evt);
            }
        });
        mnu_mt_seguridad.add(mant_seg_empleados);

        mnu_mantenimiento.add(mnu_mt_seguridad);
        mnu_mt_seguridad.getAccessibleContext().setAccessibleDescription("");

        mnu_mt_stock.setText("Stock");
        mnu_mantenimiento.add(mnu_mt_stock);

        mant_ventas.setText("Ventas");

        mnu_ventas_clientes.setText("Clientes");
        mnu_ventas_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_ventas_clientesActionPerformed(evt);
            }
        });
        mant_ventas.add(mnu_ventas_clientes);

        mant_venta_tipoDoc.setText("Tipos Documentos Clientes");
        mant_venta_tipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_venta_tipoDocActionPerformed(evt);
            }
        });
        mant_ventas.add(mant_venta_tipoDoc);

        mant_ventas_tiposCli.setText("Tipos Clientes");
        mant_ventas_tiposCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_ventas_tiposCliActionPerformed(evt);
            }
        });
        mant_ventas.add(mant_ventas_tiposCli);

        mnu_mt_ventas_FormasPago.setText("Formas de Pago");
        mnu_mt_ventas_FormasPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mt_ventas_FormasPagoActionPerformed(evt);
            }
        });
        mant_ventas.add(mnu_mt_ventas_FormasPago);

        mnu_mt_ventas_condPago.setText("Condiciones de Pago");
        mnu_mt_ventas_condPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_mt_ventas_condPagoActionPerformed(evt);
            }
        });
        mant_ventas.add(mnu_mt_ventas_condPago);

        mant_ventas_impuestos.setText("Tipos  Impuestos");
        mant_ventas_impuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mant_ventas_impuestosActionPerformed(evt);
            }
        });
        mant_ventas.add(mant_ventas_impuestos);

        mnu_mantenimiento.add(mant_ventas);

        jMenuBar2.add(mnu_mantenimiento);

        mnu_transacciones.setText("Transacciones");

        mnu_tran_caja.setText("Caja");

        mnu_tran_caja_facturacion.setText("Facturar");
        mnu_tran_caja_facturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_tran_caja_facturacionActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_tran_caja_facturacion);

        mnu_trans_caja_notaCredito.setText("Emitir Nota de Crédito");
        mnu_trans_caja_notaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_notaCreditoActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_trans_caja_notaCredito);

        mnu_trans_caja_cobrarComp.setText("Cobrar Comprobantes");
        mnu_trans_caja_cobrarComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_cobrarCompActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_trans_caja_cobrarComp);

        mnu_caja_anularComprobante.setText("Anular Comprobante");
        mnu_caja_anularComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_caja_anularComprobanteActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_caja_anularComprobante);
        mnu_tran_caja.add(jSeparator5);

        mnu_trans_caja_habilitarCaja.setText("Habilitar Caja");
        mnu_trans_caja_habilitarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_habilitarCajaActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_trans_caja_habilitarCaja);

        mnu_trans_caja_pagoProveedores.setText("Pago a Proveedores");
        mnu_trans_caja_pagoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_pagoProveedoresActionPerformed(evt);
            }
        });
        mnu_tran_caja.add(mnu_trans_caja_pagoProveedores);

        mnu_transacciones.add(mnu_tran_caja);

        mnu_tran_compras.setText("Compras");
        mnu_transacciones.add(mnu_tran_compras);

        mnu_trans_financiero.setText("Financiero");

        mnu_trans_caja_arqueo.setText("Arqueo de Caja");
        mnu_trans_caja_arqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_arqueoActionPerformed(evt);
            }
        });
        mnu_trans_financiero.add(mnu_trans_caja_arqueo);

        mnu_trans_caja_movimValores.setText("Movimiento de Valores");
        mnu_trans_caja_movimValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_caja_movimValoresActionPerformed(evt);
            }
        });
        mnu_trans_financiero.add(mnu_trans_caja_movimValores);

        mnu_transacciones.add(mnu_trans_financiero);

        mnu_tran_produccion.setText("Producción");

        mnu_trans_prod_ingredientes.setText("Ingredientes");
        mnu_trans_prod_ingredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_prod_ingredientesActionPerformed(evt);
            }
        });
        mnu_tran_produccion.add(mnu_trans_prod_ingredientes);

        mnu_trans_prod_recetas.setText("Recetas");
        mnu_trans_prod_recetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_trans_prod_recetasActionPerformed(evt);
            }
        });
        mnu_tran_produccion.add(mnu_trans_prod_recetas);

        mnu_transacciones.add(mnu_tran_produccion);

        mnu_tran_stock.setText("Stock");
        mnu_transacciones.add(mnu_tran_stock);

        mnu_tran_ventas.setText("Ventas");
        mnu_transacciones.add(mnu_tran_ventas);

        jMenuBar2.add(mnu_transacciones);

        mnu_informes.setText("Informes");

        mnu_informes_caja_pagosprov.setText("Caja");

        mnu_informes_caja_pagosProv.setText("Resumen Pagos a Proveedores");
        mnu_informes_caja_pagosProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_informes_caja_pagosProvActionPerformed(evt);
            }
        });
        mnu_informes_caja_pagosprov.add(mnu_informes_caja_pagosProv);

        mnu_informes.add(mnu_informes_caja_pagosprov);

        jMenuBar2.add(mnu_informes);

        mnu_ayuda.setText("Ayuda");

        mnu_ayuda_contenido.setText("Ayuda Contenidos");
        mnu_ayuda.add(mnu_ayuda_contenido);

        mnu_ayuda_acercaDe.setText("Acerca de...");
        mnu_ayuda_acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_ayuda_acercaDeActionPerformed(evt);
            }
        });
        mnu_ayuda.add(mnu_ayuda_acercaDe);

        jMenuBar2.add(mnu_ayuda);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(706, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_sistema_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_sistema_conectarActionPerformed
        login();
    }//GEN-LAST:event_mnu_sistema_conectarActionPerformed

    private void mnu_AccesoDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_AccesoDesconectarActionPerformed
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Desea finalizar la sesión?",
                "Acceso al Sistema.", JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == 0) {
            bloquearMenus();
            this.mnu_AccesoDesconectar.setEnabled(false);
            this.mnu_sistema_conectar.setEnabled(true);
        }
    }//GEN-LAST:event_mnu_AccesoDesconectarActionPerformed

    private void mnu_acceso_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_acceso_salirActionPerformed
        // TODO add your handling code here:
        int seleccion = JOptionPane.showOptionDialog(
                null, "Esta seguro de salir del sistema?", "Karu SGCG v.1",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"Salir", "Cancelar"}, "Salir");

        if (seleccion == 0) {
            System.exit(0);
        } else {
            this.setVisible(false);
        }

    }//GEN-LAST:event_mnu_acceso_salirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void mnu_ayuda_acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_ayuda_acercaDeActionPerformed
        // TODO add your handling code here:
        AcercaDe form = new AcercaDe(this, true);
        //Indicamos que se muestren las opciones "minimizar", "maximizar" y "cerrar"
        form.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //La hacemos visible.
        form.setVisible(true);
    }//GEN-LAST:event_mnu_ayuda_acercaDeActionPerformed

    private void mnu_seguridad_cambioContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_seguridad_cambioContrasenaActionPerformed
        CambioContrasena form = new CambioContrasena(usuario, contrasena);
        form.setDefaultCloseOperation(HIDE_ON_CLOSE);
        form.setVisible(true);
    }//GEN-LAST:event_mnu_seguridad_cambioContrasenaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void mnu_seguridad_cambioContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnu_seguridad_cambioContrasenaMouseClicked
        CambioContrasena form = new CambioContrasena(usuario, contrasena);
        form.setDefaultCloseOperation(HIDE_ON_CLOSE);
        form.setVisible(true);
    }//GEN-LAST:event_mnu_seguridad_cambioContrasenaMouseClicked

    private void mnu_mantFormulariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mantFormulariosActionPerformed
        // TODO add your handling code here:
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Formularios");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Formularios form1 = new Formularios(usuario);
            form1.setDefaultCloseOperation(HIDE_ON_CLOSE);
            form1.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mantFormulariosActionPerformed

    private void mnu_mantDeptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mantDeptosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Departamentos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Departamentos deptos = new Departamentos(usuario);
            deptos.setDefaultCloseOperation(HIDE_ON_CLOSE);
            deptos.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mantDeptosActionPerformed

    private void mnu_mtCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mtCargosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Cargos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Cargos cargo = new Cargos(usuario);
            cargo.setDefaultCloseOperation(HIDE_ON_CLOSE);
            cargo.setTitle("Mantenimiento de Cargos - KARU v1.0");
            cargo.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mtCargosActionPerformed

    private void mant_financiero_bancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_financiero_bancosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Bancos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Bancos banco = new Bancos(usuario);
            banco.setDefaultCloseOperation(HIDE_ON_CLOSE);
            banco.setVisible(true);
        }
    }//GEN-LAST:event_mant_financiero_bancosActionPerformed

    private void mnu_mtAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mtAreasActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Areas");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Areas area = new Areas(usuario);
            area.setDefaultCloseOperation(HIDE_ON_CLOSE);
            area.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mtAreasActionPerformed

    private void mant_caja_comprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_caja_comprobantesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Comprobantes");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Comprobantes comp = new Comprobantes(usuario);
            comp.setDefaultCloseOperation(HIDE_ON_CLOSE);
            comp.setVisible(true);
        }
    }//GEN-LAST:event_mant_caja_comprobantesActionPerformed

    private void mnu_ventas_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_ventas_clientesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Clientes");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Clientes cli = new Clientes(usuario);
            cli.setDefaultCloseOperation(HIDE_ON_CLOSE);
            cli.setVisible(true);
        }
    }//GEN-LAST:event_mnu_ventas_clientesActionPerformed

    private void compras_articulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compras_articulosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Articulos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Articulos articulos = new Articulos(usuario);
            articulos.setDefaultCloseOperation(HIDE_ON_CLOSE);
            articulos.setTitle("Mantenimiento de Artículos - KARU v1.0");
            articulos.setVisible(true);
        }
    }//GEN-LAST:event_compras_articulosActionPerformed

    private void mnuMant_cajas_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMant_cajas_cajaActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Cajas");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Cajas caja = new Cajas(usuario);
            caja.setDefaultCloseOperation(HIDE_ON_CLOSE);
            caja.setTitle("Mantenimiento de Cajas - KARU v1.0");
            caja.setVisible(true);
        }
    }//GEN-LAST:event_mnuMant_cajas_cajaActionPerformed

    private void mant_param_ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_param_ciudadesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Ciudades");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Ciudades ciudad = new Ciudades(usuario);
            ciudad.setDefaultCloseOperation(HIDE_ON_CLOSE);
            ciudad.setTitle("Mantenimiento de Ciudades - KARU v1.0");
            ciudad.setVisible(true);
        }
    }//GEN-LAST:event_mant_param_ciudadesActionPerformed

    private void mant_financiero_ctasBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_financiero_ctasBancoActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "CuentasBancos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CuentasBancos cuenta = new CuentasBancos(usuario);
            cuenta.setDefaultCloseOperation(HIDE_ON_CLOSE);
            cuenta.setTitle("Mantenimiento de Cuentas Bancarias - KARU v1.0");
            cuenta.setVisible(true);
        }
    }//GEN-LAST:event_mant_financiero_ctasBancoActionPerformed

    private void mant_seg_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_seg_empleadosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Empleados");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Empleados empleado = new Empleados(usuario);
            empleado.setDefaultCloseOperation(HIDE_ON_CLOSE);
            empleado.setTitle("Mantenimiento de Empleados - KARU v1.0");
            empleado.setVisible(true);
        }
    }//GEN-LAST:event_mant_seg_empleadosActionPerformed

    private void mant_financiero_chequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_financiero_chequesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "GestionCheques");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            GestionCheques cheque = new GestionCheques(usuario);
            cheque.setDefaultCloseOperation(HIDE_ON_CLOSE);
            cheque.setTitle("Mantenimiento de Cheques - KARU v1.0");
            cheque.setVisible(true);
        }
    }//GEN-LAST:event_mant_financiero_chequesActionPerformed

    private void mant_financiero_monedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_financiero_monedasActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Monedas");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Monedas moneda = new Monedas(usuario);
            moneda.setDefaultCloseOperation(HIDE_ON_CLOSE);
            moneda.setTitle("Mantenimiento de Monedas - KARU v1.0");
            moneda.setVisible(true);
        }
    }//GEN-LAST:event_mant_financiero_monedasActionPerformed

    private void mant_param_paisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_param_paisesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Paises");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Paises pais = new Paises(usuario);
            pais.setDefaultCloseOperation(HIDE_ON_CLOSE);
            pais.setTitle("Mantenimiento de Países - KARU v1.0");
            pais.setVisible(true);
        }
    }//GEN-LAST:event_mant_param_paisesActionPerformed

    private void mant_compras_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_compras_proveedoresActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Proveedores");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Proveedores proveedor = new Proveedores(usuario);
            proveedor.setDefaultCloseOperation(HIDE_ON_CLOSE);
            proveedor.setTitle("Mantenimiento de Proveedores - KARU v1.0");
            proveedor.setVisible(true);
        }
    }//GEN-LAST:event_mant_compras_proveedoresActionPerformed

    private void mant_param_sucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_param_sucursalActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Sucursales");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Sucursales sucursal = new Sucursales(usuario);
            sucursal.setDefaultCloseOperation(HIDE_ON_CLOSE);
            sucursal.setTitle("Mantenimiento de Sucursales - KARU v1.0");
            sucursal.setVisible(true);
        }
    }//GEN-LAST:event_mant_param_sucursalActionPerformed

    private void mant_venta_tipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_venta_tipoDocActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "TipoDocumentos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TipoDocumentos tipoDoc = new TipoDocumentos(usuario);
            tipoDoc.setDefaultCloseOperation(HIDE_ON_CLOSE);
            tipoDoc.setTitle("Mantenimiento de Tipos de Documentos - KARU v1.0");
            tipoDoc.setVisible(true);
        }
    }//GEN-LAST:event_mant_venta_tipoDocActionPerformed

    private void mant_compras_tipoArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_compras_tipoArtActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "TiposArticulos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TiposArticulos tipoArt = new TiposArticulos(usuario);
            tipoArt.setDefaultCloseOperation(HIDE_ON_CLOSE);
            tipoArt.setTitle("Mantenimiento de Tipos de Artículos - KARU v1.0");
            tipoArt.setVisible(true);
        }
    }//GEN-LAST:event_mant_compras_tipoArtActionPerformed

    private void mant_ventas_tiposCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_ventas_tiposCliActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "TiposClientes");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TiposClientes tipoCli = new TiposClientes(usuario);
            tipoCli.setDefaultCloseOperation(HIDE_ON_CLOSE);
            tipoCli.setTitle("Mantenimiento de Tipos de Clientes - KARU v1.0");
            tipoCli.setVisible(true);
        }
    }//GEN-LAST:event_mant_ventas_tiposCliActionPerformed

    private void mant_ventas_impuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_ventas_impuestosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "TiposImpuestos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TiposImpuestos imp = new TiposImpuestos(usuario);
            imp.setDefaultCloseOperation(HIDE_ON_CLOSE);
            imp.setTitle("Mantenimiento de Impuestos - KARU v1.0");
            imp.setVisible(true);
        }
    }//GEN-LAST:event_mant_ventas_impuestosActionPerformed

    private void mant_seg_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mant_seg_usuariosActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "Usuarios");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Usuarios usuarios = new Usuarios(usuario);
            usuarios.setDefaultCloseOperation(HIDE_ON_CLOSE);
            usuarios.setTitle("Mantenimiento de Usuarios - KARU v1.0");
            usuarios.setVisible(true);
        }
    }//GEN-LAST:event_mant_seg_usuariosActionPerformed

    private void mnu_tran_caja_facturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_tran_caja_facturacionActionPerformed
        Facturacion fac = new Facturacion(usuario);
        fac.setDefaultCloseOperation(HIDE_ON_CLOSE);
        fac.setVisible(true);
    }//GEN-LAST:event_mnu_tran_caja_facturacionActionPerformed

    private void mnu_mant_seg_defSeg_usuRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mant_seg_defSeg_usuRolesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "UsuariosPorRoles");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            UsuariosPorRoles usuRol = new UsuariosPorRoles(usuario);
            usuRol.setDefaultCloseOperation(HIDE_ON_CLOSE);
            usuRol.setTitle("Mantenimiento de Usuarios Roles - KARU v1.0");
            usuRol.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mant_seg_defSeg_usuRolesActionPerformed

    private void mnu_mant_seg_defSeg_permGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mant_seg_defSeg_permGruposActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "AccesosGrupos");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            AccesosGrupos accRol = new AccesosGrupos(usuario);
            accRol.setDefaultCloseOperation(HIDE_ON_CLOSE);
            accRol.setTitle("Mantenimiento de Permiso Grupo - KARU v1.0");
            accRol.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mant_seg_defSeg_permGruposActionPerformed

    private void mnu_mt_caja_tipoComprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mt_caja_tipoComprobantesActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "TipoComprobantes");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            TipoComprobantes comp = new TipoComprobantes(usuario);
            comp.setDefaultCloseOperation(HIDE_ON_CLOSE);
            comp.setTitle("Mantenimiento Tipo de Comprobantes - KARU v1.0");
            comp.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mt_caja_tipoComprobantesActionPerformed

    private void mnu_mt_ventas_FormasPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mt_ventas_FormasPagoActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "FormaPago");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            FormaPago form = new FormaPago(usuario);
            form.setDefaultCloseOperation(HIDE_ON_CLOSE);
            form.setTitle("Mantenimiento Formas de Pago - KARU v1.0");
            form.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mt_ventas_FormasPagoActionPerformed

    private void mnu_mt_ventas_condPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_mt_ventas_condPagoActionPerformed
        Permisos per = new Permisos();
        Boolean ejecutar = per.PuedeEjecutar(usuario, "CondicionPago");
        if (!ejecutar) {
            JOptionPane.showMessageDialog(null, "El usuario " + usuario + " no tiene permiso para acceder"
                    + " al formulario " + formulario, "Permisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CondicionPago cond = new CondicionPago(usuario);
            cond.setDefaultCloseOperation(HIDE_ON_CLOSE);
            cond.setTitle("Mantenimiento Condiciones de Pago - KARU v1.0");
            cond.setVisible(true);
        }
    }//GEN-LAST:event_mnu_mt_ventas_condPagoActionPerformed

    private void mnu_trans_caja_notaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_notaCreditoActionPerformed
        EmisionNotaCredito nc = new EmisionNotaCredito(usuario);
        nc.setDefaultCloseOperation(HIDE_ON_CLOSE);
        nc.setVisible(true);
    }//GEN-LAST:event_mnu_trans_caja_notaCreditoActionPerformed

    private void mnu_caja_anularComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_caja_anularComprobanteActionPerformed
        AnularComprobante anu = new AnularComprobante(usuario);
        anu.setDefaultCloseOperation(HIDE_ON_CLOSE);
        anu.setVisible(true);
    }//GEN-LAST:event_mnu_caja_anularComprobanteActionPerformed

    private void mnu_trans_caja_cobrarCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_cobrarCompActionPerformed
        CobrarComprobante anu = new CobrarComprobante(usuario);
        anu.setDefaultCloseOperation(HIDE_ON_CLOSE);
        anu.setVisible(true);
    }//GEN-LAST:event_mnu_trans_caja_cobrarCompActionPerformed

    private void mnu_trans_caja_movimValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_movimValoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnu_trans_caja_movimValoresActionPerformed

    private void mnu_trans_caja_pagoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_pagoProveedoresActionPerformed
        PagoProveedores pago = new PagoProveedores(usuario);
        pago.setDefaultCloseOperation(HIDE_ON_CLOSE);
        pago.setVisible(true);
    }//GEN-LAST:event_mnu_trans_caja_pagoProveedoresActionPerformed

    private void mnu_trans_caja_arqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_arqueoActionPerformed
        ArqueoCaja arq = new ArqueoCaja(usuario);
        arq.setDefaultCloseOperation(HIDE_ON_CLOSE);
        arq.setVisible(true);
    }//GEN-LAST:event_mnu_trans_caja_arqueoActionPerformed

    private void mnu_informes_caja_pagosProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_informes_caja_pagosProvActionPerformed
        ReportePagosProv pago = new ReportePagosProv(this, true);
        pago.setDefaultCloseOperation(HIDE_ON_CLOSE);
        pago.setVisible(true);
    }//GEN-LAST:event_mnu_informes_caja_pagosProvActionPerformed

    private void mnu_trans_prod_recetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_prod_recetasActionPerformed
        Recetas receta = new Recetas(usuario);
        receta.setDefaultCloseOperation(HIDE_ON_CLOSE);
        receta.setVisible(true);
    }//GEN-LAST:event_mnu_trans_prod_recetasActionPerformed

    private void mnu_trans_prod_ingredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_prod_ingredientesActionPerformed
        Ingredientes ing = new Ingredientes(usuario);
        ing.setDefaultCloseOperation(HIDE_ON_CLOSE);
        ing.setVisible(true);
    }//GEN-LAST:event_mnu_trans_prod_ingredientesActionPerformed

    private void mnu_trans_caja_habilitarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_trans_caja_habilitarCajaActionPerformed
        HabilitarCaja hab = new HabilitarCaja(usuario);
        hab.setDefaultCloseOperation(HIDE_ON_CLOSE);
        hab.setVisible(true);
    }//GEN-LAST:event_mnu_trans_caja_habilitarCajaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem compras_articulos;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem mant_caja_comprobantes;
    private javax.swing.JMenuItem mant_compras_proveedores;
    private javax.swing.JMenuItem mant_compras_tipoArt;
    private javax.swing.JMenu mant_financiero;
    private javax.swing.JMenuItem mant_financiero_bancos;
    private javax.swing.JMenuItem mant_financiero_cheques;
    private javax.swing.JMenuItem mant_financiero_ctasBanco;
    private javax.swing.JMenuItem mant_financiero_monedas;
    private javax.swing.JMenuItem mant_param_ciudades;
    private javax.swing.JMenuItem mant_param_paises;
    private javax.swing.JMenuItem mant_param_sucursal;
    private javax.swing.JMenuItem mant_seg_empleados;
    private javax.swing.JMenuItem mant_seg_usuarios;
    private javax.swing.JMenuItem mant_venta_tipoDoc;
    private javax.swing.JMenu mant_ventas;
    private javax.swing.JMenuItem mant_ventas_impuestos;
    private javax.swing.JMenuItem mant_ventas_tiposCli;
    private javax.swing.JMenuItem mnuMant_cajas_caja;
    private javax.swing.JMenuItem mnu_AccesoDesconectar;
    private javax.swing.JMenuItem mnu_acceso_salir;
    private javax.swing.JMenu mnu_ayuda;
    private javax.swing.JMenuItem mnu_ayuda_acercaDe;
    private javax.swing.JMenuItem mnu_ayuda_contenido;
    private javax.swing.JMenuItem mnu_caja_anularComprobante;
    private javax.swing.JMenu mnu_informes;
    private javax.swing.JMenuItem mnu_informes_caja_pagosProv;
    private javax.swing.JMenu mnu_informes_caja_pagosprov;
    private javax.swing.JMenuItem mnu_mantDeptos;
    private javax.swing.JMenuItem mnu_mantFormularios;
    private javax.swing.JMenu mnu_mant_seg_defSeg;
    private javax.swing.JMenuItem mnu_mant_seg_defSeg_permGrupos;
    private javax.swing.JMenuItem mnu_mant_seg_defSeg_usuRoles;
    private javax.swing.JMenu mnu_mantenimiento;
    private javax.swing.JMenuItem mnu_mtAreas;
    private javax.swing.JMenuItem mnu_mtCargos;
    private javax.swing.JMenu mnu_mt_Parametros;
    private javax.swing.JMenu mnu_mt_caja;
    private javax.swing.JMenuItem mnu_mt_caja_tipoComprobantes;
    private javax.swing.JMenu mnu_mt_compras;
    private javax.swing.JMenu mnu_mt_seguridad;
    private javax.swing.JMenu mnu_mt_stock;
    private javax.swing.JMenuItem mnu_mt_ventas_FormasPago;
    private javax.swing.JMenuItem mnu_mt_ventas_condPago;
    private javax.swing.JMenuItem mnu_seguridad_cambioContrasena;
    private javax.swing.JMenu mnu_sistema;
    private javax.swing.JMenuItem mnu_sistema_conectar;
    private javax.swing.JMenu mnu_tran_caja;
    private javax.swing.JMenuItem mnu_tran_caja_facturacion;
    private javax.swing.JMenu mnu_tran_compras;
    private javax.swing.JMenu mnu_tran_produccion;
    private javax.swing.JMenu mnu_tran_stock;
    private javax.swing.JMenu mnu_tran_ventas;
    private javax.swing.JMenuItem mnu_trans_caja_arqueo;
    private javax.swing.JMenuItem mnu_trans_caja_cobrarComp;
    private javax.swing.JMenuItem mnu_trans_caja_habilitarCaja;
    private javax.swing.JMenuItem mnu_trans_caja_movimValores;
    private javax.swing.JMenuItem mnu_trans_caja_notaCredito;
    private javax.swing.JMenuItem mnu_trans_caja_pagoProveedores;
    private javax.swing.JMenu mnu_trans_financiero;
    private javax.swing.JMenuItem mnu_trans_prod_ingredientes;
    private javax.swing.JMenuItem mnu_trans_prod_recetas;
    private javax.swing.JMenu mnu_transacciones;
    private javax.swing.JMenuItem mnu_ventas_clientes;
    // End of variables declaration//GEN-END:variables

    public void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void arranque() {
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/imagenes/karu_ico.png")));
        }catch(Exception e){
        }
    }

    //bloquea todas las opciones antes de loguearse.
    public void bloquearMenus() {
        this.mnu_mantenimiento.setEnabled(false);
        this.mnu_transacciones.setEnabled(false);
        this.mnu_informes.setEnabled(false);
    }

    public void habilitarMenus() {
        this.mnu_mantenimiento.setEnabled(true);
        this.mnu_transacciones.setEnabled(true);
        this.mnu_informes.setEnabled(true);
    }

    public void login() {
        Login login = new Login(this, true);
        login.setDefaultCloseOperation(HIDE_ON_CLOSE);
        login.setResizable(false);
        this.setVisible(false);
        login.setVisible(true);
        this.setVisible(true);

        this.setUsuario(login.getUsuario());
        this.setContrasena(login.getContrasena());

        if (login.getEstado() == true) {
            habilitarMenus();
            this.mnu_AccesoDesconectar.setEnabled(true);
            this.mnu_sistema_conectar.setEnabled(false);
        }
    }
    
    public void setUsuario(String user) {
        this.usuario = user;
    }

    public void setContrasena(String pass) {
        this.contrasena = pass;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    private void mostrarSplash() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Splash splash = new Splash();
        splash.setDefaultCloseOperation(HIDE_ON_CLOSE);
        splash.setVisible(true);
        this.st = splash.getSt();
    }
}
