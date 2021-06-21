package excepciones;

/**
 * <p><b><i>ErrorDeBusquedaExcepcion</i></b></p>
 * <pre>public class ErrorDeBusquedaExcepcion extends Exception</pre>
 * <p> tira una excepcion si no encuentra un elemento </p>
 */


public class ErrorDeBusquedaExcepcion extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorDeBusquedaExcepcion(String msg) {
		super(msg);
	}
}