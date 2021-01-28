import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlanowanieAplikowania {
	
	PlanowanieAplikowania(){
		this.listaKierunkow = new ListaKierunkow();
		this.pracownikAdministracyjny = new PracownikAdministracyjny();
		this.kierunek = new Kierunek();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc "
					+ "FROM Kierunki");
			
			while (RsKierunki.next()) {
				Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4), RsKierunki.getInt(5));
				this.listaKierunkow.dodajKierunek(kierunek);
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) 
		{
			System.out.println("Nie mo¿na otworzyæ pliku z parametrami po³¹czenia");
		}
		
	}
	
	private ListaKierunkow listaKierunkow;
	
	private PracownikAdministracyjny pracownikAdministracyjny;
	
	private Kierunek kierunek;
	
	public List<Kierunek> getlistaKierunkow(){
		Set<Kierunek> set = new HashSet<Kierunek>();
		set = listaKierunkow.getKierunek();
		
		List<Kierunek> lista = new ArrayList<Kierunek>(set);
		
		return lista;
	}
	
	public void planujAplikowanie(Date dataRozpoczecia, Date dataZakonczenia, int liczbaMiejsc, int idKierunku) {
		pracownikAdministracyjny.planujAplikowanie(dataRozpoczecia, dataZakonczenia, liczbaMiejsc, idKierunku);
	}
	
	public void update() {
		Connections connect = new Connections();
		
		listaKierunkow.setKierunek(new HashSet<Kierunek>());
		
		try{
			connect.setConnection();
			ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc "
					+ "FROM Kierunki");
			
			while (RsKierunki.next()) {
				Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4), RsKierunki.getInt(5));
				this.listaKierunkow.dodajKierunek(kierunek);
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
	 
	}
	
}
