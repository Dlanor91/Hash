package lista;

import java.util.Iterator;

public class ListaSE<T> extends Lista<T>{

	private NodoLista<T> inicio;

	public ListaSE() {
		this.inicio = null;
	}
	
	public void agregarPpio(T dato)
	{
		inicio = new NodoLista<T>(dato,inicio);
	}
	
	public void agregarFin(T dato)
	{
		if(inicio == null)
			inicio = new NodoLista<T>(dato);
		else
			agregarFinRec(dato, inicio);
	}
	
	private void agregarFinRec(T dato, NodoLista<T> nodo) {
		if(nodo.getSig()==null)
			nodo.setSig(new NodoLista<T>(dato));
		else
			agregarFinRec(dato, nodo.getSig());
	}
	
	//Pre: k>=0
	public void agregarEnPosK(int k, T dato)
	{
		if(k==0 || inicio == null)
			agregarPpio(dato);
		else
			agregarEnPosKRec(k, dato, inicio);
	}

	private void agregarEnPosKRec(int k, T dato, NodoLista<T> nodo) {
		if(k==1 || nodo.getSig()==null)
			nodo.setSig(new NodoLista<T>(dato,nodo.getSig()));
		else
			agregarEnPosKRec(k-1, dato, nodo.getSig());
	}
	

	@Override
	public void insertar(T dato) {
		agregarFin(dato);
	}

	@Override
	public int largo(){
		return largoRec(inicio);
	}
	
	private int largoRec(NodoLista<T> nodo) {
		if(nodo == null){
			return 0;
		}
		else
		{
			return 1 + largoRec(nodo.getSig());
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			NodoLista<T> aux = inicio;
			
			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public T next() {
				T ret = aux.getDato();
				aux = aux.getSig();
				return ret;
			}
		};
	}

	@Override
	public boolean existe(T dato) {
		NodoLista<T> aux = inicio;
		while(aux != null)
		{
			if(aux.getDato().equals(dato))
			{
				return true;
			}
			else
				aux = aux.getSig();
		}
		return false;
		
	}

	@Override
	public void borrar(T dato) {
		if(inicio.getDato().equals(dato))
			inicio = inicio.getSig();
		else
		{
			NodoLista<T> aux = inicio;
			while(!aux.getSig().equals(dato))
				aux = aux.getSig();
			aux.setSig(aux.getSig().getSig());
		}
	}
	
	

}
