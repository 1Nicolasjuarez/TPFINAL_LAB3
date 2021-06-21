package modelos;


/**
 * <p><b><i>Empleado</i></b></p>
 * <pre>public class Empleado extends Persona</pre>
 * <p> clase Empleado, extiende de la clase padre persona.</p>
 * @author Nicolas
 *
 */



public class Empleado extends Persona {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	private String pass;
	private String puesto;
	private double sueldo;
	private int horasDeTrabajo;

	
	/**
	 * <p><b><i>Empleado</i></b></p>
	 * <pre>public Empleado ()</pre>
	 * <p>Constructor de la clase <code>Empleado</code>.</p>
	 * @author Nicolas
	 */

	public Empleado() {
		super();
		nombreUsuario = "";
		pass = "";
		puesto = "";
		sueldo = 0;
		horasDeTrabajo = 0;
	}

	/**
	 * <p><b><i>Empleado</i></b></p>
	 * <pre>public Empleado (String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo)</pre>
	 * <p>Constructor de la clase <code>Empleado</code>.</p>
	 * @param nombre Recibe el nombre de la persona
	 * @param apellido Recibe el apellido de la persona.
	 * @param dni Recibe el dni de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param domicilio Recibe el domicilio de la persona.
	 * @param nombreUsuario Recibe el nombreUsuario de la persona.
	 * @param pass Recibe el pass de la persona.
	 * @param puesto Recibe el puesto de la persona.
	 * @param sueldo Recibe el sueldo de la persona.
	 * @param horasDeTrabajo Recibe el horasDeTrabajo de la persona.
	 *  @author Nicolas
	 */
	
	
	public Empleado(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio);
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.horasDeTrabajo = horasDeTrabajo;
	}

	
	/**
	 * <p><b><i>getNombreUsuario</i></b></p>
	 * <pre>public String getNombreUsuario ()</pre>
	 * @return Retorna el nombreUsuario  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * <p><b><i>setNombreUsuario</i></b></p>
	 * <pre>public void setNombreUsuario(String nombreUsuario)</pre>
	 * @param nombreUsuario Recibe el nombreUsuario de la persona .
	 * @author Nicolas
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * <p><b><i>getPass</i></b></p>
	 * <pre>public String getPass ()</pre>
	 * @return Retorna el pass  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	
	public String getPass() {
		return pass;
	}
	
	/**
	 * <p><b><i>setPass</i></b></p>
	 * <pre>public void setPass(String pass)</pre>
	 * @param pass Recibe el pass de la persona .
	 * @author Nicolas
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * <p><b><i>getPuesto</i></b></p>
	 * <pre>public String getPuesto ()</pre>
	 * @return Retorna el puesto  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	public String getPuesto() {
		return puesto;
	}

	/**
	 * <p><b><i>setPuesto</i></b></p>
	 * <pre>public void setPuesto(String puesto)</pre>
	 * @param puesto Recibe el puesto de la persona .
	 * @author Nicolas
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	/**
	 * <p><b><i>getSueldo</i></b></p>
	 * <pre>public double getSueldo ()</pre>
	 * @return Retorna el sueldo  de la persona en formato <code>double</code>.
	 * @author Nicolas
	 */
	public double getSueldo() {
		return sueldo;
	}
	/**
	 * <p><b><i>setSueldo</i></b></p>
	 * <pre>public void setSueldo(double sueldo)</pre>
	 * @param sueldo Recibe el sueldo de la persona .
	 * @author Nicolas
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * <p><b><i>getHorasDeTrabajo</i></b></p>
	 * <pre>public int getHorasDeTrabajo ()</pre>
	 * @return Retorna las horasDeTrabajo  de la persona en formato <code>double</code>.
	 * @author Nicolas
	 */
	public int getHorasDeTrabajo() {
		return horasDeTrabajo;
	}
	/**
	 * <p><b><i>setHorasDeTrabajo</i></b></p>
	 * <pre>public void setHorasDeTrabajo(int horasDeTrabajo)</pre>
	 * @param horasDeTrabajo Recibe las  horasDeTrabajo de la persona .
	 * @author Nicolas
	 */
	public void setHorasDeTrabajo(int horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	}
	
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del empleado.
	 * @author Nicolas
	 */
	
	@Override
	public String toString() {
		return super.toString()
				+
				"\n-nombre de usuario: " + getNombreUsuario() 
				+ "\n-pass: " + getPass() 
				+ "\n-puesto: " + getPuesto() 
				+ "\n-sueldo: $"+ getSueldo() 
				+ "\n-horas de trabajo: " + getHorasDeTrabajo()+"hs";
	}

	
	
	
	

}
