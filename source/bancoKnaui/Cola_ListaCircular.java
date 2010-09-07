package bancoKnaui;

/**
 * Cola implementada con una lista circular
 * @author aleKnaui
 * @param <E> Genérico que indica el tipo de objetos contenido en la cola 
 */
public class Cola_ListaCircular<E> extends AbstractCola<E> {
	
	//--------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Los elementos contenidos en la cola */
	private ListaCircular<E> elementos;

	//--------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Constructor de la clase. Crea la cola vac�a
	 */
	public Cola_ListaCircular(){
		elementos = new ListaCircular<E>();
	}
	
	//--------------------------------------------------
	// M�todos
	// --------------------------------------------------
	public int size() {
		return elementos.size();
	}

	public void enqueue(E elemento) {
		elementos.add( elemento );
	}

	public E dequeue() {
		return elementos.remove();
	}

	public E peek() {
		return elementos.darPrimero();
	}

}
