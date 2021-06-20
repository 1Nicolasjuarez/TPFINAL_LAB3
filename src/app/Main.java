package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONException;

import archivos.archivoClientes;
import archivos.archivoProductos;
import caja.Venta;
import colecciones.CarritoCompra;
import excepciones.SneakerException;
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
import utilidades.JsonUtiles;


public class Main {

	public static void main(String[] args) 
	{
			Menu menu = new Menu();
			
			menu.menuPrincipal();
		
	}
}
