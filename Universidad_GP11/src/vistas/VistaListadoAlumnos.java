package vistas;

import entidades.Alumno;
import entidades.Materia;
import persistencia.InscripcionData;
import persistencia.MateriaData;
import persistencia.miConexion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaListadoAlumnos extends javax.swing.JInternalFrame {
    private MateriaData materiaData;
    private InscripcionData inscripcionData;
    private List<Materia> materias;
    private boolean cargandoMaterias = false;
    
    public VistaListadoAlumnos() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de alumnos por materia");
        setDefaultCloseOperation(
     javax.swing.WindowConstants.DISPOSE_ON_CLOSE
    );
        // La tabla muestra los datos solicitados en la imagen.
    tblAlumnos.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "DNI", "Apellido", "Nombre"}
    ) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    });

    conectarYcargarMaterias();
           }
    private void conectarYcargarMaterias() {
    miConexion conexion = new miConexion(
            "jdbc:mariadb://localhost:3306/sulp",
            "root",
            ""
    );

    if (conexion.buscarConexion() == null) {
        JOptionPane.showMessageDialog(
                this,
                "No se pudo conectar con la base de datos.",
                "Error de conexión",
                JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    materiaData = new MateriaData(conexion);
    inscripcionData = new InscripcionData(conexion);

    materias = materiaData.listarMaterias();

    cargandoMaterias = true;
    cboMateria.removeAllItems();

   for (Materia materia : materias) {
            cboMateria.addItem(
                    materia.getIdMateria() + " - " + materia.getNombre()
            );
        }

        cargandoMaterias = false;

        // Si hay materias, muestra los alumnos de la primera.
        if (!materias.isEmpty()) {
            cboMateria.setSelectedIndex(0);
            cargarAlumnosDeMateria(materias.get(0));
        }
    }
private void cargarAlumnosDeMateria(Materia materia) {
    DefaultTableModel modelo = (DefaultTableModel) tblAlumnos.getModel();

    // Borra las filas de la materia anterior.
    modelo.setRowCount(0);

    List<Alumno> alumnos =
            inscripcionData.listarAlumnosPorMateria(materia.getIdMateria());

    for (Alumno alumno : alumnos) {
        modelo.addRow(new Object[]{
            alumno.getId(),
            alumno.getDni(),
            alumno.getApellido(),
            alumno.getNombre()
        });
    }

    if (alumnos.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "No hay alumnos inscriptos en esta materia."
        );
    }
}
       

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        cboMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Listado de alumnos por materia");

        lblMateria.setText("Seleccione una materia");

        cboMateria.addActionListener(this::cboMateriaActionPerformed);

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id.", "Apellido", "Nombre", "Dni"
            }
        ));
        jScrollPane1.setViewportView(tblAlumnos);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMateria)
                        .addGap(36, 36, 36)
                        .addComponent(cboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMateria)
                    .addComponent(cboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(26, Short.MAX_VALUE))
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
        {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        cboMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

}
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMateriaActionPerformed
       if (cargandoMaterias
                || materias == null
                || materias.isEmpty()
                || inscripcionData == null) {
            return;
        }

        int indice = cboMateria.getSelectedIndex();

        if (indice >= 0 && indice < materias.size()) {
            cargarAlumnosDeMateria(materias.get(indice));
        }

    }//GEN-LAST:event_cboMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboMateria;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAlumnos;
    // End of variables declaration//GEN-END:variables

}