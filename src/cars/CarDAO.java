package cars;

import enums.Enum;

import java.math.BigDecimal;
import java.util.UUID;

public class CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[]{
                new Car(UUID.fromString("83f7ed51-760c-4645-9aff-274b19cc3f24")
                        , "Audi"
                        , Enum.COLOR.RED
                        , Enum.VEHICULE_CATEGORY.HATCHBACK
                        , Enum.VEHICULE_TYPE.THERMIC
                        , Enum.ENGINE_TYPE.VTEN
                        , new BigDecimal("45888")
                        , 554448),
                new Car(UUID.fromString("91d7ee3a-3fc1-48a7-b26d-b98f3c9c4998")
                        , "BMW"
                        , Enum.COLOR.GREY
                        , Enum.VEHICULE_CATEGORY.SEDAN
                        , Enum.VEHICULE_TYPE.ELECTRIC
                        , new BigDecimal("68900")
                        , 6677666)
        };
    }

    public static Car[] getCars() {
        return cars;
    }

}
