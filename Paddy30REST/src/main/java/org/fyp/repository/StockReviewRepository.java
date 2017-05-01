package org.fyp.repository;

import org.fyp.model.StockReview;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

//@RepositoryRestResource(collectionResourceRel = "stockReview", path = "StockReview")
@Transactional
public interface StockReviewRepository extends JpaRepository<StockReview, Integer> {
    Collection<StockReview> findAllByAccountId(int accountId);
    Collection<StockReview> findAllByStockItemId(int stockItemId);
    StockReview findByAccountIdAndStockItemId( int accountId, int stockItemId );

    Integer deleteByAccountIdAndStockItemId(int accountId, int stockItemId);
}
