package modelos;

public class Cajero extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String PUESTO="cajero";
	
	
	public Cajero() {
		super();
		
	}

	public Cajero(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass,  double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, PUESTO, sueldo, horasDeTrabajo);
		
	}
	
	
	@Override
	public String toString() {
		return "Cajero"+super.toString()+"\n";
	}
}
