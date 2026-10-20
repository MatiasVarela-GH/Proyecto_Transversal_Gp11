
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

    // GUARDAR MATERIA
    public void guardarMateria(Materia m) {

        String sql = "INSERT INTO materia "
                + "(nombre, estado, anio, cuatrimestre) "
                + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());
            ps.setInt(3, m.getAnio());
            ps.setInt(4, m.getCuatrimestre());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                m.setIdMateria(rs.getInt(1));
            }

            rs.close();
            ps.close();

            System.out.println("Materia guardada correctamente");

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName())
                    .log(Level.SEVERE, "Error al guardar materia", ex);
        }
    }

    // BUSCAR MATERIA POR ID
    public Materia buscarMateria(int id) {

        Materia m = null;
        String sql = "SELECT * FROM materia WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Materia();
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setEstado(rs.getBoolean("estado"));
                m.setAnio(rs.getInt("anio"));
                m.setCuatrimestre(rs.getInt("cuatrimestre"));
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName())
                    .log(Level.SEVERE, "Error al buscar materia", ex);
        }

        return m;
    }

    // LISTAR TODAS LAS MATERIAS
    public List<Materia> listarMaterias() {

        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            Logger.getLogger(MateriaData.class.getName())
                    .log(Level.SEVERE, "Error al listar materias", ex);
        }

        return materias;
    }

    // ACTUALIZAR MATERIA
    public void actualizarMateria(Materia m) {

        String sql = "UPDATE materia "
                + "SET nombre = ?, estado = ?, anio = ?, cuatrimestre = ? "
                + "WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombre());
            ps.setBoolean(2, m.isEstado());
            ps.setInt(3, m.getAnio());
            ps.setInt(4, m.getCuatrimestre());
            ps.setInt(5, m.getIdMateria());

            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia actualizada correctamente");
            } else {
                System.out.println("No se encontró la materia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName())
                    .log(Level.SEVERE, "Error al actualizar materia", ex);
        }
    }

    // BORRAR MATERIA
    public void borrarMateria(int id) {

        String sql = "DELETE FROM materia WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            ps.close();

            if (filas > 0) {
                System.out.println("Materia eliminada correctamente");
            } else {
                System.out.println("No se encontró la materia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(MateriaData.class.getName())
                    .log(Level.SEVERE, "Error al borrar materia", ex);
        }
    }
}