package Entity;
import java.util.Date;
public class EntityOperazioneSportello extends EntityOperazioneBancaria {

	EntityImpiegato responsabile;

	//costruttore
	
	public EntityOperazioneSportello(Date data, int importo, EntityContoCorrente conto,EntityImpiegato impiegatoResponsabile) {
		super(data, importo, conto);
		// TODO Auto-generated constructor stub
		this.responsabile=impiegatoResponsabile;
	}

	public EntityOperazioneSportello() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//set-get
	public EntityImpiegato getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(EntityImpiegato responsabile) {
		this.responsabile = responsabile;
	}

	
	
	

	
	

}