package producto;



public class Low_top extends Sneaker {

	private static String TIPO_SNEAKER = "low top";

	private String tipoDeSneaker;

	public Low_top() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	public Low_top(String codigo, String marca, String modelo, double talle, double precio) {
		super(codigo, marca, modelo, talle, precio);
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
		return "low top [tipoDeSneaker=" + tipoDeSneaker + "]" + super.toString();
	}
}
