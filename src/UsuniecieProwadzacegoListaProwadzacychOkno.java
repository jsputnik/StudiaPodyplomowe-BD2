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

public class UsuniecieProwadzacegoListaProwadzacychOkno extends JPanel
{
	public UsuniecieProwadzacegoListaProwadzacychOkno(JPanel panel, UsuwanieProwadzacychZRealizacji usuZRealizacji) throws SQLException
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);
        
        List<Prowadzacy> listaProwadzacych = usuZRealizacji.getListaProwadzacychDlaRealizacji(usuZRealizacji.getRealizacjaPrzedmiotu().getPrzedmiot().getNazwa());

        int count = listaProwadzacych.size();

        String[] lecturersList1 = new String[count];
        for (int i =0; i < count; ++i)
        {
            lecturersList1[i] = listaProwadzacych.get(i).getImie() + " " + listaProwadzacych.get(i).getNazwisko();
        }

        JList<String> list = new JList<String>(lecturersList1);
        list.setFont(new Font("Calibri", Font.BOLD, 17));
        //list.setBackground(new Color(176, 224, 230));
        list.setBounds(220, 80, 200, 200);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);


        JLabel subjects = new JLabel("Dostępni prowadzący");
        subjects.setBounds(170, 25, 300, 47);
        subjects.setFont(new Font("Calibri", Font.BOLD, 20));
        add(subjects);

        JButton next = new JButton("Dalej");
        next.setBounds(282, 300, 75, 47);
        next.setFont(new Font("Calibri", Font.BOLD, 17));
        add(next);
        
        JButton logout = new JButton("Wyloguj");
        logout.setBounds(565, 0, 75, 30);
        logout.setFont(new Font("Calibri", Font.BOLD, 12));
        add(logout);

        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "usuniety");
                for(int i = 0; i < lecturersList1.length; ++i)
                {
                    if (list.getSelectedValue() == lecturersList1[i]) {
                        usuZRealizacji.setProwadzacy(listaProwadzacych.get(i));
                        usuZRealizacji.usuwanieProwadzacegoZRealizacji();
                    }
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
