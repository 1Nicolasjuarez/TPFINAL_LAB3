package colecciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import modelos.Empleado;


public class ListaEmpleados implements Serializable
{

	public static String archivoListaEmpleados = "listaEmpleados.dat";
	private HashSet<Empleado> lista;
	
	public ListaEmpleados()
	{
		lista = new HashSet<Empleado>();
	}
	
	/*
	public void setListaEmpleado() {
		this.lista = new HashSet<Empleado>();
	}
	
	public void setListaUsuario(HashSet<Empleado> listaEmpleado) {
		this.lista = listaEmpleado;
	}

	public HashSet<Empleado> getListaEmpleado() {
		return lista;
	}
	*/
	
	public void agregarEmpleado(Empleado e) 
	{
		lista.add(e);
	}
	
	public boolean comprobarExistencia(String nombreUsuario) //Comprueba si el Nombre de Usuario ya está en uso
	{	
		boolean encontrado = false;
		
		for(Empleado e : lista) 
		{
			if(nombreUsuario.equalsIgnoreCase(e.getNombreUsuario()))
			{
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public void eliminarUsuario(String nombre) //Elimina un usuario buscandolo por nombre
	{	
		lista.remove(obtenerUsuarioPorNombre(nombre));
	}
	
	
	public Empleado obtenerUsuarioPorNombre(String nombreUsuario) //Busca un Empleado
	{	
		Empleado aux = null;
		
		if(comprobarExistencia(nombreUsuario) == true)
		{
			for(Empleado e : lista)
			{
				if(e.getNombreUsuario().equals(nombreUsuario))
				{
					aux = e;
				}
			}
		}
		return aux;
	}
	
	
	public Empleado obtenerEmpleadoPorPosicion(int posicion) //Busca un empleado en la posicion pasada por parametro
	{	
		Empleado aux = null;
		
		int i = 0;
		
		if(posicion < cantidadDeEmpleados())
		{
			for(Empleado e : lista)
			{
				if(i == posicion)
				{
					aux = e;
				}
				i++;
			}
		}
		return aux;
	}
	
	public String listarEmpleados() //Devuelve una lista de los Empleados
	{
		StringBuilder sb = new StringBuilder();
		
		for(Empleado e : lista)
		{
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
	}
	
	public int cantidadDeEmpleados() 
	{
		return lista.size();
	}
	
	/**
	 * Carga la lista con los datos del archivo
	 */
	
	public void cargarLista()	//Carga la lista de Empleados guardada en el archivo
	{
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(archivoListaEmpleados);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Empleado aux;
			
			while ((aux = (Empleado) inputStream.readObject()) != null) 
			{
				agregarEmpleado(aux);	
			}
				inputStream.close();			
		} 
		
		catch (EOFException e) 
		{
			//e.printStackTrace();
		} 
		
		catch (IOException ex) 
		{	
			//ex.printStackTrace();
		} 
		
		catch (ClassNotFoundException ex) 
		{
			//ex.printStackTrace();
		}
	}
	
	/**
	 * Guarda la lista en el archivo
	 */
	public void guardarArchivo() //Guarda la lista de empleados en el archivo
	{	
		int i;
		try 
		{
			
			FileOutputStream fileOutputStream = new FileOutputStream(archivoListaEmpleados);
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			for (i = 0; i < cantidadDeEmpleados(); i++) 
			{
				objectOutputStream.writeObject(obtenerEmpleadoPorPosicion(i));
			}
			objectOutputStream.close();
			
		} 
		
		catch(FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		
		catch(IOException e) 
		{
			//e.printStackTrace();
		}
	}
	
	
	public String leerArchivo() //Lee la información almacenada en el archivo
	{
		String mensaje = "";
		
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(archivoListaEmpleados);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Empleado aux;
			
			
			while ((aux = (Empleado) inputStream.readObject()) != null) 
			{
					mensaje = "Archivo de Empleados: \n" + aux.toString();
			}
			
			inputStream.close();
		} 
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (EOFException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ex) 
		{
			//ex.printStackTrace();
		} 
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
		}
		
		return mensaje;
		
	}
	
	@Override
	public String toString()
	{
		return listarEmpleados();
	}
}