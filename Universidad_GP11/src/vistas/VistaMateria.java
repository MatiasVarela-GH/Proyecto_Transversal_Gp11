package vistas;

import entidades.Materia;
import persistencia.MateriaData;
import persistencia.miConexion;
import javax.swing.JOptionPane;

public class VistaMateria extends javax.swing.JInternalFrame {
    
    private MateriaData materiaData;
    private int idMateriaSeleccionada = -1;

    public VistaMateria() {
        initComponents();

        miConexion conexion = new miConexion(
                "jdbc:mariadb://localhost:3306/sulp",
                "root",
                ""
        );

        materiaData = new MateriaData(conexion);
        rbtnEstado.setText("Activo");
        rbtnEstado.setSelected(true);
        txtCodigo.setEditable(true);
        
    }
    
    private void limpiarFormularioMateria() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtAnio.setText("");
        txtCuatrimestre.setText("");

        rbtnEstado.setSelected(true);
        idMateriaSeleccionada = -1;
        txtCodigo.setEditable(true);

        txtNombre.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCuatrimestre = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCuatrimestre = new javax.swing.JTextField();
        rbtnEstado = new javax.swing.JRadioButton();
        btnNuevoM = new javax.swing.JButton();
        btnEliminarM = new javax.swing.JButton();
        btnGuardarM = new javax.swing.JButton();
        btnSalirM = new javax.swing.JButton();
        btnBuscarMateria = new javax.swing.JButton();

        setTitle("Formulario Materias");

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtTitulo.setText("Materia");

        lblAnio.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblAnio.setText("Año:");

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblCodigo.setText("Código:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblNombre.setText("Nombre:");

        lblCuatrimestre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblCuatrimestre.setText("Cuatrimestre:");

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblEstado.setText("Estado:");

        txtAnio.addActionListener(this::txtAnioActionPerformed);

        txtCodigo.addActionListener(this::txtCodigoActionPerformed);

        txtNombre.addActionListener(this::txtNombreActionPerformed);

        txtCuatrimestre.addActionListener(this::txtCuatrimestreActionPerformed);

        rbtnEstado.addActionListener(this::rbtnEstadoActionPerformed);

        btnNuevoM.setText("Nuevo");
        btnNuevoM.addActionListener(this::btnNuevoMActionPerformed);

        btnEliminarM.setText("Eliminar");
        btnEliminarM.addActionListener(this::btnEliminarMActionPerformed);

        btnGuardarM.setText("Guardar");
        btnGuardarM.addActionListener(this::btnGuardarMActionPerformed);

        btnSalirM.setText("Salir");
        btnSalirM.addActionListener(this::btnSalirMActionPerformed);

        btnBuscarMateria.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBuscarMateria.setText("Buscar");
        btnBuscarMateria.addActionListener(this::btnBuscarMateriaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(txtTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCuatrimestre)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnEstado)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevoM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarM, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarM, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirM, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnBuscarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(rbtnEstado)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalirM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void rbtnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnEstadoActionPerformed

    private void btnNuevoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMActionPerformed
        limpiarFormularioMateria();
    }//GEN-LAST:event_btnNuevoMActionPerformed

    private void btnEliminarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMActionPerformed
        try {
            String codigo = txtCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Buscá una materia o ingresá su código.");
                return;
            }

            int id = idMateriaSeleccionada != -1
                    ? idMateriaSeleccionada
                    : Integer.parseInt(codigo);

            Materia materia = materiaData.buscarMateria(id);

            if (materia == null) {
                JOptionPane.showMessageDialog(
                        this, "No se encontró la materia.");
                return;
            }

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Eliminar la materia " + materia.getNombre() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                materiaData.borrarMateria(id);

                JOptionPane.showMessageDialog(
                        this,
                        "Se solicitó eliminar la materia. "
                        + "Verificá la consola si aparece un error SQL.");

                limpiarFormularioMateria();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "El código debe ser un número entero.");
        }
    }//GEN-LAST:event_btnEliminarMActionPerformed

    private void btnGuardarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMActionPerformed
        try {
            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()
                    || txtAnio.getText().trim().isEmpty()
                    || txtCuatrimestre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Completá todos los campos.");
                return;
            }

            int anio = Integer.parseInt(txtAnio.getText().trim());
            int cuatrimestre = Integer.parseInt(
                    txtCuatrimestre.getText().trim());

            if (anio < 1 || anio > 3) {
                JOptionPane.showMessageDialog(
                        this, "El año debe estar entre 1 y 3.");
                return;
            }

            if (cuatrimestre < 1 || cuatrimestre > 2) {
                JOptionPane.showMessageDialog(
                        this, "El cuatrimestre debe ser 1 o 2.");
                return;
            }

            Materia materia = new Materia();
            materia.setNombre(nombre);
            materia.setEstado(rbtnEstado.isSelected());
            materia.setAnio(anio);
            materia.setCuatrimestre(cuatrimestre);

            if (idMateriaSeleccionada == -1) {
                materiaData.guardarMateria(materia);

                if (materia.getIdMateria() != -1) {
                    JOptionPane.showMessageDialog(
                            this, "Materia guardada correctamente.");
                    limpiarFormularioMateria();
                } else {
                    JOptionPane.showMessageDialog(
                            this, "No se pudo guardar la materia. "
                            + "Revisá la consola de NetBeans.");
                }
            } else {
                materia.setIdMateria(idMateriaSeleccionada);
                materiaData.actualizarMateria(materia);

                JOptionPane.showMessageDialog(
                        this, "Actualización ejecutada.");
                limpiarFormularioMateria();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "El año y el cuatrimestre deben ser números.");
        }
    }//GEN-LAST:event_btnGuardarMActionPerformed

    private void btnSalirMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirMActionPerformed

    private void btnBuscarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMateriaActionPerformed
        try {
            String codigo = txtCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Ingresá el código de la materia.");
                return;
            }

            int id = Integer.parseInt(codigo);
            Materia materia = materiaData.buscarMateria(id);

            if (materia == null) {
                JOptionPane.showMessageDialog(
                        this, "No se encontró la materia.");

                idMateriaSeleccionada = -1;
                return;
            }

            idMateriaSeleccionada = materia.getIdMateria();

            txtCodigo.setText(
                    String.valueOf(materia.getIdMateria()));
            txtNombre.setText(materia.getNombre());
            txtAnio.setText(String.valueOf(materia.getAnio()));
            txtCuatrimestre.setText(
                    String.valueOf(materia.getCuatrimestre()));

            rbtnEstado.setSelected(materia.isEstado());
            rbtnEstado.setText(
                    materia.isEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(
                    this, "Materia encontrada.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "El código debe ser un número entero.");
        }
    }//GEN-LAST:event_btnBuscarMateriaActionPerformed

    private void txtCuatrimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuatrimestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuatrimestreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMateria;
    private javax.swing.JButton btnEliminarM;
    private javax.swing.JButton btnGuardarM;
    private javax.swing.JButton btnNuevoM;
    private javax.swing.JButton btnSalirM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCuatrimestre;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JRadioButton rbtnEstado;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCuatrimestre;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
