package DAO;

import Entity.*;
import Exception.BankException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class OperazioneDepositoDAO extends OperazioneSportelloDAO {

	/**
	 * Restituisce la lista di tutti i depositi associati ad uno specifico conto
	 * @param CodiceIBAN del conto interessato dai depositi che voglio ricavare
	 * @return Lista dei depositi 
	 * @throws BankException 
	 * se non riesce ad ottenre la connessione oppure se non riesce ad eseguire la query
	 */
	public static List<EntityOperazioneDeposito> readOperazioniDeposito(String CodiceIBAN) throws BankException{
		// TODO - implement OperazioneDepositoDAO.readOperazioniDeposito
		List<EntityOperazioneDeposito> listaOperazioniDeposito = new LinkedList<>();
		
//		String codiceIBAN="'";
//		codiceIBAN=codiceIBAN+CodiceIBAN;
//		codiceIBAN=codiceIBAN+"'";
		
		
		DbManager gestoreDB = DbManager.getIstance();		
		Connection conn;
		conn = gestoreDB.getConnection();
		//ContoCorrenteCodiceIBAN=? AND TipoOperazioneSportello=p
		String query= "SELECT * FROM OPERAZIONISPORTELLO WHERE (ContoCorrenteCodiceIBAN = ? AND TipoOperazioneSportello =  'd');";
		try {
			PreparedStatement st=conn.prepareStatement(query);
			st.setString(1,CodiceIBAN);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				java.sql.Date data_SQL=rs.getDate("Data");
				int importo=rs.getInt("Importo");
				
				java.util.Date data = new java.util.Date(data_SQL.getTime());
				EntityOperazioneDeposito nuovaOperazione=new EntityOperazioneDeposito();
				nuovaOperazione.setData(data);
				nuovaOperazione.setImporto(importo);
				
				listaOperazioniDeposito.add(nuovaOperazione);
			}
			rs.close();
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException("Errore nell'interrogazione del DB");
		}
		finally {
			gestoreDB.closeConnection();
		}
		
		return listaOperazioniDeposito;
	}
	

}