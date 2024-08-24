package eddyTurpo;

import eddyTurpo.dao.BookDAO;
import eddyTurpo.dao.PrestitoDAO;
import eddyTurpo.dao.UtenteDAO;
import eddyTurpo.entities.*;
import eddyTurpo.enums.PeriodicitàType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BookDAO bookDAO = new BookDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);

        //Cominciamo a creare qualcosa ^^
        System.out.println("-----------------creazioni libri tramite save-------------");
        Libro harryP1 = new Libro(101, "Harry Potter e la pietra filosofale", 1997, 200, "JKR", "Fantasy");
        //bookDAO.save(harryP1);
        Libro harryP2 = new Libro(102, "Harry Potter e la camera dei segreti", 1998, 300, "JKR", "Fantasy");
        //bookDAO.save(harryP2);
        Libro harryP3 = new Libro(103, "Harry Potter e i prigioniero di Azkaban", 1999, 400, "JKR", "Fantasy");
        //bookDAO.save(harryP3);
        Libro harryP4 = new Libro(104, "Harry Potter e il calice di fuoco", 2000, 500, "JKR", "Fantasy");
        //bookDAO.save(harryP4);
        Libro harryP5 = new Libro(105, "Harry Potter e l'ordine della fenice", 2001, 600, "JKR", "Fantasy");
        //bookDAO.save(harryP5);
        Libro harryP6 = new Libro(106, "Harry Potter e il principe mezzosangue", 2002, 700, "JKR", "Fantasy");
        //bookDAO.save(harryP6);
        Libro harryP7 = new Libro(107, "Harry Potter e i doni della morte", 2003, 800, "JKR", "Fantasy");
        //bookDAO.save(harryP7);
        Rivista gazzettaDelProfeta = new Rivista(200, "La gazzetta del Profeta", 2024, 25, PeriodicitàType.SETTIMANALE);
        //bookDAO.save(gazzettaDelProfeta);
        List<Libro> harryPotter = new ArrayList<>();
        harryPotter.addAll(Arrays.asList(harryP1, harryP2, harryP3, harryP4, harryP5, harryP6, harryP7));
        harryPotter.forEach(System.out::println);

        //Ora troviamo i libri creati tramite ISBN
        System.out.println("------------------------Libro trovato tramite ISBN----------------------------");
        Book libroDaTrovare = bookDAO.findByID(105);
        System.out.println(libroDaTrovare);
        System.out.println("------------------------Libro trovato tramite anno pubblicazione----------------------------");
        List<Book> libriTrovatiPerAnno = bookDAO.findByYear(1999);
        libriTrovatiPerAnno.forEach(System.out::println);
        System.out.println("------------------------Libro trovato tramite Autore----------------------------");
        List<Book> libriTrovatiPerAutore = bookDAO.findByAuthor("JKR");
        libriTrovatiPerAutore.forEach(System.out::println);
        System.out.println("------------------------Libro trovato tramite titolo o parte di esso----------------------------");
        List<Book> libriTrovatiPerTitolo = bookDAO.findByTitle("enic");
        libriTrovatiPerTitolo.forEach(System.out::println);
        System.out.println("--------------Ricerca elementi in prestito dato un numero di tessera utente-------------------");
        //creiamo dei prestiti e degli utenti prima
        Utente utente1 = new Utente("Eddy", "Turpo", LocalDate.of(1990, 04, 01));
        //utenteDAO.save(utente1);
        Utente utente2 = new Utente("Francesca", "Battistini", LocalDate.of(1991, 05, 30));
        //utenteDAO.save(utente2);
        Prestito prestito1 = new Prestito(utente1, harryP1, LocalDate.now(), null);
        Prestito prestito2 = new Prestito(utente2, harryP2, LocalDate.now(), null);
        Prestito prestito3 = new Prestito(utente1, harryP3, LocalDate.now().minusDays(20), LocalDate.now());
        Prestito prestito4 = new Prestito(utente2, harryP4, LocalDate.now().minusDays(35), null);

        //prestitoDAO.save(prestito1);
        //prestitoDAO.save(prestito2);
        //prestitoDAO.save(prestito3);
        //prestitoDAO.save(prestito4);

        List<Prestito> ricercaElementiTramiteTessera = prestitoDAO.findElementbyCard(1);
        ricercaElementiTramiteTessera.forEach(System.out::println);
        List<Prestito> ricercaElementiTramiteTessera2 = prestitoDAO.findElementbyCard(2);
        ricercaElementiTramiteTessera2.forEach(System.out::println);
        System.out.println("--------------Ricerca di tutti i prestiti scaduti e non ancora restituiti-------------------");
        List<Prestito> ricercaPrestitiScadutieMaiRestituiti = prestitoDAO.ricercaPrestitiScadutiENonRestituiti();
        ricercaPrestitiScadutieMaiRestituiti.forEach(System.out::println);

    }
}
