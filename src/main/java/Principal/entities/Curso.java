package Principal.entities;

public class Curso {

	private int id;
	private String descripcion;
	
	
	
	
	
	
	@Override
	public String toString() {
		return descripcion;
	}

	public Curso() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
