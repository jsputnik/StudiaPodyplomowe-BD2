
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaPrzypisowProwadzacychDoRealizacji {
	
	ListaPrzypisowProwadzacychDoRealizacji(){
		przypisProwadzacegoDoRealizacji = new HashSet<PrzypisProwadzacegoDoRealizacji>();
	}

	private Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji;

	public Set<PrzypisProwadzacegoDoRealizacji> getPrzypisProwadzacegoDoRealizacji() {
		return przypisProwadzacegoDoRealizacji;
	}

	public void setPrzypisProwadzacegoDoRealizacji(
			Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji) {
		this.przypisProwadzacegoDoRealizacji = przypisProwadzacegoDoRealizacji;
	}

	public Boolean czyZnalezionoPrzypis(PrzypisProwadzacegoDoRealizacji przypis) {
		List<PrzypisProwadzacegoDoRealizacji> lista = new ArrayList<PrzypisProwadzacegoDoRealizacji>(przypisProwadzacegoDoRealizacji);
		
		for(int i=0; i<lista.size(); ++i) {
			if(lista.get(i).getProwadzacy() == przypis.getProwadzacy() &&
				lista.get(i).getRealizacjaPrzedmiotu() == przypis.getRealizacjaPrzedmiotu()) return true;
		}
		return false;
	}
	
	public void znajdzPrzypis() {
	}

	public void dodajPrzypis(PrzypisProwadzacegoDoRealizacji przypis) {
		przypisProwadzacegoDoRealizacji.add(przypis);
	}

	public void usunPrzypis() {
	}
}