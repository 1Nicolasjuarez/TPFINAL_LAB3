package local;



import org.json.JSONException;

import archivos.archivoClientes;
import archivos.archivoEmpleados;
import archivos.archivoProductos;
import archivos.archivoVentas;
import caja.Venta;
import excepciones.ErrorDeBusquedaExcepcion;
import listas.ListadoClientes;
import listas.ListadoEmpleados;
import listas.ListadoSneakers;
import listas.ListadoVentas;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Vendedor;
import producto.Sneaker;
import utilidades.JsonUtiles;

/**
 * <p><b><i>Local</i></b></p>
 * <pre>public class Local</pre>
 * <p>Super clase Local.</p>
 * @author Nicolas
 *
 */

public class Local  {

	
	private ListadoClientes listaClientes;
	private  ListadoEmpleados listaEmpleados;
	private ListadoSneakers listaSneakers=new ListadoSneakers();
	private ListadoVentas listaVentas;
	
	/**
	 * <p><b><i>iniciarSistemaArchivos</i></b></p>
	 * <pre>public static void iniciarSistemaArchivos()</pre>
	 * <p>metodo que uso para inicializar crear los archivos y el json</p>
	 * @author Nicolas
	 */
	
	
	public static void iniciarSistemaArchivos()
	{
		ListadoClientes listacliente = new ListadoClientes();
		ListadoEmpleados listaempleados = new  ListadoEmpleados();
		ListadoSneakers listaSnk = new ListadoSneakers();
		ListadoVentas listaventas = new ListadoVentas();
		Local local = new Local(listacliente,listaempleados,listaSnk,listaventas);
		local.guardarDatosLocal();
	}
	
	
	
	/**
	 * <p><b><i>Local</i></b></p>
	 * <pre>public Local()</pre>
	 * <p>Constructor de la clase <code>Local</code>.</p>
	 * @author Nicolas
	 */
	
	public Local() {
		
		listaClientes = new ListadoClientes(archivoClientes.leerClientes());
		listaEmpleados = new ListadoEmpleados(archivoEmpleados.leerEmpleados());
		listaSneakers = archivoProductos.leerProductos();
		listaVentas = new ListadoVentas(archivoVentas.leerVentas());
		
	}
	
	
	/**
	 * <p><b><i>Local</i></b></p>
	 * <pre>ppublic Local(ListadoClientes clientes,ListadoEmpleados empleados,ListadoSneakers sneakers,ListadoVentas ventas)</pre>
	 * <p>Constructor de la clase <code>Local</code>.</p>
	 * @param ListadoClientes clientes
	 * @param ListadoEmpleados empleados
	 * @param ListadoSneakers sneakers
	 * @param ListadoVentas ventas
	 * @author Nicolas
	 */
	
	

	public Local(ListadoClientes clientes,ListadoEmpleados empleados,ListadoSneakers sneakers,ListadoVentas ventas)
	{
		this.listaClientes = clientes;
		this.listaEmpleados= empleados;
		this.listaSneakers = sneakers;
		this.listaVentas= ventas;
		
	}
		
	
	//TODO ver si funciona para modificar las coasas 
	
	public  void LEER()
	{
		ListadoVentas lista = archivoVentas.leerVentas();
		System.out.println(lista.listarVentas());
	}
	
	
	
	/**
	 * <p><b><i>agregarCliente</i></b></p>
	 *  <pre>public boolean agregarCliente(Cliente cliente)</pre>
	 *<p> Metodo que agrega un cliente a listaClientes</p>
	 **@param Cliente cliente
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	
	public boolean agregarCliente(Cliente cliente)
	{
		return listaClientes.agregarCliente(cliente);
	}
	
	/**
	 * <p><b>listarClientes<i></i></b></p>
	 * <pre>public String listarClientes()</pre>
	 * @return Retorna el listado de clientes en formato<code>String </code>.
	 * @author Nicolas
	 */
	
	public String listarClientes()
	{
		return listaClientes.listarClientes1();
	}
	
	/**
	 * <p><b>eliminarCliente<i></i></b></p>
	 * <pre>public boolean eliminarCliente(String dni)</pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param String dni
	 * @author Nicolas
	 */
	
