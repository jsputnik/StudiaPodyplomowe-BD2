
import java.util.Set;

public class Prowadzacy extends Pracownik {

	Prowadzacy(int id, String imie, String nazwisko){
		this.setId(id);
		this.setImie(imie);
		this.setNazwisko(nazwisko);
	}
	
	public Prowadzacy() {}

	private Object typProwadzacego;

	public Object getTypProwadzacego() {
		return typProwadzacego;
	}

	public void setTypProwadzacego(Object typProwadzacego) {
		this.typProwadzacego = typProwadzacego;
	}

	private Boolean czyJestKierownikiem;

	public Boolean getCzyJestKierownikiem() {
		return czyJestKierownikiem;
	}

	public void setCzyJestKierownikiem(Boolean czyJestKierownikiem) {
		this.czyJestKierownikiem = czyJestKierownikiem;
	}

	private Instytut instytut;

	public Instytut getInstytut() {
		return instytut;
	}

	public void setInstytut(Instytut instytut) {
		this.instytut = instytut;
	}

	private Set<ListaProwadzacych> listaProwadzacych;

	public Set<ListaProwadzacych> getListaProwadzacych() {
		return listaProwadzacych;
	}

	public void setListaProwadzacych(Set<ListaProwadzacych> listaProwadzacych) {
		this.listaProwadzacych = listaProwadzacych;
	}

	private Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu;

	public Set<RealizacjaPrzedmiotu> getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}

	private Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu2;

	public Set<RealizacjaPrzedmiotu> getRealizacjaPrzedmiotu2() {
		return realizacjaPrzedmiotu2;
	}

	public void setRealizacjaPrzedmiotu2(Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu2) {
		this.realizacjaPrzedmiotu2 = realizacjaPrzedmiotu2;
	}

	private Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji;

	public Set<PrzypisProwadzacegoDoRealizacji> getPrzypisProwadzacegoDoRealizacji() {
		return przypisProwadzacegoDoRealizacji;
	}

	public void setPrzypisProwadzacegoDoRealizacji(
			Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji) {
		this.przypisProwadzacegoDoRealizacji = przypisProwadzacegoDoRealizacji;
	}
	
	public void dodajDoRealizacji() {
	}

	public void usunZRealizacji() {
	}

	public void modyfikujInstytut() {
	}

	public void dodajInstytut() {
	}

	public void usunInstytut() {
	}
	
	public String toString() {
		return this.getImie() + " " + this.getNazwisko();
	}
}