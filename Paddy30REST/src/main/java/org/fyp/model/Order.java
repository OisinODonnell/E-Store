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
@Table(name = "orders")
public class Order extends BaseEntity{
    private int orderId;
    private Timestamp date;
    private int accountId;
    private BigDecimal total;
    @JsonBackReference
    private Collection<OrderItem> orderItems;
    @JsonManagedReference
    private Account account;

    public Order() throws ParseException {
        accountId = 0;
        date= toTimestamp("2017-01-01 01:01");
        total = new BigDecimal(0);
        orderItems = new ArrayList<>();
        account = new Account();
    }

    public Order(List<String> attributes) throws AttributeCountException, ParseException {

        new Order();

        if( attributes.size() == 3) {

            setAccountId(   toInteger(attributes.get(0)) );
            setDate(        toTimestamp(attributes.get(1)) );
            setTotal(       toBigDecimal(attributes.get(2)) );

        } else {
            throw new AttributeCountException();
        }
    }
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "total", precision = 10, scale = 2)
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

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (accountId != order.accountId) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (total != null ? !total.equals(order.total) : order.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + accountId;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
