package br.com.fiap.seniorsmart.repositories;

import br.com.fiap.seniorsmart.models.Usuario;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;

public class UsuarioRepository {
    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Usuario> findAll() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    public List<Usuario> findAllOrderedByName() {
        return entityManager.createQuery("SELECT u FROM Usuario u ORDER BY u.nome ASC", Usuario.class)
                .getResultList();
    }
    
    
    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }
    
    public List<Usuario> findByNome(String nome) {
        String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    
    public List<Usuario> findByEmail(String email) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("email", email)
                .getResultList();
    }
    
    public List<Usuario> findByData(Date data) {
        String jpql = "SELECT u FROM Usuario u WHERE u.data = :data";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("data", data)
                .getResultList();
    }
    
    public void save(Usuario usuario) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void update(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
    public void removerUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    
}