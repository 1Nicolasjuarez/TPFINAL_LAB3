package caja;

import java.util.ArrayList;

import producto.Sneaker;

public class CarritoCompra {

	private ArrayList<Sneaker> carrito;
	@SuppressWarnings("unused")
	private double totalCarrito;

	public CarritoCompra() {

		carrito = new ArrayList<Sneaker>();
		totalCarrito = 0;
	}

	public void agregarAlCarrito(Sneaker x) {
		carrito.add(x);
		x.cambiarDisponibilidad();
	}

	public String mostrarCarrito() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < carrito.size(); i++) {
			sb.append("\n"+carrito.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	/*
	
	public int contarTotalCarrito() {

		return carrito.size();
	}
	*/

	public double calcularTotalCarrito() {
		double rta = 0;
		double suma = 0;

		for (int i = 0; i < carrito.size(); i++) {
			suma = suma + carrito.get(i).getPrecio();
		}

		rta = suma;

		return rta;
	}
	
	
	@Override
	public String toString() {
		
		String msj = mostrarCarrito();
		double importe= calcularTotalCarrito();
		
		return "\ncarrito"+msj + "\ntotal del importe"+importe;
	}
	

}
