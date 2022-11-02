package hash;

public class Main {

	public static void main(String[] args) {
		
		Hash hash = new Hash(10);
		hash.insertar(new Persona("Pedro"));
		hash.insertar(new Persona("Lore"));
		hash.insertar(new Persona("Guille"));
		hash.insertar(new Persona("Pedro"));
		hash.insertar(new Persona("Fabian"));
		hash.insertar(new Persona("Marcos"));
		System.out.println(hash.largo());
		System.out.println(hash.existe(new Persona("Pedro")));
	}

}
