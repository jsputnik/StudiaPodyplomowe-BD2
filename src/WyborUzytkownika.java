import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborUzytkownika extends JPanel
{

    public WyborUzytkownika(JPanel panel)
    {

        setPreferredSize(new Dimension(320, 320));
        setSize(320, 320);
        setLayout(null);

        JButton btnNewButton_1 = new JButton("Pracownik");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginPracownik");
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(40, 152, 112, 53);
        add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Student");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginStudent");
            }
        });
        btnNewButton_2.setBounds(164, 99, 112, 53);
        add(btnNewButton_2);

        JButton btnNewButton = new JButton("Kandydat");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginKandydat");
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(287, 152, 112, 53);
        add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Wybór użytkownika");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(122, 23, 187, 66);
        add(lblNewLabel);
    }
}
