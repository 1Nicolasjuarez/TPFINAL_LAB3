package excepciones;

/**
 * @author Dami�n Andr�s Barros
 * 
 * Excepci�n que ocurrir� al registrar unas Sneaker
 */

public class SneakerException extends Exception
{
	public SneakerException(String mensaje)
	{
		super(mensaje);	
	}
}