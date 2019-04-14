package modelo;

public class PessoaJuridica extends PessoaAbstrataF{
	
	private String cnpj;
	
	ValidaCNPJ valida = new ValidaCNPJ();
	
	public void validacao() {
		if(valida.ValidaCNPJ(cnpj) == false)
			System.out.println("CNPJ Invalido");
		else
			valida.imprimeCNPJ(cnpj);
	}
	
	public String getcnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
