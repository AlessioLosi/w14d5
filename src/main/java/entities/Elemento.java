package entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Elemento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elemento")
public class Elemento {
    @Id
    @GeneratedValue
    private UUID codiceIsbn;
    private String titolo;
    private LocalDate annoDiPubblicazione;
    private int numeroPagine;
    @OneToMany(mappedBy = "elemento_id")
    private List<Prestito> prestitoList;

    public Elemento() {
    }

    ;

    public Elemento(String titolo, LocalDate annoDiPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID codiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(UUID codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String titolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate annoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(LocalDate annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int numeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public List<Prestito> prestitoList() {
        return prestitoList;
    }

    public void setPrestitoList(List<Prestito> prestitoList) {
        this.prestitoList = prestitoList;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
