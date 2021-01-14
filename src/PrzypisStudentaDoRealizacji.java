
import java.util.Set;

public class PrzypisStudentaDoRealizacji {

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

	private Set<ListaPrzypisowStudentowDoRealizacji> listaPrzypisowStudentowDoRealizacji;

	public Set<ListaPrzypisowStudentowDoRealizacji> getListaPrzypisowStudentowDoRealizacji() {
		return listaPrzypisowStudentowDoRealizacji;
	}

	public void setListaPrzypisowStudentowDoRealizacji(
			Set<ListaPrzypisowStudentowDoRealizacji> listaPrzypisowStudentowDoRealizacji) {
		this.listaPrzypisowStudentowDoRealizacji = listaPrzypisowStudentowDoRealizacji;
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
}