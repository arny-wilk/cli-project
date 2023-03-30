package cars;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import enums.Enum;
import registertocsvfile.ConvertToStringArray;
import registertocsvfile.RegisterDataToCSVFile;

public class CarArrayDataAccessService implements CarDAO, ConvertToStringArray {

    private static final int SIZE = 10;
    private static Car[] cars = new Car[SIZE];
    private int nextSlot = 1;

    // save Data to CSV File
    RegisterDataToCSVFile saveToCSVFile = new RegisterDataToCSVFile("out/data/cars.csv");

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

    @Override
    public List<String[]> convert() {
        List<String[]> result = new ArrayList<>();
        String[] header = { "CarId", "Model", "Color", "Category", "Type", "Price", "Registration Number" };
        String[] emptyArray = { "", "", "", "", "", "", "" };
        result.add(header);
        List<Car> carList = Arrays.asList(cars);
        for (Car car : carList) {
            Optional<Car> optionalCar = Optional.ofNullable(car);
            if (optionalCar.isPresent()) {
                String[] stringify = { optionalCar.get().getCarId().toString()
                                                , optionalCar.get().getBrand()
                                                , optionalCar.get().getColor().toString()
                                                , optionalCar.get().getVehiculeCategory().toString()
                                                , optionalCar.get().getVehiculeType().toString()
                                                , optionalCar.get().getPrice().toString()
                                                , optionalCar.get().getRegNumber() };
                result.add(stringify);
            } else {
                result.add(emptyArray);
            }
        }
        return result;
    }

    public String registerCarsToCSVFile() {
        List<String[]> stringArray = convert();
        saveToCSVFile.writeToCsvFile(stringArray);
        return "You successfully registered " + stringArray.size() + " cars";
    }
}
