import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JPanel
{
    public LoginFrame(JPanel panel)
    {
        //construct components
        JTextField login = new JTextField();
        JLabel login_label = new JLabel("Login");
        JLabel password_label = new JLabel("Hasło");
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
                CardLayout cardLayout = (CardLayout) panel.getLayout();
                cardLayout.show(panel, "lecturerStart");
              //cardLayout.show(panel, "start"); //aplikowanie

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
