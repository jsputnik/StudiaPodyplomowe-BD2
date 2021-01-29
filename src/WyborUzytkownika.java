import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyborUzytkownika extends JPanel
{

    public WyborUzytkownika(JPanel panel)
    {

        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        JButton btnNewButton_1 = new JButton("Pracownik");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginPracownik");
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(131, 192, 130, 62);
        add(btnNewButton_1);
        

        JButton btnNewButton_2 = new JButton("Student");
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginStudent");
            }
        });
        btnNewButton_2.setBounds(378, 119, 130, 62);
        add(btnNewButton_2);
        

        JButton btnNewButton = new JButton("Kandydat");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginKandydat");
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(378, 192, 130, 62);
        add(btnNewButton);
        
        
        JButton btnNewButton_3 = new JButton("Prowadzacy");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "loginProwadzacy");
            }
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_3.setBounds(131, 119, 130, 62);
        add(btnNewButton_3);

        JLabel lblNewLabel = new JLabel("Wybór użytkownika");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(226, 23, 187, 66);
        add(lblNewLabel);
    }
}
