package producto;



public class High_top extends Sneaker {

	private static String TIPO_SNEAKER = "high top";

	private String tipoDeSneaker;

	public High_top() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	public High_top(String codigo, String marca, String modelo, double talle, double precio) {
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
		return "High_top [tipoDeSneaker=" + tipoDeSneaker + "]" + super.toString();
	}

}
