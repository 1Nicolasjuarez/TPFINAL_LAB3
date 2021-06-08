package modelos;

public class Cliente extends Persona {

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int dni, int telefono, String domicilio) {
		super(nombre, apellido, dni, telefono, domicilio);
	}

	@Override
	public String toString() {
		return "Cliente: "+super.toString();
	}
	
	

	// TODO
	// comprar()
}
