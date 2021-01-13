
import java.util.HashSet;
import java.util.Set;

public class ListaKandydatow {
	
	ListaKandydatow(){
		kandydat = new HashSet<Kandydat>();
	}
	
	private Set<Kandydat> kandydat;

	public Set<Kandydat> getKandydat() {
		return kandydat;
	}

	public void setKandydat(Set<Kandydat> kandydat) {
		this.kandydat = kandydat;
	}

	public void znajdzKandydata() {
	}

	public void dodajKandydata() {
	}

	public void usunKandydata() {
	}
}