	public boolean eliminarCliente(String dni)
	{
		boolean rta=false;
		
		try {
			rta=listaClientes.eliminarCliente(dni);
		} catch (ErrorDeBusquedaExcepcion e) {
			System.out.println(e.getMessage());
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarClienteDNI<i></i></b></p>
	 * <pre>public boolean modificarClienteDNI(int indice ,String n_dni)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_dni
	 * @author Nicolas
	 */
	
	
	public boolean modificarClienteDNI(int indice ,String n_dni)
	{
			Cliente cliente=null;
			boolean rta = false;
			
			if(indice>=0)
			{
				cliente=listaClientes.buscarClienteIndex(indice);
				cliente.setDni(n_dni);
				rta=true;
			}
			
			return rta;	
	}
	
	
	/**
	 * <p><b>modificarClienteNombre<i></i></b></p>
	 * <pre>public boolean modificarClienteNombre(int indice ,String n_nombre)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_nombre
	 * @author Nicolas
	 */
	
	public boolean modificarClienteNombre(int indice ,String n_nombre)
	{
			Cliente cliente=null;
			boolean rta = false;
			
			if(indice>=0)
			{
				cliente=listaClientes.buscarClienteIndex(indice);
				cliente.setNombre(n_nombre);
				rta=true;
			}
			
			return rta;	
	}
	
	/**
	 * <p><b>modificarClienteApellido<i></i></b></p>
	 * <pre>public boolean modificarClienteApellido(int indice ,String n_apellido)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_apellido
	 * @author Nicolas
	 */
	public boolean modificarClienteApellido(int indice ,String n_apellido)
	{
			Cliente cliente=null;
			boolean rta = false;
			
			if(indice>=0)
			{
				cliente=listaClientes.buscarClienteIndex(indice);
				cliente.setApellido(n_apellido);
				rta=true;
			}
			
			return rta;	
	}
	
	/**
	 * <p><b>modificarClienteTel<i></i></b></p>
	 * <pre>public boolean modificarClienteTel(int indice ,int n_tel)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_tel
	 * @author Nicolas
	 */
	public boolean modificarClienteTel(int indice ,int n_tel)
	{
			Cliente cliente=null;
			boolean rta = false;
			
			if(indice>=0)
			{
				cliente=listaClientes.buscarClienteIndex(indice);
				cliente.setTelefono(n_tel);
				rta=true;
			}
			
			return rta;	
	}
	
	
	/**
	 * <p><b>existeDniCliente<i></i></b></p>
	 * <pre>public int existeDniCliente(String dni) </pre>
	 * @return Retorna un numero >=1 si se encotro el dni <code>int </code>.
	 * @param String dni
	 * @author Nicolas
	 */
	
	public int existeDniCliente(String dni)
	{	
		int i=-1;
		
		try {
			
			i = listaClientes.existeCliente(dni);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			System.out.println(e.getMessage());
		}
		
		return i;
		
	}
	
	/**
	 * <p><b>retornarCliente<i></i></b></p>
	 * <pre>public Cliente retornarCliente(int i) </pre>
	 * @return Retorna un elemento <code>Cliente </code>.
	 * @param int i
	 * @author Nicolas
	 */
	
	public Cliente retornarCliente(int i)
	{
		return listaClientes.buscarClienteIndex(i);
	}
	
	
	
	//TODO inicio de abm empleado
	
	
	/**
	 * <p><b><i>agregarEmpleado</i></b></p>
	 *  <pre>public  boolean agregarEmpleado(Empleado empleado)</pre>
	 *<p> Metodo que agrega un empleado a listaEmpleados</p>
	 **@param Empleado empleado
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	public  boolean agregarEmpleado(Empleado empleado)
	{
		return listaEmpleados.agregarEmpleado(empleado);
		
	}
	
	/**
	 * <p><b>listarVendedores<i></i></b></p>
	 * <pre>public String listarVendedores()</pre>
	 * @return Retorna el listado de vendedores en formato<code>String </code>.
	 * @author Nicolas
	 */
	
	public String listarVendedores()
	{
		return listaEmpleados.devolverVendedores();
	}
	
	/**
	 * <p><b>listarCajeros<i></i></b></p>
	 * <pre>public String listarCajeros()</pre>
	 * @return Retorna el listado de cajeros en formato<code>String </code>.
	 * @author Nicolas
	 */
	
	public String listarCajeros()
	{
		return listaEmpleados.devolverCajeros();
	}
	
	/**
	 * <p><b>listarGerentes<i></i></b></p>
	 * <pre>public String listarGerentes()</pre>
	 * @return Retorna el listado de gerentes en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarGerentes()
	{
		return listaEmpleados.devolverGerentes();
	}
	
	
	/**
	 * <p><b>eliminarEmpleado<i></i></b></p>
	 * <pre>public boolean eliminarEmpleado(String dni)</pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param String dni
	 * @author Nicolas
	 */
	public boolean  eliminarEmpleado(String dni)
	{	
		boolean rta=false;
		
			 try {
				rta=listaEmpleados.eliminarEmpleado(dni);
			} catch (ErrorDeBusquedaExcepcion e) {
				
				System.out.println(e.getMessage());
			}
		return rta;
	}
	
	
	/**
	 * <p><b>modificarEmpleadoNombre<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoNombre(int indice ,String n_nombre)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_nombre
	 * @author Nicolas
	 */
	
	public boolean modificarEmpleadoNombre(int indice ,String n_nombre)
	{
			Empleado empleado=null;
			boolean rta = false;
			
			if(indice>=0)
			{
				empleado=listaEmpleados.buscarEmpleadoIndex(indice);
				empleado.setNombre(n_nombre);
				rta=true;
			}
			
			return rta;	
	}
	
	/**
	 * <p><b>modificarEmpleadoApellido<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoApellido(int indice,String n_apellido)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_apellido
	 * @author Nicolas
	 */
	
	public boolean modificarEmpleadoApellido(int indice,String n_apellido)
	{	
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setApellido(n_apellido);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoDni<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoDni(int indice,String n_dni)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_dni
	 * @author Nicolas
	 */
	
	public boolean modificarEmpleadoDni(int indice,String n_dni)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setDni(n_dni);
			rta=true;
		}
		return rta;
	}
	
	
	/**
	 * <p><b>modificarEmpleadoUser<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoUser(int indice,String n_user)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_user
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoUser(int indice,String n_user)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setNombreUsuario(n_user);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoPass<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoPass(int indice,String n_pass)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_pass
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoPass(int indice,String n_pass)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setPass(n_pass);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoDomicilio<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoDomicilio (int indice,String n_domi)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_domi
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoDomicilio (int indice,String n_domi)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setDomicilio(n_domi);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoSueldo<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoSueldo(int indice,double n_sueldo)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_sueldo
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoSueldo(int indice,double n_sueldo)
	{	
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setSueldo(n_sueldo);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoHorasDeTrabajo<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoHorasDeTrabajo(int indice,int n_horas)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_horas
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoHorasDeTrabajo(int indice,int n_horas)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setHorasDeTrabajo(n_horas);
			rta=true;
		}
		return rta;
	}
	
	/**
	 * <p><b>modificarEmpleadoTelefono<i></i></b></p>
	 * <pre>public boolean modificarEmpleadoTelefono(int indice,int n_tel)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param int indice 
	 * @param String n_tel
	 * @author Nicolas
	 */
	public boolean modificarEmpleadoTelefono(int indice,int n_tel)
	{
		boolean rta = false;
		Empleado empleado=null;
		if(indice>=0)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(indice);
			empleado.setTelefono(n_tel);
			rta=true;
		}
		return rta;
	}
	
	
	/**
	 * <p><b>exixteDniEmpleado<i></i></b></p>
	 * <pre>public int  exixteDniEmpleado(String dni)</pre>
	 * @return Retorna un numero >=1 si se encotro el dni <code>int </code>.
	 * @param String dni
	 * @author Nicolas
	 */
	public int  exixteDniEmpleado(String dni)
	{	
		
		int i=-1;
		
		try {
			
			i = listaEmpleados.existeEmpleado(dni);
			
			
		} catch (ErrorDeBusquedaExcepcion e) {
			

			System.out.println(e.getMessage());
		}
		
		return i;
	}
	
