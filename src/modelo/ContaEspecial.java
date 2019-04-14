package modelo;

public class ContaEspecial extends ContaAbstrataJ {
	
	private Double limite;
	
	//sobrescrita de metodos
	
	public double realizarSaque(double valor) {
		if(getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
	}
			if(getSaldo() < valor && getSaldo() + limite >= valor) {
				setSaldo(-(valor - getSaldo()));		
			}
			else {
				System.out.println("Saldo insuficiente!");
			}
			return getSaldo();
	}
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public void limite() {
		if(getSaldo() < 0 )
			limite -= getSaldo() - limite;
	}
				
	public double realizarDeposito(double valor) {
		setSaldo(getSaldo() + valor);
		return getSaldo();
	}

    public void setLimite(int limite) {
     
    }

    public void setCliente(PessoaFisica pf) {
        
    }
}
	
