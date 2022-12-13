package tests;

import enums.Enum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class CarServiceTest {

    @Test
    void regNumberValidator() {
        String regNumber = "GB66 DGH";
        Enum.ISO_ALPHA2[] isoAlpha2 = Enum.ISO_ALPHA2.values();
        for (Enum.ISO_ALPHA2 code : isoAlpha2) {
            if (!code.isInRegNumber(regNumber)
                    && !regNumber.matches("^.{2}\\d{2}\\s.*$")) {
                fail();
            }
        }
        assertTrue(true);
    }
}