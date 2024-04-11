package Principal.views;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import capitulo08.centroEducativo.controladores.ConnectionManager;

import capitulo08.centroEducativo.controladores.ControladorEstudiantes;
import capitulo08.centroEducativo.entidades.Estudiante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		panelDatos.getJcbSexo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		this.add(panelDatos, BorderLayout.CENTER);
		mostrarPrimero();

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

		
		
		panelDatos.mostrarMenu();
	}

	private void mostrarPrimero() {
		// En teoría aquí se produce una llamada a un controlador de estudiante
		// que obtiene un objeto de tipo estudiante y que lo envía para ser
		// mostrado
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiantes.getPrimero();
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarAnterior() {

		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiantes.getFabricanteSiguienteAnterior(panelDatos.getId() - 1);
		mostrarEntidad(mockEstudiante);

	}

	private void mostrarSiguiente() {

		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiantes.getFabricanteSiguienteAnterior(panelDatos.getId() + 1);
		mostrarEntidad(mockEstudiante);

	}

	private void mostrarUltimo() {
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiantes.getUltimo();
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarEntidad(Estudiante e) {

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
			Estudiante o = new Estudiante();
			o.setId(-1);
			if (!this.panelDatos.getJtfId().getText().trim().equals("")) {
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
			if (o.getId() == -1) {
				int nuevoId = ControladorEstudiantes.insercion(o, conn);
				this.panelDatos.getJtfId().setText("" + nuevoId);
				JOptionPane.showMessageDialog(null, "Registro nuevo guardado con éxito");

			}

			else {
				ControladorEstudiantes.modificacion(o, conn);
				JOptionPane.showMessageDialog(null, "Registro modificado con éxito");

			}
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar o modificar el registro");
			e.printStackTrace();
		}

	}

	public static void borrar(int id, Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement("" + "delete from estudiante where id = ?");
			ps.setInt(1, id);

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Registro borrado con éxtito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
