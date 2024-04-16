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


public class ControladorValoracionMateria extends SuperControlador{

	public ControladorValoracionMateria() {
		super("valoracionmateria", ValoracionMateria.class);
	}	

}
