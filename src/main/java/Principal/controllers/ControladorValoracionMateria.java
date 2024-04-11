package Principal.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Principal.entities.Estudiante;
import Principal.entities.Materia;
import Principal.entities.Profesor;
import Principal.entities.ValoracionMateria;


public class ControladorValoracionMateria {

	private static String nombreTabla = "valoracionmateria";
	private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();

	

	public static ValoracionMateria obtenerValoracion(Profesor p, Estudiante e, Materia m ) {

		TypedQuery<ValoracionMateria> q = 
				em.createQuery("SELECT v FROM " + nombreTabla + " v  where v.profesor.id = "+  String.valueOf(p.getId()) + " and v.materia.id =  " + String.valueOf(m.getId()) + " and v.estudiante.id = " + String.valueOf(e.getId()) , ValoracionMateria.class);
		ValoracionMateria valoracionQuery = (ValoracionMateria) q.getSingleResult();
		
		if (valoracionQuery != null) {
			return valoracionQuery;
		}
		return null;
		
	}
	
//	public static void insert(Profesor p, Estudiante e, Materia m, Integer valoracion ) {
//		
//		Query q = em.createNativeQuery("insert into " + nombreTabla + "(idProfesor, idEstudiante, idMateria, valoracion) values (" + p.getId() + ", " + e.getId() +" , " + m.getId() + " , "+ valoracion + ")");
//		q.executeUpdate();
//		
//	}
	
	public static void insert(Profesor p, Estudiante e, Materia m, Integer valoracion) {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        Query q = em.createNativeQuery("INSERT INTO " + nombreTabla + "(idProfesor, idEstudiante, idMateria, valoracion) VALUES (?, ?, ?, ?)");
	        q.setParameter(1, p.getId());
	        q.setParameter(2, e.getId());
	        q.setParameter(3, m.getId());
	        q.setParameter(4, valoracion);
	        q.executeUpdate();
	        tx.commit();
	    } catch (Exception ex) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        ex.printStackTrace(); // Manejo adecuado de la excepción, puedes cambiar esto según tus necesidades
	    }
	}


	public static void update(ValoracionMateria v, Integer valoracion) {
		Query q = em.createNativeQuery("update " + nombreTabla + " set valoracion = " + valoracion + " where id = " + String.valueOf(v.getId()));
		q.executeUpdate();
	}
	
	
	
	
	
	

}
