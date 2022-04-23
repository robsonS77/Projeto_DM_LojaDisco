package lojaDiscos.controller;

import java.util.List;
import lojaDiscos.model.bean.Cadastro;
import lojaDiscos.model.dao.DaoCadastro;
import java.sql.SQLException;

public class ControllerCadastro {

	DaoCadastro daoCadas = null;

	public Cadastro inserir(Cadastro c) throws SQLException, ClassNotFoundException {
		daoCadas = new DaoCadastro();
		return daoCadas.inserir(c);
	}

	public Cadastro alterar(Cadastro c) throws SQLException, ClassNotFoundException {
		daoCadas = new DaoCadastro();
		return daoCadas.alterar(c);
	}

	public Cadastro excluir(Cadastro c) throws SQLException, ClassNotFoundException {
		daoCadas = new DaoCadastro();
		return daoCadas.excluir
				(c);
	}

	public List<Cadastro> listar(Cadastro c) throws SQLException, ClassNotFoundException {
		daoCadas = new DaoCadastro();
		return daoCadas.listar(c);
	}

	public Cadastro buscar(Cadastro c) throws SQLException, ClassNotFoundException {
		daoCadas = new DaoCadastro();
		return daoCadas.buscar(c);
	}

}
