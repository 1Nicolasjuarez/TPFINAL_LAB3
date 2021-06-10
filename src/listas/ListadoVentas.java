package listas;

import java.util.Iterator;
import java.util.TreeSet;

import caja.Venta;

public class ListadoVentas {

	private TreeSet<Venta> listadoVentas;

	public ListadoVentas() {

		listadoVentas = new TreeSet<Venta>();
	}

	public void agregar(Venta x) {

		listadoVentas.add(x);

	}

	public String listar() {
		StringBuilder sb = new StringBuilder();

		@SuppressWarnings("rawtypes")
		Iterator it = listadoVentas.iterator();

		while (it.hasNext()) {
			sb.append(it.next());
		}

		return sb.toString();
	}

	public int contar() {

		return listadoVentas.size();

	}

	public void eliminar(Venta x) {
		listadoVentas.remove(x);

	}
}
