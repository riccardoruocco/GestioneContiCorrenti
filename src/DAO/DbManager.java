package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Exception.BankException;

public class DbManager {
	
	private static DbManager instance=null;
	private Connection conn=null;
	
	private DbManager()
	{
		
	} 
	
	public static DbManager getIstance(){
		if(instance==null) {
			instance=new DbManager();
		}
		return instance;
	}
	
	public Connection getConnection() throws BankException{
		// TODO - implement DbManager.getConnection
		String dbName="./GestioneConti";
		String username="GestioneConti";
		String password=" ";
		try {
			if(conn==null) {
				conn=DriverManager.getConnection("jdbc:h2:"+dbName,"GestioneConti",""); //url da modificare
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException("Errore connessione al database");
		}
		return conn;

	}

	public void closeConnection() throws BankException {
		// TODO - implement DbManager.closeConnection
		try {
			if(conn != null) {
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BankException("Errore chiusura connessione al database");
		}
	}

	   public Object clone() {
		   return null;
	   }
	   
}