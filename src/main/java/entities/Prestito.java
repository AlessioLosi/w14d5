package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona_id;
    @ManyToOne
    @JoinColumn(name = "elemento")
    private Elemento elemento_id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalDate dataEffettiva;

    public Prestito() {
    }

    ;

    public Prestito(Persona persona_id, Elemento elemento_id, LocalDate dataInizio, LocalDate dataFine, LocalDate dataEffettiva) {
        this.persona_id = persona_id;
        this.elemento_id = elemento_id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dataEffettiva = dataEffettiva;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Elemento elemento_id() {
        return elemento_id;
    }

    public void setElemento_id(Elemento elemento_id) {
        this.elemento_id = elemento_id;
    }

    public LocalDate dataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate dataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public LocalDate dataEffettiva() {
        return dataEffettiva;
    }

    public void setDataEffettiva(LocalDate dataEffettiva) {
        this.dataEffettiva = dataEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "dataFine=" + dataFine +
                ", dataEffettiva=" + dataEffettiva +
                ", dataInizio=" + dataInizio +
                ", elemento=" + elemento_id +
                ", persona=" + persona_id +
                ", id=" + id +
                '}';
    }
}
