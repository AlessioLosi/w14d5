package entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Rivista")

public class Rivista extends Elemento {
    private Periodicità periodicità;

    public Rivista(String titolo, LocalDate annoDiPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Rivista() {
    }

    public Periodicità periodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                '}';
    }
}