	/**
	 * <p><b>retornarVendedor<i></i></b></p>
	 * <pre>public Vendedor retornarVendedor(int i) </pre>
	 * @return Retorna un elemento <code>Vendedor </code>.
	 * @param int i
	 * @author Nicolas
	 */
	
	public Vendedor retornarVendedor(int i)
	{
		return (Vendedor) listaEmpleados.buscarEmpleadoIndex(i);
	}
	
	//TODO fin de abm EMPLEADO
	
	
	//TODO inicio de abm SNEAKER
	
	/**
	 * <p><b><i>agregarSneaker</i></b></p>
	 *  <pre>public boolean agregarSneaker(Sneaker snks)</pre>
	 *<p> Metodo que agrega una sneaker  a listaSneakers</p>
	 **@param Sneaker snks
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	public boolean agregarSneaker(Sneaker snks)
	{
		return listaSneakers.agregarSneaker(snks);
	}
	
	/**
	 * <p><b>listarHightop<i></i></b></p>
	 * <pre>public String listarHightop()</pre>
	 * @return Retorna el listado de high tops en formato<code>String </code>.
	 * @author Nicolas
	 */
	
	public String listarHightop()
	{
		return listaSneakers.devolverSneakersHighTop();
	}
	
	/**
	 * <p><b>listarLowTop<i></i></b></p>
	 * <pre>public String listarLowTop()</pre>
	 * @return Retorna el listado de low tops en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarLowTop()
	{
		return listaSneakers.devolverSneakersLowTop();
	}
	
	/**
	 * <p><b>listarMidCup<i></i></b></p>
	 * <pre>public String listarMidCup()</pre>
	 * @return Retorna el listado de mid cups en formato<code>String </code>.
	 * @author Nicolas
	 */
	public String listarMidCup()
	{
		return listaSneakers.devolverSneakersMidCup();
	}
	
	
	/**
	 * <p><b>eliminarSneaker<i></i></b></p>
	 * <pre>public boolean eliminarSneaker(String cod)</pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param String codigo
	 * @author Nicolas
	 */
	public boolean eliminarSneaker(String cod)
	{
		boolean rta=false;
		
		 try {
			rta=listaSneakers.eliminarSneaker(cod);
		} catch (ErrorDeBusquedaExcepcion e) {
			
			System.out.println(e.getMessage());
		}
	return rta;
	}
	
