package Boundary;

import Entity.*;
import Exception.BankException;
import java.util.*;
import Controller.GestioneContiCorrentiController;


public class BoundaryClienteAutenticatoOnline {

	public void VisualizzaSaldo() {
		// TODO - implement BoundaryClienteAutenticatoOnline.VisualizzaSaldo
		throw new UnsupportedOperationException();
	}
	/**
	 *Viene effettuto l'interfacciamento con l'applicazione per la gestione dei conti correnti
	 *  
	 * @param CodiceIBAN
	 * 
	 * 
	 * 
	 */
	public void VisualizzaListaMovimenti(String CodiceIBAN) {
		// TODO - implement BoundaryClienteAutenticatoOnline.VisualizzaListaMovimenti
		List<EntityOperazioneBancaria> listaMovimenti = new LinkedList<>();
		GestioneContiCorrentiController GestioneConti= GestioneContiCorrentiController.getIstance();
		
		try {
			listaMovimenti=GestioneConti.VisualizzaListaMovimenti(CodiceIBAN);
			Iterator<EntityOperazioneBancaria> i=listaMovimenti.iterator();
			while(i.hasNext()) {
				System.out.println(i.next());    //posso stampare direttamente l'oggetto perché ho ridefinito il metodo 
												//toString che ogni oggetto eredita da Object
			}
			
		} catch (BankException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	public void EffettuaBonifico() {
		// TODO - implement BoundaryClienteAutenticatoOnline.EffettuaBonifico
		throw new UnsupportedOperationException();
	}

}