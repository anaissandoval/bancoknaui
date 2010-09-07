package bancoKnaui;

public interface INodo<E> {

	//--------------------------------------------------
	// M�todos
	// --------------------------------------------------
	
	/**
	 * M�todo que retorna el objeto que se encuentra contenido en el nodo. 
	 */
	E darObjeto();
	/**
	 * M�todo que indica si el nodo tiene un atributo "siguiente"
	 * @return true Si hay un nodo siguiente. false Si no lo hay.
	 */
	boolean hasNext();
	/**
	 * M�todo que retorna el nodo siguiente.
	 * @return El siguiente nodo en la lista. null Si hasNext() == false
	 */
	Nodo<E> next();
	/**
	 * M�todo que cambia el siguiente elemento del nodo.
	 * @param next El nodo a agregar
	 */
	public void setNext( Nodo<E> next );
}
