package modelos;

import archivos.archivoEmpleados;
import colecciones.ListaEmpleados;
import excepciones.UserException;
import listas.ListadoEmpleados;

public class Empleado extends Persona {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	private String pass;
	private String puesto;
	private double sueldo;
	private int horasDeTrabajo;

	public Empleado() {
		super();
		nombreUsuario = "";
		pass = "";
		puesto = "";
		sueldo = 0;
		horasDeTrabajo = 0;
	}

	public Empleado(String nombre, String apellido, int dni, int telefono, String domicilio, String nombreUsuario,
			String pass, String puesto, double sueldo, int horasDeTrabajo) {
		super(nombre, apellido, dni, telefono, domicilio);
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.horasDeTrabajo = horasDeTrabajo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getHorasDeTrabajo() {
		return horasDeTrabajo;
	}

	public void setHorasDeTrabajo(int horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	}
	
	
	

	// TODO
	// revisarStock()
	
	
	public boolean comprobarExistenciaPorNombreDeUsuario(String nombreUsuario) //Busca a un empleado por su nombre de usuario
	{	
		boolean encontrado = false;
		
		ListadoEmpleados lista = new ListadoEmpleados();
		
		for(Empleado e : lista.getEmpleados())
		{
			if(nombreUsuario.equalsIgnoreCase(e.getNombreUsuario()))
			{
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public Empleado obtenerEmpleadoPorNombreDeUsuario(String nombreUsuario) //Retorna a un empleado buscandolo por su nombre de usuario
	{
		Empleado aux = null;
		ListadoEmpleados lista = new ListadoEmpleados();
		
		if(comprobarExistenciaPorNombreDeUsuario(nombreUsuario) == true)
		{
			for(Empleado e : lista.getEmpleados())
			{
				if(e.getNombreUsuario().equals(nombreUsuario))
				{
					aux = e;
				}
			}
		}
		return aux;
	}
	
	
	public boolean comprobarExistenciaPorDNI(int dni) //Busca a un empleado por su DNI
	{	
		boolean encontrado = false;
		
		ListadoEmpleados lista = new ListadoEmpleados();
		
		for(Empleado e : lista.getEmpleados())
		{
			if(dni == e.getDni())
			{
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	public Empleado obtenerEmpleadoPorDNI(int dni) //Retorna un empleado buscandolo por DNI
	{
		Empleado aux = null;
		ListadoEmpleados lista = new ListadoEmpleados();
		
		if(comprobarExistenciaPorDNI(dni) == true)
		{
			for(Empleado e : lista.getEmpleados())
			{
				if(e.getDni() == dni)
				{
					aux = e;
				}
			}
		}
		return aux;
	}
	
	
	public void registrarCuenta(Empleado e, ListadoEmpleados lista) throws UserException
	{
			int dni = e.getDni();
		
			if(obtenerEmpleadoPorDNI(dni) != null)
			{
				throw new UserException("Ya existe un empleado registrado con ese DNI");
			}
			
			
			if(e.getNombreUsuario().equalsIgnoreCase(""))
			{
				throw new UserException("El nombre de usuario está vacio ");
			}
			else if (e.getNombreUsuario().length() <= 5)
			{
				throw new UserException("El nombre de usuario debe superar como mínimo cinco caracteres");
			}
			
			e.setNombreUsuario(nombreUsuario);
			
			
			if(e.getPass().equalsIgnoreCase(""))
			{
				throw new UserException("La contraseña está vacia");
			} 
			else if (e.getPass().length() <= 8)
			{
				throw new UserException("La contraseña debe superar como mínimo ocho caracteres");
			}
			
			e.setPass(pass);
			
			if(obtenerEmpleadoPorNombreDeUsuario(e.getNombreUsuario()) == null)	// Si no existe un usuario con ese nombre se guarda en el archivo
			{
				lista.agregarEmpleado(e);
				archivoEmpleados.grabarEmpleados(lista);
			}
			else
			{
				throw new UserException("Ya existe un usuario con ese nombre.");
			}
		}
	
	
	public void loginUsuario(ListaEmpleados lista, String nombreUsuario, String pass) throws UserException
	{
		
		if(nombreUsuario.equalsIgnoreCase(""))
		{
			throw new UserException("El nombre de usuario está vacío ");
		}
		
		if(pass.equalsIgnoreCase(""))
		{
			throw new UserException("La contraseña está vacia");
		} 
		else if (pass.length() <= 8)
		{
			throw new UserException("La contraseña debe superar como minimo ocho caracteres");
		}
		
		if((obtenerEmpleadoPorNombreDeUsuario(nombreUsuario)) != null)
		{
			//TODO
			//Enviarlo al menú
			System.out.println("Menú");
		}
		else
		{
			throw new UserException("Este usuario no esta registrado.");
		}
		
	}
	
	@Override
	public String toString()
	{
		return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " DNI: " + getDni() + " Teléfono: " + getTelefono() + " Domicilio: " + getDomicilio() + " Nombre de Usuario: " + getNombreUsuario() + " Puesto: " + getPuesto() + " Sueldo: " + getSueldo()	+ " Horas de trabajo: " + getHorasDeTrabajo();
		
	}

}
