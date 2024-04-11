package Principal.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import capitulo08.centroEducativo.controladores.ControladorSexo;
import capitulo08.centroEducativo.entidades.Sexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JLabel lblTitulo;
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableMostrarSiguienteRegistro;
	private Runnable runnableMostrarAnteriorRegistro;
	private Runnable runnableMostrarUltimoRegistro;
	private JTextField jtfPrimApe;
	private JTextField jtfSegApe;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Sexo> jcbSexo;
	private JScrollPane jspImagen;
	private JColorChooser jColorChooser;
	public JPanel panel;
	private int anchoImagen, altoImagen;
	private byte[] imagenEnArrayDeBytes;

	private JButton btnNuevo_1;
	private Runnable runnableGuardar;
	private Runnable runnableBorrar;
	private JTextField jtfColorPreferido;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarPrimerRegistro.run();
			}
		});
		btnPrimero.setIcon(new ImageIcon(
				PanelDatosPersonales.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotostart.png")));
		toolBar.add(btnPrimero);

		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarAnteriorRegistro.run();
			}
		});
		btnAnterior.setIcon(
				new ImageIcon(PanelDatosPersonales.class.getResource("/capitulo08/centroEducativo/res/previous.png")));
		toolBar.add(btnAnterior);

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarSiguienteRegistro.run();
			}
		});
		btnSiguiente.setIcon(
				new ImageIcon(PanelDatosPersonales.class.getResource("/capitulo08/centroEducativo/res/next.png")));
		toolBar.add(btnSiguiente);

		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarUltimoRegistro.run();
			}
		});
		btnUltimo.setIcon(new ImageIcon(
				PanelDatosPersonales.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/gotoend.png")));
		toolBar.add(btnUltimo);

		btnNuevo_1 = new JButton("");
		btnNuevo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				runnableNuevo.run();
				nuevo();
			}
		});
		btnNuevo_1.setIcon(new ImageIcon(
				PanelDatosPersonales.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/nuevo.png")));
		toolBar.add(btnNuevo_1);

		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGuardar.run();
			}
		});
		btnGuardar.setIcon(new ImageIcon(
				PanelDatosPersonales.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/guardar.png")));
		toolBar.add(btnGuardar);

		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableBorrar.run();
			}
		});
		btnEliminar.setIcon(new ImageIcon(
				PanelDatosPersonales.class.getResource("/tutorialJava/capitulo9_AWT_SWING/res/eliminar.png")));
		toolBar.add(btnEliminar);

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblTitulo = new JLabel("Título del componente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		jspImagen = new JScrollPane();

		JPopupMenu popupMenu = getPopUpMenu();
		popupMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				showPopup(e);
			}

			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});
		addPopup(jspImagen, popupMenu);
		GridBagConstraints gbc_jspImagen = new GridBagConstraints();
		gbc_jspImagen.gridheight = 4;
		gbc_jspImagen.insets = new Insets(0, 0, 5, 0);
		gbc_jspImagen.fill = GridBagConstraints.BOTH;
		gbc_jspImagen.gridx = 2;
		gbc_jspImagen.gridy = 1;
		panel.add(jspImagen, gbc_jspImagen);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 3;
		panel.add(lblPrimerApellido, gbc_lblPrimerApellido);

		jtfPrimApe = new JTextField();
		GridBagConstraints gbc_jtfPrimApe = new GridBagConstraints();
		gbc_jtfPrimApe.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrimApe.anchor = GridBagConstraints.NORTH;
		gbc_jtfPrimApe.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimApe.gridx = 1;
		gbc_jtfPrimApe.gridy = 3;
		panel.add(jtfPrimApe, gbc_jtfPrimApe);
		jtfPrimApe.setColumns(10);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 4;
		panel.add(lblSegundoApellido, gbc_lblSegundoApellido);

		jtfSegApe = new JTextField();
		GridBagConstraints gbc_jtfSegApe = new GridBagConstraints();
		gbc_jtfSegApe.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegApe.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegApe.gridx = 1;
		gbc_jtfSegApe.gridy = 4;
		panel.add(jtfSegApe, gbc_jtfSegApe);
		jtfSegApe.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 5;
		panel.add(lblSexo, gbc_lblSexo);

		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		panel.add(jcbSexo, gbc_jcbSexo);

		JButton btnFileChooser = new JButton("Seleccionar Imagen");
		btnFileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnFileChooser = new GridBagConstraints();
		gbc_btnFileChooser.insets = new Insets(0, 0, 5, 0);
		gbc_btnFileChooser.gridx = 2;
		gbc_btnFileChooser.gridy = 5;
		panel.add(btnFileChooser, gbc_btnFileChooser);

		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 6;
		panel.add(lblDni, gbc_lblDni);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 7;
		panel.add(lblDireccion, gbc_lblDireccion);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		panel.add(lblEmail, gbc_lblEmail);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 9;
		panel.add(lblTelefono, gbc_lblTelefono);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		jtfId.setEnabled(false);

		JLabel lblColorPreferido = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 0, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 10;
		panel.add(lblColorPreferido, gbc_lblColorPreferido);

		setJtfColorPreferido(new JTextField());
		GridBagConstraints gbc_jtfColorPreferido = new GridBagConstraints();
		gbc_jtfColorPreferido.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColorPreferido.gridx = 1;
		gbc_jtfColorPreferido.gridy = 10;
		panel.add(getJtfColorPreferido(), gbc_jtfColorPreferido);
		getJtfColorPreferido().setColumns(10);

		JButton btnCambiarColor = new JButton("Cambiar Color");
		btnCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnCambiarColor = new GridBagConstraints();
		gbc_btnCambiarColor.gridx = 2;
		gbc_btnCambiarColor.gridy = 10;
		panel.add(btnCambiarColor, gbc_btnCambiarColor);
		cargarTodosSexos();

	}

	public void mostrarMenu() {
		JPopupMenu menu = getPopUpMenu();
		jspImagen.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				menu.show(e.getComponent(), e.getX(), e.getY());
			}

		});
	}

	private JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem item1 = new JMenuItem(
				"La dimensión de la imagen es " + this.anchoImagen + "x" + this.altoImagen + " pixeles");
		JMenuItem item2 = new JMenuItem("Cambiar Imagen");
		menu.add(item1);
		menu.add(item2);
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();

			}
		});
		return menu;
	}

	public void seleccionaImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().toLowerCase().endsWith(".jpg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".jpeg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".png")
						|| f.getAbsolutePath().toLowerCase().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			if (fichero.isFile()) {
				if (isMayorde100x100(cargarImagenComoIcono(fichero))) {
					JOptionPane.showMessageDialog(null, "Error, la imagen es mayor de 100 x 100");
					return;
				}
				try {

					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	public static ImageIcon cargarImagenComoIcono(File archivoImagen) {
		try {
			BufferedImage imagen = ImageIO.read(archivoImagen);
			if (imagen != null) {
				// Escalar la imagen si es necesario
				Image imagenEscalada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				return new ImageIcon(imagenEscalada);
			} else {
				System.out.println("El archivo no contiene una imagen válida");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}



	public boolean isMayorde100x100(ImageIcon f) {
		if (altoImagen > 100) {
			return true;
		}
		if (anchoImagen > 100) {
			return true;
		}
		return false;
	}

	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.getJtfColorPreferido().setText(strColor);
			this.panel.setBackground(color);
		}
	}

	public void setColorFAvorito(String n) {
		this.getJtfColorPreferido().setText(n);

	}

	public String GetColorFavorito() {
		return this.getJtfColorPreferido().getText();
	}

	/**
	 * 
	 * @param newTitulo
	 */
	public void setTitulo(String newTitulo) {
		this.lblTitulo.setText(newTitulo);
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.jtfId.setText("" + id);
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return jtfNombre.getText();
	}

	public void setNombre(String n) {
		this.jtfNombre.setText("" + n);
	}

	public byte[] getImagen() {
		return this.imagenEnArrayDeBytes;

	}

	public void setImagen(byte[] img) {
		if (img != null && img.length > 0) {
			this.imagenEnArrayDeBytes = img;
			ImageIcon icono = new ImageIcon(this.imagenEnArrayDeBytes);
			this.anchoImagen = icono.getIconWidth();
			this.altoImagen = icono.getIconHeight();
			
			
//		ImageIcon icono = new ImageIcon(img);
//		JLabel lblIcono = new JLabel(icono);
//		jspImagen.setViewportView(lblIcono);
//		}else 
//		{
//		JLabel lblIcono = new JLabel("Sin imagen");
//		jspImagen.setViewportView(lblIcono);
		} else {
			this.imagenEnArrayDeBytes = null;
			JLabel lblicono = new JLabel("Sin Icono");
			this.jspImagen.setViewportView(lblicono);
			this.anchoImagen = 0;
			this.altoImagen = 0;

		}
		mostrarImagen();

	}

	private void mostrarImagen() {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);

			JLabel lblIcono = new JLabel(icono);
			this.jspImagen.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			this.jspImagen.setViewportView(lblIcono);
		}

	}

	public String getAp1() {
		return jtfPrimApe.getText();
	}

	public void setAp1(String n) {
		this.jtfPrimApe.setText("" + n);
	}

	public String getAp2() {
		return jtfSegApe.getText();
	}

	public void setAp2(String n) {
		this.jtfSegApe.setText("" + n);
	}

	public String getDire() {
		return jtfDireccion.getText();
	}

	public void setDire(String n) {
		this.jtfDireccion.setText("" + n);
	}

	public String getDni() {
		return jtfDni.getText();
	}

	public void setDni(String n) {
		this.jtfDni.setText("" + n);
	}

	public String getMail() {
		return jtfEmail.getText();
	}

	public void setMail(String n) {
		this.jtfEmail.setText("" + n);
	}

	public String getTlf() {
		return jtfTelefono.getText();
	}

	public void setTlf(String n) {
		this.jtfTelefono.setText("" + n);
	}

	public int getSexo() {
		Sexo o;
		o = (Sexo) this.jcbSexo.getSelectedItem();
		return o.getId();
	}

	public JComboBox<Sexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<Sexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return Integer.parseInt(this.jtfId.getText());
	}

	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}

	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}

	public Runnable getRunnableMostrarSiguienteRegistro() {
		return runnableMostrarSiguienteRegistro;
	}

	public void setRunnableMostrarSiguienteRegistro(Runnable runnableMostrarSiguienteRegistro) {
		this.runnableMostrarSiguienteRegistro = runnableMostrarSiguienteRegistro;
	}

	public Runnable getRunnableMostrarAnteriorRegistro() {
		return runnableMostrarAnteriorRegistro;
	}

	public void setRunnableMostrarAnteriorRegistro(Runnable runnableMostrarAnteriorRegistro) {
		this.runnableMostrarAnteriorRegistro = runnableMostrarAnteriorRegistro;
	}

	public Runnable getRunnableMostrarUltimoRegistro() {
		return runnableMostrarUltimoRegistro;
	}

	public void setRunnableMostrarUltimoRegistro(Runnable runnableMostrarUltimoRegistro) {
		this.runnableMostrarUltimoRegistro = runnableMostrarUltimoRegistro;
	}

	public JButton getBtnNuevo_1() {
		return btnNuevo_1;
	}

	public void setBtnNuevo_1(JButton btnNuevo_1) {
		this.btnNuevo_1 = btnNuevo_1;
	}

	public Runnable getRunnableGuardar() {
		return runnableGuardar;
	}

	public void setRunnableGuardar(Runnable runnableGuardar) {
		this.runnableGuardar = runnableGuardar;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public JTextField getJtfNombre() {
		return jtfNombre;
	}

	public void setJtfNombre(JTextField jtfNombre) {
		this.jtfNombre = jtfNombre;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JTextField getJtfPrimApe() {
		return jtfPrimApe;
	}

	public void setJtfPrimApe(JTextField jtfPrimApe) {
		this.jtfPrimApe = jtfPrimApe;
	}

	public JTextField getJtfSegApe() {
		return jtfSegApe;
	}

	public void setJtfSegApe(JTextField jtfSegApe) {
		this.jtfSegApe = jtfSegApe;
	}

	public JTextField getJtfDni() {
		return jtfDni;
	}

	public void setJtfDni(JTextField jtfDni) {
		this.jtfDni = jtfDni;
	}

	public JTextField getJtfDireccion() {
		return jtfDireccion;
	}

	public void setJtfDireccion(JTextField jtfDireccion) {
		this.jtfDireccion = jtfDireccion;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public void setJtfEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}

	public JTextField getJtfTelefono() {
		return jtfTelefono;
	}

	public void setJtfTelefono(JTextField jtfTelefono) {
		this.jtfTelefono = jtfTelefono;
	}

	private void cargarTodosSexos() {
		List<Sexo> l = ControladorSexo.getTodos();
		for (Sexo o : l) {
			jcbSexo.addItem(o);
		}

	}

	private void nuevo() {
		jtfId.setText("");
		jtfNombre.setText("");
		jtfDni.setText("");
		jtfPrimApe.setText("");
		jtfSegApe.setText("");
		jtfDireccion.setText("");
		jtfTelefono.setText("");
		jtfEmail.setText("");
		jcbSexo.setSelectedItem(null);
		setImagen(null);
		mostrarMenu();

		

	}

	public Runnable getRunnableBorrar() {
		return runnableBorrar;
	}

	public void setRunnableBorrar(Runnable runnableBorrar) {
		this.runnableBorrar = runnableBorrar;
	}

	public JTextField getJtfColorPreferido() {
		return jtfColorPreferido;
	}

	public void setJtfColorPreferido(JTextField jtfColorPreferido) {
		this.jtfColorPreferido = jtfColorPreferido;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
