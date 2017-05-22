package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.fyp.controller.AttributeCountException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "item_categories")
public class ItemCategory extends BaseEntity{
    private int itemCategoryId;
    private String type;
    @JsonBackReference
    private Collection<StockItem> stockItems;

    public ItemCategory() {

        type = "";
        stockItems = new ArrayList<>();
    }

    public ItemCategory(List<String> attributes) throws AttributeCountException {

        new ItemCategory();

        if( attributes.size() == 1) {

            setType(attributes.get(0));

        } else {
            throw new AttributeCountException();
        }
    }

    @Id
    @Column(name = "item_category_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getItemCategoryId() {
        return itemCategoryId;
    }
    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCategory that = (ItemCategory) o;

        if (itemCategoryId != that.itemCategoryId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemCategoryId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "itemCategory")
    public Collection<StockItem> getStockItems() { return stockItems;  }
    public void setStockItems(Collection<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
