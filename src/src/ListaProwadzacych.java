
import java.util.Set;
import java.util.HashSet;

public class ListaProwadzacych {
	
	ListaProwadzacych(){
		prowadzacy = new HashSet<Prowadzacy>();
	}

	private Set<Prowadzacy> prowadzacy;

	public Set<Prowadzacy> getProwadzacy() {
		return prowadzacy;
	}

	public void setProwadzacy(Set<Prowadzacy> prowadzacy) {
		this.prowadzacy = prowadzacy;
	}

	public void znajdzProwadzacego() {
	}

	public void dodajProwadzacego(Prowadzacy prowadzacy) {
		this.prowadzacy.add(prowadzacy);
	}

	public void usunProwadzacego() {
	}
}