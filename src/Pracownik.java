
import java.util.Set;

public class Pracownik extends Osoba {
	
	public Pracownik() 
	{
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Set<ListaPracownikow> listaPracownikow;

	public Set<ListaPracownikow> getListaPracownikow() {
		return listaPracownikow;
	}

	public void setListaPracownikow(Set<ListaPracownikow> listaPracownikow) {
		this.listaPracownikow = listaPracownikow;
	}
	
	public void znajdzStudenta() {
	}

	public void znajdzPracownika() {
	}

	public void znajdzPrzedmiot() {
	}

	public void znajdzRealizacje() {
	}

	public void modyfikujRealizacje() {
	}
}