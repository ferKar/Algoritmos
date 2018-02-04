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
 * Version -UNO
*/

public class Problema_CUATRO{

  private static int[] borrarMenosNum(int arr[], boolean creciente) {
    int[] sec = new int[arr.length];
 
    for (int i = 0; i < arr.length; i++)
      sec[i] = 1;
 
    for (int i = 1; i < arr.length; i++ )
      for (int j = 0; j < i; j++ ) 
            if(creciente){
              if (arr[i] > arr[j] && sec[i] < sec[j] + 1 )
                  sec[i] = sec[j] + 1; 
            } else {
              if (arr[i] < arr[j] && sec[i] < sec[j] + 1 )
                  sec[i] = sec[j] + 1; 
            }

    int max = 0, indice = 0;
    for (int i = 0; i < sec.length; i++ )
      if ( max < sec[i]){
        max = sec[i];
        indice = i;
      }
 
    int noBorrados[] = new int[max];
    int j = noBorrados.length - 1;
    for(int i = indice; i >= 0; i--)
      if(sec[i] == max){
        noBorrados[j--] = arr[i];
        max--;
      }    

    return noBorrados;
  }

  public static void main(String args[]){
    int arr[] = { 9, 44, 32, 12, 7, 42, 34, 92, 35, 37, 41, 8, 20, 27, 83, 17, 48,64, 61, 28, 39, 93, 29, 17, 
                 13, 14, 55, 21, 66, 72, 23, 73, 95, 12, 99, 1, 2, 88, 77, 3, 65, 83, 84, 62, 5, 11, 74, 68, 
                  76, 33, 30,78, 51, 67, 44, 75, 69, 70, 22, 4, 71, 53, 24, 18, 25, 47, 26 };
    
    int[] nob = borrarMenosNum(arr,false);
    
    for(Integer noBor : nob)
      System.out.print(noBor + " ");
    
    System.out.println();
  }
}