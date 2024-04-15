package Principal.views;

import javax.swing.JPanel;

import Principal.controllers.ControladorEstudiantes;
import Principal.controllers.ControladorMateria;
import Principal.controllers.ControladorProfesor;
import Principal.controllers.ControladorValoracionMateria;
import Principal.controllers.SuperControlador;
import Principal.entities.Estudiante;
import Principal.entities.Materia;
import Principal.entities.Profesor;
import Principal.entities.ValoracionMateria;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelNotaJPA extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JList <Estudiante>listSeleccionados;
	private JList <Estudiante>listNOSeleccionados;
	private DefaultListModel<Estudiante> listModelNOSeleccionados;
	private DefaultListModel<Estudiante> listModelSeleccionados ;

	private JComboBox <Materia>jcbMateria;
	private JComboBox <Profesor>jcbProfesor;
	private JComboBox <Integer>jcbNota;

	/**
	 * Create the panel.
	 */
	public PanelNotaJPA() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		 jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		 jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota:");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);
		
		 jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizarAlumnado = new JButton("Actualizar Alumnado");
		btnActualizarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarAlumnado();
			}
		});
		GridBagConstraints gbc_btnActualizarAlumnado = new GridBagConstraints();
		gbc_btnActualizarAlumnado.gridx = 1;
		gbc_btnActualizarAlumnado.gridy = 3;
		panel.add(btnActualizarAlumnado, gbc_btnActualizarAlumnado);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnGuardarNotaAlumnos = new JButton("Guardar Nota Alumnos Seleccionados");
		btnGuardarNotaAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_1.add(btnGuardarNotaAlumnos);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblAlumnosNoSeleccionados = new JLabel("Alumnos NO Seleccionados");
		GridBagConstraints gbc_lblAlumnosNoSeleccionados = new GridBagConstraints();
		gbc_lblAlumnosNoSeleccionados.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlumnosNoSeleccionados.gridx = 0;
		gbc_lblAlumnosNoSeleccionados.gridy = 0;
		panel_2.add(lblAlumnosNoSeleccionados, gbc_lblAlumnosNoSeleccionados);
		
		JLabel lblAlumnosSeleccionados = new JLabel("Alumnos Seleccionados");
		GridBagConstraints gbc_lblAlumnosSeleccionados = new GridBagConstraints();
		gbc_lblAlumnosSeleccionados.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlumnosSeleccionados.gridx = 4;
		gbc_lblAlumnosSeleccionados.gridy = 0;
		panel_2.add(lblAlumnosSeleccionados, gbc_lblAlumnosSeleccionados);
		
		 listNOSeleccionados = new JList(this.getListModelNOSeleccionados());
		GridBagConstraints gbc_listNOSeleccionados = new GridBagConstraints();
		gbc_listNOSeleccionados.insets = new Insets(0, 0, 0, 5);
		gbc_listNOSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_listNOSeleccionados.gridx = 0;
		gbc_listNOSeleccionados.gridy = 1;
		panel_2.add(listNOSeleccionados, gbc_listNOSeleccionados);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnPasarTodos = new JButton(">>");
		btnPasarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodosASeleccionados();
			}
		});
		GridBagConstraints gbc_btnPasarTodos = new GridBagConstraints();
		gbc_btnPasarTodos.insets = new Insets(0, 0, 5, 5);
		gbc_btnPasarTodos.gridx = 1;
		gbc_btnPasarTodos.gridy = 0;
		panel_3.add(btnPasarTodos, gbc_btnPasarTodos);
		
		JButton btnPasar1 = new JButton(">");
		btnPasar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarUnoASeleccionado();
			}
		});
		GridBagConstraints gbc_btnPasar1 = new GridBagConstraints();
		gbc_btnPasar1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPasar1.gridx = 1;
		gbc_btnPasar1.gridy = 1;
		panel_3.add(btnPasar1, gbc_btnPasar1);
		
		JButton btnQuitar1 = new JButton("<");
		btnQuitar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarUnoDeSeleccionado();
			}
		});
		GridBagConstraints gbc_btnQuitar1 = new GridBagConstraints();
		gbc_btnQuitar1.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitar1.gridx = 1;
		gbc_btnQuitar1.gridy = 2;
		panel_3.add(btnQuitar1, gbc_btnQuitar1);
		
		JButton btnQuitarTodos = new JButton("<<");
		btnQuitarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarTodosDeSeleccionados();
			}
		});
		GridBagConstraints gbc_btnQuitarTodos = new GridBagConstraints();
		gbc_btnQuitarTodos.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitarTodos.gridx = 1;
		gbc_btnQuitarTodos.gridy = 3;
		panel_3.add(btnQuitarTodos, gbc_btnQuitarTodos);
		
		 listSeleccionados = new JList(this.getListModelSeleccionados());
		GridBagConstraints gbc_listSeleccionados = new GridBagConstraints();
		gbc_listSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_listSeleccionados.gridx = 4;
		gbc_listSeleccionados.gridy = 1;
		panel_2.add(listSeleccionados, gbc_listSeleccionados);
		cargarTodasMaterias();
		cargarTodosProfesores();
		cargarNotas();
	}
	
	
	private void guardar(){
	

		List<Estudiante> estudiantes = getEstudiantesSeleccionados();
		if (estudiantes != null) {

			for (Estudiante estudiante : estudiantes) {
				
				if (SuperControlador.obtenerValoracionSinNota(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem()) == null) {
					ControladorValoracionMateria.insert(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem(), (Integer)this.jcbNota.getSelectedItem());
				}
				else {
					ControladorValoracionMateria.update(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem(), (Integer)this.jcbNota.getSelectedItem());;
				}
			}
			
			
		}

		
		
	}
	
	private List<Estudiante> getEstudiantesSeleccionados() {
		
		List<Estudiante> l = new ArrayList<Estudiante>();
		for (int i = 0; i < this.listModelSeleccionados.size(); i++) {
			Estudiante e = this.listModelSeleccionados.get(i);
			System.out.println(e.getNombre());
			l.add(this.listModelSeleccionados.get(i));
		}
		
		return l;
	}
	
	private void pasarUnoASeleccionado() {
		Estudiante selectedEstudiante = null;
		int selectedIndex = listNOSeleccionados.getSelectedIndex();

		// Verifica si hay algún elemento seleccionado
		if (selectedIndex != -1) {
		    // Obten el objeto correspondiente del DefaultListModel
		     selectedEstudiante = listModelNOSeleccionados.getElementAt(selectedIndex);
		    
		    // Ahora puedes manipular el objeto seleccionado como desees
		} 
		
		listModelSeleccionados.addElement(selectedEstudiante);
		listModelNOSeleccionados.remove(selectedIndex);

	}
	private void quitarUnoDeSeleccionado() {
		Estudiante selectedEstudiante = null;
		int selectedIndex = listSeleccionados.getSelectedIndex();

		// Verifica si hay algún elemento seleccionado
		if (selectedIndex != -1) {
		    // Obten el objeto correspondiente del DefaultListModel
		     selectedEstudiante = listModelSeleccionados.getElementAt(selectedIndex);
		    
		    // Ahora puedes manipular el objeto seleccionado como desees
		} 
		
		listModelNOSeleccionados.addElement(selectedEstudiante);
		listModelSeleccionados.remove(selectedIndex);

	}
	
	private void pasarTodosASeleccionados() {
		
		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudiantes.getInstance().findAll();

		for (Estudiante estudiante : estudiantes) {
			this.listModelSeleccionados.addElement(estudiante);
		}
		
		this.listModelNOSeleccionados.removeAllElements();
	}
	
	private void quitarTodosDeSeleccionados() {
	
		
		this.listModelSeleccionados.removeAllElements();
		actualizarAlumnado();
	}
	
	
	
	private void cargarNotas() {
		jcbNota.addItem(Integer.parseInt("0"));
		jcbNota.addItem(Integer.parseInt("1"));
		jcbNota.addItem(Integer.parseInt("2"));
		jcbNota.addItem(Integer.parseInt("3"));
		jcbNota.addItem(Integer.parseInt("4"));
		jcbNota.addItem(Integer.parseInt("5"));
		jcbNota.addItem(Integer.parseInt("6"));
		jcbNota.addItem(Integer.parseInt("7"));
		jcbNota.addItem(Integer.parseInt("8"));
		jcbNota.addItem(Integer.parseInt("9"));
		jcbNota.addItem(Integer.parseInt("10"));

	}
	
	private void cargarTodasMaterias() {
		List<Materia> l = (List<Materia>) new ControladorMateria().getInstance().findAll();
		for (Materia o : l) {
			jcbMateria.addItem(o);
		}

	}
	
	private void cargarTodosProfesores() {
		List<Profesor> l = (List<Profesor>) new ControladorProfesor().getInstance().findAll();
		for (Profesor o : l) {
			jcbProfesor.addItem(o);
		}

	}
	
	
	private void actualizarAlumnado(){
		this.listModelNOSeleccionados.clear();
		this.listModelSeleccionados.clear();
		
		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudiantes.getInstance().findAll();

		for (Estudiante estudiante : estudiantes) {
			if (SuperControlador.obtenerValoracion(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem(), (Integer)this.jcbNota.getSelectedItem() ) != null) {
				this.listModelSeleccionados.addElement(estudiante);
			}
			else {
				this.listModelNOSeleccionados.addElement(estudiante);

			}
		}
		
	}

	public DefaultListModel<Estudiante> getListModelNOSeleccionados() {
		if(this.listNOSeleccionados == null) {
			this.listModelNOSeleccionados = new DefaultListModel<Estudiante>();

		}
		return listModelNOSeleccionados;
	}


	public DefaultListModel<Estudiante> getListModelSeleccionados() {
		if (this.listModelSeleccionados == null) {
			this.listModelSeleccionados = new DefaultListModel<Estudiante>();

		}
		return listModelSeleccionados;
	}


	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
