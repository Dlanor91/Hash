package lista;

public abstract class Lista<T> implements Iterable<T>{
	
	public abstract int largo();
	
	public abstract void insertar(T dato);
	
	public abstract boolean existe(T dato);
	
	public abstract void borrar(T dato);
	
}
