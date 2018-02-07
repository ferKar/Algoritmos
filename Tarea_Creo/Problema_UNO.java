import java.util.LinkedList;

/*
 * PROBLEMA UNO
 * Clara enumeró las páginas de un cuaderno del 1 al 400. Si Juan le
 * arranco 25 hojas y sumó los 50 números que estaban escritos en esas
 * páginas arrancadas, puede tal suma llegar a ser...
 * a) 2017? b) 2018?
 *
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
    
	En resumen k > n , (k-n) debe ser par y j >= 2(n).
	
	Ahora para el problema particular
	Con n = 25 , j = 400 	
	 k = 2017 -> 2017-25 = 1992 como 1992 es par, 2017 > 25 y 400 >= 50 
	 						 es posible que las 25 hojas sumen 2017.
	 					  

	 k = 2018 -> 2018-25 = 1993 como 1992 no es par es imposible que las 25 hojas sumen 2017,
	 									pues no existe m en los naturales talque 2(m) = 1993.

 * Created by ferKarly.
 * Clase-Algoritmos Tarea_Cero
 * Version -DOS
*/
public class Problema_UNO{

    /*	
	 * @param k numero que se quiere sumar con las hojas arrancadas.
	 * @param n cantidad de hojas que se quieren arrancar.
	 * @param j la ultima pagina del cuaderno.
	*/
	public static boolean esPosible(int k, int n, int j){
		if(((k - n) % 2) == 0 && j >= (2*n) && k > n)
			return true;
		return false;

	}

	public static void main (String[] args){
		int meta = Integer.parseInt(args[0]);
		int n = 25;
		int j = 400;
		System.out.println(esPosible(meta,n,j));		
	}
}
