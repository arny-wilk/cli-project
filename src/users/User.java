package users;

import java.io.Serializable;
import java.util.UUID;

import enums.Enum;

public class User implements Serializable {
    private UUID userId;
    private String firstName;
    private String lastname;
    private Enum.GENDER gender;
    private Enum.ADDRESS_TYPE addressType;
    private String address;
    private Enum.COUNTRY country;
    private String email;

    public User() {
    }

    public User(UUID userId, String firstName, String lastname, Enum.GENDER gender, Enum.ADDRESS_TYPE addressType,
            String address, Enum.COUNTRY country, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.addressType = addressType;
        this.address = address;
        this.country = country;
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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
                "userId='" + userId + '\'' +
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((addressType == null) ? 0 : addressType.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (gender != other.gender)
            return false;
        if (addressType != other.addressType)
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (country != other.country)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
