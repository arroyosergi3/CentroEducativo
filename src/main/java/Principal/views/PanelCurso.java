package Principal.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import Principal.controllers.ControladorCurso;
import Principal.entities.Curso;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;


import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JTextField;

public class PanelCurso extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDesc;

	/**
	 * Create the panel.
	 */
	public PanelCurso() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
				
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnDel = new JButton("");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnDel.setIcon(new ImageIcon(PanelCurso.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnDel);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{164, 122, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestinDeCurso = new JLabel("Gestión de Curso");
		GridBagConstraints gbc_lblGestinDeCurso = new GridBagConstraints();
		gbc_lblGestinDeCurso.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeCurso.gridx = 1;
		gbc_lblGestinDeCurso.gridy = 0;
		panel.add(lblGestinDeCurso, gbc_lblGestinDeCurso);
		
		JLabel lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
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
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 2;
		panel.add(lblDescripcin, gbc_lblDescripcin);
		
		jtfDesc = new JTextField();
		GridBagConstraints gbc_jtfDesc = new GridBagConstraints();
		gbc_jtfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDesc.gridx = 1;
		gbc_jtfDesc.gridy = 2;
		panel.add(jtfDesc, gbc_jtfDesc);
		jtfDesc.setColumns(10);
		cargarPrimero();

	}
	
	
	private void cargarPrimero() {
		Curso o = ControladorCurso.getPrimero();
		muestraEnPantalla(o);
	}
	
	private void cargarAnterior() {
		Curso o = ControladorCurso.getFabricanteSiguienteAnterior((Integer.parseInt(jtfId.getText())-1));
		muestraEnPantalla(o);
	}
	private void cargarSiguiente(){
		Curso o = ControladorCurso.getFabricanteSiguienteAnterior((Integer.parseInt(jtfId.getText())+1));
		muestraEnPantalla(o);
	}
	
	private void cargarUltimo() {
		Curso o = ControladorCurso.getUltimo();
		muestraEnPantalla(o);
				
	}
	
	
	
	private void muestraEnPantalla(Curso o) {
		this.jtfId.setText(""+ o.getId());
		this.jtfDesc.setText(""+ o.getDescripcion());
	}
	
	
	
	private void nuevo() {
		jtfId.setText("");
		jtfDesc.setText("");
		
	}
	
	
	private void guardar() {
		
		
		
		try {
			Curso o = new Curso();
			o.setId(-1);
			if(!this.jtfId.getText().trim().equals("")){
				o.setId(Integer.parseInt(this.jtfId.getText()));
			}
			o.setDescripcion(this.jtfDesc.getText());
			
			
			Connection conn = ConnectionManager.getConexion();
			if(o.getId() == -1) {
				int nuevoId = ControladorCurso.insercion(o, conn);
				jtfId.setText(""+nuevoId);
			}
			
			else {
				ControladorCurso.modificacion(o, conn);
				
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
					"Eliminación de Curso", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);
		    
			if(opcionElegida == 0) {
		      if (!this.jtfId.getText().trim().equals("")) {
		    	  int id = Integer.parseInt(this.jtfId.getText());
		    	  ControladorCurso.eliminacion(id, ConnectionManager.getConexion());
		    	 
		    	  
		    	  
		    	  Curso cursoAMostrar = ControladorCurso.getFabricanteSiguienteAnterior((id - 1));
		    	  if(cursoAMostrar != null) {
		    		  cargaCursoEnPantalla(cursoAMostrar);
		    	  }
		    	  else {
		    		  cursoAMostrar =  ControladorCurso.getFabricanteSiguienteAnterior((id + 1));
		    		  if (cursoAMostrar != null) {
		    			  cargaCursoEnPantalla(cursoAMostrar);
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

	
	private void cargaCursoEnPantalla(Curso o) {
		if( o != null) {
			jtfId.setText("" + o.getId());
			jtfDesc.setText("" + o.getDescripcion());
		}

	}
	
	
	
	

}
