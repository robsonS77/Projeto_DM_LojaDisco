package lojaDiscos.model.bean;

public class Usuario {

	private int id;
	private String login;
	private String senha;

	public Usuario() {

	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(int id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario(int id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String login) {
		super();
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario Id: " + id 
				+ "\nLogin: " + login;
	}

}
