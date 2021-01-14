
import java.util.HashSet;
import java.util.Set;

public class ListaKierunkow {
	
	ListaKierunkow(){
		kierunek = new HashSet<Kierunek>();
	}
	
	private Set<Kierunek> kierunek;

	public Set<Kierunek> getKierunek() {
		return kierunek;
	}

	public void setKierunek(Set<Kierunek> kierunek) {
		this.kierunek = kierunek;
	}

	public void znajdzKierunek() {
	}

	public void dodajKierunek() {
	}

	public void usunKierunek() {
	}
}