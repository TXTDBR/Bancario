package modelo;

public class PessoaFisica extends PessoaAbstrataF{

	
	private String cpf;
	
	
	public PessoaFisica() {
		
	}

	ValidaCPF valid = new ValidaCPF();
	
	public boolean validacao() {
		if (!valid.validarCpf(cpf)) {
			System.out.println("CPF Invalido");
		return false;
		}else
			return true;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    public void setidPessoa(int aInt) {
       
    }
	
	
}
