//pakiety j�zyka JAVA potrzebne do nawi�zania (i obs�ugi) po��czenia z BD
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource; //sterownik bazy danych Oracle

public class Connections {
	
	Connections(){
		this.conn = null;
	}
	
	Connection conn; // obiekt Connection do nawi�zania po��czenia z baz� danych
	
	public void setConnection() throws SQLException, IOException // metoda nawi�zuje po��czenie
	{
		
		Properties prop = new Properties(); // nowy obiekt typu Properites
											// przechowuj�cy parametry
											// po��czenia do BD
		
		FileInputStream in = new FileInputStream("connection.parameters.txt"); // w pliku znajduj� si� parametry po��czenia
		
		prop.load(in); // za�adowanie danych z pliku
		in.close(); // zamkni�cie pliku

		String url = prop.getProperty("jdbc.url"); // pobieramy parametry
													// po��czenia
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");
		String port = prop.getProperty("jdbc.port");
		String SID = prop.getProperty("jdbc.SID");

		OracleDataSource ods; // nowe �r�d�o danych
		ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:" + username + "/" + password + "@" + url + ":" + port + ":" + SID); // ustawiamy
																											// parametry
																											// po��czenia
		
		conn = ods.getConnection(); // nawi�zujemy po��czenie z BD

		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(
				"Połaczenie do bazy danych poprawnie nawiązane. Wersja sterownika BD:" + meta.getDriverVersion());
	}
	
	public ResultSet connectionMakeRead(String SQLPolecenie) throws SQLException 
	{
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(SQLPolecenie);
		
		return rs; 
	}
	
	public void connectionMakeUpdate(String SQLPolecenie) throws SQLException 
	{
		Statement stat = conn.createStatement();
		
		stat.executeUpdate(SQLPolecenie);
	}
	
	public void closeConnection() throws SQLException // zamkni�cie po��czenia
	{
		conn.close(); // ponownie wykorzystanie conn
		System.out.println("Połączenie z bazą zamknięte poprawnie."); // wypisujemy
																		// tekst
	}
	
}
