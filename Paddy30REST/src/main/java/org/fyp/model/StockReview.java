package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.fyp.controller.AttributeCountException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "stock_reviews")
@IdClass(StockReviewPK.class)
public class StockReview extends BaseEntity{
    private int stockItemId;
    private int accountId;
    private String rating;
    private String comment;
    private Timestamp date;
    @JsonBackReference
    private StockItem stockItem;
    @JsonBackReference
    private Account account;

    public StockReview() throws ParseException {
        stockItemId = 0;
        accountId = 0;
        rating = "5";
        comment = "";
        date = toTimestamp("2017-01-01 01:01");
        stockItem = new StockItem();
        account = new Account();
    }

    public StockReview(List<String> attributes) throws AttributeCountException, ParseException {

        new StockReview();

        if (attributes.size() == 5) {

            setStockItemId( toInteger(attributes.get(0)) );
            setAccountId(   toInteger(attributes.get(1)) );
            setRating(      attributes.get(2) );
            setComment(     attributes.get(3) );
            setDate(        toTimestamp(attributes.get(4)) );

        } else {
            throw new AttributeCountException();
        }
    }

    @Id
    @Column(name = "stock_item_id", nullable = false)
    public int getStockItemId() {
        return stockItemId;
    }
    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    @Id
    @Column(name = "account_id", nullable = false)
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "comment", length = 100)
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockReview that = (StockReview) o;

        if (stockItemId != that.stockItemId) return false;
        if (accountId != that.accountId) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockItemId;
        result = 31 * result + accountId;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "stock_item_id", referencedColumnName = "stock_item_id", nullable = false,insertable = false, updatable = false)
    public StockItem getStockItem() {
        return stockItem;
    }
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
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
