import java.util.NoSuchElementException;

public class Cola<T> implements PiCoLa<T> {

    private class Nodo {
        public T elemento;

        public Nodo siguiente;

        public Nodo(T elemento){
            this.elemento = elemento;
            this.siguiente = null;
        }

        
    }

    private int tamanio;
    private Nodo cabeza;
    private Nodo rabo;

    public Cola(){
        this.cabeza = null;
        this.rabo = null;
        this.tamanio = 0;
    }

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

    @Override public T mira(){
        if(cabeza == null){
            throw new NoSuchElementException("La cola está vacía.");
        }

        return cabeza.elemento;
    }      
    
    @Override public boolean estaVacia(){
        return cabeza == null;
    }
    
    @Override public int devolverTamanio(){
        return tamanio;
    }

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
