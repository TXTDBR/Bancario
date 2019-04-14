package teste;

import modelo.Conta;
import modelo.Pessoa;
import modelo.PessoaAbstrataF;

public class TestePessoa {
	public static void main(String[] args) {
		
		Pessoa Cliente = new Pessoa();
		
		Cliente.setNomePessoa("Flavia Almeida");
		System.out.println(Cliente.getNomePessoa());
		
		//---------------------------------
		
		Pessoa Cliente2 = new Pessoa("Flavia almeida", "16751333700");
		
		Cliente2.validacao();
		
		
	
		Conta conta = new Conta();
		
		conta.setCliente(Cliente2);
		conta.setSenha(123456);
		conta.verificarSenha(123456);
		
	
		
	}

}
