import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrzypisanieProwadzacychDoRealizacji {
	
	PrzypisanieProwadzacychDoRealizacji() throws SQLException{
		ListaProwadzacych listaProwadzacych = new ListaProwadzacych();
		ListaRealizacji listaRealizacji = new ListaRealizacji();
		ListaPrzypisowProwadzacychDoRealizacji listaPrzypisowProwadzacychDoRealizacji = new ListaPrzypisowProwadzacychDoRealizacji();
		
		PracownikAdministracyjny pracownikAdministracyjny = new PracownikAdministracyjny();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			ResultSet RsProwadzacy = connect.connectionMakeRead("SELECT PR.ID_PRACOWNIKA, IMIE, NAZWISKO FROM ProwadzacyT Pr JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika");
			ResultSet RsPrzedmioty = connect.connectionMakeRead("SELECT id_realizacji, nazwa, kod_przedmiotu, numer_semestru "
				 +	"FROM Realizacje_przedmiotow RP "
				 +	"JOIN Przedmioty P ON RP.id_przedmiotu = P.id_przedmiotu");
			
			while (RsProwadzacy.next()) {
				Prowadzacy prowadzacy = new Prowadzacy(RsProwadzacy.getInt(1),RsProwadzacy.getString(2),RsProwadzacy.getString(3));
				listaProwadzacych.dodajProwadzacego(prowadzacy);
			}
			
			while (RsPrzedmioty.next()) {
				Przedmiot przedmiot = new Przedmiot(RsPrzedmioty.getString(2),  RsPrzedmioty.getString(4));
				RealizacjaPrzedmiotu realizacjaPrzedmiotu = new RealizacjaPrzedmiotu(RsPrzedmioty.getInt(1), przedmiot , RsPrzedmioty.getString(3));
				listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu);
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) // B��d obs�ugi pliku zawieraj�cego parametry po��czenia
		{
			System.out.println("Nie mo�na otworzy� pliku z parametrami po��czenia");
		}
		
		this.listaProwadzacych = listaProwadzacych;
		this.listaRealizacji = listaRealizacji;
		this.pracownikAdministracyjny = pracownikAdministracyjny;
		this.listaPrzypisowProwadzacychDoRealizacji = listaPrzypisowProwadzacychDoRealizacji;
	}
	
	private ListaProwadzacych listaProwadzacych;
	
	private ListaRealizacji listaRealizacji;
	
	private ListaPrzypisowProwadzacychDoRealizacji listaPrzypisowProwadzacychDoRealizacji;
	
	private PracownikAdministracyjny pracownikAdministracyjny;

	private Prowadzacy prowadzacy;

	private RealizacjaPrzedmiotu realizacjaPrzedmiotu;
	
	public List<Prowadzacy> getListaProwadzacych(){
		Set<Prowadzacy> set = new HashSet<Prowadzacy>();
		set = listaProwadzacych.getProwadzacy();
		
		List<Prowadzacy> lista = new ArrayList<Prowadzacy>(set);
		
		return lista;
	}
	
	public List<RealizacjaPrzedmiotu> getListaRealizacji(){
		Set<RealizacjaPrzedmiotu> set = new HashSet<RealizacjaPrzedmiotu>();
		set = listaRealizacji.getRealizacjaPrzedmiotu();
		
		List<RealizacjaPrzedmiotu> lista = new ArrayList<RealizacjaPrzedmiotu>(set);
		
		return lista;
	}
	
	public void przypisanie() {
		pracownikAdministracyjny.przypiszProwadzacegoDoRealizacji(this.prowadzacy, this.realizacjaPrzedmiotu, listaPrzypisowProwadzacychDoRealizacji);
	}

	public void setProwadzacy(Prowadzacy prowadzacy)
	{
		this.prowadzacy = prowadzacy;
	}

	public void setRealizacjaPrzedmiotu(RealizacjaPrzedmiotu realizacjaPrzedmiotu)
	{
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}


	
}
