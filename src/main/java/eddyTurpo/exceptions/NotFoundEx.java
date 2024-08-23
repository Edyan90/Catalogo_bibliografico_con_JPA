package eddyTurpo.exceptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(long id) {
        super("L'elemento con ID " + id + " non è stato trovato");
    }
}
