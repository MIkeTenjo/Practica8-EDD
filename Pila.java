public class Pila<T> implements PiCoLa<T> {

    private class Nodo {
        public T elemento;
        public Nodo siguiente;

        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }

    private Nodo tope;
    private int tamanio;

    public Pila() {
        this.tope = null;
        this.tamanio = 0;
    }

    @Override
    public void meter(T elemento) {
        /*Aquí va tu código*/
    }

    @Override
    public T sacar() {
        /*Aquí va tu código*/
    }

    @Override
    public T mira() {
        /*Aquí va tu código*/
    }

    @Override
    public boolean estaVacia() {
        /*Aquí va tu código*/
    }

    @Override
    public int devolverTamanio() {
        /*Aquí va tu código*/
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        @SuppressWarnings("unchecked") Pila<T> m = (Pila<T>)o;
        Nodo n1 = this.tope;
        Nodo n2 = m.tope;
        while (n1 !=null && n2 != null){
            if (!n1.elemento.equals(n2.elemento))
                return false;
            n1 = n1.siguiente;
            n2 = n2.siguiente;
        }
        return (n1 == null && n2 == null);
    }

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
