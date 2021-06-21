package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;
import modelos.Cajero;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;


/**
* <p><b><i>ListadoEmpleados</i></b></p>
* <pre>public class ListadoEmpleados implements Serializable</pre>
* <p>Super clase ListadoEmpleados.</p>
* @author Nicolas
*
*/
public class ListadoEmpleados implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Listado<Empleado> empleados;
	
	/**
	 * <p><b><i>ListadoEmpleados</i></b></p>
	 * <pre>public ListadoEmpleados()</pre>
	 * <p>Constructor de la clase <code>ListadoEmpleados</code>.</p>
	 * @author Nicolas
	 */
	
	public ListadoEmpleados() {
		empleados = new Listado<Empleado>();
	}
	
	
	/**
	 * <p><b><i>ListadoEmpleados</i></b></p>
	 * <pre>public ListadoEmpleados(ListadoEmpleados listaEmpleados)</pre>
	 * <p>Constructor de la clase <code>ListadoEmpleados</code>.</p>
	 * @param ListadoEmpleados listaEmpleados
	 * @author Nicolas
	 */
	public ListadoEmpleados(ListadoEmpleados listaEmpleados) {
		
		empleados = new Listado<Empleado>();
		this.agregarListaDeEmpleados(listaEmpleados.devolverEmpleados()); 
	}
	
	
	/**
	 * <p><b><i>agregarEmpleado</i></b></p>
	 *  <pre>public boolean agregarEmpleado(Empleado elemento)</pre>
	 *<p> Metodo que agrega un elemento a empleados</p>
	 **@param Empleado elemento
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	public boolean agregarEmpleado(Empleado elemento) {
		return empleados.agregarElemento(elemento);
	}
	
	/**
	 * <p><b><i>buscarEmpleadoIndex</i></b></p>
	 *  <pre>public Empleado buscarEmpleadoIndex(int  index)</pre>
	 *<p> Metodo que busca un elemento en listado de empleados</p>
	 **@param int index
	 * @return Empleado.
	 * @author Nicolas
	 */
	public Empleado buscarEmpleadoIndex(int  index) {
		return empleados.buscarElemento(index);
	}
	
	/**
	 * <p><b>listarEmpleados<i></i></b></p>
	 * <pre>public String listarEmpleados() </pre>
	 * @return Retorna el listado de empleados en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarEmpleados() {
		return empleados.listarElementos();
	}
	
	/**
	 * <p><b>cantidadDeEmpleados<i></i></b></p>
	 * <pre>public int cantidadDeEmpleados()</pre>
	 * @return Retorna la cantidad de empleados que hay en el listado<code>int </code>.
	 * @author Nicolas
	 */
	public int cantidadDeEmpleados() {
		return empleados.contarElementos();
	}
	
	/**
	 * <p><b>existeEmpleado<i></i></b></p>
	 * <pre>public int existeEmpleado(String dni) </pre>
	 * @return Retorna un numero >=0 si se encotro el dni <code>int </code>.
	 * @param String dni
	 * @author Nicolas
	 * @throws ErrorDeBusquedaExcepcion
	 */
	public int existeEmpleado(String dni) throws ErrorDeBusquedaExcepcion
	{
		int resp=-1;	
		boolean existe=false;
				

			for (int i = 0; i < empleados.contarElementos(); i++) 
			{
				if(empleados.buscarElemento(i).getDni().equals(dni))
				{	
					resp=i;
					existe=true;
					
				}		
			}	
			
			if(!existe)
			{
				throw new ErrorDeBusquedaExcepcion("Empleado no encontrado");
			}
						
			return resp;
			
	}
	
	/**
	 * <p><b>devolverEmpleados<i></i></b></p>
	 * <pre>public ArrayList<Empleado> devolverEmpleados() </pre>
	 * @return Retorna todos los empleados en un<code>ArrayList </code>.
	 * @author Nicolas
	 */
	
	public ArrayList<Empleado> devolverEmpleados() {
		ArrayList<Empleado> listaDeEmpleados = new ArrayList<Empleado>();
		
		for(int i = 0 ; i < empleados.contarElementos() ; i++) {
			listaDeEmpleados.add(empleados.buscarElemento(i));
		}
		
		return listaDeEmpleados;
	} 
	
	
	/**
	 * <p><b>eliminarEmpleado<i></i></b></p>
	 * <pre>public boolean eliminarEmpleado(String dni) </pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param String dni
	 * @author Nicolas
	 * @throws ErrorDeBusquedaExcepcion
	 */
	public boolean eliminarEmpleado(String dni)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;
		
		for (int i = 0; i < empleados.contarElementos(); i++) 
		{
			if(empleados.buscarElemento(i).getDni().equals(dni))
			{
				empleados.eliminarElementoIndice(i);
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
	 * <p><b><i>devolverVendedores</i></b></p>
	 * <pre>public String devolverVendedores()</pre>
	 * @return Retorna todos los vendedores de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
	
	
	public String devolverVendedores()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Vendedor)
			{
				builder.append(empleado.toString());
			}
			
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	
	/**
	 * <p><b><i>devolverCajeros</i></b></p>
	 * <pre>public String devolverCajeros()</pre>
	 * @return Retorna todos los cajeros de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String devolverCajeros()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Cajero)
			{
				builder.append(empleado.toString());
			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	/**
	 * <p><b><i>devolverGerentes</i></b></p>
	 * <pre>public String devolverGerentes()</pre>
	 * @return Retorna todos los gerentes de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
	public String devolverGerentes()
	{
		StringBuilder builder = new StringBuilder();
		ArrayList<Empleado> arrayEmpleados = devolverEmpleados();
		
		for (Empleado empleado : arrayEmpleados) 
		{
			if(empleado instanceof Gerente)
			{
				builder.append(empleado.toString());
			}
			
		}
		if(builder.isEmpty())
		{
			builder.append("El archivo esta vacio.");
		}
		return builder.toString();
		
	}
	
	
	
	
	
	
	
	/**
	 * <p><b><i>agregarListaDeEmpleados</i></b></p>
	 * <pre>public void agregarListaDeEmpleados(ArrayList<Empleado> listaDeEmpleado)</pre>
	 * <p>Agrega varios empleados a la lista de empleados</p>
	 * @param ArrayList<Empleado> listaDeEmpleado
	 * @author Nicolas
	 */
	
	
	
	public void agregarListaDeEmpleados(ArrayList<Empleado> listaDeEmpleado) {
		
		for(Empleado empleado : listaDeEmpleado) {
			this.empleados.agregarElemento(empleado);
		}
	}	
	
	
}
