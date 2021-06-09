package colecciones;

import java.util.HashSet;
import java.util.Iterator;

import interfaces.iColecciones;
import producto.Sneaker;

public class Inventario implements iColecciones<Sneaker> {

	private HashSet<Sneaker> hash;

	public Inventario() {
		hash = new HashSet<Sneaker>();
	}

	@Override
	public void agregar(Sneaker x) {
		hash.add(x);

	}

	@Override
	public String listar() {

		StringBuilder sb = new StringBuilder();

		@SuppressWarnings("rawtypes")
		Iterator it = hash.iterator();

		while (it.hasNext()) {
			sb.append(it.next() + "\n");
		}

		return sb.toString();
	}

	@Override
	public int contar() {
		return hash.size();
	}
	
	
	/*
	 * TODO falta eliminar inventario y mostrar los que fueron vendidos
	 */
	
	

}
