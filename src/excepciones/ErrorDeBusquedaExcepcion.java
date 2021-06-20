package excepciones;

/**
 * @author Nicolas Juarez
 * 
 * Excepción que ocurrirá cuando no se encuentre un elemento buscado
 */
public class ErrorDeBusquedaExcepcion extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ErrorDeBusquedaExcepcion(String msg) {
		super(msg);
	}
}