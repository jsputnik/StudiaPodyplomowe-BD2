import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RezygnacjaZAplikowania {
	
	RezygnacjaZAplikowania(){
		listaAplikacji = new ListaAplikacji();
		
		pracownikAdministracyjny = new PracownikAdministracyjny();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			ResultSet RsAplikacje = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji "
					+ "FROM Kierunki");
			
			while (RsAplikacje.next()) {
				Kierunek kierunek = new Kierunek(RsAplikacje.getInt(1), RsAplikacje.getString(2), RsAplikacje.getDate(3), RsAplikacje.getDate(4));
				Aplikacja aplikacja = new Aplikacja();
				aplikacja.setKierunek(kierunek);
				this.listaAplikacji.dodajAplikacje(aplikacja);
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) // B³¹d obs³ugi pliku zawieraj¹cego parametry po³¹czenia
		{
			System.out.println("Nie mo¿na otworzyæ pliku z parametrami po³¹czenia");
		}
		
	}
	
	private ListaAplikacji listaAplikacji;
	
	private PracownikAdministracyjny pracownikAdministracyjny;
	
	private int idKierunku;
	
	private int idKandydata;
	
	public List<Aplikacja> getListaAplikacjiStudenta(String pesel){
		List<Aplikacja> lista = new ArrayList<Aplikacja>(listaAplikacji.getAplikacja());
		
		List<Aplikacja> listaStudenta = new ArrayList<Aplikacja>();
		
		for(int i=0; i<lista.size(); ++i) {
			if(lista.get(i).getKandydat().getPesel().equals(pesel)) listaStudenta.add(lista.get(i));
		}
		
		return listaStudenta;
	}
	
	public void rezygnujZAplikowania() {
		pracownikAdministracyjny.rezygnujZAplikowania(idKandydata, idKierunku);
	}
	
	public void setIdKierunku(int idKierunku) {
		this.idKierunku = idKierunku;
	}
	
	public void setIdKandydata(int idKandydata) {
		this.idKandydata = idKandydata;
	}
	
	public void update() {
		Connections connect = new Connections();
		
		listaAplikacji.setAplikacja(new HashSet<Aplikacja>());
		
		try{
			connect.setConnection();
			ResultSet RsAplikacje = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji "
					+ "FROM Kierunki");
			
			while (RsAplikacje.next()) {
				Kierunek kierunek = new Kierunek(RsAplikacje.getInt(1), RsAplikacje.getString(2), RsAplikacje.getDate(3), RsAplikacje.getDate(4));
				Aplikacja aplikacja = new Aplikacja();
				aplikacja.setKierunek(kierunek);
				this.listaAplikacji.dodajAplikacje(aplikacja);
			}
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) // B³¹d obs³ugi pliku zawieraj¹cego parametry po³¹czenia
		{
			System.out.println("Nie mo¿na otworzyæ pliku z parametrami po³¹czenia");
		}
		
	}
	
}
