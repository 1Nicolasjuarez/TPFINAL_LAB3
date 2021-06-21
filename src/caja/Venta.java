package caja;


import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import colecciones.CarritoCompra;
import modelos.Cliente;
import modelos.Vendedor;

/**
 * <p><b><i>Venta</i></b></p>
 * <pre>public class Venta implements Serializable, Comparable<Venta></pre>
 * <p>Super clase Venta.</p>
 * @author Nicolas
 *
 */

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

	/**
	 * <p><b><i>Venta</i></b></p>
	 * <pre>public Venta(Date fechaVenta, Cliente cliente,Vendedor vendedor ,CarritoCompra carrito)</pre>
	 * <p>Constructor de la clase <code>Venta</code>.</p>
	 * @param fechaVenta Recibe el fecha  de la venta
	 * @param cliente Recibe el cliente de la venta.
	 * @param vendedor Recibe el vendedor de la venta.
	 * @param carrito Recibe el carrito de compras de la venta.
	 *  @author Nicolas
	 */
	public Venta(Date fechaVenta, Cliente cliente,Vendedor vendedor ,CarritoCompra carrito) {
		this.id=0;
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
		this.vendedor=vendedor;
		this.carrito = carrito;
		this.totalVenta = carrito.calcularTotalCarrito();
	}

	
	/**
	 * <p><b><i>getId</i></b></p>
	 * <pre>public int getId()</pre>
	 * @return Retorna el nombre  de la persona en formato <code>String</code>.
	 * @author Nicolas
	 */
		
	public int getId() {
		return id;
	}
	
	/**
	 * <p><b><i>setId</i></b></p>
	 * <pre>public void setId(int id)</pre>
	 * @param id Recibe el id de la venta .
	 * @author Nicolas
	 */

	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * <p><b><i>getFechaVenta </i></b></p>
	 * <pre>public Date getFechaVenta()</pre>
	 * @return Retorna la fecha  de la venta en formato <code>Date </code>.
	 * @author Nicolas
	 */

	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	/**
	 * <p><b><i>setFechaVenta</i></b></p>
	 * <pre>public void setFechaVenta(Date fechaVenta)</pre>
	 * @param fechaVenta Recibe la fecha  de la venta .
	 * @author Nicolas
	 */
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	/**
	 * <p><b><i> getCliente</i></b></p>
	 * <pre>public Cliente getCliente()</pre>
	 * @return Retorna el cliente  de la venta en formato <code>Cliente </code>.
	 * @author Nicolas
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * <p><b><i>setCliente</i></b></p>
	 * <pre>public void setCliente(Cliente cliente)</pre>
	 * @param cliente Recibe el cliente de la venta .
	 * @author Nicolas
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * <p><b><i>getVendedor </i></b></p>
	 * <pre>public Vendedor getVendedor() </pre>
	 * @return Retorna el vendedor  de la venta en formato <code> Vendedor</code>.
	 * @author Nicolas
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	/**
	 * <p><b><i>setVendedor</i></b></p>
	 * <pre>public void setVendedor(Vendedor vendedor) </pre>
	 * @param vendedor Recibe el vendedor de la venta .
	 * @author Nicolas
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	/**
	 * <p><b><i>setTotalVenta</i></b></p>
	 * <pre>public void setTotalVenta(double totalVenta)</pre>
	 * @param totalVenta Recibe el total de la venta .
	 * @author Nicolas
	 */
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	/**
	 * <p><b><i>getTotalVenta </i></b></p>
	 * <pre>public double getTotalVenta()</pre>
	 * @return Retorna el totalVentade la venta en formato <code> double</code>.
	 * @author Nicolas
	 */
	public double getTotalVenta() {
		return totalVenta;
	}

	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos de la venta.
	 * @author Nicolas
	 */
	
	@Override
	public String toString() {
		return "\n=========== VENTA ===========" 
		+"\n-id venta: " +getId() 
		+ "\n-fecha de venta: " + getFechaVenta() 
		+  cliente.toString() 
		+ carrito.toString()
		
		+"---------------------------------"
		+ "\n-TOTAL DE LA VENTA: "+ getTotalVenta()
		+ "\n---------------------------------\n";
	}

	
	
	@Override
	public int compareTo(Venta o) {
		// TODO Auto-generated method stub
		return 0;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	/**
	 * <p><b><i>equals</i></b></p>
	 * <pre>public boolean equals (Object obj)</pre>
	 * <p>Sobreescritura del metodo <code>equals(Object obj)</code>. Compara numeros de id.</p>
	 * @return Retorna un <code>boolean</code> indicando si ambas ventas son iguales o no.
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
		Venta other = (Venta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	/**
	 * <p><b><i>toJSONObject</i></b></p>
	 *  <pre>public JSONObject toJSONObject ()</pre>
	 *<p> Metodo que conviete una venta a un objeto de json</p>
	 * @return Retorna un <code>JSONObject</code> con los datos del venta en formato <code>JSON</code>.
	 * @throws JSONException
	 * @author Nicolas
	 */

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
