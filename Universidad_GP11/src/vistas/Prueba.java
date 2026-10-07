package vistas;

import entidades.Alumno;
import persistencia.AlumnoData;
import persistencia.miConexion;
import java.time.LocalDate;

public class Prueba {

    private AlumnoData alumnoData;
    private miConexion conexion;

    public static void main(String[] args) {

        Alumno alumno = new Alumno(
            28180533,
            "Juan Cruz",
            LocalDate.of(1997, 9, 13),
            true
        );

        new Prueba().conectar(alumno);
    }

    void conectar(Alumno alumno) {

        conexion = new miConexion(
            "jdbc:mariadb://localhost/universidad",
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