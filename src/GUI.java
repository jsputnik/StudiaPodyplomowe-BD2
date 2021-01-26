import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GUI extends JFrame
{
    private final JPanel contentPane;
    private final WyborUzytkownika wyborUzytkownika;
    private final LoginKandydat loginKandydat;
    private final LoginStudent loginStudent;
    private final LoginPracownik loginPracownik;
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
    private final UsuniecieProwadzacegoListaPrzedmiotowOkno usuniecieProwadzacegoListaPrzedmiotow;
    private final UsuniecieProwadzacegoListaProwadzacychOkno usuniecieProwadzacegoListaProwadzacych;
    private final ProwadzacyUsunietyOkno prowadzacyUsunietyOkno;
    private final NieMaProwadzacychPrzypisanychDoRealizacji nieMaProwadzacychPrzypisanychDoRealizacji;
    
    
    private final PrzypisanieProwadzacychDoRealizacji przypisanieProwadzacychDoRealizacji;
    private final UsuwanieProwadzacychZRealizacji usuwanieProwadzacychZRealizacji;
    private final AplikowanieNaKierunek aplikowanieNaKierunek;

    public GUI() throws SQLException
    {
    	aplikowanieNaKierunek = new AplikowanieNaKierunek();
    	przypisanieProwadzacychDoRealizacji = new PrzypisanieProwadzacychDoRealizacji();
    	usuwanieProwadzacychZRealizacji = new UsuwanieProwadzacychZRealizacji();
        contentPane = new JPanel();
        wyborUzytkownika = new WyborUzytkownika(contentPane);
        loginKandydat = new LoginKandydat(contentPane);
        loginStudent = new LoginStudent(contentPane);
        loginPracownik = new LoginPracownik(contentPane);
        loginFrame = new LoginFrame(contentPane);
        startFrame = new ApplyStartFrame(contentPane);
        majorsFrame = new MajorsFrame(contentPane, aplikowanieNaKierunek);
        majorsInfoFrame = new MajorsInfoFrame(contentPane, aplikowanieNaKierunek);
        applyOkFrame = new ApplyOkFrame(contentPane);
        applyBadDateFrame = new ApplyBadDateFrame(contentPane);

        lecturerStartFrame = new LecturerStartFrame(contentPane);
        lecturerSubjectsListFrame = new LecturerSubjectsListFrame(contentPane, przypisanieProwadzacychDoRealizacji);
        lecturersListFrame = new LecturersListFrame(contentPane, przypisanieProwadzacychDoRealizacji);
        lecturerChosenFrame = new LecturerChosenFrame(contentPane);
        lecturerUnavailableFrame = new LecturerUnavailableFrame(contentPane);
        
        usuniecieProwadzacegoListaProwadzacych = new UsuniecieProwadzacegoListaProwadzacychOkno(contentPane, usuwanieProwadzacychZRealizacji);
        usuniecieProwadzacegoListaPrzedmiotow = new UsuniecieProwadzacegoListaPrzedmiotowOkno(contentPane, usuwanieProwadzacychZRealizacji);
        prowadzacyUsunietyOkno = new ProwadzacyUsunietyOkno(contentPane);
        nieMaProwadzacychPrzypisanychDoRealizacji = new NieMaProwadzacychPrzypisanychDoRealizacji(contentPane);
    }

    public void displayGUI()
    {
        add(contentPane);
        contentPane.setLayout(new CardLayout());
        contentPane.add(wyborUzytkownika, "wybor");
        contentPane.add(loginKandydat, "loginKandydat");
        contentPane.add(loginStudent, "loginStudent");
        contentPane.add(loginPracownik, "loginPracownik");
        contentPane.add(loginFrame, "login");
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
        contentPane.add(usuniecieProwadzacegoListaPrzedmiotow, "usunieciePrzedmioty");
        contentPane.add(usuniecieProwadzacegoListaProwadzacych, "usuniecieProwadzacy");
        contentPane.add(prowadzacyUsunietyOkno, "usuniety");
        contentPane.add(nieMaProwadzacychPrzypisanychDoRealizacji,"nieMaProwadzacych");
        
        


        setContentPane(contentPane);
        setTitle("System aplikacji");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        this.pack();
    }
}
