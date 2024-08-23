package eddyTurpo.dao;

import eddyTurpo.entities.Book;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Book> findByYear(long year) {
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.annoPubblicazione=:year",
                Book.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Book> findByAuthor(String autore) {
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.autore=:autore",
                Book.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b WHERE b.titolo LIKE :title",
                Book.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

}
