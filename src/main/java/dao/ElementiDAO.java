package dao;

import entities.Elemento;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class ElementiDAO {
    private EntityManager em;

    public ElementiDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Elemento elemento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(elemento);
            t.commit();
            System.out.println(elemento.titolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Elemento findById(String codiceisbn) {
        Elemento found = em.find(Elemento.class, UUID.fromString(codiceisbn));
        if (found == null) System.out.println("nessun elemento trovato");
        else {
            System.out.println("Elemento " + found.titolo() + " è stato trovato");

        }
        return found;

    }

    public void findByISBNAndDelete(String codiceisbn) {
        try {
            EntityTransaction t = em.getTransaction();
            Elemento found = em.find(Elemento.class, UUID.fromString(codiceisbn));
            if (found != null) {
                System.out.println("l'elemento " + found.titolo() + " è stato eliminato");
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Elemento> filtraElemento(String partialName) {
        TypedQuery<Elemento> query = em.createQuery("SELECT e FROM Elemento e WHERE e.titolo LIKE :partialaName ", Elemento.class);
        query.setParameter("partialName", "%" + partialName + "%");
        return query.getResultList();
    }

    public List<Libro> filtraAutore(String nomeAutore) {
        TypedQuery<Libro> query = em.createQuery("SELECT l  FROM Libro l WHERE l.autore LIKE " + nomeAutore, Libro.class);
        query.setParameter("nomeAutore", nomeAutore);
        return query.getResultList();
    }
}