package modelos;

/**
 * <p><b><i>Cliente</i></b></p>
 * <pre>public class Cliente extends Persona </pre>
 * <p> clase Empleado, extiende de la clase persona.</p>
 * @author Nicolas
 *
 */
public class Cliente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p><b><i>Cliente</i></b></p>
	 * <pre>public Cliente ()</pre>
	 * <p>Constructor de la clase <code>Cliente</code>.</p>
	 * @author Nicolas
	 */
	public Cliente() {
		super();
	}

	
	/**
	 * <p><b><i>Cliente</i></b></p>
	 * <pre> public Cliente(String nombre, String apellido, String dni, int telefono, String domicilio)</pre>
	 * <p>Constructor de la clase <code>Cliente</code>.</p>
	 * @param nombre Recibe el nombre de la persona
	 * @param apellido Recibe el apellido de la persona.
	 * @param dni Recibe el dni de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param domicilio Recibe el domicilio de la persona.
	 *  @author Nicolas
	 */
	
	
	public Cliente(String nombre, String apellido, String dni, int telefono, String domicilio) {
		super(nombre, apellido, dni, telefono, domicilio);
	}
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del cliente.
	 * @author Nicolas
	 */
	@Override
	public String toString() {
		return "\n------  CLIENTE  ------"+super.toString()+"\n";
	}
	
	

	
}
