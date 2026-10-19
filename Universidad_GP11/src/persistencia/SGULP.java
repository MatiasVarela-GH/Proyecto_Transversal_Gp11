package persistencia;

import vistas.VistaPrincipal;
import entidades.Alumno;
import persistencia.AlumnoData;
import persistencia.miConexion;
import java.time.LocalDate;

public class SGULP {

    private AlumnoData alumnoData;
    private miConexion conexion;

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Excepcion capturada acerca de el Look and Feel");
        }
        
       java.awt.EventQueue.invokeLater(() -> {
    VistaPrincipal v1 = new VistaPrincipal();
    v1.setLocationRelativeTo(null);
    v1.setVisible(true);
});
    }

    void conectar(Alumno alumno) {

        conexion = new miConexion(
                "jdbc:mariadb://localhost:3307/sistema de gestión",
                "root",
                ""
        );

        alumnoData = new AlumnoData(conexion);

        // Guardar
        alumnoData.guardarAlumno(alumno);

        // Buscar
        Alumno alu = alumnoData.buscarAlumno(alumno.getId());

        System.out.println("Datos: " + alu);

        // Listar
        System.out.println(" TODOS LOS ALUMNOS ");

        for (Alumno a : alumnoData.listarAlumnos()) {
            System.out.println(a);
        }

        // Actualizar
        System.out.println(" ACTUALIZAR ALUMNO ");

        alumno.setNombre("Juan Cruz Gagliano");

        alumnoData.actualizarAlumno(alumno);

        System.out.println("Alumno actualizado " + alumno);

        // Borrar
        System.out.println(" BORRAR ALUMNO ");

        alumnoData.borrarAlumno(alumno.getId());

        System.out.println("Alumno eliminado " + alumno);

    }
}
