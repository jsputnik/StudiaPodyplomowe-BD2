import javax.swing.*;

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

        String[] majorsList = {"Informatyka", "Matematyka", "Fizyka", "Chemia", "Astrofizyka"}; //przykładowe, trzeba wziąć liste z bazy

        JList<String> list = new JList<String>(majorsList);
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
                cardLayout.show(panel, "majorsInfo");
                //list.getSelectedValue(); do pobrania wybranego kierunku
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
