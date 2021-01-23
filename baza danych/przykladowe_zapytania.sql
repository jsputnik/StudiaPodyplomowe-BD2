
-- zapytania
SELECT imie, nazwisko, nazwa
FROM Aplikacje A
JOIN Kandydaci K ON A.id_kandydata = K.id_kandydata
JOIN Kierunki Ki ON A.id_kierunku = Ki.id_kierunku;

SELECT *
FROM Prowadzacy Pr
JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika;

SELECT Pr.id_pracownika FROM Prowadzacy Pr JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika;

SELECT imie, nazwisko, pesel
FROM Prowadzacy Pr
JOIN Pracownicy P ON Pr.id_pracownika = P.id_pracownika;

SELECT id_realizacji, nazwa, kod_przedmiotu, numer_semestru
FROM Realizacje_przedmiotow RP
JOIN Przedmioty P ON RP.id_przedmiotu = P.id_przedmiotu;

-- Wszystkie przypisy prowadzacych do realizacji
SELECT imie, nazwisko, kod_przedmiotu
FROM Przypisy_prow_do_real PR
JOIN Prowadzacy PT ON PR.id_pracownika = PT.id_pracownika
JOIN Pracownicy P ON PT.id_pracownika = P.id_pracownika
JOIN Realizacje_przedmiotow RPr ON RPr.id_realizacji = PR.id_realizacji
JOIN Przedmioty Pr ON RPr.id_przedmiotu = Pr.id_przedmiotu;

SELECT id_kierunku, nazwa, data_rozpoczecia_rekrutacji, data_zakonczenia_rekrutacji
FROM Kierunki;

SELECT id_kandydata, imie, nazwisko
FROM Kandydaci;