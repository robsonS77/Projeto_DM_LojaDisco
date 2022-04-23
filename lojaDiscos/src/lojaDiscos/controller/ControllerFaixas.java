package lojaDiscos.controller;

import java.sql.SQLException;
import java.util.List;
import lojaDiscos.model.bean.Faixas;
import lojaDiscos.model.dao.DaoFaixas;

public class ControllerFaixas {

	DaoFaixas daoFaixa = null;

	public Faixas inserir(Faixas f) throws SQLException, ClassNotFoundException {
		daoFaixa = new DaoFaixas();
		return daoFaixa.inserir(f);
	}

	public Faixas alterar(Faixas f) throws SQLException, ClassNotFoundException {
		daoFaixa = new DaoFaixas();
		return daoFaixa.alterar(f);
	}

	public Faixas excluir(Faixas f) throws SQLException, ClassNotFoundException {
		daoFaixa = new DaoFaixas();
		return daoFaixa.excluir(f);
	}

	public List<Faixas> listar(Faixas f) throws SQLException, ClassNotFoundException {
		daoFaixa = new DaoFaixas();
		return daoFaixa.listar(f);
	}

	public Faixas buscar(Faixas f) throws SQLException, ClassNotFoundException {
		daoFaixa = new DaoFaixas();
		return daoFaixa.buscar(f);
	}

}