	/**
	 * <p><b>modificarSneakerPrecio<i></i></b></p>
	 * <pre>public boolean modificarSneakerPrecio(String clave,double precio)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param String clave 
	 * @param double precio
	 * @author Nicolas
	 */
	
	public boolean modificarSneakerPrecio(String clave,double precio)
	{
		return listaSneakers.modificarSneakerPrecio(clave, precio);
	}
	
	/**
	 * <p><b>modificarSneakerTalle<i></i></b></p>
	 * <pre>public boolean modificarSneakerTalle(String clave,double talle)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param String clave 
	 * @param double talle
	 * @author Nicolas
	 */
	
	public boolean modificarSneakerTalle(String clave,double talle)
	{
		return listaSneakers.modificarSneakerTalle(clave, talle);
	}
	
	/**
	 * <p><b>modificarSneakerMarca<i></i></b></p>
	 * <pre>public boolean modificarSneakerMarca(String clave,String marca)</pre>
	 * @return Retorna true si se modifico correctamente <code>boolean </code>.
	 * @param String clave 
	 * @param dString marca
	 * @author Nicolas
	 */
	public boolean modificarSneakerMarca(String clave,String marca)
	{
		return listaSneakers.modificarSneakerMarca(clave, marca);
	}
	
	
	/**
	 * <p><b>exixteClaveSnk<i></i></b></p>
	 * <pre>public boolean exixteClaveSnk(String clave) </pre>
	 * @return Retorna true si la clave esta en la lista de sneakers <code>boolean </code>.
	 * @param String clave
	 * @author Nicolas
	 */
	
	public boolean exixteClaveSnk(String clave)
	{	
		boolean rta=false;
		try {
			rta= listaSneakers.existeSneaker(clave);
		} catch (ErrorDeBusquedaExcepcion e) {
			
			System.err.println(e.getMessage());
		}
		
		return rta;
	}
	
