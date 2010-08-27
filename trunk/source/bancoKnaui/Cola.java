package bancoKnaui;
/**
 * Interfaz que define el comportamiento que debe implementar una estructura
 * de datos Cola con genéricos.
 * @author aleKnaui
 */
public interface Cola<E> {
	
	/**
	 * Método que indica si la cola no tiene elementos.
	 * @return true Si la cola se encuentra vacía. false Si no lo está.  
	 */
	public boolean isEmpty();
	
	/**
	 * Método que indica la cantidad de elementos en la cola.
	 * @return La cantidad de elementos en la cola.
	 */
	public int size();
	
	/**
	 * Método que introduce al final de la cola un elemento.
	 * @param elemento El objeto que se desea insertar a la cola.
	 * <b>post:</b> El elemento indicado como parámetro se ha insertado al final de la cola.
	 */
	public void enqueue( E elemento );
	
	/**
	 * Método que retorna y remueve el primer elemento de la cola.
	 * @return El elemento que está al principio de la cola. null Si la cola está vacía.
	 * <b>post:</b> El primer elemento de la cola es removido de la misma y retornado.
	 */
	public E dequeue();
	
	/**
	 * Método que retorna pero no remueve el primer elemento de la cola.
	 * @return El elemento que está al principio de la cola. null Si la cola está vacía.
	 * <b>post:</b> El primer elemento de la cola es retornado, pero sigue en la cabeza de la cola.
	 */
	public E peek();

}
