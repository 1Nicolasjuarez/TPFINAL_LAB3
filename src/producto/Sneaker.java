package producto;

import java.io.Serializable;

/**
 * <p><b><i>Sneaker</i></b></p>
 * <pre>public abstract class Sneaker implements Serializable</pre>
 * <p>Super clase Sneaker, reune todas las caracteristicas de todas las clases que sean "sneakers".</p>
 * @author Nicolas
 *
 */



public abstract class Sneaker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroSerie;
	private String marca;
	private String modelo;
	private double talle;
	private double precio;
	private boolean isDisponible;

	/**
	 * <p><b><i>Sneaker</i></b></p>
	 * <pre>public Sneaker ()</pre>
	 * <p>Constructor de la clase <code>Sneaker</code>.</p>
	 * @author Nicolas
	 */
	
	public Sneaker() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * <p><b><i>Sneaker</i></b></p>
	 * <pre> public Sneaker(String numeroSerie, String marca, String modelo, double talle, double precio)</pre>
	 * <p>Constructor de la clase <code>Sneaker</code>.</p>
	 * @param numeroSerie Recibe el numeroSerie de la sneaker.
	 * @param marca Recibe la marca de la sneaker..
	 * @param modelo Recibe el modelo de la sneaker.
	 * @param talle Recibe el talle de la sneaker.
	 * @param precio Recibe el precio de la sneaker.
	 *  @author Nicolas
	 */
	
	
	public Sneaker(String numeroSerie, String marca, String modelo, double talle, double precio) {

		this.numeroSerie = numeroSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.talle = talle;
		this.precio = precio;
		this.isDisponible = true;
	}

	/**
	 * <p><b><i>getNumeroSerie</i></b></p>
	 * <pre>public String getNumeroSerie()</pre>
	 * @return Retorna el numeroSerie  de la sneaker en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}
	
	/**
	 * <p><b><i>setNumeroSerie</i></b></p>
	 * <pre>public void setNombre(String numeroSerie)</pre>
	 * @return Recibe el numeroSerie de la sneaker .
	 * @author Nicolas
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	/**
	 * <p><b><i>getMarca</i></b></p>
	 * <pre>public String getMarca()</pre>
	 * @return Retorna la marca  de la sneaker en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * <p><b><i>setMarca</i></b></p>
	 * <pre>public void setMarca(String marca)</pre>
	 * @return Recibe la marca de la sneaker .
	 * @author Nicolas
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * <p><b><i>getModelo</i></b></p>
	 * <pre>public String getModelo()</pre>
	 * @return Retorna la modelo  de la sneaker en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * <p><b><i>setModelo</i></b></p>
	 * <pre>public void setModelo(String modelo)</pre>
	 * @return Recibe el modelo de la sneaker .
	 * @author Nicolas
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * <p><b><i>getTalle</i></b></p>
	 * <pre>public double getTalle()</pre>
	 * @return Retorna el talle  de la sneaker en formato <code>double</code>.
	 * @author Nicolas
	 */
	public double getTalle() {
		return talle;
	}
	
	/**
	 * <p><b><i>setTalle</i></b></p>
	 * <pre>public void setTalle(double talle)</pre>
	 * @return Recibe la talle de la sneaker .
	 * @author Nicolas
	 */
	
	public void setTalle(double talle) {
		this.talle = talle;
	}
	
	/**
	 * <p><b><i>getPrecio</i></b></p>
	 * <pre>public double getPrecio()</pre>
	 * @return Retorna el precio  de la sneaker en formato <code>double</code>.
	 * @author Nicolas
	 */
	
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * <p><b><i>setPrecio</i></b></p>
	 * <pre>public void setPrecio(double precio)</pre>
	 * @return Recibe el precio de la sneaker .
	 * @author Nicolas
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}
	
	/**
	 * <p><b><i>getTipoDeSneakerAbs</i></b></p>
	 * <pre>public abstract String getTipoDeSneakerAbs()()</pre>
	 * <p>metodo abstract String getTipoDeSneakerAbs() </code>.</p>
	 * @author Nicolas
	 */
	
	public abstract String getTipoDeSneakerAbs();
	
	
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos de la sneaker.
	 * @author Nicolas
	 */

	@Override
	public String toString() {
		return "\n-numero de serie: " + getNumeroSerie() 
				+"\n-marca: " + getMarca() 
				+"\n-modelo: " + getModelo() 
				+"\n-talle: "+ getTalle() 
				+"\n-precio: " + getPrecio() + "\n";
	}
	
	/**
	 * <p><b><i>equals</i></b></p>
	 * <pre>public boolean equals (Object obj)</pre>
	 * <p>Sobreescritura del metodo <code>equals(Object obj)</code>. Compara numeros de numeroSerie.</p>
	 * @return Retorna un <code>boolean</code> indicando si ambas sneaker son iguales o no.
	 * @author Nicolas
	 */
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sneaker other = (Sneaker) obj;
		if (numeroSerie != other.numeroSerie)
			return false;
		return true;
	}
	
	/**
	 * <p><b><i>hashCode</i></b></p>
	 * <pre>public int hashCode ()</pre>
	 * <p>Sobreescritura del metodo <code>hashCode()</code>.</p>
	 * @return Retorna 1.
	 * @author Nicolas
	 */
	
	@Override
	public int hashCode() {

		return 1;
	}

	public void cambiarDisponibilidad() {
		this.isDisponible = false;
	}

}
