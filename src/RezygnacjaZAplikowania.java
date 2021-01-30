import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RezygnacjaZAplikowania {
	
	RezygnacjaZAplikowania(){
		listaAplikacji = new ListaAplikacji();
		
		pracownikAdministracyjny = new PracownikAdministracyjny();
		
		kierunek = new Kierunek();
		
		listaKierunkow = new ListaKierunkow();
		
		Connections connect = new Connections();
		
		try{
			connect.setConnection();
			ResultSet RsAplikacje = connect.connectionMakeRead("SELECT A.id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc, A.id_kandydata, pesel "
					+ "FROM Aplikacje A "
					+ "JOIN Kandydaci K ON A.id_kandydata = K.id_kandydata "
					+ "JOIN Kierunki Ki ON A.id_kierunku = Ki.id_kierunku");
			ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc "
					+ "FROM Kierunki");
			
			while (RsAplikacje.next()) {
				Kierunek kierunek = new Kierunek(RsAplikacje.getInt(1), RsAplikacje.getString(2), RsAplikacje.getDate(3), RsAplikacje.getDate(4), RsAplikacje.getInt(5));
				Kandydat kandydat = new Kandydat(RsAplikacje.getInt(6), RsAplikacje.getString(7));
				Aplikacja aplikacja = new Aplikacja();
				aplikacja.setKierunek(kierunek);
				aplikacja.setKandydat(kandydat);
				this.listaAplikacji.dodajAplikacje(aplikacja);
				}
			
			while (RsKierunki.next()) {
				Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4), RsKierunki.getInt(5));
				this.listaKierunkow.dodajKierunek(kierunek);
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
	
	private Kierunek kierunek;
	
	private ListaKierunkow listaKierunkow;
	
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
	
	public int getIdKierunku() 
	{
		return this.idKierunku;
	}
	
	public void setKierunek(Kierunek kierunek) 
	{
		this.kierunek = kierunek;
	}
	
	public Kierunek getKierunek() 
	{
		return this.kierunek;
	}
	
	public List<Kierunek> getlistaKierunkow(){
		Set<Kierunek> set = new HashSet<Kierunek>();
		set = listaKierunkow.getKierunek();
		
		List<Kierunek> lista = new ArrayList<Kierunek>(set);
		
		return lista;
	}
	
	
	public Boolean czyRezygnacjaWOkresie(String nazwaKierunku) {
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
	
	public void update() {
		Connections connect = new Connections();
		
		listaAplikacji.setAplikacja(new HashSet<Aplikacja>());
		
		try{
			connect.setConnection();
			ResultSet RsAplikacje = connect.connectionMakeRead("SELECT A.id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc, A.id_kandydata, pesel "
					+ "FROM Aplikacje A "
					+ "JOIN Kandydaci K ON A.id_kandydata = K.id_kandydata "
					+ "JOIN Kierunki Ki ON A.id_kierunku = Ki.id_kierunku");
			ResultSet RsKierunki = connect.connectionMakeRead("SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji, limit_miejsc "
					+ "FROM Kierunki");
			
			while (RsAplikacje.next()) {
				Kierunek kierunek = new Kierunek(RsAplikacje.getInt(1), RsAplikacje.getString(2), RsAplikacje.getDate(3), RsAplikacje.getDate(4), RsAplikacje.getInt(5));
				Kandydat kandydat = new Kandydat(RsAplikacje.getInt(6), RsAplikacje.getString(7));
				Aplikacja aplikacja = new Aplikacja();
				aplikacja.setKierunek(kierunek);
				aplikacja.setKandydat(kandydat);
				this.listaAplikacji.dodajAplikacje(aplikacja);
				}
			
			while (RsKierunki.next()) {
				Kierunek kierunek = new Kierunek(RsKierunki.getInt(1), RsKierunki.getString(2), RsKierunki.getDate(3), RsKierunki.getDate(4), RsKierunki.getInt(5));
				this.listaKierunkow.dodajKierunek(kierunek);
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