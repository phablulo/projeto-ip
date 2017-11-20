package ui;
import dados.*;

/*Classe para testar o programa e tratar das exceptions*/

public class Programa {
	public static void main(String[] args) {
		Livro alquimista = new Livro("001", "O Alquimista", new String[]{"Paulo Coelho"}, 93, 25.0);
		Livro narnia     = new Livro("001", "As Crônicas de Nárnia", new String[]{"C.S. Lewis"}, 800, 80.0);


	}
	public static void useLista() {}
	public static void useArray() {}
}
