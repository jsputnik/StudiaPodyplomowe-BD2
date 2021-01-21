
import java.util.Set;

public class HistoriaStudent {
	
	private Object id;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	private Object dataRozpoczecia;

	public Object getDataRozpoczecia() {
		return dataRozpoczecia;
	}

	public void setDataRozpoczecia(Object dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	private Object stan;

	public Object getStan() {
		return stan;
	}

	public void setStan(Object stan) {
		this.stan = stan;
	}

	private Object dataUsunieciaDanychZHistorii;

	public Object getDataUsunieciaDanychZHistorii() {
		return dataUsunieciaDanychZHistorii;
	}

	public void setDataUsunieciaDanychZHistorii(Object dataUsunieciaDanychZHistorii) {
		this.dataUsunieciaDanychZHistorii = dataUsunieciaDanychZHistorii;
	}

	private Set<HistoriaStudentow> historiaStudentow;

	public Set<HistoriaStudentow> getHistoriaStudentów() {
		return historiaStudentow;
	}

	public void setHistoriaStudentow(Set<HistoriaStudentow> historiaStudentow) {
		this.historiaStudentow = historiaStudentow;
	}

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}