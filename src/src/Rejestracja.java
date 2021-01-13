


import java.util.Date;
import java.util.Set;

public class Rejestracja {
	
	public Rejestracja(int id, String semestr, Date dataDodania, Date dataWygasniecia ) 
	{
		this.id = id;
		this.semestr = semestr;
		//this.dataDodania = dataDodania;
		//this.dataWygasniecia = dataWygasniecia;
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

	private Date dataDodania;

	public Date getDataDodania() {
		return dataDodania;
	}

	public void setDataDodania(Date dataDodania) {
		this.dataDodania = dataDodania;
	}

	private Date dataWygasniecia;

	public Date getDataWygasniecia() {
		return dataWygasniecia;
	}

	public void setDataWygasniecia(Date dataWygasniecia) {
		this.dataWygasniecia = dataWygasniecia;
	}

	private Set<ListaRejestracji> listaRejestracji;

	public Set<ListaRejestracji> getListaRejestracji() {
		return listaRejestracji;
	}

	public void setListaRejestracji(Set<ListaRejestracji> listaRejestracji) {
		this.listaRejestracji = listaRejestracji;
	}

	private RealizacjaPrzedmiotu realizacjaPrzedmiotu;

	public RealizacjaPrzedmiotu getRealizacjaPrzedmiotu() {
		return realizacjaPrzedmiotu;
	}

	public void setRealizacjaPrzedmiotu(RealizacjaPrzedmiotu realizacjaPrzedmiotu) {
		this.realizacjaPrzedmiotu = realizacjaPrzedmiotu;
	}

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String toString() {
		return semestr;
	}
}