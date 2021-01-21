import java.sql.SQLException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
    	PrzypadkiUzycia przypadki = new PrzypadkiUzycia();
    	przypadki.PrzypisanieProwadzacychDoRealizacji();
    	
    	try {
    		UIManager.setLookAndFeel(new com.jtattoo.plaf.noire.NoireLookAndFeel());

    	}
    	catch(Exception e) {}
    	
    	
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
