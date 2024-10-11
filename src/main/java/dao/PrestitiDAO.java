package dao;

import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitiDAO {
    private final EntityManager entityManager;

    public PrestitiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito newPrestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPrestito);
        transaction.commit();
        System.out.println("il prestito numero " + newPrestito.id() + " è stato salvato correttamente nel db");
    }

    public Prestito findById(long prestitoId) throws Exception {
        Prestito found = entityManager.find(Prestito.class, prestitoId);
        if (found == null) throw new Exception(String.valueOf(prestitoId));
        return found;
    }

    public Prestito findElement(long id) {
        Prestito found = entityManager.find(Prestito.class, id);
        if (found.dataEffettiva().isBefore(found.dataFine())) System.out.println("Elemento reso in tempo");
        else {
            System.out.println("Elemento non reso in tempo");

        }
        return found;

    }
}
