package producto;



public class Mid_cup extends Sneaker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String TIPO_SNEAKER = "mid cup";

	private String tipoDeSneaker;

	public Mid_cup() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	public Mid_cup(String numeroSerie, String marca, String modelo, double talle, double precio) {
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
		return "Mid_cup [tipoDeSneaker=" + tipoDeSneaker + "]" + super.toString();
	}

	@Override
	public String getTipoDeSneakerAbs() {
		
		return getTipoDeSneaker();
	}
}
