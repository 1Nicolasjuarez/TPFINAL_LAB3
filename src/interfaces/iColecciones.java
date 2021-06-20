package interfaces;

/**
 * @author Nicolas Juarez
 * 
 * Interfaz gen�rica con m�todos a utilizar en colecciones
 */

public interface iColecciones<E> {

	public boolean agregarElemento(E x);
	public int contarElementos();
	public String listarElementos();
	
}
