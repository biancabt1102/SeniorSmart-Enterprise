package br.com.fiap.seniorsmart.repositories;

import br.com.fiap.seniorsmart.models.Pagamento;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;

public class PagamentoRepository {
    private EntityManager entityManager;

    public PagamentoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Pagamento> findAll() {
        return entityManager.createQuery("SELECT p FROM Pagamento p", Pagamento.class)
                .getResultList();
    }

    public Pagamento findById(Long id) {
        return entityManager.find(Pagamento.class, id);
    }

    public List<Pagamento> findByNomeNoCartao(String nomeNoCartao) {
        String jpql = "SELECT p FROM Pagamento p WHERE p.nomeNoCartao = :nomeNoCartao";
        return entityManager.createQuery(jpql, Pagamento.class)
                .setParameter("nomeNoCartao", nomeNoCartao)
                .getResultList();
    }

    public List<Pagamento> findByNumeroDoCartao(String numeroDoCartao) {
        String jpql = "SELECT p FROM Pagamento p WHERE p.numeroDoCartao = :numeroDoCartao";
        return entityManager.createQuery(jpql, Pagamento.class)
                .setParameter("numeroDoCartao", numeroDoCartao)
                .getResultList();
    }

    public List<Pagamento> findByValidadeDoCartao(Date validadeDoCartao) {
        String jpql = "SELECT p FROM Pagamento p WHERE p.validadeDoCartao = :validadeDoCartao";
        return entityManager.createQuery(jpql, Pagamento.class)
                .setParameter("validadeDoCartao", validadeDoCartao)
                .getResultList();
    }

    public void save(Pagamento pagamento) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void atualizarPagamento(Pagamento pagamento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    

    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Pagamento pagamento = entityManager.find(Pagamento.class, id);
            entityManager.remove(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    

    public void removerPagamento(Pagamento pagamento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
}
