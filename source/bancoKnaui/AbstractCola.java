package bancoKnaui;

/**
 * Clase abstracta que implementa el comportamiento independiente de una cola
 * @author aleKnaui
 * @param <E> Genérico de la cola
 */
public abstract class AbstractCola<E> implements Cola<E> {
	
	@Override
	public boolean isEmpty(){
		return size() == 0;
	}

}
