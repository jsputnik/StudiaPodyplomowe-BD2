import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    private final JPanel contentPane;
    private final LoginFrame loginFrame;
    private final ApplyStartFrame startFrame;
    private final MajorsFrame majorsFrame;
    private final MajorsInfoFrame majorsInfoFrame;
    private final ApplyOkFrame applyOkFrame;
    private final ApplyBadDateFrame applyBadDateFrame;
    private final LecturerStartFrame lecturerStartFrame;
    private final LecturerSubjectsListFrame lecturerSubjectsListFrame;
    private final LecturersListFrame lecturersListFrame;
    private final LecturerChosenFrame lecturerChosenFrame;
    private final LecturerUnavailableFrame lecturerUnavailableFrame;

    public GUI()
    {
        contentPane = new JPanel();
        loginFrame = new LoginFrame(contentPane);
        startFrame = new ApplyStartFrame(contentPane);
        majorsFrame = new MajorsFrame(contentPane);
        majorsInfoFrame = new MajorsInfoFrame(contentPane);
        applyOkFrame = new ApplyOkFrame(contentPane);
        applyBadDateFrame = new ApplyBadDateFrame(contentPane);

        lecturerStartFrame = new LecturerStartFrame(contentPane);
        lecturerSubjectsListFrame = new LecturerSubjectsListFrame(contentPane);
        lecturersListFrame = new LecturersListFrame(contentPane);
        lecturerChosenFrame = new LecturerChosenFrame(contentPane);
        lecturerUnavailableFrame = new LecturerUnavailableFrame(contentPane);
    }

    public void displayGUI()
    {
        add(contentPane);
        contentPane.setLayout(new CardLayout());
        contentPane.add(loginFrame, "Login");
        contentPane.add(startFrame, "start");
        contentPane.add(majorsFrame, "majors");
        contentPane.add(majorsInfoFrame, "majorsInfo");
        contentPane.add(applyOkFrame, "applyOk");
        contentPane.add(applyBadDateFrame, "applyBad");
        contentPane.add(lecturerStartFrame, "lecturerStart");
        contentPane.add(lecturerSubjectsListFrame, "lecturerSubjects");
        contentPane.add(lecturersListFrame, "lecturersList");
        contentPane.add(lecturerChosenFrame, "lecturerChosen");
        contentPane.add(lecturerUnavailableFrame, "lecturerUnavailable");


        setContentPane(contentPane);
        setTitle("System aplikacji");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        this.pack();
    }
}
