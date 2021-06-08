package modelos;

public class Vendedor extends Empleado {

	public Vendedor() {
		super();
	}

	public Vendedor(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, puesto, sueldo, horasDeTrabajo);
	}

	// TODO
	// registrarVenta

}
