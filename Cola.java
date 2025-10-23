import java.util.NoSuchElementException;

/**
 * Clase que representa el funcionamiento de una Cola como estructura de datos.
 */
public class Cola<T> implements PiCoLa<T> {

    /**
     * Clase privada Nodo para guardar los elementos de la Cola.
     */
    private class Nodo {

        public T elemento;/*El elemento del Nodo. */

        public Nodo siguiente;/*El elemento siguiente del Nodo. */

        /**
         * Constructor que inicializa un Nodo con un elemento en el.
         * @param elemento El elemento a insertar en el Nodo.
         */
        public Nodo(T elemento){
            this.elemento = elemento;
            this.siguiente = null;
        }

        
    }

    /*El tamaño de la Cola. */
    private int tamanio;
    /*La cabeza de la Cola. */
    private Nodo cabeza;
    /*El rabo de la Cola */
    private Nodo rabo;

    /**
     * Constructor que inicializa una Cola vacia.
     */
    public Cola(){
        this.cabeza = null;
        this.rabo = null;
        this.tamanio = 0;
    }

    /**
     * Método que inserta un elemento al final de la Cola.
     * 
     * @param elemento El elemento a insertar al final de la Cola.
     */
    @Override public void meter(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("El elemento es vacío.");
        }else{
            Nodo n = new Nodo(elemento);

            if(rabo == null){
                rabo = n;
                cabeza = n;
            }else{
                rabo.siguiente = n;
                rabo = n;
            }
        }
    }

    /**
     * Método que elimina la cabeza de la Cola y retorna su elemento.
     * 
     * @return El elemento del valor eliminado de la Cola.
     */
    @Override public T sacar(){
        if(cabeza == null){
            throw new NoSuchElementException("La cola es vacía.");
        }
        Nodo c = cabeza;
        cabeza = cabeza.siguiente;
        if(cabeza == null){
            rabo = null;
        }
        return c.elemento;
    }

    /**
     * Método que devuelve el elemento de la cabeza de la Cola.
     * 
     * @return El elemento de la cabeza de la Cola
     */
    @Override public T mira(){
        if(cabeza == null){
            throw new NoSuchElementException("La cola está vacía.");
        }

        return cabeza.elemento;
    }      
    
    /**
     * Método que nos dice si la Cola está vacía.
     * 
     * @return {@code true} sí la Cola está vacía. {@code false}
     * en otro caso.
     */
    @Override public boolean estaVacia(){
        return cabeza == null;
    }
    
    /**
     * Método que nos devuelve el tamaño de elementos que hay en la Cola.
     * 
     * @return El tamaño de elementos que hay en la Cola.
     */
    @Override public int devolverTamanio(){
        return tamanio;
    }

    /**
     * Método que nos dice si una estructura de datos Cola es similar
     * a la actual.
     * 
     * @return {@code true} si la estructura de datos Cola a comparar
     * es igual a la actual. {@code false} en otro caso.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked") Cola<T> m = (Cola<T>)obj;
        if (this == m) {
            return true;
        }

        Nodo b1 = this.cabeza;
        Nodo b2 = m.cabeza;


        while(b1 != null && b2 != null){
            if(! b1.elemento.equals(b2.elemento)){
                return false;
            }
            b1 = b1.siguiente;
            b2 = b2.siguiente;
        }

        if(b1 != null || b2 != null){
            return false;
        }

        return true;
    }

    /**
     * Método que devuelve una representación en cadena de la Cola.
     * 
     * @return Una representación en cadena de la Cola.
     */
    @Override
    public String toString(){
        if(estaVacia()){
            return "";
        }
        String s = "[";
        Nodo c = cabeza;

        while(c != null){
            s += String.format("%s", c.elemento);
            if (c.siguiente != null) {
                s += ", ";
            }
            c = c.siguiente;
        }

        return s;
    }

}
