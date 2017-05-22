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
@Table(name = "cart_items")
@IdClass(CartItemPK.class)
public class CartItem extends BaseEntity{
    private int cartId;
    private int stockItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    @JsonBackReference
    private Cart cart;
    @JsonManagedReference
    private StockItem stockItem;

    public CartItem() throws ParseException {

        cartId      = 0;
        stockItemId = 0;
        unitPrice   = new BigDecimal(0.0);
        quantity    = 0;
        stockItem   = new StockItem();
        cart        = new Cart();

    }

    public CartItem(List<String> attributes) throws AttributeCountException, ParseException {

        new CartItem();

        if( attributes.size() == 4) {

            setCartId(      toInteger(attributes.get(0)) );
            setStockItemId( toInteger(attributes.get(1)) );
            setUnitPrice(   toBigDecimal(attributes.get(2)) );
            setQuantity(    toInteger(attributes.get(3)) );

        } else {
            throw new AttributeCountException();
        }
    }
    @Id
    @Column(name = "cart_id", nullable = false)
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
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
    @Column(name = "quantity" )
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_price",  precision = 2)
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

        CartItem cartItem = (CartItem) o;

        if (cartId != cartItem.cartId) return false;
        if (stockItemId != cartItem.stockItemId) return false;
        if (quantity != null ? !quantity.equals(cartItem.quantity) : cartItem.quantity != null) return false;
        if (unitPrice != null ? !unitPrice.equals(cartItem.unitPrice) : cartItem.unitPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + stockItemId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false,insertable = false, updatable = false)
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart carts) {
        this.cart = carts;
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
