package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.fyp.controller.AttributeCountException;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "manufacturers")
public class Manufacturer extends BaseEntity {
    private int manufacturerId;
    private String name;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    @JsonBackReference
    private Collection<StockItem> stockItems;

    public Manufacturer() {
        name = "";
        contactName  = "";
        contactPhone = "";
        contactEmail = "";
//        stockItems = new ArrayList<?>();

    }

    public Manufacturer(List<String> attributes) throws AttributeCountException {

        new Manufacturer();

        if( attributes.size() == 4) {

            setName(         attributes.get(0) );
            setContactName(  attributes.get(1) );
            setContactPhone( attributes.get(2) );
            setContactEmail( attributes.get(3) );

        } else {
            throw new AttributeCountException();
        }
    }

    @Id
    @Column(name = "manufacturer_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getManufacturerId() {
        return manufacturerId;
    }
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "contact_name", nullable = true, length = 45)
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contact_phone", nullable = true, length = 45)
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Basic
    @Column(name = "contact_email", nullable = false, length = 60)
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (manufacturerId != that.manufacturerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (contactPhone != null ? !contactPhone.equals(that.contactPhone) : that.contactPhone != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manufacturerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "manufacturer")
    public Collection<StockItem> getStockItems() {
        return stockItems;
    }
    public void setStockItems(Collection<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
