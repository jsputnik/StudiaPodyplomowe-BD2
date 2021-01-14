

import java.util.Set;
import java.util.HashSet;

public class ListaRealizacji {
	
	ListaRealizacji(){
		realizacjaPrzedmiotu = new HashSet<RealizacjaPrzedmiotu>();
	}
	
	private Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu;

	public Set<RealizacjaPrzedmiotu> getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}

	public void znajdzRealizacje() {
	}

	public void dodajRealizacje(RealizacjaPrzedmiotu realizacja) {
		this.realizacjaPrzedmiotu.add(realizacja);
	}

	public void usunRealizacje() {
	}
}