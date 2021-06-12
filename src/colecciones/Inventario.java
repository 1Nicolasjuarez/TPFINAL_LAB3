package colecciones;

import java.util.HashSet;
import java.util.Iterator;

import interfaces.iColecciones;
import producto.Sneaker;

public class Inventario  {

	private HashSet<Sneaker> hash;

	public Inventario() {
		hash = new HashSet<Sneaker>();
	}

	
	public void agregar(Sneaker x) {
		hash.add(x);

	}

	
	public String listar() {

		StringBuilder sb = new StringBuilder();

		@SuppressWarnings("rawtypes")
		Iterator it = hash.iterator();

		while (it.hasNext()) {
			sb.append(it.next() + "\n");
		}

		return sb.toString();
	}

	
	public int contar() {
		return hash.size();
	}

	
	public void agregarElemento(Sneaker x) {
		// TODO Auto-generated method stub
		
	}

	
	public int contarElementos() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String listarElementos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * TODO falta eliminar inventario y mostrar los que fueron vendidos
	 */
	
	

}
