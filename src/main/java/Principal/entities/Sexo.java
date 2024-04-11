package Principal.entities;

public class Sexo {

	int id;
	String descripcion;
	
	
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


	public Sexo() {
		super();
	}


	@Override
	public String toString() {
		return  descripcion;
	}
	
	
	
	
	
	
}
