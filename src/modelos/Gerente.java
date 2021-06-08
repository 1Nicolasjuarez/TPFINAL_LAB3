package modelos;

public class Gerente extends Empleado {

	public Gerente() {
		super();
	}

	public Gerente(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, puesto, sueldo, horasDeTrabajo);
	}

	// TODO
	// reponerStock();
}
