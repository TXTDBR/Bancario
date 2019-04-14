package controle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.FabricaDeConexoes;
import modelo.Conta;
import modelo.ContaCorrente;
import modelo.ContaEspecial;
import modelo.PessoaFisica;
import modelo.PessoaJuridica;

public class ContaDAO {

    private Connection conn;

    public ContaDAO() {

        conn = new FabricaDeConexoes().getConnection();

    }

    public void inserirContaC(ContaCorrente conta, PessoaFisica pf) throws SQLException {
        String sql = "insert into contacorrente (numConta,idCliente,saldo,senha) values(?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, conta.getNumConta());
        stmt.setInt(2, pf.getIdPessoa());
        stmt.setDouble(3, conta.getSaldo());
        stmt.setInt(4, conta.getSenha());

        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void excluirContaC(ContaCorrente conta, Integer numconta) throws SQLException {
        String sql = "delete from contacorrente where numconta=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, numconta);
        
        stmt.executeUpdate(sql);
    }

    public void alterarContaC(Conta conta, Integer numconta) throws SQLException {
        String sql = "update contacorrente set cliente=?, saldo=?, senha=? where numconta=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

    }

    public List<ContaCorrente> consultarContaC(int numConta) throws SQLException {

        String sql = "select * from contacorrente where numConta = ?";
        //String sql = "select * from clientesF where cliente like ?"; 
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, numConta);
        //stmt.setString(1, "%"cliente"%");

        ResultSet rs = stmt.executeQuery();

        List<ContaCorrente> contaC = new ArrayList<ContaCorrente>();

        while (rs.next()) {
            ContaCorrente c = new ContaCorrente();
            PessoaFisica pf = new PessoaFisica();

            c.setNumConta(rs.getInt("numConta"));
            c.setSaldo(rs.getDouble("saldo"));
            c.setSenha(rs.getInt("senha"));
            pf.setIdPessoa(rs.getInt("idCliente"));
            c.setCliente(pf);

            contaC.add(c);
        }

        rs.close();
        stmt.close();
        conn.close();
        return contaC;

    }

    public void inserirContaE(ContaEspecial conta, PessoaFisica pf) throws SQLException {
        String sql = "insert into contaespecial (numconta,idCliente,saldo,senha,limite) values(?,?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, conta.getNumConta());
        stmt.setInt(2, pf.getIdPessoa());
        stmt.setDouble(3, conta.getSaldo());
        stmt.setInt(4, conta.getSenha());
        stmt.setDouble(5, conta.getLimite());

        stmt.execute();
        stmt.close();
        conn.close();
    }

    public List<ContaEspecial> consultarcontaJNum(int numConta) throws SQLException {

        String sql = "select * from contaespecial where numConta = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, numConta);

        ResultSet rs = stmt.executeQuery();

        List<ContaEspecial> contaespecial = new ArrayList<ContaEspecial>();

        while (rs.next()) {
            ContaEspecial cc = new ContaEspecial();
            PessoaFisica pf = new PessoaFisica();

            cc.setNumConta(rs.getInt("numConta"));
            cc.setSaldo(rs.getDouble("saldo"));
            cc.setLimite(rs.getDouble("limite"));

            pf.setIdPessoa(rs.getInt("idPessoa"));

            cc.setCliente(pf);

            contaespecial.add(cc);

        }
        rs.close();
        stmt.close();
        conn.close();
        return contaespecial;

    }

    public boolean logContaCorrente(int numConta, int senha) throws SQLException {

        boolean status;
        String sql = "select * from contacorrente where numConta = ? and senha = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, numConta);
        stmt.setInt(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            status = true;
        } else {
            status = false;

        }
        rs.close();
        stmt.close();
        conn.close();
        return status;

    }

    public boolean logarContaEspecial(int numConta, int senha) throws SQLException {
        boolean status;
        String sql = "select * from contaespecial where"
                + " numConta = ? and senha = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, numConta);
        stmt.setInt(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            status = true;
        } else {
            status = false;
        }
        rs.close();
        stmt.close();
        conn.close();

        return status;
    }

    public void depositarContaCorrente(int numConta, double valor) throws SQLException {

        double saldo = 0;
        String sql = "select * from contacorrente where numConta = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, numConta);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            saldo = rs.getDouble("saldo");
            saldo += valor;

            String sql2 = "update contacorrente set saldo=? where numConta=?";

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setDouble(1, saldo);
            stmt2.setInt(2, numConta);
            stmt2.executeUpdate();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void sacarContaCorrente(int numConta, double valor) throws SQLException {
        double saldo = 0;
        
        String sql = "select * from contacorrente where numConta = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, numConta);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            saldo = rs.getDouble("saldo");

            saldo -= valor;
            String sql2 = "update contacorrente set saldo=? where numConta=?";

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setDouble(1, saldo);
            stmt2.setInt(2, numConta);
            stmt2.executeUpdate();
        }

        rs.close();
        stmt.close();
        conn.close();

    }

    public double pegaSaldo(int conta) throws SQLException {
        String sql = "select * from contacorrente where numConta = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, conta);

        ResultSet rs = stmt.executeQuery();
        double saldo = 0;
        if (rs.next()) {
            saldo = rs.getDouble("saldo");
        }
        return saldo;
    }

}
