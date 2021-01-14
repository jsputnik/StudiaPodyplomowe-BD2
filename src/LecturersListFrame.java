import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class LecturersListFrame extends JPanel
{
    /**
     * Create the panel.
     */

    public LecturersListFrame(JPanel panel) throws SQLException
    {
        PrzypisanieProwadzacychDoRealizacji lecturerList = new PrzypisanieProwadzacychDoRealizacji();
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        List<RealizacjaPrzedmiotu> lecturersList = lecturerList.getListaRealizacji();
        int count = lecturersList.size();

        String[] lecturersList1 = new String[count];
        for (int i =0; i < count; ++i)
        {
            lecturersList1[i] = lecturersList.get(i).getPrzedmiot().getNazwa();
        }

        JList<String> list = new JList<String>(lecturersList1);
        list.setFont(new Font("Calibri", Font.BOLD, 17));
        //list.setBackground(new Color(176, 224, 230));
        list.setBounds(220, 80, 200, 200);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);


        JLabel subjects = new JLabel("Dostępne prowadzący");
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
                cardLayout.show(panel, "lecturerChosen");
            }
        });

    }
}
