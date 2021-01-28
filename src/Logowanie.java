import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logowanie {
	
	Logowanie(){
		kandydat = new Kandydat();
		prowadzacy = new Prowadzacy();
	
	}
	
	private Kandydat kandydat;
	
	private Prowadzacy prowadzacy;
	
	private PracownikAdministracyjny pracownikAdministracyjny;
	
	public Boolean logujKandydata(String pesel) {
		Connections connect = new Connections();
		
		Boolean flaga = false;
		
		try{
			connect.setConnection();
			ResultSet RsKandydat = connect.connectionMakeRead("SELECT id_kandydata, imie, nazwisko, pesel"
				+	"FROM Kandydaci"
				+	"WHERE pesel = " + pesel);
			
			 if(RsKandydat.next()) {
				kandydat.setId(RsKandydat.getInt(1));
				kandydat.setImie(RsKandydat.getString(2));
				kandydat.setNazwisko(RsKandydat.getString(3));
				kandydat.setPesel(RsKandydat.getString(4));
				flaga = true;
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) 
		{
			System.out.println("Nie można otworzyć pliku z parametrami połączenia");
		}
		
		return flaga;
	}
	
	public Boolean logujProwadzacego(String pesel) {
		Connections connect = new Connections();
		
		Boolean flaga = false;
		
		try{
			connect.setConnection();
			ResultSet RsProwadzacy = connect.connectionMakeRead("SELECT Prow.id_pracownika, imie, nazwisko, pesel"
					+ "FROM Prowadzacy Prow"
					+ "JOIN Pracownicy Prac ON Prow.id_pracownika = Prac.id_pracownika"
					 + "WHERE pesel = " + pesel);
			
			while (RsProwadzacy.next()) {
				prowadzacy.setId(RsProwadzacy.getInt(1));
				prowadzacy.setImie(RsProwadzacy.getString(2));
				prowadzacy.setNazwisko(RsProwadzacy.getString(3));
				prowadzacy.setPesel(RsProwadzacy.getString(4));
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) 
		{
			System.out.println("Nie można otworzyć pliku z parametrami połączenia");
		}
		
		return flaga;
	}
	
	public Boolean logujPracownikaAdministracyjnego(String pesel) {
		Connections connect = new Connections();
		
		Boolean flaga = false;
		
		try{
			connect.setConnection();
			ResultSet RsPracownik = connect.connectionMakeRead("SELECT id_pracownika, imie, nazwisko, pesel"
					 + "FROM PRACOWNICY"
					 + "WHERE pesel = " + pesel);
			
			while (RsPracownik.next()) {
				pracownikAdministracyjny.setId(RsPracownik.getInt(1));
				pracownikAdministracyjny.setImie(RsPracownik.getString(2));
				pracownikAdministracyjny.setNazwisko(RsPracownik.getString(3));
				pracownikAdministracyjny.setPesel(RsPracownik.getString(4));
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) 
		{
			System.out.println("Nie można otworzyć pliku z parametrami połączenia");
		}
		
		return flaga;
	}
	
}

