package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.MapaGenerico;
import producto.High_top;
import producto.Low_top;
import producto.Mid_cup;
import producto.Sneaker;

public class ListadoSneakers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapaGenerico<String,Sneaker> listSneakers;
	
	
	// Sneaker  
	
	/// sneakers
	
	
	public ListadoSneakers() {
		
		listSneakers= new MapaGenerico<String, Sneaker>();
	}
	
	public ListadoSneakers(ListadoSneakers listaSneakers) {
		
		listSneakers= new MapaGenerico<String, Sneaker>();
	}
	
	public boolean agregarSneaker(Sneaker valor)
	{
		return listSneakers.agregarElemento(valor.getNumeroSerie(), valor);
	}
	
	public boolean eliminarSneaker(String clave)throws ErrorDeBusquedaExcepcion
	{	
		boolean rta=false;
		
		rta=listSneakers.eliminarElemento(clave);
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Sneaker no encontrada");
		}
		
		return rta;
	}
	
	public boolean modificarSneaker(String clave, Sneaker newSneaker) {
		return listSneakers.modificarElemento(clave, newSneaker);
	}
	
	public boolean modificarSneakerPrecio(String clave, double precio) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setPrecio(precio);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return rta;
	}
	
	public boolean modificarSneakerTalle(String clave, double talle) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setTalle(talle);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rta;
	}
	
	public boolean modificarSneakerMarca(String clave, String marca) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setMarca(marca);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rta;
	}
	
	
	
	public String listarSneakers() {
		return listSneakers.listarElementos("CODIGO", "SNEAKER");
	}
	
	public String listarSnk()
	{
		return listSneakers.listarElementos("clave","valor");
	}
	
	
	
	
	public boolean existeSneaker(String codigo)throws ErrorDeBusquedaExcepcion
	{	
		boolean rta=listSneakers.existeClave(codigo);
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Sneaker no encontrada");
		}
		return rta;
	}
	
	
	
	public Sneaker buscarSneaker(String clave) throws ErrorDeBusquedaExcepcion {
		
		Sneaker sneaker = null;
		
		if(existeSneaker(clave)) {
			sneaker = listSneakers.buscarElemento(clave);
		}
		else {
			throw new ErrorDeBusquedaExcepcion("Sneaker no encontrado");
		}
		
		return sneaker;
	}
	
	
	
	public ArrayList<Sneaker> devolverListaDeSneakers() {
		return listSneakers.devolverElementos();
	
	}
	
	public void agragarListaDeSneakers(ArrayList<Sneaker> listaDeSneakers) {
		
		for(Sneaker sneaker : listaDeSneakers) {
			this.listSneakers.agregarElemento(sneaker.getNumeroSerie(),sneaker);
		}
	} 
	
	public String devolverSneakersConSuCodigo() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n\n");
		}
		
		return builder.toString();
	}
	
	
	public String devolverSneakersConSuCodigoYTalle(double talle) {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			if(s.getTalle()==talle)
			{
				builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n\n");

			}
		}
		
		if(builder.isEmpty())
		{
			builder.append("No se ha encontrado la marca, por favor intente de nuevo.");
		}
		return builder.toString();
	}
	
	public String devolverSneakersConSuCodigoYMarca(String marca) {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			if(s.getMarca()==marca)
			{
				builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+"\nTipo de sneaker: "+s.getTipoDeSneakerAbs()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n");

			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("No se ha encontrado la marca, por favor intente de nuevo.");
		}
		
		return builder.toString();
	}
	
	public String devolverSneakersHighTop() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			if( s instanceof High_top)
			{
				builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+"\nTipo de sneaker: "+s.getTipoDeSneakerAbs()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n");

			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("El archivo esta, por favor intente de nuevo.");
		}
		
		return builder.toString();
	}
	
	public String devolverSneakersLowTop() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			if( s instanceof Low_top)
			{
				builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+"\nTipo de sneaker: "+s.getTipoDeSneakerAbs()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n");

			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("El archivo esta, por favor intente de nuevo.");
		}
		
		return builder.toString();
	}
	
	public String devolverSneakersMidCup() {
		StringBuilder builder = new StringBuilder();
		
		ArrayList<Sneaker> arrayDeSneakers = listSneakers.devolverElementos();
		
		for(Sneaker s : arrayDeSneakers)
		{	
			if( s instanceof Mid_cup)
			{
				builder.append("Codigo: "+s.getNumeroSerie()+"\nMarca: "+s.getMarca()+"\nModelo: "+s.getModelo()+"\nTipo de sneaker: "+s.getTipoDeSneakerAbs()+" \nPrecio: "+s.getPrecio()+"\nTalle: "+s.getTalle()+"\n");

			}
			
		}
		
		if(builder.isEmpty())
		{
			builder.append("El archivo esta, por favor intente de nuevo.");
		}
		
		return builder.toString();
	}
	
	
	
	
}
