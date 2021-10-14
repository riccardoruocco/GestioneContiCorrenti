package Entity;
import java.util.*;
public class EntityOperazioneBancaria {

	protected Date Data;
	protected int Importo;
	EntityContoCorrente conto;
	
	
	//costruttore
	
	
	
	
	public EntityOperazioneBancaria() {
		
	}


	public EntityOperazioneBancaria(Date data, int importo, EntityContoCorrente conto) {
		Data = data;
		Importo = importo;
		this.conto = conto;
	}


	//set-get

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
	
	public int getImporto() {
		return Importo;
	}
	
	public void setImporto(int importo) {
		Importo = importo;
	}

	public EntityContoCorrente getConto() {
		return conto;
	}

	public void setConto(EntityContoCorrente conto) {
		this.conto = conto;
	}


	@Override
	public String toString() {
		return "EntityOperazioneBancaria [Data=" + Data + ", Importo=" + Importo + "]";
	}

	
	

}