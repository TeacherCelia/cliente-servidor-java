package servidor;

import java.util.Random;

public class ServicioPass {

	//---- Lógica del programa con 2 métodos obligatorios + si necesitamos implementar algo más
	//-- caracteres especiales: !@#$%^&*()_-+=.:?
	
	RequisitosPass requisitosPass;
	
	// constructor
    public ServicioPass(RequisitosPass requisitosPass) {
    	this.requisitosPass = requisitosPass;
    }
	
	// método obligatorio para generar la contraseña
	public String generaPass() {
		Random randisimo = new Random(); //objeto random necesario 
        StringBuilder pass = new StringBuilder(); //objeto StringBuilder necesario

        // for para generar minusculas
        for (int i = 0; i < requisitosPass.getNumMinusculas(); i++) {
            pass.append((char) (randisimo.nextInt(26) + 'a'));
        }

        // for para generar mayusculas
        for (int i = 0; i < requisitosPass.getNumMayusculas(); i++) {
            pass.append((char) (randisimo.nextInt(26) + 'A'));
        }

        // for para generar digitos
        for (int i = 0; i < requisitosPass.getNumDigitos(); i++) {
            pass.append(randisimo.nextInt(10));
        }

        // for para generar caracteres especiales
        String caracteresEspeciales = "!@#$%^&*()_-+=.:?";
        for (int i = 0; i < requisitosPass.getNumCaractEspeciales(); i++) {
            pass.append(caracteresEspeciales.charAt(randisimo.nextInt(caracteresEspeciales.length())));
        }
        // ********** PUNTO ADICIONAL 1 ********** //
        // ---- mezclamos los caracteres de la contraseña a generar ---
        // -- primero, hacemos de la contraseña un array de caracteres
        char[] passArray = pass.toString().toCharArray();
        
        // para cada caracter:
        for (int i = 0; i < passArray.length; i++) {
        	// generamos un indice de random para el array
            int indiceRandisimo = randisimo.nextInt(passArray.length);            
            char temporal = passArray[i]; //declaramos una variable temporal
            
            // se intercambian los caracteres en las posiciones i e indiceRandisimo
            passArray[i] = passArray[indiceRandisimo];
            passArray[indiceRandisimo] = temporal;
        }
        // devolvemos como string el array mezclado
        return new String(passArray);      
		
	}
	
	// Método obligatorio para dar la longitud que tendrá la contraseña
	
	public int longitudPass() {
		return requisitosPass.getNumCaractEspeciales() +
	               requisitosPass.getNumDigitos() +
	               requisitosPass.getNumMayusculas() +
	               requisitosPass.getNumMinusculas();
	    }
	
}
