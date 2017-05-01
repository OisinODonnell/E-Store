package org.fyp.repository;

import org.fyp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "order", path = "Orders")
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Collection<Order> findAllByAccountId(int accountId);
    Order findByOrderId (int orderId);


}
