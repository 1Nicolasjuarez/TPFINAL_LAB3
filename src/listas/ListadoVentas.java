package listas;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import caja.Venta;
import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;

/**
* <p><b><i>ListadoVentas</i></b></p>
* <pre>public class ListadoVentas implements Serializable</pre>
* <p>Super clase ListadoVentas.</p>
* @author Nicolas
*
*/

public class ListadoVentas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int id=0;
	
	private Listado<Venta> ventas;
	
	/**
	 * <p><b><i>ListadoVentas</i></b></p>
	 * <pre>public ListadoVentas()</pre>
	 * <p>Constructor de la clase <code>ListadoVentas</code>.</p>
	 * @author Nicolas
	 */
	
	public ListadoVentas() {

		ventas = new Listado<Venta>();
	}
	
	/**
	 * <p><b><i>ListadoVentas</i></b></p>
	 * <pre>public ListadoVentas(ListadoVentas listaVentas)</pre>
	 * <p>Constructor de la clase <code>ListadoVentas</code>.</p>
	 * @param LListadoVentas listaVentas
	 * @author Nicolas
	 */
	public ListadoVentas(ListadoVentas listaVentas) {

		ventas = new Listado<Venta>();
		this.agregarListaDeVentas(listaVentas.devolverVentas());
	}
	
	/**
	 * <p><b><i>agregarVenta</i></b></p>
	 *  <pre>public boolean agregarVenta(Venta venta)</pre>
	 *<p> Metodo que agrega una venta  a la lista ventas</p>
	 **@param Venta venta
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	public boolean agregarVenta(Venta venta) {
		venta.setId(id++);
		return ventas.agregarElemento(venta);
	}
	
	
	
	/**
	 * <p><b>listarVentas<i></i></b></p>
	 * <pre>public String listarVentas()  </pre>
	 * @return Retorna el listado de ventas en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarVentas() {
		return ventas.listarElementos();
	}
	
	
	/**
	 * <p><b>cantidadDeVentas<i></i></b></p>
	 * <pre>public int cantidadDeVentas()</pre>
	 * @return Retorna la cantidad de ventas que hay en el listado<code>int </code>.
	 * @author Nicolas
	 */
	public int cantidadDeVentas() {
		return ventas.contarElementos();
	}
	
	/**
	 * <p><b><i>agregarListaDeVentas</i></b></p>
	 * <pre>public void agregarListaDeVentas(ArrayList<Venta> listaDeVentas)</pre>
	 * <p>Agrega varias ventas a la lista de ventas</p>
	 * @param ArrayList<Venta> listaDeVentas
	 * @author Nicolas
	 */
	
	public void agregarListaDeVentas(ArrayList<Venta> listaDeVentas) {
		
		for(Venta venta : listaDeVentas) {
			this.ventas.agregarElemento(venta);
		}
	}
	
	
	/**
	 * <p><b>devolverVentas<i></i></b></p>
	 * <pre>public ArrayList<Venta> devolverVentas() </pre>
	 * @return Retorna todas las ventas en un<code>ArrayList </code>.
	 * @author Nicolas
	 */

	public ArrayList<Venta> devolverVentas() {
		ArrayList<Venta> listaDeVentas = new ArrayList<Venta>();
		
		for(int i = 0 ; i < ventas.contarElementos() ; i++) {
			listaDeVentas.add(ventas.buscarElemento(i));
		}
		
		return listaDeVentas;
	} 
	
	/**
	 * <p><b><i>listarVentasDeUnVendedor</i></b></p>
	 * <pre>public String listarVentasDeUnVendedor(String dni)</pre>
	 * @param String dni
	 * @return Retorna todas las ventas de un vendedor en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	public String listarVentasDeUnVendedor(String dni) {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();

		for(Venta v : arrayVentas) {
			if(v.getVendedor().getDni().equals(dni)) {
				builder.append(v.toString()+"\n");
			}
		}
		
		String ventas = builder.toString();
		if(ventas.isEmpty()) {
			ventas = "No hay ventas registradas";
		}
		
		return ventas;
	}
	
	/**
	 * <p><b><i>listarComprasDeUnCliente</i></b></p>
	 * <pre>public String listarComprasDeUnCliente(String dni)</pre>
	 * @param String dni
	 * @return Retorna todas las compras de un cliente en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	public String listarComprasDeUnCliente(String dni) {
		
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();

		for(Venta v : arrayVentas) {
			if(v.getCliente().getDni().equals(dni)) {
				builder.append(v.toString()+"\n");
			}
		}
		
		String ventas = builder.toString();
		if(ventas.isEmpty()) {
			ventas = "No hay ventas registradas";
		}
		
		return ventas;
	}
	
	
	/**
	 * <p><b>eliminarVenta<i></i></b></p>
	 * <pre>public boolean eliminarVenta(int idVenta) </pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param int idVenta
	 * @author Nicolas
	 * @throws ErrorDeBusquedaExcepcion
	 */
	
	public boolean eliminarVenta(int idVenta)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;

		for (int i = 0; i < ventas.contarElementos(); i++) 
		{
			if(ventas.buscarElemento(i).getId()==idVenta)
			{
				ventas.eliminarElementoIndice(i);
				rta=true;
			}
		}
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Venta no encontrado");
		}
		return rta;
	}
	
	/**
	 * <p><b><i>toJSONarray</i></b></p>
	 *  <pre>public JSONArray toJSONarray ()</pre>
	 *<p> Metodo pasa una lista de ventas a un array de json. Cada venta es un obj json</p>
	 * @return Retorna un <code>JSONArray</code> 
	 * @throws JSONException
	 * @author Nicolas
	 */
	
	public JSONArray toJSONarray () throws JSONException
	{
		JSONArray jsonArray = new JSONArray();
		
		for (int i = 0; i < ventas.contarElementos(); i++)
		{
			
			jsonArray.put(ventas.buscarElemento(i).toJSONObject());
			
		}
		return jsonArray;
	}
	
	
	
	/**
	 * <p><b><i>JSONtoJava</i></b></p>
	 * <pre>public void JSONtoJava(String json)</pre>
	 *<p> Metodo que lee un String de json y lo pasa a un obj java</p>
	 * @throws JSONException
	 * @author Nicolas
	 */
	
	public void JSONtoJava(String json) throws JSONException
	{
		JSONArray jsonObjPadre = new JSONArray(json);

		for (int i = 0; i < jsonObjPadre.length(); i++)
		{
			JSONObject jsonObj =jsonObjPadre.getJSONObject(i); 
			System.out.println("\n----------------------------\n");
			System.out.println("Id de venta: "+jsonObj.get("ID"));
			System.out.println("fecha: "+jsonObj.get("FECHA"));
			System.out.println("Cliente: "+jsonObj.get("CLIENTE"));
			System.out.println("Vendedor: "+jsonObj.get("VENDEDOR"));
			System.out.println("Carrito de compra: "+jsonObj.get("CARRITO"));
			System.out.println("Total de la venta: "+jsonObj.get("MONTO"));
			System.out.println("\n----------------------------\n");
		}
		
	}
	
}
