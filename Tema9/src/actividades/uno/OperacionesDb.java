package actividades.uno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Clase para manejar registros de la DB planetas
 * 
 * @author amna
 * @version 1.0
 */
public class OperacionesDb {
	private DbConn dbconn;
	private Planeta planeta;
	private Connection conn;

	public OperacionesDb() {
		dbconn = new DbConn();
		planeta = new Planeta();
	}

	public void insertar(int id, String nombre, double radio, double densidad, double velocidad) {
		PreparedStatement ps;
		String sql;
		planeta.setId(id);
		planeta.setNombre(nombre);
		planeta.setRadio(radio);
		planeta.setDensidad(densidad);
		planeta.setVelocidad(velocidad);
		try {
			conn = dbconn.getConexion();
			sql = "INSERT INTO planetas (id,nombre, radio, densidad, velocidad) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, planeta.getId());
			ps.setString(2, planeta.getNombre());
			ps.setDouble(3, planeta.getRadio());
			ps.setDouble(4, planeta.getDensidad());
			ps.setDouble(5, planeta.getVelocidad());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminar(int id) {
		PreparedStatement ps;
		String sql;
		try {
			conn = dbconn.getConexion();
			sql = "DELETE FROM planetas WHERE planetas.id = "+id;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
