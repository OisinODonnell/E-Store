package org.fyp.repository;

import org.fyp.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "session", path = "Sessions")
@Transactional
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Collection<Session> findAllByAccountId(int accountId);
    Session findBySessionId(int sessionId);
    Integer deleteBySessionId(int sessionId);
}
