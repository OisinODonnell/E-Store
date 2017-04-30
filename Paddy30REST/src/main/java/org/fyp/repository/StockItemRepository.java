package org.fyp.repository;

import org.fyp.model.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


//@RepositoryRestResource(collectionResourceRel = "stockItem", path = "StockItems")
@Transactional
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    //public StockItem findByStockItemId(Long stockItemId);
}
