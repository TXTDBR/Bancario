package modelo;

public class Gerente extends Funcionario {
	private String senha = "232njodw";
	public Gerente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double bonificacao() {
		// TODO Auto-generated method stub
		return getSalario()*0.175 + 2500.0;
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
