package br.com.fiap.seniorsmart.repositories;

import br.com.fiap.seniorsmart.models.Plano;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlanoRepository {

    private EntityManager entityManager;

    public PlanoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Plano> findAll() {
        return entityManager.createQuery("SELECT p FROM Plano p", Plano.class)
                .getResultList();
    }

    public Plano findById(Long id) {
        return entityManager.find(Plano.class, id);
    }

    public void save(Plano plano) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(plano);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void update(Plano plano) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(plano);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Plano plano = entityManager.find(Plano.class, id);
            entityManager.remove(plano);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void removerPLano(Plano plano) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(plano);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
