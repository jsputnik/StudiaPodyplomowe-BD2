import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuwanieProwadzacychZRealizacji {
	
	UsuwanieProwadzacychZRealizacji(){
		
		listaPrzypisowProwadzacychDoRealizacji = new ListaPrzypisowProwadzacychDoRealizacji();
		
		pracownikAdministracyjny = new PracownikAdministracyjny();
		
		prowadzacy = new Prowadzacy();
		
		realizacjaPrzedmiotu = new RealizacjaPrzedmiotu();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			
			ResultSet RsPrzypis = connect.connectionMakeRead("SELECT Rpr.id_realizacji, nazwa, kod_przedmiotu, numer_semestru, P.id_pracownika, imie, nazwisko "
				+	"FROM Przypisy_prow_do_real PR "
				+	"JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika "
				+	"JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika "
				+	"JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji "
				+	"JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu");
			
			while (RsPrzypis.next()) {
				Prowadzacy prowadzacy = new Prowadzacy(RsPrzypis.getInt(5), RsPrzypis.getString(6), RsPrzypis.getString(7));
				Przedmiot przedmiot = new Przedmiot(RsPrzypis.getString(2),  RsPrzypis.getString(3));
				RealizacjaPrzedmiotu realizacjaPrzedmiotu = new RealizacjaPrzedmiotu(RsPrzypis.getInt(1), przedmiot , RsPrzypis.getString(4));
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
	
	private PracownikAdministracyjny pracownikAdministracyjny;

	private Prowadzacy prowadzacy;

	private RealizacjaPrzedmiotu realizacjaPrzedmiotu;
	
	public List<Prowadzacy> getListaProwadzacychDlaRealizacji(String nazwaPrzedmiotu){
		List<PrzypisProwadzacegoDoRealizacji> lista = new ArrayList<PrzypisProwadzacegoDoRealizacji>(listaPrzypisowProwadzacychDoRealizacji.getPrzypisProwadzacegoDoRealizacji());
		
		List<Prowadzacy> listaDlaRealizacji = new ArrayList<Prowadzacy>();
				
		for(int i=0; i<lista.size(); ++i) {
			if(lista.get(i).getRealizacjaPrzedmiotu().getPrzedmiot().getNazwa().equals(nazwaPrzedmiotu))
				listaDlaRealizacji.add(lista.get(i).getProwadzacy());
		}
		
		return listaDlaRealizacji;
	}
	
	public void usuwanieProwadzacegoZRealizacji() {
		pracownikAdministracyjny.usunProwadzacegoZRealizacji(this.prowadzacy, this.realizacjaPrzedmiotu);
	}

	public void setProwadzacy(Prowadzacy prowadzacy)
	{
		this.prowadzacy = prowadzacy;
	}

	public void setRealizacjaPrzedmiotu(RealizacjaPrzedmiotu realizacjaPrzedmiotu)
	{
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}
	
	public void update() {
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			
			ResultSet RsPrzypis = connect.connectionMakeRead("SELECT Rpr.id_realizacji, nazwa, kod_przedmiotu, numer_semestru, P.id_pracownika, imie, nazwisko "
				+	"FROM Przypisy_prow_do_real PR "
				+	"JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika "
				+	"JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika "
				+	"JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji "
				+	"JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu");
			
			while (RsPrzypis.next()) {
				Prowadzacy prowadzacy = new Prowadzacy(RsPrzypis.getInt(5), RsPrzypis.getString(6), RsPrzypis.getString(7));
				Przedmiot przedmiot = new Przedmiot(RsPrzypis.getString(2),  RsPrzypis.getString(3));
				RealizacjaPrzedmiotu realizacjaPrzedmiotu = new RealizacjaPrzedmiotu(RsPrzypis.getInt(1), przedmiot , RsPrzypis.getString(4));
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

}
