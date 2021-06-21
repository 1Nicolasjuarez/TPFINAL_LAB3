package interfaces;

/**
 * <p><b><i>iLista</i></b></p>
 * <pre>public interface iLista <P></pre>
 * <p>La interfaz <code>iLista</code> contiene una serie de metodos a redefinir en aquellas clases que necesiten realizar estas operaciones basicas.</p>
 * @author Nicolas
 */



public interface iLista <P>{

	public boolean agregarElemento(P p);
	public P eliminarElementoIndice(int indice);
	public boolean eliminarElementoObj(P p);
	public int contarElementos();
	public String listarElementos();
	public P buscarElemento(int index);
	public boolean existeElemento(P e);
}
