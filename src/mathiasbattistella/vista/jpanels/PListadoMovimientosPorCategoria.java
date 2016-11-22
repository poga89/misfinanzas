/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathiasbattistella.vista.jpanels;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mathiasbattistella.controlador.CCategoria;
import mathiasbattistella.dto.Categoria;
import mathiasbattistella.dto.Movimiento;

/**
 *
 * @author user6
 */
public class PListadoMovimientosPorCategoria extends javax.swing.JPanel {
    
    private ArrayList<Movimiento> lista_Movimientos = null;
    private ArrayList<Categoria> lista_categorias = null;


    
    private void cargarDatos(){
        try{
            //creo el modelo por defecto y le inrgeso un array de String con los nombres de columnas
            DefaultTableModel tbm = new DefaultTableModel(new String[]
            {"Nombre", "Descripcion","Monto","Categoria","Tipo","Fecha Pagado"}, 0);  
            //obtengo la lista de movimientos a cargar
            lista_Movimientos = CCategoria.obtenerMovimientosPorCategoria(ddlCategorias.getSelectedItem().toString());
            if (lista_Movimientos.isEmpty()){
                lblMensaje.setText("No hay resultados");
            }
            //establezco la cantidad de filas en lista.size
            tbm.setRowCount(lista_Movimientos.size());
            //seteo el modelo a la tabla
            tabla.setModel(tbm);
            //cargo los datos a las filas
            if (!lista_Movimientos.isEmpty()){
                int fila = 0;
                for (Movimiento m : lista_Movimientos){
                    tabla.setValueAt(m.getNombre(), fila, 0);
                    tabla.setValueAt(m.getDescripcion(), fila, 1);
                    tabla.setValueAt(m.getMonto(), fila, 2);
                    tabla.setValueAt(m.getCategoria().getNombre(), fila, 3);
                    tabla.setValueAt(m.isEs_ingreso()?"Ingreso":"Egreso", fila, 4);
                    tabla.setValueAt(m.getFecha_pagado()==null?"Impago":m.getFecha_pagado().toString(), fila, 5);
                    fila++;
                }
                lblMensaje.setText("Encontrado " + lista_Movimientos.size() + " resultado(s).");
            }
        } catch (Error e){
            lblMensaje.setText(e.getMessage());
        } catch (Exception e) {
            lblMensaje.setText("Ha ocurrido un error" + e.getMessage());
        }
    }    
    
    /**
     * Creates new form ListadoMovimientosPorCategoria
     */
    public PListadoMovimientosPorCategoria() {
        lista_categorias = CCategoria.listarCategorias();
            initComponents();     
            cargarDatos();        
            tabla.setDefaultEditor(Object.class, null);
        if (lista_categorias.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nada que hacer por aqui, no hay categorias...");
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

        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ddlCategorias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblMensaje = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Movimientos por Categorías:");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ver Movimientos por:");

        ArrayList<Categoria> l = mathiasbattistella.controlador.CCategoria.listarCategorias();
        String[] v = new String[l.size()];
        for (int i=0;i<l.size();i++){
            v[i] = l.get(i).getNombre();
        }
        ddlCategorias.setModel(new DefaultComboBoxModel(v));
        ddlCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ddlCategoriasItemStateChanged(evt);
            }
        });
        ddlCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ddlCategoriasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ddlCategoriasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ddlCategoriasMouseReleased(evt);
            }
        });
        ddlCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlCategoriasActionPerformed(evt);
            }
        });
        ddlCategorias.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ddlCategoriasPropertyChange(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(347, 381, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ddlCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizar)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void ddlCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlCategoriasActionPerformed

    private void ddlCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddlCategoriasMouseClicked
        
    }//GEN-LAST:event_ddlCategoriasMouseClicked

    private void ddlCategoriasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddlCategoriasMousePressed

    }//GEN-LAST:event_ddlCategoriasMousePressed

    private void ddlCategoriasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ddlCategoriasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlCategoriasMouseReleased

    private void ddlCategoriasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ddlCategoriasPropertyChange

    }//GEN-LAST:event_ddlCategoriasPropertyChange

    private void ddlCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ddlCategoriasItemStateChanged
cargarDatos();
    }//GEN-LAST:event_ddlCategoriasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> ddlCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}