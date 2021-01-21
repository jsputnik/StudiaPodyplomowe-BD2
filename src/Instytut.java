
import java.util.Set;

public class Instytut {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object nazwa;

	public Object getNazwa() {
		return nazwa;
	}

	public void setNazwa(Object nazwa) {
		this.nazwa = nazwa;
	}

	private Object email;

	public Object getEmail() {
		return email;
	}

	public void setEmail(Object email) {
		this.email = email;
	}

	private Object telefon;

	public Object getTelefon() {
		return telefon;
	}

	public void setTelefon(Object telefon) {
		this.telefon = telefon;
	}

	private Adres adres;

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	private Set<ListaInstytutow> listaInstytutow;

	public Set<ListaInstytutow> getListaInstytutow() {
		return listaInstytutow;
	}

	public void setListaInstytutow(Set<ListaInstytutow> listaInstytutow) {
		this.listaInstytutow = listaInstytutow;
	}

	private Set<Prowadzacy> Property;

	public Set<Prowadzacy> getProperty() {
		return Property;
	}

	public void setProperty(Set<Prowadzacy> Property) {
		this.Property = Property;
	}
}