package excepciones;

/**
 * @author Damián Andrés Barros
 * 
 * Excepción que ocurrirá al registrar unas Sneaker
 */

public class SneakerException extends Exception
{
	public SneakerException(String mensaje)
	{
		super(mensaje);	
	}
}