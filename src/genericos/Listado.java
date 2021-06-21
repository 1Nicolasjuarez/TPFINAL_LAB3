package genericos;

import java.io.Serializable;

import java.util.ArrayList;

import interfaces.iLista;



/*
 * 
 * CLASE GENERICA
 */

public class Listado<P> implements iLista<P>, Serializable {

	

	private static final long serialVersionUID = 1L;
	
	private ArrayList<P> contenedor;

	public Listado() {
		contenedor = new ArrayList<P>();
	}

	@Override
	public boolean agregarElemento(P x) {
		return contenedor.add( x);
	}

	@Override
	public P eliminarElementoIndice(int indice) {
		 return contenedor.remove(indice);
	}

	@Override
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
		if(sb.isEmpty())
		{
			sb.append("La lista se encuentra vacia");
		}
		return sb.toString();
	}

	@Override
	public P buscarElemento(int index) {
		return contenedor.get(index);
	}

	@Override
	public boolean existeElemento(P e) {
		return contenedor.contains(e);
	}

	
	
	

}
