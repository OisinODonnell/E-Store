package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.fyp.controller.AttributeCountException;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity{
    private int cartId;
    private int accountId;
    private Timestamp date;
    private BigDecimal total;
    @JsonBackReference
    private Collection<CartItem> cartItems;
    // This is Jackson annotation added to manage bidirectional relationships
    // to avoid the problem of infinite recursion. (Account calling Cart, then Cart
    // calling the same account. As is @JsonBackReference.
    @JsonManagedReference
    private Account account;

    public Cart() throws ParseException {

        accountId = 0;
        date= toTimestamp("2017-01-01 01:01");
        total = new BigDecimal(0.0);
        cartItems = new ArrayList<>();
        account = new Account();

    }

    public Cart(List<String> attributes) throws AttributeCountException, ParseException {

        new Cart();

        if( attributes.size() == 3) {

            setAccountId(   toInteger(attributes.get(0)) );
            setDate(        toTimestamp(attributes.get(1)) );
            setTotal(       toBigDecimal(attributes.get(2)) );
        } else {
            throw new AttributeCountException();
        }
    }
    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "total",  precision = 10, scale = 2)
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (accountId != cart.accountId) return false;
        if (date != null ? !date.equals(cart.date) : cart.date != null) return false;
        if (total != null ? !total.equals(cart.total) : cart.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + accountId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cart", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Collection<CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(Collection<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false,insertable = false, updatable = false)
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
