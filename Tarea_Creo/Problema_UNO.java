import java.util.LinkedList;

/*
 * PROBLEMA UNO
 * Clara enumeró las páginas de un cuaderno del 1 al 400. Si Juan le
 * arranco 25 hojas y sumó los 50 números que estaban escritos en esas
 * páginas arrancadas, puede tal suma llegar a ser...
 * a) 2017? b) 2018?
 *
 * Created by ferKarly.
 * Clase-Algoritmos Tarea_Cero
 * Version -DOS
*/
public class Problema_UNO{

    /* 
    Notemos que la diferencia entre hoja y hoja es de 4, es decir que si por hoja vieramos
    la secuencia de la suma de sus numeros se veria asi
    hoja -> 1   , 2   ,3       ,...,i          
    pag  ->(1,2),(3,4),(5,6)   ,...,(2i-1,2i)   
    suma -> 4-1  ,4+4-1,4+4+4-1,...,4*i -1
    
    entonces dos cuales quiera hojas suman:    hoja k, hoja m
    (2k-1 + 2k) + (2m-1 + 2m) = (4*k - 1) + (4*m - 1)
                              = 4*k + 4*m -2
                              = 4(k + m) - 2

    entonces la suma de n hojas cualesquiera es 
    4(h1 + h2 + ... + hn) - n

    ahora si queremos que esta suma sea k es decir
    k = 4(h1 + h2 + ... + hn) - n 
    k + n = 4(h1 + h2 + ... + hn)

    Esto nos dice que k+n debe ser multiplo de 4, entonces existe un x natural talque 4(x) = (k+n)
    este numero sería igual a la suma de las n hojas:    x = h1 + h2 + ... + hn
    como todas las hojas son distintas x va a ser por lo menos la suma de 1 a n, es decir.
    x >= suma(1,n) ->  4(x) >= 4(suma(1,n))
    entonces  k+n >= 4(suma(1,n)),con k>=3 pues partimos de la hoja 1 y n > 0. 

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
           

     * @param k numero que se quiere sumar con las hojas arrancadas.
     * @param n cantidad de hojas que se quieren arrancar.
     * @param j la ultima pagina del cuaderno.
    */
    public static boolean esPosible(int k, int n, int j){
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
    System.out.println(esPosible(meta,n,j));
    System.out.println(esPosible(5,1,j));    
    }
}
