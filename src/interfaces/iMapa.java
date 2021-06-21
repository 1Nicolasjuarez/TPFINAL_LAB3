package interfaces;

import java.util.ArrayList;

/**
 * <p><b><i>iMapa</i></b></p>
 * <pre>public interface iMapa <K,V><P></pre>
 * <p>La interfaz <code>iMapa</code> contiene una serie de metodos a redefinir en aquellas clases  que necesiten realizar estas operaciones basicas.</p>
 * @author Nicolas
 */

public interface iMapa <K,V>{

	public boolean existeClave(K clave);
	public boolean agregarElemento(K clave, V valor);
	public boolean eliminarElemento(K clave);
	public boolean modificarElemento(K clave, V valor);
	public String listarElementos(String claves, String valores);
	public V buscarElemento(K clave);
	public ArrayList<V> devolverElementos();
}
