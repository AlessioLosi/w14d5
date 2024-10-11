package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private int numeroTessera;
    @OneToMany(mappedBy = "persona_id")
    private List<Prestito> prestitoList;


    public Persona(String nome, String cognome, int numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTessera = numeroTessera;
    }

    public Persona() {
    }

    ;

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String cognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int numeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public List<Prestito> prestitoList() {
        return prestitoList;
    }

    public void setPrestitoList(List<Prestito> prestitoList) {
        this.prestitoList = prestitoList;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numeroTessera=" + numeroTessera +
                '}';
    }
}