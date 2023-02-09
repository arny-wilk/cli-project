package cars;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import enums.Enum;

public class CarArrayDataAccessService implements CarDAO {

    private static final int SIZE = 10;
    private static  Car[] cars = new Car[SIZE];
    private int nextSlot = 1;

    static {
        cars[0] = new Car(UUID.fromString("83f7ed51-760c-4645-9aff-274b19cc3f24"), "Audi", Enum.COLOR.RED,
                Enum.VEHICULE_CATEGORY.HATCHBACK, Enum.VEHICULE_TYPE.THERMIC, new BigDecimal("45888"), "GB21 SMT");
        cars[1] = new Car(UUID.fromString("91d7ee3a-3fc1-48a7-b26d-b98f3c9c4998"), "BMW", Enum.COLOR.GREY,
                Enum.VEHICULE_CATEGORY.SEDAN, Enum.VEHICULE_TYPE.ELECTRIC, new BigDecimal("68900"), "GB44 SSP");
    }

    @Override
    public Car[] getCars() {
        return cars;
    }

    @Override
    public void addCar(Car newCar) {
        for (int i = 1; i < cars.length; i++) {
            if (CarService.regNumberValidator(newCar)) {
                cars[nextSlot++] = newCar;
            }
        }
    }

    @Override
    public Car updateCar(Car car) {
        return car;
    }

    @Override
    public void deleteCar(Car car) {
        int indexOfUser = Arrays.binarySearch(cars, car);
        cars[indexOfUser] = null;
    }
}
