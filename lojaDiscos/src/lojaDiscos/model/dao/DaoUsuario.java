package lojaDiscos.model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lojaDiscos.model.bean.Usuario;
import lojaDiscos.util.*;

public class DaoUsuario {

	private final Connection c;

	public DaoUsuario() throws SQLException, ClassNotFoundException {
		this.c = new Conexao().getConnection();
	}

	public Usuario inserir(Usuario usu) throws SQLException {
		String sql = "INSERT INTO usuarios" + " (login, senha)" + " values (?,?)";

		PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, usu.getLogin());
		stmt.setString(2, usu.getSenha());

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int id = rs.getInt(1);
			usu.setId(id);
		}
		stmt.close();
		return usu;
	}

	public Usuario alterar(Usuario usu) throws SQLException {
		String sql = "UPDATE usuarios SET login = ?, senha = ?  WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setString(1, usu.getLogin());
		stmt.setString(2, usu.getSenha());
		stmt.setInt(3, usu.getId());

		stmt.execute();
		stmt.close();
		return usu;
	}

	public Usuario excluir(Usuario usu) throws SQLException {
		String sql = "DELETE FROM usuarios WHERE id = ?";

		PreparedStatement stmt = c.prepareStatement(sql);

		stmt.setInt(1, usu.getId());

		stmt.execute();
		stmt.close();
		c.close();
		return usu;
	}

	public Usuario buscar(Usuario usu) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setInt(1, usu.getId());

		ResultSet rs = stmt.executeQuery();
		Usuario retorno = null;
		while (rs.next()) {

			retorno = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));

		}
		stmt.close();
		return retorno;
	}

	public List<Usuario> listar(Usuario usuEnt) throws SQLException {

		List<Usuario> usus = new ArrayList<>();

		String sql = "SELECT * FROM usuarios WHERE login LIKE ?";
		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, "%" + usuEnt.getLogin() + "%");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Usuario usu = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));

			usus.add(usu);
		}

		rs.close();
		stmt.close();
		return usus;
	}

	public Usuario validar(Usuario usu) throws SQLException {

		String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

		PreparedStatement stmt = this.c.prepareStatement(sql);

		stmt.setString(1, usu.getLogin());
		stmt.setString(2, usu.getSenha());

		ResultSet rs = stmt.executeQuery();

		Usuario usuSaida = null;
		while (rs.next()) {

			usuSaida = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));

		}
		stmt.close();
		System.out.println("Usuario: " + usuSaida.toString());

		return usuSaida;
	}

}
