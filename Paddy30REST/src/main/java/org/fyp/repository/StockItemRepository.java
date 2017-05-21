package org.fyp.repository;

        import org.fyp.model.StockItem;
        import org.springframework.data.jpa.repository.JpaRepository;

        import javax.transaction.Transactional;
        import java.util.ArrayList;
        import java.util.Collection;


//@RepositoryRestResource(collectionResourceRel = "stockItem", path = "StockItems")
@Transactional
public interface StockItemRepository extends JpaRepository<StockItem, Integer> {

    StockItem findByStockItemId(Integer stockItemId);

    // product search methods
    ArrayList<StockItem> findAllByItemCategoryId(int itemCategoryId);
    ArrayList<StockItem> findAllByManufacturerId(int manufacturerId);
    ArrayList<StockItem> findByTitleLikeIgnoreCase(String titleLike);
    ArrayList<StockItem> findByManufacturerIdAndItemCategoryIdAndTitleLikeIgnoreCase( Integer manufacturerId, Integer itemCategoryId, String titleLike );
    ArrayList<StockItem> findAllByTitleLikeIgnoreCase(String titleLike);
    ArrayList<StockItem> findByItemCategoryIdAndTitleLikeIgnoreCase( Integer itemCategoryId, String titleLike);
    ArrayList<StockItem> findByManufacturerIdAndTitleLikeIgnoreCase( Integer manufacturerId, String titleLike);

    Integer deleteByStockItemId(int stockItemId);
}
