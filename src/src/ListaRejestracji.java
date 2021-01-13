
import java.util.HashSet;
import java.util.Set;

public class ListaRejestracji {
	
	ListaRejestracji(){
		rejestracja = new HashSet<Rejestracja>();
	}
	
	private Set<Rejestracja> rejestracja;

	public Set<Rejestracja> getRejestracja() {
		return rejestracja;
	}

	public void setRejestracja(Set<Rejestracja> rejestracja) {
		this.rejestracja = rejestracja;
	}

	public void znajdzRejestracje() {
	}

	public void dodajRejestracje(Rejestracja nowaRejestracja) {
		this.rejestracja.add(nowaRejestracja);
		
	}

	public void usunRejestracje() {
	}
}