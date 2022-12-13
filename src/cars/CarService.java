package cars;

import static enums.Enum.ISO_ALPHA2;
import static enums.Enum.VEHICULE_TYPE.ELECTRIC;

public class CarService {
    static boolean regNumberValidator(Car car) {
        String regNumber = car.getRegNumber();
        ISO_ALPHA2[] isoAlpha2 = ISO_ALPHA2.values();
        for (ISO_ALPHA2 countryCode : isoAlpha2) {
            if (!countryCode.isInRegNumber(regNumber)
                    && !regNumber.matches("^.{2}\\d{2}\\s.*$")) {
                return false;
            }
        }
        return true;
    }

}
