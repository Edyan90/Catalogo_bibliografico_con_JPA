package eddyTurpo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "data_di_nascità")
    private LocalDate dataNascità;
    @Column(name = "numero_tessera")
    private long numeroTessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataNascità, long numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascità = dataNascità;
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascità() {
        return dataNascità;
    }

    public void setDataNascità(LocalDate dataNascità) {
        this.dataNascità = dataNascità;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascità=" + dataNascità +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}
