package interfaces;

public interface iLista <P>{

	public boolean agregarElemento(P p);
	public P eliminarElementoIndice(int indice);
	public boolean eliminarElementoObj(P p);
	public int contarElementos();
	public String listarElementos();
	public P buscarElemento(int index);
	public boolean existeElemento(P e);
}
