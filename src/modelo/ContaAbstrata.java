package modelo;

public abstract class ContaAbstrata {
	
	//parametros / variaveis
	private Integer numConta;
	private PessoaFisica cliente;
	private Double saldo;
	private Integer senha;
	
	
	
	//constructor from superclass
	public ContaAbstrata() {
	}
	
	//constructor using fields
	public ContaAbstrata(Integer numConta, PessoaFisica cliente, Double saldo, Integer senha) {
		
		this.numConta = numConta;
		this.cliente = cliente;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	public double realizarSaque(double valor) {
		if(saldo >= valor)
			return saldo -= valor;
		else {
			System.out.println("Saldo insuficiente");
			return saldo;
		}
	}
	
	public double realizarDeposito(double valor) {
		return saldo += valor;
	}
	
	public boolean verificarSenha(Integer senha) {
		if(!this.senha.equals(senha)) {
			System.out.println("Senha invalida!");
			return false;
		}
		else {
			System.out.println("Bem-vindo(a) "+cliente.getNomePessoa());
			return true;
		}
		
		
		}
		public void verificaSaldo() {
			System.out.println("Conta "+getNumConta());
			System.out.println("Saldo "+getSaldo());
	}
	
	
	
	//generate getters and setters
	public Integer getNumConta() {
		return numConta;
	}
	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}
	public Integer getCliente() {
		return cliente.getIdPessoa();
	}
	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Integer getSenha() {
		return senha;
	}
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
}
