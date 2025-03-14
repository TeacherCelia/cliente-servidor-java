package servidor;

import java.io.IOException;

public class MainServidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// definimos objeto servidor
    	Servidor servidor = new Servidor();    	
        System.out.println("Servidor arrancado");
        
        // iniciamos el servidor
        servidor.start();
        
        // finalizamos el servidor
        servidor.finalizarServer();

	}
}


