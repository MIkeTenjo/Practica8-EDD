/**
 * Clase que implementa una estructura de datos tipo Pila (Stack) genérica.
 * 
 * 
 */
public class Pila<T> implements PiCoLa<T> {

    /**
     * Clase interna que representa un nodo de la pila.
     */
    private class Nodo {
        public T elemento;
        public Nodo siguiente;

        /**
         * Crea un nuevo nodo con el elemento especificado.
         * @param elemento el elemento a almacenar en el nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }

    private Nodo tope;
    private int tamanio;

    /**
     * Crea una pila vacía.
     */
    public Pila() {
        this.tope = null;
        this.tamanio = 0;
    }

    /**
     * Inserta un elemento en el tope de la pila.
     * 
     * @param elemento el elemento que se agregará a la pila.
     */
    @Override
    public void meter(T elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    /**
     * Elimina y devuelve el elemento que se encuentra en el tope de la pila.
     * 
     * @return el elemento en el tope, o null si la pila está vacía.
     */
    @Override
    public T sacar() {
        if (estaVacia()) {
            return null;
        }
        T elemento = tope.elemento;
        tope = tope.siguiente;
        tamanio--;
        return elemento;
    }

    /**
     * Devuelve el elemento que se encuentra en el tope de la pila sin eliminarlo.
     * 
     * @return el elemento en el tope, o null si la pila está vacía.
     */
    @Override
    public T mira() {
        if (estaVacia()) {
            return null;
        }
        return tope.elemento;
    }

    /**
     * Verifica si la pila no contiene elementos.
     * 
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean estaVacia() {
        return tope == null;
    }

    /**
     * Devuelve el número de elementos almacenados en la pila.
     * 
     * @return el tamaño actual de la pila.
     */
    @Override
    public int devolverTamanio() {
        return tamanio;
    }

    /**
     * Compara esta pila con otro objeto para determinar si son iguales.
     * 
     * @param o el objeto a comparar.
     * @return true si ambas pilas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        @SuppressWarnings("unchecked") Pila<T> m = (Pila<T>)o;
        Nodo n1 = this.tope;
        Nodo n2 = m.tope;
        while (n1 != null && n2 != null){
            if (!n1.elemento.equals(n2.elemento))
                return false;
            n1 = n1.siguiente;
            n2 = n2.siguiente;
        }
        return (n1 == null && n2 == null);
    }

    /**
     * Devuelve una representación en cadena de la pila.
     * 
     * <p>El formato es una lista de los elementos desde el tope hasta la base,
     * encerrados entre corchetes y separados por comas.</p>
     * 
     * @return una cadena que representa el contenido de la pila.
     */
    @Override
    public String toString() {
        String resultado = "[";
        Nodo actual = tope;

        while (actual != null) {
            resultado += actual.elemento;
            if (actual.siguiente != null) {
                resultado += ", ";
            }
            actual = actual.siguiente;
        }

        resultado += "]";
        return resultado;
    }

}
