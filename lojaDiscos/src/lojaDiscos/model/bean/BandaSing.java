package lojaDiscos.model.bean;

public class BandaSing {
	
	private int id;
	private String nome;
	private String pais;
	private int anoFormacao;
	private String estilo;
	
	public BandaSing(int id) {
		super();
		this.id = id;
	}
	
	public BandaSing(String nome) {
		super();
		this.nome = nome;
	}

	public BandaSing(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public BandaSing(String nome, String pais, int anoFormacao, String estilo) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.anoFormacao = anoFormacao;
		this.estilo = estilo;
	}
	public BandaSing(int id, String nome, String pais, int anoFormacao, String estilo) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.anoFormacao = anoFormacao;
		this.estilo = estilo;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getAnoFormacao() {
		return anoFormacao;
	}
	public void setAnoFormacao(int anoFormacao) {
		this.anoFormacao = anoFormacao;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	@Override
	public String toString() {
		return "\nBanda Id: " + id 
				+ "\nNome da Banda: " + nome 
				+ "\nPaís de origem:  " +pais 
				+ "\nAno de formacao:  " + anoFormacao
				+ "\nEstilo musical: " + estilo +" \n";
	}

}
