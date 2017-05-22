package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.fyp.controller.AttributeCountException;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "stock_items")
public class StockItem extends BaseEntity{
    private int stockItemId;
    private String title;
    private Integer stockLevel;
    private byte[] image;
    private BigDecimal price;
    private int manufacturerId;
    private int itemCategoryId;
    @JsonManagedReference
    private Manufacturer manufacturer;
    @JsonManagedReference
    private ItemCategory itemCategory;
    @JsonManagedReference
    private Collection<StockReview> stockReviews;

    public StockItem() {

        title = "";
        stockLevel = 0;
        image = null;
        price = new BigDecimal(0);
        manufacturerId = 0;
        itemCategoryId = 0;
        manufacturer = new Manufacturer();
        itemCategory = new ItemCategory();
        stockReviews = new ArrayList<>();

    }


    public StockItem(List<String> attributes) throws AttributeCountException {

        new StockItem();

        if( attributes.size() == 6) {

            setTitle(           attributes.get(0) );
            setStockLevel(      toInteger(attributes.get(1)) );
            setImage(           toByteArray(attributes.get(2)) );
            setPrice(           toBigDecimal(attributes.get(3)) );
            setManufacturerId(  toInteger(attributes.get(4)) );
            setItemCategoryId(  toInteger(attributes.get(5)) );

        } else {
            throw new AttributeCountException();
        }
    }

    @Id
    @Column(name = "stock_item_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getStockItemId() {
        return stockItemId;
    }
    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "stock_level")
    public Integer getStockLevel() {
        return stockLevel;
    }
    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price", precision = 10, scale = 2)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "manufacturer_id", nullable = false)
    public int getManufacturerId() {
        return manufacturerId;
    }
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Basic
    @Column(name = "item_category_id", nullable = false)
    public int getItemCategoryId() {
        return itemCategoryId;
    }
    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockItem stockItem = (StockItem) o;

        if (stockItemId != stockItem.stockItemId) return false;
        if (manufacturerId != stockItem.manufacturerId) return false;
        if (itemCategoryId != stockItem.itemCategoryId) return false;
        if (title != null ? !title.equals(stockItem.title) : stockItem.title != null) return false;
        if (stockLevel != null ? !stockLevel.equals(stockItem.stockLevel) : stockItem.stockLevel != null) return false;
        if (!Arrays.equals(image, stockItem.image)) return false;
        if (price != null ? !price.equals(stockItem.price) : stockItem.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockItemId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (stockLevel != null ? stockLevel.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + manufacturerId;
        result = 31 * result + itemCategoryId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id", nullable = false,insertable = false, updatable = false)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToOne
    @JoinColumn(name = "item_category_id", referencedColumnName = "item_category_id", nullable = false,insertable = false, updatable = false)
    public ItemCategory getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @OneToMany(mappedBy = "stockItem", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    public Collection<StockReview> getStockReviews() {
        return stockReviews;
    }
    public void setStockReviews(Collection<StockReview> stockReviews) {
        this.stockReviews = stockReviews;
    }
}
