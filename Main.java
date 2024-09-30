
package primitivechars2;


import javax.swing.JOptionPane;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {

		//instanciamos el objeto
		EscrituraLectura2 fa = new EscrituraLectura2();
		//pedimos que introduzca la ruta
		String frase = "Está en casa";
		String ruta = JOptionPane.showInputDialog("Introduce la ruta: ");
		//llamamos a los objetos
		fa.writeAlternateFile(frase, ruta);
		fa.readAlternateFile(ruta);

	}
}