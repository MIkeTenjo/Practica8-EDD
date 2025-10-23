public interface PiCoLa<T> {
    
    /**
     * Meté un nuevo elemento a la estructura de datos (pila o cola) siguiendo
     * la forma FIFO ó LIFO.
     * @param elemento El elemento a agregar en la estructura de datos.
     */
    public void meter(T elemento);   
    
    /**
     * Elimina el elemento de la estructura de datos (pila o cola) siguiendo
     * la forma FIFO ó LIFO y retorna el elemento eliminado.
     * @return El elemento eliminado de la estructura de datos.
     */
    public T sacar();                
    
    /**
     * Regresa el elemento en la cabeza de la estructura de datos (pila o cola),
     * pero no la elimina.
     * @return El elemento en la cabeza de la estructura de datos
     */
    public T mira();            
    
    /**
     * Regresa un valor booleano que nos dice si la estructura de datos(pila o cola)
     * esta vacía.
     * @return {@code true} sí la estructura está vacía. {@code false} en otro caso.
     */
    public boolean estaVacia();
    
    /**
     * Nos devuelve el números de elementos en la estructura de datos.
     * @return El tamaño de la estructura de datos.
     */
    public int devolverTamanio();

    /**
     * Nos devuelve un valor boleano que nos dice si la estructura de datos(pila o cola)
     * es igual a otra estructura de datos del mismo tipo.
     * @param obj La estructura de datos del mismo tipo a comparar.
     * @return {@code true} sí las dos estructuras son iguales. {@code false} en otro caso.
     */
    @Override
    public boolean equals(Object obj);

    /**
     * Nos devuelve una representación en cadena de la estructura de datos.
     * @return Una representación en cadena de la estructura de datos.
     */
    @Override
    public String toString();
}