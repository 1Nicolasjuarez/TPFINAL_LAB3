package producto;

/**
 * <p><b><i>High_top</i></b></p>
 * <pre>public class High_top extends Sneaker</pre>
 * <p>clase High_top, extiende de la clase padre Sneaker</p>
 * @author Nicolas
 *
 */

public class High_top extends Sneaker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String TIPO_SNEAKER = "high top";

	private String tipoDeSneaker;
	
	
	/**
	 * <p><b><i>High_top</i></b></p>
	 * <pre>public High_top ()</pre>
	 * <p>Constructor de la clase <code>High_top</code>.</p>
	 * @author Nicolas
	 */
	public High_top() {
		super();
		this.tipoDeSneaker = TIPO_SNEAKER;
	}
	
	/**
	 * <p><b><i>High_top</i></b></p>
	 * <pre>public High_top(String numeroSerie, String marca, String modelo, double talle, double precio)</pre>
	 * <p>Constructor de la clase <code>High_top</code>.</p>
	 * @param numeroSerie Recibe el numeroSerie de la sneaker.
	 * @param marca Recibe la marca de la sneaker..
	 * @param modelo Recibe el modelo de la sneaker.
	 * @param talle Recibe el talle de la sneaker.
	 * @param precio Recibe el precio de la sneaker.
	 * @param tipoDeSneaker Recibe el tipoDeSneaker de la sneaker (mediante la variable static TIPO_SNEAKER).
	 *  @author Nicolas
	 */

	public High_top(String numeroSerie, String marca, String modelo, double talle, double precio) {
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
