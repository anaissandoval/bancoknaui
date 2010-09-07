package bancoKnaui;

public class Nodo<E> implements INodo<E> {
	
	//--------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** El objeto contenido en el nodo */
	private E objeto;
	/** El objeto siguiente */
	private Nodo<E> siguiente;
	
	//--------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Constructor de la clase
	 */
	public Nodo( E obj ){
		objeto = obj;
		siguiente = null;
	}
	
	//--------------------------------------------------
	// Métodos
	// --------------------------------------------------

	public E darObjeto() {
		return objeto;
	}

	public boolean hasNext() {
		return siguiente == null;
	}

	public Nodo<E> next() {
		return siguiente;
	}
	
	public void setNext( E next ){
		siguiente = new Nodo<E>(next);
	}
	
	public void setNext( Nodo<E> next ){
		siguiente = next;
	}
}
