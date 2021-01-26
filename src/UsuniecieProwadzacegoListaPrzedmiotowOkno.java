import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class UsuniecieProwadzacegoListaPrzedmiotowOkno extends JPanel
{
	 public UsuniecieProwadzacegoListaPrzedmiotowOkno(JPanel panel, UsuwanieProwadzacychZRealizacji usuZRealizacji) throws SQLException
	    {
	        //setBackground(new Color(176, 224, 230));
	        setPreferredSize(new Dimension(640, 360));
	        setLayout(null);
	        
	        
	        
	        PrzypisanieProwadzacychDoRealizacji listaPrzedmiotow = new PrzypisanieProwadzacychDoRealizacji();
	        List<RealizacjaPrzedmiotu> lista = listaPrzedmiotow.getListaRealizacji();
	        int count = lista.size();
	        
	        String[] subjectsList1 = new String[count];
	        for (int i =0; i < count; ++i)
	        {
	            subjectsList1[i] = lista.get(i).getPrzedmiot().getNazwa();
	        }

	        
	        JList<String> list = new JList<String>(subjectsList1);
	        list.setFont(new Font("Calibri", Font.BOLD, 17));
	        //list.setBackground(new Color(176, 224, 230));
	        list.setBounds(170, 80, 300, 200);
	        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        list.setLayoutOrientation(JList.VERTICAL);
	        add(list);


	        JLabel subjects = new JLabel("Lista twoich realizacji przedmiotów");
	        subjects.setBounds(170, 25, 300, 47);
	        subjects.setFont(new Font("Calibri", Font.BOLD, 20));
	        add(subjects);
	        
	        JButton logout = new JButton("Wyloguj");
	        logout.setBounds(565, 0, 75, 30);
	        logout.setFont(new Font("Calibri", Font.BOLD, 12));
	        add(logout);

	        JButton next = new JButton("Dalej");
	        next.setBounds(282, 300, 75, 47);
	        next.setFont(new Font("Calibri", Font.BOLD, 17));
	        add(next);

	        next.addActionListener( new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) panel.getLayout();
	                
	                List<Prowadzacy> listaProwadzacych = usuZRealizacji.getListaProwadzacychDlaRealizacji(list.getSelectedValue());
	            	int num = listaProwadzacych.size();
	                
	                if(num == 0)
	                    cardLayout.show(panel, "nieMaProwadzacych");
	                else
	                    cardLayout.show(panel, "usuniecieProwadzacy");

	                for(int i = 0; i < subjectsList1.length; ++i)
	                {
	                    if (list.getSelectedValue() == subjectsList1[i])
	                        usuZRealizacji.setRealizacjaPrzedmiotu(lista.get(i));
	                }

	                
	            }

	        });
	        
	        logout.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                CardLayout cardLayout = (CardLayout) panel.getLayout();
	                    cardLayout.show(panel, "login");
	              
	            }

	        });

	    }
}
