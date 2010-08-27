package bancoKnaui;

public abstract class AbstractCola<E> implements Cola<E> {
	
	@Override
	public boolean isEmpty(){
		return size() == 0;
	}

}
