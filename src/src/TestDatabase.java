import java.io.FileInputStream; //pakiety jêzyka JAVA potrzebne do nawi¹zania (i obs³ugi) po³¹czenia z BD
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

public class TestDatabase {

	Connection conn; // obiekt Connection do nawi¹zania po³¹czenia z baz¹ danych

	public static void main(String[] args) {

		TestDatabase cwiczenie = new TestDatabase(); // zwróæ uwagê jak (i w którym miejscu) tworzony jest obiekt klasy

		try {
			
			cwiczenie.setConnection(); // otwarcie po³¹czenia z BD
			cwiczenie.connectionTest(); // test po³¹czenia
			cwiczenie.preparedStatement(); // wykonanie zapytania
			cwiczenie.transactionShowcase(); // obs³uga transakcji
			cwiczenie.closeConnection();// zamkniêcie po³¹czenia z BD
			
		} 
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		} 
		catch (IOException eIO) // B³¹d obs³ugi pliku zawieraj¹cego parametry po³¹czenia
		{
			System.out.println("Nie mo¿na otworzyæ pliku z parametrami po³¹czenia");
		}
	}

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

	public void closeConnection() throws SQLException // zamkniêcie po³¹czenia
	{
		conn.close(); // ponownie wykorzystanie conn
		System.out.println("Po³¹czenie z baz¹ zamkniête poprawnie."); // wypisujemy
																		// tekst
	}

	public void connectionTest() throws SQLException // wykonanie prostego
														// zapytania SQL
	{
		System.out.println("Proste zapytanie SQL:"); // wypisujemy tekst na
														// ekranie konsoli

		// tworzymy nowy obiekt Statement przechowuj¹cy polecenie SQL
		Statement stat = conn.createStatement();

		// wydajemy zapytanie oraz zapisujemy rezultat w obiekcie typu ResultSet
		ResultSet rs = stat.executeQuery("Select Imie, Nazwisko From Pracownicy");

		System.out.println("---------------------------------");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2)); // iteracyjnie odczytujemy rezultaty zapytania
		}
		System.out.println("---------------------------------");

		rs.close(); // zamykamy obiekt ResultSet
		stat.close(); // zamykamy obiekt Conn
	}

	public void preparedStatement() throws SQLException {
		System.out.println("Prepared statement:");

		// Zwróæ uwagê na znak zapytania na koñcu linii, w to miejsce zostanie
		// wstawiona wartoœæ wczytana z klawiatury
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT Imie, Nazwisko FROM Pracownicy WHERE Imie LIKE ?");

		// Wczytaj parametr Imie
		System.out.println("Podaj Imie pracownika:");
		Scanner in = new Scanner(System.in);

		// Ustaw wczytan¹ wartoœæ
		preparedStatement.setString(1, in.nextLine());

		// Wykonaj zapytanie oraz zapamiêtaj zbiór rezultatów
		ResultSet rs = preparedStatement.executeQuery();

		// Iteracyjnie wypisz rezultaty
		System.out.println("---------------------------------");
		while (rs.next()) {
			System.out.println(rs.getString("Imie") + " " + rs.getString(2));
		}
		System.out.println("---------------------------------");

		// Zamknij ResultSet oraz PreparedStatement
		rs.close();
		preparedStatement.close();
	}

	public void transactionShowcase() // obs³uga transakcji
	{
		System.out.println("Obs³uga transakcji");

		// TODO: Uzupe³nij poni¿szy przyk³ad
		try {
			
			conn.setAutoCommit(false);

			// Tutaj umieœæ operacje SELECT,UPDATE,DELETE,INSERT

			Statement stat = conn.createStatement();
			int rsInt = stat.executeUpdate("UPDATE Pracownicy SET Zarobki = 4500 WHERE Nazwisko LIKE 'J%'");
			System.out.println("Liczba uaktualnionych wierszy: " + rsInt);
			
			rsInt = stat.executeUpdate("UPDATE Pracownicy SET Zarobki = 4500 WHERE Nazwisko LIKE 'K%'");
			System.out.println("Liczba uaktualnionych wierszy: " + rsInt);
			
			// Jeœli nie by³o b³êdu:
			conn.commit();
			stat.close();
		
		} catch (SQLException eSQL) // coœ posz³o nie tak
		{
			try {
				System.out.println("Transakcja wycofana");
				conn.rollback(); // wycofaj transakcjê
			} catch (SQLException e2SQL) {
				System.out.println("Blad przetwarzania SQL"); // inny b³¹d SQL
			}
		}
	}
}
