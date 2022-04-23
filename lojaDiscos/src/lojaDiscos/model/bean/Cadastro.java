package lojaDiscos.model.bean;

public class Cadastro {
	
	private int id;
	private String nome;
	private String email;
	private int telefone;
	private String endereco;
	
	public Cadastro(int id) {
		super();
		this.id = id;
	}

	public Cadastro(String nome) {
		super();
		this.nome = nome;
	}

	public Cadastro(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Cadastro(int id, String nome, String email, int telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Cadastro(String nome, String email, int telefone, String endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente Id: " + id 
				+ "\nNome: " + nome 
				+ "\ne-mail: " + email 
				+ "\nTelefone: " + telefone 
				+ "\nEndereco: " + endereco ;
	}

}
