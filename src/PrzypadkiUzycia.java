import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrzypadkiUzycia {
	
	public void PrzypisanieProwadzacychDoRealizacji() throws SQLException {
		// Klasa testowa
		
		PrzypisanieProwadzacychDoRealizacji przypisanie = new PrzypisanieProwadzacychDoRealizacji();
		
		//List<Prowadzacy> listaProwadzacych = new ArrayList<Prowadzacy>(przypisanie.getListaProwadzacych());
		List<RealizacjaPrzedmiotu> listaRealizacji = new ArrayList<RealizacjaPrzedmiotu>(przypisanie.getListaRealizacji());
		
		//System.out.println(listaProwadzacych);
		System.out.println(listaRealizacji);
		
		//AplikowanieNaKierunek aplikowanie = new AplikowanieNaKierunek();
		
		//List<Kierunek> listaKierunkow = new ArrayList<Kierunek>(aplikowanie.getlistaKierunkow());
		
		//System.out.println(listaKierunkow);
		
		//aplikowanie.przypiszKandydataDoKierunku(2, "Informatyka");
		
		UsuwanieProwadzacychZRealizacji usuwanie = new UsuwanieProwadzacychZRealizacji();
		
		List<Prowadzacy> listaPrzypisow = new ArrayList<Prowadzacy>(usuwanie.getListaProwadzacychDlaRealizacji("Bazy danych 2"));
		
		System.out.println(listaPrzypisow);
		
		usuwanie.setProwadzacy(listaPrzypisow.get(0));
		usuwanie.setRealizacjaPrzedmiotu(listaRealizacji.get(2));
		
		usuwanie.usuwanieProwadzacegoZRealizacji();
		
		
	}
	
	
}