import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PracownikOkOkno extends JPanel
{
	public PracownikOkOkno(JPanel panel)
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);


        JLabel majors = new JLabel("Informacja została zaktualizowana");
        majors.setBounds(170, 120, 300, 47);
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
                cardLayout.show(panel, "dostepneOpcje");
            }
        });

    }
}
