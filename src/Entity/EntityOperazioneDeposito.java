package Entity;
import java.util.Date;

public class EntityOperazioneDeposito extends EntityOperazioneSportello {

	public EntityOperazioneDeposito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityOperazioneDeposito(Date data, int importo, EntityContoCorrente conto,
			EntityImpiegato impiegatoResponsabile) {
		super(data, importo, conto, impiegatoResponsabile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Deposito " + Data + ", Importo=" + Importo + "";
	}
	
	
}