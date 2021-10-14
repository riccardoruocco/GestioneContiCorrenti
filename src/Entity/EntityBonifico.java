package Entity;
import java.util.Date;

public class EntityBonifico extends EntityOperazioneOnline {

	private String IBANDestinatario;

	public EntityBonifico(Date data, int importo, EntityContoCorrente conto, String iBANDestinatario) {
		super(data, importo, conto);
		IBANDestinatario = iBANDestinatario;
	}

	public EntityBonifico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIBANDestinatario() {
		return IBANDestinatario;
	}

	public void setIBANDestinatario(String iBANDestinatario) {
		IBANDestinatario = iBANDestinatario;
	}

	@Override
	public String toString() {
		return "Bonifico IBANDestinatario=" + IBANDestinatario + ", Data=" + Data + ", Importo=" + Importo + "";
	}
	
	
	

}