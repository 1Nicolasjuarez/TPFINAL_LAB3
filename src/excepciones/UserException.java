package excepciones;

public class UserException extends Exception
{
	private String mensaje;
	
	public UserException(String mensaje)
	{
		super(mensaje);	
		this.mensaje = mensaje;
	}
	
	
	
	public void setMensaje(String msg) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	@Override
	public String getMessage() {
		
		return getMensaje();
	}
}
