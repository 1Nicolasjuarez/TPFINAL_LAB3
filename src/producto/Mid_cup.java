package producto;

/**
 * <p><b><i>Mid_cup</i></b></p>
 * <pre>public class Mid_cup extends Sneaker</pre>
 * <p>clase Mid_cup, extiende de la clase padre Sneaker</p>
 * @author Nicolas
 *
 */

public class Mid_cup extends Sneaker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String TIPO_SNEAKER = "mid cup";

	private String tipoDeSneaker;
	
	/**
	 * <p><b><i>Mid_cup</i></b></p>
	 * <pre>public Mid_cup ()</pre>
	 * <p>Constructor de la clase <code>Mid_cup</code>.</p>
	 * @author Nicolas
	 */
	public Mid_cup() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}
	
	/**
	 * <p><b><i>Mid_cup</i></b></p>
	 * <pre>public Mid_cup(String numeroSerie, String marca, String modelo, double talle, double precio)</pre>
	 * <p>Constructor de la clase <code>Mid_cup</code>.</p>
	 * @param numeroSerie Recibe el numeroSerie de la sneaker.
	 * @param marca Recibe la marca de la sneaker..
	 * @param modelo Recibe el modelo de la sneaker.
	 * @param talle Recibe el talle de la sneaker.
	 * @param precio Recibe el precio de la sneaker.
	 * @param tipoDeSneaker Recibe el tipoDeSneaker de la sneaker (mediante la variable static TIPO_SNEAKER).
	 *  @author Nicolas
	 */
	public Mid_cup(String numeroSerie, String marca, String modelo, double talle, double precio) {
		super(numeroSerie, marca, modelo, talle, precio);
		this.tipoDeSneaker = TIPO_SNEAKER;
	}

	/**
	 * <p><b><i>getTipoDeSneaker</i></b></p>
	 * <pre>public String getTipoDeSneaker ()</pre>
	 * @return Retorna el tipoDeSneaker  de la sneaker en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getTipoDeSneaker() {
		return tipoDeSneaker;
	}

	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos de la sneaker.
	 * @author Nicolas
	 */
	@Override
	public String toString() {
		return "\n------------ Sneaker ------------" +
				"\n-tipo de sneaker: "+getTipoDeSneaker() 
				+ super.toString();
	}
	
	/**
	 * <p><b><i>getTipoDeSneakerAbs</i></b></p>
	 * <pre>public String getTipoDeSneakerAbs ()</pre>
	 * @return Retorna el tipoDeSneaker  de la sneakers en formato <code>String</code>.
	 * @author Nicolas
	 */
	@Override
	public String getTipoDeSneakerAbs() {
		
		return getTipoDeSneaker();
	}
}
