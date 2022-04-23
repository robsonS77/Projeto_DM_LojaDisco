package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.PessoaDisco;
import lojaDiscos.util.Conexao;

public class DaoPessoaDisco {
	
	private final Connection c;

	public DaoPessoaDisco() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public PessoaDisco inserir(PessoaDisco pessoaDiscoEntrada) throws SQLException {
		String sql = "INSERT INTO pessoadisco" + " (idPessoa, idDisco, referencia)" + " VALUES (?,?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, pessoaDiscoEntrada.getIdPessoa());
		stmt.setInt(2, pessoaDiscoEntrada.getIdDisco());
		stmt.setString(3, pessoaDiscoEntrada.getReferencia());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			pessoaDiscoEntrada.setId(id);
		}
		stmt.close();
		return pessoaDiscoEntrada;
	}

	public PessoaDisco alterar(PessoaDisco pesDiscEntrada) throws SQLException {
		String sql = "UPDATE pessoaDisco SET idPessoa = ?, idDisco = ?, referencia = ? WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, pesDiscEntrada.getIdPessoa());
		stmt.setInt(2, pesDiscEntrada.getIdDisco());
		stmt.setString(3, pesDiscEntrada.getReferencia());
		stmt.setInt(4, pesDiscEntrada.getId());

		stmt.execute();
		stmt.close();
		return pesDiscEntrada;
	}
	
	public PessoaDisco excluir(PessoaDisco pesDiscEntrada) throws SQLException {
		String sql = "DELETE FROM pessoaDisco WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, pesDiscEntrada.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return pesDiscEntrada;
	}

	public PessoaDisco buscar(PessoaDisco pesDiscEntrada) throws SQLException {
		String sql = "SELECT * FROM pessoaDisco WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, pesDiscEntrada.getId());

		ResultSet rs = stmt.executeQuery();
		PessoaDisco retorno = null;
		while (rs.next()) {
			retorno = new PessoaDisco(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
		}
		stmt.close();
		return retorno;
	}

	public List<PessoaDisco> lista(PessoaDisco pesDiscEntrada) throws SQLException {

		List<PessoaDisco> listaPesDisc = new ArrayList<>();

		String sql = "SELECT  * FROM pessoaDisco WHERE referencia LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + pesDiscEntrada.getReferencia() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			PessoaDisco pesDisc = new PessoaDisco(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaPesDisc.add(pesDisc);
		}

		rs.close();
		stmt.close();

		return listaPesDisc;
	}
}
