package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	// objetos necesarios para establecer un socket	
	private final String HOST = "localhost";
    private final int PUERTO = 4321;
    private Socket socket;

    // constructor
    public Cliente() throws IOException {
        socket = new Socket(HOST, PUERTO);
    }
	
	// metodo para interactuar
	public void interactua() throws IOException {
			//creamos flujo de entrada y salida de mensajes entre servidor y cliente
		 	DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
	        DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());
	        Scanner scanner = new Scanner(System.in); //clase scanner para leer los datos del cliente

	        try {
	        	// --- secuencia de leer y responder al servidor
	        	// siempre primero leemos con readUTF y luego escribimos con writeUTF
	        	
	        	// 1- contestamos a la pregunta del nombre
		        System.out.println(entradaServidor.readUTF());
		        salidaServidor.writeUTF(scanner.nextLine());

		        // 2- contestamos a la pregunta de las minusculas
		        System.out.println(entradaServidor.readUTF());		        
		        salidaServidor.writeUTF(scanner.nextLine());

		        // 3- contestamos a la pregunta de las mayusculas
		        System.out.println(entradaServidor.readUTF());
		        salidaServidor.writeUTF(scanner.nextLine());

		        // 4- contestamos a la pregunta de los digitos
		        System.out.println(entradaServidor.readUTF());
		        salidaServidor.writeUTF(scanner.nextLine());

		        // 5- contestamos a la pregunta de los caracteres especiales
		        System.out.println(entradaServidor.readUTF());
		        salidaServidor.writeUTF(scanner.nextLine());

		        // 6- contestamos a la pregunta de SI o NO queremos generar la contraseña
		        System.out.println(entradaServidor.readUTF());
		        String respuesta = scanner.nextLine();
		        salidaServidor.writeUTF(respuesta);
		        System.out.println(entradaServidor.readUTF());

		    // lanzamos error si ocurre alguna anomalia durante el programa    		        
	        } catch (Exception e){
	        	System.err.println("Ocurrió un error durante la comunicación: " + e.getMessage());
	        } finally {
	        	// cerramos conexiones 
		        salidaServidor.close();
		        entradaServidor.close();
		        socket.close();	        	
	        }
	        	        
	    }
}
