package Entity;

import java.util.ArrayList;

public class EntityCartaPagamento {

	private String CodiceCarta;
	EntityContoCorrente conto;
	ArrayList<EntityRichiestaPagamento> richiesta;
	
	
	//costruttori
	public EntityCartaPagamento(String codiceCarta, EntityContoCorrente conto,
			ArrayList<EntityRichiestaPagamento> richiesta) {
		super();
		CodiceCarta = codiceCarta;
		this.conto = conto;
		this.richiesta = richiesta;
	}


	public EntityCartaPagamento() {
	}
	
	
	


}