package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.fyp.controller.AttributeCountException;
import org.fyp.repository.CartRepository;
import org.fyp.repository.OrderRepository;
import org.fyp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity{

    @Autowired
    SessionRepository sessionRepo;
    @Autowired
    OrderRepository orderRepo;
    @Autowired
    CartRepository cartRepo;
    @Autowired
    StockReview stockReviewRepo;

    private int accountId;
    private Timestamp dateJoined;
    private String name;
    private String email;
    private String phone;
    private String accountType;
    private String paymentType;
    private Byte loyaltyCard;
    private String password;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    // This is Jackson annotation added to manage bidirectional relationships
    // to avoid the problem of infinite recursion. (Account calling Cart, then Cart
    // calling the same account.
    @JsonBackReference
    private Collection<Cart> carts;
    @JsonBackReference
    private Collection<Order> orders;
    @JsonBackReference
    private Collection<Session> sessions;
    @JsonBackReference
    private Collection<StockReview> stockReviews;

    public Account() throws ParseException {

        dateJoined      = toTimestamp("2017-01-01 01:01");
        name            = "";
        email           = "";
        phone           = "";
        accountType     = "CUSTOMER";
        paymentType     = "VISA";
        loyaltyCard     = 0x0; // byte value
        password        = "";
        addressStreet   = "";
        addressCity     = "";
        addressCountry  = "";
        carts           = new ArrayList<>();
        orders          = new ArrayList<>();
        sessions        = new ArrayList<>();
        stockReviews    = new ArrayList<>();

    }

    public Account(List<String> attributes) throws AttributeCountException, ParseException {

        new Account();

        if( attributes.size() == 11) {

            setDateJoined(      toTimestamp(attributes.get(0)) );
            setName(            attributes.get(1) );
            setEmail(           attributes.get(2) );
            setPhone(           attributes.get(3) );
            setAccountType(     attributes.get(4) );
            setPaymentType(     attributes.get(5) );
            setPassword(        attributes.get(6) );
            setLoyaltyCard(     toByte(attributes.get(7)) );
            setAddressCity(     attributes.get(8) );
            setAddressStreet(   attributes.get(9) );
            setAddressCountry(  attributes.get(10) );
        } else {
            throw new AttributeCountException();
        }
    }


    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "date_joined", nullable = false)
    public Timestamp getDateJoined() {
        return dateJoined;
    }
    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Basic
    @Column(name = "name",  length = 45)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone",  length = 45)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "account_type", nullable = false)
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "payment_type")
    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "loyalty_card")
    public Byte getLoyaltyCard() {
        return loyaltyCard;
    }
    public void setLoyaltyCard(Byte loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @Basic
    @Column(name = "password", length = 45)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "address_street",  length = 45)
    public String getAddressStreet() {
        return addressStreet;
    }
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Basic
    @Column(name = "address_city",  length = 45)
    public String getAddressCity() {
        return addressCity;
    }
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Basic
    @Column(name = "address_country",  length = 45)
    public String getAddressCountry() {     return addressCountry;   }
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != account.accountId) return false;
        if (dateJoined != null ? !dateJoined.equals(account.dateJoined) : account.dateJoined != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        if (phone != null ? !phone.equals(account.phone) : account.phone != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null) return false;
        if (paymentType != null ? !paymentType.equals(account.paymentType) : account.paymentType != null) return false;
        if (loyaltyCard != null ? !loyaltyCard.equals(account.loyaltyCard) : account.loyaltyCard != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (addressStreet != null ? !addressStreet.equals(account.addressStreet) : account.addressStreet != null) return false;
        if (addressCity != null ? !addressCity.equals(account.addressCity) : account.addressCity != null) return false;
        if (addressCountry != null ? !addressCountry.equals(account.addressCountry) : account.addressCountry != null)
            return false;

        return true;
    }

    // hashcode is needed to create a unique reference for each item in the list.
    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (dateJoined != null ? dateJoined.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (loyaltyCard != null ? loyaltyCard.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (addressStreet != null ? addressStreet.hashCode() : 0);
        result = 31 * result + (addressCity != null ? addressCity.hashCode() : 0);
        result = 31 * result + (addressCountry != null ? addressCountry.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "account", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Collection<Cart> getCarts() {
        return carts;
    }
    public void setCarts(Collection<Cart> carts) {
        this.carts = carts;
    }

    @OneToMany(mappedBy = "account", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Collection<Order> getOrders()     {
        return orders;
    }
    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "account", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Collection<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Collection<Session> sessions) {
        this.sessions = sessions;
    }

    @OneToMany(mappedBy = "account", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
    //@Fetch(value = FetchMode.SUBSELECT)
    public Collection<StockReview> getStockReviews() {
        return stockReviews;
    }

    public void setStockReviews(Collection<StockReview> stockReviews) {
        this.stockReviews = stockReviews;
    }
}
