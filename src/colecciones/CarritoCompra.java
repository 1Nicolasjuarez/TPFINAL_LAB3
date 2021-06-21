package colecciones;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONException;

import producto.Sneaker;

/**
 * <p><b><i>CarritoCompra</i></b></p>
 * <pre>public class CarritoCompra  implements Serializable</pre>
 * <p>Super clase CarritoCompra.</p>
 * @author Nicolas
 *
 */

public class CarritoCompra  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Sneaker> carrito;
	@SuppressWarnings("unused")
	private double totalCarrito;

	
	
	/**
	 * <p><b><i>CarritoCompra</i></b></p>
	 * <pre>public CarritoCompra ()</pre>
	 * <p>Constructor de la clase <code>CarritoCompra</code>.</p>
	 * @author Nicolas
	 */
	public CarritoCompra() {

		carrito = new ArrayList<Sneaker>();
		totalCarrito = 0;
	}

	
	/**
	 * <p><b><i>agregarAlCarrito</i></b></p>
	 * <pre>public void agregarAlCarrito(Sneaker x)</pre>
	 *<p> Metodo que agrega una sneaker al carrito</p>
	 * @author Nicolas
	 */
	public void agregarAlCarrito(Sneaker x) {
		carrito.add(x);
		//x.cambiarDisponibilidad();
	}

	
	/**
	 * <p><b><i>mostrarCarrito</i></b></p>
	 * <pre>public String mostrarCarrito()</pre>
	 * @return Retorna la lista del carrito en formato <code> String</code>.
	 * @author Nicolas
	 */
	
	public String mostrarCarrito() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < carrito.size(); i++) {
			sb.append("\n"+carrito.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	
	/**
	 * <p><b><i>calcularTotalCarrito</i></b></p>
	 *  <pre>public double calcularTotalCarrito()</pre>
	 *<p> Metodo que calcula la suma del precio de cada sneaker agregada al carrito</p>
	 *@return Retorna el total de la suma de precios del carrito <code>double</code>.
	 * @author Nicolas
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
	
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del metodo <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del carrito.
	 * @author Nicolas
	 */
	@Override
	public String toString() {
		
		String msj = mostrarCarrito();
		//double importe= calcularTotalCarrito();
		
		return "\nlista de productos : "+msj ;
	}
	

}
