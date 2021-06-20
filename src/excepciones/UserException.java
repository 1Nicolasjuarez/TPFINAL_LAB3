package excepciones;


/**
 * @author Dami�n Andr�s Barros
 * 
 * Excepci�n que ocurrir� cuando se est� registrando un Empleado
 */

public class UserException extends Exception
{
	private String mensaje;
	
	public UserException(String mensaje)
	{
		super(mensaje);	
	}
}
