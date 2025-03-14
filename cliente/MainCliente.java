package cliente;

import java.io.IOException;

public class MainCliente {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// creamos objeto de Cliente
        Cliente cliente = new Cliente();
        System.out.println("Iniciando cliente...");
        
        // iniciamos la conexion e interacción
        cliente.interactua();

	}

}
