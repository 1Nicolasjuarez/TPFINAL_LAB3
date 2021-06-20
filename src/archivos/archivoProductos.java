package archivos;

import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import listas.ListadoSneakers;

/**
 * @author Nicolás Juarez
 * 
 * Esta clase posee los métodos para poder almacenar y leer datos de un archivo de Productos.
 * Esta serializada.
 */

public class archivoProductos implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private static String archivoDeProductos = "productos.dat";
	
	
	public static void grabarProductos(ListadoSneakers productos) 
	{	
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		try {
			
			fileOutputStream = new FileOutputStream(archivoDeProductos);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
			objectOutputStream.writeObject(productos);
			
			objectOutputStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 	
	} 
	
	
	
	
	
	public static ListadoSneakers leerProductos() {
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		ListadoSneakers aux = new ListadoSneakers();
		
		
		try {
			fileInputStream = new FileInputStream(archivoDeProductos);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			aux = (ListadoSneakers) objectInputStream.readObject();
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try  {
				objectInputStream.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	return aux;
	}
}
