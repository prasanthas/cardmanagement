package au.com.ps.opal.domain;

import java.util.List;

public class Customer {

    private String customerId;

    private String firstName;
    private String lastName;
    private List<OpalCard> opalCards;

    private Address address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<OpalCard> getOpalCards() {
        return opalCards;
    }

    public void setOpalCards(List<OpalCard> opalCards) {
        this.opalCards = opalCards;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
