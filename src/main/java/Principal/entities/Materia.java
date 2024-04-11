package Principal.entities;

public class Materia {

	@Override
	public String toString() {
		return nombre ;
	}
	private int id;
	private int cursoID;
	private String nombre;
	private String acronimo;
	
	
	
	public Materia() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCursoID() {
		return cursoID;
	}
	public void setCursoID(int cursoID) {
		this.cursoID = cursoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	
	
	
	
	
	
}
