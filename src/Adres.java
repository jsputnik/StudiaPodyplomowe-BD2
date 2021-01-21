

import java.util.Set;


public class Adres {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object ulica;

	public Object getUlica() {
		return ulica;
	}

	public void setUlica(Object ulica) {
		this.ulica = ulica;
	}

	private Object numerMieszkania;

	public Object getNumerMieszkania() {
		return numerMieszkania;
	}

	public void setNumerMieszkania(Object numerMieszkania) {
		this.numerMieszkania = numerMieszkania;
	}

	private Object kodPocztowy;

	public Object getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(Object kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	private Object miejscowosc;

	public Object getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(Object miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	private Object wojewodztwo;

	public Object getWojewodztwo() {
		return wojewodztwo;
	}

	public void setWojewodztwo(Object wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}

	private Object kraj;

	public Object getKraj() {
		return kraj;
	}

	public void setKraj(Object kraj) {
		this.kraj = kraj;
	}

	private Set<Osoba> osoba;

	public Set<Osoba> getOsoba() {
		return osoba;
	}

	public void setOsoba(Set<Osoba> osoba) {
		this.osoba = osoba;
	}

	private Instytut instytut;

	public Instytut getInstytut() {
		return instytut;
	}

	public void setInstytut(Instytut instytut) {
		this.instytut = instytut;
	}
}