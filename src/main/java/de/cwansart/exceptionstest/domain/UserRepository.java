package de.cwansart.exceptionstest.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    public User getById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = ?1", User.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
