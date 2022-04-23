package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.Cadastro;
import lojaDiscos.util.Conexao;

public class DaoCadastro {

	private final Connection c;

	public DaoCadastro() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public Cadastro inserir(Cadastro cad) throws SQLException {
		String sql = "INSERT INTO cadastro" + " (nome, email, telefone, endereco)" + " VALUES (?,?,?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, cad.getNome());
		stmt.setString(2, cad.getEmail());
		stmt.setInt(3, cad.getTelefone());
		stmt.setString(4, cad.getEndereco());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			cad.setId(id);
		}
		stmt.close();
		return cad;
	}

	public Cadastro alterar(Cadastro cad) throws SQLException {
		String sql = "UPDATE cadastro SET nome = ?, email = ?, telefone = ?, endereco = ?  WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, cad.getNome());
		stmt.setString(2, cad.getEmail());
		stmt.setInt(3, cad.getTelefone());
		stmt.setString(4, cad.getEndereco());
		stmt.setInt(5, cad.getId());

		stmt.execute();
		stmt.close();
		return cad;
	}

	public Cadastro excluir(Cadastro cad) throws SQLException {
		String sql = "DELETE FROM cadastro WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, cad.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return cad;
	}

	public Cadastro buscar(Cadastro cad) throws SQLException {
		String sql = "SELECT * FROM cadastro WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, cad.getId());

		ResultSet rs = stmt.executeQuery();
		Cadastro retorno = null;
		while (rs.next()) {

			retorno = new Cadastro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

		}
		stmt.close();
		return retorno;
	}

	public List<Cadastro> listar(Cadastro cadEnt) throws SQLException {

		List<Cadastro> cadS = new ArrayList<>();

		String sql = "SELECT * FROM cadastro WHERE nome LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + cadEnt.getNome() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cadastro cad = new Cadastro(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4), 
					rs.getString(5));

			cadS.add(cad);
		}

		rs.close();
		stmt.close();
		return cadS;
	}

}
