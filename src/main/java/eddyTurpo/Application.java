package eddyTurpo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("ciao");
    }
}
