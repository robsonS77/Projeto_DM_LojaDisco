package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.BandaDisco;
import lojaDiscos.util.Conexao;

public class DaoBandaDisco {

	private final Connection c;

	public DaoBandaDisco() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public BandaDisco inserir(BandaDisco bdEntrada) throws SQLException {
		String sql = "INSERT INTO bandadisco" + " (idB, idD, referencia)" + " values (?,?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, bdEntrada.getIdB());
		stmt.setInt(2, bdEntrada.getIdD());
		stmt.setString(3, bdEntrada.getReferencia());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			bdEntrada.setId(id);
		}
		stmt.close();
		return bdEntrada;
	}

	public BandaDisco alterar(BandaDisco bdEntrada) throws SQLException {
		String sql = "UPDATE bandaDisco SET idB = ?, idD = ?, referencia = ? WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, bdEntrada.getIdB());
		stmt.setInt(2, bdEntrada.getIdD());
		stmt.setString(3, bdEntrada.getReferencia());
		stmt.setInt(4, bdEntrada.getId());

		stmt.execute();
		stmt.close();
		return bdEntrada;
	}

	public BandaDisco excluir(BandaDisco bdEntrada) throws SQLException {
		String sql = "DELETE FROM bandaDisco WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, bdEntrada.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return bdEntrada;
	}

	public BandaDisco buscar(BandaDisco bdEntrada) throws SQLException {
		String sql = "SELECT * FROM bandaDisco WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, bdEntrada.getId());

		ResultSet rs = stmt.executeQuery();
		BandaDisco retorno = null;
		while (rs.next()) {
			retorno = new BandaDisco(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
		}
		stmt.close();
		return retorno;
	}

	public List<BandaDisco> lista(BandaDisco bdEntrada) throws SQLException {

		List<BandaDisco> listaBd = new ArrayList<>();

		String sql = "SELECT  * FROM bandaDisco WHERE referencia LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + bdEntrada.getReferencia() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			BandaDisco bD = new BandaDisco(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			listaBd.add(bD);
		}

		rs.close();
		stmt.close();

		return listaBd;
	}
} 
