package lojaDiscos.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.Faixas;
import lojaDiscos.util.Conexao;

public class DaoFaixas {

	private final Connection c;

	public DaoFaixas() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public Faixas inserir(Faixas fX) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO faixas" + " (faixa)" + " VALUE (?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, fX.getFaixa());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			fX.setId(id);
		}
		stmt.close();
		return fX;
	}

	public Faixas alterar(Faixas fX) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE faixas SET faixa = ?  WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, fX.getFaixa());
		stmt.setInt(2, fX.getId());

		stmt.execute();
		stmt.close();
		return fX;

	}

	public Faixas excluir(Faixas fX) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM faixas WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, fX.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return fX;
	}

	public Faixas buscar(Faixas fX) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM faixas WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, fX.getId());

		ResultSet rs = stmt.executeQuery();
		Faixas retorno = null;
		while (rs.next()) {

			retorno = new Faixas(rs.getInt(1), rs.getString(2));

		}
		stmt.close();
		return retorno;
	}

	public List<Faixas> listar(Faixas fXent) throws SQLException, ClassNotFoundException {

		List<Faixas> fai = new ArrayList<>();

		String sql = "SELECT * FROM faixas WHERE faixa LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + fXent.getFaixa() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Faixas faixa = new Faixas(rs.getInt(1), rs.getString(2));

			fai.add(faixa);
		}

		rs.close();
		stmt.close();
		return fai;
	}

}
