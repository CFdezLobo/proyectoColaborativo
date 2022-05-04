import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String cadena = "";
		
		System.out.println("Introduzca la cadena deseada: ");
		cadena = sc.nextLine();
		
		System.out.println(Main.isNumeric(cadena));
		
	}
	
	//Método que recibe un String y diga verdadero o falso si ese String es un numero
	public static boolean isNumeric(String cadena) {
		boolean esNumero = false;
		try {
			double num = 0;
			num = Double.parseDouble(cadena);
			esNumero = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return esNumero;
	}
	
}
