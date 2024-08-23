package eddyTurpo.entities;

import eddyTurpo.enums.PeriodicitàType;
import jakarta.persistence.*;

@Entity
@Table(name = "rivista")
public class Rivista extends Book {
    @Column(name = "periodicità")
    @Enumerated(EnumType.STRING)
    private PeriodicitàType periodicità;

    public Rivista(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, PeriodicitàType periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Rivista() {

    }

    public PeriodicitàType getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(PeriodicitàType periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" + super.toString() +
                "periodicità=" + periodicità +
                "} ";
    }
}
