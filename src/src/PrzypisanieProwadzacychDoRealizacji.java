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
			ResultSet rs = connect.connectionMake("Select ENAME From EMP");
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) // B³¹d obs³ugi pliku zawieraj¹cego parametry po³¹czenia
		{
			System.out.println("Nie mo¿na otworzyæ pliku z parametrami po³¹czenia");
		}
		
		
		//docelowo z bazy danych w petli
		Prowadzacy prowadzacy1 = new Prowadzacy(0,"Jan","Kaminski");
		Prowadzacy prowadzacy2 = new Prowadzacy(1,"Jan","Janowski");
		Prowadzacy prowadzacy3 = new Prowadzacy(2,"Michal","Kaminski");
		Prowadzacy prowadzacy4 = new Prowadzacy(3,"Damian","Wegierski");
		Prowadzacy prowadzacy5 = new Prowadzacy(4,"Iza","Angielska");
		
		listaProwadzacych.dodajProwadzacego(prowadzacy1);
		listaProwadzacych.dodajProwadzacego(prowadzacy2);
		listaProwadzacych.dodajProwadzacego(prowadzacy3);
		listaProwadzacych.dodajProwadzacego(prowadzacy4);
		listaProwadzacych.dodajProwadzacego(prowadzacy5);
		
		//docelowo z bazy danych w petli
		Przedmiot przedmiot1 = new Przedmiot(0,0,"Grafika");
		RealizacjaPrzedmiotu realizacjaPrzedmiotu1 = new RealizacjaPrzedmiotu(przedmiot1);
		Przedmiot przedmiot2 = new Przedmiot(1,1,"Inzynieria Oprogramowania");
		RealizacjaPrzedmiotu realizacjaPrzedmiotu2 = new RealizacjaPrzedmiotu(przedmiot2);
		Przedmiot przedmiot3 = new Przedmiot(2,2,"Bazy Danych");
		RealizacjaPrzedmiotu realizacjaPrzedmiotu3 = new RealizacjaPrzedmiotu(przedmiot3);
		Przedmiot przedmiot4 = new Przedmiot(3,3,"Wstep do Informatyki");
		RealizacjaPrzedmiotu realizacjaPrzedmiotu4 = new RealizacjaPrzedmiotu(przedmiot4);
		Przedmiot przedmiot5 = new Przedmiot(4,4,"Analiza Matematyczna");
		RealizacjaPrzedmiotu realizacjaPrzedmiotu5 = new RealizacjaPrzedmiotu(przedmiot5);
		
		listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu1);
		listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu2);
		listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu3);
		listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu4);
		listaRealizacji.dodajRealizacje(realizacjaPrzedmiotu5);
		
		this.listaProwadzacych = listaProwadzacych;
		this.listaRealizacji = listaRealizacji;
		this.pracownikAdministracyjny = pracownikAdministracyjny;
		this.listaPrzypisowProwadzacychDoRealizacji = listaPrzypisowProwadzacychDoRealizacji;
	}
	
	private ListaProwadzacych listaProwadzacych;
	
	private ListaRealizacji listaRealizacji;
	
	private ListaPrzypisowProwadzacychDoRealizacji listaPrzypisowProwadzacychDoRealizacji;
	
	private PracownikAdministracyjny pracownikAdministracyjny;
	
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
	
	public void przypisanie(Prowadzacy prowadzacy, RealizacjaPrzedmiotu realizacjaPrzedmiotu) {
		pracownikAdministracyjny.przypiszProwadzacegoDoRealizacji(prowadzacy, realizacjaPrzedmiotu, listaPrzypisowProwadzacychDoRealizacji);
	}
	
}
