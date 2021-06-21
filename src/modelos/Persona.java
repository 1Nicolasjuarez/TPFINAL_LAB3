package modelos;

import java.io.Serializable;

/**
 * <p><b><i>Persona</i></b></p>
 * <pre>public abstract class Persona implements Serializable</pre>
 * <p>Super clase Persona, reune todas las caracteristicas de todas las clases que sean "personas".</p>
 * @author Nicolas
 *
 */

public abstract class Persona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String dni;
	private int telefono;
	private String domicilio;
	
	/**
	 * <p><b><i>Persona</i></b></p>
	 * <pre>public Persona ()</pre>
	 * <p>Constructor de la clase <code>Persona</code>.</p>
	 * @author Nicolas
	 */
	public Persona() {
		super();
		nombre = "";
		apellido = "";
		dni = "";
		telefono = 0;
		domicilio = "";
	}
	/**
	 * <p><b><i>Persona</i></b></p>
	 * <pre> public Persona(String nombre, String apellido, String dni, int telefono, String domicilio)</pre>
	 * <p>Constructor de la clase <code>Persona</code>.</p>
	 * @param nombre Recibe el nombre de la persona
	 * @param apellido Recibe el apellido de la persona.
	 * @param dni Recibe el dni de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param domicilio Recibe el domicilio de la persona.
	 *  @author Nicolas
	 */
	public Persona(String nombre, String apellido, String dni, int telefono, String domicilio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}
	
	
	/**
	 * <p><b><i>getNombre</i></b></p>
	 * <pre>public String getNombre ()</pre>
	 * @return Retorna el nombre  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * <p><b><i>setNombre</i></b></p>
	 * <pre>public void setNombre(String nombre)</pre>
	 * @param nombre Recibe el nombre de la persona .
	 * @author Nicolas
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * <p><b><i>getApellido</i></b></p>
	 * <pre>public String getApellido ()</pre>
	 * @return Retorna el apellido  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * <p><b><i>setApellido</i></b></p>
	 * <pre>public void setApellido(String apellido) </pre>
	 * @param apellido Recibe el apellido de la persona .
	 * @author Nicolas
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * <p><b><i>getDomicilio</i></b></p>
	 * <pre>public String getDomicilio ()</pre>
	 * @return Retorna el domicilio  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getDomicilio() {
		return domicilio;
	}
	
	/**
	 * <p><b><i>setDomicilio</i></b></p>
	 * <pre>public void setDomicilio(String domicilio) </pre>
	 * @param domicilio Recibe el domicilio de la persona .
	 * @author Nicolas
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	/**
	 * <p><b><i>getTelefono</i></b></p>
	 * <pre>public int getTelefono ()</pre>
	 * @return Retorna el telefono  de la persona en formato <code>int</code>.
	 * @author Nicolas
	 */
	public int getTelefono() {
		return telefono;
	}
	
	/**
	 * <p><b><i>setTelefono</i></b></p>
	 * <pre>public void setTelefono(int telefono) </pre>
	 * @param telefono Recibe el telefono de la persona .
	 * @author Nicolas
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * <p><b><i>getDni</i></b></p>
	 * <pre>public String getDni ()</pre>
	 * @return Retorna el dni  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * <p><b><i>setDni</i></b></p>
	 * <pre>public void setDni(String dni) </pre>
	 * @param dni Recibe el dni de la persona .
	 * @author Nicolas
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos de la persona.
	 * @author Nicolas
	 */

	@Override
	public String toString() {
		return "\n-nombre: " + getNombre() 
				+ "\n-apellido: " + getApellido() 
				+ "\n-dni: " + getDni() 
				+ "\n-telefono: " + getTelefono()
				+ "\n-domicilio: " + getDomicilio();
	}
	
	
	/**
	 * <p><b><i>hashCode</i></b></p>
	 * <pre>public int hashCode ()</pre>
	 * <p>Sobreescritura del metodo <code>hashCode()</code>.</p>
	 * @return Retorna 1.
	 * @author Nicolas
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	
	
	/**
	 * <p><b><i>equals</i></b></p>
	 * <pre>public boolean equals (Object obj)</pre>
	 * <p>Sobreescritura del metodo <code>equals(Object obj)</code>. Compara numeros de DNI.</p>
	 * @return Retorna un <code>boolean</code> indicando si ambas personas son iguales o no.
	 * @author Nicolas
	 */
	
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
