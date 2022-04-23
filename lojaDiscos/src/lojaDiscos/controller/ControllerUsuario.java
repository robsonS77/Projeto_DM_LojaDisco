package lojaDiscos.controller;

import java.sql.SQLException;
import java.util.List;

import lojaDiscos.model.bean.Usuario;
import lojaDiscos.model.dao.DaoUsuario;

public class ControllerUsuario {

	DaoUsuario daoUsu;

	public Usuario inserir(Usuario u) throws SQLException, ClassNotFoundException {
		daoUsu = new DaoUsuario();
		return daoUsu.inserir(u);
	}

	public Usuario alterar(Usuario u) throws SQLException, ClassNotFoundException {
		daoUsu = new DaoUsuario();
		return daoUsu.alterar(u);
	}

	public Usuario excluir(Usuario u) throws SQLException, ClassNotFoundException {
		daoUsu = new DaoUsuario();
		return daoUsu.excluir(u);
	}

	public List<Usuario> listar(Usuario u) throws SQLException, ClassNotFoundException {
		daoUsu = new DaoUsuario();
		return daoUsu.listar(u);
	}

	public Usuario buscar(Usuario u) throws SQLException, ClassNotFoundException {
		daoUsu = new DaoUsuario();
		return daoUsu.buscar(u);
	}

	public boolean validar(Usuario u) throws SQLException, ClassNotFoundException {
		boolean validado = false;
		daoUsu = new DaoUsuario();
		Usuario usuSaida = daoUsu.validar(u);
		if (usuSaida.getLogin().equals("ROBSON")) {
			validado = true;
		}
		return validado;
	}
}
