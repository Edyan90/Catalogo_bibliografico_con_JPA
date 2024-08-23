package eddyTurpo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends Book {
    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    private String genere;

    public Libro() {

    }

    public Libro(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString() +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} ";
    }
}
