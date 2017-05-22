package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.fyp.controller.AttributeCountException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "order_items")
@IdClass(OrderItemPK.class)
public class OrderItem extends BaseEntity{
    private int orderId;
    private int stockItemId;
    private int quantity;
    private BigDecimal unitPrice;
    @JsonBackReference
    private Order order;
    @JsonManagedReference
    private StockItem stockItem;


    public OrderItem() throws ParseException {

        orderId = 0;
        stockItemId = 0;
        unitPrice = new BigDecimal(0);
        quantity = 0;
        stockItem = new StockItem();
        order =  new Order();

    }

    public OrderItem(List<String> attributes) throws AttributeCountException, ParseException {

        new Order();

        if( attributes.size() == 4) {

            setOrderId(     toInteger(attributes.get(0)) );
            setStockItemId( toInteger(attributes.get(1)) );
            setUnitPrice(   toBigDecimal(attributes.get(2)) );
            setQuantity(    toInteger(attributes.get(3)) );

        } else {
            throw new AttributeCountException();
        }
    }
    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "stock_item_id", nullable = false)
    public int getStockItemId() {
        return stockItemId;
    }
    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_price", nullable = false, precision = 2)
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (orderId != orderItem.orderId) return false;
        if (stockItemId != orderItem.stockItemId) return false;
        if (quantity != orderItem.quantity) return false;
        if (unitPrice != null ? !unitPrice.equals(orderItem.unitPrice) : orderItem.unitPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + stockItemId;
        result = 31 * result + quantity;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false,insertable = false, updatable = false)
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "stock_item_id", referencedColumnName = "stock_item_id", nullable = false,insertable = false, updatable = false)
    public StockItem getStockItem() {
        return stockItem;
    }
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
}
