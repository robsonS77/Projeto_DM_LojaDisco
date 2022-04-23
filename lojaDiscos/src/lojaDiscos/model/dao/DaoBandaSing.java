package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.BandaSing;
import lojaDiscos.util.Conexao;

public class DaoBandaSing {

	private final Connection c;

	public DaoBandaSing() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public BandaSing inserir(BandaSing bS) throws SQLException {
		String sql = "INSERT INTO bandaSing" + " (nome, pais, anoFormacao, estilo)" + " values (?,?,?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, bS.getNome());
		stmt.setString(2, bS.getPais());
		stmt.setInt(3, bS.getAnoFormacao());
		stmt.setString(4, bS.getEstilo());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			bS.setId(id);
		}
		stmt.close();
		return bS;
	}

	public BandaSing alterar(BandaSing bS) throws SQLException {
		String sql = "UPDATE bandaSing SET nome = ?, pais = ?, anoFormacao = ?, estilo = ? WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, bS.getNome());
		stmt.setString(2, bS.getPais());
		stmt.setInt(3, bS.getAnoFormacao());
		stmt.setString(4, bS.getEstilo());
		stmt.setInt(5, bS.getId());

		stmt.execute();
		stmt.close();
		return bS;
	}

	public BandaSing excluir(BandaSing bS) throws SQLException {
		String sql = "DELETE FROM bandaSing WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, bS.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return bS;
	}

	public BandaSing buscar(BandaSing bS) throws SQLException {
		String sql = "SELECT * FROM bandaSing WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, bS.getId());

		ResultSet rs = stmt.executeQuery();
		BandaSing retorno = null;
		while (rs.next()) {

			retorno = new BandaSing(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

		}
		stmt.close();
		return retorno;
	}

	public List<BandaSing> listar(BandaSing bS) throws SQLException {

		List<BandaSing> banSin = new ArrayList<>();

		String sql = "SELECT * FROM bandasing WHERE nome LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + bS.getNome() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			BandaSing banda = new BandaSing(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getString(5));

			banSin.add(banda);
		}

		rs.close();
		stmt.close();
		return banSin;
	}

}
