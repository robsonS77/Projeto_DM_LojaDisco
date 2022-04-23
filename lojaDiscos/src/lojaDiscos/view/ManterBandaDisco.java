package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import lojaDiscos.controller.ControllerBandaDisco;
import lojaDiscos.model.bean.BandaDisco;

public class ManterBandaDisco {

	static ControllerBandaDisco contBandaDisco;

	public static void inserir() throws SQLException, ClassNotFoundException {
		int idB = Integer.parseInt(JOptionPane.showInputDialog("Id banda "));
		int idD = Integer.parseInt(JOptionPane.showInputDialog("Id disco "));
		String referencia = JOptionPane.showInputDialog("Referências ");
		BandaDisco bdEntrada = new BandaDisco(idB, idD, referencia);
		contBandaDisco = new ControllerBandaDisco();
		BandaDisco bdSaida = contBandaDisco.inserir(bdEntrada);
		JOptionPane.showMessageDialog(null, bdSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		int idB = Integer.parseInt(JOptionPane.showInputDialog("Id banda"));
		int idD = Integer.parseInt(JOptionPane.showInputDialog("Id disco "));
		String referencia = JOptionPane.showInputDialog("Referencias ");
		BandaDisco bdEntrada = new BandaDisco(id, idB, idD, referencia);
		contBandaDisco = new ControllerBandaDisco();
		BandaDisco bdSaida = contBandaDisco.alterar(bdEntrada);
		JOptionPane.showMessageDialog(null, bdSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		BandaDisco bdEntrada = new BandaDisco(id);
		contBandaDisco = new ControllerBandaDisco();
		BandaDisco bdSaida = contBandaDisco.excluir(bdEntrada);
		JOptionPane.showMessageDialog(null, bdSaida.toString());
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		BandaDisco bdEntrada = new BandaDisco(id);
		contBandaDisco = new ControllerBandaDisco();
		BandaDisco bdSaida = contBandaDisco.buscar(bdEntrada);
		JOptionPane.showMessageDialog(null, bdSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {
		String referencia = JOptionPane.showInputDialog("Tecle enter para ver a lista!! ");
		BandaDisco bdEntrada = new BandaDisco(referencia);
		contBandaDisco = new ControllerBandaDisco();
		List<BandaDisco> listaBdSaida = contBandaDisco.lista(bdEntrada);
		for (BandaDisco bD : listaBdSaida) {
			JOptionPane.showMessageDialog(null, bD.toString());
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
