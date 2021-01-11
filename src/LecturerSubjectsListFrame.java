import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LecturerSubjectsListFrame extends JPanel
{
    /**
     * Create the panel.
     */
    public LecturerSubjectsListFrame(JPanel panel)
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        String[] subjectsList = {"Informatyka", "Matematyka", "Fizyka", "Chemia", "Astrofizyka"};//przykładowe, trzeba wziąć listę z bazy

        JList<String> list = new JList<String>(subjectsList);
        list.setFont(new Font("Calibri", Font.BOLD, 17));
        //list.setBackground(new Color(176, 224, 230));
        list.setBounds(220, 80, 200, 200);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);


        JLabel subjects = new JLabel("Lista twoich realizacji przedmiotów");
        subjects.setBounds(170, 25, 300, 47);
        subjects.setFont(new Font("Calibri", Font.BOLD, 20));
        add(subjects);

        JButton next = new JButton("Dalej");
        next.setBounds(282, 300, 75, 47);
        next.setFont(new Font("Calibri", Font.BOLD, 17));
        add(next);

        next.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "lecturersList");
                //tutaj sprawdzamy czy są dostępne prowadzący, jeżeli nie, to
                // cardLayout.show(panel, "lecturerUnavailable");
            }
        });

    }
}
