package archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import genericos.Listado;



public class archivoProductos implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private static String archivoDePersonas = "productos.dat";
	
	
	public static void grabarProductos(Listado productos) 
	{	
		
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		
		try {
			
			fileOutputStream = new FileOutputStream(archivoDePersonas);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
			objectOutputStream.writeObject(productos);
			
			objectOutputStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 	
	} 
	
	
	
	
	
	public static Listado leerProductos() {
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Listado aux = new Listado();
		
		
		try {
			fileInputStream = new FileInputStream(archivoDePersonas);
			objectInputStream = new ObjectInputStream(fileInputStream);
			
			aux = (Listado) objectInputStream.readObject();
			
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
