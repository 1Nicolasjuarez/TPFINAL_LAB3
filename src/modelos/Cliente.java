package modelos;

public class Cliente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, String dni, int telefono, String domicilio) {
		super(nombre, apellido, dni, telefono, domicilio);
	}

	@Override
	public String toString() {
		return "Cliente: "+super.toString();
	}
	
	

	// TODO
	// comprar()
}
