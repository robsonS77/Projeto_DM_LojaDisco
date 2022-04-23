package lojaDiscos.model.bean;

public class Disco {

	private int id;
	private String nome;
	private int anoLancamento;
	private String integrantes;

	public Disco(int id) {
		this.id = id;
	}
	
	public Disco(String nome) {
		this.nome = nome;
	}

	public Disco(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Disco(String nome, int anoLancamento, String integrantes) {
		this.nome = nome;
		this.anoLancamento = anoLancamento;
		this.integrantes = integrantes;
	}

	public Disco(int id, String nome, int anoLancamento, String integrantes) {
		this.id = id;
		this.nome = nome;
		this.anoLancamento = anoLancamento;
		this.integrantes = integrantes;
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

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
	}

	@Override
	public String toString() {
		return "\nDisco Id: " + id 
				+ "\nNome do disco: " + nome 
				+ "\nAno de Lançamento: " + anoLancamento 
				+ "\nIntegrantes: "	+ integrantes;
	}

}
