package menus;

import java.util.Scanner;

import archivos.archivoEmpleados;
import excepciones.UserException;
import local.Local;
import modelos.Cajero;
import modelos.Empleado;
import modelos.Gerente;
import modelos.Vendedor;

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
			double sueldo;
			int horas;
			
			String registro = "REGISTRO DE USUARIO\n\n";
			String puestoEmpleado = "\n\n=> PUESTO DEL EMPLEADO \n 1. VENDEDOR \n 2. CAJERO \n 3. GERENTE \n 0. SALIR";
			String cont= "s";
			
			int secondSelect = 0;
			
			
			System.out.println(registro);
			
			System.out.println("Ingrese el nombre del empleado:");
			nombre = scanner.next();	
			
			if(nombre.equalsIgnoreCase(""))
			{
				throw new UserException("El nombre está vacio ");
			}
			
			System.out.println("Ingrese el apellido del empleado:");
			apellido = scanner.next();		
			
			if(apellido.equalsIgnoreCase(""))
			{
				throw new UserException("El apellido está vacio ");
			}
			
			System.out.println("Ingrese DNI:");
			dni = scanner.next();
			
			System.out.println("Ingrese número de teléfono:");
			telefono=scanner.nextInt();
			
			System.out.println("Ingrese domicilio:");
			domicilio = scanner.next();
			
			System.out.println("Ingrese nombre de usuario:");
			user = scanner.next();
			
			if(user.equalsIgnoreCase(""))
			{
				throw new UserException("El nombre de usuario está vacio ");
			}
			else if(user.length() < 5)
			{
				throw new UserException("El nombre de usuario debe tener al menos cinco caracteres");
			}
			
			System.out.println("Ingrese contraseña:");
			pass = scanner.next();
			
			if(pass.equalsIgnoreCase(""))
			{
				throw new UserException("La contraseña está vacía ");
			}
			
			if(pass.length() < 8)
			{
				throw new UserException("La contraseña debe tener al menos ocho caracteres");
			}
			
			
			System.out.println("Ingrese sueldo:");
			sueldo = scanner.nextDouble();
			
			System.out.println("Ingrese horas de trabajo:");
			horas = scanner.nextInt();
			
			System.out.println(puestoEmpleado);
			
			System.out.print("Seleccione: ");
			secondSelect = scanner.nextInt();
			
			while (cont.equalsIgnoreCase("s")) 
			{
				
				switch (secondSelect)
				{
				case 1: 
					
					emp = new Vendedor(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					
					
					//Empleado emp3 = new Vendedor("sergio","jua","123",124123,"luro123","nick","asda",32,5);
					boolean rta = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta);
					menuGerente();
					
					break;
					
				case 2:
					
					 
					emp = new Cajero(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					
					boolean rta2 = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta2);
					menuGerente();
					
					break;
				
				case 3:
					 
					emp = new Gerente(nombre, apellido, dni, telefono, domicilio, user, pass, sueldo, horas);
					boolean rta3 = local.agregarEmpleado(emp);
					local.guardarDatosLocal();
					
					verificacionAgregar(rta3);
					menuGerente();
					
					break;
					
				case(0):
					
					System.out.println("Lo veré en el futuro... o en el pasado...");	
				
					cont = "n";
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
						
					}while(opcion.equalsIgnoreCase("N"));
					
					menuGerente();
					break;
					
				case 2:
					
					System.out.println("\nLISTA DE CAJEROS\n");
					
					do
					{
						System.out.println(local.listarCajeros());
						System.out.println("Presione N para volver");
						opcion = scanner.nextLine();
						
					}while(opcion.equalsIgnoreCase("N"));
					
					menuGerente();
					break;
					
				case 3:
					System.out.println("\nLISTA DE GERENTES\n");
					
					do
					{
					System.out.println(local.listarGerentes());
					System.out.println("Presione N para volver");
					opcion = scanner.nextLine();
					
					}while(opcion.equalsIgnoreCase("N"));
					
					menuGerente();	
					break;
					
				case(0):
					System.out.println("\n\n\n");
					cont = "n";
					
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
		System.out.println("\nIngrese DNI:");
		String dni = scanner.next();
		
		boolean res = local.eliminarEmple(dni);
		
		verificacionBorrar(res);
		menuGerente();
	}
	
	
	
	public void menuModificar()
	{
		int opcion = -1;
		String dni = "";
		String nombre = "";
		String apellido = "";
		String nuevoDni = "";
		String nombreUsuario = "";
		String pass = "";
		String domicilio = "";
		double sueldo = 0;
		int horasDeTrabajo = 0;
		int numTelefono = 0;
		
		String cont = "S";
		
		
		String menuModificar = "\n\n=> MENU MODIFICAR\n 1. MODIFICAR NOMBRE DEL EMPLEADO\n 2. MODIFICAR EL APELLIDO DEL EMPLEADO\n 3. MODIFICAR EL DNI DEL EMPLEADO\n 4. MODIFICAR EL NOMBRE DE USUARIO\n 5. MODIFICAR LA CONTRASEÑA\n 6. MODIFICAR EL DOMICILIO\n 7. MODIFICAR EL SUELDO\n 8. MODIFICAR LA CANTIDAD DE HORAS DE TRABAJO\n 9. MODIFICAR EL NUMERO DE TELÉFONO\n 0. VOLVER";
		
		do
		{
			switch(opcion)
			{
			case 1:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo nombre");
				nombre = scanner.nextLine();
				
				local.modificarEmpleadoNombre(dni, nombre);
				
				menuModificar();
				break;
				
			case 2:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo apellido");
				apellido = scanner.nextLine();
				
				local.modificarEmpleadoApellido(dni, nombre);
				
				menuModificar();
				break;
				
			case 3:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo DNI");
				nuevoDni = scanner.nextLine();
				
				local.modificarEmpleadoDni(dni, nuevoDni);
				
				menuModificar();
				break;
				
			case 4:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo apellido");
				nombreUsuario = scanner.nextLine();
				
				local.modificarEmpleadoUser(dni, nombreUsuario);
				
				menuModificar();
				break;
				
			case 5:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo apellido");
				pass = scanner.nextLine();
				
				local.modificarEmpleadoApellido(dni, pass);
				
				menuModificar();
				break;
				
			case 6:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo domicilio");
				domicilio = scanner.nextLine();
				
				local.modificarEmpleadoApellido(dni, domicilio);
				
				menuModificar();
				break;
				
			case 7:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo sueldo");
				sueldo = scanner.nextDouble();
				
				local.modificarEmpleadoSueldo(dni, sueldo);
				
				menuModificar();
				break;
				
			case 8:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese la nueva cantidad de horas de trabajo");
				horasDeTrabajo = scanner.nextInt();
				
				local.modificarEmpleadoHorasDeTrabajo(dni, horasDeTrabajo);
				
				menuModificar();
				break;
				
			case 9:
				System.out.println("Ingrese el DNI del empleado");
				dni = scanner.nextLine();
				
				System.out.println("Ingrese el nuevo número de teléfono");
				numTelefono = scanner.nextInt();
				
				local.modificarEmpleadoTelefono(dni, numTelefono);
				
				menuModificar();
				break;
				
			case 0:
				System.out.println("\n\n\n");
				cont = "n";
				menuGerente();	
				break;
				
				
			default:
				System.out.println("Apretaste cualquiera, reidirigido al menu anterior!");
				menuGerente();
				cont = "S";
				break;
			}
			
		}while(cont.equalsIgnoreCase("s"));
		
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
						menuModificar();
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
