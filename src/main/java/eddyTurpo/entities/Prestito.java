package eddyTurpo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "utente")
    private Utente utente;
    @Column(name = "elemento_prestato")
    private Book elementoPrestato;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituizione_prevista")
    private LocalDate dataRestituizionePrevista;
    @Column(name = "data_restituizione_effettiva")
    private LocalDate dataRestituizioneEffettiva;

    public Prestito(long id, Utente utente, Book elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituizioneEffettiva) {
        this.id = id;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituizioneEffettiva = dataRestituizioneEffettiva;
    }

    public Prestito() {

    }

    public long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Book getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Book elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituizionePrevista() {
        return dataRestituizionePrevista;
    }

    public void setDataRestituizionePrevista(LocalDate dataRestituizionePrevista) {
        this.dataRestituizionePrevista = dataRestituizionePrevista;
    }

    public LocalDate getDataRestituizioneEffettiva() {
        return dataRestituizioneEffettiva;
    }

    public void setDataRestituizioneEffettiva(LocalDate dataRestituizioneEffettiva) {
        this.dataRestituizioneEffettiva = dataRestituizioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituizionePrevista=" + dataRestituizionePrevista +
                ", dataRestituizioneEffettiva=" + dataRestituizioneEffettiva +
                '}';
    }
}
