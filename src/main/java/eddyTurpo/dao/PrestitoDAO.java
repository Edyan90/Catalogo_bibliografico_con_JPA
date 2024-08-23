package eddyTurpo.dao;

import eddyTurpo.entities.Prestito;
import eddyTurpo.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Il prestito con ID: " + prestito.getId() + " è stato salvato/a correttamente");
    }

    public Prestito findByID(long id) {
        Prestito found = em.find(Prestito.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void delete(long id) {
        Prestito found = this.findByID(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("il prestito con ID " + found.getId() + " è stato rimosso!");
    }

    public List<Prestito> findElementbyCard(long numero) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroTessera=:numero AND p.dataRestituizioneEffettiva IS NULL",
                Prestito.class);
        query.setParameter("numero", numero);
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx(numero);
        }
        return query.getResultList();
    }

    public List<Prestito> ricercaPrestitiScadutiENonRestituiti() {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituizioneEffettiva IS NULL AND p.dataRestituizionePrevista < :today",
                Prestito.class);
        query.setParameter("today", LocalDate.now());
        if (query.getResultList().isEmpty()) {
            throw new NotFoundEx();
        }
        return query.getResultList();
    }
}
