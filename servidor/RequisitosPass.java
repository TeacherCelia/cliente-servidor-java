package servidor;

public class RequisitosPass {
	
	//atributos
	int numCaractEspeciales;
	int numDigitos;
	int numMayusculas;
	int numMinusculas;
	
	//getters y setters
	public int getNumCaractEspeciales() {
		return numCaractEspeciales;
	}
	public void setNumCaractEspeciales(int numCaractEspeciales) {
		this.numCaractEspeciales = numCaractEspeciales;
	}
	public int getNumDigitos() {
		return numDigitos;
	}
	public void setNumDigitos(int numDigitos) {
		this.numDigitos = numDigitos;
	}
	public int getNumMayusculas() {
		return numMayusculas;
	}
	public void setNumMayusculas(int numMayusculas) {
		this.numMayusculas = numMayusculas;
	}
	public int getNumMinusculas() {
		return numMinusculas;
	}
	public void setNumMinusculas(int numMinusculas) {
		this.numMinusculas = numMinusculas;
	}
	
	
    @Override
    public String toString() {
        return "PasswordReqs{minusculas=" + numMinusculas + ", mayusculas=" + numMayusculas +
                ", digitos=" + numDigitos + ", caracteresEspeciales=" + numCaractEspeciales + "}";
    }
		
}
