package excepciones;


/**
 * @author Damián Andrés Barros
 * 
 * Excepción que ocurrirá cuando se esté registrando un Empleado
 */

public class UserException extends Exception
{
	private String mensaje;
	
	public UserException(String mensaje)
	{
		super(mensaje);	
	}
}
