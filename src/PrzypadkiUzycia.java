import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrzypadkiUzycia {
	
	public void PrzypisanieProwadzacychDoRealizacji() throws SQLException {
		// Klasa testowa
		
		//PrzypisanieProwadzacychDoRealizacji przypisanie = new PrzypisanieProwadzacychDoRealizacji();
		
		//List<Prowadzacy> listaProwadzacych = new ArrayList<Prowadzacy>(przypisanie.getListaProwadzacych());
		//List<RealizacjaPrzedmiotu> listaRealizacji = new ArrayList<RealizacjaPrzedmiotu>(przypisanie.getListaRealizacji());
		
		//System.out.println(listaProwadzacych);
		//System.out.println(listaRealizacji);
		
		//przypisanie.update();
		
		//List<Prowadzacy> listaProwadzacych2 = new ArrayList<Prowadzacy>(przypisanie.getListaProwadzacych());
		//System.out.println(listaProwadzacych2);
		
		//AplikowanieNaKierunek aplikowanie = new AplikowanieNaKierunek();
		
		//List<Kierunek> listaKierunkow = new ArrayList<Kierunek>(aplikowanie.getlistaKierunkow());
		
		//System.out.println(listaKierunkow);
		
		//aplikowanie.przypiszKandydataDoKierunku(2, "Informatyka");
		
		//UsuwanieProwadzacychZRealizacji usuwanie = new UsuwanieProwadzacychZRealizacji();
		
		//List<Prowadzacy> listaPrzypisow = new ArrayList<Prowadzacy>(usuwanie.getListaProwadzacychDlaRealizacji("Bazy danych 2"));
		
		//System.out.println(listaPrzypisow);
		
		//usuwanie.update();

		//List<Prowadzacy> listaPrzypisow2 = new ArrayList<Prowadzacy>(usuwanie.getListaProwadzacychDlaRealizacji("Analiza algorytmow"));
		
		//System.out.println(listaPrzypisow2);	
		
		//usuwanie.setProwadzacy(listaPrzypisow.get(0));
		//usuwanie.setRealizacjaPrzedmiotu(listaRealizacji.get(2));
		
		//usuwanie.usuwanieProwadzacegoZRealizacji();
		
		PlanowanieAplikowania planowanie = new PlanowanieAplikowania();
		
		List<Kierunek> lista = new ArrayList<Kierunek>(planowanie.getlistaKierunkow());
		System.out.println(lista);
		
		Date data = new Date();
		
		planowanie.planujAplikowanie(data, data, 15, 2);

	}
	
	
}
