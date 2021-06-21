package genericos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import interfaces.iMapa;

/**
* <p><b><i>MapaGenerico</i></b></p>
* <pre>public class MapaGenerico <K,V> implements iMapa<K, V>,Serializable</pre>
* <p>Contenedor generico que esta pensado para abstraer el comportamiento del
 * HashMap</p>
* @param <K> clave esperando por el Objeto
 * @param <V> valor esperado por el objeto
* @author Nicolas
*
*/


public class MapaGenerico <K,V> implements iMapa<K, V>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<K, V> mapa;
	
	
	/**
	 * <p><b><i>MapaGenerico</i></b></p>
	 * <pre>public MapaGenerico ()</pre>
	 * <p>Constructor de la clase <code>MapaGenerico</code>.</p>
	 * @author Nicolas
	 */
	public MapaGenerico() {
		
		mapa = new HashMap<K, V>();
	}
	
	/**
	 * <p><b><i>existeClave</i></b></p>
	 *  <pre>public boolean existeClave(K clave)</pre>
	 *<p> Metodo para verificar si exixte una clave en el hashmap</p>
	 * @return true si se encuentra en el mapa.
	 * @author Nicolas
	 */
	
	@Override
	public boolean existeClave(K clave) {
		return mapa.containsKey(clave);
	}
	
	/**
	 * <p><b><i>agregarElemento</i></b></p>
	 *  <pre>public boolean agregarElemento(K clave, V valor) </pre>
	 *<p> Metodo que agrega un elemento al hashmap</p>
	 *@param clave elemento que reprecenta la clave
	 * @param valor elemento que reprecenta el contenido del elemento
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	@Override
	public boolean agregarElemento(K clave, V valor) {
		boolean agregado = false;
		if (!existeClave(clave)) {
			mapa.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}

	
	/**
	 * <p><b><i>eliminarElemento</i></b></p>
	 *  <pre>public boolean eliminarElemento(K clave) </pre>
	 *<p> Metodo para eliminar  un elemento del  hashmap mediante la clave</p>
	 *@param clave elemento que reprecenta la clave
	 * @return true si se elimino.
	 * @author Nicolas
	 */
	@Override
	public boolean eliminarElemento(K clave) {
		boolean eliminado = false;
		if (existeClave(clave)) {
			mapa.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}

	
	/**
	 * <p><b><i>modificarElemento</i></b></p>
	 *  <pre>public boolean modificarElemento(K clave, V valor) </pre>
	 *<p> Metodo que modificar un elemento del hashmap</p>
	 *@param clave elemento que reprecenta la clave
	 * @param valor elemento que reprecenta el contenido del elemento
	 * @return true si se modifico.
	 * @author Nicolas
	 */
	@Override
	public boolean modificarElemento(K clave, V valor) {
		boolean modificado = false;
		if (existeClave(clave)) {
			mapa.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}

	
	 /**
	 * <p><b><i>listarElementos</i></b></p>
	 * <pre>public String listarElementos(String claves, String valores)</pre>
	 * *<p> Metodo que retorna una string con los datos del mapa claves y valores</p>
	 *@param claves elemento que reprecenta la clave
	 * @param valores elemento que reprecenta el contenido del elemento
	 * @return Retorna los datos mediante un <code>String </code>.
	 * @author Nicolas
	 */
	@Override
	public String listarElementos(String claves, String valores) {
		StringBuilder builder = new StringBuilder();

		Set<Entry<K, V>> set = mapa.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			builder.append("\n\n"+claves + ": " + entry.getKey() + " " + "\n\n"+valores + ": " + entry.getValue());
		}

		return builder.toString();
	}

	
	/**
	 * <p><b><i>buscarElemento</i></b></p>
	 *  <pre>public V buscarElemento(K clave)</pre>
	 *<p> Metodo para buscas un elemento, si no existe retorna null.</p>
	 * @return el elemento.
	 * @author Nicolas
	 */
	
	@Override
	public V buscarElemento(K clave) {
		if (existeClave(clave)) {
			return mapa.get(clave);
		} else {
			return null;
		}
	}

	/**
	 * <p><b><i>devolverElementos</i></b></p>
	 *  <pre>public ArrayList<V> devolverElementos()</pre>
	 *<p> Metodo que retorna un arraylist de los elementos del hashmap</p>
	 * @return un arraylist de los elementos.
	 * @author Nicolas
	 */
	
	@Override
	public ArrayList<V> devolverElementos() {
		ArrayList <V> elementos = new ArrayList<V>();
		
		Set<Entry<K, V>> set = mapa.entrySet();
		Iterator<Entry<K, V>> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Entry<K, V> entry = iterator.next();
			elementos.add(entry.getValue());
		}
		return elementos;
	}
	
	

}
