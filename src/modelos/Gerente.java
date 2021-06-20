package modelos;


/**
 * @author Damián Andrés Barros
 * 
 * Esta clase contiene los constructores para manejar a un gerente y un valor estático
 * que lo califica en ese puesto. Extiende de Empleado
 */
public class Gerente extends Empleado {


	private static final long serialVersionUID = 1L;
	
	private static String PUESTO="gerente";
	
	public Gerente() {
		super();
		
	}

	public Gerente(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
			String pass, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio, nombreUsuario, pass, PUESTO, sueldo, horasDeTrabajo);
		
	}
	
	@Override
	public String toString() {
		return "Gerente"+super.toString()+"\n";
	}
	
	
	
	// TODO
	// reponerStock();
}
