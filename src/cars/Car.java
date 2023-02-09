package cars;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import enums.Enum.COLOR;
import enums.Enum.ENGINE_TYPE;
import enums.Enum.VEHICULE_TYPE;

import static enums.Enum.COLOR;
import static enums.Enum.VEHICULE_CATEGORY;
import static enums.Enum.VEHICULE_TYPE;
import static enums.Enum.ENGINE_TYPE;

public class Car {
    private UUID carId;
    private String brand;
    private COLOR color;
    private VEHICULE_CATEGORY vehiculeCategory;
    private VEHICULE_TYPE vehiculeType;
    private ENGINE_TYPE engineType;
    private BigDecimal price;
    private String regNumber;

    public Car() {
    }
    
    public Car(UUID carId, String brand, COLOR color, VEHICULE_TYPE vehiculeType, ENGINE_TYPE engineType,
    String regNumber) {
        this.carId = carId;
        this.brand = brand;
        this.color = color;
        this.vehiculeType = vehiculeType;
        this.engineType = engineType;
        this.regNumber = regNumber;
    }
    
    public Car(UUID carId, String brand, COLOR color, VEHICULE_CATEGORY vehiculeCategory, VEHICULE_TYPE vehiculeType, BigDecimal price, String regNumber) {
        this.carId = carId;
        this.brand = brand;
        this.color = color;
        this.vehiculeCategory = vehiculeCategory;
        this.vehiculeType = vehiculeType;
        this.price = price;
        this.regNumber = regNumber;
    }

    public UUID getCarId(UUID carId) {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public VEHICULE_CATEGORY getVehiculeCategory() {
        return vehiculeCategory;
    }

    public void setVehiculeCategory(VEHICULE_CATEGORY vehiculeCategory) {
        this.vehiculeCategory = vehiculeCategory;
    }

    public VEHICULE_TYPE getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(VEHICULE_TYPE vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    public ENGINE_TYPE getEngineType() {
        return engineType;
    }

    public void setEngineType(ENGINE_TYPE engineType) {
        this.engineType = engineType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", color=" + color +
                ", vehiculeCategory=" + vehiculeCategory +
                ", vehiculeType=" + vehiculeType +
                ", engineType=" + engineType +
                ", price=" + price +
                ", regNumber=" + regNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return regNumber == car.regNumber && Objects.equals(carId, car.carId) && Objects.equals(brand, car.brand) && color == car.color && vehiculeCategory == car.vehiculeCategory && vehiculeType == car.vehiculeType && engineType == car.engineType && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, brand, color, vehiculeCategory, vehiculeType, engineType, price, regNumber);
    }
}
