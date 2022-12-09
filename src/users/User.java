package users;

import enums.Enum;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastname;
    private Enum.GENDER gender;
    private Enum.ADDRESS_TYPE addressType;
    private String address;
    private Enum.COUNTRY country;
    private String email;

    public User(String firstName, String lastname, Enum.GENDER gender, Enum.ADDRESS_TYPE addressType, String address, Enum.COUNTRY country, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.addressType = addressType;
        this.address = address;
        this.country = country;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Enum.GENDER getGender() {
        return gender;
    }

    public void setGender(Enum.GENDER gender) {
        this.gender = gender;
    }

    public Enum.ADDRESS_TYPE getAddressType() {
        return addressType;
    }

    public void setAddressType(Enum.ADDRESS_TYPE addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Enum.COUNTRY getCountry() {
        return country;
    }

    public void setCountry(Enum.COUNTRY country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", addressType=" + addressType +
                ", address='" + address + '\'' +
                ", country=" + country +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastname, user.lastname) && gender == user.gender && addressType == user.addressType && Objects.equals(address, user.address) && country == user.country && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastname, gender, addressType, address, country, email);
    }
}
