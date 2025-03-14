package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	//---- objetos necesarios para establecer un socket
	private final int PUERTO = 4321; //
    private ServerSocket serverSocket;
    private Socket socket;
	// atributo extra 
	ServicioPass servicioPass;
	
	//Definimos los constructores
	public Servidor() throws IOException {		
    	serverSocket = new ServerSocket(PUERTO); // definimos la conexion
        socket = new Socket(); // iniciamos el cliente
	}
	    
	//Metodo para iniciar la conexion
    public void start() throws IOException {
        
    	// se genera un bucle para estar siempre esperando los datos del cliente
    	while (true) {
    		
            System.out.println("Esperando al cliente..."); 
            socket = serverSocket.accept(); // guardamos la peticion que llegue al servidor en socket            
            System.out.println("Cliente conectado desde " + socket.getInetAddress()); // escribimos la direccion del cliente con getInetAddress()
            // aquí, el servidor se queda a la espera de recibir peticiones
            
            // creamos los objetos de flujo de entrada y salida
            DataInputStream entradaCliente = new DataInputStream(socket.getInputStream());
            DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());

            // ********** PUNTO ADICIONAL 2 ********** //
            // ---- se identifican parámetros incorrectos y se muestra un error si hay alguna anomalia
            // -- Esto es posible con TRY / CATCH
            try {
            	// 1- se pide al cliente varios datos, comenzando por su nombre
            	
                salidaCliente.writeUTF("Hola, soy un servidor. ¿Cómo te llamas?");
                String nombreCliente = entradaCliente.readUTF();
                System.out.println("Nombre del cliente: " + nombreCliente);

                // ------ servidor solicita requisitos de la contraseña ------ //
                
                // 2 - minusculas
                salidaCliente.writeUTF("Te doy la bienvenida " + nombreCliente 
                		+ ".\nVoy a solicitarte distintos requisitos para la contraseña que voy a generar."
                		+ "\n¿Cuántas minúsculas debe tener la contraseña?");                
                int minusculas = Integer.parseInt(entradaCliente.readUTF());
                
                // 3 - mayusculas
                salidaCliente.writeUTF("¿Cuántas mayúsculas debe tener la contraseña?");
                int mayusculas = Integer.parseInt(entradaCliente.readUTF());

                // 4 - digitos
                salidaCliente.writeUTF("¿Cuántos dígitos debe tener la contraseña?");
                int digitos = Integer.parseInt(entradaCliente.readUTF());

                // 5 - caracteres especiales
                salidaCliente.writeUTF("¿Cuántos caracteres especiales debe tener la contraseña?");
                int caracteresEspeciales = Integer.parseInt(entradaCliente.readUTF());

				// ------ con todas las respuestas, se generan los requisitos de la contraseña ------ //
                
                RequisitosPass requisitos = new RequisitosPass();
                requisitos.setNumMinusculas(minusculas);
                requisitos.setNumMayusculas(mayusculas);
                requisitos.setNumDigitos(digitos);
                requisitos.setNumCaractEspeciales(caracteresEspeciales);
                
                System.out.println("Los requisitos del cliente son los siguientes: \n" + requisitos.toString());
                
                // calculamos la longitud y la guardamos en una variable                
                this.servicioPass = new ServicioPass(requisitos);
                int longitud = servicioPass.longitudPass();
                
                // 6 - despues de los calculos, decimos al cliente la longitud de la contraseña y preguntamos si la quiere generar o no
                salidaCliente.writeUTF("La longitud de la contraseña que se va a generar es de " + longitud 
                		+ "\n¿Quieres generar la contraseña ahora? [si/no]");
                System.out.println("Se ha enviado la longitud de la contraseña al cliente");
                
                // 7- si el cliente acepta, generamos contraseña                
                String respuesta = entradaCliente.readUTF();
                                               
                if (respuesta.equalsIgnoreCase("si")) {
                    String passwordGenerado = servicioPass.generaPass();
                    salidaCliente.writeUTF("La contraseña generada es: " + passwordGenerado);
                    System.out.println("Se ha enviado la contraseña al cliente.");
                } else if (respuesta.equalsIgnoreCase("no")){
                    salidaCliente.writeUTF("No se generará ninguna contraseña. Hasta la próxima.");
                    System.out.println("El cliente no desea generar una contraseña");
                }
            
            // si en cualquier momento el cliente introduce un parámetro inválido se muestra un error
            // se puede seguir recibiendo clientes si ejecutamos MainCliente de nuevo    
            }catch(Exception e) {
            	System.err.println("Ocurrió un error: " + e.getMessage());
            	// avisamos al cliente
                salidaCliente.writeUTF("Ocurrió un error en el servidor. Intenta de nuevo.");
            } finally {
            	// cerrar conexión con el cliente
                entradaCliente.close();
                salidaCliente.close();
                socket.close();            	
            }
            
            
        }
    }

    public void finalizarServer() throws IOException {
        serverSocket.close();
    }
}
