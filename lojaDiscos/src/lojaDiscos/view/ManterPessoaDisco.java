package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

import lojaDiscos.controller.ControllerPessoaDisco;
import lojaDiscos.model.bean.PessoaDisco;

public class ManterPessoaDisco {

	static ControllerPessoaDisco contPessoaDisco;

	public static void inserir() throws SQLException, ClassNotFoundException {
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa "));
		int idDisco = Integer.parseInt(JOptionPane.showInputDialog("Id Disco "));
		String referencia = JOptionPane.showInputDialog("Referências ");
		PessoaDisco pesDiscEntrada = new PessoaDisco(idPessoa, idDisco, referencia);
		contPessoaDisco = new ControllerPessoaDisco();
		PessoaDisco pesDiscSaida = contPessoaDisco.inserir(pesDiscEntrada);
		JOptionPane.showMessageDialog(null, pesDiscSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa "));
		int idDisco = Integer.parseInt(JOptionPane.showInputDialog("Id Disco "));
		String referencia = JOptionPane.showInputDialog("Referências ");
		PessoaDisco pesDiscEntrada = new PessoaDisco(id, idPessoa, idDisco, referencia);
		contPessoaDisco = new ControllerPessoaDisco();
		PessoaDisco pesDiscSaida = contPessoaDisco.alterar(pesDiscEntrada);
		JOptionPane.showMessageDialog(null, pesDiscSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		PessoaDisco pesDiscEntrada = new PessoaDisco(id);
		contPessoaDisco = new ControllerPessoaDisco();
		PessoaDisco pesDiscSaida = contPessoaDisco.excluir(pesDiscEntrada);
		JOptionPane.showMessageDialog(null, pesDiscSaida.toString());
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		PessoaDisco pesDiscEntrada = new PessoaDisco(id);
		contPessoaDisco = new ControllerPessoaDisco();
		PessoaDisco pesDiscSaida = contPessoaDisco.buscar(pesDiscEntrada);
		JOptionPane.showMessageDialog(null, pesDiscSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {
		String referencia = JOptionPane.showInputDialog("Tecle enter para ver a lista!! ");
		PessoaDisco pesDiscEntrada = new PessoaDisco(referencia);
		contPessoaDisco = new ControllerPessoaDisco();
		List<PessoaDisco> listaPesDiscSaida = contPessoaDisco.lista(pesDiscEntrada);
		for (PessoaDisco pesDisc : listaPesDiscSaida) {
			JOptionPane.showMessageDialog(null, pesDisc.toString());
		}
		menu();
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair??");
			System.out.println(sair);
			if (sair > 0)
				menu();
			break;
		case 1:
			inserir();
			break;
		case 2:
			alterar();
			break;
		case 3:
			excluir();
			break;
		case 4:
			buscar();
			break;
		case 5:
			listar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Erro!!\nOpção invalida!!\nEscolha novamente!!");
			menu();
			break;
		}
	}
}
