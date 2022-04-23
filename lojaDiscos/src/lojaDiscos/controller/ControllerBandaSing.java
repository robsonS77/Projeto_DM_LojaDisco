package lojaDiscos.controller;

import java.sql.SQLException;
import java.util.List;

import lojaDiscos.model.bean.BandaSing;
import lojaDiscos.model.dao.DaoBandaSing;

public class ControllerBandaSing {

	DaoBandaSing daoBanda = null;

	public BandaSing inserir(BandaSing bS) throws SQLException, ClassNotFoundException {
		daoBanda = new DaoBandaSing();
		return daoBanda.inserir(bS);
	}

	public BandaSing alterar(BandaSing bS) throws SQLException, ClassNotFoundException {
		daoBanda = new DaoBandaSing();
		return daoBanda.alterar(bS);
	}

	public BandaSing excluir(BandaSing bS) throws SQLException, ClassNotFoundException {
		daoBanda = new DaoBandaSing();
		return daoBanda.excluir(bS);
	}

	public List<BandaSing> lista(BandaSing bS) throws SQLException, ClassNotFoundException {
		daoBanda = new DaoBandaSing();
		return daoBanda.listar(bS);
	}

	public BandaSing buscar(BandaSing bS) throws SQLException, ClassNotFoundException {
		daoBanda = new DaoBandaSing();
		return daoBanda.buscar(bS);
	}

}
