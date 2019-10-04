
import java.io.IOException;
import java.util.Arrays;

public class RunProcess {
	public static void main(String[] args) throws IOException {
//		EJERCICIO 1
//		a) Ejecuta el programa anterior en eclipse indicando como argumento el programa “calc.exe”. ¿Cómo lo has hecho?
//		b) Repite la acción anterior sin poner argumentos. ¿Qué sucede?
//		c) Repite la acción anterior poniendo 2 argumentos. ¿Y ahora?
//		d) ¿Serías capaz de cambiar el código para que ejecutase una calculadora detrás de otra? Indica cómo quedaría el código

//		a)Para ejecutar la aplicación calculadora.app he tenido que dar el valor del comando al argumento,
//		para ello en RunConfiguration/Argumentos añades la linea de comando a ejecutar en este caso 'open -a calculator'

//		b)El argumento al tener un valor menor o igual a cero, te sale imprime un mensaje indicado que no hay un programa para ejecutar

//		c)Al añadir un nuevo argumento, ningun programa se ejecuta, en este caso retorna un 1 ,el metodo waitFor() al no retornar un 0 
//		ha ocurrido un problema

//		d)Lo único que he añadido al codigo base a sido un while con un true , que repita todo el rato ese proceso,
//		la aplicacion se vuelve a ejecutar pero en macOS la aplicacion se cambia la nueva por la aplicacion antigua, es decir
//		no se abren varias calculadoras

		while (true) {
			if (args.length <= 0) {
				System.err.println("Se necesita un programa a ejecutar");
				System.exit(-1);
			}
			ProcessBuilder pb = new ProcessBuilder(args);

			try {

				Process process = pb.start();
				int retorno = process.waitFor();
				System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);

			} catch (IOException ex) {
				System.err.println("Excepción de E/S!!");
				System.exit(-1);
			} catch (InterruptedException ex) {
				System.err.println("El proceso hijo finalizó de forma incorrecta");
				System.exit(-1);
			}
		}
	}
}
