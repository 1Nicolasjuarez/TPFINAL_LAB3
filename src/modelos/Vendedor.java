package modelos;

public class Vendedor extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String PUESTO="vendedor";
	
	
	
	public Vendedor() {
		super();
		
	}

	public Vendedor(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, PUESTO, sueldo, horasDeTrabajo);
	}
	
	@Override
	public String toString() {
		return "Vendedor"+super.toString()+"\n";
	}
	// TODO
	// registrarVenta

}
