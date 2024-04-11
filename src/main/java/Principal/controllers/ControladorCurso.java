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
import javax.persistence.Query;

import Principal.entities.Curso;

public class ControladorCurso extends SuperControlador {
	
	private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();
	
	private static String nombreTabla = "curso";

	
	
	public static Curso getPrimero() {
		Query q  = em.createNativeQuery("Select min(id) from"  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Curso c = em.find(Curso.class, primerId);
		return c;
	}

	public static Curso getUltimo() {
		Query q  = em.createNativeQuery("Select max(id) from"  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Curso c = em.find(Curso.class, primerId);
		return c;
	}

	
	public static Curso getFabricanteSiguienteAnterior(int id) {
		return null;


	}
	
	
	

	public static Curso getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		Curso o = null;

		if (rs.next()) {
			o = new Curso();
			o.setId(rs.getInt("id"));
			o.setDescripcion(rs.getString("descripcion"));

		}
		return o;
	}
	
	
	public static List<Curso> getTodos(){
		List<Curso> l = new ArrayList<Curso>();
		
		
		
		
		return l;
	}

	
	public static int insercion (Curso o, Connection conn) {
		int nuevoId = SuperControlador.maxIdEnTabla("curso");
		try {
			PreparedStatement ps = conn.prepareStatement(""+ "insert into curso (id, descripcion) "
		+ "values (?, ?)");
			ps.setInt(1, nuevoId);
			ps.setString(2, o.getDescripcion());

			ps.execute();
			return nuevoId;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	public static void modificacion (Curso  o, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""+ "update curso set descripcion=? where id=?");
			ps.setString(1, o.getDescripcion());
			ps.setInt(2, o.getId());
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void eliminacion (int id, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete from curso where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
