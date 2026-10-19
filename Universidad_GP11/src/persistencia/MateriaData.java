package persistencia;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MateriaData {

    private Connection con = null;

    public MateriaData(miConexion conexion) {
        this.con = conexion.buscarConexion();
    }

    // =========================
    // GUARDAR MATERIA
    // INSERT
    // =========================
    public void guardarMateria(Materia m) {

        String sql = "INSERT INTO materia(nombre, estado) VALUES (?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());

            ps.executeUpdate();

            // Recuperamos el ID generado por MySQL
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                m.setIdMateria(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el ID");
            }

            rs.close();
            ps.close();

            System.out.println("Materia guardada correctamente");

        } catch (SQLException ex) {

            System.out.println("No se pudo insertar la materia");
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // =========================
    // BUSCAR MATERIA POR ID
    // SELECT
    // =========================
    public Materia buscarMateria(int id) {

        Materia m = null;

        String sql = "SELECT * FROM materia WHERE idMateria= ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m;
    }

    // =========================
    // LISTAR TODAS LAS MATERIAS
    // SELECT *
    // =========================
    public List<Materia> listarMaterias() {

        List<Materia> materias = new ArrayList<>();

        String query = "SELECT * FROM materia";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia m = new Materia();

                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materias;
    }

    // =========================
    // ACTUALIZAR MATERIA
    // UPDATE
    // =========================
    public void actualizarMateria(Materia m) {

        String query = "UPDATE materia SET nombre = ?, estado = ? "
                + "WHERE idMateria = ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());
            ps.setInt(3, m.getIdMateria());

           int filas = ps.executeUpdate();

            ps.close();


            if (filas > 0) {
                System.out.println("Materia actualizada correctamente");
            } else {
                System.out.println("No se encontró la materia");
            }

        } catch (SQLException ex) {

            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // =========================
    // BORRAR MATERIA
    // DELETE
    // =========================
    public void borrarMateria(int id) {

        String query = "DELETE FROM materia WHERE idMateria= ?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Materia eliminada correctamente");
            } else {
                System.out.println("No se encontró la materia");
            }

            ps.close();


        } catch (SQLException ex) {

            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
