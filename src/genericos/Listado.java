package genericos;

import java.io.Serializable;

import java.util.ArrayList;

import interfaces.iLista;

/*
 * 
 * CLASE GENERICA
 */
/**
* <p><b><i>Listado</i></b></p>
* <pre>public class Listado<P> implements iLista<P>, Serializable</pre>
* <p>Contenedor generico que esta pensado para abstraer el comportamiento del
 * ArrayList</p>
* param <P> Tipo de dato esperodo por el objeto. podria ser una persona o una venta
* @author Nicolas
*
*/

public class Listado<P> implements iLista<P>, Serializable {

	

	private static final long serialVersionUID = 1L;
	
	private ArrayList<P> contenedor;
	
	/**
	 * <p><b><i>Listado</i></b></p>
	 * <pre>public Listado ()</pre>
	 * <p>Constructor de la clase <code>Listado</code>.</p>
	 * @author Nicolas
	 */
	
	public Listado() {
		contenedor = new ArrayList<P>();
	}

	/**
	 * <p><b><i>agregarElemento</i></b></p>
	 *  <pre>public boolean agregarElemento(P x)</pre>
	 *<p> Metodo que agrega un elemento a la lista</p>
	 *@param P 
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	@Override
	public boolean agregarElemento(P x) {
		return contenedor.add( x);
	}

	/**
	 * <p><b><i>eliminarElementoIndice</i></b></p>
	 *  <pre>public P eliminarElementoIndice(int indice)</pre>
	 *<p> Metodo que elimina un elemento a la lista mendiante el idice</p>
	 **@param int indice
	 * @return true si se elimino.
	 * @author Nicolas
	 */
	
	@Override
	public P eliminarElementoIndice(int indice) {
		 return contenedor.remove(indice);
	}
	
	/**
	 * <p><b><i>eliminarElementoObj</i></b></p>
	 *  <pre>public boolean eliminarElementoObj(P p)</pre>
	 *<p> Metodo que elimina un elemento a la lista mendiante comparacion de un objeto</p>
	 **@param P 
	 * @return true si se elimino.
	 * @author Nicolas
	 */

	@Override
	public boolean eliminarElementoObj(P p) {
		return contenedor.remove(p);
	}
	
	/**
	 * <p><b><i>contarElementos</i></b></p>
	 *  <pre>public int contarElementos()</pre>
	 *<p> Metodo que cuenta la cantidad de  elementos en una lista</p>
	 * @return true si se elimino.
	 * @author Nicolas
	 */
	@Override
	public int contarElementos() {
		return contenedor.size();
	}

	 /**
		 * <p><b><i>listarElementos</i></b></p>
		 * <pre>public String listarElementos()</pre>
		 * *<p> Metodo que retorna una string con los datos de una lista</p>
		 * @return Retorna los datos mediante un<code>String </code>.
		 * @author Nicolas
		 */
	
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

	
	/**
	 * <p><b><i>buscarElemento</i></b></p>
	 *  <pre>public P buscarElemento(int index)</pre>
	 *<p> Metodo retorna la posicion de una lista mediante el indice</p>
	 **@param int indice 
	 * @return un obj.
	 * @author Nicolas
	 */
	@Override
	public P buscarElemento(int index) {
		return contenedor.get(index);
	}
	
	
	/**
	 * <p><b><i>existeElemento</i></b></p>
	 *  <pre>public boolean existeElemento(P e)</pre>
	 *<p> Metodo que retorna true si un objeto se encuentra en la lista mediante la comparacion de un obj</p>
	 **@param P 
	 * @return true si se encontro.
	 * @author Nicolas
	 */
	@Override
	public boolean existeElemento(P e) {
		return contenedor.contains(e);
	}

	
	
	

}
