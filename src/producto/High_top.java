package producto;


/**
 * @author Nicolas Juarez
 * 
 * Esta clase contiene los constructores para manejar a unas Sneakers de tipo High Top y un valor estático
 * que lo califica en ese puesto. Extiende de Sneaker
 */

public class High_top extends Sneaker {

	
	private static final long serialVersionUID = 1L;

	private static String TIPO_SNEAKER = "high top";

	private String tipoDeSneaker;

	public High_top() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	public High_top(String numeroSerie, String marca, String modelo, double talle, double precio) {
		super(numeroSerie, marca, modelo, talle, precio);
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	public String getTipoDeSneaker() {
		return tipoDeSneaker;
	}

	public void setTipoDeSneaker(String tipoDeSneaker) {
		this.tipoDeSneaker = tipoDeSneaker;
	}

	@Override
	public String toString() {
		return "High_top [tipoDeSneaker=" + tipoDeSneaker + "]" + super.toString();
	}

	@Override
	public String getTipoDeSneakerAbs() {
		
		return getTipoDeSneaker();
	}

}
