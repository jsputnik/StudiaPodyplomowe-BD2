import java.sql.SQLException;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
    	PrzypadkiUzycia przypadki = new PrzypadkiUzycia();
    	przypadki.PrzypisanieProwadzacychDoRealizacji();
    	
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					new GUI().displayGUI();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

    }
}
