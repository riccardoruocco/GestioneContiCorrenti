package DAO;

import Entity.*;
import java.util.*;
import Entity.EntityOperazionePrelievo;
import Exception.BankException;
import java.sql.*;
import java.sql.Date;

public class OperazionePrelievoDAO extends OperazioneSportelloDAO {

	/**
	 * Restituisce la lista di tutti i prelievi associati ad uno specifico conto
	 * @param CodiceIBAN del conto interessato dai prelievi che voglio ricavare
	 * @return Lista dei prelievi
	 * @throws BankException 
	 * se non riesce ad ottenre la connessione oppure se non riesce ad eseguire la query
	 */
	public static List<EntityOperazionePrelievo> readOperazioniPrelievo(String CodiceIBAN) throws BankException{
		// TODO - implement OperazionePrelievoDAO.readOperazioniPrelievo
		
		List<EntityOperazionePrelievo> listaOperazioniPrelievo = new LinkedList<>();
//		String codiceIBAN="'";
//		
//		codiceIBAN=codiceIBAN+CodiceIBAN;
//		codiceIBAN=codiceIBAN+"'";
		
		DbManager gestoreDB = DbManager.getIstance();		
		Connection conn;
		conn = gestoreDB.getConnection();
		//ContoCorrenteCodiceIBAN=? AND TipoOperazioneSportello=p
		//String query= "SELECT * FROM OPERAZIONISPORTELLO WHERE (ContoCorrenteCodiceIBAN ='?' AND TipoOperazioneSportello ='p');";
		try {
			PreparedStatement st=conn.prepareStatement("SELECT * FROM OPERAZIONISPORTELLO WHERE (ContoCorrenteCodiceIBAN =? AND TipoOperazioneSportello ='p');");
			st.setString(1,CodiceIBAN);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				java.sql.Date data_SQL=rs.getDate("Data");
				int importo=rs.getInt("Importo");
				java.util.Date data = new java.util.Date(data_SQL.getTime()); 
				EntityOperazionePrelievo nuovaOperazione=new EntityOperazionePrelievo();
				nuovaOperazione.setData(data);
				nuovaOperazione.setImporto(importo);
				listaOperazioniPrelievo.add(nuovaOperazione);
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
		
		return listaOperazioniPrelievo;
	}

}