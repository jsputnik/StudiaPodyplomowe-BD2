import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LecturerStartFrame extends JPanel
{


    public LecturerStartFrame(JPanel panel)
    {
        //construct components
        JButton addLecturer = new JButton("Dodanie prowadzącego do realizacji");
        JButton deleteLecturer = new JButton("Usunięcie prowadzącego z realizacji");


        //adjust size and set layout
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        addLecturer.setFont(new Font("Calibri", Font.BOLD, 17));
        deleteLecturer.setFont(new Font("Calibri", Font.BOLD, 17));

        //set component bounds (only needed by Absolute Positioning)
        addLecturer.setBounds(120, 65, 400, 100);
        deleteLecturer.setBounds(120, 215, 400, 100);

        addLecturer.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "lecturerSubjects");
            }
        });

        deleteLecturer.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        //add components
        add(addLecturer);
        add(deleteLecturer);
    }
}

