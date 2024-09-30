package primitivechars2;

import java.io.*;

/**
 * clase alterna ficheros donde hacemos los metodos de leer y escribir
 * @author cristian
 * @version 1.0
 */
public class EscrituraLectura2 {

	/**
	 * metodo que alterna entre writeUTF y writeChars
	 * @param sentence la frase que vamos a escribir en el archivo
	 * @param path la ruta del archivo
	 */
	public void writeAlternateFile(String sentence, String path) {

		File file = new File(path);

		try {
			//comprobamos que existe para crearlo o no
			if (!file.exists()) {
				if (file.createNewFile()) {
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

					//usamos un bucle para escribir el texto 3 veces
					for (int i = 0; i < 3; i++) {

						//alternamos entre utf y chars
						if (i % 2 == 0) {
							dos.writeUTF(sentence);
							System.out.println("writeUTF escribiendo: " + sentence + "\nbytes totales escritos: "
									+ dos.size() + " bytes");
						} else {
							dos.writeChars(sentence);
							System.out.println("writeChars escribiendo: " + sentence + "\nbytes totales escritos: "
									+ dos.size() + " bytes");
						}
					}

				}
			}
			else {
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

				for (int i = 0; i < 3; i++) {

					if (i % 2 == 0) {
						dos.writeUTF(sentence);
						System.out.println("writeUTF escribiendo: " + sentence + "\nbytes totales escritos: "
								+ dos.size() + " bytes");
					} else {
						dos.writeChars(sentence);
						System.out.println("writeChars escribiendo: " + sentence + "\nbytes totales escritos: "
								+ dos.size() + " bytes");
					}
				}
				dos.close();
			}
		} catch (IOException e) {
			System.out.println("No se pudo acceder al archivo");
		}

	}

	/**
	 * metodo que lee alternando entre utf y chars
	 * @param path la ruta del archivo
	 */
	public void readAlternateFile(String path) {

		File file = new File(path);
		try {
			//comprobamos si existe
			if (file.exists() && file.isFile()) {

				DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
				int alternaFormatos = 0;

				//mientras los bytes leidos no dean 0 entra en el bucle
				while (dis.available() > 0) {

					if (alternaFormatos % 2 == 0) {

						System.out.println("Bytes totales por leer: " + dis.available() + " bytes");
						System.out.println("Leemos la cadena en UTF: " + dis.readUTF());
						System.out.println("Bytes totales por leer: " + dis.available() + " bytes");
					}
					else {

						/**
						 * la logica mas importante
						 * creamos un objeto tipo char y tendra de espacio lo equivalente a letras de lo que queremos escribir
						 * recorremos el for que es igual al tamaño del array
						 * introducimos los valores a lo leido
						 */
						char [] chars = new char[12];
						for(int i = 0; i < chars.length; i++) {
							chars[i] = dis.readChar();
						}
						System.out.println("Leemos la cadena en readChar() en bucle: " + new String(chars));
					}
					alternaFormatos++;
				}
				dis.close();

			}
			else {
				System.out.println("No existe el fichero");
			}
		} catch (IOException e) {
			System.out.println("No existe el fichero o ruta incorrecta");
		}

	}
}


