package lojaDiscos.model.bean;

public class BandaDisco {

	private int id;
	private int idB;
	private int idD;
	private String referencia;
	private Disco disc;
	private BandaSing bandSin;

	public BandaDisco(int id) {
		this.id = id;
	}

	public BandaDisco(String referencia) {
		this.referencia = referencia;
	}

	public BandaDisco(int idB, int idD, String referencia) {
		this.idB = idB;
		this.idD = idD;
		this.referencia = referencia;
	}

	public BandaDisco(int id, int idB, int idD, String referencia) {
		this.id = id;
		this.idB = idB;
		this.idD = idD;
		this.referencia = referencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdB() {
		return idB;
	}

	public void setIdB(int idB) {
		this.idB = idB;
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Disco getDisc() {
		return disc;
	}

	public void setDisc(Disco disc) {
		this.disc = disc;
	}

	public BandaSing getBandSin() {
		return bandSin;
	}

	public void setBandSin(BandaSing bandSin) {
		this.bandSin = bandSin;
	}

	@Override
    public String toString() {
        String retorno = "";
        String msgBanda ="" ;
        String msgDisco = "" ;
        if(this.bandSin != null) {
            msgBanda = bandSin.toString() + "\n";
        }
        if(this.disc != null) {
            msgDisco = disc.toString() + "\n";
        }
        
        String msgBandaDisco = "\nBandaDisco: " + id 
		+ "\nIdB: " + idB 
		+ "\nIdD: " + idD 
		+ "\nReferencia: " + referencia 
		+"\n";
        retorno = msgBandaDisco + "\n" + msgBanda + "\n" + msgDisco;
                
        return retorno;
    }
}
