package lojaDiscos.model.bean;

public class Faixas {

	private int id;
	private String faixa;
	
	public Faixas(String faixa) {
		this.faixa = faixa;
	}
	
	public Faixas(int id) {
		this.id = id;
	}

	public Faixas(int id, String faixa) {
		this.id = id;
		this.faixa = faixa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	@Override
	public String toString() {
		return "Faixa Id " + id 
				+ "\nFaixas:   \n" + faixa;
	}
	
}
