import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AplikowanieNaKierunek {
	 
	AplikowanieNaKierunek(){
		this.listaKierunkow = new ListaKierunkow();
		
		pracownikAdministracyjny = new PracownikAdministracyjny();
		 
		 Connections connect = new Connections();
			
			try{
				connect.setConnection();
				ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji "
						+ "FROM Kierunki");
				
				while (RsKierunki.next()) {
					Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4));
					this.listaKierunkow.dodajKierunek(kierunek);
				}
				
				
				
				connect.closeConnection();
			}
			catch (SQLException eSQL) 
			{
				System.out.println("Blad przetwarzania SQL");
			}
			catch (IOException eIO) // B��d obs�ugi pliku zawieraj�cego parametry po��czenia
			{
				System.out.println("Nie mo�na otworzy� pliku z parametrami po��czenia");
			}
		 
		 
	 }
	
	private ListaKierunkow listaKierunkow;
	
	private PracownikAdministracyjny pracownikAdministracyjny;
	
	private Kierunek kierunek;
	
	public List<Kierunek> getlistaKierunkow(){
		Set<Kierunek> set = new HashSet<Kierunek>();
		set = listaKierunkow.getKierunek();
		
		List<Kierunek> lista = new ArrayList<Kierunek>(set);
		
		return lista;
	}
	
	public Boolean czyAplikowanieWOkresie(String nazwaKierunku) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		List<Kierunek> lista = getlistaKierunkow();
		int keyId = 0;
		
		for(int i=0; i<lista.size(); ++i ) {
			if(lista.get(i).getNazwa() == nazwaKierunku) {
				keyId = i;
			}
		}
		
		Date dataRozpoczecia = lista.get(keyId).getDataRozpoczeciaRekrutacji();
		Date dataZakonczenia = lista.get(keyId).getDataZakonczeniaRekrutacji();
		
		Date dataObecna = new Date();
		//System.out.println(formatter.format(dataObecna));
		if(dataObecna.after(dataRozpoczecia) && dataObecna.before(dataZakonczenia) ) return true;
		else return false;
	}
	
	public void przypiszKandydataDoKierunku(int idKandydata, String nazwaKierunku ) {
		pracownikAdministracyjny.przypiszKandydataDoKierunku(idKandydata, listaKierunkow, nazwaKierunku);
	}
	
	
	public void setKierunek(Kierunek kierunek ) {
		this.kierunek = kierunek;
	}
	
	public void update() {
		Connections connect = new Connections();
		
		listaKierunkow.setKierunek(new HashSet<Kierunek>());
		
		try{
			connect.setConnection();
			ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji "
					+ "FROM Kierunki");
			
			while (RsKierunki.next()) {
				Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4));
				this.listaKierunkow.dodajKierunek(kierunek);
			}
			
			
			
			connect.closeConnection();
		}
		catch (SQLException eSQL) 
		{
			System.out.println("Blad przetwarzania SQL");
		}
		catch (IOException eIO) // B��d obs�ugi pliku zawieraj�cego parametry po��czenia
		{
			System.out.println("Nie mo�na otworzy� pliku z parametrami po��czenia");
		}
	 
	}
	
}
