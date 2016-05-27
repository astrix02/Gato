package abraham.hernandez.constantes;

public class Constantes {
	   //Constantes para el tablero
	   public static final int FIL = 3;  
	   public static final int COL = 3;
	   public static int tablero[];
	   public static int turno = 1; 
	   
	   public static final int CELDA_TAM = 100; 
	   public static final int CANVAS_ANCHO = CELDA_TAM * COL;
	   public static final int CANVAS_ALTO = CELDA_TAM * FIL;
	   public static final int TAB_TAM = 8;
	   public static final int TAB_MITAD = TAB_TAM / 2;
	   
	   
	   public static final int SIMBOLO_ESP = CELDA_TAM/6; //Padding en celda
	   public static final int SIMBOLO_TAM = CELDA_TAM - SIMBOLO_ESP * 2; // * 2 por el padding de dos lados
	   public static final int GROSOR_SIMBOLO = 8; // Grosor Simbolo
}
