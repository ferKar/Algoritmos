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
 * Version -UNO
*/
public class Problema_UNO{
    
	public static int sumaE(int inicio, int fin){
		int suma = 0;
		while(fin >= inicio){
			suma += fin--;
		}
		return suma;
	}
    
	public static LinkedList<Integer> arranca_hojas(int meta){
	    LinkedList<Integer> paginas_arrancadas = new LinkedList<>();
		for(int i = 400; i > 0; i = i - 2){
			int diferencia = meta - (i + (i - 1));
			if(diferencia >= sumaE(1,48 - paginas_arrancadas.size())){ // 48 porque siempre voy a meter la ultima hoja
				meta = diferencia;
				paginas_arrancadas.add(i);
				paginas_arrancadas.add(i - 1);
			} 
		}
		return paginas_arrancadas;
	}

	public static void main(String args[]){
		int meta = Integer.parseInt(args[0]);
		int regreso = 0;
		int i = 1;

		for (Integer pag : arranca_hojas(meta)){
			regreso += pag;
			System.out.println("(" + (i++)  + ") :" + pag);
		}

		System.out.printf("La suma da: %d\n",regreso);
		
	}
}
