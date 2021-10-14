package Entity;

import java.util.*;

/**
 * 
 */
public class EntityCliente {
	
	private String Nome;
	private String Cognome;
	private String Email;
	private String NumeroDiTelefono;
	private String CodiceFiscale;
	private String Username;
	private String Password;
	ArrayList<EntityContoCorrente> conto;
	
	
	//costruttore
	
	public EntityCliente(String nome, String cognome, String email, String numeroDiTelefono, String codiceFiscale,
			String username, String password, ArrayList<EntityContoCorrente> conto) {
		Nome = nome;
		Cognome = cognome;
		Email = email;
		NumeroDiTelefono = numeroDiTelefono;
		CodiceFiscale = codiceFiscale;
		Username = username;
		Password = password;
		this.conto = conto;
	}

	
	//set-get
	
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

	public String getNumeroDiTelefono() {
		return NumeroDiTelefono;
	}

	public void setNumeroDiTelefono(String numeroDiTelefono) {
		NumeroDiTelefono = numeroDiTelefono;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public ArrayList<EntityContoCorrente> getConto() {
		return conto;
	}

	public void setConto(ArrayList<EntityContoCorrente> conto) {
		this.conto = conto;
	}
	
	

	
	
	
	

}