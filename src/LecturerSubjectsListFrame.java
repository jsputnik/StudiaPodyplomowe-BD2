import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class LecturerSubjectsListFrame extends JPanel
{
    /**
     * Create the panel.
     */
    public LecturerSubjectsListFrame(JPanel panel) throws SQLException
    {
        PrzypisanieProwadzacychDoRealizacji lecturerSujectList = new PrzypisanieProwadzacychDoRealizacji();
        //setBackground(new Color(176, 224, 230));
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        List<Prowadzacy> listaProwadzacych = lecturerSujectList.getListaProwadzacych();
        int num = listaProwadzacych.size();
        List<RealizacjaPrzedmiotu> subjectList = lecturerSujectList.getListaRealizacji();
        int count = subjectList.size();

        String[] subjectsList1 = new String[count];
        for (int i =0; i < count; ++i)
        {
            subjectsList1[i] = subjectList.get(i).getPrzedmiot().getNazwa();
        }


        JList<String> list = new JList<String>(subjectsList1);
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

                if(num == 0)
                    cardLayout.show(panel, "lecturerUnavailable");
                else
                    cardLayout.show(panel, "lecturersList");

                for(int i = 0; i < subjectsList1.length; ++i)
                {
                    if (list.getSelectedValue() == subjectsList1[i])
                        lecturerSujectList.setRealizacjaPrzedmiotu(subjectList.get(i));
                }
            }

        });

    }
}
