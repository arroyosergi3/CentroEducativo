package Principal;

import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;


import Principal.views.PanelNotaJPA;



public class Principal extends JFrame{

	static Principal instance = null;

	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	JTabbedPane panelTabbed;

	PanelNotaJPA panelNotaJPA;
	




	public void setPanelTabbed(JTabbedPane panelTabbed) {
		this.panelTabbed = panelTabbed;
	}





	public Principal() {
		super("Gestion de centro Educativo");
		this.setBounds(0,0,800,600);

		panelNotaJPA = new PanelNotaJPA();
		
		panelTabbed = new JTabbedPane();
		

		
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
