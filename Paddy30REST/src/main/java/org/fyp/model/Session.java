package org.fyp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.fyp.controller.AttributeCountException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

/**
 * Created by oisin on 02/04/2017.
 */
@Entity
@Table(name = "sessions")
public class Session extends BaseEntity {

    private int sessionId;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private int accountId;
    @JsonManagedReference
    private Account account;

    public Session() throws ParseException {

        accountId = 0;
        dateStart = toTimestamp("2017-01-01 01:01");
        dateEnd = toTimestamp("2017-01-01 01:01");
        account = null;
    }

    public Session(List<String> attributes) throws AttributeCountException, ParseException {

        new Session();

        if( attributes.size() == 3) {

            setAccountId(   toInteger(attributes.get(0)) );
            setDateStart(   toTimestamp(attributes.get(1)) );
            setDateEnd(     toTimestamp(attributes.get(2)) );

        } else {
            throw new AttributeCountException();
        }
    }

    @Id
    @Column(name = "session_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getSessionId() {
        return sessionId;
    }
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "date_start", nullable = false)
    public Timestamp getDateStart() {
        return dateStart;
    }
    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end")
    public Timestamp getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "account_id", nullable = false)
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

        Session session = (Session) o;

        if (sessionId != session.sessionId) return false;
        if (accountId != session.accountId) return false;
        if (dateStart != null ? !dateStart.equals(session.dateStart) : session.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(session.dateEnd) : session.dateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
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
