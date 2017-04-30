package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by oisin on 02/04/2017.
 */
public class CartItemPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cartId;
    private int stockItemId;

    @Column(name = "cart_id", nullable = false)
    @Id
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Column(name = "stock_item_id", nullable = false)
    @Id
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

        CartItemPK that = (CartItemPK) o;

        if (cartId != that.cartId) return false;
        if (stockItemId != that.stockItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + stockItemId;
        return result;
    }
}
