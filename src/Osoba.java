
public class Osoba {

	private String imie;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	private String nazwisko;

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	private Object pesel;

	public Object getPesel() {
		return pesel;
	}

	public void setPesel(Object pesel) {
		this.pesel = pesel;
	}

	private Object email;

	public Object getEmail() {
		return email;
	}

	public void setEmail(Object email) {
		this.email = email;
	}

	private Object telefon;

	public Object getTelefon() {
		return telefon;
	}

	public void setTelefon(Object telefon) {
		this.telefon = telefon;
	}

	private Adres adres;

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public void znajdzKierunek() {
	}

	public void znajdzInstytut() {
	}

	public void znajdzSwojeDane() {
	}

	public void modyfikujSwojeDane() {
	}
}