package org.fyp.repository;

import org.fyp.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "itemCategory", path = "ItemCategories")
@Transactional
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {
    ItemCategory findByItemCategoryId(Integer itemCategoryId);
    Integer deleteByItemCategoryId(Integer itemCategoryId);
}
