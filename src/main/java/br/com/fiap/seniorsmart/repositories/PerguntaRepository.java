package br.com.fiap.seniorsmart.repositories;

import br.com.fiap.seniorsmart.models.Pergunta;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PerguntaRepository {
    private EntityManager entityManager;

    public PerguntaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Pergunta> findAll() {
        return entityManager.createQuery("SELECT p FROM Pergunta p", Pergunta.class)
                .getResultList();
    }
    
    public Pergunta findById(Long id) {
        return entityManager.find(Pergunta.class, id);
    }
    
    public void save(Pergunta pergunta) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(pergunta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void update(Pergunta pergunta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pergunta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Pergunta pergunta = entityManager.find(Pergunta.class, id);
            entityManager.remove(pergunta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void removerPergunta(Pergunta pergunta) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(pergunta);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }    
}