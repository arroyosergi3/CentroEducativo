package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import capitulo08.centroEducativo.entidades.Curso;

public class ControladorCurso extends SuperControlador {

	private static String nombreTabla = "centroeducativo.curso";

	
	public static Curso getPrimero() {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id asc limit 1");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Curso getUltimo() {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id desc limit 1");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Curso getFabricanteSiguienteAnterior(int id) {

		if (id > getUltimo().getId()) {
			return getPrimero();
		} else if (id < getPrimero().getId()) {
			return getUltimo();
		}
		
		

		try {

			return getEntidad(ConnectionManager.getConexion(), "select * from centroeducativo.curso where id=" + id);

		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			ResultSet rs =  ConnectionManager.getConexion().createStatement().executeQuery("select * from " + nombreTabla);
			while(rs.next()) {
				Curso o = getEntidadFromResulSet(rs);
				l.add(o);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}
	
	
	
	
	
	private static Curso getEntidadFromResulSet(ResultSet rs) throws SQLException {
		Curso o = null;


			o = new Curso();
			o.setId(rs.getInt("id"));
			o.setDescripcion(rs.getString("descripcion"));

		
		
		return o;
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
