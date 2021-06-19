package caja;


import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import colecciones.CarritoCompra;
import modelos.Cliente;
import modelos.Vendedor;

public class Venta implements Serializable, Comparable<Venta>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id=0;
	private Date fechaVenta;
	private Cliente cliente;
	private Vendedor vendedor;
	private CarritoCompra carrito;
	private double totalVenta;

	
	public Venta(Date fechaVenta, Cliente cliente,Vendedor vendedor ,CarritoCompra carrito) {
		this.id=0;
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.vendedor=vendedor;
		this.carrito = carrito;
		this.totalVenta = carrito.calcularTotalCarrito();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	@Override
	public String toString() {
		return "Venta [" +"id venta:" +getId() + "  fechaVenta=" + fechaVenta + ", cliente=" + cliente.toString() + carrito + ", totalVenta="
				+ totalVenta + "]";
	}

	@Override
	public int compareTo(Venta o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public JSONObject toJSONObject () throws JSONException
	{
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("ID", getId());
		jsonObj.put("FECHA", getFechaVenta());
		jsonObj.put("CLIENTE", cliente.getDni());
		jsonObj.put("VENDEDOR", vendedor.getDni());
		jsonObj.put("CARRITO", carrito.mostrarCarrito());
		jsonObj.put("MONTO", getTotalVenta());
		
		return jsonObj;
		
		
	}
	
	
	

}
