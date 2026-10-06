package persistencia;



import entidades.Alumno;
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

public class AlumnoData {

    private Connection con = null;

    public AlumnoData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    // =========================
    // GUARDAR ALUMNO
    // INSERT
    // =========================
    public void guardarAlumno(Alumno a) {

        String sql = "INSERT INTO alumno(dni, nombre, fecNac, activo) VALUES (?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, Date.valueOf(a.getFechaNac()));
            ps.setBoolean(4, a.isActivo());

            ps.executeUpdate();

            // Recuperamos el ID generado por MySQL
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                a.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el ID");
            }

            ps.close();

            System.out.println("Alumno guardado correctamente");

        } catch (SQLException ex) {

            System.out.println("No se pudo insertar el alumno");
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // =========================
    // BUSCAR ALUMNO POR ID
    // SELECT
    // =========================
    public Alumno buscarAlumno(int id) {

        Alumno a = null;

        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                a = new Alumno();

                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(
                        rs.getDate("fecNac").toLocalDate()
                );
                a.setActivo(rs.getBoolean("activo"));
            }

            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    // =========================
    // LISTAR TODOS LOS ALUMNOS
    // SELECT *
    // =========================
    public List<Alumno> listarAlumnos() {

        List<Alumno> alumnos = new ArrayList<>();

        String query = "SELECT * FROM alumno";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alumno a = new Alumno();

                a.setId(rs.getInt("idAlumno"));
                a.setDni(rs.getInt("dni"));
                a.setNombre(rs.getString("nombre"));
                a.setFechaNac(
                        rs.getDate("fecNac").toLocalDate()
                );
                a.setActivo(rs.getBoolean("activo"));

                alumnos.add(a);
            }

            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alumnos;
    }

    // =========================
    // ACTUALIZAR ALUMNO
    // UPDATE
    // =========================
    public void actualizarAlumno(Alumno a) {

        String query = "UPDATE alumno SET dni = ?, nombre = ?, fecNac = ?, activo = ? "
                + "WHERE idAlumno = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, Date.valueOf(a.getFechaNac()));
            ps.setBoolean(4, a.isActivo());
            ps.setInt(5, a.getId());

            ps.executeUpdate();

            ps.close();

            System.out.println("Alumno actualizado correctamente");

        } catch (SQLException ex) {

            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // =========================
    // BORRAR ALUMNO
    // DELETE
    // =========================
    public void borrarAlumno(int id) {

        String query = "DELETE FROM alumno WHERE idAlumno = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();

            System.out.println("Alumno eliminado correctamente");

        } catch (SQLException ex) {

            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

