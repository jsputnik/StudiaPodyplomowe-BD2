import javax.swing.*;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MajorsFrame extends JPanel
{
        /**
     * Create the panel.
     */
    public MajorsFrame(JPanel panel)
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);
        
        AplikowanieNaKierunek aplikowanie = new AplikowanieNaKierunek();
        
        List<Kierunek> kierunki = aplikowanie.getlistaKierunkow();
        int count = kierunki.size();
        String[] listaKierunkow = new String[count];

        for (int i =0; i < count; ++i)
        {
            listaKierunkow[i] = kierunki.get(i).getNazwa();
        }

        JList<String> list = new JList<String>(listaKierunkow);
        list.setFont(new Font("Calibri", Font.BOLD, 17));
        //list.setBackground(new Color(176, 224, 230));
        list.setBounds(220, 80, 200, 200);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);


        JLabel majors = new JLabel("Kierunki");
        majors.setBounds(282, 25, 75, 47);
        majors.setFont(new Font("Calibri", Font.BOLD, 20));
        add(majors);

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
                
                if(aplikowanie.czyAplikowanieWOkresie(list.getSelectedValue())) 
                {
                	cardLayout.show(panel, "majorsInfo");
                }
                else 
                {
                	cardLayout.show(panel,"applyBad");
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
