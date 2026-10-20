package vistas;

import javax.swing.JOptionPane;
import entidades.Alumno;
import entidades.Inscripcion;
import persistencia.AlumnoData;
import persistencia.InscripcionData;
import persistencia.miConexion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaCargaNotas extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private InscripcionData inscripcionData;

    public VistaCargaNotas() {
        initComponents();
        configurarVista();
    }

    private void configurarVista() {
        miConexion conexion = new miConexion(
                "jdbc:mariadb://localhost:3306/sulp",
                "root",
                ""
        );

        alumnoData = new AlumnoData(conexion);
        inscripcionData = new InscripcionData(conexion);

        cboAlumno.removeAllItems();

        for (Alumno alumno : alumnoData.listarAlumnos()) {
            cboAlumno.addItem(
                    alumno.getId() + " - "
                    + alumno.getApellido() + ", "
                    + alumno.getNombre()
            );
        }

        tblNotas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Código", "Materia", "Nota"}
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return columna == 2;
            }
        });

        cboAlumno.addActionListener(this::cboAlumnoActionPerformed);
    }

    private void cargarMateriasDelAlumno() {
        if (cboAlumno.getSelectedItem() == null) {
            return;
        }

        int idAlumno = Integer.parseInt(
                cboAlumno.getSelectedItem().toString().split(" - ")[0]
        );

        DefaultTableModel modelo
                = (DefaultTableModel) tblNotas.getModel();

        modelo.setRowCount(0);

        List<Inscripcion> inscripciones
                = inscripcionData.listarInscripcionesPorAlumno(idAlumno);

        for (Inscripcion inscripcion : inscripciones) {
            entidades.Materia materia
                    = new persistencia.MateriaData(
                            new miConexion(
                                    "jdbc:mariadb://localhost:3306/sulp",
                                    "root",
                                    ""
                            )
                    ).buscarMateria(inscripcion.getIdMateria());

            if (materia != null) {
                modelo.addRow(new Object[]{
                    materia.getIdMateria(),
                    materia.getNombre(),
                    inscripcion.getNota()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cboAlumno = new javax.swing.JComboBox<>();

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
        jScrollPane2.setViewportView(jTable1);

        lbltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulo.setText("Carga de notas");
        lbltitulo.setAlignmentY(0.0F);

        lblAlumno.setText("Seleccione un alumno");

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Nota"
            }
        ));
        jScrollPane4.setViewportView(tblNotas);

        jScrollPane1.setViewportView(jScrollPane4);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        cboAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlumno)
                    .addComponent(cboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (tblNotas.isEditing()) {
            tblNotas.getCellEditor().stopCellEditing();
        }

        if (tblNotas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "El alumno no tiene materias inscriptas.");
            return;
        }

        int idAlumno = Integer.parseInt(
                cboAlumno.getSelectedItem().toString().split(" - ")[0]
        );

        List<Inscripcion> inscripciones
                = inscripcionData.listarInscripcionesPorAlumno(idAlumno);

        // Validar todas las notas antes de guardar
        for (int fila = 0; fila < tblNotas.getRowCount(); fila++) {
            Object valor = tblNotas.getValueAt(fila, 2);

            try {
                int nota = Integer.parseInt(String.valueOf(valor).trim());

                if (nota < 1 || nota > 10) {
                    JOptionPane.showMessageDialog(this,
                            "La nota debe estar entre 1 y 10.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese una nota numérica entre 1 y 10.");
                return;
            }
        }

        // Guardar las notas correspondientes a cada inscripción
        for (int fila = 0; fila < tblNotas.getRowCount(); fila++) {
            int idMateria = Integer.parseInt(
                    tblNotas.getValueAt(fila, 0).toString()
            );

            float nota = Float.parseFloat(
                    tblNotas.getValueAt(fila, 2).toString().trim()
            );

            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getIdMateria() == idMateria
                        && inscripcion.isEstado()) {
                    inscripcionData.actualizarNota(
                            inscripcion.getIdCursada(), nota
                    );
                    break;
                }
            }
        }

        JOptionPane.showMessageDialog(this,
                "Notas guardadas correctamente.");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {
        if (inscripcionData != null) {
            cargarMateriasDelAlumno();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboAlumno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTable tblNotas;
    // End of variables declaration//GEN-END:variables
}
