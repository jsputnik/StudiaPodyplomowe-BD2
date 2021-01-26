
import java.util.Set;

public class ListaAplikacji {
	
	private Set<Aplikacja> aplikacja;

	public Set<Aplikacja> getAplikacja() {
		return aplikacja;
	}

	public void setAplikacja(Set<Aplikacja> aplikacja) {
		this.aplikacja = aplikacja;
	}

	public void znajdzAplikacje() {
	}

	public void dodajAplikacje(Aplikacja aplikacja) {
		this.aplikacja.add(aplikacja);
	}

	public void usunAplikacje() {
	}
}