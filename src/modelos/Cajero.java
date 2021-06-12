package modelos;

public class Cajero extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String PUESTO="cajero";
	private String puesto;
	
	public Cajero() {
		super();
		this.puesto=PUESTO;
	}

	public Cajero(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, puesto, sueldo, horasDeTrabajo);
		this.puesto=PUESTO;
	}
	
	
	@Override
	public String toString() {
		return "Gerente [puesto=" + puesto + "]"+super.toString()+"\n";
	}
}
