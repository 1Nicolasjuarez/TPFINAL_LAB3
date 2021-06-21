package listas;

import java.io.Serializable;
import java.util.ArrayList;

import excepciones.ErrorDeBusquedaExcepcion;
import genericos.MapaGenerico;
import producto.High_top;
import producto.Low_top;
import producto.Mid_cup;
import producto.Sneaker;


/**
 * <p><b><i>ListadoSneakers</i></b></p>
 * <pre>public class ListadoSneakers implements Serializable<Venta></pre>
 * <p>Super clase ListadoSneakers.</p>
 * @author Nicolas
 *
 */
public class ListadoSneakers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapaGenerico<String,Sneaker> listSneakers;
	

	/**
	 * <p><b><i>ListadoClientes</i></b></p>
	 * <pre>public ListadoClientes()</pre>
	 * <p>Constructor de la clase <code>ListadoClientes</code>.</p>
	 * @author Nicolas
	 */
	
	public ListadoSneakers() {
		
		listSneakers= new MapaGenerico<String, Sneaker>();
	}
	

	/**
	 * <p><b><i>ListadoSneakers</i></b></p>
	 * <pre>public ListadoSneakers(ListadoSneakers listaSneakers)</pre>
	 * <p>Constructor de la clase <code>ListadoSneakers</code>.</p>
	 * @param ListadoSneakers listaSneakers
	 * @author Nicolas
	 */
	public ListadoSneakers(ListadoSneakers listaSneakers) {
		
		listSneakers= new MapaGenerico<String, Sneaker>();
	}
	
	/**
	 * <p><b><i>agregarSneaker</i></b></p>
	 *  <pre>public boolean agregarSneaker(Sneaker valor)</pre>
	 *<p> Metodo que agrega una sneaker a al listado</p>
	 **@param Sneaker valor
	 * @return true si se agrego.
	 * @author Nicolas
	 */
	
	public boolean agregarSneaker(Sneaker valor)
	{
		return listSneakers.agregarElemento(valor.getNumeroSerie(), valor);
	}
	
	/**
	 * <p><b>eliminarSneaker<i></i></b></p>
	 * <pre>public boolean eliminarSneaker(String clave) </pre>
	 * <p> Metodo que elimina una sneaker de la lista mediante la clave </p>
	 * @param String clave
	 * @return Recibe true si el elemento se elimino correctamente
	 * @throws ErrorDeBusquedaExcepcion
	 * @author Nicolas
	 */
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
	
	
	
	/**
	 * <p><b>modificarSneakerPrecio<i></i></b></p>
	 * <pre>public boolean modificarSneakerPrecio(String clave, double precio) </pre>
	 * <p> Metodo que modicicar una sneaker mediante la clave y el precio </p>
	 * @param String clave double precio
	 * @return Recibe true si el elemento se modifico correctamente
	 * @author Nicolas
	 */
	public boolean modificarSneakerPrecio(String clave, double precio) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setPrecio(precio);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			
			System.err.println(e.getMessage());
		}
		
		return rta;
	}
	
	/**
	 * <p><b>modificarSneakerTalle<i></i></b></p>
	 * <pre>public boolean modificarSneakerTalle(String clave, double talle) </pre>
	 * <p> Metodo que modicicar una sneaker mediante la clave y el talle </p>
	 * @param String clave double talle
	 * @return Recibe true si el elemento se modifico correctamente
	 * @author Nicolas
	 */
	public boolean modificarSneakerTalle(String clave, double talle) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setTalle(talle);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			
			e.printStackTrace();
		}
		
		return rta;
	}
	
	/**
	 * <p><b>modificarSneakerMarca<i></i></b></p>
	 * <pre>public boolean modificarSneakerMarca(String clave, String marca)  </pre>
	 * <p> Metodo que modicicar una sneaker mediante la clave y la marca </p>
	 * @param String clave String clave
	 * @return Recibe true si el elemento se modifico correctamente
	 * @author Nicolas
	 */
	public boolean modificarSneakerMarca(String clave, String marca) 
	{
		boolean rta=false;
		try {
			Sneaker sk=buscarSneaker(clave);
			sk.setMarca(marca);
			
			rta=listSneakers.modificarElemento(clave, sk);
			
		} catch (ErrorDeBusquedaExcepcion e) {
			e.printStackTrace();
		}
		
		return rta;
	}
	
	
	
	public String listarSneakers() {
		return listSneakers.listarElementos("CODIGO", "SNEAKER");
	}
	
	
	/**
	 * <p><b>existeSneaker<i></i></b></p>
	 * <pre>public boolean existeSneaker(String codigo) </pre>
	 * <p> Metodo que verifica si existe una sneakers mediante su clave </p>
	 * @param String codigo
	 * @return Recibe true si el elemento se encuentra en en la lista
	 * @throws ErrorDeBusquedaExcepcion
	 * @author Nicolas
	 */
	public boolean existeSneaker(String codigo)throws ErrorDeBusquedaExcepcion
	{	
		boolean rta=listSneakers.existeClave(codigo);
		
		if(!rta)
		{
			throw new ErrorDeBusquedaExcepcion("Sneaker no encontrada");
		}
		return rta;
	}
	
	
	/**
	 * <p><b>buscarSneaker<i></i></b></p>
	 * <pre>public Sneaker buscarSneaker(String clave) </pre>
	 * <p> Metodo que verifica si existe una sneakers mediante su clave </p>
	 * @param String codigo
	 * @return Recibe true si el elemento se encuentra en en la lista
	 * @throws ErrorDeBusquedaExcepcion
	 * @author Nicolas
	 */
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
	
	
	/**
	 * <p><b>devolverListaDeSneakers<i></i></b></p>
	 * <pre>public ArrayList<Sneaker> devolverListaDeSneakers()</pre>
	 * @return Retorna todas las sneakers en un<code>ArrayList </code>.
	 * @author Nicolas
	 */
	public ArrayList<Sneaker> devolverListaDeSneakers() {
		return listSneakers.devolverElementos();
	
	}
	
	/**
	 * <p><b>agragarListaDeSneakers<i></i></b></p>
	 * <pre>public void agragarListaDeSneakers(ArrayList<Sneaker> listaDeSneakers) </pre>
	 * <p> Metodo que agrega varias sneakers a la lista de sneakers </p>
	 * @param ArrayList<Cliente> listaDeClientes
	 * @author Nicolas
	 */
	
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
	
	
	/**
	 * <p><b><i>devolverSneakersHighTop</i></b></p>
	 * <pre>public String devolverSneakersHighTop()</pre>
	 * @return Retorna todas las sneakers high top de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
	
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
	
	/**
	 * <p><b><i>devolverSneakersLowTop</i></b></p>
	 * <pre>public String devolverSneakersLowTop()</pre>
	 * @return Retorna todas las sneakers low top de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
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
	
	/**
	 * <p><b><i>devolverSneakersMidCup</i></b></p>
	 * <pre>public String devolverSneakersMidCup()</pre>
	 * @return Retorna todas las sneakers mid cup de la lista en formato <code>String</code>.
	 * @author Nicolas
	 */
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
