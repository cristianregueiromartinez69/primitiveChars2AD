package primitivechars2;

import java.io.*;

/**
 * clase con los métodos que escriben cadenas de texto alternando 2 metodos
 *
 * @author cristian
 * @version 1.0
 */
public class EscrituraLectura2 {

    /**
     * metodo para escribir en un archivo de texto alternando entre writeUTF y
     * writeChar
     *
     * @param sentence la frase que le pasamos por parametro
     * @param pathFile el path del archivo
     */
    public void writeFile2(String sentence, String path) {

        File myFile = new File(path);

        try {
            if(myFile.exists()){
                //instanciamos los objetos y metemos el path
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myFile)));

                for (int i = 0; i < 3; i++) {

                    //si i es par, hace un metodo, si no lo es hace el otro
                    if (i % 2 == 0) {
                        dos.writeUTF(sentence);
                        System.out.println("writeUTF escribiendo: " + sentence + "\n" + "bytes totales escritos: " + dos.size() + " bytes");

                    } else {
                        dos.writeChars(sentence);
                        System.out.println("Escribiendo en writeChars: " + sentence + "\n" + "bytes totales escritos: " + dos.size() + " bytes");
                    }

                }
                dos.close(); 
            }
            else{
            if (myFile.createNewFile()) {
                  //instanciamos los objetos y metemos el path
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myFile)));

                for (int i = 0; i < 3; i++) {

                    //si i es par, hace un metodo, si no lo es hace el otro
                    if (i % 2 == 0) {
                        dos.writeUTF(sentence);
                        System.out.println("writeUTF escribiendo: " + sentence + "\n" + "bytes totales escritos: " + dos.size() + " bytes");

                    } else {
                        dos.writeChars(sentence);
                        System.out.println("Escribiendo en writeChars: " + sentence + "\n" + "bytes totales escritos: " + dos.size() + " bytes");
                    }

                }
                dos.close(); 
               
            }else{
                System.out.println("No se ha podido escribir en el archivo o ya existe");
            }    
            }
            

        } catch (IOException e) {
            System.out.println("El archivo no ha podido ser escrito");
        }

    }

    /**
     * metodo para leer un archivo de texto alternando entre readUTF y readChar
     *
     * @param sentence la frase que le pasamos por parametro
     * @param pathFile el path del archivo
     */
    public void readFile2(String sentence, String path) {

        File myFile = new File(path);

        try {
        
            if(myFile.isFile()){
             //instanciamos los objetos y metemos el path
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(myFile)));

            for (int i = 0; i < 3; i++) {

                while (dis.available() > 0) {
                    //si i es par, hace un metodo, si no lo es hace el otro
                    if (i % 2 == 0) {
                        dis.readUTF();
                        System.out.println("readUTF leyendo: " + sentence + "\n" + "bytes totales por leer: " + dis.available() + " bytes");

                    } else {
                        dis.readChar();
                        System.out.println("leyendo en readChars: " + sentence + "\n" + "bytes totales escritos: " + dis.available() + " bytes");
                    }
                }

            }
            dis.close();    
            }
            else{
                System.out.println("No se encontro el archivo a leer");
            }

        } catch (IOException e) {
            System.out.println("El archivo no ha podido ser leido");
        }

    }

}
