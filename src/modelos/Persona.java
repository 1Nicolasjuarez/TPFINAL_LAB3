package modelos;

public abstract class Persona {

	

	private String nombre;
	private String apellido;
	private int dni;
	private int telefono;
	private String domicilio;

	public Persona() {
		super();
		nombre = "";
		apellido = "";
		dni = 0;
		telefono = 0;
		domicilio = "";
	}

	public Persona(String nombre, String apellido, int dni, int telefono, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono
				+ ", domicilio=" + domicilio + "]";
	}

}
