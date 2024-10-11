package dao;

import entities.Elemento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.time.LocalDate;
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

    public List findElement(String name) {
        Query query = em.createQuery("SELECT e FROM Elemento e WHERE e.titolo LIKE  :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List findLibro(String name) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.titolo LIKE  :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List findRivista(String name) {
        Query query = em.createQuery("SELECT r FROM Rivista r WHERE r.titolo LIKE  :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List findAutore(String autore) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.autore =   :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List findAnnoLibro(LocalDate anno) {
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.annoDiPubblicazione =   :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List findAnnoRivista(LocalDate anno) {
        Query query = em.createQuery("SELECT r FROM Rivista r WHERE r.annoDiPubblicazione =   :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

}