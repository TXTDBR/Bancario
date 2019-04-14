package modelo;

public class Atendente extends Funcionario{
	
	private String senha = "232njodw";
	public Atendente() {
	
	}

	@Override //annotation
	public double bonificacao() {
		
		return getSalario()*0.05;
	}

	@Override 
	public boolean validaSenha() {
		if(getSenha().equals(senha)) {
			System.out.println("Bem-Vindo(a) "+getNome()+"!");
		return true;
	} 
		else {
			System.out.println("Senha Invalida!");
			return false;
		}
	}
	
	
}
	
