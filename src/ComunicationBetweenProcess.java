
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ComunicationBetweenProcess {
	public static void main(String args[]) throws IOException {
		// EJERCICIO 3
//		a) Ejecuta el programa anterior en eclipse indicando como argumento el programa “cmd.exe”, ¿qué se obtiene por pantalla y por qué?
//		b) Un proceso puede esperar recibir por su entrada estándar los datos con los que operar en un formato específico. 
//			Por ejemplo, si el proceso se crea a partir de un ejecutable en Unix, la comunicación de datos con el mismo debería
//			producirse en UTF-8. Si los datos de entrada no contienen caracteres extraños (saltos de línea, tildes, ñ, etc.).
//			Prueba a incluir el parámetro “UTF-8” dentro del ImputStreamReader.
//		c) Por último, incorpora el tratamiento de excepciones y cierra el descriptor de salida del hijo (is) antes de finalizar el programa.

//		a)Esta parte la realicé en un sistema operativo windows, al añadir el argumento "cmd.exe" se imprime por pantalla el texto que aparece  al utilizar el cmd ya que el texto de este caso el hijo "cmd" lo imprime el padre
//		b)Desaparce la ó de versión y se sustituye por un símbolo de interrogación "?"
//		c)Añadido el try catch y cerrado el hijo, se ejecuta se abre el cmd pero se cierra nada mas abrirse el cmd
		try {
			Process process = new ProcessBuilder(args).start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
			is.close();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}