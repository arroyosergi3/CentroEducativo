package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import capitulo08.centroEducativo.entidades.Curso;
import capitulo08.centroEducativo.entidades.ValoracionMateria;

public class ControladorValoracionMateria extends SuperControlador {

	private static String nombreTabla = "valoracionmateria";

	

	
	
	public static ValoracionMateria findByIdMateriaAndIdProfesorAndIdEstudiante (int idMateria, int idProfesor, int idEstudiante){
		ValoracionMateria v = null;
		try {
			PreparedStatement ps =  ConnectionManager.getConexion().prepareStatement("select * from " + nombreTabla + " where idProfesor = ? and idMateria=? and idEstudiante=? limit 1");
			ps.setInt(1, idProfesor);
			ps.setInt(2, idMateria);
			ps.setInt(3, idEstudiante);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				v = getEntidadFromResulSet(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return v;
	}
	
	
	
	
	
	private static ValoracionMateria getEntidadFromResulSet(ResultSet rs) throws SQLException {
		
		ValoracionMateria o = new ValoracionMateria();

		o.setId(rs.getInt("id"));
		o.setIdEstudiante(rs.getInt("idEstudiante"));
		o.setIdMateria(rs.getInt("idMateria"));
		o.setIdProfesor(rs.getInt("idProfesor"));
		o.setValoracion(rs.getFloat("valoracion"));
		
		return o;
	}
	

	
	
	public static void insercion (ValoracionMateria o, Connection conn) {
		int nuevoId = SuperControlador.maxIdEnTabla(nombreTabla);
		if (o != null) {
			try {
				PreparedStatement ps = conn.prepareStatement(""+ "insert into " + nombreTabla + "(id, idProfesor, idEstudiante, idMateria, valoracion) "
			+ "values (?, ?, ? , ? , ?)");
				ps.setInt(1, nuevoId);
				ps.setInt(2, o.getIdProfesor());
				ps.setInt(3, o.getIdEstudiante());
				ps.setInt(4, o.getIdMateria());
				ps.setFloat(5, o.getValoracion());
				ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	
	public static void modificacion (ValoracionMateria  o, Connection conn) {
		if (o != null) {
			try {
				
				PreparedStatement ps = conn.prepareStatement(""+ "update " + nombreTabla + " set valoracion=? where  idProfesor = ? and idEstudiante=? and idMateria=?");
				ps.setFloat(1, o.getValoracion());
				ps.setInt(2, o.getIdProfesor());
				ps.setInt(3, o.getIdEstudiante());
				ps.setInt(4, o.getIdMateria());

				ps.execute();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	

	
	
	
	
	
	
	
	

}
