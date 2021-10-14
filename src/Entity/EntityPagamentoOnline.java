package Entity;
import java.util.Date;

public class EntityPagamentoOnline extends EntityOperazioneOnline {

	private String NomeSitoCommerciale;

	public EntityPagamentoOnline(Date data, int importo, EntityContoCorrente conto, String nomeSitoCommerciale) {
		super(data, importo, conto);
		NomeSitoCommerciale = nomeSitoCommerciale;
	}

	public EntityPagamentoOnline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomeSitoCommerciale() {
		return NomeSitoCommerciale;
	}

	public void setNomeSitoCommerciale(String nomeSitoCommerciale) {
		NomeSitoCommerciale = nomeSitoCommerciale;
	}

	@Override
	
	public String toString() {
		return "Pagamento Online Nome Sito:" + NomeSitoCommerciale + " " + Data + ", Importo="
				+ Importo + "";
	}
	

	

	
	
	

}