
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
		
		if(!listaPrzypisowProwadzacychDoRealizacji.czyZnalezionoPrzypis(przypisProwadzacegoDoRealizacji)) {
			//dodanie do bazy danych
			
			listaPrzypisowProwadzacychDoRealizacji.dodajPrzypis(przypisProwadzacegoDoRealizacji);
			System.out.println("P!NK");
		}
		// do bazy danych
		
		
	}
}