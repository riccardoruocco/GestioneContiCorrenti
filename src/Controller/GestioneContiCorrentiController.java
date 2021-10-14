package Controller;

import Entity.*;
import DAO.*;
import java.util.*;
import Exception.*;

public class GestioneContiCorrentiController {

	private static GestioneContiCorrentiController instance=null;
	
	private GestioneContiCorrentiController() {
		
	}
	public static GestioneContiCorrentiController getIstance() {
		if(instance==null) {
			instance=new GestioneContiCorrentiController();
		}
		return instance;
	}
	
	public void VisualizzaContiCorrenti() {
		// TODO - implement GestioneContiCorrentiController.VisualizzaContiCorrenti
		throw new UnsupportedOperationException();
	}

	public void GeneraReportOperazioniCliente() {
		// TODO - implement GestioneContiCorrentiController.GeneraReportOperazioniCliente
		throw new UnsupportedOperationException();
	}

	public void RegistraImpiegati() {
		// TODO - implement GestioneContiCorrentiController.RegistraImpiegati
		throw new UnsupportedOperationException();
	}

	public void ApriContoCorrente() {
		// TODO - implement GestioneContiCorrentiController.ApriContoCorrente
		throw new UnsupportedOperationException();
	}

	public void ChiudiContoCorrente() {
		// TODO - implement GestioneContiCorrentiController.ChiudiContoCorrente
		throw new UnsupportedOperationException();
	}

	public void PrelevaContanti() {
		// TODO - implement GestioneContiCorrentiController.PrelevaContanti
		throw new UnsupportedOperationException();
	}

	public void DepositaContanti() {
		// TODO - implement GestioneContiCorrentiController.DepositaContanti
		throw new UnsupportedOperationException();
	}

	public void GeneraReportOperazioniClientiUltimoMese() {
		// TODO - implement GestioneContiCorrentiController.GeneraReportOperazioniClientiUltimoMese
		throw new UnsupportedOperationException();
	}

	public void VisualizzaSaldo() {
		// TODO - implement GestioneContiCorrentiController.VisualizzaSaldo
		throw new UnsupportedOperationException();
	}

	/**
	 * Dato un codiceIBAN cerca tutte le operazioni che lo hanno interessato negli ultimi 30 giorni
	 *  
	 * @param CodiceIBAN
	 * @return lista dei movimenti associata al conto il cui IBAN è stato dato come parametro d'ingresso
	 * @throws BankException
	 * ritorna un eccezione se il parametro di ingresso non è lungo 27 caratteri o se non è un conto esistente
	 */
	public List<EntityOperazioneBancaria> VisualizzaListaMovimenti(String CodiceIBAN) throws BankException{
		// TODO - implement GestioneContiCorrentiController.VisualizzaListaMovimenti
		List<EntityOperazioneBancaria> listaMovimenti = new LinkedList<>();
		List<EntityOperazioneDeposito> listaOperazioniDeposito = new LinkedList<>();
		List<EntityOperazionePrelievo> listaOperazioniPrelievo;
		List<EntityPagamentoOnline> listaPagamentiOnline=new LinkedList<>();
		List<EntityBonifico> listaBonifici=new LinkedList<>();
		
		Date DataOdierna = new Date(System.currentTimeMillis()); //ottengo la data di oggi
		long DifferenzaDate;
		//verifichiamo che il codiceIBAN sia ben formato
		
		if(CodiceIBAN.length() != 27) {
			throw new BankException("Errore!Input Malformato");
		}
		
		//verifichiamo che il codice sia esistente nel DB
		if(!ContoCorrenteDAO.IsPresente(CodiceIBAN))
		{
			throw new BankException("Errore!IBAN Inesistente");

		}
		//se è esistente formiamo la lista dei movimenti bancari
		
		//LEGGO LE OPERAZIONI DI PRELIEVO
		listaOperazioniPrelievo = OperazionePrelievoDAO.readOperazioniPrelievo(CodiceIBAN);
		Iterator<EntityOperazionePrelievo> iP=listaOperazioniPrelievo.iterator();
		
			while (iP.hasNext()) {
			EntityOperazionePrelievo Prelievo;
			Prelievo=iP.next();
		    Date DataPrelievo=Prelievo.getData();
		    DifferenzaDate = (DataOdierna.getTime() - DataPrelievo.getTime() )/86400000L; //ottengo la differenza tra le due date in giorni
		    if(DifferenzaDate < 31) {
		    	listaMovimenti.add(Prelievo);
		    }
		    
		}
			//LEGGO LE OPERAZIONI DI DEPOSITO
			listaOperazioniDeposito = OperazioneDepositoDAO.readOperazioniDeposito(CodiceIBAN);
			Iterator<EntityOperazioneDeposito> iD=listaOperazioniDeposito.iterator();
			
				while (iD.hasNext()) {
				EntityOperazioneDeposito Deposito;
				Deposito=iD.next();
			    Date DataDeposito=Deposito.getData();
			    DifferenzaDate = (DataOdierna.getTime() - DataDeposito.getTime() )/86400000L;
			    if(DifferenzaDate < 31) {
			    	listaMovimenti.add(Deposito);
			    }
			    
			}
			//LEGGO LE OPERAZIONI DI PAGAMENTO ONLINE
				listaPagamentiOnline = PagamentoOnlineDAO.readPagamentiOnline(CodiceIBAN);
				Iterator<EntityPagamentoOnline> iO=listaPagamentiOnline.iterator();
				
					while (iO.hasNext()) {
					EntityPagamentoOnline Pagamento;
					Pagamento=iO.next();
				    Date DataPagamento=Pagamento.getData();
				    DifferenzaDate = (DataOdierna.getTime() - DataPagamento.getTime() )/86400000L;
				    if(DifferenzaDate < 31) {
				    	listaMovimenti.add(Pagamento);
				    }
				    
				}

			//LEGGO LE OPERAZIONI DI BONIFICO
					listaBonifici = BonificoDAO.readBonifici(CodiceIBAN);
					Iterator<EntityBonifico> iB=listaBonifici.iterator();
					
						while (iB.hasNext()) {
						EntityBonifico Bonifico;
						Bonifico=iB.next();
					    Date DataBonifico=Bonifico.getData();
					    DifferenzaDate = (DataOdierna.getTime() - DataBonifico.getTime() )/86400000L;
					    if(DifferenzaDate < 31) {
					    	listaMovimenti.add(Bonifico);
					    }
					    
					}
						
		return listaMovimenti;
	}

	public void EffettuaBonifico() {
		// TODO - implement GestioneContiCorrentiController.EffettuaBonifico
		throw new UnsupportedOperationException();
	}

	public void RichiediPagamento() {
		// TODO - implement GestioneContiCorrentiController.RichiediPagamento
		throw new UnsupportedOperationException();
	}

	private void GeneraCredenzialiWeb() {
		// TODO - implement GestioneContiCorrentiController.GeneraCredenzialiWeb
		throw new UnsupportedOperationException();
	}

	private void GeneraCodiceCartaPagamento() {
		// TODO - implement GestioneContiCorrentiController.GeneraCodiceCartaPagamento
		throw new UnsupportedOperationException();
	}

	private void CalcolaSaldo() {
		// TODO - implement GestioneContiCorrentiController.CalcolaSaldo
		throw new UnsupportedOperationException();
	}

	private void RifiutaPagamento() {
		// TODO - implement GestioneContiCorrentiController.RifiutaPagamento
		throw new UnsupportedOperationException();
	}

}