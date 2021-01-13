
import java.util.Set;

public class PrzypisPrzedmiotuDoKierunku {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object dataDodania;

	public Object getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Object dataDodania) {
		this.dataDodania = dataDodania;
	}

	private Set<ListaPrzypisowPrzedmiotowDoKierunkow> listaPrzypisowPrzedmiotowDoKierunkow;

	public Set<ListaPrzypisowPrzedmiotowDoKierunkow> getListaPrzypisowPrzedmiotowDoKierunkow() {
		return listaPrzypisowPrzedmiotowDoKierunkow;
	}

	public void setListaPrzypisowPrzedmiotowDoKierunkow(
			Set<ListaPrzypisowPrzedmiotowDoKierunkow> listaPrzypisowPrzedmiotowDoKierunkow) {
		this.listaPrzypisowPrzedmiotowDoKierunkow = listaPrzypisowPrzedmiotowDoKierunkow;
	}

	private Kierunek kierunek;

	public Kierunek getKierunek() {
		return kierunek;
	}

	public void setKierunek(Kierunek kierunek) {
		this.kierunek = kierunek;
	}

	private Przedmiot przedmiot;

	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}
}