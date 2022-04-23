package lojaDiscos.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lojaDiscos.model.bean.Cadastro;
import lojaDiscos.model.bean.Disco;
import lojaDiscos.model.bean.PessoaDisco;
import lojaDiscos.model.dao.DaoPessoaDisco;

public class ControllerPessoaDisco {

	DaoPessoaDisco daoPessoaDisco = null;

	public PessoaDisco inserir(PessoaDisco pesDiscEntrada) throws SQLException, ClassNotFoundException {
		daoPessoaDisco = new DaoPessoaDisco();
		return daoPessoaDisco.inserir(pesDiscEntrada);
	}

	public PessoaDisco alterar(PessoaDisco pesDiscEntrada) throws SQLException, ClassNotFoundException {
		daoPessoaDisco = new DaoPessoaDisco();
		return daoPessoaDisco.alterar(pesDiscEntrada);
	}

	public PessoaDisco excluir(PessoaDisco pesDiscEntrada) throws SQLException, ClassNotFoundException {
		daoPessoaDisco = new DaoPessoaDisco();
		return daoPessoaDisco.excluir(pesDiscEntrada);
	}

	public PessoaDisco buscar(PessoaDisco pesDiscEntrada) throws SQLException, ClassNotFoundException {
		daoPessoaDisco = new DaoPessoaDisco();
		PessoaDisco pessoaDisco = daoPessoaDisco.buscar(pesDiscEntrada);

		ControllerCadastro contCad = new ControllerCadastro();
		Cadastro pessoaEntrada = new Cadastro(pessoaDisco.getIdPessoa());
		pessoaDisco.setCad(contCad.buscar(pessoaEntrada));

		ControllerDisco contDisco = new ControllerDisco();
		Disco discEntrada = new Disco(pessoaDisco.getIdDisco());
		pessoaDisco.setDisc(contDisco.buscar(discEntrada));

		return pessoaDisco;
	}

	public List<PessoaDisco> lista(PessoaDisco pesDiscEntrada) throws SQLException, ClassNotFoundException {
		daoPessoaDisco = new DaoPessoaDisco();
		List<PessoaDisco> listaPesDisc = daoPessoaDisco.lista(pesDiscEntrada);
		List<PessoaDisco> listaPesDiscAux = new ArrayList<>();
		for (PessoaDisco pesDisc : listaPesDisc) {
			listaPesDiscAux.add(buscar(pesDisc));
		}
		return listaPesDiscAux;
	}
}
