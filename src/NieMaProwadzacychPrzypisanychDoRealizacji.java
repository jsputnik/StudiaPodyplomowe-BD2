import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NieMaProwadzacychPrzypisanychDoRealizacji extends JPanel
{
	
	public NieMaProwadzacychPrzypisanychDoRealizacji(JPanel panel)
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);


        JTextArea okMessage = new JTextArea("Nie ma prowadzących przypisanych do realizacji");
        okMessage.setBounds(170, 100, 300, 50);
        okMessage.setFont(new Font("Calibri", Font.BOLD, 20));
        okMessage.setBackground(panel.getBackground());
        okMessage.setEditable(false);
        okMessage.setLineWrap(true);
        add(okMessage);

        JButton next = new JButton("Ok");
        next.setBounds(250, 220, 150, 47);
        next.setFont(new Font("Calibri", Font.BOLD, 17));
        add(next);


        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "lecturerStart");
            }
        });

    }
}
