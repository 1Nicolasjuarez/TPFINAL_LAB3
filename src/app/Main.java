package app;

import java.util.Date;

import archivos.archivoClientes;
import archivos.archivoEmpleados;
import caja.Venta;
import colecciones.CarritoCompra;
import colecciones.Inventario;
import colecciones.ListaEmpleados;
import excepciones.UserException;
import listas.ListadoClientes;
import listas.ListadoEmpleados;
import listas.ListadoVentas;
import modelos.Cliente;
import modelos.Empleado;
import producto.High_top;
import producto.Low_top;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		
		/*
		
		High_top z1 = new High_top(1, "nike" ,"", 32, 600);
		High_top z2 = new High_top(2, "adidas","", 32, 400);
		High_top z3 = new High_top(3, "reekon","", 32, 600);
		High_top z4 = new High_top(4, "fila","", 32, 600);
		
		
		
		
		Cliente cl = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c2= new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c3 = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		
		
		CarritoCompra carrito = new CarritoCompra();
		carrito.agregarAlCarrito(z1);
		carrito.agregarAlCarrito(z2);
		
		
		
		Venta venta = new Venta(new Date(), cl, carrito);
		///System.out.println(venta.toString());
		
		
		ListadoVentas listaVentas = new ListadoVentas();
		
		listaVentas.agregar(venta);
		
		
		System.out.println(listaVentas.listar());
		*/
		
		Cliente c1 = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c2= new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c3 = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		
		ListadoClientes listaCliente = new ListadoClientes();
		
		listaCliente.agregarCliente(c1);
		listaCliente.agregarCliente(c2);
		listaCliente.agregarCliente(c3);
		
		//System.out.println(listaCliente.listarClientes());
		
		archivoClientes.grabarClientes(listaCliente);
		
		ListadoEmpleados listaEmpleado = new ListadoEmpleados();
		Scanner scan = new Scanner(System.in);
		
		Empleado e1 = new Empleado("Esteban", "Quito", 123, 321, "ABC 123", "EstebanQuito", "12345", "Gerente", 40000, 6);
		Empleado e2 = new Empleado("Armando", "Casas", 456, 654, "CBA 321", "ArmandoCasas", "12345", "Vendedor", 30000, 8);
		Empleado e = new Empleado();
		listaEmpleado.agregarEmpleado(e1);
		listaEmpleado.agregarEmpleado(e2);
		
		archivoEmpleados.grabarEmpleados(listaEmpleado);
		archivoEmpleados.leerEmpleados();
		System.out.println(listaEmpleado.listarEmpleados());
		
		System.out.println("Ingrese el DNI del empleado");
		e.setDni(scan.nextInt());
		
		scan.nextLine();
		System.out.println("Ingrese el nombre del empleado");
		e.setNombre(scan.nextLine());
		
		System.out.println("Ingrese el apellido del empleado");
		e.setApellido(scan.nextLine());
		
		System.out.println("Ingrese el número de teléfono");
		e.setTelefono(scan.nextInt());
		
		
		scan.nextLine();
		System.out.println("Ingrese el domicilio");
		e.setDomicilio(scan.nextLine());
		
		System.out.println("Ingrese el nombre de usuario");
		e.setNombreUsuario(scan.nextLine());
		
		System.out.println("Ingrese la contraseña");
		e.setPass(scan.nextLine());
		
		System.out.println("Ingrese el puesto que ocupa");
		e.setPuesto(scan.nextLine());
		
		
		System.out.println("Ingrese el sueldo");
		e.setSueldo(scan.nextDouble());
		
		System.out.println("Ingrese la cantidad de horas que trabaja");
		e.setHorasDeTrabajo(scan.nextInt());
		
		scan.close();
		
		listaEmpleado.agregarEmpleado(e);
		try
		{
			e.registrarCuenta(e, listaEmpleado);
		} 
		catch (UserException ex) {
			
			System.out.println(ex.getMensaje());
		}
		
		
		
	}

}
