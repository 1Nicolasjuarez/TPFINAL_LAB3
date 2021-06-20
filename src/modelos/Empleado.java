package modelos;

import archivos.archivoEmpleados;
import excepciones.UserException;
import listas.ListadoEmpleados;

/**
 * @author Damián Andrés Barros
 * 
 * Esta es la clase que permitirá manejar a los empleados.
 * Extiende de Persona.
 */

public class Empleado extends Persona {
	
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

	public Empleado(String nombre, String apellido, String dni, int telefono, String domicilio, String nombreUsuario,
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
	
	
	@Override
	public String toString()
	{
		return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " DNI: " + getDni() + " Teléfono: " + getTelefono() + " Domicilio: " + getDomicilio() + " Nombre de Usuario: " + getNombreUsuario() + " Puesto: " + getPuesto() + " Sueldo: " + getSueldo()	+ " Horas de trabajo: " + getHorasDeTrabajo();
		
	}

}
