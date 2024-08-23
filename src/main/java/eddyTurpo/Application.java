package eddyTurpo;

import eddyTurpo.dao.BookDAO;
import eddyTurpo.dao.PrestitoDAO;
import eddyTurpo.dao.UtenteDAO;
import eddyTurpo.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BookDAO bookDAO = new BookDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);

        //Cominciamo a creare qualcosa ^^
        Libro harryP1 = new Libro(101, "Harry Potter e la pietra filosofale", 1997, 200, "JKR", "Fantasy");
        bookDAO.save(harryP1);
        Libro harryP2 = new Libro(102, "Harry Potter e la camera dei segreti", 1998, 300, "JKR", "Fantasy");
        bookDAO.save(harryP2);
        Libro harryP3 = new Libro(103, "Harry Potter e i prigioniero di Azkaban", 1999, 400, "JKR", "Fantasy");
        bookDAO.save(harryP3);
        Libro harryP4 = new Libro(104, "Harry Potter e il calice di fuoco", 2000, 500, "JKR", "Fantasy");
        bookDAO.save(harryP4);
        Libro harryP5 = new Libro(105, "Harry Potter e l'ordine della fenice", 2001, 600, "JKR", "Fantasy");
        bookDAO.save(harryP5);
        Libro harryP6 = new Libro(106, "Harry Potter e il principe mezzosangue", 2002, 700, "JKR", "Fantasy");
        bookDAO.save(harryP6);
        Libro harryP7 = new Libro(107, "Harry Potter e i doni della morte", 2003, 800, "JKR", "Fantasy");
        bookDAO.save(harryP7);


    }
}
