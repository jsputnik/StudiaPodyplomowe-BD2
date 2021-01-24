import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuwanieProwadzacychZRealizacji {
	
	UsuwanieProwadzacychZRealizacji(){
		
		listaPrzypisowProwadzacychDoRealizacji = new ListaPrzypisowProwadzacychDoRealizacji();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			
			ResultSet RsPrzypis = connect.connectionMakeRead("SELECT PR.ID_PRACOWNIKA, IMIE, NAZWISKO FROM Prowadzacy Pr JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika");
			
			while (RsPrzypis.next()) {
				Prowadzacy prowadzacy = new Prowadzacy(0, "s", "s");
				Przedmiot przedmiot = new Przedmiot(RsPrzypis.getString(2),  RsPrzypis.getString(4));
				RealizacjaPrzedmiotu realizacjaPrzedmiotu = new RealizacjaPrzedmiotu(RsPrzypis.getInt(1), przedmiot , RsPrzypis.getString(3));
				PrzypisProwadzacegoDoRealizacji przypisProwadzacegoDoRealizacji = new PrzypisProwadzacegoDoRealizacji(prowadzacy, realizacjaPrzedmiotu);
				listaPrzypisowProwadzacychDoRealizacji.dodajPrzypis(przypisProwadzacegoDoRealizacji);
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) 
		{
			System.out.println("Nie mozna otworzyc pliku z parametrami polaczenia");
		}
		
	}
	
	private ListaPrzypisowProwadzacychDoRealizacji listaPrzypisowProwadzacychDoRealizacji;
	
	public List<PrzypisProwadzacegoDoRealizacji> getListaPrzypisowProwadzacychDoRealizacji(){
		List<PrzypisProwadzacegoDoRealizacji> lista = new ArrayList<PrzypisProwadzacegoDoRealizacji>(listaPrzypisowProwadzacychDoRealizacji.getPrzypisProwadzacegoDoRealizacji());
		return lista;
	}
	
	public void usunProwadzacegoZRealizacji() {
		
	}

}
