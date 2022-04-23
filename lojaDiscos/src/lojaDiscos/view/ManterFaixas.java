package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import lojaDiscos.controller.ControllerFaixas;
import lojaDiscos.model.bean.Faixas;

public class ManterFaixas {

	public static void inserir() throws SQLException, ClassNotFoundException {

		String faixa = JOptionPane.showInputDialog("Título da faixa ");
		Faixas faixaEntrada = new Faixas(faixa);
		ControllerFaixas contFaixa = new ControllerFaixas();
		Faixas faixaSaida = contFaixa.inserir(faixaEntrada);
		JOptionPane.showMessageDialog(null, "" + faixaSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		String faixa = JOptionPane.showInputDialog("Título da faixa ");
		Faixas faixaEntrada = new Faixas(id, faixa);
		ControllerFaixas contFaixa = new ControllerFaixas();
		Faixas faixaSaida = contFaixa.alterar(faixaEntrada);
		JOptionPane.showInternalMessageDialog(null, faixaSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		Faixas faixaEntrada = new Faixas(id);
		ControllerFaixas contFaixas = new ControllerFaixas();
		Faixas faixaSaida = contFaixas.excluir(faixaEntrada);
		JOptionPane.showMessageDialog(null, "" + faixaSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {

		String faixa = JOptionPane.showInputDialog("Tecle enter para mostrar a lista!!");
		Faixas faixaEntrada = new Faixas(faixa);
		ControllerFaixas contFaixa = new ControllerFaixas();
		List<Faixas> lista = contFaixa.listar(faixaEntrada);
		for (Faixas f : lista) {
			JOptionPane.showInternalMessageDialog(null, f.toString());
		}
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		Faixas faixaEntrada = new Faixas(id);
		ControllerFaixas contFaixa = new ControllerFaixas();
		Faixas faixaSaida = contFaixa.buscar(faixaEntrada);
		JOptionPane.showInternalMessageDialog(null, "" + faixaSaida.toString());
		menu();
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
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
