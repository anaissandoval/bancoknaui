package bancoKnaui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa al banco con 4 colas y un mÃ¡ximo de 10 clientes por cola.
 * @author aleKnaui
 */
public class BancoKnaui {

	// --------------------------------------------------
	// Constantes
	// --------------------------------------------------
	
	/** La cantidad de colas que hay en el banco. */
	public final static int CANTIDAD_COLAS = 4;
	/** La cantidad mÃ¡xima de clientes que debe haber en cada cola */
	public final static int MAXIMO_CLIENTES_POR_COLA = 10;
	/** Cantidad de clientes que se generarÃ¡n para el ejercicio */
	public final static int CLIENTES_A_GENERAR = 50;
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------

	/** Las colas de atenciÃ³n en el banco. */
	private Cola<Cliente>[] colas;
	/** La lista generada de clientes. */
	private ListaOrdenada<Cliente> listaClientes;
	/** La suma de todos los tiempos de permanencia de todos los clientes */
	private int sumaPermanencias;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------

	/**
	 * Constructor de la clase.
	 * post: Se creÃ³ una instancia del banco con 4 colas de atenciÃ³n a clientes y se generÃ³ la lista aleatoria de clientes.
	 */
	public BancoKnaui()
	{
		colas = new Cola[CANTIDAD_COLAS];
		
		Scanner scan = new Scanner( System.in );
		System.out.print( "Presione '1' para realizar la simulación con la implementación de cola que utiliza arreglos.\n" +
				"Presiones '2' para realizar la simulación con la implementación de cola que utiliza listas circulares" );
		String seleccion = scan.nextLine();
		//int seleccion = scan.nextInt();
		for( int i = 0; i < CANTIDAD_COLAS; i++ ){
			if( seleccion.trim().equals("1"))  colas[i] = new Cola_Arreglos<Cliente>();
			else if( seleccion.trim().equals("2") )colas[i] = new Cola_ListaCircular<Cliente>();
			else { System.out.println( "Número inválido." ); new BancoKnaui(); }
		}
		
		generarListaClientes();
		simularBanco();
	}
	
	// --------------------------------------------------
	// MÃ©todos
	// --------------------------------------------------
	
	/**
	 * Genera una lista aleatoria de clientes del banco y la ordena por su tiempo de entrada.
	 * post: Se genera una lista ordenada de clientes que irÃ¡n al banco con una hora de entrada y tiempo de permanencia aleatorios. 
	 */
	private void generarListaClientes()
	{
		// Inicializa la lista
		listaClientes = new ListaOrdenada<Cliente>();
		
		// Crea los clientes aleatoriamente
		Random random = new Random();
		for( int i = 0; i < CLIENTES_A_GENERAR; i++ ){
			int t1 = random.nextInt( 480 ) + 1;
			int t2 = random.nextInt( 30 ) + 1;
			listaClientes.add( new Cliente( i+1, t1, t2 ) );
		}
		
		// Ordena los clientes por su hora de entrada
		listaClientes.sort();
		
		System.out.println( "\n----- Lista de clientes -----\n" );
		for( int i = 0; i < listaClientes.size(); i++ )
		{
			Cliente cliente = listaClientes.get(i);
			System.out.println( "Cliente " + (i+1) + ":" + cliente.toString() );
		}
	}
	
	/**
	 * MÃ©todo que retorna el Ã­ndice de la cola mÃ¡s corta posible.
	 * @return El Ã­ndice de la cola vacÃ­a mÃ¡s prÃ³xima o de la cola con menor cantidad de clientes en espera.
	 */
	private int darColaMasCorta()
	{
		// Retorna la cola mÃ¡s prÃ³xima que estÃ© vacÃ­a (si es que hay colas vacÃ­as)
		for( int i = 0; i < CANTIDAD_COLAS; i++ )
			if( colas[i].isEmpty() ) return i;
		// Retorna la cola con menor cantidad de clientes en espera si no hay colas vacÃ­as
		int menor = colas[0].size();
		for( int i = 1; i < CANTIDAD_COLAS; i++ )
			if( menor > colas[i].size() ) menor = colas[i].size();
		return menor;
	}
	
	/**
	 * Método que atiende a los clientes que entran a determinada hora, metiéndolos en la cola más corta.
	 * También marca la hora de atención a los clientes que están empezando a ser atendidos.
	 * @param hora La hora a la que se quiere atender a los clientes.
	 */
	private void atenderClientes( int hora )
	{
		for( int i = 0; i < CLIENTES_A_GENERAR; i++ ){
			if( listaClientes.get(i).darHoraEntrada() == hora ){
				int colaMasCorta = darColaMasCorta();
				colas[colaMasCorta].enqueue( listaClientes.get(i) );
				System.out.println( hora + ":\n\tEl cliente " + (i+1) + " ha ingresado a la cola " + (colaMasCorta+1) );
			}
		}
		for( int i = 0; i < colas.length; i++ ){
			Cola<Cliente> cola = colas[i];
			if( ! cola.isEmpty() )
			if( cola.peek().darHoraAtendido() == 0 ){
				cola.peek().setHoraAtendido( hora );
				System.out.println( hora + ":\n\tSe está atendiendo al cliente " + cola.peek().darCodigo() + " en la cola " + (i+1) );
			}
		}
	}
	
	/**
	 * Método que saca de la cola a los clientes que terminaron a determinada hora.
	 * @param hora La hora determinada.
	 */
	private void sacarClientes( int hora )
	{
		for( int i = 0; i < colas.length; i++ ){
			Cola<Cliente> cola = colas[i];
			if( ! cola.isEmpty() ){
				if( cola.peek().darHoraSalida() == hora ){
					Cliente saliendo = cola.dequeue();
					sumaPermanencias += saliendo.darHoraSalida() - saliendo.darHoraEntrada();
					System.out.println( hora + ":\n\tSe ha terminado de atender al cliente " + saliendo.darCodigo() + " en la cola " + (i+1) + ".\n\tSu permanencia fue de " + (saliendo.darHoraSalida() - saliendo.darHoraEntrada()) );
				} else{}
			} else{}
		}
		for( int i = 0; i < colas.length; i++ ){
			Cola<Cliente> cola = colas[i];
			if( ! cola.isEmpty() ){
				if( cola.peek().darHoraAtendido() == 0 ){
					cola.peek().setHoraAtendido( hora );
					System.out.println( hora + ":\n\tSe está atendiendo al cliente " + cola.peek().darCodigo() + " en la cola " + (i+1) );
				} else{}
			} else{}
		}
	}
	
	/**
	 * Método que realiza toda la simulación del banco. Por cada segundo atiende a los clientes que entran
	 * y registra el tiempo de los clientes que van saliendo.
	 */
	private void simularBanco()
	{
		System.out.println( "\n----- Eventos -----\n" );
		for( int i = 1; i < 512; i++ ){
			atenderClientes(i);
			sacarClientes(i);
		}
		System.out.println( "\nPromedio de permanencia: " + sumaPermanencias / CLIENTES_A_GENERAR );
	}

	/**
	 * Método que ejecuta todo el programa.
	 */
	public static void main( String[] args ){
		new BancoKnaui();
	}
}
