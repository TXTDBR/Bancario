package modelo;

public class Caixa extends Funcionario {
	private String senha = "232njodw";
	public Caixa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double bonificacao() {
		// TODO Auto-generated method stub
		return getSalario()*0.1;
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
