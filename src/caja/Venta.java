package caja;


import java.util.Date;

import colecciones.CarritoCompra;
import modelos.Cliente;

public class Venta implements Comparable<Venta>{

	private Date fechaVenta;
	private Cliente cliente;
	private CarritoCompra carrito;
	private double totalVenta;

	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Venta(Date fechaVenta, Cliente cliente, CarritoCompra carrito) {
		super();
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.carrito = carrito;
		this.totalVenta = carrito.calcularTotalCarrito();
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	@Override
	public String toString() {
		return "Venta [fechaVenta=" + fechaVenta + ", cliente=" + cliente.toString() + carrito + ", totalVenta="
				+ totalVenta + "]";
	}

	@Override
	public int compareTo(Venta o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
