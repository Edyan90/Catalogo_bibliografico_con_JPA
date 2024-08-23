package eddyTurpo;

import eddyTurpo.dao.BookDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BookDAO bookDAO = new BookDAO(em);
        
    }
}
