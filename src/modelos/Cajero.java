package modelos;

public class Cajero extends Empleado {

	public Cajero() {
		super();
	}

	public Cajero(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, puesto, sueldo, horasDeTrabajo);
	}
}
