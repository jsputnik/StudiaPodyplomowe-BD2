
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PracownikAdministracyjny extends Pracownik {
	
	private Set<ListaPracownikowAdministracyjnych> listaPracownikowAdministracyjnych;

	public Set<ListaPracownikowAdministracyjnych> getListaPracownikowAdministracyjnych() {
		return listaPracownikowAdministracyjnych;
	}

	public void setListaPracownikowAdministracyjnych(
			Set<ListaPracownikowAdministracyjnych> listaPracownikowAdministracyjnych) {
		this.listaPracownikowAdministracyjnych = listaPracownikowAdministracyjnych;
	}

	public void planujAplikowanie() {
	}

	public void przyjmijRejestracje() {
	}

	public void dodajKierDoReal() {
	}

	public void znajdzKandydata() {
	}

	public void modyfikujKandydata() {
	}

	public void usunKandydata() {
	}

	public void modyfikujStudenta() {
	}

	public void usunStudenta() {
	}

	public void modyfikujPracownika() {
	}

	public void dodajPracownika() {
	}

	public void usunPracownika() {
	}

	public void modyfikujPrzedmiot() {
	}

	public void dodajPrzedmiot() {
	}

	public void usunPrzedmiot() {
	}

	public void modyfikujKierunek() {
	}

	public void dodajKierunek() {
	}

	public void usunKierunek() {
	}

	public void dodajRealizacje() {
	}

	public void usunRealizacje() {
	}
	
	public void przypiszProwadzacegoDoRealizacji(Prowadzacy prowadzacy, RealizacjaPrzedmiotu realizacja, 
							ListaPrzypisowProwadzacychDoRealizacji listaPrzypisowProwadzacychDoRealizacji) {
		PrzypisProwadzacegoDoRealizacji przypisProwadzacegoDoRealizacji = new PrzypisProwadzacegoDoRealizacji();
		
		przypisProwadzacegoDoRealizacji.setProwadzacy(prowadzacy);
		przypisProwadzacegoDoRealizacji.setRealizacjaPrzedmiotu(realizacja);
		
		Connections connect = new Connections();
		
		int idPracownika = przypisProwadzacegoDoRealizacji.getProwadzacy().getId();
		int idRealizacji = przypisProwadzacegoDoRealizacji.getRealizacjaPrzedmiotu().getId();
		System.out.println("DODANIE");
		
		try{
			connect.setConnection();
			connect.connectionMakeUpdate("INSERT INTO Przypisy_prow_do_real "
				    + "VALUES (przypis_pr_seq.nextval, "+ idPracownika + ", " + idRealizacji + ", SYSDATE, '0')");
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
			
			listaPrzypisowProwadzacychDoRealizacji.dodajPrzypis(przypisProwadzacegoDoRealizacji);
		
	}
	
	public void przypiszKandydataDoKierunku(int idKandydata, ListaKierunkow listaKierunkow, String nazwaKierunku) {
		List<Kierunek> lista = new ArrayList<Kierunek>(listaKierunkow.getKierunek());
		
		
		int numerKierunku = 0;
		Boolean flaga = false;
		
		for(int i=0; i<lista.size(); ++i) {
			if(lista.get(i).getNazwa().equals(nazwaKierunku)) {
				flaga = true;
				numerKierunku = i;
				}
		}
		
		Connections connect = new Connections();
		
		int idKierunku = 0;
		
		if(flaga) idKierunku = lista.get(numerKierunku).getId();
		
		try{
			connect.setConnection();

			connect.connectionMakeUpdate("INSERT INTO Aplikacje "
				   + "VALUES (aplikacja_seq.nextval, " + idKandydata + ", " + idKierunku + ", '21L', SYSDATE, ADD_MONTHS(SYSDATE,6))");

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