package teste;

import java.sql.SQLException;

import controle.FabricaDeConexoes;
import controle.DAO.ClienteDAO;
import modelo.PessoaFisica;
import modelo.ValidaCPF;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
//		FabricaDeConexoes conn = new FabricaDeConexoes();
//////		
//		conn.getConnection();
		ClienteDAO cdao = new ClienteDAO();
		
		PessoaFisica pf = new PessoaFisica();
		
		pf.setNomePessoa("Flavia Almediada");
		pf.setNomeSocial("FGlavinha");
		pf.setCep("21050490");
		pf.setNum("22222");
		pf.setComplemento("casa");
		pf.setCpf("05437084706");
		
		ValidaCPF valid = new ValidaCPF();
		
		if(valid.validarCpf(pf.getCpf()) == true) {
			cdao.inserirClienteF(pf);
		}else
			System.out.println("CPF invalido");
	}

}
