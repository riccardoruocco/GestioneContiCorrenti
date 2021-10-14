package Entity;

import java.util.*;

public class EntityImpiegato {

	private String Nome;
	private String Cognome;
	private String Email;
	private String NumeroDiTelefonoAziendale;
	ArrayList<EntityOperazioneSportello> OperazioniEseguite;
	
	
	//costruttore
	public EntityImpiegato(String nome, String cognome, String email, String numeroDiTelefonoAziendale,
			ArrayList<EntityOperazioneSportello> operazioniEseguite) {
		Nome = nome;
		Cognome = cognome;
		Email = email;
		NumeroDiTelefonoAziendale = numeroDiTelefonoAziendale;
		OperazioniEseguite = operazioniEseguite;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getCognome() {
		return Cognome;
	}


	public void setCognome(String cognome) {
		Cognome = cognome;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getNumeroDiTelefonoAziendale() {
		return NumeroDiTelefonoAziendale;
	}


	public void setNumeroDiTelefonoAziendale(String numeroDiTelefonoAziendale) {
		NumeroDiTelefonoAziendale = numeroDiTelefonoAziendale;
	}


	public ArrayList<EntityOperazioneSportello> getOperazioniEseguite() {
		return OperazioniEseguite;
	}


	public void setOperazioniEseguite(ArrayList<EntityOperazioneSportello> operazioniEseguite) {
		OperazioniEseguite = operazioniEseguite;
	}
	
	
	

}