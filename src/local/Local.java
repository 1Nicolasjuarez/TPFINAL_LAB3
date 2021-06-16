package local;



import archivos.archivoClientes;
import archivos.archivoEmpleados;
import archivos.archivoProductos;
import archivos.archivoVentas;
import excepciones.ErrorDeBusquedaExcepcion;
import listas.ListadoClientes;
import listas.ListadoEmpleados;
import listas.ListadoSneakers;
import listas.ListadoVentas;
import modelos.Cliente;
import modelos.Empleado;

public class Local  {

	
	private ListadoClientes listaClientes;
	private  ListadoEmpleados listaEmpleados;
	private ListadoSneakers listaSneakers;
	private ListadoVentas listaVentas;
	
	
	public Local() {
		
		listaClientes = new ListadoClientes(archivoClientes.leerClientes());
		listaEmpleados = new ListadoEmpleados(archivoEmpleados.leerEmpleados());
		//listaSneakers = new ListadoSneakers(archivoProductos.leerProductos());
		//listaVentas = new ListadoVentas(archivoVentas.leerVentas());
		
	}
	
	/*
	 * ,ListadoEmpleados empleados,ListadoSneakers sneakers ,ListadoVentas ventas
	 */

	public Local(ListadoClientes clientes,ListadoEmpleados empleados)
	{
		this.listaClientes = clientes;
		this.listaEmpleados= empleados;
		//this.listaSneakers = sneakers;
		//this.listaVentas= ventas;
		
	}
	
	public boolean agregarCliente(Cliente cliente)
	{
		return listaClientes.agregarCliente(cliente);
	}
	
	public String listarClientes()
	{
		return listaClientes.listarClientes();
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
	
	
	public  boolean agregarEmpleado(Empleado empleado)
	{
		return listaEmpleados.agregarEmpleado(empleado);
		
	}
	
	
	public boolean  eliminarEmple(String dni)
	{	
		boolean rta=false;
		
			 rta=listaEmpleados.eliminarEmpleado(dni);
		return rta;
	}
	
	
	public void modificarEmpleadoNombre(String dni,String n_nombre)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setNombre(n_nombre);
		}
	}
	public void modificarEmpleadoApellido(String dni,String n_apellido)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setApellido(n_apellido);
		}
	}
	
	public void modificarEmpleadoDni(String dni,String n_dni)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setApellido(n_dni);
		}
	}
	
	public void modificarEmpleadoUser(String dni,String n_user)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setNombreUsuario(n_user);
		}
	}
	
	public void modificarEmpleadoPass(String dni,String n_pass)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setPass(n_pass);
		}
	}
	
	public void modificarEmpleadoDomicilio (String dni,String n_domi)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setDomicilio(n_domi);
		}
	}
	
	
	public void modificarEmpleadoSueldo(String dni,double n_sueldo)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setSueldo(n_sueldo);
		}
	}
	
	public void modificarEmpleadoHorasDeTrabajo(String dni,int n_horas)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setHorasDeTrabajo(n_horas);
		}
	}
	
	public void modificarEmpleadoTelefono(String dni,int n_tel)
	{
		Empleado empleado=null;
		int i=listaEmpleados.modificarEmpleado(dni);
		if(i!=-1)
		{
			empleado=listaEmpleados.buscarEmpleadoIndex(i);
			empleado.setTelefono(n_tel);
		}
	}
	
	
	
	
	
	
	
	
	public void guardarDatosLocal()
	{
		archivoClientes.grabarClientes(listaClientes);
		archivoEmpleados.grabarEmpleados(listaEmpleados);
	}
	
	
	
	
	
	
}
