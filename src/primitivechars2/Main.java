
package primitivechars2;

import javax.swing.JOptionPane;

public class Main {

 
    public static void main(String[] args) {

        EscrituraLectura2 el2 = new EscrituraLectura2();

        
        String frase = JOptionPane.showInputDialog("Introduce el mensaje a escribir: ");
        
        String path = JOptionPane.showInputDialog("Introduce el path: ");
        el2.writeFile2(frase, path);
        
        
      
        
        el2.readFile2(frase, path);

    }
    
}
