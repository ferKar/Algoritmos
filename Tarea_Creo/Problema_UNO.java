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

    
	public static LinkedList<Integer> suma_hojas2(int meta){
	    LinkedList<Integer> paginas_arrancadas = new LinkedList<>();

		for(int i = 400; i > 0; i = i - 2){
			int suma_paginas = i + (i - 1); 
			int diferencia = meta - suma_paginas;
			if(diferencia >= sumaE(1,48 - paginas_arrancadas.size())){ // 48 porque siempre voy a meter la ultima hoja
				meta = diferencia;
				paginas_arrancadas.add(i);
				paginas_arrancadas.add(i - 1);
			} 
		}
		return paginas_arrancadas;
	}

	public static LinkedList<Integer> llena_paginas(){
		LinkedList<Integer> paginas = new LinkedList<>();
		for(int i = 1; i <= 400; i++)
			paginas.add(i);
		return paginas;		
	}

	private static LinkedList<Integer> paginas = llena_paginas();
	private static int i = 0;


	public static LinkedList<Integer> arranca_paginas(LinkedList<Integer> paginas_arrancadas){
		int sumaHoja = paginas.size() + (paginas.size() -1);

		if(i + sumaHoja <= 2018){
			i += sumaHoja;
			paginas_arrancadas.add(paginas.removeLast());
			paginas_arrancadas.add(paginas.removeLast());
			return arranca_paginas(paginas_arrancadas);
		}
		else if (paginas.size() > 2){
			paginas.removeLast();
			paginas.removeLast();
			return arranca_paginas(paginas_arrancadas);			
		}else{
			return paginas_arrancadas;
		}
	}

	public static void main(String args[]){
		LinkedList<Integer> paginas_arrancadas = new LinkedList<>();
		int meta = Integer.parseInt(args[0]);
		int regreso = 0;
		int i = 1;
		 /*arranca_paginas(paginas_arrancadas*/ 
		for (Integer pag :suma_hojas2(meta)){
			regreso += pag;
			System.out.println("(" + (i++)  + ") :"+pag);
		}

		System.out.printf("La suma da: %d\n",regreso);
		
	}
}
