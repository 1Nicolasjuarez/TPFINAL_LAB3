package menus;

import java.util.Date;
import java.util.Scanner;



import caja.Venta;
import colecciones.CarritoCompra;
import excepciones.SneakerException;
import excepciones.UserException;
import local.Local;
import modelos.Cajero;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;
import producto.High_top;
import producto.Low_top;
import producto.Mid_cup;
import producto.Sneaker;

public class Menu 
{
	
	Scanner scanner = new Scanner(System.in);
	
	Local local = new Local();
	
	
	
	public void registrarEmpleado() throws UserException
	{
		Empleado emp = new Empleado();
		try {
			
			String nombre;
			String apellido;
			String dni;
			int telefono;
			String domicilio;
			String user;
			String pass;
			Double sueldo;
			int horas;
			
			String registro = "REGISTRO DE USUARIO\n\n 1. CONTINUAR\n 0. SALIR";
			String puestoEmpleado = "\n\n=> PUESTO DEL EMPLEADO \n 1. VENDEDOR \n 2. CAJERO \n 3. GERENTE";
			
			int secondSelect = -1;
			int continuarSalir = -1;
			
			
			System.out.println(registro);
		
			do
			{
				
				continuarSalir = scanner.nextInt();
				
			}while(continuarSalir != 1 && continuarSalir != 2);
			
			if(continuarSalir == 1)
			{
			do
			{
				System.out.println("Ingrese el nombre del empleado:");
				nombre = scanner.next();	
				
				if(nombre.equalsIgnoreCase(""))
				{
					throw new UserException("El nombre est� vacio. Intente nuevamente");
				}
				
			}while(nombre.equalsIgnoreCase(""));
			
			
			do
			{
				System.out.println("Ingrese el apellido del empleado:");
				apellido = scanner.next();		
				
				if(apellido.equalsIgnoreCase(""))
				{
					throw new UserException("El apellido est� vacio. Intente nuevamente");
				}	
			}while(apellido.equalsIgnoreCase(""));
			
			
			do
			{
				
				System.out.println("Ingrese DNI:");
				dni = scanner.next();
				
				if(dni.equalsIgnoreCase(""))
				{
					throw new UserException("El DNI est� vac�o. Intente nuevamente");
				}
				else if(dni.length() < 8)
				{
					throw new UserException("La cantidad de digitos del DNI es menor a 8. Intente nuevamente");
				}
				
			}while(dni.equalsIgnoreCase("") && dni.length() < 8);
			
			
				System.out.println("Ingrese n�mero de tel�fono:");
				telefono=scanner.nextInt();		
			
			do
			{
				System.out.println("Ingrese domicilio:");
				domicilio = scanner.next();
				
				if(domicilio.equalsIgnoreCase(""))
				{
					throw new UserException("El domicilio est� vac�o. Intente nuevamente");
				}
				
			}while(domicilio.equalsIgnoreCase(""));
			
			do
			{
				
				System.out.println("Ingrese nombre de usuario:");
				user = scanner.next();
				
				if(user.equalsIgnoreCase(""))
				{
					throw new UserException("El nombre de usuario est� vacio. Intente nuevamente ");
				}
				else if(user.length() < 5)
				{
					throw new UserException("El nombre de usuario debe tener al menos cinco caracteres. Intente nuevamente");
				}
				
			}while(user.equalsIgnoreCase("") && user.length() < 5);
			
			
			do
			{
				System.out.println("Ingrese contrase�a:");
				pass = scanner.next();
				
				if(pass.equalsIgnoreCase(""))
				{
					throw new UserException("La contrase�a est� vac�a. Intente nuevamente ");
				}
				
				if(pass.length() < 8)
				{
					throw new UserException("La contrase�a debe tener al menos ocho caracteres. Intente nuevamente");
				}
				
			}while(pass.equalsIgnoreCase("") && pass.length() < 8);
			
				
				System.out.println("Ingrese sueldo:");
				sueldo = scanner.nextDouble();
				
			
			System.out.println("Ingrese horas de trabajo:");
			horas = scanner.nextInt();
			
			System.out.println(puestoEmpleado);
			
			do
			{
			System.out.print("Seleccione: ");
			secondSelect = scanner.nextInt();
			
			}while(secondSelect != 1 && secondSelect != 2 && secondSelect != 3);
			
				switch (secondSelect)
				{
				case 1: 
					
					emp = new Vendedor(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					
					
					//Empleado emp3 = new Vendedor("sergio","jua","123",124123,"luro123","nick","asda",32,5);
					boolean rta = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta);
					menuABMempleado();
					
					break;
					
				case 2:
					
					 
					emp = new Cajero(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					
					boolean rta2 = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta2);
					menuABMempleado();
					
					break;
				
				case 3:
					 
					emp = new Gerente(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					boolean rta3 = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta3);
					menuABMempleado();
					
					break;
					
				case(0):
					
					System.out.println("Lo ver� en el futuro... o en el pasado...");	
				
					menuABMempleado();
					break;
					
				default:
					System.out.println("Apretaste cualquiera, reidirigido al menu anterior!");
					registrarEmpleado();
					break;
				}
			}
			else if(continuarSalir == 0)
			{
				menuABMempleado();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	public void listarEmpleados()
	{
		
		String opcion = null;
		try {
			
			String principalMenu = "\n\n=> MENU LISTAR EMPLEADOS \n 1.LISTAR VENDEDORES \n 2. LISTAR CAJERO \n 3. LISTAR GERENTE \n 0. SALIR, VOLVER AL MENU ANTERIOR";
			String cont = "s";
			
			int secondSelect = 0;
			
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			
			while(cont.equalsIgnoreCase("s"))
			{
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					
					System.out.println("\nLISTA DE VENDEDORES\n");
					
					do
					{
						System.out.println(local.listarVendedores());	
						System.out.println("Presione N para volver");
						opcion = scanner.nextLine();
						
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMempleado();
					break;
					
				case 2:
					
					System.out.println("\nLISTA DE CAJEROS\n");
					
					do
					{
						System.out.println(local.listarCajeros());
						System.out.println("Presione N para volver");
						opcion = scanner.nextLine();
						
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMempleado();
					break;
					
				case 3:
					System.out.println("\nLISTA DE GERENTES\n");
					
					do
					{
					System.out.println(local.listarGerentes());
					System.out.println("Presione N para volver");
					opcion = scanner.nextLine();
					
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMempleado();	
					break;
					
				case(0):	

					System.out.println("Volviendo al menu anterior");
					
					menuABMempleado();

					break;
					
				default:
					System.out.println("Opcion incorrecta!");
					listarEmpleados();
	                
					break;
				}
			}
		}	
			
		
			catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	private void verificacionAgregar(boolean rta)
	{
		
		
		if(rta==true)
		{
			System.out.println("\nAgregado correctamente");
		}
		else
		{
			System.out.println("\nHa ocurrido un error");
		}
	}
	
	private void verificacionBorrar(boolean rta)
	{
		
		
		if(rta==true)
		{
			System.out.println("\nEliminado correctamente");
		}
		
	}
	
	private void verificacionModidicar(boolean rta)
	{
			
		if(rta==true)
		{
			System.out.println("\nModificado correctamente");
		}
		
	}
	

	public void eliminarEmpleado()
	{
		System.out.println("\nIngrese DNI:");
		String dni = scanner.next();
		

		boolean res = local.eliminarEmpleado(dni);
	
	
		verificacionBorrar(res);
		menuABMempleado();
	}
	

	public void menuModificarEmpleado(int v_indice)
	{
		try {
			
			String nombre;
			String apellido;
			String dni;
			int telefono;
			String domicilio;
			String user;
			String pass;
			double sueldo;
			int horas;
			
			String principalMenu = "\n\n=> MENU MODIFICACION DE EMPLEADO\n1.MODIFICAR NOMBRE\n2.MODIFICAR APELLIDO \n3.MODIFICAR DNI \n4.MODIFICAR TELEFONO \n5.MODIFICAR DOMICILIO \n6.MODIFICAR USUARIO \n7.MODIFICAR PASS \n8.MODIFICAR SUELDO \n9.MODIFICAR HORAS DE TRABAJO \n0.SALIR, VOLVER AL MENU ANTERIOR";
			
			int secondSelect = -1;
			
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			secondSelect= scanner.nextInt();
			
			switch (secondSelect) {
			case 1:	
				
				System.out.println("\nIngrese nuevo nombre:");
				nombre = scanner.next();
				boolean rta=local.modificarEmpleadoNombre(v_indice, nombre);
				verificacionModidicar(rta);
				menuABMempleado();	
				break;
			case 2:
				System.out.println("\nIngrese nuevo apellido :");
				apellido = scanner.next();	
				boolean rta2=local.modificarEmpleadoApellido(v_indice, apellido);
				verificacionModidicar(rta2);
				menuABMempleado();	
				break;
			case 3:
				System.out.println("\nIngrese nuevo dni:");
				dni = scanner.next();
				boolean rta3=local.modificarEmpleadoDni(v_indice, dni);
				verificacionModidicar(rta3);
				menuABMempleado();
				break;
			case 4:
				System.out.println("\nIngrese nuevo telefono:");
				telefono = scanner.nextInt();
				boolean rta4=local.modificarEmpleadoTelefono(v_indice, telefono);
				verificacionModidicar(rta4);
				menuABMempleado();
				break;
			case 5:
				System.out.println("\nIngrese nuevo domicilio:");
				domicilio = scanner.next();
				boolean rta5=local.modificarEmpleadoDomicilio(v_indice, domicilio);
				verificacionModidicar(rta5);
				menuABMempleado();
				break;
			case 6:
				System.out.println("\nIngrese nuevo usuario:");
				user = scanner.next();
				boolean rta6=local.modificarEmpleadoUser(v_indice, user);
				verificacionModidicar(rta6);
				menuABMempleado();
				break;
			case 7:
				System.out.println("\nIngrese nuevo pass:");
				pass = scanner.next();
				boolean rta7=local.modificarEmpleadoPass(v_indice, pass);
				verificacionModidicar(rta7);
				menuABMempleado();
				break;
			case 8:
				System.out.println("\nIngrese nuevo sueldo:");
				sueldo = scanner.nextDouble();
				boolean rta8=local.modificarEmpleadoSueldo(v_indice, sueldo);
				verificacionModidicar(rta8);
				menuABMempleado();
				break;
			case 9:
				System.out.println("\nIngrese nuevas horas de trabajo:");
				horas= scanner.nextInt();
				boolean rta9=local.modificarEmpleadoHorasDeTrabajo(v_indice, horas);
				verificacionModidicar(rta9);
				menuABMempleado();
				break;
			case(0):
				System.out.println("Volviendo al menu anterior");
				
				menuABMempleado();
				break;
			default:
				System.out.println("Opcion incorrecta!");
				menuABMempleado();  
				break;
			}
						
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	
	
	public void menuABMempleado() 

	{
		try {
			
			String principalMenu = "\n\n=> MENU GERENTE\n1.AGREGAR EMPLEADO\n2.LISTAR EMPLEADOS \n3.MODIFICAR EMPLEADO \n4.ELIMINAR EMPLEADO \n0.SALIR, VOLVER AL MENU ANTERIOR";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			

				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					
					try
					{
						registrarEmpleado();
						
					}
					catch(UserException e)
					{
						System.out.println(e.getMensaje());
					}
					
					break;
					
				case 2:
					listarEmpleados();
										
					break;
				case 3:
						System.out.println("Ingrese dni:");
						String dni=scanner.next();
						
						int indice = local.exixteDniEmpleado(dni);
						
						if(indice>=0)
						{	
							//System.out.println(indice);
							
							menuModificarEmpleado(indice);
						}
						else
						{
							menuABMempleado();
						}
						
					break;
				case 4: eliminarEmpleado();
						
					break;
				case(0):
					System.out.println("Volviendo al menu anterior");
					menuGenerte();
					break;
				default:
					System.out.println("Opcion incorrecta!");
					menuABMempleado();
					break;
				}
			
			
			
		} 
		catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
			
		}
		
	}
	
	
	
	
	public void registarSneaker() throws SneakerException
	{
		try {
			
			String numeroSerie;
			String marca;
			String modelo;
			double talle;
			double precio;
			
			String principalMenu = "\n\n=> MENU AGREGAR SNEAKER\n 1. CONTINUAR\n 0.SALIR, VOLVER AL MENU ANTERIOR";
			int secondSelect = -1;
			int continuarSalir = -1;
			
			String SeleccionTipo = "\\n\\n=> MODELO\n 1.HIGH TOP\n 2.LOW TOP\n 3.MID TOP";
			
			
			do
			{
				System.out.println(principalMenu);
				continuarSalir = scanner.nextInt();	
				
			}while(continuarSalir != 1 && continuarSalir != 0);
			
			if(continuarSalir == 1)
			{
				
			
			do
			{
				System.out.println("ingrese numero de serie:");
				numeroSerie = scanner.next();
				
				if(numeroSerie.equalsIgnoreCase(""))
				{
					throw new SneakerException("El n�mero de serie est� vac�o. Intente nuevamente");
				}
				
			}while(numeroSerie.equalsIgnoreCase(""));
			
			do
			{
				System.out.println("ingrese marca:");
				marca = scanner.next();
				
				if(marca.equalsIgnoreCase(""))
				{
					throw new SneakerException("El nombre de la marca est� vac�o. Intente nuevamente");
				}
				
			}while(marca.equalsIgnoreCase(""));
			
			do
			{
				System.out.println("ingrese modelo");
				modelo = scanner.next();
				
				if(modelo.equalsIgnoreCase(""))
				{
					throw new SneakerException("El modelo est� vac�o. Intente nuevamente");
				}
				
			}while(modelo.equalsIgnoreCase(""));
			
			
				System.out.println("ingrese talle:");
				talle= scanner.nextDouble();
				
				System.err.println("ingrese precio:");
				precio= scanner.nextDouble();	
			
				
				do
				{
					System.out.println(SeleccionTipo);
					secondSelect = scanner.nextInt();
					
				}while(secondSelect != 1 && secondSelect != 2 && secondSelect != 3);
				
				
				switch (secondSelect) {
				case 1:
					
					//Sneaker s1 = new High_top("1111", "nike" ,"force", 32, 600);
					
					Sneaker s1 = new High_top(numeroSerie, marca, modelo, talle, precio);
					boolean rta = local.agregarSneaker(s1);
					verificacionAgregar(rta);
					menuABMstock();
					break;			
					
				case 2:
					
					Sneaker s2 = new Low_top(numeroSerie, marca, modelo, talle, precio);
					boolean rta2 = local.agregarSneaker(s2);
					verificacionAgregar(rta2);
					menuABMstock();			
					break;
					
				case 3:

					Sneaker s3 = new Mid_cup(numeroSerie, marca, modelo, talle, precio);
					boolean rta3 = local.agregarSneaker(s3);
					verificacionAgregar(rta3);
					menuABMstock();	
					break;
				
				case(0):
					System.out.println("Volviendo al menu anterior");
					
					menuABMstock();
					
					break;

				default:
					System.out.println("Opcion incorrecta!");
					registarSneaker();
	                
					break;
				}
			}
			
			else if(continuarSalir == 0)
			{
				menuABMstock();
			}
			
					
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	
	public void listarSneakers()
	{
		String opcion = "";
		try {
			
			String principalMenu = "\n\n=> MENU LISTAR SNEAKER\n1.LISTAR HIGH TOP\n2.LISTAR LOW TOP \n3.LISTAR MID CUP \n0.SALIR, VOLVER AL MENU ANTERIOR";
			
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");	
			
			
					secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					
					do
					{
						
						System.out.println("\nLISTA DE HIGH TOPS\n");
						System.out.println(local.listarHightop());
						System.out.println("Presione N para salir");
						
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMstock();
					break;
					
				case 2:
					
					do
					{
						System.out.println("\nLISTA DE LOW TOPS\n");
						System.out.println(local.listarLowTop());
						System.out.println("Presione N para salir");
						
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMstock();
					break;
					
				case 3:
					
					do
					{
						System.out.println("\nLISTA DE MID CUPS\n");
						System.out.println(local.listarMidCup());
						System.out.println("Presione N para salir");
						
					}while(!opcion.equalsIgnoreCase("N"));
					
					menuABMstock();	
					break;
					
					
				case(0):
					System.out.println("Volviendo al menu anterior");
					
					menuABMstock();
					break;
				default:

					System.out.println("Opcion incorrecta!");
					listarSneakers();
	               
					break;
				}
				
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
		
	}
	
	
	public void eliminarSneaker()
	{
		System.out.println("\nIngrese numero de serie:");
		String numSerie = scanner.next();
		
		boolean res=local.eliminarSneaker(numSerie);
		verificacionBorrar(res);
		menuABMstock();
	}
	
	
	public void menuModificarSneaker(String v_clave)
	{
		
		try {
			String marca;
			double precio;
			double talle;
			
			String principalMenu = "\n\n=> MENU MODIFICACION DE SNEAKER\n1.MODIFICAR MARCA \n2.MODIFICAR PRECIO  \n3.MODIFICAR TALLE \n0.SALIR, VOLVER AL MENU ANTERIOR";

			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					System.out.println("\nIngrese nueva marca:");
					marca = scanner.next();
					boolean rta=local.modificarSneakerMarca(v_clave, marca);
					verificacionModidicar(rta);
					menuABMstock();
					break;
				case 2:
					System.out.println("\nIngrese nuevo precio:");
					precio = scanner.nextDouble();
					boolean rta2=local.modificarSneakerPrecio(v_clave, precio);
					verificacionModidicar(rta2);
					menuABMstock();
					break;
				case 3:
					System.out.println("\nIngrese nuevo talle:");
					talle = scanner.nextDouble();
					boolean rta3=local.modificarSneakerTalle(v_clave, talle);
					verificacionModidicar(rta3);
					menuABMstock();
					break;
				case(0):
					System.out.println("Volviendo al menu anterior");
					
					menuABMstock();
					break;

				default:
					System.out.println("Opcion incorrecta!");
					menuABMstock();
	                
					break;
				}
				
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
			
	}
	
	public boolean existeClaveSneaker(String clave)
	{	
		return local.exixteClaveSnk(clave);
	}
	
	
	public void menuABMstock()
	{
		try {
			
			String principalMenu = "\n\n=> MENU STOCK\n1.AGREGAR SNEAKER\n2.LISTAR SNEAKER \n3.MODIFICAR SNEAKER \n4.ELIMINAR SNEAKER \n0.SALIR, VOLVER AL MENU ANTERIOR";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					
					try
					{
						registarSneaker();
					}
					catch(SneakerException e)
					{
						System.out.println(e.getMensaje());
					}
					
					break;
				case 2:
					listarSneakers();
										
					break;
				case 3:
						
					System.out.println("ingrese clave");
					String clave=scanner.next();
					
					boolean rta = existeClaveSneaker(clave);
					if(rta==true)
					{
						menuModificarSneaker(clave);
					}
					else
					{
						menuABMstock();
					}
				
						
					break;
				case 4:eliminarSneaker();;
						
					break;
				case(0):
					System.out.println("Volviendo al menu anterior");

					menuGenerte();
					break;
				default:
					System.out.println("Opcion incorrecta!");
					menuABMstock();
	               
					break;
				}
			
				
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
		
		
	}
	
	
	
	public void menuModificarCliente(int v_indice)
	{
		try {
			
			String nombre;
			String apellido;
			String dni;
			int telefono;
			
			String principalMenu = "\n\n=> MENU MODIFICACION DE CLIENTE\n1.MODIFICAR NOMBRE\n2.MODIFICAR APELLIDO \n3.MODIFICAR DNI \n4.MODIFICAR TELEFONO  \n0.SALIR, VOLVER AL MENU ANTERIOR";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					System.out.println("\nIngrese nuevo nombre:");
					nombre = scanner.next();
					boolean rta=local.modificarClienteNombre(v_indice, nombre);
					verificacionModidicar(rta);
					menuABMCliente();
					break;
				case 2:
					System.out.println("\nIngrese nuevo apellido :");
					apellido = scanner.next();	
					boolean rta2=local.modificarClienteApellido(v_indice, apellido);
					verificacionModidicar(rta2);
					menuABMCliente();
					break;
				case 3:
					System.out.println("\nIngrese nuevo dni:");
					dni = scanner.next();
					boolean rta3=local.modificarClienteDNI(v_indice, dni);
					verificacionModidicar(rta3);
					menuABMCliente();
					
					
					break;
				case 4:
					System.out.println("\nIngrese nuevo telefono:");
					telefono = scanner.nextInt();
					boolean rta4=local.modificarClienteTel(v_indice, telefono);
					verificacionModidicar(rta4);
					menuABMCliente();
					break;
				case(0):
					System.out.println("Volviendo al menu anterior");
					
					menuABMCliente();
					break;
				default:
					System.out.println("Opcion incorrecta!");
					menuABMCliente();
	                
					break;
				}
				
		} catch (Exception e) {

			System.out.println("Hubo un error \n"+e.getMessage());
		}
	}
	
	
	public void eliminarCliente()
	{
		System.out.println("\nIngrese dni:");
		String dni = scanner.next();
		
		boolean res=local.eliminarCliente(dni);
		verificacionBorrar(res);
		menuABMCliente();
	}
	
	
	
	
	
	
	public void menuABMCliente()
	{
		try {
			
			String principalMenu = "\n\n=> MENU ABM CLIENTE\n1.AGREGAR CLIENTE\n2.LISTAR CLIENTE \n3.MODIFICAR CLIENTE \n4.ELIMINAR CLIENTE \n0.SALIR, VOLVER AL MENU ANTERIOR";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			secondSelect= scanner.nextInt();
			
			switch (secondSelect) {
			case 1: System.out.println("Registrar cliente");
					agregarClienteGerente();
					
				break;
			case 2:
					System.out.println("Listar");
					System.out.println(local.listarClientes());
					menuABMCliente();
				break;
			case 3:
				System.out.println("Ingrese DNI:");
				String dni=scanner.next();
				int indice = local.existeDniCliente(dni);
				if(indice>=0)
				{	
					//System.out.println(indice);
					
					menuModificarCliente(indice);
				}
				else
				{
					
					menuABMCliente();
				}
				break;
			case 4:
				eliminarCliente();
				break;
			case (0):
				System.out.println("Volviendo al menu anterior");
				menuGenerte();
				
				break;

			default:
				System.out.println("Opcion incorrecta!");
				menuABMCliente();
				break;
			}	
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
		
		
	}
	
	
	public void agregarClienteCajero()
	{
		
			String nombre;
			String apellido;
			String dni;
			int telefono;
			String domicilio;
			
			System.out.println("ingrese nombre:");
			nombre=scanner.next();
			System.out.println("ingrese apellido:");
			apellido=scanner.next();
			System.out.println("ingrese dni:");
			dni=scanner.next();
			System.out.println("ingrese telefono:");
			telefono=scanner.nextInt();
			System.out.println("domicilio:");
			domicilio=scanner.next();
			
			Cliente cliente = new Cliente(nombre, apellido, dni, telefono, domicilio);		
			boolean resp =local.agregarCliente(cliente);		
			if(resp==true)
			{
				System.out.println("cliente agregado correctamente");
			}
			else
			{
				System.out.println("cliente no se ha agregado correctamente");
			}
			
			menuABMCajero();
		
		
		
	}
	
	public void agregarClienteGerente()
	{
		
			String nombre;
			String apellido;
			String dni;
			int telefono;
			String domicilio;
			
			System.out.println("ingrese nombre:");
			nombre=scanner.next();
			System.out.println("ingrese apellido:");
			apellido=scanner.next();
			System.out.println("ingrese dni:");
			dni=scanner.next();
			System.out.println("ingrese telefono:");
			telefono=scanner.nextInt();
			System.out.println("domicilio:");
			domicilio=scanner.next();
			
			Cliente cliente = new Cliente(nombre, apellido, dni, telefono, domicilio);		
			boolean resp =local.agregarCliente(cliente);		
			if(resp==true)
			{
				System.out.println("cliente agregado correctamente");
			}
			else
			{
				System.out.println("cliente no se ha agregado correctamente");
			}
			
			menuABMCliente();
		
		
		
	}
	
	
	
	
	
	
	public Cliente menu_retornarCliente(String dni)
	{	
		
		Cliente cliente=null;
		int i=local.existeDniCliente(dni);
		
		if(i>=0)
		{
			cliente = local.retornarCliente(i);
		}
		
		
		 
		 
		 
		return cliente;
	}
	
	
	//TODO CONSULTAR ---------------------
	
	public Vendedor menu_retornarVendedor(String dni)
	{
		
		Vendedor vende=null;
		
		int i=local.exixteDniEmpleado(dni);
		
		if(i>=0)
		{
			vende= local.retornarVendedor(i);
		}
		
		return  vende;
		
	}
	
	public Sneaker menu_retornarSneaker(String numero)
	{
		Sneaker sn = local.devolverSneaker(numero);
		
		return sn;
		
	}
	
	
	public CarritoCompra menuCarrito()
	{
		CarritoCompra carrito = new CarritoCompra();
		Sneaker snk =null;
		
		char mander = 's';
		int op=1;
	
		while(mander=='s')
		{
		
			switch (op) {
			case 1:	System.out.println("ingrese numero de serie:");
					String numero = scanner.next();
			
					snk= menu_retornarSneaker(numero);		
					carrito.agregarAlCarrito(snk);
					
				break;	
			}
				
			System.out.println("deseas seguir agregando  sneakers ? s para si");
			scanner.nextLine();
			mander = scanner.nextLine().charAt(0);
			
		}
		
		return carrito;
		
	}
	
	public void nuevaVenta()
	{
		try {
			
			Cliente cliente = null;
			Vendedor vendedor =null;
			CarritoCompra carrito= null;
			int secondSelect=0;
			
			char mander='s';
			
			while (mander=='s') 
			{	
				
				
				String principalMenu2 = "\n\n=> MENU VENTA \n1.AGREGAR CLIENTE\n2.AGREGAR VENDEDOR \n3.AGREGAR AL CARRITO \n4.FINALIZAR VENTA \n0.SALIR, VOLVER AL MENU ANTERIOR";
				System.out.println(principalMenu2);
				System.out.print("Seleccione: ");
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1: 
					System.out.println("ingrese dni del cliente");
					String dni= scanner.next();
					cliente = menu_retornarCliente(dni);
					
					
					if(cliente!=null)
					{
						System.out.println("cliente agregado correctamente");
						
					}
					
					
					break;
				case 2:
					System.out.println("ingrese dni del vendedor");
					String dni2= scanner.next();
					vendedor = (Vendedor) menu_retornarVendedor(dni2);		
					if(vendedor!=null)
					{	
						System.out.println("vendedor agregado correctamente");
						
					}
									
					break;
				case 3:carrito=menuCarrito();
						
					break;
				case 4: 
						
						if(cliente==null && vendedor==null && carrito ==null)
						{
							System.out.println("no se puedo registrar la venta");
						}
						else
						{
				
							Venta  venta = new Venta(new Date(), cliente, vendedor, carrito);		
							boolean agre =local.agregarVenta(venta);
							System.out.println(agre);
							System.out.println("TOTAL A PAGAR:"+venta.getTotalVenta());
							
						}
					
					
						menuABMCajero();
					break;
				case (0):
					System.out.println("Volviendo al menu anterior");
					menuABMCajero();
					
					break;
				default:
					System.out.println("Opcion incorrecta!");
					nuevaVenta();
					break;
				}
				
					
				mander = 's';
				
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	
	
	public void menuABMCajero()
	{
		
		
		try {
			
			String principalMenu = "\n\n=> MENU CAJERO\n1.NUEVA VENTA \n2.LISTAR VENTAS \n3.ELIMINAR VENTA \n4.AGREGAR CLIENTE \n5.LISTAR HISTORIAL DE COMPRAS DE UN CLIENTE\n0.SALIR, VOLVER AL MENU ANTERIOR";

			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			
			secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1: nuevaVenta();
						menuABMCajero();	
					break;
				case 2:
					System.out.println("LISTA DE VENTAS:");
					
					System.out.println(local.listarVentas());
					menuABMCajero();
					break;
				case 3:
					System.out.println("ingrese id de venta");
					int b = scanner.nextInt();
					
					boolean rta4 = local.eliminarVenta(b);
					
					if(rta4==true)
					{	
						System.out.println("eliminado con exito");
						
					}
					
					menuABMCajero();
					break;
				case 4:
						agregarClienteCajero();
					break;
				case 5:
						System.out.println("ingrese dni del cliente");
						String dni=scanner.next();
						System.out.println(local.listarComprasDeClienteDni(dni));
				break;
				case (0): 
					System.out.println("Volviendo al menu anterior");
					menuPrincipal();
					break;
				default:
					System.out.println("Opcion incorrecta!");
					menuABMCajero();
					break;
				}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+"ocurrio un error");
		}
		
		
	}
	
	
	
	public void menuGenerte()
	{
		try {
			
			String principalMenu = "\n\n=> MENU GERENTE\n1.ABM STOCK\n2.ABM EMPLEADOS \n3.ABM CLIENTES \n0.SALIR,VOLVER AL MENU ANTERIOR";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			secondSelect= scanner.nextInt();
			
			switch (secondSelect) {
			case 1:	menuABMstock();
				
				break;
			case 2:
					menuABMempleado();		
				break;
			case 3:
					menuABMCliente();
				break;
			case (0):
				System.out.println("Volviendo al menu anterior");
				menuPrincipal();
				break;

			default:
				System.out.println("Opcion incorrecta!");
				menuGenerte();
				
				break;
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	
	
	public void menuPrincipal()
	{
		
		try {
			String principalMenu = "\n\n=> MENU PRINCIPAL\n1.MENU GERENTE\n2.MENU CAJERO \n3.MENU VENDEDOR \n4.GUARDAR DATOS  \n5.LEER DATOS JSON VENTAS \n0.SALIR DEL SISTEMA";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			secondSelect= scanner.nextInt();
			
			switch (secondSelect) {
			case 1:
					menuGenerte();
				break;
			case 2:menuABMCajero();
							
				break;
			case 3: //menuVendedor donde ve sus ventas
					System.out.println("ingrese dni del vendedor");
					String dni = scanner.next();
					
					System.out.println(local.listarVentasDeVendedorDni(dni));
				
				break;
			case 4:// guardar datos
					local.guardarDatosLocal();
					menuPrincipal();
				break;
			case 5:// guardar datos GUARDAR EL JSON CON LAS VENTAS 
					
					local.mostrarJsonVentas();
					menuPrincipal();
					// VER EL JSON DE VENTAS
				
						//local.guardarVentasJson();
			break;
			
			case 8 : 
				local.LEER();
			
			break;
			
			case (0): 
				System.out.println("SALIENDO DEL SISTEMA, VUELVA PRONTOS");
				System.exit(0);
				
				break;

			default:
				System.out.println("Opcion incorrecta!");
				menuPrincipal();
				break;
			}	
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
		
	}
		
		
	}
	
	

