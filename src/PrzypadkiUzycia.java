import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrzypadkiUzycia {
	
	public void PrzypisanieProwadzacychDoRealizacji() throws SQLException {
		// Klasa testowa
		
		PrzypisanieProwadzacychDoRealizacji przypisanie = new PrzypisanieProwadzacychDoRealizacji();
		
		List<Prowadzacy> listaProwadzacych = new ArrayList<Prowadzacy>(przypisanie.getListaProwadzacych());
		List<RealizacjaPrzedmiotu> listaRealizacji = new ArrayList<RealizacjaPrzedmiotu>(przypisanie.getListaRealizacji());
		
		System.out.println(listaProwadzacych);
		System.out.println(listaRealizacji);
		
		System.out.println(listaProwadzacych.get(2));
		System.out.println(listaRealizacji.get(3));
		
		//przypisanie.przypisanie(listaProwadzacych.get(1), listaRealizacji.get(3));
		//przypisanie.przypisanie(listaProwadzacych.get(1), listaRealizacji.get(3));
		//przypisanie.przypisanie(listaProwadzacych.get(2), listaRealizacji.get(3));
	}
	
	
}
