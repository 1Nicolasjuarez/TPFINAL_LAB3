package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.MapaGenerico;
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
	
	public boolean eliminarSneaker(String clave)
	{
		return listSneakers.eliminarElemento(clave);
	}
	
	public boolean modificarSneaker(String clave, Sneaker newSneaker) {
		return listSneakers.modificarElemento(clave, newSneaker);
	}
	
	public String listarSneakers() {
		return listSneakers.listarElementos("CODIGO", "SNEAKER");
	}
	
	
	
	public boolean existeSneaker(String codigo) {
		return listSneakers.existeClave(codigo);
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
}
