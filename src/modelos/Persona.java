package modelos;

import java.io.Serializable;


/**
 * 
 * @author Nicolas Juarez
 * 
 * Esta clase es abstracta ya que en el sistema se encuentran Clientes y Empleados
 * Esta serializada para poder almacenar datos en un archivo.
 *
 */

public abstract class Persona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String dni;
	private int telefono;
	private String domicilio;

	public Persona() {
		super();
		nombre = "";
		apellido = "";
		dni = "";
		telefono = 0;
		domicilio = "";
	}

	public Persona(String nombre, String apellido, String dni, int telefono, String domicilio) {
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

	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono
				+ ", domicilio=" + domicilio + "]";
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
