import java.util.Date;
import java.util.Set;

public class Kierunek {
	
	Kierunek(int id, String nazwa, Date dataRozpoczeciaRekrutacji, Date dataZakonczeniaRekrutacji, int limitMiejsc){
		this.id = id;
		this.nazwa = nazwa;
		this.dataRozpoczeciaRekrutacji = dataRozpoczeciaRekrutacji;
		this.dataZakonczeniaRekrutacji = dataZakonczeniaRekrutacji;
		this.limitMiejsc = limitMiejsc;
	}
	
	Kierunek(int id, String nazwa, Date dataRozpoczeciaRekrutacji, Date dataZakonczeniaRekrutacji){
		this.id = id;
		this.nazwa = nazwa;
		this.dataRozpoczeciaRekrutacji = dataRozpoczeciaRekrutacji;
		this.dataZakonczeniaRekrutacji = dataZakonczeniaRekrutacji;
	}
	
	
	public Kierunek() {
	}


	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nazwa;

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	private int limitMiejsc;

	public int getLimitMiejsc() {
		return limitMiejsc;
	}

	public void setLimitMiejsc(int limitMiejsc) {
		this.limitMiejsc = limitMiejsc;
	}

	private Date dataRozpoczeciaRekrutacji;

	public Date getDataRozpoczeciaRekrutacji() {
		return dataRozpoczeciaRekrutacji;
	}

	public void setDataRozpoczeciaRekrutacji(Date dataRozpoczeciaRekrutacji) {
		this.dataRozpoczeciaRekrutacji = dataRozpoczeciaRekrutacji;
	}

	private Date dataZakonczeniaRekrutacji;

	public Date getDataZakonczeniaRekrutacji() {
		return dataZakonczeniaRekrutacji;
	}

	public void setDataZakonczeniaRekrutacji(Date dataZakonczeniaRekrutacji) {
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
	
	public String toString() {
		return nazwa;
	}
}