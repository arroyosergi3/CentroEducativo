package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Principal.entities.Estudiante;
import Principal.entities.Materia;



public class ControladorEstudiantes {

	private static String nombreTabla = "estudiante";
	private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();

	

	public static List<Estudiante> getTodos () {
		
		
		Query q = em.createNativeQuery("SELECT * FROM " + nombreTabla + ";", Estudiante.class);
		
		List<Estudiante> materias = (List<Estudiante>) q.getResultList();
		
		return materias;
		
	}
	

	
	
	
	
	
	
	
	
	
}
