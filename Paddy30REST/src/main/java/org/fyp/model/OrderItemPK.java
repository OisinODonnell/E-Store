package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by oisin on 02/04/2017.
 */
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private int orderId;
    private int stockItemId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;

        if (orderId != that.orderId) return false;
        if (stockItemId != that.stockItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + stockItemId;
        return result;
    }
}
