
package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.Disco;
import lojaDiscos.util.Conexao;

public class DaoDisco {

	private final Connection c;

	public DaoDisco() throws SQLException, ClassNotFoundException {

		this.c = new Conexao().getConnection();
	}

	public Disco inserir(Disco disc) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO disco" + "(nome, anoLancamento, integrantes)" + "VALUES(?, ?, ?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, disc.getNome());
		stmt.setInt(2, disc.getAnoLancamento());
		stmt.setString(3, disc.getIntegrantes());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			disc.setId(id);
		}
		stmt.close();
		return disc;
	}

	public Disco alterar(Disco disc) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE disco SET nome = ?, anoLancamento = ?, integrantes = ? WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, disc.getNome());
		stmt.setInt(2, disc.getAnoLancamento());
		stmt.setString(3, disc.getIntegrantes());
		stmt.setInt(4, disc.getId());

		stmt.execute();
		stmt.close();
		return disc;
	}

	public Disco excluir(Disco disc) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM disco WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, disc.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return disc;

	}

	public Disco buscar(Disco disc) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM disco WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, disc.getId());

		ResultSet rs = stmt.executeQuery();
		Disco retorno = null;
		while (rs.next()) {

			retorno = new Disco(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));

		}
		stmt.close();
		return retorno;
	}

	public List<Disco> listar(Disco discEnt) throws SQLException, ClassNotFoundException {

		List<Disco> discList = new ArrayList<>();

		String sql = "SELECT * FROM disco WHERE nome   LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + discEnt.getNome() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Disco disc = new Disco(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));

			discList.add(disc);
		}

		rs.close();
		stmt.close();
		return discList;
	}

}
