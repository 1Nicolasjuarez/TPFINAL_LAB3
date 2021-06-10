package listas;

import java.io.Serializable;
import java.util.ArrayList;

import genericos.Listado;
import modelos.Proveedor;

public class ListadoProveedores implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Listado<Proveedor> proveedores;
	
	public ListadoProveedores() {
		proveedores = new Listado<Proveedor>();
	}
	
	public ListadoProveedores(ListadoProveedores listaProveedores) {
		
		proveedores = new Listado<Proveedor>();
		this.agregarListaDeProveedores(listaProveedores.devolverProveedores()); 
	}
	
	public boolean agregarProveedor(Proveedor elemento) {
		return proveedores.agregarElemento(elemento);
	}
	
	public boolean eliminarProveedor(Proveedor elemento)
	{
		return proveedores.agregarElemento(elemento);
	}
	
	public boolean eliminarProveedorObj(Proveedor elemento) {
		return proveedores.eliminarElementoObj(elemento);
	}
	
	public Proveedor eliminarProveedorIndex(int  index) {
		return proveedores.eliminarElementoIndice(index);
	}
	
	public String listarProveedores() {
		return proveedores.listarElementos();
	}
	
	public int cantidadDeProveedores() {
		return proveedores.contarElementos();
	}
	
	public boolean existeProveedor(Proveedor proveedor) {
		return proveedores.existeElemento(proveedor);
	}
	
	public ArrayList<Proveedor> devolverProveedores() {
		ArrayList<Proveedor> listaDeProveedores = new ArrayList<Proveedor>();
		
		for(int i = 0 ; i < proveedores.contarElementos() ; i++) {
			listaDeProveedores.add(proveedores.buscarElemento(i));
		}
		
		return listaDeProveedores;
	} 
	
	public void agregarListaDeProveedores(ArrayList<Proveedor> listaDeProveedores) {
		
		for(Proveedor proveedor : listaDeProveedores) {
			this.proveedores.agregarElemento(proveedor);
		}
	}	
	
}
