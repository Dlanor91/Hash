package hash;

import lista.Lista;
import lista.ListaSE;

public class Hash {

    private final int tope;

    private int cantidadMaxima;
    private int cantidad;
    private Lista<Persona>[] vec;

    public Hash(int cantMax) {
        this.tope = primoSup(cantMax);
        this.cantidadMaxima = cantMax;
        this.cantidad = 0;
        this.vec = new ListaSE[this.tope];
        for (int i = 0; i < tope; i++) {
            this.vec[i] = new ListaSE<>();
        }

    }

    // Pre: !Existe(p)
    public void insertar(Persona p) {
        int cubeta = fnhash(p);
        vec[cubeta].insertar(p);
        this.cantidad++;
    }

    public boolean existe(Persona p) {
        int cubeta = fnhash(p);
        return this.vec[cubeta].existe(p);

    }

    //precondicion el elemento existe
    public void borrar(Persona p) {
        int cubeta = fnhash(p);
        vec[cubeta].borrar(p);
        this.cantidad--;

    }

    public boolean estaLleno() {
        return this.cantidad == cantidadMaxima;

    }

    public int largo() {
        return this.cantidad;
    }

    public boolean estaVacio() {
        return this.cantidad == 0;
    }

    private int fnhash(int dato) {
        return Math.abs(dato) % this.tope;
    }

    private int fnhash(String dato) {
        int aux = 0;

        for(int i=0;i<dato.length();i++){
            aux += dato.charAt(i);
        }
        //System.out.println(aux + " "  +aux % this.tope );
        return aux % this.tope;
    }

    private int fnhash(Persona p) {
        //System.out.println(p.hashCode() + " "  +Math.abs(p.hashCode()) % this.tope );
        return Math.abs(p.hashCode()) % this.tope;
    }

    private int primoSup(int num) {
        while (!esPrimo(++num)) ;
        return num;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        } else {
            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }

}
