package vistas;

import entidades.Alumno;
import persistencia.AlumnoData;
import persistencia.miConexion;
import java.time.LocalDate;

public class Prueba {

    private AlumnoData alumnoData;
    private miConexion conexion;

    public static void main(String[] args) {

        LocalDate fecha = LocalDate.now();

        Alumno estudioso = new Alumno(
            28180533,
            "El ko Ala",
            fecha,
            false
        );

        new Prueba().conectar(estudioso);
    }

    void conectar(Alumno estudioso) {

        conexion = new miConexion(
            "jdbc:mariadb://localhost/universidad",
            "root",
            ""
        );

        alumnoData = new AlumnoData(conexion);

        alumnoData.guardarAlumno(estudioso);

        Alumno alu = alumnoData.buscarAlumno(estudioso.getId());

        System.out.println("Datos: " + alu);
    }
}