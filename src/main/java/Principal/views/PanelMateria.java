package Principal.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import Principal.controllers.ControladorMateria;
import Principal.entities.Curso;
import Principal.entities.Materia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.awt.event.ActionEvent;

public class PanelMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfAcr;
	private JTextField jtfNombre;
	private JComboBox<Curso> jcbCurso;

	/**
	 * Create the panel.
	 */
	public PanelMateria() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrincipio = new JButton("");
		btnPrincipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnPrincipio.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrincipio);
		
		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnAtras.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		toolBar.add(btnAtras);
		
		JButton btnAlante = new JButton("");
		btnAlante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnAlante.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		toolBar.add(btnAlante);
		
		JButton btnFinal = new JButton("");
		btnFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		btnFinal.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnFinal);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNew.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNew);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnSave.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/guardar.png")));
		toolBar.add(btnSave);
		
		JButton btnDel = new JButton("");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnDel.setIcon(new ImageIcon(PanelMateria.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnDel);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{92, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestinMateria = new JLabel("Gestión Materia");
		GridBagConstraints gbc_lblGestinMateria = new GridBagConstraints();
		gbc_lblGestinMateria.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinMateria.gridwidth = 2;
		gbc_lblGestinMateria.gridx = 0;
		gbc_lblGestinMateria.gridy = 0;
		panel.add(lblGestinMateria, gbc_lblGestinMateria);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.anchor = GridBagConstraints.EAST;
		gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurso.gridx = 0;
		gbc_lblCurso.gridy = 2;
		panel.add(lblCurso, gbc_lblCurso);
		
		jcbCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 2;
		panel.add(jcbCurso, gbc_jcbCurso);
		
		
		JLabel lblAcrnimo = new JLabel("Acrónimo:");
		GridBagConstraints gbc_lblAcrnimo = new GridBagConstraints();
		gbc_lblAcrnimo.anchor = GridBagConstraints.EAST;
		gbc_lblAcrnimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcrnimo.gridx = 0;
		gbc_lblAcrnimo.gridy = 3;
		panel.add(lblAcrnimo, gbc_lblAcrnimo);
		
		jtfAcr = new JTextField();
		GridBagConstraints gbc_jtfAcr = new GridBagConstraints();
		gbc_jtfAcr.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcr.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcr.gridx = 1;
		gbc_jtfAcr.gridy = 3;
		panel.add(jtfAcr, gbc_jtfAcr);
		jtfAcr.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 4;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		cargarPrimero();
		cargarTodosCursos();
		
		
	}
	
	
	
	private void cargarPrimero() {
		Materia o = ControladorMateria.getPrimero();
		muestraEnPantalla(o);
	}
	
	private void cargarAnterior() {
		Materia o = ControladorMateria.getFabricanteSiguienteAnterior((Integer.parseInt(jtfId.getText())-1));
		muestraEnPantalla(o);
	}
	private void cargarSiguiente(){
		Materia o = ControladorMateria.getFabricanteSiguienteAnterior((Integer.parseInt(jtfId.getText())+1));
		muestraEnPantalla(o);
	}
	
	private void cargarUltimo() {
		Materia o = ControladorMateria.getUltimo();
		muestraEnPantalla(o);
				
	}
	
	
	
	private void muestraEnPantalla(Materia o) {
		if(o != null) {
			this.jtfId.setText(""+ o.getId());

			for (int i = 0; i < jcbCurso.getItemCount(); i++) {
				if(jcbCurso.getItemAt(i).getId() == o.getCursoID()) {
					jcbCurso.setSelectedIndex(i);
					
				}
			}
			
			this.jtfAcr.setText(o.getAcronimo());
			this.jtfNombre.setText(o.getNombre());
		}
		
	}
	
	
	private void cargarTodosCursos() {
		List <Curso> l = ControladorCurso.getTodos();
		for(Curso o : l) {
			jcbCurso.addItem(o);
		}
		
		
	}

	private void nuevo() {
		jtfId.setText("");
		jtfNombre.setText("");
		jtfAcr.setText("");
		
	}
	

	private void guardar() {
		
		
		
		try {
			Materia o = new Materia();
			o.setId(-1);
			if(!this.jtfId.getText().trim().equals("")){
				o.setId(Integer.parseInt(this.jtfId.getText()));
			}
			o.setNombre(this.jtfNombre.getText());
			o.setAcronimo(this.jtfAcr.getText());
			o.setCursoID(1);
			
			
			Connection conn = ConnectionManager.getConexion();
			if(o.getId() == -1) {
				int nuevoId = ControladorMateria.insercion(o, conn);
				jtfId.setText(""+nuevoId);
			}
			
			else {
				ControladorMateria.modificacion(o, conn);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	private void eliminar () {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de Materia", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {
		    	  int id = Integer.parseInt(this.jtfId.getText());
		    	  ControladorMateria.eliminacion(id, ConnectionManager.getConexion());
		    	 
		    	  
		    	  
		    	  Materia cursoAMostrar = ControladorMateria.getFabricanteSiguienteAnterior((id - 1));
		    	  if(cursoAMostrar != null) {
		    		  cargaMateriaEnPantalla(cursoAMostrar);
		    	  }
		    	  else {
		    		  cursoAMostrar =  ControladorMateria.getFabricanteSiguienteAnterior((id + 1));
		    		  if (cursoAMostrar != null) {
		    			  cargaMateriaEnPantalla(null);
					} else {
						nuevo();
					}
		    	  }
		      }
		    }			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	
	
	private void cargaMateriaEnPantalla(Materia o) {
		if( o != null) {
			jtfId.setText("" + o.getId());
			jtfNombre.setText("" + o.getNombre() );
			

	}
	}
	
	
	
	
	
	
	
	
	
}
