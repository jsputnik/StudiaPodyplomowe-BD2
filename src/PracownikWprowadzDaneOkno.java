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
    
	 	public PracownikWprowadzDaneOkno(JPanel panel, PlanowanieAplikowania planowanie) throws SQLException
	    {
	        //setBackground(new Color(176, 224, 230));
	        setPreferredSize(new Dimension(640, 360));
	        setLayout(null);
	        
	        int num = planowanie.getKierunek().getLimitMiejsc();


	        JLabel majors = new JLabel("Wybrany kierunek: " + planowanie.getKierunek().getNazwa());
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
	        
	        JLabel format_start_label = new JLabel("(YYYY/MM/DD)");
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
	        
	        JLabel format_end_label = new JLabel("(YYYY//MM/DD)");
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
	                
	                String start = date_start.getText();
	                String end = date_end.getText();
	                int limit = Integer.parseInt(number.getText());
	                Date date1 = new Date();
	                Date date2 = new Date();
	                try
					{
						date1 = new SimpleDateFormat("yyyy/MM/dd").parse(start);
						date2= new SimpleDateFormat("yyyy/MM/dd").parse(end);
						System.out.println(date1);
						
					} catch (ParseException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                if(date1.before(date2)) {
		                planowanie.planujAplikowanie(date1, date2, limit, planowanie.getKierunek().getId());
		                planowanie.update();
		                cardLayout.show(panel, "pracownikOk");
	                }
	                else {
	                	cardLayout.show(panel, "pracownikNiepoprawne");
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
