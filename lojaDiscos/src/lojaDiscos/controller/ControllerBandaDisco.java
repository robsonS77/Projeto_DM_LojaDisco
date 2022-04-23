package lojaDiscos.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.BandaDisco;
import lojaDiscos.model.bean.BandaSing;
import lojaDiscos.model.bean.Disco;
import lojaDiscos.model.dao.DaoBandaDisco;

public class ControllerBandaDisco {

	DaoBandaDisco daoBd = null;

	public BandaDisco inserir(BandaDisco bdEntrada) throws SQLException, ClassNotFoundException {
		daoBd = new DaoBandaDisco();
		return daoBd.inserir(bdEntrada);
	}

	public BandaDisco alterar(BandaDisco bdEntrada) throws SQLException, ClassNotFoundException {
		daoBd = new DaoBandaDisco();
		return daoBd.alterar(bdEntrada);

	}

	public BandaDisco excluir(BandaDisco bdEntrada) throws SQLException, ClassNotFoundException {
		daoBd = new DaoBandaDisco();
		return daoBd.excluir(bdEntrada);
	}

	public BandaDisco buscar(BandaDisco bdEntrada) throws SQLException, ClassNotFoundException {
		daoBd = new DaoBandaDisco();
		BandaDisco bD = daoBd.buscar(bdEntrada);

		ControllerBandaSing contBandaSing = new ControllerBandaSing();
		BandaSing bSingEntrada = new BandaSing(bD.getIdB());
		bD.setBandSin(contBandaSing.buscar(bSingEntrada));

		ControllerDisco contDisco = new ControllerDisco();
		Disco discEntrada = new Disco(bD.getIdD());
		bD.setDisc(contDisco.buscar(discEntrada));

		return bD;
	}

	public List<BandaDisco> lista(BandaDisco bdEntrada) throws SQLException, ClassNotFoundException {
		daoBd = new DaoBandaDisco();
		List<BandaDisco> listaBd = daoBd.lista(bdEntrada);
		List<BandaDisco> listaBdAux = new ArrayList<>();
		for (BandaDisco bD : listaBd) {
			listaBdAux.add(buscar(bD));
		}
		return listaBdAux;
	}
}
