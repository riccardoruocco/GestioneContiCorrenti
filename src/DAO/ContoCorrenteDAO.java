package DAO;

import Exception.BankException;
import java.sql.*;
import Entity.EntityContoCorrente;
import Entity.EntityOperazionePrelievo;



public class ContoCorrenteDAO {
	
	/**
	 * Verifica la presenza nel DB di uno specifico conto corrente
	 * @param CodiceIBAN del conto di cui voglio verificare la presenza
	 * @return valorePresente una condizione booleana che mi indica se il valore è presente nel DB(vero) oppure no(falso)
	 * @throws BankException 
	 * se non riesce ad ottenre la connessione oppure se non riesce ad eseguire la query
	 */
	
	
	public static boolean IsPresente(String CodiceIBAN) throws BankException{
		boolean valorePresente=false;
		DbManager gestoreDB = DbManager.getIstance();		
		Connection conn;
		conn = gestoreDB.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("SELECT * FROM CONTICORRENTI WHERE CodiceIBAN = ?;");
			st.setString(1,CodiceIBAN);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				valorePresente=true;
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
	
		
		return valorePresente;
	}
}