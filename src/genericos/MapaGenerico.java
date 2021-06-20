package genericos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author Nicolas Juarez
 * 
 * Clase genérica que permitirá agregar, eliminar, buscar, o contar elementos en un HashMap
 */
public class MapaGenerico <K,V> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private HashMap<K, V> mapa;
	
	public MapaGenerico() {
		
		mapa = new HashMap<K, V>();
	}
	
	public boolean existeClave(K clave) {
		return mapa.containsKey(clave);
	}
	
	public boolean agregarElemento(K clave, V valor) {
		boolean agregado = false;
		if (!existeClave(clave)) {
			mapa.put(clave, valor);
			agregado = true;
		}
		return agregado;
	}
	
	public boolean eliminarElemento(K clave) {
		boolean eliminado = false;
		if (existeClave(clave)) {
			mapa.remove(clave);
			eliminado = true;
		}
		return eliminado;
	}
	
	
	public boolean modificarElemento(K clave, V valor) {
		boolean modificado = false;
		if (existeClave(clave)) {
			mapa.put(clave, valor);
			modificado = true;
		}
		return modificado;
	}
	
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
	


	public V buscarElemento(K clave) {

		if (existeClave(clave)) {
			return mapa.get(clave);
		} else {
			return null;
		}

	}
	
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
