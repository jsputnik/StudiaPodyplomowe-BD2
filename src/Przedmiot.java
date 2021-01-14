
import java.util.Set;

public class Przedmiot {
	
	Przedmiot(String nazwa, String kod){
		this.kodPrzedmiotu = kod;
		this.nazwa = nazwa;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String kodPrzedmiotu;

	public String getKodPrzedmiotu() {
		return kodPrzedmiotu;
	}

	public void setKodPrzedmiotu(String kodPrzedmiotu) {
		this.kodPrzedmiotu = kodPrzedmiotu;
	}

	private String nazwa;

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	private Set<Kierunek> kierunek;

	public Set<Kierunek> getKierunek() {
		return kierunek;
	}

	public void setKierunek(Set<Kierunek> kierunek) {
		this.kierunek = kierunek;
	}

	private Set<PrzypisPrzedmiotuDoKierunku> przypisPrzedmiotuDoKierunku;

	public Set<PrzypisPrzedmiotuDoKierunku> getPrzypisPrzedmiotuDoKierunku() {
		return przypisPrzedmiotuDoKierunku;
	}

	public void setPrzypisPrzedmiotuDoKierunku(Set<PrzypisPrzedmiotuDoKierunku> przypisPrzedmiotuDoKierunku) {
		this.przypisPrzedmiotuDoKierunku = przypisPrzedmiotuDoKierunku;
	}

	private Set<ListaPrzedmiot�w> listaPrzedmiot�w;

	public Set<ListaPrzedmiot�w> getListaPrzedmiot�w() {
		return listaPrzedmiot�w;
	}

	public void setListaPrzedmiot�w(Set<ListaPrzedmiot�w> listaPrzedmiot�w) {
		this.listaPrzedmiot�w = listaPrzedmiot�w;
	}

	private Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu;

	public Set<RealizacjaPrzedmiotu> getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}
}