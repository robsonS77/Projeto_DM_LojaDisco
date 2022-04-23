package lojaDiscosPrincipal;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import lojaDiscos.view.ManterBandaDisco;
import lojaDiscos.view.ManterBandaSing;
import lojaDiscos.view.ManterCadastro;
import lojaDiscos.view.ManterDisco;
import lojaDiscos.view.ManterFaixas;
import lojaDiscos.view.ManterPessoaDisco;
import lojaDiscos.view.ManterUsuario;

public class LojaDiscos {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		if (ManterUsuario.validar()) {
			menu();
		}
		else {
			JOptionPane.showMessageDialog(null,"Usuario Invalido");
		}

	}

	public static void menu() throws SQLException, ClassNotFoundException {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog(
				"0 - Sair \n 1 - Usuario \n 2 - Cliente \n 3 - Banda \n 4 - Disco \n 5 - Faixas"
				+ "\n 6 - BandaDisco \n 7 - PessoaDisco"));

		switch (operacao) {
		case 0:
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair??");
			if (sair > 0) 
				menu();
			System.out.println("Digite zero para sair = " + sair);
			break;
		case 1:
			ManterUsuario.menu();
			break;
		case 2:
			ManterCadastro.menu();
			break;
		case 3:
			ManterBandaSing.menu();
			break;
		case 4:
			ManterDisco.menu();
			break;
		case 5:
			ManterFaixas.menu();
			break;
		case 6:
			ManterBandaDisco.menu();
			break;
		case 7:
			ManterPessoaDisco.menu();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Erro!!\nOpcao invalida!!\nEscolha novamente!!");
			menu();
			break;
		}
	}
}
