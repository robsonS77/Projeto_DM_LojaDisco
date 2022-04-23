package lojaDiscos.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import lojaDiscos.controller.*;
import lojaDiscos.model.bean.Usuario;

public class ManterUsuario {

	public static void inserir() throws SQLException, ClassNotFoundException {
		String login = JOptionPane.showInputDialog("Login");
		String Senha = JOptionPane.showInputDialog("Senha");
		Usuario usuEntrada = new Usuario(login, Senha);
		ControllerUsuario contUsu = new ControllerUsuario();
		Usuario usuSaida = contUsu.inserir(usuEntrada);
		JOptionPane.showMessageDialog(null, "" + usuSaida.toString());
		menu();
	}

	public static void alterar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
		String login = JOptionPane.showInputDialog("Login");
		String Senha = JOptionPane.showInputDialog("Senha");
		Usuario usuEntrada = new Usuario(id, login, Senha);
		ControllerUsuario contUsu = new ControllerUsuario();
		Usuario usuSaida = contUsu.alterar(usuEntrada);
		JOptionPane.showMessageDialog(null, "" + usuSaida.toString());
		menu();
	}

	public static void excluir() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
		Usuario usuEntrada = new Usuario(id);
		ControllerUsuario contUsu = new ControllerUsuario();
		Usuario usuSaida = contUsu.excluir(usuEntrada);
		JOptionPane.showMessageDialog(null, "" + usuSaida.toString());
		menu();
	}

	public static void listar() throws SQLException, ClassNotFoundException {

		String login = JOptionPane.showInputDialog("Tecle enter para mostrar a lista!!");
		Usuario usuEntrada = new Usuario(login);
		ControllerUsuario contUsu = new ControllerUsuario();
		List<Usuario> lista = contUsu.listar(usuEntrada);
		for (Usuario u : lista) {
			JOptionPane.showInternalMessageDialog(null, u.toString());
		}
		menu();
	}

	public static void buscar() throws SQLException, ClassNotFoundException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
		Usuario usuEntrada = new Usuario(id);
		ControllerUsuario contUsu = new ControllerUsuario();
		Usuario usuSaida = contUsu.buscar(usuEntrada);
		JOptionPane.showMessageDialog(null, "" + usuSaida.toString());
		menu();
	}

	public static boolean validar() throws SQLException, ClassNotFoundException {
		boolean validado = false;
		String login = JOptionPane.showInputDialog("Login");
		String Senha = JOptionPane.showInputDialog("Senha");
		Usuario usuEntrada = new Usuario(login, Senha);
		ControllerUsuario contUsu = new ControllerUsuario();
		validado = contUsu.validar(usuEntrada);

		return validado;
	}

	public static void menu() throws SQLException, ClassNotFoundException {
		int operacao = Integer.parseInt(JOptionPane
				.showInputDialog("0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar"));
		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente Sair?");
			System.out.println(" " + sair);
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
			JOptionPane.showMessageDialog(null, "Erro!!!\nOpção invalida!!\nEscolha novamente!!");
			menu();
			break;
		}

	}

}
