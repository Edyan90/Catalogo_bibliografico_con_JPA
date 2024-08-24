package eddyTurpo.exceptions;

public class NotFoundYear extends RuntimeException {
    public NotFoundYear(long year) {
        super("Non sono stati trovati libri/riviste con l'anno " + year);
    }
}

