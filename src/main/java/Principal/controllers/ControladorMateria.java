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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Principal.entities.Materia;


public class ControladorMateria extends SuperControlador{

private static String nombreTabla = "materia";
private static EntityManager em =  Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();


	
	public static Materia getFabricanteSiguienteAnterior(int id) {

		return null;
	}
	
	
	
	public static List<Materia> getTodos () {
		
		
		Query q = em.createNativeQuery("SELECT * FROM " + nombreTabla + ";", Materia.class);
		
		List<Materia> materias = (List<Materia>) q.getResultList();
		
		return materias;
		
	}
	
	
	
	
	
	
	
}
