package org.example;

import dao.ElementiDAO;
import dao.PersoneDAO;
import dao.PrestitiDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w14d5");

    public static void main(String[] args) {

        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        ElementiDAO ed = new ElementiDAO(em);
        PersoneDAO pd = new PersoneDAO(em);
        PrestitiDAO prd = new PrestitiDAO(em);

        Libro libro1 = new Libro("Libro 1", LocalDate.now().minusYears(3), 340, "Autore 1", "Horror");
        Libro libro2 = new Libro("Libro 2", LocalDate.now().minusYears(5), 400, "Autore 2", "Romanzo");
        Libro libro3 = new Libro("Libro 3", LocalDate.now().minusYears(2), 120, "Autore 3", "Storico");
        Rivista rivista1 = new Rivista("Rivista1", LocalDate.now().minusMonths(2), 30, Periodicità.semestrale);
        Rivista rivista2 = new Rivista("Rivista2", LocalDate.now().minusMonths(1), 34, Periodicità.annuale);
        Rivista rivista3 = new Rivista("Rivista3", LocalDate.now().minusMonths(4), 80, Periodicità.mensile);
        Rivista rivista4 = new Rivista("Rivista4", LocalDate.now().minusMonths(18), 90, Periodicità.settimanale);
        // ed.save(libro1);
        // ed.save(libro2);
        //  ed.save(libro3);
        // ed.save(rivista1);
        //  ed.save(rivista2);
        // ed.save(rivista3);
        //  ed.save(rivista4);
        Persona persona1 = new Persona("Taylor", "Swift", 20);
        Persona persona2 = new Persona("Olivia", "Rodrigo", 30);
        Persona persona3 = new Persona("Tate", "Mcrae", 40);
        // pd.save(persona1);
        // pd.save(persona2);
        // pd.save(persona3);
        Prestito prestito1 = new Prestito(persona1, libro1, LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().plusDays(10));
        Prestito prestito2 = new Prestito(persona2, libro2, LocalDate.now().minusDays(30), LocalDate.now(), LocalDate.now().plusDays(14));
        Prestito prestito3 = new Prestito(persona3, libro3, LocalDate.now().minusMonths(2), LocalDate.now().minusDays(30), LocalDate.now());
        Prestito prestito4 = new Prestito(persona1, rivista1, LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().plusDays(10));
        Prestito prestito5 = new Prestito(persona2, rivista2, LocalDate.now().minusYears(1), LocalDate.now().minusMonths(11), LocalDate.now().minusMonths(11));
        Prestito prestito6 = new Prestito(persona3, rivista3, LocalDate.now(), LocalDate.now().plusDays(30), LocalDate.now().plusDays(5));
        // prd.save(prestito1);
        // prd.save(prestito2);
        // prd.save(prestito3);
        // prd.save(prestito4);
        //prd.save(prestito5);
        //prd.save(prestito6);

        //Elimina un elemebnto dal codice isbn
        // ed.findByISBNAndDelete("\"58541bc8-e9af-4434-a20a-e69cb04b982e\"");
        ed.findById("58541bc8-e9af-4434-a20a-e69cb04b982e");
        ed.filtraElemento("s");

    }
}
