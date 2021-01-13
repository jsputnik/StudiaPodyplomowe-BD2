
import java.util.Set;

public class Aplikacja {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object semestr;

	public Object getSemestr() {
		return semestr;
	}

	public void setSemestr(Object semestr) {
		this.semestr = semestr;
	}

	private Object dataDodania;

	public Object getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Object dataDodania) {
		this.dataDodania = dataDodania;
	}

	private Object dataWygasniecia;

	public Object getDataWygasniecia() {
		return dataWygasniecia;
	}

	public void setDataWygasniecia(Object dataWygasniecia) {
		this.dataWygasniecia = dataWygasniecia;
	}

	private Kierunek kierunek;

	public Kierunek getKierunek() {
		return kierunek;
	}

	public void setKierunek(Kierunek kierunek) {
		this.kierunek = kierunek;
	}

	private Kandydat kandydat;

	public Kandydat getKandydat() {
		return kandydat;
	}

	public void setKandydat(Kandydat kandydat) {
		this.kandydat = kandydat;
	}

	private Set<ListaAplikacji> listaAplikacji;

	public Set<ListaAplikacji> getListaAplikacji() {
		return listaAplikacji;
	}

	public void setListaAplikacji(Set<ListaAplikacji> listaAplikacji) {
		this.listaAplikacji = listaAplikacji;
	}
}