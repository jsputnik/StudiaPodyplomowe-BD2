import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AplikowanieNaKierunek {
	 
	AplikowanieNaKierunek(){
		this.listaKierunkow = new ListaKierunkow();
		 
		 Connections connect = new Connections();
			
			try{
				connect.setConnection();
				ResultSet RsKierunki = connect.connectionMakeRead("Select ENAME From EMP");
				
				while (RsKierunki.next()) {
					System.out.println(RsKierunki.getString(1));
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
	
	public List<Kierunek> getlistaKierunkow(){
		Set<Kierunek> set = new HashSet<Kierunek>();
		set = listaKierunkow.getKierunek();
		
		List<Kierunek> lista = new ArrayList<Kierunek>(set);
		
		return lista;
	}
}
