package vistas;

import entidades.Alumno;
import entidades.Materia;
import entidades.Inscripcion;
import persistencia.AlumnoData;
import persistencia.InscripcionData;
import persistencia.MateriaData;
import persistencia.miConexion;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class VistaFormularioInscripcion extends javax.swing.JInternalFrame {
    
    private AlumnoData alumnoData;
    private InscripcionData inscripcionData;
    private MateriaData materiaData;

    public VistaFormularioInscripcion() {
        initComponents();

        miConexion conexion = new miConexion(
                "jdbc:mariadb://localhost:3306/sulp",
                "root",
                ""
        );

        alumnoData = new AlumnoData(conexion);
        inscripcionData = new InscripcionData(conexion);
        materiaData = new MateriaData(conexion);

        cargarAlumnos();
    }

    private void cargarAlumnos() {
        cboAlumno.removeAllItems();

        for (Alumno alumno : alumnoData.listarAlumnos()) {
            cboAlumno.addItem(
                    alumno.getId() + " - "
                    + alumno.getApellido() + ", "
                    + alumno.getNombre()
            );
        }
    }
    
    private void cargarMateriasNoInscriptas() {
        if (cboAlumno.getSelectedItem() == null) {
            return;
        }

        String seleccionado = cboAlumno.getSelectedItem().toString();
        int idAlumno = Integer.parseInt(seleccionado.split(" - ")[0]);

        DefaultTableModel modelo = (DefaultTableModel) tblMaterias.getModel();
        modelo.setRowCount(0);

        for (Materia materia : inscripcionData.listarMateriasNoInscriptas(idAlumno)) {
            modelo.addRow(new Object[]{
                materia.getIdMateria(),
                materia.getNombre(),
                materia.getAnio()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblforminscrip = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        cboAlumno = new javax.swing.JComboBox<>();
        lblMaterias = new javax.swing.JLabel();
        rbInscriptas = new javax.swing.JRadioButton();
        rbNoInscriptas = new javax.swing.JRadioButton();
        btnInscribir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblforminscrip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblforminscrip.setText("Formulario de inscripcion");
        lblforminscrip.setAlignmentY(0.0F);
        lblforminscrip.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblAlumno.setText("Seleccione un alumno");

        cboAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboAlumno.addActionListener(this::cboAlumnoActionPerformed);

        lblMaterias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaterias.setText("Listado Materias");

        buttonGroup1.add(rbInscriptas);
        rbInscriptas.setText("Materias inscriptas");
        rbInscriptas.addActionListener(this::rbInscriptasActionPerformed);

        buttonGroup1.add(rbNoInscriptas);
        rbNoInscriptas.setText("Materias no inscriptas");
        rbNoInscriptas.addActionListener(this::rbNoInscriptasActionPerformed);

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(this::btnInscribirActionPerformed);

        btnAnular.setText("Anular Inscripcion");
        btnAnular.addActionListener(this::btnAnularActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id.", "Materia", "Año"
            }
        ));
        jScrollPane4.setViewportView(tblMaterias);

        jScrollPane3.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblforminscrip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblMaterias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblAlumno)
                        .addGap(36, 36, 36)
                        .addComponent(cboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(rbInscriptas)
                        .addGap(49, 49, 49)
                        .addComponent(rbNoInscriptas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(btnInscribir)
                        .addGap(50, 50, 50)
                        .addComponent(btnAnular)
                        .addGap(44, 44, 44)
                        .addComponent(btnSalir)
                        .addGap(40, 40, 40)))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblforminscrip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlumno)
                    .addComponent(cboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNoInscriptas)
                    .addComponent(rbInscriptas))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnAnular)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAlumnoActionPerformed
        cargarMateriasNoInscriptas();
    }//GEN-LAST:event_cboAlumnoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rbInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInscriptasActionPerformed
        if (cboAlumno.getSelectedItem() == null) {
            return;
        }

        String seleccionado = cboAlumno.getSelectedItem().toString();
        int idAlumno = Integer.parseInt(seleccionado.split(" - ")[0]);

        DefaultTableModel modelo = (DefaultTableModel) tblMaterias.getModel();
        modelo.setRowCount(0);

        for (Materia materia : inscripcionData.listarMateriasPorAlumno(idAlumno)) {
            modelo.addRow(new Object[]{
                materia.getIdMateria(),
                materia.getNombre(),
                materia.getAnio()
            });
        }
    }//GEN-LAST:event_rbInscriptasActionPerformed

    private void rbNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoInscriptasActionPerformed
        cargarMateriasNoInscriptas();
    }//GEN-LAST:event_rbNoInscriptasActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        if (cboAlumno.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccioná un alumno.");
            return;
        }

        int fila = tblMaterias.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná una materia de la tabla.");
            return;
        }

        int idAlumno = Integer.parseInt(
                cboAlumno.getSelectedItem().toString().split(" - ")[0]
        );

        int idMateria = Integer.parseInt(
                tblMaterias.getValueAt(fila, 0).toString()
        );

        Materia materia = materiaData.buscarMateria(idMateria);

        if (materia == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la materia.");
            return;
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdAlumno(idAlumno);
        inscripcion.setIdMateria(idMateria);
        inscripcion.setCuatrimestre(materia.getCuatrimestre());
        inscripcion.setAnioCursada(java.time.Year.now().getValue());
        inscripcion.setNota(0);
        inscripcion.setAsistencia(0);
        inscripcion.setEstado(true);

        inscripcionData.guardarInscripcion(inscripcion);

        if (inscripcion.getIdCursada() != -1) {
            JOptionPane.showMessageDialog(this, "Inscripción realizada correctamente.");
            cargarMateriasNoInscriptas();
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo confirmar la inscripción. Revisá la consola de NetBeans.");
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (cboAlumno.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccioná un alumno.");
            return;
        }

        int fila = tblMaterias.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná una materia de la tabla.");
            return;
        }

        int idAlumno = Integer.parseInt(
                cboAlumno.getSelectedItem().toString().split(" - ")[0]
        );

        int idMateria = Integer.parseInt(
                tblMaterias.getValueAt(fila, 0).toString()
        );

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Querés anular la inscripción a esta materia?",
                "Confirmar anulación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        Inscripcion inscripcionSeleccionada = null;

        for (Inscripcion inscripcion : inscripcionData.listarInscripcionesPorAlumno(idAlumno)) {
            if (inscripcion.getIdMateria() == idMateria && inscripcion.isEstado()) {
                inscripcionSeleccionada = inscripcion;
                break;
            }
        }

        if (inscripcionSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la inscripción.");
            return;
        }

        inscripcionData.desinscribirAlumno(inscripcionSeleccionada.getIdCursada());

        JOptionPane.showMessageDialog(this, "Inscripción anulada.");
        cargarMateriasNoInscriptas();
    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboAlumno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblMaterias;
    private javax.swing.JLabel lblforminscrip;
    private javax.swing.JRadioButton rbInscriptas;
    private javax.swing.JRadioButton rbNoInscriptas;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables

}