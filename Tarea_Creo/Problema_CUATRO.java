import java.util.LinkedList;

/*
 * PROBLEMA CUATRO
 * Considere la siguiente lista de números.
 * 9, 44, 32, 12, 7, 42, 34, 92, 35, 37, 41, 8, 20, 27, 83, 17, 48,
 * 64, 61, 28, 39, 93, 29, 17, 13, 14, 55, 21, 66, 72, 23, 73, 95,
 * 12, 99, 1, 2, 88, 77, 3, 65, 83, 84, 62, 5, 11, 74, 68, 76, 33, 30
 * 78, 51, 67, 44, 75, 69, 70, 22, 4, 71, 53, 24, 18, 25, 47, 26.
 * Sin modificar el orden de la lista actual, borrar la menor cantidad
 * posible de números de tal forma que los números restantes aparezcan
 * en:
 * a) orden creciente;
 * b) orden decreciente;
 * 
 * Created by ferKarly.
 * Clase-Algoritmos Tarea_Cero
 * Version -DOS
*/

public class Problema_CUATRO{

  private static int[] borrarMenosNum(int arr[], boolean creciente) {
    int[] sec = new int[arr.length];
 	int max_sec = 0; // logitud maxima de la secuencia.
 	int indiceD = 0; // el indice donde se encuentra el maximo de la secuencia.

    for (int i = 0; i < arr.length; i++)
      sec[i] = 1;//empezamos a todos en uno pues la secuencia maxima es de por lo menos un numero.
 
    for (int i = 1; i < arr.length; i++ ){// para cada numero checar la subsecuencia mas larga hasta ese momento.
      for (int j = 0; j < i; j++ ){ // obteniendo la secuencia más larga desde j hasta i
            if(creciente){
              if (arr[i] > arr[j] && sec[i] < sec[j] + 1 )
              	// hasta i la mejor secencia aumenta en uno respecto a la mejor secuencia anterior
                  sec[i] = sec[j] + 1; 
            } else {
              if (arr[i] < arr[j] && sec[i] < sec[j] + 1 )
              	// hasta i la mejor secencia aumenta en uno respecto a la mejor secuencia anterior
                  sec[i] = sec[j] + 1; 
            }
      }
    
      if(sec[i] >= max_sec){ // con esto obtengo los mejores indices.
      	max_sec = sec[i]; // intente sacar la lista de estos indices pero algo salio mal xD asi...el for de abajo no? jejeje fuerza bruta, donde? no puede ser peor no pasa de n² :P.
      	indiceD = i;
      }
    }

    // de atras para delante sacamos los numeros de la entrada, con respecto a los numeros que estan en la secuencia
    int noBorrados[] = new int[max_sec];
    int j = noBorrados.length - 1;
    for(int i = indiceD; i >= 0; i--)
      if(sec[i] == max_sec){
        noBorrados[j--] = arr[i];
        max_sec--;
      }    

    return noBorrados;
  }

  public static void main(String args[]){
    int arr[] = { 9, 44, 32, 12, 7, 42, 34, 92, 35, 37, 41, 8, 20, 27, 83, 17, 48,64, 61, 28, 39, 93, 29, 17, 
                 13, 14, 55, 21, 66, 72, 23, 73, 95, 12, 99, 1, 2, 88, 77, 3, 65, 83, 84, 62, 5, 11, 74, 68, 
                  76, 33, 30,78, 51, 67, 44, 75, 69, 70, 22, 4, 71, 53, 24, 18, 25, 47, 26 };
    
    int[] nob = borrarMenosNum(arr,true);
    
    for(Integer noBor : nob)
      System.out.print(noBor + " ");
    
    System.out.println();
  }
}