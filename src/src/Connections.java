//pakiety jêzyka JAVA potrzebne do nawi¹zania (i obs³ugi) po³¹czenia z BD
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
	
	Connection conn; // obiekt Connection do nawi¹zania po³¹czenia z baz¹ danych
	
	public void setConnection() throws SQLException, IOException // metoda nawi¹zuje po³¹czenie
	{
		
		Properties prop = new Properties(); // nowy obiekt typu Properites
											// przechowuj¹cy parametry
											// po³¹czenia do BD
		
		FileInputStream in = new FileInputStream("connection.parameters.txt"); // w pliku znajduj¹ siê parametry po³¹czenia
		
		prop.load(in); // za³adowanie danych z pliku
		in.close(); // zamkniêcie pliku

		String url = prop.getProperty("jdbc.url"); // pobieramy parametry
													// po³¹czenia
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");
		String port = prop.getProperty("jdbc.port");
		String SID = prop.getProperty("jdbc.SID");

		OracleDataSource ods; // nowe Ÿród³o danych
		ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:" + username + "/" + password + "@" + url + ":" + port + ":" + SID); // ustawiamy
																											// parametry
																											// po³¹czenia
		
		conn = ods.getConnection(); // nawi¹zujemy po³¹czenie z BD

		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(
				"Po³aczenie do bazy danych poprawnie nawi¹zane. Wersja sterownika BD:" + meta.getDriverVersion());
	}
	
	public ResultSet connectionMake(String SQLPolecenie ) throws SQLException 
	{
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery(SQLPolecenie);
		
		return rs; 
	}
	
	public void closeConnection() throws SQLException // zamkniêcie po³¹czenia
	{
		conn.close(); // ponownie wykorzystanie conn
		System.out.println("Po³¹czenie z baz¹ zamkniête poprawnie."); // wypisujemy
																		// tekst
	}
	
}
