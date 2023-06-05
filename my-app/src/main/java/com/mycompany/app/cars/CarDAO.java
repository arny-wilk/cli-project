package cars;

public interface CarDAO {
    Car[] getCars();

    public abstract void addCar(Car car);

    public abstract Car updateCar(Car car);

    public abstract void deleteCar(Car car);
}
