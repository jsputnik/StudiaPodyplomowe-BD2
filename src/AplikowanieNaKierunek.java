import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AplikowanieNaKierunek {
	 
	AplikowanieNaKierunek(){
		 listaKandydatow = new ListaKandydatow();
		 
		 Connections connect = new Connections();
			
			try{
				connect.setConnection();
				ResultSet rs = connect.connectionMakeRead("Select ENAME From EMP");
				
				while (rs.next()) {
					System.out.println(rs.getString(1));
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
	
	private ListaKandydatow listaKandydatow;
	
	public List<Kandydat> getListaKandydatow(){
		Set<Kandydat> set = new HashSet<Kandydat>();
		set = listaKandydatow.getKandydat();
		
		List<Kandydat> lista = new ArrayList<Kandydat>(set);
		
		return lista;
	}
}
