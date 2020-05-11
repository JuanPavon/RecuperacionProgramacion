/*Juan Pavon Lopez
 * Recuperacion 2º trimestre programacion
 * 
 * Ejercicio 2:
 * Crea una función que mezcla dos ArrayList de números enteros a partir de otros dos que se pasan
	como parámetros. Para mezclarlos, se va cogiendo un elemento del primer ArrayList y otro del
	segundo. Cuando se acaben los elementos de una de las listas lista, se continúan pasando los de la
	otra.
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		// La cabecera viene dada en el ejercicio
	    ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
	    ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(77, 88, 99));
	    ArrayList<Integer> lista3 = new ArrayList<>();

	    System.out.println(mezclaListas(lista1, lista2));
	    System.out.println(mezclaListas(lista2, lista1));
	    System.out.println(mezclaListas(lista1, lista3));
	    System.out.println(mezclaListas(lista2, lista3));
	}
	
	//Defino una clase que se encargara de toda la logica del programa
	public static ArrayList<Integer> mezclaListas(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		
		 ArrayList<Integer> resultado = new ArrayList<>();
		 
		 //Creo un contador que se encargara de sacar los numeros de los arrays uno a uno
		 int contador = 0;
		     
		 do {
		   if (contador < a1.size()) {
		     resultado.add(a1.get(contador));
		   }

		   if (contador < a2.size()) {
		     resultado.add(a2.get(contador));
		   }

		   contador++;
		 } while ((contador < a1.size()) || (contador < a2.size()));
		     
		 return resultado;
	}
}
