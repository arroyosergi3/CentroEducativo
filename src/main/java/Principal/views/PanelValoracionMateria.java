package Principal.views;

import javax.swing.JPanel;

import capitulo08.centroEducativo.controladores.ControladorEstudiantes;
import capitulo08.centroEducativo.controladores.ControladorMateria;
import capitulo08.centroEducativo.controladores.ControladorProfesor;
import capitulo08.centroEducativo.controladores.ControladorValoracionMateria;
import capitulo08.centroEducativo.entidades.Estudiante;
import capitulo08.centroEducativo.entidades.Materia;
import capitulo08.centroEducativo.entidades.Profesor;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class PanelValoracionMateria extends JPanel {

	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JPanel panel_1;
	private List<PanelValoracionesIndividual> l = new ArrayList<PanelValoracionesIndividual>();
	JPanel panelEstudiantes;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelValoracionMateria() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel jlblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_jlblMateria = new GridBagConstraints();
		gbc_jlblMateria.anchor = GridBagConstraints.EAST;
		gbc_jlblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jlblMateria.gridx = 0;
		gbc_jlblMateria.gridy = 0;
		panel.add(jlblMateria, gbc_jlblMateria);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);

		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JButton btnRefrescarAlumnado = new JButton("Boton Refrescar Alumnado");
		btnRefrescarAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarAlumnado();
			}
		});
		GridBagConstraints gbc_btnRefrescarAlumnado = new GridBagConstraints();
		gbc_btnRefrescarAlumnado.gridx = 2;
		gbc_btnRefrescarAlumnado.gridy = 1;
		panel.add(btnRefrescarAlumnado, gbc_btnRefrescarAlumnado);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_2.add(btnGuardar);

		panelEstudiantes = new JPanel();
		panel_1.add(panelEstudiantes, BorderLayout.CENTER);
		panelEstudiantes.setLayout(new BoxLayout(panelEstudiantes, BoxLayout.Y_AXIS));

		cargarTodasMaterias();
		cargarTodosProfesores();

	}

	private void cargarTodosProfesores() {
		List<Profesor> l = ControladorProfesor.getTodos();
		for (Profesor o : l) {
			jcbProfesor.addItem(o);
		}
	}

	private void cargarTodasMaterias() {
		List<Materia> l = ControladorMateria.getTodos();
		for (Materia o : l) {
			jcbMateria.addItem(o);
		}

	}

	private void refrescarAlumnado() {
		List<Estudiante> estudiantes = ControladorEstudiantes.getTodos();
		Profesor profSeleccionado = (Profesor) this.jcbProfesor.getSelectedItem();
		Materia matSeleccionada = (Materia) this.jcbMateria.getSelectedItem();
		this.panelEstudiantes.removeAll();
		this.l.clear();

		for (Estudiante estudiante : estudiantes) {
			PanelValoracionesIndividual panel = new PanelValoracionesIndividual(profSeleccionado, estudiante, matSeleccionada);
			this.panelEstudiantes.add(panel);
			l.add(panel);
		}
		this.panelEstudiantes.revalidate();
		this.panelEstudiantes.repaint();
	}

	// GUARDAR
	// Cuando se crea el panel individual;
	// comprobar si existe nota, hacer insert o modificacion.
	private void guardar() {
		for (PanelValoracionesIndividual panelValoracionesIndividual : this.l) {
			panelValoracionesIndividual.guardarNota();
		}
		JOptionPane.showMessageDialog(null, "Registros guardados con éxtio");
	}

}
