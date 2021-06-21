package listas;

import java.io.Serializable;

import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;
import modelos.Cliente;


/**
* <p><b><i>ListadoClientes</i></b></p>
* <pre>public class ListadoClientes implements Serializable</pre>
* <p>Super clase ListadoClientes.</p>
* @author Nicolas
*
*/

public class ListadoClientes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Listado<Cliente> clientes;
	
	
	/**
	 * <p><b><i>ListadoClientes</i></b></p>
	 * <pre>public ListadoClientes()</pre>
	 * <p>Constructor de la clase <code>ListadoClientes</code>.</p>
	 * @author Nicolas
	 */
	
	public ListadoClientes() {	
		clientes = new Listado<Cliente>();
	}
	
	
	/**
	 * <p><b><i>ListadoClientes</i></b></p>
	 * <pre>public ListadoClientes(ListadoClientes listaClientes)</pre>
	 * <p>Constructor de la clase <code>ListadoClientes</code>.</p>
	 * @param ListadoClientes listaClientes
	 * @author Nicolas
	 */
	public ListadoClientes(ListadoClientes listaClientes) {
		
		clientes = new Listado<Cliente>();
		this.agregarListaDeClientes(listaClientes.devolverClientes()); 
	}
	
	
	/**
	 * <p><b><i>agregarCliente</i></b></p>
	 *  <pre>public boolean agregarCliente(Cliente elemento)</pre>
	 *<p> Metodo que agrega un elemento a clientes</p>
	 **@param Cliente elemento
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agregarElemento(elemento);
	}
	
	
	/**
	 * <p><b><i>eliminarClienteObj</i></b></p>
	 *  <pre>public boolean eliminarClienteObj(Cliente elemento)</pre>
	 *<p> Metodo que elimina un elemento de listadoClientes</p>
	 **@param Cliente elemento
	 * @return true si se elimino.
	 * @author Nicolas
	 */
	
	public boolean eliminarClienteObj(Cliente elemento) {
		return clientes.eliminarElementoObj(elemento);
	}
	
	/**
	 * <p><b><i>buscarClienteIndex</i></b></p>
	 *  <pre>public Cliente buscarClienteIndex(int  index)</pre>
	 *<p> Metodo que busca un elemento en listadoClientes</p>
	 **@param index
	 * @return Cliente.
	 * @author Nicolas
	 */
	
	public Cliente buscarClienteIndex(int  index) {
		return clientes.buscarElemento(index);
	}
	
	/**
	 * <p><b>listarClientes<i></i></b></p>
	 * <pre>public String listarClientes() </pre>
	 * @return Retorna el listado de clientes en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarClientes() {
		return clientes.listarElementos();
	}
	
	/**
	 * <p><b>cantidadDeClientes<i></i></b></p>
	 * <pre>public int cantidadDeClientes() </pre>
	 * @return Retorna la cantidad de clientes que hay en el listado<code>int </code>.
	 * @author Nicolas
	 */
	public int cantidadDeClientes() {
		return clientes.contarElementos();
	}
	
	
	/**
	 * <p><b>existeCliente<i></i></b></p>
	 * <pre>public boolean existeCliente(Cliente cliente) </pre>
	 * @return Retorna true si exixte un cliente  en el listado<code>boolean </code>.
	 * @param Cliente cliente
	 * @author Nicolas
	 */
	public boolean existeCliente(Cliente cliente) {
		return clientes.existeElemento(cliente);
	}
	
	/**
	 * <p><b>devolverClientes<i></i></b></p>
	 * <pre>public ArrayList<Cliente> devolverClientes()</pre>
	 * @return Retorna todos los clientes en un<code>ArrayList </code>.
	 * @author Nicolas
	 */
	
	public ArrayList<Cliente> devolverClientes() {
		ArrayList<Cliente> listaDeclientes = new ArrayList<Cliente>();
		
		for(int i = 0 ; i < clientes.contarElementos() ; i++) {
			listaDeclientes.add(clientes.buscarElemento(i));
		}

		return listaDeclientes;
	} 
	
	/**
	 * <p><b>agregarListaDeClientes<i></i></b></p>
	 * <pre>public void agregarListaDeClientes(ArrayList<Cliente> listaDeClientes) </pre>
	 * <p> Metodo que agrega varios clientes a la lista de clientes </p>
	 * @param ArrayList<Cliente> listaDeClientes
	 * @author Nicolas
	 */
	
	public void agregarListaDeClientes(ArrayList<Cliente> listaDeClientes) {
		
		for(Cliente cliente : listaDeClientes) {
			this.clientes.agregarElemento(cliente);
		}
	}	
	
	/**
	 * <p><b>eliminarCliente<i></i></b></p>
	 * <pre>public boolean eliminarCliente(String dni) </pre>
	 * <p> Metodo que elimina un cliente de la lista mediante el dni </p>
	 * @param String dni
	 * @return Recibe true si el elemento se elimino correctamente
	 * @throws ErrorDeBusquedaExcepcion
	 * @author Nicolas
	 */
	
	public boolean eliminarCliente(String dni)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;
		
		for (int i = 0; i < clientes.contarElementos(); i++) 
		{
			if(clientes.buscarElemento(i).getDni().equals(dni))
			{
				clientes.eliminarElementoIndice(i);
				rta=true;
			}
		}
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Cliente no encontrado");
		}
		
		return rta;
		
	}
	
	/**
	 * <p><b>existeCliente<i></i></b></p>
	 * <pre>public boolean eliminarCliente(String dni) </pre>
	 * <p> Metodo que busca si existe  un cliente de la lista mediante el dni </p>
	 * @param String dni
	 * @return Recibe un numero >=0 si se encontro.
	 * @throws ErrorDeBusquedaExcepcion
	 * @author Nicolas
	 */
	public int existeCliente(String dni) throws ErrorDeBusquedaExcepcion
	{
		int resp=-1;	
		boolean existe=false;
				

			for (int i = 0; i < clientes.contarElementos(); i++) 
			{
				if(clientes.buscarElemento(i).getDni().equals(dni))
				{	
					resp=i;
					existe=true;
					
				}		
			}	
			
			if(!existe)
			{
				throw new ErrorDeBusquedaExcepcion("Cliente no encontrado");
			}
						
			return resp;
			
	}
	
	
	/**
	 * <p><b><i>listarClientes1</i></b></p>
	 * <pre>public String listarClientes1()</pre>
	 * @return Retorna todos los clientes en formato <code>String</code>.
	 * @author Nicolas
	 */
	 
	public String listarClientes1()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Cliente> arrayClientes = devolverClientes();
		
		for (Cliente cliente : arrayClientes) 
		{
			
				builder.append(cliente.toString());
				
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	

}
