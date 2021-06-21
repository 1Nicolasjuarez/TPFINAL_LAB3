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

public class Local  {

	
	private ListadoClientes listaClientes;
	private  ListadoEmpleados listaEmpleados;
	private ListadoSneakers listaSneakers=new ListadoSneakers();
	private ListadoVentas listaVentas;
	
	public static void iniciarSistemaArchivos()
	{
		ListadoClientes listacliente = new ListadoClientes();
		ListadoEmpleados listaempleados = new  ListadoEmpleados();
		ListadoSneakers listaSnk = new ListadoSneakers();
		ListadoVentas listaventas = new ListadoVentas();
		Local local = new Local(listacliente,listaempleados,listaSnk,listaventas);
		local.guardarDatosLocal();
	}
	
	
	public Local() {
		
		listaClientes = new ListadoClientes(archivoClientes.leerClientes());
		listaEmpleados = new ListadoEmpleados(archivoEmpleados.leerEmpleados());
		listaSneakers = archivoProductos.leerProductos();
		listaVentas = new ListadoVentas(archivoVentas.leerVentas());
		
	}
	
	
	/*
	 * ,ListadoEmpleados empleados,ListadoSneakers sneakers ,ListadoVentas ventas
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
	
	public boolean agregarCliente(Cliente cliente)
	{
		return listaClientes.agregarCliente(cliente);
	}
	
	public String listarClientes()
	{
		return listaClientes.listarClientes1();
	}
	
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
	
	
	
	
	
	
	
	
	public int existeDniCliente(String dni)
	{	
		int i=-2;
		
		try {
			
			i = listaClientes.existeCliente(dni);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			System.out.println(e.getMessage());
		}
		
		return i;
		
	}
	
	public Cliente retornarCliente(int i)
	{
		return listaClientes.buscarClienteIndex(i);
	}
	
	
	
	//TODO inicio de abm empleado
	
	
	
	public  boolean agregarEmpleado(Empleado empleado)
	{
		return listaEmpleados.agregarEmpleado(empleado);
		
	}
	
	public String listarVendedores()
	{
		return listaEmpleados.devolverVendedores();
	}
	
	public String listarCajeros()
	{
		return listaEmpleados.devolverCajeros();
	}
	
	public String listarGerentes()
	{
		return listaEmpleados.devolverGerentes();
	}
	
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
	
	
	public boolean eliminarCliente2(String dni)
	{
		boolean rta=false;
		
		try {
			rta=listaClientes.eliminarCliente(dni);
		} catch (ErrorDeBusquedaExcepcion e) {
			System.out.println(e.getMessage());
		}
		return rta;
	}
	
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
	
	public boolean modificarEmpleadoApellido(int indice,String n_apellido)throws ErrorDeBusquedaExcepcion
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
	
	public int  exixteDniEmpleado(String dni)
	{	
		
		int i=-2;
		
		try {
			
			i = listaEmpleados.existeEmpleado(dni);
			
			
		} catch (ErrorDeBusquedaExcepcion e) {
			

			System.out.println(e.getMessage());
		}
		
		return i;
	}
	
	public Vendedor retornarVendedor(int i)
	{
		return (Vendedor) listaEmpleados.buscarEmpleadoIndex(i);
	}
	//TODO fin de abm EMPLEADO
	
	//TODO inicio de abm SNEAKER
	
	public boolean agregarSneaker(Sneaker snks)
	{
		return listaSneakers.agregarSneaker(snks);
	}
	
	//TODO arreglar esta cosa por dios
	
	public String listarHightop()
	{
		return listaSneakers.devolverSneakersHighTop();
	}
	
	public String listarLowTop()
	{
		return listaSneakers.devolverSneakersLowTop();
	}
	
	public String listarMidCup()
	{
		return listaSneakers.devolverSneakersMidCup();
	}
	
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
	
	public boolean modificarSneakerPrecio(String clave,double pre)
	{
		return listaSneakers.modificarSneakerPrecio(clave, pre);
	}
	
	public boolean modificarSneakerTalle(String clave,double talle)
	{
		return listaSneakers.modificarSneakerTalle(clave, talle);
	}
	
	public boolean modificarSneakerMarca(String clave,String marca)
	{
		return listaSneakers.modificarSneakerMarca(clave, marca);
	}
	
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
	
	public boolean agregarVenta(Venta venta)
	{
		return listaVentas.agregarVenta(venta);
	}
	
	public String listarVentas()
	{
		return listaVentas.listarVentas();
	}
	
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
	
	
	
	public String listarVentasDeVendedorDni(String dni)
	{
		return listaVentas.listarVentasDeUnVendedor(dni);
	}
	
	public String listarComprasDeClienteDni(String dni)
	{
		return listaVentas.listarComprasDeUnCliente(dni);
		
	}
	
	
	
	
	public void guardarVentasJson()
	{
		try {
			JsonUtiles.grabar(listaVentas.toJSONarray());
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void mostrarJsonVentas()
	{
		try {
			String msg= JsonUtiles.leer();
			listaVentas.JSONtoJava(msg);
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	
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
