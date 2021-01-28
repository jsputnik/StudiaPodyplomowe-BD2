
-- aplikacje
SELECT imie, nazwisko, nazwa
FROM Aplikacje A
JOIN Kandydaci K ON A.id_kandydata = K.id_kandydata
JOIN Kierunki Ki ON A.id_kierunku = Ki.id_kierunku;

-- prowadzacy
SELECT imie, nazwisko, pesel
FROM Prowadzacy Pr
JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika;

-- realizacje
SELECT id_realizacji, nazwa, kod_przedmiotu, numer_semestru
FROM Realizacje_przedmiotow RP
JOIN Przedmioty P ON RP.id_przedmiotu = P.id_przedmiotu;

-- przypisy prowadzacych do realizacji
SELECT imie, nazwisko, kod_przedmiotu
FROM Przypisy_prow_do_real PR
JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika
JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika
JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji
JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu;

-- przypisy prowadzacych do realizacji
SELECT Rpr.id_realizacji, nazwa, kod_przedmiotu, numer_semestru, P.id_pracownika, imie, nazwisko
FROM Przypisy_prow_do_real PR
JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika
JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika
JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji
JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu;

-- kierunki
SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji
FROM Kierunki;

-- kandydaci
SELECT id_kandydata, imie, nazwisko
FROM Kandydaci;

-- USUNIECIE PROWADZACEGO Z REALIZACJI
SELECT Rpr.id_realizacji, nazwa, kod_przedmiotu, numer_semestru, P.id_pracownika, imie, nazwisko
FROM Przypisy_prow_do_real PR
JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika
JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika
JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji
JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu;

DELETE FROM Przypisy_prow_do_real WHERE id_pracownika = 1 AND id_realizacji = 1;

-- Kierownik
INSERT INTO Przypisy_prow_do_real
    VALUES (przypis_pr_seq.nextval, 1, 1, SYSDATE, '1');
-- Kierownik
INSERT INTO Przypisy_prow_do_real
    VALUES (przypis_pr_seq.nextval, 2, 2, SYSDATE, '1');

-- USUNIECIE APLIKACJI
SELECT id_aplikacji,nazwa
FROM Aplikacje A
JOIN Kierunki K ON A.id_kierunku = K.id_kierunku
WHERE id_kandydata = 1;
--tu zamiast 1 wstawic ID

-- lub

SELECT id_aplikacji, nazwa
FROM Aplikacje A
JOIN Kierunki K ON A.id_kierunku = K.id_kierunku
JOIN Kandydaci Kand ON A.id_kandydata = Kand.id_kandydata
WHERE pesel = 97081531712;
--tu zamiast 97081531712 wstawic pesel

-- usuwanie
DELETE FROM Aplikacje WHERE id_aplikacji = 10001;
--zamiast 10001 id aplikacji, ktora chcemy usunac


-- PLANOWANIE APLIKOWANIA
SELECT * FROM Kierunki;
--rownoznaczne z
SELECT id_kierunku, nazwa, limit_miejsc, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji FROM Kierunki;

UPDATE Kierunki
SET limit_miejsc = 10,
    data_rozpoczecia_rekrutacji = TO_DATE('2012-9-5', 'YYYY-MM-DD'),--'20/9/05', --TO_DATE();
    data_zakonczenia_rekrutacji = '20/10/05'
WHERE id_kierunku = 2;

-- format daty: 'YY/MM/DD'
-- np. '20/09/05' to 5 wrzesnia 2020