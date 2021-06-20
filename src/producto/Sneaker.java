package producto;

import java.io.Serializable;


/**
 * @author Nicolas Juarez
 * 
 * Esta clase contiene los constructores para manejar a las Sneakers
 * Está serializada.
 */

public abstract class Sneaker implements Serializable{


	private static final long serialVersionUID = 1L;
	private String numeroSerie;
	private String marca;
	private String modelo;
	private double talle;
	private double precio;
	private boolean isDisponible;

	public Sneaker() {
		// TODO Auto-generated constructor stub
	}

	public Sneaker(String numeroSerie, String marca, String modelo, double talle, double precio) {

		this.numeroSerie = numeroSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.talle = talle;
		this.precio = precio;
		this.isDisponible = true;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getTalle() {
		return talle;
	}

	public void setTalle(double talle) {
		this.talle = talle;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}
	
	public abstract String getTipoDeSneakerAbs();
	
	
	

	@Override
	public String toString() {
		return "Sneaker [numeroSerie=" + numeroSerie + ", marca=" + marca + ", modelo=" + modelo + ", talle="
				+ talle + ", precio=" + precio + ", isDisponible=" + isDisponible + "]";
	}

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

	@Override
	public int hashCode() {

		return 1;
	}

	public void cambiarDisponibilidad() {
		this.isDisponible = false;
	}

}
