INSERT INTO Semestry
    VALUES ('20Z');
INSERT INTO Semestry
    VALUES ('21L');

INSERT INTO Przedmioty
    VALUES (1, 'BD2', 'Bazy danych 2');
INSERT INTO Przedmioty
    VALUES (2, 'BSS', 'Bezpieczenstwo systemow i sieci');
INSERT INTO Przedmioty
    VALUES (3, 'PSZT', 'Podstawy sztucznej inteligencji');
INSERT INTO Przedmioty
    VALUES (4, 'AAL', 'Analiza algorytmow');

INSERT INTO Adresy
    VALUES (1, 'Ulica', 1, '00-000', 'Warszawa', 'Mazowieckie', 'Polska');

INSERT INTO Pracownicy
    VALUES (1, 'Prowadzacy', 'Artur', 'Kubiak', 70011011427, 'test', 111222333, 1);
INSERT INTO Pracownicy
    VALUES (2, 'Prowadzacy', 'Ludwik', 'Zalewski', 71112373441, 'test', 111222333, 1);
INSERT INTO Pracownicy
    VALUES (3, 'Prowadzacy', 'Marek', 'Kolodziej', 73112382744, 'test', 111222333, 1);
INSERT INTO Pracownicy
    VALUES (4, 'Prowadzacy', 'Aleksander', 'Kaminski', 74011263563, 'test', 111222333, 1);

INSERT INTO Instytuty
    VALUES (1, 'Instytut Informatyki', 'testi', 333222111, 1);

INSERT INTO Prowadzacy
    VALUES (1, 'Wykladowca', 1);
INSERT INTO Prowadzacy
    VALUES (2, 'Wykladowca', 1);
INSERT INTO Prowadzacy
    VALUES (3, 'Wykladowca', 1);
INSERT INTO Prowadzacy
    VALUES (4, 'Wykladowca', 1);
    

INSERT INTO Realizacje_przedmiotow
    VALUES (1, 1, '20Z', 1);
INSERT INTO Realizacje_przedmiotow
    VALUES (2, 1, '20Z', 2);
INSERT INTO Realizacje_przedmiotow
    VALUES (3, 1, '20Z', 3);
INSERT INTO Realizacje_przedmiotow
    VALUES (4, 1, '20Z', 4);

INSERT INTO Kandydaci (id_kandydata, imie, nazwisko, pesel, id_adresu)
    VALUES (1, 'Edward', 'Marciniak', 97081531712, 1);
INSERT INTO Kandydaci (id_kandydata, imie, nazwisko, pesel, id_adresu)
    VALUES (2, 'Roman', 'Chmielewski', 95030699915, 1);
INSERT INTO Kandydaci (id_kandydata, imie, nazwisko, pesel, id_adresu)
    VALUES (3, 'Daniel', 'Krawczyk', 96030919599, 1);
INSERT INTO Kandydaci (id_kandydata, imie, nazwisko, pesel, id_adresu)
    VALUES (4, 'Anna', 'Szyma�ska', 96030695383, 1);

INSERT INTO Kierunki(id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji)
    VALUES (1, 'Automatyka i robotyka', TO_DATE('20-01-2021','dd-mm-yyyy'), TO_DATE('20-02-2021','dd-mm-yyyy'));
INSERT INTO Kierunki(id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji)
    VALUES (2, 'Elektronika', TO_DATE('01-09-2020','dd-mm-yyyy'), TO_DATE('01-10-2020','dd-mm-yyyy'));
INSERT INTO Kierunki(id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji)
    VALUES (3, 'Informatyka', TO_DATE('20-01-2021','dd-mm-yyyy'), TO_DATE('20-02-2021','dd-mm-yyyy'));
INSERT INTO Kierunki(id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji)
    VALUES (4, 'Telekomunikacja', TO_DATE('20-01-2021','dd-mm-yyyy'), TO_DATE('20-02-2021','dd-mm-yyyy'));



-- Kierownik
INSERT INTO Przypisy_prow_do_real
    VALUES (przypis_pr_seq.nextval, 1, 1, SYSDATE, '1');
-- Prowadzacy
--INSERT INTO Przypisy_prow_do_real
--    VALUES (przypis_pr_seq.nextval, id_pracownika, id_realizacji, SYSDATE, '0');


--INSERT INTO Przypisy_prow_do_real
--    VALUES (1, 4, 4, DATE, czy_kierownik);

--DELETE FROM Przypisy_prow_do_real 
--    WHERE id_pracownika = 1 AND id_realizacji = 3;


INSERT INTO Aplikacje
    VALUES (aplikacja_seq.nextval, 1, 1, '21L', SYSDATE, ADD_MONTHS(SYSDATE, 6));
INSERT INTO Aplikacje
    VALUES (aplikacja_seq.nextval, 2, 2, '21L', SYSDATE, ADD_MONTHS(SYSDATE, 6));