package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import archivos.archivoClientes;
import caja.Venta;
import colecciones.CarritoCompra;
import excepciones.UserException;
import listas.ListadoClientes;
import listas.ListadoEmpleados;
import listas.ListadoSneakers;
import listas.ListadoVentas;
import local.Local;
import menus.Menu;
import modelos.Cajero;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;
import producto.High_top;
import producto.Low_top;


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
		
		/*
		
		Cliente c1 = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c2= new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		Cliente c3 = new Cliente("luis", "tools", 2185122, 223504523, "chaco 332");
		
		ListadoClientes listaCliente = new ListadoClientes();
		
		listaCliente.agregarCliente(c1);
		listaCliente.agregarCliente(c2);
		listaCliente.agregarCliente(c3);
		
		//System.out.println(listaCliente.listarClientes());
		
		archivoClientes.grabarClientes(listaCliente);
		*/
		
		/*
		
		High_top z1 = new High_top("1111", "nike" ,"force", 32, 600);
		High_top z2 = new High_top("2222", "adidas","garache", 33, 400);
		High_top z3 = new High_top("3333", "reekon","sport", 33, 600);
		High_top z4 = new High_top("4444", "adidas","runner", 32, 600);
		
		
		ListadoSneakers  lista = new ListadoSneakers();
		
		lista.agregarSneaker(z1);
		lista.agregarSneaker(z2);
		lista.agregarSneaker(z3);
		lista.agregarSneaker(z4);
		
		//lista.agregarSneaker("2", z2);
		//lista.agregarSneaker("1", z3);
		//lista.agregarSneaker("1", z4);

		System.out.println(lista.listarSneakers());
		
	
		
		
		//System.out.println(lista.devolverSneakersConSuCodigoYTalle(32));
		
		//System.out.println(lista.devolverSneakersConSuCodigoYMarca("adidas"));
		  
		 Vendedor v1 = new Vendedor();
		Vendedor v2 = new Vendedor();
		
		High_top z1 = new High_top("1111", "nike" ,"force", 32, 600);
		High_top z2 = new High_top("2222", "adidas","garache", 33, 400);
		Cliente c1 = new Cliente("luis", "tools", "2185122", 223504523, "chaco 332");
		Cliente c2= new Cliente("luis", "tools", "2185122", 223504523, "chaco 332");
		
		
		CarritoCompra carri = new CarritoCompra();
		carri.agregarAlCarrito(z2);
		carri.agregarAlCarrito(z1);
		
		
		Venta venta1 = new Venta(new Date(), c1, v1, carri);
		
		Venta venta2 = new Venta(new Date(), c2, v2, carri);
		
		ListadoVentas listaVentas = new ListadoVentas();
		listaVentas.agregarVenta(venta1);
		listaVentas.agregarVenta(venta2);
		
		
		System.out.println(listaVentas.listarVentas());
		
		
		
		Cliente c2= new Cliente("luis", "tools", "2185122", 223504523, "chaco 332");
		
		Local local = new Local();
		
		//local.agregarCliente(c2);
		
		
		
		
		System.out.println(local.listarClientes());
		
		
		local.guardarDatosLocal();
		
		*/
		//Cliente c1 = new Cliente("luis", "tools", "2185122", 223504523, "chaco 332");
		
		//ListadoClientes listcli = new ListadoClientes();
		
		//listcli.agregarCliente(c1);
		
		
		
		ListadoClientes listacliente = new ListadoClientes();
		ListadoEmpleados listaempleados = new  ListadoEmpleados();
		
		
		
		
		//Local local = new Local(listacliente,listaempleados);
		//local.guardarDatosLocal();
		
		/*
		try {
			
			Menu menu = new Menu();
			
			//menu.registrarEmpleado();
			
			menu.menuGerente();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		Menu menu = new Menu();
		try {
			menu.registrarEmpleado();
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMensaje());
		}
		
		
		/*
		Empleado emp1 = new Vendedor("nico","jua","123123",124123,"luro123","nick","asda",32,5);
		Empleado emp2 = new Vendedor("raul","jua","33333",124123,"luro123","nick","asda",32,5);
		Empleado emp3 = new Gerente("sergio","jua","22222",124123,"luro123","nick","asda",32,5);
		
		
		ListadoEmpleados lista = new ListadoEmpleados();
		lista.agregarEmpleado(emp1);
		lista.agregarEmpleado(emp2);
		lista.agregarEmpleado(emp3);
		
		System.out.println(lista.listarEmpleados());
		
		System.out.println(lista.devolverVendedores());
		System.out.println(lista.devolverCajeros());
		System.out.println(lista.devolverGerentes());
		
		
		
		//
		
		//System.out.println(array.toString());
		
		*/
	}
}
