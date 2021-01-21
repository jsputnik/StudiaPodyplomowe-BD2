import java.io.FileInputStream; //pakiety j�zyka JAVA potrzebne do nawi�zania (i obs�ugi) po��czenia z BD
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

	Connection conn; // obiekt Connection do nawi�zania po��czenia z baz� danych

	public static void main(String[] args) {

		TestDatabase cwiczenie = new TestDatabase(); // zwr�� uwag� jak (i w kt�rym miejscu) tworzony jest obiekt klasy

		try {
			
			cwiczenie.setConnection(); // otwarcie po��czenia z BD
			cwiczenie.connectionTest(); // test po��czenia
			cwiczenie.preparedStatement(); // wykonanie zapytania
			cwiczenie.transactionShowcase(); // obs�uga transakcji
			cwiczenie.closeConnection();// zamkni�cie po��czenia z BD
			
		} 
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		} 
		catch (IOException eIO) // B��d obs�ugi pliku zawieraj�cego parametry po��czenia
		{
			System.out.println("Nie można otworzyć pliku z parametrami połączenia");
		}
	}

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
				"Połączenie do bazy danych poprawnie nawiązane. Wersja sterownika BD:" + meta.getDriverVersion());
	}

	public void closeConnection() throws SQLException // zamkni�cie po��czenia
	{
		conn.close(); // ponownie wykorzystanie conn
		System.out.println("Połączenie z bazą zamknięte poprawnie."); // wypisujemy
																		// tekst
	}

	public void connectionTest() throws SQLException // wykonanie prostego
														// zapytania SQL
	{
		System.out.println("Proste zapytanie SQL:"); // wypisujemy tekst na
														// ekranie konsoli

		// tworzymy nowy obiekt Statement przechowuj�cy polecenie SQL
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

		// Zwr�� uwag� na znak zapytania na ko�cu linii, w to miejsce zostanie
		// wstawiona warto�� wczytana z klawiatury
		PreparedStatement preparedStatement = conn
				.prepareStatement("SELECT Imie, Nazwisko FROM Pracownicy WHERE Imie LIKE ?");

		// Wczytaj parametr Imie
		System.out.println("Podaj Imie pracownika:");
		Scanner in = new Scanner(System.in);

		// Ustaw wczytan� warto��
		preparedStatement.setString(1, in.nextLine());

		// Wykonaj zapytanie oraz zapami�taj zbi�r rezultat�w
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

	public void transactionShowcase() // obs�uga transakcji
	{
		System.out.println("Obsługa transakcji");

		// TODO: Uzupe�nij poni�szy przyk�ad
		try {
			
			conn.setAutoCommit(false);

			// Tutaj umie�� operacje SELECT,UPDATE,DELETE,INSERT

			Statement stat = conn.createStatement();
			int rsInt = stat.executeUpdate("UPDATE Pracownicy SET Zarobki = 4500 WHERE Nazwisko LIKE 'J%'");
			System.out.println("Liczba uaktualnionych wierszy: " + rsInt);
			
			rsInt = stat.executeUpdate("UPDATE Pracownicy SET Zarobki = 4500 WHERE Nazwisko LIKE 'K%'");
			System.out.println("Liczba uaktualnionych wierszy: " + rsInt);
			
			// Je�li nie by�o b��du:
			conn.commit();
			stat.close();
		
		} catch (SQLException eSQL) // co� posz�o nie tak
		{
			try {
				System.out.println("Transakcja wycofana");
				conn.rollback(); // wycofaj transakcj�
			} catch (SQLException e2SQL) {
				System.out.println("Blad przetwarzania SQL"); // inny b��d SQL
			}
		}
	}
}
