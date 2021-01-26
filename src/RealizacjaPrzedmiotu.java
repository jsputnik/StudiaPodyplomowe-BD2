import java.util.Set;

public class RealizacjaPrzedmiotu {
	
	RealizacjaPrzedmiotu(int id, Przedmiot przedmiot, String semestr){
		this.id = id;
		this.przedmiot = przedmiot;
		this.semestr = semestr;
	}

	public RealizacjaPrzedmiotu() 
	{
		przedmiot = new Przedmiot();
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String semestr;

	public String getSemestr() {
		return semestr;
	}

	public void setSemestr(String semestr) {
		this.semestr = semestr;
	}

	private Przedmiot przedmiot;

	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}

	private Set<ListaRealizacji> listaRealizacji;

	public Set<ListaRealizacji> getListaRealizacji() {
		return listaRealizacji;
	}

	public void setListaRealizacji(Set<ListaRealizacji> listaRealizacji) {
		this.listaRealizacji = listaRealizacji;
	}

	private Set<Student> student;

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	private Set<Rejestracja> rejestracja;

	public Set<Rejestracja> getRejestracja() {
		return rejestracja;
	}

	public void setRejestracja(Set<Rejestracja> rejestracja) {
		this.rejestracja = rejestracja;
	}

	private Set<PrzypisStudentaDoRealizacji> przypisStudentaDoRealizacji;

	public Set<PrzypisStudentaDoRealizacji> getPrzypisStudentaDoRealizacji() {
		return przypisStudentaDoRealizacji;
	}

	public void setPrzypisStudentaDoRealizacji(Set<PrzypisStudentaDoRealizacji> przypisStudentaDoRealizacji) {
		this.przypisStudentaDoRealizacji = przypisStudentaDoRealizacji;
	}

	private Prowadzacy prowadzacy;

	public Prowadzacy getProwadzacy() {
		return prowadzacy;
	}

	public void setProwadzacy(Prowadzacy prowadzacy) {
		this.prowadzacy = prowadzacy;
	}

	private Set<Prowadzacy> prowadzacy2;

	public Set<Prowadzacy> getProwadzacy2() {
		return prowadzacy2;
	}

	public void setProwadzacy2(Set<Prowadzacy> prowadzacy2) {
		this.prowadzacy2 = prowadzacy2;
	}

	private Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji;

	public Set<PrzypisProwadzacegoDoRealizacji> getPrzypisProwadzacegoDoRealizacji() {
		return przypisProwadzacegoDoRealizacji;
	}

	public void setPrzypisProwadzacegoDoRealizacji(
			Set<PrzypisProwadzacegoDoRealizacji> przypisProwadzacegoDoRealizacji) {
		this.przypisProwadzacegoDoRealizacji = przypisProwadzacegoDoRealizacji;
	}
	
	public String toString() {
		return this.przedmiot.getNazwa();
	}
	
}