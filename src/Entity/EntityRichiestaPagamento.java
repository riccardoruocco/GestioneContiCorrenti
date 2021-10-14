package Entity;

public class EntityRichiestaPagamento {

	private String NomeSitoCommerciale;
	private String EsitoTransazione;
	private String Data;
	private int Importo;
	EntityCartaPagamento cartaAssociata;
	
	
	public EntityRichiestaPagamento(String nomeSitoCommerciale, String esitoTransazione, String data, int importo,
			EntityCartaPagamento cartaAssociata) {
		super();
		NomeSitoCommerciale = nomeSitoCommerciale;
		EsitoTransazione = esitoTransazione;
		Data = data;
		Importo = importo;
		this.cartaAssociata = cartaAssociata;
	}


	public EntityRichiestaPagamento() {
		super();
	}
	
	
	
	

}