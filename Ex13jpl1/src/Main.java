/*Juan Pavon Lopez
 * Recuperacion 2º trimestre programacion
 * 
 * Ejercicio 1:
 * Realiza un test de inglés. La información se debe almacenar en un diccionario (HashMap) en el que
	las entradas (al menos 8) están formadas por pares (palabra en inglés, palabra en español). El
	programa hará 5 preguntas. No es necesario controlar que no se repitan las preguntas. En cada
	pregunta elegirá al azar una palabra en inglés y otra en español y preguntará si es correcto.
 * 
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creo un HashMap con 10 palabras en español con su correspondiente traduccion al ingles
		Scanner s = new Scanner(System.in);
        HashMap<String, String> d = new HashMap<>();
        
        d.put("boligrafo", "pen");
        d.put("mano", "hand");
        d.put("ornitorrinco", "platypus");
        d.put("comprar", "buy");
        d.put("galleta", "cookie");
        d.put("caramelo", "candy");
        d.put("manzana", "apple");
        d.put("andamio", "scaffolding");
        d.put("botella", "bottle");
        d.put("sangre", "blood");
        d.put("libro", "book");
        
        int aciertos = 0;
        
        //meto las claves en un array
        String[] claves = d.keySet().toArray(new String[10]);
        
        //meto los valores en un array
        String[] valores = d.values().toArray(new String[10]);
        
        //creo y relleno un array con 5 numeros aleatorios para las claves
        int[] aClaves = new int[5];
       
        for(int i = 0; i < 5; i++){
            aClaves[i] = (int)(Math.random()* 10);
        }
        
        //creo y relleno un array con 5 numeros aleatorios para los valores
        int[] aValores = new int[5];
        
        for(int i = 0; i < 5; i++){
            aValores[i] = (int)(Math.random()* 10);
        }
        
        //Creo una coleccion en la que guardare las preguntas que ha fallado
        ArrayList<String> e = new ArrayList<String>();
        
        //Muestro las preguntas
        for(int i = 0; i < 5; i++) {
        	System.out.println("¿" + claves[aClaves[i]] + " es " + valores[aValores[i]] + "?: Conteste (s/n):");
        	String respuesta = s.nextLine();
        	
        	if((aClaves[i] == aValores[i]) && (respuesta.equals("s"))) {
        		aciertos++;
        	} else if ((aClaves[i] != aValores[i]) && (respuesta.equals("n"))) {
        		aciertos++;
        	} else {
        		e.add(claves[aClaves[i]]); 
        	}
        }
        
        System.out.println("Respuestas acertadas: " + aciertos);
        
        //Muestro el resultado de correcto de las preguntas erroneas
        if(aciertos == 5 ) {
        	System.out.println("Todas las respuestas son correctas. ¡¡Enhorabuena!!");
        } else {
        	System.out.println("Debe repasar las siguientes preguntas:");
	        for (String i : e) {
				System.out.println(i + ": " + d.get(i));
	        }
        }
	}

}
