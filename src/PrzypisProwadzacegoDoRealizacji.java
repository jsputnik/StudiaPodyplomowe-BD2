
import java.util.Set;

public class PrzypisProwadzacegoDoRealizacji {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Object dataDodania;

	public Object getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Object dataDodania) {
		this.dataDodania = dataDodania;
	}

	private Set<ListaPrzypisowProwadzacychDoRealizacji> listaPrzypisowProwadzacychDoRealizacji;

	public Set<ListaPrzypisowProwadzacychDoRealizacji> getListaPrzypisowProwadzacychDoRealizacji() {
		return listaPrzypisowProwadzacychDoRealizacji;
	}

	public void setListaPrzypisowProwadzacychDoRealizacji(
			Set<ListaPrzypisowProwadzacychDoRealizacji> listaPrzypisowProwadzacychDoRealizacji) {
		this.listaPrzypisowProwadzacychDoRealizacji = listaPrzypisowProwadzacychDoRealizacji;
	}

	private RealizacjaPrzedmiotu realizacjaPrzedmiotu;

	public RealizacjaPrzedmiotu getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(RealizacjaPrzedmiotu realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}

	private Prowadzacy prowadzacy;

	public Prowadzacy getProwadzacy() {
		return prowadzacy;
	}

	public void setProwadzacy(Prowadzacy prowadzacy) {
		this.prowadzacy = prowadzacy;
	}
}