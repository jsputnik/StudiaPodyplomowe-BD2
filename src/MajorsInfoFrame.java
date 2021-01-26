import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MajorsInfoFrame extends JPanel
{
    /**
     * Create the panel.
     */
    public MajorsInfoFrame(JPanel panel, AplikowanieNaKierunek aplikowanie) throws SQLException
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);
        
        int num = aplikowanie.getKierunek().getLimitMiejsc();


        JLabel majors = new JLabel("Informacja o kierunku");
        majors.setBounds(250, 25, 200, 47);
        majors.setFont(new Font("Calibri", Font.BOLD, 20));
        add(majors);

        JButton next = new JButton("Zatwierdź");
        next.setBounds(260, 300, 150, 47);
        next.setFont(new Font("Calibri", Font.BOLD, 17));
        add(next);

        JTextArea info = new JTextArea("Wybrany kierunek: " + aplikowanie.getKierunek().getNazwa() + "\n");
        info.append("Limit miejsc: " + String.valueOf(num));
        info.setBounds(240, 80, 200, 200);
        info.setFont(new Font("Calibri", Font.BOLD, 17));
        info.setEditable(false);
        info.setLineWrap(true);
        add(info);
        
        JButton logout = new JButton("Wyloguj");
        logout.setBounds(565, 0, 75, 30);
        logout.setFont(new Font("Calibri", Font.BOLD, 12));
        add(logout);

        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "applyOk");
                //aplikowanie.przypiszKandydataDoKierunku();
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