	/**
	 * <p><b>devolverSneaker<i></i></b></p>
	 * <pre>public Sneaker devolverSneaker(String num) </pre>
	 * @return Retorna el elemento <code>Sneaker </code>.
	 * @param String num
	 * @author Nicolas
	 */
	
	public Sneaker devolverSneaker(String num)
	{	Sneaker sk =null;
		try {
			 sk = listaSneakers.buscarSneaker(num);
		} catch (ErrorDeBusquedaExcepcion e) {
			
			System.out.println(e.getMessage());
		}
		return sk;
		
	}
	
	//TODO FIN de abm SNEAKER
	
	//TODO inicio de abm SNEAKER
	
	
	/**
	 * <p><b><i>agregarVenta</i></b></p>
	 *  <pre>public boolean agregarVenta(Venta venta)</pre>
	 *<p> Metodo que agrega una venta a listaVentas</p>
	 **@param Venta venta
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	public boolean agregarVenta(Venta venta)
	{
		return listaVentas.agregarVenta(venta);
	}
	
	/**
	 * <p><b>listarVentas<i></i></b></p>
	 * <pre>public String listarVentas()</pre>
	 * @return Retorna el listado de ventas en formato<code>String </code>.
	 * @author Nicolas
	 */
	
	public String listarVentas()
	{
		return listaVentas.listarVentas();
	}
	
	/**
	 * <p><b>eliminarVenta<i></i></b></p>
	 * <pre>public boolean eliminarVenta(int id)</pre>
	 * @return Retorna true si se elimino <code>boolean </code>.
	 * @param int id de la venta
	 * @author Nicolas
	 */
	
	public boolean eliminarVenta(int id)
	{
		boolean rta=false;
		
		 try {
			 rta=listaVentas.eliminarVenta(id);
		 } catch (ErrorDeBusquedaExcepcion e) {
				
				System.out.println(e.getMessage());
			}
		return rta;
	}
	
	/**
	 * <p><b>listarVentasDeVendedorDni<i></i></b></p>
	 * <pre>public String listarVentasDeVendedorDni(String dni)</pre>
	 * @return Retorna el listado de ventas de un vendedor  en formato<code>String </code>
	 * @param String dni
	 * @author Nicolas
	 */
	
	public String listarVentasDeVendedorDni(String dni)
	{
		return listaVentas.listarVentasDeUnVendedor(dni);
	}
	
	/**
	 * <p><b>listarComprasDeClienteDni<i></i></b></p>
	 * <pre>public String listarComprasDeClienteDni(String dni)</pre>
	 * @return Retorna el listado de compras de un cliente  en formato<code>String </code>
	 * @param String dni
	 * @author Nicolas
	 */
	public String listarComprasDeClienteDni(String dni)
	{
		return listaVentas.listarComprasDeUnCliente(dni);
		
	}
	
	
	
	/**
	 * <p><b><i>guardarVentasJson</i></b></p>
	 *  <pre>public void guardarVentasJson()</pre>
	 *<p> Metodo guarda las ventas en un json</p>
	 * @author Nicolas
	 */
	public void guardarVentasJson()
	{
		try {
			JsonUtiles.grabar(listaVentas.toJSONarray());
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * <p><b><i>mostrarJsonVentas</i></b></p>
	 *  <pre>public void mostrarJsonVentas()</pre>
	 *<p> Metodo que muestra las ventas de un json</p>
	 * @author Nicolas
	 */
	
	public void mostrarJsonVentas()
	{
		try {
			String msg= JsonUtiles.leer();
			listaVentas.JSONtoJava(msg);
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	/**
	 * <p><b><i>guardarDatosLocal</i></b></p>
	 *  <pre>public void guardarDatosLocal()</pre>
	 *<p> Metodo que guarda los datos de las listas en los archivos y tambien las ventas en el json</p>
	 * @author Nicolas
	 */
	
	public void guardarDatosLocal()
	{
		try {
			
			archivoClientes.grabarClientes(listaClientes);
			archivoEmpleados.grabarEmpleados(listaEmpleados);
			archivoProductos.grabarProductos(listaSneakers);
			archivoVentas.grabarVentas(listaVentas);
			JsonUtiles.grabar(listaVentas.toJSONarray());
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	
	
	
	
	
}
