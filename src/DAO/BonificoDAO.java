package DAO;

import Entity.*;
import Exception.BankException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BonificoDAO extends OperazioneOnlineDAO {

	/**
	 * Restituisce la lista di tutti i bonifici associati ad uno specifico conto
	 * @param CodiceIBAN del conto interessato dai bonifici che voglio ricavare
	 * @return Lista dei bonifici 
	 * @throws BankException 
	 * se non riesce ad ottenre la connessione oppure se non riesce ad eseguire la query
	 */
	public static List<EntityBonifico> readBonifici(String CodiceIBAN) throws BankException{
		// TODO - implement BonificoDAO.readBonifici
		List<EntityBonifico> listaBonifici = new LinkedList<>();
		//aggiungiamo gli apici al codice IBAN
//		String codiceIBAN="'";
//		codiceIBAN=codiceIBAN+CodiceIBAN;
		
		DbManager gestoreDB = DbManager.getIstance();		
		Connection conn;
		conn = gestoreDB.getConnection();
		//ContoCorrenteCodiceIBAN=? AND TipoOperazioneSportello=p
		//String query= "SELECT * FROM OPERAZIONIONLINE WHERE (ContoCorrenteCodiceIBAN = ? AND TipoOperazioneSportello =  'b');";
		
		try {
			//PreparedStatement st=conn.prepareStatement(query);
			PreparedStatement st=conn.prepareStatement("SELECT * FROM OPERAZIONIONLINE WHERE (ContoCorrenteCodiceIBAN =? AND TipoOperazioneOnline ='b');");

			st.setString(1,CodiceIBAN);
			ResultSet rs=st.executeQuery();
			while(rs.next()) { //vediamo
				java.sql.Date data_SQL=rs.getDate("Data");
				int importo=rs.getInt("Importo");
				String IBANDestinatario=rs.getString("IBANDestinatario");
				java.util.Date data = new java.util.Date(data_SQL.getTime()); 					
				EntityBonifico nuovoBonifico=new EntityBonifico();
				nuovoBonifico.setData(data);
				nuovoBonifico.setImporto(importo);
				nuovoBonifico.setIBANDestinatario(IBANDestinatario);
				listaBonifici.add(nuovoBonifico);
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
		return listaBonifici;
	}

}