package persistencia;


import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.miConexion;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Taigo Capo
 */
public class InscripcionData {

    private Connection con = null;

    public InscripcionData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    // =========================
    // GUARDAR INSCRIPCIÓN
    // INSERT
    // =========================
    public void guardarInscripcion(Inscripcion i) {
        String sql = "INSERT INTO cursada "
                + "(idAlumno, idMateria, cuatrimestre, nota, asistencias, anioLectivo, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, i.getIdAlumno());
            ps.setInt(2, i.getIdMateria());
            ps.setInt(3, i.getCuatrimestre());
            ps.setFloat(4, i.getNota());
            ps.setFloat(5, i.getAsistencia());
            ps.setInt(6, i.getAnioCursada());
            ps.setBoolean(7, i.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                i.setIdCursada(rs.getInt(1));

            }
            ps.close();
            rs.close();
            System.out.println("Inscripción guardada correctamente");

        } catch (SQLException ex) {

            Logger.getLogger(InscripcionData.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    // =========================
    // BUSCAR INSCRIPCION POR ID
    // SELECT
    // =========================
    public Inscripcion buscarInscripcion(int id) {

        Inscripcion i = null;

        String sql = "SELECT * FROM cursada WHERE idCursada = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                i = new Inscripcion();

                i.setIdCursada(rs.getInt("idCursada"));
                i.setIdAlumno(rs.getInt("idAlumno"));
                i.setIdMateria(rs.getInt("idMateria"));
                i.setCuatrimestre(rs.getInt("cuatrimestre"));
                i.setNota(rs.getFloat("nota"));
                i.setAsistencia(rs.getFloat("asistencias"));
                i.setAnioCursada(rs.getInt("anioLectivo"));
                i.setEstado(rs.getBoolean("estado"));

            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {

            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    // =========================
    // LISTAR MATERIAS POR ALUMNO
    // SELECT *
    // =========================
    public List<Materia> listarMateriasPorAlumno(int idAlumno) {

        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT DISTINCT m.* "
                + "FROM materia m "
                + "INNER JOIN cursada c ON m.idMateria = c.idMateria "
                + "WHERE c.idAlumno = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                m.setIdMateria(rs.getInt("idMateria"));

                materias.add(m);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar materias por alumno: " + ex.getMessage());
        }

        return materias;
    }
    
    // =========================
    // LISTAR MATERIAS NO INSCRIPTAS
    // =========================

    public List<Materia> listarMateriasNoInscriptas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();

        String sql = "SELECT m.* FROM materia m "
                + "WHERE m.estado = 1 "
                + "AND m.idMateria NOT IN ("
                + "SELECT c.idMateria FROM cursada c "
                + "WHERE c.idAlumno = ? AND c.estado = 1)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                m.setAnio(rs.getInt("anio"));
                m.setCuatrimestre(rs.getInt("cuatrimestre"));

                materias.add(m);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al listar materias no inscriptas: "
                    + ex.getMessage());
        }

        return materias;
    }
    
    // =========================
    // LISTAR iNSCRIPCIONES X ALUMNO
    // =========================

    public List<Inscripcion> listarInscripcionesPorAlumno(int idAlumno) {
        List<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT * FROM cursada WHERE idAlumno = ? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setIdCursada(rs.getInt("idCursada"));
                i.setIdAlumno(rs.getInt("idAlumno"));
                i.setIdMateria(rs.getInt("idMateria"));
                i.setCuatrimestre(rs.getInt("cuatrimestre"));
                i.setNota(rs.getFloat("nota"));
                i.setAsistencia(rs.getFloat("asistencias"));
                i.setAnioCursada(rs.getInt("anioLectivo"));
                i.setEstado(rs.getBoolean("estado"));

                inscripciones.add(i);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al listar inscripciones: " + ex.getMessage());
        }

        return inscripciones;
    }


    // =========================
    // LISTAR ALUMNOS POR MATERIA
    // SELECT
    // =========================
    public List<Alumno> listarAlumnosPorMateria(int idMateria) {

        List<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT a.* "
                + "FROM alumno a "
                + "INNER JOIN cursada c ON a.idAlumno= c.idAlumno "
                + "WHERE c.idMateria = ? ";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(rs.getDate("fecNac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));

                alumnos.add(a);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar alumnos por materia: " + ex.getMessage());
        }

        return alumnos;
    }

    // =========================
    // BORRAR INSCRIPCION POR IDCURSADA
    // DELETE
    // =========================
    public void desinscribirAlumno(int idCursada) {

        String sql = "DELETE FROM cursada "
                + "WHERE idCursada= ? ";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idCursada);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Desinscripción realizada correctamente.");
            } else {
                System.out.println("No se encontró esa inscripción.");
            }

            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // =========================
// REGISTRAR ASISTENCIA POR MATERIA
// =========================
    public void registrarAsistencia(int idCursada) {
        try {
            String sql = "UPDATE cursada "
                    + "SET asistencias = asistencias + 1 "
                    + "WHERE idCursada = ? AND asistencias < 30";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCursada);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Asistencia registrada correctamente.");
            } else {
                System.out.println("No se registró la asistencia: "
                        + "la cursada no existe o ya tiene 30 asistencias.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.getLogger(InscripcionData.class.getName())
                    .log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // =========================
    // ACTUALIZAR NOTA DE ALUMNO
    // =========================
    public void actualizarNota(int idCursada, float nota) {
        String sql = "UPDATE cursada "
                + "SET nota = ? "
                + " WHERE idCursada = ? ";
        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setFloat(1, nota);
            ps.setInt(2, idCursada);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Nota actualizada correctamente.");
            } else {
                System.out.println("No se registró la nota; no existe la cursada.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.getLogger(InscripcionData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
