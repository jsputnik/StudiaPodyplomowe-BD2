import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class PracownikWprowadzDaneOkno extends JPanel
{
	
		int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	    JLabel l = new JLabel("", JLabel.CENTER);
	    String day = "";
	    JDialog d;
	    JButton[] button = new JButton[49];
    
	 	public PracownikWprowadzDaneOkno(JPanel panel, AplikowanieNaKierunek aplikowanie) throws SQLException
	    {
	        //setBackground(new Color(176, 224, 230));
	        setPreferredSize(new Dimension(640, 360));
	        setLayout(null);
	        
	        int num = aplikowanie.getKierunek().getLimitMiejsc();


	        JLabel majors = new JLabel("Wybrany kierunek: " + aplikowanie.getKierunek().getNazwa());
	        majors.setBounds(200, 30, 400, 40);
	        majors.setFont(new Font("Calibri", Font.BOLD, 20));
	        add(majors);

	        JButton next = new JButton("Zatwierdź");
	        next.setBounds(250, 270, 150, 47);
	        next.setFont(new Font("Calibri", Font.BOLD, 17));
	        add(next);
	        
	        JLabel number_label = new JLabel("Maksymalna liczba osób:");
	        number_label.setBounds(80, 90, 190, 40);
	        number_label.setFont(new Font("Calibri", Font.BOLD, 17));
	        add(number_label);
	        
	        JTextField number = new JTextField();
	        number.setBounds(280, 93, 100, 30);
	        add(number);
	        
	        JLabel date_start_label = new JLabel("Data rozpoczęcia:");
	        date_start_label.setBounds(130, 125, 190, 30);
	        date_start_label.setFont(new Font("Calibri", Font.BOLD, 17));
	        add(date_start_label);
	        
	        JLabel format_start_label = new JLabel("(DD/MM/YYYY)");
	        format_start_label.setBounds(160, 145, 190, 30);
	        format_start_label.setFont(new Font("Calibri", Font.BOLD, 13));
	        add(format_start_label);
	        
	        JTextField date_start = new JTextField();
	        date_start.setBounds(280, 140, 100, 30);
	        add(date_start);
	        
	        JLabel date_end_label = new JLabel("Data zakończenia:");
	        date_end_label.setBounds(130, 175, 190, 30);
	        date_end_label.setFont(new Font("Calibri", Font.BOLD, 17));
	        add(date_end_label);
	        
	        JLabel format_end_label = new JLabel("(DD/MM/YYYY)");
	        format_end_label.setBounds(160, 195, 190, 30);
	        format_end_label.setFont(new Font("Calibri", Font.BOLD, 13));
	        add(format_end_label);
	        
	        JTextField date_end = new JTextField();
	        date_end.setBounds(280, 190, 100, 30);
	        add(date_end);
	        
			
	        
	        JButton logout = new JButton("Wyloguj");
	        logout.setBounds(565, 0, 75, 30);
	        logout.setFont(new Font("Calibri", Font.BOLD, 12));
	        add(logout);

	        next.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) panel.getLayout();
	                cardLayout.show(panel, "pracownikOk");
	                //cardLayout.show(panel, "pracownikBad");
	                //aplikowanie.przypiszKandydataDoKierunku();
	                String start = date_start.getText();
	                String end = date_end.getText();
	                int limit = Integer.parseInt(number.getText());
	                try
					{
						Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(start);
						Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(end); 
						
					} catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	            }
	        });
	        
	        logout.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) panel.getLayout();
	                    cardLayout.show(panel, "wybor");
	              
	            }

	        });
	        
	    

	    }
	
}
