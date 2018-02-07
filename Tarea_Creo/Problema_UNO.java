import java.util.LinkedList;

/*
 * PROBLEMA UNO
 * Clara enumeró las páginas de un cuaderno del 1 al 400. Si Juan le
 * arranco 25 hojas y sumó los 50 números que estaban escritos en esas
 * páginas arrancadas, puede tal suma llegar a ser...
 * a) 2017? b) 2018?
 *
   Razonamiento (1) es incorrecto btw pero no lo borraré.
    Entonces no sabemos cuales son las hojas sin embargo al estar numeradas sabemos que
    su suma se ve de la siguiente forma:
     a1 + (a1 + 1) + a2 + (a2 + 1) + .....+ an + (an +1)
     y tambien sabemos que las a's son impares pues la numeracion empieza en uno.
    Queremos que esta suma sea igual a una k = 2017 / 2018 es decir:
    k = a1 + (a1 + 1) + a2 + (a2 + 1) + ...+ an + (an +1)
    k = 2(a1) + 1 + 2(a2) + 1 + ... + 2(an) + 1
    k = 2(a1 + a2 + ... + an) + n
    k - n = 2 (a1 + a2 + ... + an)
    
    Como en la numeracion solo se manejan numeros naturales con lo anterior vemos que
    (k - n) debe ser par y como la suma es positiva entonces k > n.

    Ahora notemos el rango, no puedes arrancar más hojas de las que tienes 
    Entonces en un rango de 1,.....,j debe ser j >= 2(n).
    
    Notemos que k>=3 pues la primera hoja suma 3 y que n>0 pues no puedes sumar algo con 0 hojas.
    
    En resumen k >= 3, k > n , (k-n) debe ser par y j >= 2(n).
    
    PERO!!!!!!!!!!!!
    Sumar 5 con una hoja/o 3hojas es imposible sin embargo
    n = 1 k = 5
    4 es par, 5 > 1 y cumple con las demas condiciones falta alguna condición :/

    ENTONCES!!!!!!!!!
   Razonamiento (2) es el mero bueno :P.
    La diferencia entre hoja y hoja es de 4,
    es decir que si por hoja vieramos la secuencia de la suma de sus numeros se veria algo asi
    hoja -> 1   , 2   ,3       ,...,i          
    pag  ->(1,2),(3,4),(5,6)   ,...,(2i-1,2i)   
    suma -> 4-1  ,4+4-1,4+4+4-1,...,4*i -1
    
    entonces dos cuales quiera hojas suman:    hoja k, hoja m
    (2k-1 + 2k) + (2m-1 + 2m) = (4*k - 1) + (4*m - 1)
                              = 4*k + 4*m -2
                              = 4(k + m) - 2

    entonces la suma de n hojas cualesquiera es 
    4(h1 + h2 + ... + hn) - n

    ahora si queremos que esta suma de k es decir
    k = 4(h1 + h2 + ... + hn) - n 
    k + n = 4(h1 + h2 + ... + hn)

    Esto nos dice que k+n debe ser multiplo de 4, entonces existe un x natural talque 4(x) = (k+n)
    ahora este numero sería igual a la suma de las n hojas:
    x = h1 + h2 + ... + hn
    es decir que x es por lo menos 1 dado que la numeración empieza en 1 y vamos a pertir de una hoja.
    pero no solo eso sino que x va a ser por lo menos la suma de 1 a n.
    x >= suma(1,n)
    4(x) >= 4(suma(1,n))
    entonces como 4(x) = (k+n), esto nos dice que k+n >= 4*suma(1,n),con k>=3 pues partimos de (1,2) y n > 0. 

    Ahora si 
    En resumen para sumar k con n hojas en un rango maximo de j debe cumplirse que:
    1) k >= 3
    2) n > 0 
    3) j >= 2(n).
    4) (k + n) debe ser multiplo de 4.
    5) (k + n) >= 4*suma(1,n)


    Ahora para el problema particular
    Con n = 25 , j = 400     
     k = 2017 -> 2017 + 25 = 2042 como 2042 no es multiplo de 4,es IMPOSIBLE que las 25 hojas sumen 2017,
                                pues no existe m en los naturales talque 4(m) = 2042.
           

     k = 2018 -> 2018 + 25 = 2043 como 2043 no es multiplo de 4,es IMPOSIBLE que las 25 hojas sumen 2018,
                                pues no existe m en los naturales talque 4(m) = 2043.
           
 * Created by ferKarly.
 * Clase-Algoritmos Tarea_Cero
 * Version -DOS
*/
public class Problema_UNO{

    /*    Razonamiento (1)
     * @param k numero que se quiere sumar con las hojas arrancadas.
     * @param n cantidad de hojas que se quieren arrancar.
     * @param j la ultima pagina del cuaderno.
    */
    public static boolean esPosible1(int k, int n, int j){
    if(k >= 3 && ((k - n) % 2) == 0 && j >= (2*n) && k > n)
    return true;
    return false;
    }
    
    /* Razonamiento (2)
    1) k >= 3
    2) n > 0 
    3) j >= 2(n).
    4) (k + n) debe ser multiplo de 4.
    5) (k + n) >= 4*suma(1,n)          Suma de Gauss de 1...n (n(n+1))/2.
     * @param k numero que se quiere sumar con las hojas arrancadas.
     * @param n cantidad de hojas que se quieren arrancar.
     * @param j la ultima pagina del cuaderno.
    */
    public static boolean esPosible2(int k, int n, int j){
    if(k >= 3 &&
       n > 0 &&
       j >= (2*n) &&
       ((k + n) % 4) == 0 &&
       ((k + n) >= 4 * ( (n * (n + 1)) / 2) ))

    return true;
    return false;
    }

    public static void main (String[] args){
    int meta = Integer.parseInt(args[0]);
    int n = 25;
    int j = 400;
    System.out.println(esPosible2(meta,n,j));
    System.out.println(esPosible2(5,1,j));    
    }
}
