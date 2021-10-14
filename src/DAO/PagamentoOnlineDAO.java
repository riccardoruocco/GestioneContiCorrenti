package DAO;

import Entity.*;
import Exception.BankException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PagamentoOnlineDAO extends OperazioneOnlineDAO {

	/**
	 * Restituisce la lista di tutti i pagamenti online associati ad uno specifico conto
	 * @param CodiceIBAN del conto che ha erogato i pagamenti che voglio ricavare
	 * @return Lista dei pagamenti 
	 * @throws BankException 
	 * se non riesce ad ottenre la connessione oppure se non riesce ad eseguire la query
	 */
	public static List<EntityPagamentoOnline> readPagamentiOnline(String CodiceIBAN) throws BankException{
		// TODO - implement PagamentoOnlineDAO.readPagamentiOnline
		List<EntityPagamentoOnline> listaPagamentiOnline = new LinkedList<>();
		
//		String codiceIBAN="'";
//		codiceIBAN=codiceIBAN+CodiceIBAN;
//		
		DbManager gestoreDB = DbManager.getIstance();		
		Connection conn;
		conn = gestoreDB.getConnection();
		//ContoCorrenteCodiceIBAN=? AND TipoOperazioneSportello=p
		//String query= "SELECT * FROM OPERAZIONIONLINE WHERE (ContoCorrenteCodiceIBAN = ? AND TipoOperazioneSportello =  'o');";
		try {
			//PreparedStatement st=conn.prepareStatement(query);
			PreparedStatement st=conn.prepareStatement("SELECT * FROM OPERAZIONIONLINE WHERE (ContoCorrenteCodiceIBAN =? AND TipoOperazioneOnline ='o');");

			st.setString(1,CodiceIBAN);
			ResultSet rs=st.executeQuery();
			while(rs.next()) { //vediamo
				java.sql.Date data_SQL=rs.getDate("Data");
				int importo=rs.getInt("Importo");
				String nomeSito=rs.getString("NomeSitoCommerciale");
				
				java.util.Date data = new java.util.Date(data_SQL.getTime()); 	
				EntityPagamentoOnline nuovoPagamento=new EntityPagamentoOnline();
				nuovoPagamento.setData(data);
				nuovoPagamento.setImporto(importo);
				nuovoPagamento.setNomeSitoCommerciale(nomeSito);
				listaPagamentiOnline.add(nuovoPagamento);
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
		
		
		
		
		return listaPagamentiOnline;
	}

}