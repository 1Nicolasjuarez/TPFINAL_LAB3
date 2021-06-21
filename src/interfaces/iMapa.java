package interfaces;

import java.util.ArrayList;

public interface iMapa <K,V>{

	public boolean existeClave(K clave);
	public boolean agregarElemento(K clave, V valor);
	public boolean eliminarElemento(K clave);
	public boolean modificarElemento(K clave, V valor);
	public String listarElementos(String claves, String valores);
	public V buscarElemento(K clave);
	public ArrayList<V> devolverElementos();
}
