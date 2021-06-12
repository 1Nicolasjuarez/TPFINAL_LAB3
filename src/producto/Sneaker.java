package producto;



public abstract class Sneaker {

	private String codigo;
	private String marca;
	private String modelo;
	private double talle;
	private double precio;
	private boolean isDisponible;

	public Sneaker() {
		// TODO Auto-generated constructor stub
	}

	public Sneaker(String codigo, String marca, String modelo, double talle, double precio) {

		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.talle = talle;
		this.precio = precio;
		this.isDisponible = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Sneaker [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", talle="
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
		if (codigo != other.codigo)
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
