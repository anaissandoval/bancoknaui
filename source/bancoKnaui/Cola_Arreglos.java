package bancoKnaui;

/**
 * Cola implementada con arreglos
 * @author aleKnaui
 * @param <E> Genérico que indica el tipo de objetos contenido en la cola 
 */
public class Cola_Arreglos<E> extends AbstractCola<E> {
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Los elementos contenidos en la cola */
	private Object[] elementos;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Crea la cola vacía
	 */
	public Cola_Arreglos(){
		elementos = new Object[0];
	}
	
	// --------------------------------------------------
	// Métodos
	// --------------------------------------------------

	public E dequeue() {
		if( isEmpty() ) return null;
		else{
			E retorno = (E) elementos[0];
			Object[] nuevo = new Object[ size()-1 ];
			for( int i = 1; i < size(); i++ )
				nuevo[i-1] = elementos[i];
			elementos =  nuevo;
			return retorno;
		}
	}

	public void enqueue(E elemento) {
		Object[] nuevos = new Object[ size() + 1 ];
		for( int i = 0; i < size(); i++ )
			nuevos[i] = elementos[i];
		nuevos[ nuevos.length - 1 ] = elemento;
		elementos = nuevos;
	}
	
	public E peek() {
		if( isEmpty() ) return null;
		else
			return (E) elementos[0];
	}

	public int size() {
		return elementos.length;
	}

}
