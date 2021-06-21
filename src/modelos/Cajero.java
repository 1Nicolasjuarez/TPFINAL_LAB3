package modelos;


/**
 * <p><b><i>Cajero</i></b></p>
 * <pre>public class Cajero extends Empleado </pre>
 * <p> clase Empleado, extiende de la clase empleado.</p>
 * @author Nicolas
 *
 */


public class Cajero extends Empleado {

	/**
	 * @author Damián Andrés Barros
	 * 
	 * Esta clase contiene los constructores para manejar a un cajero y un valor estático
	 * que lo califica en ese puesto. Extiende de Empleado
	 */
	
	private static final long serialVersionUID = 1L;
	private static String PUESTO="cajero";
	
	/**
	 * <p><b><i>Cajero</i></b></p>
	 * <pre>public Cajero ()</pre>
	 * <p>Constructor de la clase <code>Cajero</code>.</p>
	 * @author Nicolas
	 */
	public Cajero() {
		super();
		
	}
	
	/**
	 * <p><b><i>Cajero</i></b></p>
	 * <pre> public Cajero(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass,  double sueldo, int horasDeTrabajo)</pre>
	 * <p>Constructor de la clase <code>Cajero</code>.</p>
	 * @param nombre Recibe el nombre de la persona
	 * @param apellido Recibe el apellido de la persona.
	 * @param dni Recibe el dni de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param domicilio Recibe el domicilio de la persona.
	 * @param nombreUsuario Recibe el nombreUsuario de la persona.
	 * @param pass Recibe el pass de la persona.
	 * @param puesto Recibe el puesto de la persona (variable statica PUESTO).
	 * @param sueldo Recibe el sueldo de la persona.
	 * @param horasDeTrabajo Recibe el horasDeTrabajo de la persona.
	 *  @author Nicolas
	 */
	
	public Cajero(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass,  double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, PUESTO, sueldo, horasDeTrabajo);
		
	}
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del cajero.
	 * @author Nicolas
	 */
	
	@Override
	public String toString() {
		return "\n------  CAJERO  ------"+super.toString()+"\n";
	}
}
