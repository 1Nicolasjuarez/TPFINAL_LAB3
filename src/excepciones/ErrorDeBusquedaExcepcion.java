package excepciones;

/**
 * @author Nicolas Juarez
 * 
 * Excepci�n que ocurrir� cuando no se encuentre un elemento buscado
 */
public class ErrorDeBusquedaExcepcion extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ErrorDeBusquedaExcepcion(String msg) {
		super(msg);
	}
}