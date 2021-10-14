package Entity;
import java.util.Date;
public class EntityOperazionePrelievo extends EntityOperazioneSportello {

	public EntityOperazionePrelievo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityOperazionePrelievo(Date data, int importo, EntityContoCorrente conto,
			EntityImpiegato impiegatoResponsabile) {
		super(data, importo, conto, impiegatoResponsabile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Prelievo " + Data + ", Importo=" + Importo + "";
	}
	
	
}