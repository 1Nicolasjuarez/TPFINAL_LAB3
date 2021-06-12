package listas;

import java.io.Serializable;
import java.util.ArrayList;

import genericos.Listado;
import modelos.Cliente;

public class ListadoClientes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Listado<Cliente> clientes;
	
	public ListadoClientes() {	
		clientes = new Listado<Cliente>();
	}
	
	
	public ListadoClientes(ListadoClientes listaClientes) {
		
		clientes = new Listado<Cliente>();
		this.agregarListaDeClientes(listaClientes.devolverClientes()); 
	}
	
	
	public boolean agregarCliente(Cliente elemento) {
		return clientes.agregarElemento(elemento);
	}
	
	public boolean eliminarCliente(Cliente elemento)
	{
		return clientes.agregarElemento(elemento);
	}
	
	public boolean eliminarClienteObj(Cliente elemento) {
		return clientes.eliminarElementoObj(elemento);
	}
	
	public Cliente eliminarClienteIndex(int  index) {
		return clientes.eliminarElementoIndice(index);
	}
	
	public String listarClientes() {
		return clientes.listarElementos();
	}
	
	
	public int cantidadDeClientes() {
		return clientes.contarElementos();
	}
	
	public boolean existeCliente(Cliente cliente) {
		return clientes.existeElemento(cliente);
	}
	
	public ArrayList<Cliente> devolverClientes() {
		ArrayList<Cliente> listaDeclientes = new ArrayList<Cliente>();
		
		for(int i = 0 ; i < clientes.contarElementos() ; i++) {
			listaDeclientes.add(clientes.buscarElemento(i));
		}

		return listaDeclientes;
	} 
	
	public void agregarListaDeClientes(ArrayList<Cliente> listaDeClientes) {
		
		for(Cliente cliente : listaDeClientes) {
			this.clientes.agregarElemento(cliente);
		}
	}	
	
	

}
