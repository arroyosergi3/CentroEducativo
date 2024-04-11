package Principal.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import capitulo08.centroEducativo.controladores.ConnectionManager;

import capitulo08.centroEducativo.controladores.ControladorProfesor;

import capitulo08.centroEducativo.entidades.Profesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelProfesor extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelProfesor() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		this.panelDatos.setRunnableMostrarPrimerRegistro(new Runnable() {
			@Override
			public void run() {
				mostrarPrimero();
			}
		});

		this.panelDatos.setRunnableMostrarAnteriorRegistro(new Runnable() {

			@Override
			public void run() {
				mostrarAnterior();

			}
		});

		this.panelDatos.setRunnableMostrarSiguienteRegistro(new Runnable() {

			@Override
			public void run() {
				mostrarSiguiente();

			}
		});

		this.panelDatos.setRunnableMostrarUltimoRegistro(new Runnable() {

			@Override
			public void run() {
				mostrarUltimo();

			}
		});

		this.panelDatos.setRunnableMostrarAnteriorRegistro(new Runnable() {

			@Override
			public void run() {
				mostrarAnterior();

			}
		});

		this.panelDatos.setRunnableGuardar(new Runnable() {

			@Override
			public void run() {
				guardar();

			}
		});

		this.panelDatos.setRunnableBorrar(new Runnable() {

			@Override
			public void run() {
				try {
					borrar(Integer.parseInt(panelDatos.getJtfId().getText()), ConnectionManager.getConexion());
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mostrarPrimero();
		panelDatos.mostrarMenu();
		
	}

	
	private void mostrarPrimero() {
		// En teoría aquí se produce una llamada a un controlador de estudiante
		// que obtiene un objeto de tipo estudiante y que lo envía para ser
		// mostrado
		Profesor mockEstudiante = new Profesor();
		mockEstudiante = ControladorProfesor.getPrimero();
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarAnterior() {

		Profesor mockEstudiante = new Profesor();
		mockEstudiante = ControladorProfesor.getFabricanteSiguienteAnterior(panelDatos.getId() - 1);
		mostrarEntidad(mockEstudiante);

	}

	private void mostrarSiguiente() {

		Profesor mockEstudiante = new Profesor();
		mockEstudiante = ControladorProfesor.getFabricanteSiguienteAnterior(panelDatos.getId() + 1);
		mostrarEntidad(mockEstudiante);

	}

	private void mostrarUltimo() {
		Profesor mockEstudiante = new Profesor();
		mockEstudiante = ControladorProfesor.getUltimo();
		mostrarEntidad(mockEstudiante);
	}

	
	
	private void mostrarEntidad(Profesor e) {
		
		
		this.panelDatos.setId(e.getId());
		this.panelDatos.setNombre(e.getNombre());
		this.panelDatos.setAp1(e.getApellido_1());
		this.panelDatos.setAp2(e.getApellido_2());
		this.panelDatos.setDni(e.getDni());
		this.panelDatos.setDire(e.getDireccion());
		this.panelDatos.setMail(e.getMail());
		this.panelDatos.setTlf(e.getTelefono());
		for (int i = 0; i < this.panelDatos.getJcbSexo().getItemCount(); i++) {
			if (this.panelDatos.getJcbSexo().getItemAt(i).getId() == e.getIdSexo()) {
			this.panelDatos.getJcbSexo().setSelectedIndex(i);
			}
			}
		
		this.panelDatos.setImagen(e.getImagen());
		this.panelDatos.setColorFAvorito(e.getColorFavorito());
		setBackground();
		this.panelDatos.mostrarMenu();

	}
	
	private void setBackground() {
		if (!this.panelDatos.getJtfColorPreferido().getText().isBlank()) {
			Color color = Color.decode(this.panelDatos.getJtfColorPreferido().getText());
			this.panelDatos.panel.setBackground(color);
		} else {
			this.panelDatos.panel.setBackground(Color.WHITE);
		}
	}
	
	
	
		
		
		
	
	
	private void guardar() {
		
		
		
		try {
			Profesor o = new Profesor();
			o.setId(-1);
			if(!this.panelDatos.getJtfId().getText().trim().equals("")){
				o.setId(Integer.parseInt(this.panelDatos.getJtfId().getText()));
			}
			o.setNombre(this.panelDatos.getJtfNombre().getText());
			o.setDni(this.panelDatos.getJtfDni().getText());
			o.setApellido_1(this.panelDatos.getJtfPrimApe().getText());
			o.setApellido_2(this.panelDatos.getJtfSegApe().getText());
			o.setDireccion(this.panelDatos.getJtfDireccion().getText());
			o.setMail(this.panelDatos.getJtfEmail().getText());
			o.setTelefono(this.panelDatos.getJtfTelefono().getText());
			o.setIdSexo(this.panelDatos.getSexo());
			o.setImagen(this.panelDatos.getImagen());
			o.setColorFavorito(this.panelDatos.GetColorFavorito());
			
			
			Connection conn = ConnectionManager.getConexion();
			if(o.getId() == -1) {
				int nuevoId = ControladorProfesor.insercion(o, conn);
				this.panelDatos.getJtfId().setText(""+nuevoId);
				JOptionPane.showMessageDialog(null, "Registro nuevo guardado con éxito");
				
			}
			
			else {
				ControladorProfesor.modificacion(o, conn);
				JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	public static void borrar (int id, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "delete from profesor where id = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Registro borrado con éxtito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	
}






