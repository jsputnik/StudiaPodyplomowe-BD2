import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyBadDateFrame extends JPanel
{
    /**
     * Create the panel.
     */
    public ApplyBadDateFrame(JPanel panel)
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);


        JLabel majors = new JLabel("Brak możliwości aplikowania na kierunek");
        majors.setBounds(150, 150, 350, 47);
        majors.setFont(new Font("Calibri", Font.BOLD, 20));
        add(majors);

        JButton next = new JButton("Ok");
        next.setBounds(250, 200, 150, 47);
        next.setFont(new Font("Calibri", Font.BOLD, 17));
        add(next);


        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "start");
            }
        });

    }
}
