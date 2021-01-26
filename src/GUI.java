import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GUI extends JFrame
{
    private JPanel contentPane;
    private WyborUzytkownika wyborUzytkownika;
    private LoginKandydat loginKandydat;
    private LoginStudent loginStudent;
    private LoginPracownik loginPracownik;
    private LoginFrame loginFrame;
    private ApplyStartFrame startFrame;
    private MajorsFrame majorsFrame;
    //private MajorsInfoFrame majorsInfoFrame;
    private ApplyOkFrame applyOkFrame;
    private ApplyBadDateFrame applyBadDateFrame;
    private LecturerStartFrame lecturerStartFrame;
    private LecturerSubjectsListFrame lecturerSubjectsListFrame;
    private LecturersListFrame lecturersListFrame;
    private LecturerChosenFrame lecturerChosenFrame;
    private LecturerUnavailableFrame lecturerUnavailableFrame;
    private UsuniecieProwadzacegoListaPrzedmiotowOkno usuniecieProwadzacegoListaPrzedmiotow;
    //private final UsuniecieProwadzacegoListaProwadzacychOkno usuniecieProwadzacegoListaProwadzacych;
    private ProwadzacyUsunietyOkno prowadzacyUsunietyOkno;
    private NieMaProwadzacychPrzypisanychDoRealizacji nieMaProwadzacychPrzypisanychDoRealizacji;
    
    
    private PrzypisanieProwadzacychDoRealizacji przypisanieProwadzacychDoRealizacji;
    private UsuwanieProwadzacychZRealizacji usuwanieProwadzacychZRealizacji;
    private AplikowanieNaKierunek aplikowanieNaKierunek;

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
        //majorsInfoFrame = new MajorsInfoFrame(contentPane, aplikowanieNaKierunek);
        applyOkFrame = new ApplyOkFrame(contentPane);
        applyBadDateFrame = new ApplyBadDateFrame(contentPane);

        lecturerStartFrame = new LecturerStartFrame(contentPane);
        lecturerSubjectsListFrame = new LecturerSubjectsListFrame(contentPane, przypisanieProwadzacychDoRealizacji);
        lecturersListFrame = new LecturersListFrame(contentPane, przypisanieProwadzacychDoRealizacji, usuwanieProwadzacychZRealizacji);
        lecturerChosenFrame = new LecturerChosenFrame(contentPane);
        lecturerUnavailableFrame = new LecturerUnavailableFrame(contentPane);
        
        //usuniecieProwadzacegoListaProwadzacych = new UsuniecieProwadzacegoListaProwadzacychOkno(contentPane, usuwanieProwadzacychZRealizacji);
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
        //contentPane.add(majorsInfoFrame, "majorsInfo");
        contentPane.add(applyOkFrame, "applyOk");
        contentPane.add(applyBadDateFrame, "applyBad");
        contentPane.add(lecturerStartFrame, "lecturerStart");
        contentPane.add(lecturerSubjectsListFrame, "lecturerSubjects");
        contentPane.add(lecturersListFrame, "lecturersList");
        contentPane.add(lecturerChosenFrame, "lecturerChosen");
        contentPane.add(lecturerUnavailableFrame, "lecturerUnavailable");
        contentPane.add(usuniecieProwadzacegoListaPrzedmiotow, "usunieciePrzedmioty");
        //contentPane.add(usuniecieProwadzacegoListaProwadzacych, "usuniecieProwadzacy");
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
