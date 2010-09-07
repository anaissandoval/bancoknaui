package test;

import junit.framework.TestCase;
import bancoKnaui.*;

/**
 * Clase que realiza pruebas sobre cualquier implementación de Cola
 * @author ale
 */
public class TestCola_ListaCircular extends TestCase {

	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Pila sobre la cual se realizaran las pruebas */
	private Cola<String> cola;
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------

	/**
	 * Prepara el escenario 1 para las pruebas.
	 * post: La cola se encuentra vacía
	 */
	protected void setUpScenario1(){
		cola = new Cola_ListaCircular<String>();
	}
	
	/**
	 * Prepara el escenario 2 para las pruebas.
	 * post: La cola contiene los elementos "casa", "carro" y "perro".
	 */
	protected void setUpScenario2(){
		cola = new Cola_ListaCircular<String>();
		cola.enqueue("casa");
		cola.enqueue("carro");
		cola.enqueue("perro");
	}
	
	/**
	 * Realiza pruebas sobre el método dequeue().
	 * 1. Si la cola está vacía, se debe retornar null y la cola debe mantenerse vacía
	 * 2. Si la cola no está vacía, el tamaño de la cola debe disminuir en 1 y se debe retornar
	 * el primer elemento de la cola (en este caso, "casa").
	 */
	public void testDequeue(){
		setUpScenario1();
		assertEquals( "Si la cola está vacía, se debe retornar null y la cola debe mantenerse vacía", null, cola.dequeue() );
		assertEquals( "Si la cola está vacía, se debe retornar null y la cola debe mantenerse vacía", true, cola.isEmpty() );
		
		setUpScenario2();
		assertEquals( "Si la cola está vacía, se debe retornar null y la cola debe mantenerse vacía", "casa", cola.dequeue() );
		assertEquals( "Si la cola está vacía, se debe retornar null y la cola debe mantenerse vacía", 2, cola.size() );
	}
	
	/**
	 * Realiza pruebas sobre el método enqueue().
	 * 1. Si la cola está vacía, el tamaño debe volverse 1 al meter algo a la cola y al ejecutar dequeue se debe obtener el valor
	 * introducido.
	 * 2. Si la cola no está vacía, el tamaño de la cola debe aumentar en uno y su último elemento debe ser el introducido.
	 */
	public void testEnqueue(){
		setUpScenario1();
		cola.enqueue( "gato" );
		assertEquals( "Si la cola está vacía, el tamaño debe volverse 1 al meter algo a la cola.", 1, cola.size() );
		assertEquals( "Al ejecutar dequeue se debe obtener el valor introducido.", "gato", cola.dequeue() );
		
		setUpScenario2();
		cola.enqueue( "gato" );
		assertEquals( "El tamaño de la cola debe aumentar en uno", 4, cola.size() );
		cola.dequeue();
		cola.dequeue();
		cola.dequeue();
		assertEquals( "El último elemento debe ser el introducido.", "gato", cola.dequeue() );
	}
	
	/**
	 * Realiza pruebas sobre el método peek().
	 * 1. Si la cola está vacía, se debe retornar null.
	 * 2. Si la cola no está vacía, el tamaño de la cola debe mantenerse constante y el valor retornado debe
	 * ser el último valor ingresado.
	 */
	public void testPeek() {
		setUpScenario1();
		assertEquals( "El método peek() sobre una cola vacía debe retornar null.", null, cola.peek() );
		assertEquals( "El método peek() no debe afectar el tamaño de una cola", true, cola.isEmpty() );
		
		setUpScenario2();
		assertEquals( "El método peek() sobre una cola vacía debe retornar el primer elemento de la cola.", "casa", cola.peek() );
		assertEquals( "El método peek() no debe afectar el tamaño de una cola", 3, cola.size() );
	}

}