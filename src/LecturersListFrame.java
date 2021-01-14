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

    public LecturersListFrame(JPanel panel, PrzypisanieProwadzacychDoRealizacji lecturerList) throws SQLException
    {
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        List<Prowadzacy> lecturersList = lecturerList.getListaProwadzacych();
        int count = lecturersList.size();

        String[] lecturersList1 = new String[count];
        for (int i =0; i < count; ++i)
        {
            lecturersList1[i] = lecturersList.get(i).getImie() + " " + lecturersList.get(i).getNazwisko();
        }

        JList<String> list = new JList<String>(lecturersList1);
        list.setFont(new Font("Calibri", Font.BOLD, 17));
        //list.setBackground(new Color(176, 224, 230));
        list.setBounds(220, 80, 200, 200);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        add(list);


        JLabel subjects = new JLabel("Dostêpni prowadz¹cy");
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
                for(int i = 0; i < lecturersList1.length; ++i)
                {
                    if (list.getSelectedValue() == lecturersList1[i]) {
                        lecturerList.setProwadzacy(lecturersList.get(i));
                        lecturerList.przypisanie();
                    }
                }
            }
        });

    }
}
