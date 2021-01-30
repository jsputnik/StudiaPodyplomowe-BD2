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
    private LoginProwadzacy loginProwadzacy;
    
    private ApplyStartFrame startFrame;
    //private MajorsFrame majorsFrame;
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
    
    private PracownikDostepneOpcjeOkno dostepneOpcjeOkno;
    private PracownikListaOkno pracownikListaOkno;
    //private PracownikWprowadzDaneOkno wprowadzDaneOkno;
    private PracownikNiepoprawneDaneOkno niepoprawneDaneOkno;
    private PracownikOkOkno pracownikOkOkno;
    
    //private RezygnacjaZAplikowaniaInfoOkno rezygnacjaZAplikowaniaInfoOkno;
    //private RezygnacjaZAplikowaniaListaOkno aplikowaniaListaOkno;
    private RezygnacjaOkOkno rezygnacjaOkOkno;
    private ApplyBadDateFrame rezygnacjaBadOkno;
    
    
    private PrzypisanieProwadzacychDoRealizacji przypisanieProwadzacychDoRealizacji;
    private UsuwanieProwadzacychZRealizacji usuwanieProwadzacychZRealizacji;
    private AplikowanieNaKierunek aplikowanieNaKierunek;
    private RezygnacjaZAplikowania rezygnacjaZAplikowania;
    
    private Logowanie login_Kandydat;
    private Logowanie login_Pracownik;
    private Logowanie login_Prowadzacy;
    
    private PlanowanieAplikowania planowanie;

    public GUI() throws SQLException
    {
    	aplikowanieNaKierunek = new AplikowanieNaKierunek();
    	przypisanieProwadzacychDoRealizacji = new PrzypisanieProwadzacychDoRealizacji();
    	usuwanieProwadzacychZRealizacji = new UsuwanieProwadzacychZRealizacji();
    	rezygnacjaZAplikowania = new RezygnacjaZAplikowania();
    	planowanie = new PlanowanieAplikowania();
    	login_Kandydat = new Logowanie();
    	login_Pracownik = new Logowanie();
    	login_Prowadzacy = new Logowanie();
    	
    	
        contentPane = new JPanel();
        
        wyborUzytkownika = new WyborUzytkownika(contentPane);
        loginKandydat = new LoginKandydat(contentPane, login_Kandydat, rezygnacjaZAplikowania);
        loginStudent = new LoginStudent(contentPane);
        loginPracownik = new LoginPracownik(contentPane, login_Pracownik);
        loginProwadzacy = new LoginProwadzacy(contentPane, login_Prowadzacy);
        
        startFrame = new ApplyStartFrame(contentPane, rezygnacjaZAplikowania, aplikowanieNaKierunek, login_Kandydat);
        //majorsFrame = new MajorsFrame(contentPane, aplikowanieNaKierunek, login_Kandydat);
        //majorsInfoFrame = new MajorsInfoFrame(contentPane, aplikowanieNaKierunek);
        applyOkFrame = new ApplyOkFrame(contentPane);
        applyBadDateFrame = new ApplyBadDateFrame(contentPane);

        lecturerStartFrame = new LecturerStartFrame(contentPane);
        lecturerSubjectsListFrame = new LecturerSubjectsListFrame(contentPane, przypisanieProwadzacychDoRealizacji);
        lecturersListFrame = new LecturersListFrame(contentPane, przypisanieProwadzacychDoRealizacji, usuwanieProwadzacychZRealizacji);
        lecturerChosenFrame = new LecturerChosenFrame(contentPane);
        lecturerUnavailableFrame = new LecturerUnavailableFrame(contentPane);
        
        dostepneOpcjeOkno = new PracownikDostepneOpcjeOkno(contentPane);
        pracownikListaOkno = new PracownikListaOkno(contentPane, planowanie);
        //wprowadzDaneOkno = new PracownikWprowadzDaneOkno(contentPane, planowanie);
        niepoprawneDaneOkno = new PracownikNiepoprawneDaneOkno(contentPane);
        pracownikOkOkno = new PracownikOkOkno(contentPane);
        
        //rezygnacjaZAplikowaniaInfoOkno = new RezygnacjaZAplikowaniaInfoOkno(contentPane, rezygnacjaZAplikowania, login_Kandydat);
        //aplikowaniaListaOkno = new RezygnacjaZAplikowaniaListaOkno(contentPane, rezygnacjaZAplikowania, login_Kandydat);
        rezygnacjaOkOkno = new RezygnacjaOkOkno(contentPane);
        rezygnacjaBadOkno = new ApplyBadDateFrame(contentPane);
        
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
        contentPane.add(loginProwadzacy, "loginProwadzacy");
        
        contentPane.add(startFrame, "start");
        //contentPane.add(majorsFrame, "majors");
        //contentPane.add(majorsInfoFrame, "majorsInfo");
        contentPane.add(applyOkFrame, "applyOk");
        contentPane.add(applyBadDateFrame, "applyBad");
        
        contentPane.add(lecturerStartFrame, "lecturerStart");
        contentPane.add(lecturerSubjectsListFrame, "lecturerSubjects");
        contentPane.add(lecturersListFrame, "lecturersList");
        contentPane.add(lecturerChosenFrame, "lecturerChosen");
        contentPane.add(lecturerUnavailableFrame, "lecturerUnavailable");
        
        contentPane.add(dostepneOpcjeOkno, "dostepneOpcje");
        contentPane.add(pracownikListaOkno, "pracownikLista");
        //contentPane.add(wprowadzDaneOkno, "wprowadzDane");
        contentPane.add(niepoprawneDaneOkno, "pracownikNiepoprawne");
        contentPane.add(pracownikOkOkno, "pracownikOk");
        
        //contentPane.add(rezygnacjaZAplikowaniaInfoOkno, "rezygnacjaInfo");
        //contentPane.add(aplikowaniaListaOkno, "rezygnacjaLista");
        contentPane.add(rezygnacjaOkOkno, "rezygnacjaOk");
        contentPane.add(rezygnacjaBadOkno, "rezygnacjaBad");
        
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

//Kandydaci:
//97081531712
//95030699915
//96030919599
//96030695383Prowadzacy:
//70011011427
//71112373441
//73112382744
//74011263563
//
//Pracownicy administracyjni:
//66080268721
