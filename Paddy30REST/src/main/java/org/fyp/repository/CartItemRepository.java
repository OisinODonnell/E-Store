package org.fyp.repository;

import org.fyp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "cartItem", path = "CartItems")
@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Collection<CartItem> findAllByCartId(int cartId);
}
