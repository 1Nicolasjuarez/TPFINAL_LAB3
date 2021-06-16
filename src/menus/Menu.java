package menus;

import java.util.Scanner;

import local.Local;
import modelos.Cajero;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;

public class Menu {
	
	Scanner scanner=new Scanner(System.in);
	
	Local local = new Local();
	
	
	
	

	public void registrarEmpleado()
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
			
			
			String principalMenu = "\n\n=> MENU REGISTRO\n1.REGISTRO VENDEDOR\n2.REGISTRO CAJERO \n3.REGISTRO GERENTE \n0.SALIR";
			String cont= "s";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			while (cont.equals("s")||cont.equals("S")) 
			{
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					/*
					System.out.println("ingrese nombre:");
					nombre = scanner.next();	
					System.out.println("ingrese apellido:");
					apellido = scanner.next();		
					System.out.println("ingrese dni:");
					dni = scanner.next();
					System.out.println("ingrese telefono:");
					telefono=scanner.nextInt();
					System.out.println("ingrese domicilio:");
					domicilio = scanner.next();
					System.out.println("ingrese nombre de usuario:");
					user = scanner.next();
					System.out.println("ingrese password:");
					pass = scanner.next();
					System.out.println("ingrese sueldo:");
					sueldo = scanner.nextDouble();
					System.out.println("ingrese horas de trabajo:");
					horas=scanner.nextInt();
					 
					Empleado vendedor = new Vendedor(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					
					*/
					Empleado emp3 = new Vendedor("sergio","jua","123",124123,"luro123","nick","asda",32,5);
					boolean rta=local.agregarEmpleado(emp3);
					
					verificacionAgregar(rta);
					menuGerente();
					
					
					
					break;
				case 2:
					System.out.println("ingrese nombre:");
					nombre = scanner.next();		
					System.out.println("ingrese apellido:");
					apellido = scanner.next();	
					System.out.println("ingrese dni:");
					dni = scanner.next();
					System.out.println("ingrese telefono:");
					telefono=scanner.nextInt();
					System.out.println("ingrese domicilio:");
					domicilio = scanner.next();
					System.out.println("ingrese nombre de usuario:");
					user = scanner.next();
					System.out.println("ingrese password:");
					pass = scanner.next();
					System.out.println("ingrese sueldo:");
					sueldo = scanner.nextDouble();
					System.out.println("ingrese horas de trabajo:");
					horas=scanner.nextInt();
					 
					Empleado cajero = new Cajero(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					boolean rta2=local.agregarEmpleado(cajero);
					
					verificacionAgregar(rta2);
					menuGerente();
					
					break;
				
				case 3:
					System.out.println("ingrese nombre:");
					nombre = scanner.next();	
					System.out.println("ingrese apellido:");
					apellido = scanner.next();
					System.out.println("ingrese dni:");
					dni = scanner.next();
					System.out.println("ingrese telefono:");
					telefono=scanner.nextInt();
					System.out.println("ingrese domicilio:");
					domicilio = scanner.next();
					System.out.println("ingrese nombre de usuario:");
					user = scanner.next();
					System.out.println("ingrese password:");
					pass = scanner.next();
					System.out.println("ingrese sueldo:");
					sueldo = scanner.nextDouble();
					System.out.println("ingrese horas de trabajo:");
					horas=scanner.nextInt();
					 
					Empleado gerente = new Gerente(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					boolean rta3=local.agregarEmpleado(gerente);
					
					verificacionAgregar(rta3);
					menuGerente();
					//TODO aca tendria que ir a algun menu
					break;
				case(0):
					System.out.println("Salimos");	
					cont="n";
					menuGerente();
					break;
					
				default:
					System.out.println("Apretaste cualquiera, reidirigido al menu anterior!");
					registrarEmpleado();
	                cont = "S";
					break;
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("Hubo un error \n"+e.getMessage());	
		}
	}
	
	
	public void listarEmpleados()
	{
		try {
			
			String principalMenu = "\n\n=> MENU LISTAR EMPLEADOS\n1.LISTAR VENDEDOR\n2.LISTAR CAJERO \n3.LISTAR GERENTE \n0.SALIR, VOLVER AL MENU ANTERIOR";
			String cont= "s";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			while(cont.equals("s")||cont.equals("S"))
			{
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:
					System.out.println("\nLISTA DE VENDEDORES\n");
					System.out.println(local.listarVendedores());
					menuGerente();
					break;
				case 2:
					System.out.println("\nLISTA DE CAJEROS\n");
					System.out.println(local.listarCajeros());
					menuGerente();
					break;
				case 3:
					System.out.println("\nLISTA DE GERENTES\n");
					System.out.println(local.listarGerentes());
					menuGerente();	
					break;
				case(0):
					System.out.println("Salimos");
					cont="n";
					menuGerente();
					break;
				default:
					System.out.println("Apretaste cualquiera, reidirigido al menu anterior!");
					menuGerente();
	                cont = "S";
					break;
				}
			}
				
			
		} catch (Exception e) {
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
		else
		{
			System.out.println("\nNo se encuentra el dni en la base de datos");
		}
	}
	
	
	
	
	public void eliminarEmpleado()
	{
		System.out.println("\nIngrese dni:");
		String dni = scanner.next();
		
		boolean res=local.eliminarEmple(dni);
		verificacionBorrar(res);
		menuGerente();
	}
	
	
	
	public void modificar()
	{
		local.modificarEmpleadoNombre("123", "raul");
		menuGerente();	
	}
	
	
	
	
	public void menuGerente() 
	{
		try {
			
			String principalMenu = "\n\n=> MENU GERENTE\n1.AGREGAR EMPLEADO\n2.LISTAR EMPLEADOS \n3.MODIFICAR EMPLEADO \n4.ELIMINAR EMPLEADO \n0.SALIR, VOLVER AL MENU ANTERIOR";
			String cont= "s";
			int secondSelect=0;
			System.out.println(principalMenu);
			System.out.print("Seleccione: ");
			
			while(cont.equals("s")||cont.equals("S"))
			{
				secondSelect= scanner.nextInt();
				
				switch (secondSelect) {
				case 1:registrarEmpleado();
					
					break;
				case 2:listarEmpleados();
										
					break;
				case 3:
						modificar();
					break;
				case 4: eliminarEmpleado();
						
					break;
				case 5:
						
					break;

				default:
					break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
