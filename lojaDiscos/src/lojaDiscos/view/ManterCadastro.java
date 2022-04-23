package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import lojaDiscos.controller.ControllerCadastro;
import lojaDiscos.model.bean.Cadastro;

public class ManterCadastro {

	public static void inserir() throws SQLException, ClassNotFoundException {

		String nome = JOptionPane.showInputDialog("Nome do cliente ");
		String email = JOptionPane.showInputDialog("E-mail ");
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Telefone "));
		String endereco = JOptionPane.showInputDialog("Endereço (Rua, número, bairro, cep, cidade)");
		Cadastro cadEntrada = new Cadastro(nome, email, telefone, endereco);
		ControllerCadastro contCadastro = new ControllerCadastro();
		Cadastro cadSaida = contCadastro.inserir(cadEntrada);
		JOptionPane.showMessageDialog(null, "" + cadSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		String nome = JOptionPane.showInputDialog("Nome do cliente ");
		String email = JOptionPane.showInputDialog("E-mail ");
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Telefone"));
		String endereco = JOptionPane.showInputDialog("Endereço (Rua, número, bairro, cep, cidade)");
		Cadastro cadEntrada = new Cadastro(id, nome, email, telefone, endereco);
		ControllerCadastro contCadastro = new ControllerCadastro();
		Cadastro cadSaida = contCadastro.alterar(cadEntrada);
		JOptionPane.showMessageDialog(null, "" + cadSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id "));
		Cadastro cadEntrada = new Cadastro(id);
		ControllerCadastro contCadastra = new ControllerCadastro();
		Cadastro cadSaida = contCadastra.excluir(cadEntrada);
		JOptionPane.showMessageDialog(null, "" + cadSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {

		String nome = JOptionPane.showInputDialog("Tecle enter para mostrar a lista!!");
		Cadastro cadEntrada = new Cadastro(nome);
		ControllerCadastro contCadastro = new ControllerCadastro();
		List<Cadastro> lista = contCadastro.listar(cadEntrada);
		for (Cadastro c : lista) {
			JOptionPane.showInternalMessageDialog(null, c.toString());
		}
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));
		Cadastro cadEntrada = new Cadastro(id);
		ControllerCadastro contCadastro = new ControllerCadastro();
		Cadastro cadSaida = contCadastro.buscar(cadEntrada);
		JOptionPane.showInternalMessageDialog(null, "" + cadSaida.toString());
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
			listar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Erro!!\nOpção invalida!!\nEscolha novamente!!");
			menu();
			break;
		}

	}

}
