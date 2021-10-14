package Entity;

import java.util.List;
import java.util.ArrayList;

public class EntityContoCorrente {

	
	private String CodiceIBAN;
	private int Saldo;
	ArrayList<EntityCliente> titolare;
	ArrayList<EntityOperazioneBancaria> operazione;
	EntityCartaPagamento cartaAssociata;
	
	//costruttore
	public EntityContoCorrente(String codiceIBAN, int saldo, ArrayList<EntityCliente> titolare,
			ArrayList<EntityOperazioneBancaria> operazione, EntityCartaPagamento cartaAssociata) {
		super();
		CodiceIBAN = codiceIBAN;
		Saldo = saldo;
		this.titolare = titolare;
		this.operazione = operazione;
		this.cartaAssociata = cartaAssociata;
	}
	
	public EntityContoCorrente() {
		
	}



	//set-get

	public String getCodiceIBAN() {
		return CodiceIBAN;
	}

	public void setCodiceIBAN(String codiceIBAN) {
		CodiceIBAN = codiceIBAN;
	}

	public int getSaldo() {
		return Saldo;
	}

	public void setSaldo(int saldo) {
		Saldo = saldo;
	}

	public ArrayList<EntityCliente> getTitolare() {
		return titolare;
	}

	public void setTitolare(ArrayList<EntityCliente> titolare) {
		this.titolare = titolare;
	}

	public ArrayList<EntityOperazioneBancaria> getOperazione() {
		return operazione;
	}

	public void setOperazione(ArrayList<EntityOperazioneBancaria> operazione) {
		this.operazione = operazione;
	}

	public EntityCartaPagamento getCartaAssociata() {
		return cartaAssociata;
	}

	public void setCartaAssociata(EntityCartaPagamento cartaAssociata) {
		this.cartaAssociata = cartaAssociata;
	}
	
	
	
	
	
	

}