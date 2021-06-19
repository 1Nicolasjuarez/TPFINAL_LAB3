package listas;

import java.io.Serializable;
import java.util.ArrayList;


import caja.Venta;
import excepciones.ErrorDeBusquedaExcepcion;
import genericos.Listado;

public class ListadoVentas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int id=0;
	
	private Listado<Venta> ventas;

	public ListadoVentas() {

		ventas = new Listado<Venta>();
	}
	
	public ListadoVentas(ListadoVentas listaVentas) {

		ventas = new Listado<Venta>();
		this.agregarListaDeVentas(listaVentas.devolverVentas());
	}
	
	public boolean agregarVenta(Venta venta) {
		venta.setId(id++);
		return ventas.agregarElemento(venta);
	}
	
	public boolean eliminarVentaObj(Venta venta) {
		return ventas.eliminarElementoObj(venta);
	}
	
	public Venta eliminarVentaIndex(int index) {
		return ventas.buscarElemento(index);
	}
	
	public String listarVentas() {
		return ventas.listarElementos();
	}
	
	public int cantidadDeVentas() {
		return ventas.contarElementos();
	}
	
	
	public void agregarListaDeVentas(ArrayList<Venta> listaDeVentas) {
		
		for(Venta venta : listaDeVentas) {
			this.ventas.agregarElemento(venta);
		}
	}
	

	public ArrayList<Venta> devolverVentas() {
		ArrayList<Venta> listaDeVentas = new ArrayList<Venta>();
		
		for(int i = 0 ; i < ventas.contarElementos() ; i++) {
			listaDeVentas.add(ventas.buscarElemento(i));
		}
		
		return listaDeVentas;
	} 
	
	public String listarVentasDeUnVendedor(String dni) {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();

		for(Venta v : arrayVentas) {
			if(v.getVendedor().getDni().equals(dni)) {
				builder.append(v.toString()+"\n");
			}
		}
		
		String ventas = builder.toString();
		if(ventas.isEmpty()) {
			ventas = "No hay ventas registradas";
		}
		
		return ventas;
	}
	

	
	public String listarVentasDeUnCliente(String dni) {
		
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();

		for(Venta v : arrayVentas) {
			if(v.getCliente().getDni().equals(dni)) {
				builder.append(v.toString()+"\n");
			}
		}
		
		String ventas = builder.toString();
		if(ventas.isEmpty()) {
			ventas = "No hay ventas registradas";
		}
		
		return ventas;
	}
	
	
	public Venta buscarVentaPorID(int id) throws ErrorDeBusquedaExcepcion {
		
		Venta venta = null;
		boolean existe = false;
	
		ArrayList<Venta> arrayVentas = devolverVentas();
		
		for(Venta v : arrayVentas) {
			if(v.getId() == id) {
				venta = v;
				existe = true;
				break;
			}	
		}
		if(!existe) {
			throw new ErrorDeBusquedaExcepcion("Venta no encontrada");
		}
		
		return venta;
	}
	
	
	public String listarVentasConIdVendedorClineteYFecha() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Venta> arrayVentas = devolverVentas();
		
		for(Venta v : arrayVentas) {
			builder.append("ID: "+v.getId()+" - Cliente: "+v.getCliente().getNombre()+" "+v.getCliente().getApellido()
					+" - Vendedor: "+v.getVendedor().getNombre()+" "+v.getVendedor().getApellido()+" - Fecha: "+v.getFechaVenta()+"\n");
			
		}
		if(builder.isEmpty())
		{
			builder.append("No se encontraron registros.");
		}
		
		
		return builder.toString();
	}
	
	public boolean existeVenta(Venta venta) {
		return ventas.existeElemento(venta);
	}
	
	public boolean eliminarVenta(int idVenta)throws ErrorDeBusquedaExcepcion
	{
		boolean rta=false;
		
		//Integer num =indice;
		
		for (int i = 0; i < ventas.contarElementos(); i++) 
		{
			if(ventas.buscarElemento(i).getId()==idVenta)
			{
				ventas.eliminarElementoIndice(i);
				rta=true;
			}
		}
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Venta no encontrado");
		}
		return rta;
	}
	
	
	
}
