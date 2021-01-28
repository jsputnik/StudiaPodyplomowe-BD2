
import java.util.Set;

public class Kandydat extends Osoba {
	
	Kandydat(){
		
	}
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Object punktyRekrutacyjne;

	public Object getPunktyRekrutacyjne() {
		return punktyRekrutacyjne;
	}

	public void setPunktyRekrutacyjne(Object punktyRekrutacyjne) {
		this.punktyRekrutacyjne = punktyRekrutacyjne;
	}

	private Set<Kierunek> kierunek;

	public Set<Kierunek> getKierunek() {
		return kierunek;
	}

	public void setKierunek(Set<Kierunek> kierunek) {
		this.kierunek = kierunek;
	}

	private Set<Aplikacja> aplikacja;

	public Set<Aplikacja> getAplikacja() {
		return aplikacja;
	}

	public void setAplikacja(Set<Aplikacja> aplikacja) {
		this.aplikacja = aplikacja;
	}

	private Set<ListaKandydatow> listaKandydatow;

	public Set<ListaKandydatow> getListaKandydatow() {
		return listaKandydatow;
	}

	public void setListaKandydatow(Set<ListaKandydatow> listaKandydatow) {
		this.listaKandydatow = listaKandydatow;
	}

	public void aplikuj() {
	}

	public void rezygnuj() {
	}
}