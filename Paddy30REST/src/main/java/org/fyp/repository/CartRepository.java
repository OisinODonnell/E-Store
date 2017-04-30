package org.fyp.repository;

import org.fyp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "cart", path = "Carts")
@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer> {
    Collection<Cart> findAllByAccountId(int accountId);
    Cart findByCartId(int cartId);
}

