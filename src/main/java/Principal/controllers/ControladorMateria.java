package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import Principal.entities.Materia;


public class ControladorMateria extends SuperControlador{

private static String nombreTabla = "materia";
private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();


	
	public static Materia getPrimero() {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id asc limit 1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Materia getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id desc limit 1");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Materia getFabricanteSiguienteAnterior(int id) {

		if (id > getUltimo().getId()) {
			return getPrimero();
		} else if (id < getPrimero().getId()) {
			return getUltimo();
		}
		
		

		try {

			return getEntidad(ConnectionManager.getConexion(), "select * from "+nombreTabla+ " where id=" + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public static Materia getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		Materia o = null;

		if (rs.next()) {
			o = new Materia();
			o.setId(rs.getInt("id"));
			o.setCursoID(rs.getInt("curso_id"));
			o.setAcronimo(rs.getString("acronimo"));
			o.setNombre(rs.getString("nombre"));
			
		}
		return o;
	}
	
	
	public static void nuevaMateria () {
		Scanner sc = new Scanner(System.in);
		String acr, nom;
		int nuevoIdDisponible;
		
		System.out.println("Creación de una nueva materia");
		System.out.println("Dame el nombre de la materia:");
		nom = sc.nextLine();
		System.out.println("Dame el acronimo de la materia:");
		acr = sc.nextLine();
		
		sc.close();
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			nuevoIdDisponible = maxIdEnTabla("materia");
			if (nuevoIdDisponible != -1) {
				int registrosAfectados = s.executeUpdate(
						"insert into materia values (" + nuevoIdDisponible + ",'" + nom + "' ,'" + acr + ","  + 1 + "')");
				System.out.println(registrosAfectados + " registros insertados ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int maxIdEnTabla(String nombreTabla) {
		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("Select max(id) from " + nombreTabla);
			
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; 		
	}
	
	public static int insercion (Materia o, Connection conn) {
		int nuevoId = maxIdEnTabla("materia");
		try {
			PreparedStatement ps = conn.prepareStatement(""+ "insert into materia (id, nombre, acronimo, curso_id) "
		+ "values (?, ?, ?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getAcronimo());
			ps.setInt(4, 1);
			ps.execute();
			return nuevoId;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	public static void modificacion (Materia  o, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""+ "update materia set nombre=?, acronimo=?, curso_id = ?  where id=?");
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getAcronimo());
			ps.setInt(3, 1);
			ps.setInt(4, o.getId());
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void eliminacion (int id, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete from materia where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Materia> getTodos(){
		List<Materia> l = new ArrayList<Materia>();
		
		
		
		
		return l;
	}
	
	
	private static Materia getEntidadFromResulSet(ResultSet rs) throws SQLException {
		Materia o = null;


			o = new Materia();
			o.setId(rs.getInt("id"));
			o.setNombre(rs.getString("nombre"));
			o.setAcronimo("acronimo");
			o.setCursoID(1);

		
		
		return o;
	}
	
	
	
	
	
	
	
	
	
}
