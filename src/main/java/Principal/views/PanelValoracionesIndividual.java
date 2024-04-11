package Principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import capitulo08.centroEducativo.controladores.ConnectionManager;
import capitulo08.centroEducativo.controladores.ControladorValoracionMateria;
import capitulo08.centroEducativo.entidades.Estudiante;
import capitulo08.centroEducativo.entidades.Materia;
import capitulo08.centroEducativo.entidades.Profesor;
import capitulo08.centroEducativo.entidades.ValoracionMateria;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.SQLException;

public class PanelValoracionesIndividual extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTextField jtfNota;
	public JLabel lblNombre;
	private Materia materia;
	private Profesor profesor;
	private Estudiante estudiante;

	/**
	 * Create the panel.
	 */
	public PanelValoracionesIndividual(Profesor p, Estudiante e, Materia m) {
		
		this.profesor = p;
		this.estudiante = e;
		this.materia = m;
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNombre = new JLabel("New label");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);

		jtfNota = new JTextField();
		GridBagConstraints gbc_jtfNota = new GridBagConstraints();
		gbc_jtfNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNota.gridx = 1;
		gbc_jtfNota.gridy = 0;
		add(jtfNota, gbc_jtfNota);
		jtfNota.setColumns(10);
		this.lblNombre.setText(this.estudiante.getNombre() + " " + this.estudiante.getApellido_1() + " " + this.estudiante.getApellido_2());
		cargarNotaActual();
	}
	/**
	 * 
	 */
	private void cargarNotaActual(){
		ValoracionMateria v = ControladorValoracionMateria.findByIdMateriaAndIdProfesorAndIdEstudiante(this.materia.getId(), this.profesor.getId(), this.estudiante.getId());
		if (v != null) {
			this.jtfNota.setText("" + v.getValoracion());
		}
	}
	
	
	public void guardarNota() {
	    try {
	        Connection conn = ConnectionManager.getConexion();
	        ValoracionMateria v = ControladorValoracionMateria.findByIdMateriaAndIdProfesorAndIdEstudiante(this.materia.getId(), this.profesor.getId(), this.estudiante.getId());
	        if (v != null) {
	            // Si la valoración ya existe, actualiza la valoración existente
	            v.setValoracion(Float.parseFloat(this.jtfNota.getText()));
	            ControladorValoracionMateria.modificacion(v, conn);
	        } else {
	            // Si la valoración no existe, crea una nueva
	            v = new ValoracionMateria();
	            v.setIdMateria(this.materia.getId());
	            v.setIdProfesor(this.profesor.getId());
	            v.setIdEstudiante(this.estudiante.getId());
	            v.setValoracion(Float.parseFloat(this.jtfNota.getText()));
	            ControladorValoracionMateria.insercion(v, conn);
	        }
	    } catch (SQLException e) {
	        // Manejo de la excepción
	        e.printStackTrace();
	    }
	}


	
	
	

}
