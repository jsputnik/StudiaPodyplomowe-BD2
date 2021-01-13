
import java.util.Set;

public class Kierunek {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object nazwa;

	public Object getNazwa() {
		return nazwa;
	}

	public void setNazwa(Object nazwa) {
		this.nazwa = nazwa;
	}

	private Object limitMiejsc;

	public Object getLimitMiejsc() {
		return limitMiejsc;
	}

	public void setLimitMiejsc(Object limitMiejsc) {
		this.limitMiejsc = limitMiejsc;
	}

	private Object dataRozpoczeciaRekrutacji;

	public Object getDataRozpoczeciaRekrutacji() {
		return dataRozpoczeciaRekrutacji;
	}

	public void setDataRozpoczeciaRekrutacji(Object dataRozpoczeciaRekrutacji) {
		this.dataRozpoczeciaRekrutacji = dataRozpoczeciaRekrutacji;
	}

	private Object dataZakonczeniaRekrutacji;

	public Object getDataZakonczeniaRekrutacji() {
		return dataZakonczeniaRekrutacji;
	}

	public void setDataZakonczeniaRekrutacji(Object dataZakonczeniaRekrutacji) {
		this.dataZakonczeniaRekrutacji = dataZakonczeniaRekrutacji;
	}

	private Set<Kandydat> kandydat;

	public Set<Kandydat> getKandydat() {
		return kandydat;
	}

	public void setKandydat(Set<Kandydat> kandydat) {
		this.kandydat = kandydat;
	}

	private Set<Aplikacja> aplikacja;

	public Set<Aplikacja> getAplikacja() {
		return aplikacja;
	}

	public void setAplikacja(Set<Aplikacja> aplikacja) {
		this.aplikacja = aplikacja;
	}

	private Set<ListaKierunkow> listaKierunkow;

	public Set<ListaKierunkow> getListaKierunkow() {
		return listaKierunkow;
	}

	public void setListaKierunkow(Set<ListaKierunkow> listaKierunkow) {
		this.listaKierunkow = listaKierunkow;
	}

	private Set<Przedmiot> przedmiot;

	public Set<Przedmiot> getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Set<Przedmiot> przedmiot) {
		this.przedmiot = przedmiot;
	}

	private Set<PrzypisPrzedmiotuDoKierunku> przypisPrzedmiotuDoKierunku;

	public Set<PrzypisPrzedmiotuDoKierunku> getPrzypisPrzedmiotuDoKierunku() {
		return przypisPrzedmiotuDoKierunku;
	}

	public void setPrzypisPrzedmiotuDoKierunku(Set<PrzypisPrzedmiotuDoKierunku> przypisPrzedmiotuDoKierunku) {
		this.przypisPrzedmiotuDoKierunku = przypisPrzedmiotuDoKierunku;
	}

	private Set<Student> student;

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public void dodajKandydata() {
	}
}