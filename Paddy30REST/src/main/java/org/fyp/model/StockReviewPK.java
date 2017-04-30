package org.fyp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by oisin on 02/04/2017.
 */
public class StockReviewPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private int stockItemId;
    private int accountId;

    @Column(name = "stock_item_id", nullable = false)
    @Id
    public int getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    @Column(name = "account_id", nullable = false)
    @Id
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockReviewPK that = (StockReviewPK) o;

        if (stockItemId != that.stockItemId) return false;
        if (accountId != that.accountId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockItemId;
        result = 31 * result + accountId;
        return result;
    }
}
