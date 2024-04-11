package Principal;

import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import Principal.views.PanelCurso;
import Principal.views.PanelEstudiante;
import Principal.views.PanelMateria;
import Principal.views.PanelNotaJPA;
import Principal.views.PanelProfesor;
import Principal.views.PanelValoracionMateria;
import Principal.views.PanelValoracionesIndividual;


public class Principal extends JFrame{

	static Principal instance = null;

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	JTabbedPane panelTabbed;
	PanelCurso panelCurso;
	PanelMateria panelMateria;
	PanelEstudiante panelEstudiante;
	PanelProfesor panelProfesor;
	PanelValoracionesIndividual panelValoracionMateria;
	PanelNotaJPA panelNotaJPA;
	
	public PanelCurso getPanelCurso() {
		return panelCurso;
	}





	public void setPanelCurso(PanelCurso panelCurso) {
		this.panelCurso = panelCurso;
	}





	public PanelMateria getPanelMateria() {
		return panelMateria;
	}





	public void setPanelMateria(PanelMateria panelMateria) {
		this.panelMateria = panelMateria;
	}





	public PanelEstudiante getPanelEstudiante() {
		return panelEstudiante;
	}





	public void setPanelEstudiante(PanelEstudiante panelEstudiante) {
		this.panelEstudiante = panelEstudiante;
	}





	public PanelProfesor getPanelProfesor() {
		return panelProfesor;
	}





	public void setPanelProfesor(PanelProfesor panelProfesor) {
		this.panelProfesor = panelProfesor;
	}





	public void setPanelTabbed(JTabbedPane panelTabbed) {
		this.panelTabbed = panelTabbed;
	}





	public Principal() {
		super("Gestion de centro Educativo");
		this.setBounds(0,0,800,600);

		panelNotaJPA = new PanelNotaJPA();
		
		panelTabbed = new JTabbedPane();
		
//		 panelCurso = new PanelCurso();
//		 panelMateria = new PanelMateria();
//		 panelEstudiante = new PanelEstudiante();
//		 panelProfesor = new PanelProfesor();
//		 panelValoracionMateria = new PanelValoracionMateria();
//		Menu menu = new Menu();
		
//		panelTabbed.addTab("Cursos", panelCurso);
//		panelTabbed.addTab("Materias", panelMateria);
//		panelTabbed.addTab("Estudiantes", panelEstudiante);
//		panelTabbed.addTab("Profesores", panelProfesor);
//		panelTabbed.addTab("Valoración Materia", panelValoracionMateria);
		
		
//		this.setJMenuBar(menu);
		
//		panelTabbed.setSelectedIndex(0);
		
		this.getContentPane().add(panelTabbed);
		panelTabbed.addTab("Nota JPA", panelNotaJPA);
	}
	
	
	
	
	
	public JTabbedPane getPanelTabbed() {
		return panelTabbed;
	}





	public static void main(String[] args) {

		Principal.getInstance().setVisible(true);
		
	}

}
