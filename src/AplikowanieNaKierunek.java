import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AplikowanieNaKierunek {
	 
	AplikowanieNaKierunek(){
		 listaKandydatow = new ListaKandydatow();
		 
		 // dodanie z bazy
		 
		 
	 }
	
	private ListaKandydatow listaKandydatow;
	
	public List<Kandydat> getListaKandydatow(){
		Set<Kandydat> set = new HashSet<Kandydat>();
		set = listaKandydatow.getKandydat();
		
		List<Kandydat> lista = new ArrayList<Kandydat>(set);
		
		return lista;
	}
}
