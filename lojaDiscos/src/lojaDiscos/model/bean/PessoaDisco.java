package lojaDiscos.model.bean;

public class PessoaDisco {
	
	private int id;
	private int idPessoa;
	private int idDisco;
	private String referencia;
	private Cadastro cad;
	private Disco disc;
	
	public PessoaDisco(int id) {
		this.id = id;
	}
	
	public PessoaDisco(String referencia) {
		super();
		this.referencia = referencia;
	}

	public PessoaDisco(int idPessoa, int idDisco, String referencia) {
		this.idPessoa = idPessoa;
		this.idDisco = idDisco;
		this.referencia = referencia;
	}

	public PessoaDisco(int id, int idPessoa, int idDisco, String referencia) {
		this.id = id;
		this.idPessoa = idPessoa;
		this.idDisco = idDisco;
		this.referencia = referencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdDisco() {
		return idDisco;
	}

	public void setIdBanda(int idDisco) {
		this.idDisco = idDisco;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Cadastro getCad() {
		return cad;
	}

	public void setCad(Cadastro cad) {
		this.cad = cad;
	}

	public Disco getDisc() {
		return disc;
	}

	public void setDisc(Disco disc) {
		this.disc = disc;
	}

	@Override
    public String toString() {
        String retorno = "";
        String msgPessoa = "" ;
        String msgDisco = "" ;
        if(this.cad != null) {
            msgPessoa = cad.toString() + "\n";
        }
        if(this.disc != null) {
            msgDisco = disc.toString() + "\n";
        }
        
        String msgPessoaDisco = "\nPessoaDisco: " + id 
		+ "\nId Pessoa: " + idPessoa 
		+ "\nId Disco: " + idDisco 
		+ "\nReferencia: " + referencia 
		+"\n";
        retorno = msgPessoaDisco + "\n" + msgPessoa + "\n" + msgDisco;
                
        return retorno;
    }

}
