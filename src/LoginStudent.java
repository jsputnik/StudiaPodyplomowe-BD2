import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginStudent extends JPanel
{
    public LoginStudent(JPanel panel)
    {
        //construct components
        JTextField login = new JTextField();
        JLabel login_label = new JLabel("Nr indeksu");
        JLabel password_label = new JLabel("Haslo");
        JButton login_button = new JButton("Zaloguj");
        JPasswordField password = new JPasswordField();

        //adjust size and set layout
        setPreferredSize(new Dimension(640, 360));
        setLayout(null);

        login_label.setFont(new Font("Calibri", Font.BOLD, 20));
        password_label.setFont(new Font("Calibri", Font.BOLD, 20));
        login_button.setFont(new Font("Calibri", Font.BOLD, 20));

        //set component bounds (only needed by Absolute Positioning)
        login_label.setBounds(207, 100, 50, 25);
        login.setBounds(282, 100, 150, 30);
        password_label.setBounds(207, 180, 50, 25);
        password.setBounds(282, 180, 150, 30);
        login_button.setBounds(245, 255, 150, 50);

        login_button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                CardLayout cardLayout = (CardLayout) panel.getLayout();
//                cardLayout.show(panel, "start");

            }
        });


        //add components
        add(login_label);
        add(login);
        add(password);
        add(password_label);
        add(login_button);
    }
}