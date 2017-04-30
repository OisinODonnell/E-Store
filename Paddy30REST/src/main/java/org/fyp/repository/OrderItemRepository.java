package org.fyp.repository;

import org.fyp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "orderItem", path = "OrderItems")
@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Collection<OrderItem> findAllByOrderId(int orderId);

}
