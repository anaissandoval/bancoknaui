package bancoKnaui;

import java.util.ArrayList;

/**
 * Clase que implementa una lista que se ordena en base al método compareTo()
 * @author aleKnaui
 * @param <E> Genérico de la 
 */
public class ListaOrdenada<E extends Comparable<E>> extends ArrayList<E>{

	// --------------------------------------------------
	// Métodos
	// --------------------------------------------------
	
	/**
	 * Método que ordena los elementos de la lista utilizando el algoritmo
	 * de Bubble Sort.
	 * Tomado de: http://answers.yahoo.com/question/index?qid=20080404114642AAmF68Y
	 */
	public void sort(){
		int out, in;

		for( out = size()-1; out > 1; out-- ) // outer loop (backward)
		for( in = 0; in < out; in++ ) // inner loop (forward)
		if( get(in).compareTo(get( in+1 )) == 1 ) // out of order?
			swap(in, in+1); // swap them
	}

	/**
	 * Método que cambia de lugar dos elementos dados sus índices
	 * @param i1 El índice del primer elemento
	 * @param i2 El índice del segundo elemento
	 */
	private void swap(int i1, int i2) {
		E primero = get(i1);
		E segundo = get(i2);
		set( i1, segundo );
		set( i2, primero );
	}
	
}
