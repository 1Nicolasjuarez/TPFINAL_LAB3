package colecciones;

import java.util.ArrayList;

import interfaces.iColecciones;
import modelos.Persona;

/*
 * 
 * CLASE GENERICA
 */

public class Listado<P extends Persona> implements iColecciones<Persona> {

	private ArrayList<P> lista;

	public Listado() {
		lista = new ArrayList<P>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void agregar(Persona x) {

		lista.add((P) x);
	}

	@Override
	public String listar() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < lista.size(); i++) {
			sb.append(lista.get(i).toString());
		}
		return sb.toString();
	}

	@Override
	public int contar() {

		return lista.size();
	}

	private boolean buscarElementoPorDni(int dni) {

		boolean rta = false;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDni() == dni) {

				rta = true;
			}

		}

		return rta;
	}

	
	/*
	 * 
	 * TODO tendria que devolver un objeto asi cuando el cliente ya compro antes, use su objeto.
	 */
	
	
	public String buscarYmostrarElementoPorDni(int dni) {
		
		
		
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDni() == dni) {

				sb.append(lista.get(i).toString());
			}
		}

		if (sb.isEmpty()) {
			sb.append("Elemento no encontrado");
		}

		return sb.toString();
		
		
	}

	public String eliminarElementoPorDni(int dni) {
		String msj = "El elemento no se ha borrado, ya que no se encuentra en la lista";

		boolean rta = buscarElementoPorDni(dni);

		if (rta) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getDni() == dni) {

					lista.remove(i);
					msj = "elemento eliminado correctamente";
				}

			}

		}

		return msj;
	}

}
