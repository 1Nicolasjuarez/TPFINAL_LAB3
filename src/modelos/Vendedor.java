package modelos;

public class Vendedor extends Empleado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String PUESTO="vendedor";
	
	private String puesto;
	
	public Vendedor() {
		super();
		this.puesto=PUESTO;
	}

	public Vendedor(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, puesto, sueldo, horasDeTrabajo);
	}
	
	@Override
	public String toString() {
		return "Gerente [puesto=" + puesto + "]"+super.toString()+"\n";
	}
	// TODO
	// registrarVenta

}
