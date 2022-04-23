package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import lojaDiscos.controller.ControllerBandaSing;
import lojaDiscos.model.bean.BandaSing;

public class ManterBandaSing {

	public static void inserir() throws SQLException, ClassNotFoundException {
		String nome = JOptionPane.showInputDialog("Nome da banda ou cantor(a)?");
		String pais = JOptionPane.showInputDialog("País de origem ?/nPara Brasil tecle enter!!");
		int anoFormacao = Integer.parseInt(JOptionPane.showInputDialog("Ano de formação da banda "));
		String estilo = JOptionPane.showInputDialog("Estilo músical ");
		BandaSing bandaEntrada = new BandaSing(nome, pais, anoFormacao, estilo);
		ControllerBandaSing contUsu = new ControllerBandaSing();
		BandaSing usuSaida = contUsu.inserir(bandaEntrada);
		JOptionPane.showMessageDialog(null, "" + usuSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id "));
		String nome = JOptionPane.showInputDialog("Nome da banda ou cantor(a) ");
		String pais = JOptionPane.showInputDialog("País de origem ");
		int anoFormacao = Integer.parseInt(JOptionPane.showInputDialog("Ano de formação"));
		String estilo = JOptionPane.showInputDialog("Estilo");
		BandaSing bandaEntrada = new BandaSing(id, nome, pais, anoFormacao, estilo);
		ControllerBandaSing contBanda = new ControllerBandaSing();
		BandaSing bandaSaida = contBanda.alterar(bandaEntrada);
		JOptionPane.showMessageDialog(null, "" + bandaSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id "));
		BandaSing bandaEntrada = new BandaSing(id);
		ControllerBandaSing contBanda = new ControllerBandaSing();
		BandaSing bandaSaida = contBanda.excluir(bandaEntrada);
		JOptionPane.showMessageDialog(null, "" + bandaSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {

		String nome = JOptionPane.showInputDialog("Nome da banda ou cantor(a) ");
		BandaSing bandaEntrada = new BandaSing(nome);
		ControllerBandaSing contBandaSing = new ControllerBandaSing();
		List<BandaSing> lista = contBandaSing.lista(bandaEntrada);
		for (BandaSing bS : lista) {
			JOptionPane.showInternalMessageDialog(null, bS.toString());
		}
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
		BandaSing bandaEntrada = new BandaSing(id);
		ControllerBandaSing contBanda = new ControllerBandaSing();
		BandaSing bandaSaida = contBanda.buscar(bandaEntrada);
		JOptionPane.showMessageDialog(null, "" + bandaSaida.toString());
		menu();
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair? ");
			System.out.println("Valor de Sair = " + sair);
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
			JOptionPane.showMessageDialog(null, "Erro opcao invalida");
			menu();
			break;
		}

	}

}
