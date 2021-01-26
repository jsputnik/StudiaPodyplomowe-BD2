import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ApplyStartFrame extends JPanel
{


    public ApplyStartFrame(JPanel panel)
    {
        //construct components
        JButton apply = new JButton("Aplikowanie");
        JButton resign = new JButton("Rezygnacja z aplikacji");

        //adjust size and set layout
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        apply.setFont(new Font("Calibri", Font.BOLD, 17));
        resign.setFont(new Font("Calibri", Font.BOLD, 17));

        //set component bounds (only needed by Absolute Positioning)
        apply.setBounds(220, 65, 200, 100);
        resign.setBounds(220, 215, 200, 100);
        
        JButton logout = new JButton("Wyloguj");
        logout.setBounds(565, 0, 75, 30);
        logout.setFont(new Font("Calibri", Font.BOLD, 12));
        add(logout);

        apply.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "majors");
            }
        });

        resign.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

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
        add(apply);
        add(resign);
    }
}
