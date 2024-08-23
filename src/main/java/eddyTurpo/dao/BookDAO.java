package eddyTurpo.dao;

import eddyTurpo.entities.Book;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BookDAO {
    private final EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Book book) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        System.out.println("Il libro/rivista " + book.getTitolo() + " è stato salvato/a correttamente");
    }

    public Book findByID(long id) {
        Book found = em.find(Book.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(long id) {
        Book found = this.findByID(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("il libro/rivista è stato/a rimosso/a!");
    }
}
