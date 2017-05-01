package org.fyp.repository;

        import org.fyp.model.StockItem;
        import org.springframework.data.jpa.repository.JpaRepository;

        import javax.transaction.Transactional;
        import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "stockItem", path = "StockItems")
@Transactional
public interface StockItemRepository extends JpaRepository<StockItem, Integer> {

    StockItem findByStockItemId(Integer stockItemId);

    Collection<StockItem> findAllByItemCategoryId(int itemCategoryId);
    Collection<StockItem> findAllByManufacturerId(int manufacturerId);
    Collection<StockItem> findByTitleLikeIgnoreCase(String titleLike);
}
