package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Principal.entities.Profesor;


public class ControladorProfesor {
	private static String nombreTabla = "profesor";
	private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();

	
	
	
	public static List<Profesor> getTodos () {
		
		
		Query q = em.createNativeQuery("SELECT * FROM " + nombreTabla + ";", Profesor.class);
		
		List<Profesor> materias = (List<Profesor>) q.getResultList();
		
		return materias;
		
	}
	
	
	
	
	
}
