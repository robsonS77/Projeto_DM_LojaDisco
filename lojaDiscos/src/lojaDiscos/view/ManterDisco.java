package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import lojaDiscos.controller.ControllerDisco;
import lojaDiscos.model.bean.Disco;

public class ManterDisco {

	public static void inserir() throws SQLException, ClassNotFoundException {

		String nome = JOptionPane.showInputDialog("Nome do disco ");
		int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento do disco"));
		String integrantes = JOptionPane.showInputDialog("Integrantes da banda ");
		Disco discoEntrada = new Disco(nome, anoLancamento, integrantes);
		ControllerDisco contDisco = new ControllerDisco();
		Disco discoSaida = contDisco.inserir(discoEntrada);
		JOptionPane.showMessageDialog(null, "" + discoSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		String nome = JOptionPane.showInputDialog("Nome do disco ");
		int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento do disco"));
		String integrantes = JOptionPane.showInputDialog("Integrantes da banda ");
		Disco discoEntrada = new Disco(id, nome, anoLancamento, integrantes);
		ControllerDisco contDisco = new ControllerDisco();
		Disco discoSaida = contDisco.alterar(discoEntrada);
		JOptionPane.showMessageDialog(null, "" + discoSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		Disco discoEntrada = new Disco(id);
		ControllerDisco contDisco = new ControllerDisco();
		Disco discoSaida = contDisco.excluir(discoEntrada);
		JOptionPane.showMessageDialog(null, "" + discoSaida.toString());
		menu();
	}

	public static void lista() throws SQLException, ClassNotFoundException {

		String nome = JOptionPane.showInputDialog("Tecle enter para mostrar a lista!!");
		Disco cadEntrada = new Disco(nome);
		ControllerDisco contDisco = new ControllerDisco();
		List<Disco> lista = contDisco.listar(cadEntrada);
		for (Disco d: lista) {
			JOptionPane.showInternalMessageDialog(null, d.toString());
		}
		
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		Disco discoEntrada = new Disco(id);
		ControllerDisco contDisco = new ControllerDisco();
		Disco discoSaida = contDisco.buscar(discoEntrada);
		JOptionPane.showInternalMessageDialog(null, "" + discoSaida.toString());
		menu();
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
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
			lista();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Erro!!\nOpção invalida!!Escolha novamente!!");
			menu();
			break;
		}

	}

}
