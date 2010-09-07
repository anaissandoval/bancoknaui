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
	 * Inicia la lista vac�a
	 */
	public ListaCircular(){
		primero = null;
	}
	
	//--------------------------------------------------
	// M�todos
	// --------------------------------------------------
	
	/**
	 * M�todo que agrega un elemento a la lista
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
	 * M�todo que remueve el primer nodo de la lista y lo retorna.
	 * @return El primer elemento de la lista. null Si la lista est� vac�a
	 */
	public E remove(){
		E elementoARemover = null;

	      // lanza una excepci�n si la Lista esta vac�a
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
	 * M�todo que indica si la lista est� vac�a.
	 * @return true Si no hay elementos en la lista. false Si no los hay.
	 */
	public boolean isEmpty(){
		return primero == null;
	}
	
	/**
	 * M�todo que informa sobre el tama�o de la lista
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
	 * M�todo que retorna el primer elemento de la lista
	 */
	public E darPrimero(){
		if( primero != null )
			return primero.darObjeto();
		else
			return null;
	}
}
