import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PracownikDostepneOpcjeOkno extends JPanel
{
	 public PracownikDostepneOpcjeOkno(JPanel panel)
	    {
	        //construct components
	        JButton addLecturer = new JButton("Dodanie kierownika do realizacji");
	        JButton deleteLecturer = new JButton("Usunięcie kierownika z realizacji");
	        JButton addSubject = new JButton("Dodanie przedmiotu do kierunku");
	        JButton deleteSubject = new JButton("Usunięcie przedmiotu z kierunku");
	        JButton planning = new JButton("Planowanie aplikowania");



	        //adjust size and set layout
	        setPreferredSize(new Dimension(640, 360));
	        setLayout(null);

	        addLecturer.setFont(new Font("Calibri", Font.BOLD, 17));
	        deleteLecturer.setFont(new Font("Calibri", Font.BOLD, 17));
	        addSubject.setFont(new Font("Calibri", Font.BOLD, 17));
	        deleteSubject.setFont(new Font("Calibri", Font.BOLD, 17));
	        planning.setFont(new Font("Calibri", Font.BOLD, 17));

	        //set component bounds (only needed by Absolute Positioning)
	        addLecturer.setBounds(170, 40, 300, 50);
	        deleteLecturer.setBounds(170, 100, 300, 50);
	        addSubject.setBounds(170, 160, 300, 50);
	        deleteSubject.setBounds(170, 220, 300, 50);
	        planning.setBounds(170, 280, 300, 50);
	        
	        JButton logout = new JButton("Wyloguj");
	        logout.setBounds(565, 0, 75, 30);
	        logout.setFont(new Font("Calibri", Font.BOLD, 12));
	        add(logout);

//	        addLecturer.addActionListener( new ActionListener()
//	        {
//	            public void actionPerformed(ActionEvent e)
//	            {
//	                CardLayout cardLayout = (CardLayout) panel.getLayout();
//	                cardLayout.show(panel, "lecturerSubjects");
//	            }
//	        });
//
//	        deleteLecturer.addActionListener( new ActionListener()
//	        {
//	            public void actionPerformed(ActionEvent e)
//	            {
//	            	CardLayout cardLayout = (CardLayout) panel.getLayout();
//	                cardLayout.show(panel, "usunieciePrzedmioty");
//	            }
//	        });
//	        
//	        addSubject.addActionListener( new ActionListener()
//	        {
//	            public void actionPerformed(ActionEvent e)
//	            {
//	                CardLayout cardLayout = (CardLayout) panel.getLayout();
//	                cardLayout.show(panel, "lecturerSubjects");
//	            }
//	        });
//
//	        deleteSubject.addActionListener( new ActionListener()
//	        {
//	            public void actionPerformed(ActionEvent e)
//	            {
//	            	CardLayout cardLayout = (CardLayout) panel.getLayout();
//	                cardLayout.show(panel, "usunieciePrzedmioty");
//	            }
//	        });
	        
	        planning.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	            	CardLayout cardLayout = (CardLayout) panel.getLayout();
	                cardLayout.show(panel, "pracownikLista");
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
	       

	        //add components
	        add(addLecturer);
	        add(deleteLecturer);
	        add(addSubject);
	        add(deleteSubject);
	        add(planning);
	    }
}
