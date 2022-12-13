package cars;

import enums.Enum;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO {
    private static final Car[] cars;
    private static int nextAvailableSlot = 1;

    static {
        int arraySize = 10;
        cars = new Car[arraySize];
        cars[0] = new Car(UUID.fromString("83f7ed51-760c-4645-9aff-274b19cc3f24")
                        , "Audi"
                        , Enum.COLOR.RED
                        , Enum.VEHICULE_CATEGORY.HATCHBACK
                        , Enum.VEHICULE_TYPE.THERMIC
                        , Enum.ENGINE_TYPE.VTEN
                        , new BigDecimal("45888")
                        , "GB21 SMT");
        cars[1] = new Car(UUID.fromString("91d7ee3a-3fc1-48a7-b26d-b98f3c9c4998")
                        , "BMW"
                        , Enum.COLOR.GREY
                        , Enum.VEHICULE_CATEGORY.SEDAN
                        , Enum.VEHICULE_TYPE.ELECTRIC
                        , new BigDecimal("68900")
                        , "GB44 SSP");
    }

    public static Car[] getCars() {
        return cars;
    }

    public void addCar(Car newCar){
        for (int i = 1; i < cars.length; i++) {
            if(CarService.regNumberValidator(newCar)){
                cars[nextAvailableSlot++] = newCar;
            }
        }
    }

}
