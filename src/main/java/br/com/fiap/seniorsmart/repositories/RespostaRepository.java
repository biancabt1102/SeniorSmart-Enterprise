package br.com.fiap.seniorsmart.repositories;

import br.com.fiap.seniorsmart.models.Resposta;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RespostaRepository {
    private EntityManager entityManager;

    public RespostaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Resposta> findAll() {
        return entityManager.createQuery("SELECT r FROM Resposta r", Resposta.class)
                .getResultList();
    }

    public Resposta findById(long id) {
        return entityManager.find(Resposta.class, id);
    }

    public void save(Resposta resposta) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(resposta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void update(Resposta resposta) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(resposta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteById(long id) {
        try {
            entityManager.getTransaction().begin();
            Resposta resposta = entityManager.find(Resposta.class, id);
            entityManager.remove(resposta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void removerResposta(Resposta resposta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(resposta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
