package bancoKnaui;

public class ListaCircular<E> {

	//--------------------------------------------------
	// Atributos
	// --------------------------------------------------

	/** Primer nodo de la lista */
	private Nodo<E> primero;
	
	//--------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Inicia la lista vacía
	 */
	public ListaCircular(){
		primero = null;
	}
	
	//--------------------------------------------------
	// Métodos
	// --------------------------------------------------
	
	/**
	 * Método que agrega un elemento a la lista
	 */
	public void add( E nuevo ){
		 if ( isEmpty() ) {
	         primero = new Nodo<E>( nuevo );
	         primero.setNext( primero );
	      }
	      else {
	    	  Nodo<E> ultimo;
	    	  Nodo<E> actual = primero;
	      	 while(actual.next() != primero) {
	      	 	actual = actual.next();
	      	 }
	      	 ultimo = actual;
	         
	         Nodo<E> desplazado = primero;
	         primero = new Nodo<E>( nuevo );
	         primero.setNext( desplazado );
	         ultimo.setNext( primero );
	      }
	}
	
	/**
	 * Método que remueve el primer nodo de la lista y lo retorna.
	 * @return El primer elemento de la lista. null Si la lista está vacía
	 */
	public E remove(){
		E elementoARemover = null;

	      // lanza una excepción si la Lista esta vacía
	      if ( isEmpty() )
	    	  return null;
	      // recupera el dato a ser removido
	      elementoARemover = primero.darObjeto();  

	      // reinicializa las referencias al primerNodo and ultimoNodo
	      if ( primero == primero.next())
	         primero = null;

	      else
	      {
	    	  Nodo<E> ultimo;
	    	  Nodo<E> actual = primero;
	      	 while(actual.next() != primero ) {
	      	 	actual = actual.next();
	      	 }
	      	 ultimo = actual;
	      	 	        
	         primero = primero.next();
	         ultimo.setNext( primero );
	      }

	      // devuelve el dato del nodo removido
	      return elementoARemover;  
	}
	
	/**
	 * Método que indica si la lista está vacía.
	 * @return true Si no hay elementos en la lista. false Si no los hay.
	 */
	public boolean isEmpty(){
		return primero == null;
	}
	
	/**
	 * Método que informa sobre el tamaño de la lista
	 */
	public int size(){
		if( isEmpty() )
			return 0;
		else{
			int tamanio = 0;
			for( Nodo<E> actual = primero; actual.hasNext(); actual.next() )
				tamanio++;
			return tamanio;
		}
	}
	
	/**
	 * Método que retorna el primer elemento de la lista
	 */
	public E darPrimero(){
		if( primero != null )
			return primero.darObjeto();
		else
			return null;
	}
}
