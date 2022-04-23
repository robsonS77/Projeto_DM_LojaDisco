package lojaDiscos.controller;

import java.sql.SQLException;
import java.util.List;

import lojaDiscos.model.bean.Disco;
import lojaDiscos.model.dao.DaoDisco;

public class ControllerDisco {

	DaoDisco daoDisc = null;

	public Disco inserir(Disco d) throws SQLException, ClassNotFoundException {
		daoDisc = new DaoDisco();
		return daoDisc.inserir(d);
	}

	public Disco alterar(Disco d) throws SQLException, ClassNotFoundException {
		daoDisc = new DaoDisco();
		return daoDisc.alterar(d);
	}

	public Disco excluir(Disco d) throws SQLException, ClassNotFoundException {
		daoDisc = new DaoDisco();
		return daoDisc.excluir(d);
	}

	public List<Disco> listar(Disco d) throws SQLException, ClassNotFoundException {
		daoDisc = new DaoDisco();
		return daoDisc.listar(d);
	}

	public Disco buscar(Disco d) throws SQLException, ClassNotFoundException {
		daoDisc = new DaoDisco();
		return daoDisc.buscar(d);
	}

}
