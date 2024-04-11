 package Principal.views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import capitulo08.centroEducativo.Principal;



public class Menu extends JMenuBar {

	/**
	 * 
	 */
	public Menu () {
		// Menú Archivo de la aplicación
        JMenu menuArchivo = new JMenu("Archivo");
        
        menuArchivo.add(crearNuevoMenuItem("Curso", 0));
        
        menuArchivo.add(crearNuevoMenuItem("Materia",  1 ));
        
        menuArchivo.add(crearNuevoMenuItem("Estudiante", 2));
        
        menuArchivo.add(crearNuevoMenuItem("Profesor", 3));
        
        this.add(menuArchivo);
        
        
      
	}
	
	
	
	/**
	 * Menú Item para salir de la aplicación
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String nombre, int n) {
		JMenuItem item = new JMenuItem(nombre);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Principal.getInstance().getPanelTabbed().setSelectedIndex(n);
				
			}
		});
		return item;
       
	}
	
	/**
	 * 
	 * @param titulo
	 * @param nombreIcono
	 * @return
	 */
	private JMenuItem crearNuevoCheckBoxMenuItem (String titulo, String nombreIcono) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(titulo);
        item.setIcon(CacheImagenes.getCacheImagenes().getIcono(nombreIcono));
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Han hecho clic en el JCheckBox: " + titulo + " - Seleccionado: " + item.isSelected());
            }
        });
        
        return item;
	}

	/**
	 * 
	 * @param titulo
	 * @param nombreIcono
	 * @return
	 */
	private JMenuItem crearNuevoRadioButtonMenuItem (String titulo, String nombreIcono, ButtonGroup buttonGroup) {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem(titulo);
        item.setIcon(CacheImagenes.getCacheImagenes().getIcono(nombreIcono));
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Han hecho clic en el JRadioButton: " + titulo + " - Seleccionado: " + item.isSelected());
            }
        });
        buttonGroup.add(item);
        
        return item;
	}

}
