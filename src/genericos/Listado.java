package genericos;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.iColecciones;
import modelos.Persona;

/*
 * 
 * CLASE GENERICA
 */

public class Listado<P extends Persona> implements iColecciones<Persona>,Serializable {

	

	private static final long serialVersionUID = 1L;
	
	private ArrayList<P> contenedor;

	public Listado() {
		contenedor = new ArrayList<P>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean agregarElemento(Persona x) {

		return contenedor.add((P) x);
	}
	
	public P eliminarElementoIndice(int indice) {
		 return contenedor.remove(indice);
		
	}
	
	public boolean eliminarElementoObj(P p) {
			return contenedor.remove(p);
	}
	
	@Override
	public int contarElementos() {

		return contenedor.size();
	}
	

	@Override
	public String listarElementos() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < contenedor.size(); i++) {
			sb.append(contenedor.get(i).toString());
		}
		return sb.toString();
	}
	
	public P buscarElemento(int index) {
		return contenedor.get(index);
	}
	
	public boolean existeElemento(P elemento) {
		return contenedor.contains(elemento);
	}
	
	
	
	/*
	

	private boolean buscarElementoPorDni(int dni) {

		boolean rta = false;

		for (int i = 0; i < contenedor.size(); i++) {
			if (contenedor.get(i).getDni() == dni) {

				rta = true;
			}

		}

		return rta;
	}

	
	/*
	 * 
	 * TODO tendria que devolver un objeto asi cuando el cliente ya compro antes, use su objeto.
	 
	
	
	public String buscarYmostrarElementoPorDni(int dni) {
		
		
		
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < contenedor.size(); i++) {
			if (contenedor.get(i).getDni() == dni) {

				sb.append(contenedor.get(i).toString());
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
			for (int i = 0; i < contenedor.size(); i++) {
				if (contenedor.get(i).getDni() == dni) {

					contenedor.remove(i);
					msj = "elemento eliminado correctamente";
				}

			}

		}

		return msj;
	}
	
	*/

}
