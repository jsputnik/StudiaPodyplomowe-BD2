

import java.util.Set;
import java.sql.Date;
import java.util.Scanner;

public class Student extends Osoba {

	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object nrIndeksu;


	public Object getNrIndeksu() {
		return nrIndeksu;
	}

	public void setNrIndeksu(Object nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}

	private Object srednia;

	public Object getSrednia() {
		return srednia;
	}

	public void setSrednia(Object srednia) {
		this.srednia = srednia;
	}

	private HistoriaStudent historiaStudent;

	public HistoriaStudent getHistoriaStudent() {
		return historiaStudent;
	}

	public void setHistoriaStudent(HistoriaStudent historiaStudent) {
		this.historiaStudent = historiaStudent;
	}

	private Set<ListaStudentow> listaStudentow;

	public Set<ListaStudentow> getListaStudentow() {
		return listaStudentow;
	}

	public void setListaStudentow(Set<ListaStudentow> listaStudentow) {
		this.listaStudentow = listaStudentow;
	}

	private Kierunek kierunek;

	public Kierunek getKierunek() {
		return kierunek;
	}

	public void setKierunek(Kierunek kierunek) {
		this.kierunek = kierunek;
	}

	private Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu;

	public Set<RealizacjaPrzedmiotu> getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(Set<RealizacjaPrzedmiotu> realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
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

	public void rejestruj(ListaRejestracji listaRejestracji) {
		Scanner scan = new Scanner(System.in);
		
		int id = 0;
		String semestr = scan.nextLine();
		Date dataDodania = new Date(30);
		Date dataWygasniecia = new Date(20);
		
		
		Rejestracja rejestracja = new Rejestracja(id,semestr,dataDodania,dataWygasniecia);
		
		listaRejestracji.dodajRejestracje(rejestracja);
		
		scan.close();
	}

	public void wyrejestruj() {
	}

	public void rezygnujZeStudiow() {
	}

	public void znajdzPrzedmiot() {
	}

	public void znajdzRealizacje(ListaRealizacji listaRealizacji) {
		listaRealizacji.znajdzRealizacje();
		
	}
}